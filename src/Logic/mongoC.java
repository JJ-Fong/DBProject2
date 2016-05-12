/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;



import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.bson.Document;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import twitter4j.Paging;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.UserMentionEntity;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author William
 */
public class mongoC {
    
    Gson gson = new Gson();
    MongoClient mc;
    MongoDatabase db;
    MongoCollection<org.bson.Document> coll;
    ConfigurationBuilder cb;
    TwitterFactory factory;
    Twitter twitter;
    public mongoC() {
        
    }
    
    public boolean conect(){
       try{
            cb= new ConfigurationBuilder();
            cb.setDebugEnabled(true)
                .setOAuthConsumerKey("JdGDNmMv8tAkKsETMCY7DZHKb")
                .setOAuthConsumerSecret("3FPCYWtVjbXcR1uJa2r26vvTBUWZaTL6Y7sMkGlnir1dZOcPSi")
                .setOAuthAccessToken("306043744-RpbVQtTG0cpZ3c2ItfN2QaruVEmliJ24B5NVnLjz")
                .setOAuthAccessTokenSecret("mOjCZi44GTWW7ELNaVRow4o9JBU3dqTZQCLPPGXNRg4bP");
            factory= new TwitterFactory(cb.build()); 
            twitter= factory.getInstance();
            mc = new MongoClient();
            db = mc.getDatabase("social_media");
            coll = db.getCollection("Usuarios");
            this.gson = new GsonBuilder().setPrettyPrinting().create();
            return true;
       
       }
       catch(Exception ex){
           return false;
       }

    }
    
    public boolean inicioSesion (){
         /*Entro a twitter con una cuenta de un suario x
       para esto necesite los permisos que esta abajo*/
       
        /*Permisos de la cuenta a la que ingreso*/
        
       
       /*Trata de hacer la conexion con twitter
       y toma los ultimos 20 twitts que aparecen en la 
       time line del usuario*/
       conect();
       try{
           
           twitter4j.User user = twitter.verifyCredentials();
           List<Status> statu = twitter.getHomeTimeline();
           for(Status sta: statu){
               System.out.println("Showing @" + sta.getUser().getScreenName()+"->"+sta.getText());
           }
           
           //usuario("sofimelgar_",cb,twitter);
           return true;
       } catch (TwitterException ex) {
            
            return false;
        }
      
      
    }
    
    public void IngresarUsuario(String name){
        
        String [] buscarUs = new String[1];
        buscarUs[0] = name; 
        try{
                ResponseList<twitter4j.User> use = twitter.lookupUsers(buscarUs);
                twitter4j.User u = use.get(0);
                System.out.println(u.getStatus());
                usuario nuevoS = new usuario();
                nuevoS.setId(Long.toString(u.getId()));
                nuevoS.setNombre(u.getName());
                nuevoS.setLocation(u.getLocation());
                nuevoS.setNumFol(u.getFollowersCount());
                nuevoS.setNumeroDeT(u.getStatusesCount());
                List<Status> twitts = twitter.getUserTimeline(u.getId(),new Paging(1,200));
                ArrayList<twitt> timeL = new ArrayList() ;
                for(Status s: twitts){
                    twitt tw = new twitt();
                    tw.setTexto(s.getText());
                    tw.setRetwett(s.getRetweetCount());
                    //tw.setFecha((java.util.Date) s.getCreatedAt());
                    tw.setFav(s.getFavoriteCount());
                    tw.setCreador(s.getUser().getScreenName());
                    UserMentionEntity[] userMentionEntities = s.getUserMentionEntities();
                    ArrayList<String> inter = new ArrayList();
                    for(UserMentionEntity uh: userMentionEntities){
                        inter.add(uh.getScreenName());
                    }
                    tw.setPersonas(inter);
                    timeL.add(tw);
                }
                nuevoS.setTimeline(timeL);
                final String fIns = gson.toJson(nuevoS);
                
                Document dt;
                dt = new Document("ScreenName",u.getScreenName());
                dt.append("todo", fIns);
                conect();
                coll.insertOne(dt);
               JOptionPane.showMessageDialog(null,"Usuario Ingresado");
        }
           
        catch(TwitterException ex){
             System.out.println("No se pudo conectar el usuario deseado");
        }
        
      
        
    }
    
    
    /*Mas interacciones con usuarios*/
    public void masInter(String usuario){
        HashMap<String,String> conteo = new HashMap();
        Document soloN = this.coll.find(eq("ScreenName",usuario)).first();
        usuario regreso = this.gson.fromJson(soloN.getString("todo"), usuario.class);
        for(twitt t: regreso.getTimeline()){
            Date d = t.getFecha();
            System.out.println(d.getDay());
            for(String men: t.getPersonas()){
                if(conteo.containsKey(men)){
                    int cl= Integer.valueOf(conteo.get(men));
                    cl++;
                    conteo.put(men,String.valueOf(cl));
                    
                }
                else{
                    conteo.put(men,"1");
                }
            }
        }
        JFreeChart Grafica;
        DefaultCategoryDataset Datos = new DefaultCategoryDataset();
        
        for(Map.Entry<String,String>entry:conteo.entrySet()){
            String key = entry.getKey().toString();
            Integer value = Integer.valueOf(entry.getValue());
            Datos.addValue(value,usuario , key);
            System.out.println("KEY " + key + " vaue " + value );
        }
        

        Grafica = ChartFactory.createBarChart("Interacciones con usuarios",
        "Usuarios", "Numero de interacciones", Datos,
        PlotOrientation.VERTICAL, true, true, false); 
        
        ChartPanel Panel = new ChartPanel(Grafica);
        JFrame Ventana = new JFrame("JFreeChart");
        Ventana.getContentPane().add(Panel);
        Ventana.pack();
        Ventana.setVisible(true);
        Ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    public void diasTweet(String usuario){
        HashMap<String,String> conteo = new HashMap();
        conteo.put("Lunes","0");
        conteo.put("Martes","0");
        conteo.put("Miercoles","0");
        conteo.put("Jueves","0");
        conteo.put("Viernes","0");
        conteo.put("Sabado","0");
        conteo.put("Domingo","0");
        Document soloN = this.coll.find(eq("ScreenName",usuario)).first();
        usuario regreso = this.gson.fromJson(soloN.getString("todo"), usuario.class);
        for(twitt t: regreso.getTimeline()){
            Date d = t.getFecha();
            int dia = d.getDay();
            if(dia==1){
                int cl= Integer.valueOf(conteo.get("Lunes"));
                    cl++;
                conteo.put("Lunes",String.valueOf(cl));
            }
            if(dia==2){
                int cl= Integer.valueOf(conteo.get("Martes"));
                    cl++;
                conteo.put("Martes",String.valueOf(cl));
            }
            if(dia==3){
                int cl= Integer.valueOf(conteo.get("Miercoles"));
                    cl++;
                conteo.put("Miercoles",String.valueOf(cl));
            }
            if(dia==4){
                int cl= Integer.valueOf(conteo.get("Jueves"));
                    cl++;
                conteo.put("Jueves",String.valueOf(cl));
            }
            if(dia==5){
                int cl= Integer.valueOf(conteo.get("Viernes"));
                    cl++;
                conteo.put("Viernes",String.valueOf(cl));
            }
            if(dia==6){
                int cl= Integer.valueOf(conteo.get("Sabado"));
                    cl++;
                conteo.put("Sabado",String.valueOf(cl));
            }
            if(dia==7){
                int cl= Integer.valueOf(conteo.get("Domingo"));
                    cl++;
                conteo.put("Domingo",String.valueOf(cl));
            }
            
        }
        JFreeChart Grafica;
        DefaultCategoryDataset Datos = new DefaultCategoryDataset();
        
        for(Map.Entry<String,String>entry:conteo.entrySet()){
            String key = entry.getKey().toString();
            Integer value = Integer.valueOf(entry.getValue());
            Datos.addValue(value,usuario , key);
            System.out.println("KEY " + key + " vaue " + value );
        }
        

        Grafica = ChartFactory.createBarChart("Tweets por dia",
        "Dias", "Numero de Tweets", Datos,
        PlotOrientation.VERTICAL, true, true, false); 
        
        ChartPanel Panel = new ChartPanel(Grafica);
        JFrame Ventana = new JFrame("JFreeChart");
        Ventana.getContentPane().add(Panel);
        Ventana.pack();
        Ventana.setVisible(true);
        Ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
    }
    
    public String obtnerTwe(String usuario){
        HashMap<String,String> conteo = new HashMap();
        Document soloN = this.coll.find(eq("ScreenName",usuario)).first();
        usuario regreso = this.gson.fromJson(soloN.getString("todo"), usuario.class);
        String allTwe = "";
        for(twitt t: regreso.getTimeline()){
            Date d = t.getFecha();
            
            allTwe = allTwe + t.getTexto() + "\n"+"\n";
        }
        System.out.println(allTwe);
        return allTwe;
    }
    
    public ArrayList obtenerTweetConP(String name, String palabra){
        HashMap<String,String> conteo = new HashMap();
        ArrayList <String> toTwe = new ArrayList();
        ArrayList <String> encontrados = new ArrayList();
        Document soloN = this.coll.find(eq("ScreenName",name)).first();
        usuario regreso = this.gson.fromJson(soloN.getString("todo"), usuario.class);
        String allTwe = "";
        for(twitt t: regreso.getTimeline()){
            Date d = t.getFecha();
            toTwe.add(t.getTexto());
        }
        for(String g: toTwe){
            if(g.contains(palabra)){
                encontrados.add(g);
            }
        }
        
        return encontrados;
    }
    
}
