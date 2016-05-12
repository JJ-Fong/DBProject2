/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author mariobsdd
 */
import Logic.DBManager;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Control extends JFrame {

    // JPanel
    JPanel pnlButton = new JPanel();
    // Buttons
    JButton boton1 = new JButton("GRÁFICA - 1");
    JButton boton2 = new JButton("GRÁFICA - 2");
    JButton boton3 = new JButton("GRÁFICA - 3");
    String anio = "";
    JFreeChart Grafica;
    JFreeChart Grafica2;
    JFreeChart Grafica3;
    DBManager dbman = new DBManager();
    DefaultCategoryDataset Datos = new DefaultCategoryDataset();
    DefaultCategoryDataset Datos2 = new DefaultCategoryDataset();
    DefaultCategoryDataset Datos3 = new DefaultCategoryDataset();

    public Control() {
        // Info setbounds
        boton1.setBounds(60, 400, 220, 30);
        boton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton1ActionPerformed(evt);
            }
        });
        boton2.setBounds(60, 400, 220, 30);
        boton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton2ActionPerformed(evt);
            }
        });
        boton3.setBounds(60, 400, 220, 30);
        boton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton3ActionPerformed(evt);
            }
        });
        // JPanel bounds
        pnlButton.setBounds(800, 800, 200, 100);

        // Adding to JFrame
        pnlButton.add(boton1);
        pnlButton.add(boton2);
        pnlButton.add(boton3);
        add(pnlButton);

        // JFrame properties
        setSize(100, 150);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    private void boton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        ArrayList<String> y = graf1();
        Datos.addValue(Integer.parseInt(y.get(0)), "Año "+anio, "Enero");
        Datos.addValue(Integer.parseInt(y.get(1)), "Año "+anio, "Febrero");
        Datos.addValue(Integer.parseInt(y.get(2)), "Año "+anio, "Marzo");
        Datos.addValue(Integer.parseInt(y.get(3)), "Año "+anio, "Abril");
        Datos.addValue(Integer.parseInt(y.get(4)), "Año "+anio, "Mayo");
        Datos.addValue(Integer.parseInt(y.get(5)), "Año "+anio, "Junio");
        Datos.addValue(Integer.parseInt(y.get(6)), "Año "+anio, "Julio");
        Datos.addValue(Integer.parseInt(y.get(7)), "Año "+anio, "Agosto");
        Datos.addValue(Integer.parseInt(y.get(8)), "Año "+anio, "Septiembre");
        Datos.addValue(Integer.parseInt(y.get(9)), "Año "+anio, "Octubre");
        Datos.addValue(Integer.parseInt(y.get(10)), "Año "+anio, "Noviembre");
        Datos.addValue(Integer.parseInt(y.get(11)), "Año "+anio, "Diciembre");
        
        Grafica = ChartFactory.createBarChart3D("Meses con más clientes","Mes","Clientes",Datos,PlotOrientation.VERTICAL,true,true,false);
        
        ChartPanel Panel = new ChartPanel(Grafica);
        JFrame Ventana = new JFrame("Gráfica 1");
        Ventana.getContentPane().add(Panel);
        Ventana.pack();
        Ventana.setVisible(true);
        //Ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void boton3ActionPerformed(java.awt.event.ActionEvent evt) {
        JOptionPane.showMessageDialog(null, "Gráfica No. 3 - Venta de acuerdo a cada tipo de Cliente");
        ArrayList<String> tipUsers = new ArrayList();
        ArrayList<String> tipUsersDB = new ArrayList();
        ArrayList<String> ventas = new ArrayList();
        ArrayList dataType = dbman.executeQuery("select t.name from client c join venta v on (v.client_id = c.id) join type t on (t.id = c.type_id);");
        ArrayList dataTUser = dbman.executeQuery("select distinct t.name from client c join type t on (c.type_id = t.id);");
        ArrayList dataVenta = dbman.executeQuery("select v.total from client c join venta v on (v.client_id = c.id) join type t on (t.id = c.type_id);");
        
        for (int i = 0; i < dataType.size(); i++) {
            ArrayList temp = (ArrayList) dataType.get(i);
            tipUsers.add((String) temp.get(0));
        }
        for (int i = 0; i < dataTUser.size(); i++) {
            ArrayList temp = (ArrayList) dataTUser.get(i);
            tipUsersDB.add((String) temp.get(0));
        }
        for (int i = 0; i < dataVenta.size(); i++) {
            ArrayList temp = (ArrayList) dataVenta.get(i);
            ventas.add((String) temp.get(0));
        }
        System.out.println(tipUsers);
        System.out.println(tipUsersDB);
        System.out.println(ventas);
        ArrayList<String> y3 = new ArrayList();
        double parcial = 0;
        for (int i = 0; i < tipUsersDB.size(); i++) {
            for (int j = 0; j < tipUsers.size(); j++) {
                if (tipUsers.get(j).equals(tipUsersDB.get(i))) {
                    parcial = parcial+Double.parseDouble(ventas.get(j));
                }
            }
            y3.add(String.valueOf(parcial));
            parcial = 0;
        }
        System.out.println(y3);
        for (int i = 0; i < y3.size(); i++) {
            if (y3.size() == tipUsersDB.size()) {
                Datos3.addValue(Double.parseDouble(y3.get(i)),"Total de Ventas por cada Tipo de Clientes", tipUsersDB.get(i));
            }
        }
        Grafica3 = ChartFactory.createBarChart3D("Ventas por cada Tipo de Clientes","Tipo de Clientes","Ventas ($)",Datos3,PlotOrientation.VERTICAL,true,true,false);
        ChartPanel Panel = new ChartPanel(Grafica3);
        JFrame Ventana = new JFrame("Gráfica 3 - Ventas por cada Tipo de Clientes");
        Ventana.getContentPane().add(Panel);
        Ventana.pack();
        Ventana.setVisible(true);
    }

    public static void main(String[] args) {
        new Control();
    }
    public ArrayList<String> graf1(){
        JOptionPane.showMessageDialog(null, "Gráfica: Meses donde más personas se registran.");
        boolean error = true;
        while (error) { //validacion e ingreso del nombre del cliente
            String defecto = "2016";
            anio = JOptionPane.showInputDialog(null, "Ingrese el Año que le interese:",  defecto);
            if (anio != null && anio.length()>0) {
                error = false;
            }
        }
        ArrayList<String> numeros = new ArrayList();
        ArrayList IDcliente = dbman.executeQuery("select id from client order by id");
        for (int i = 0; i < IDcliente.size(); i++) {
            ArrayList cliente = (ArrayList) IDcliente.get(i);
            numeros.add((String) cliente.get(0));
        }
        ArrayList<String> meses = new ArrayList();
        for (int i = 0; i < numeros.size(); i++) {
            ArrayList data = dbman.executeQuery("select extract(month from (Select c.joined from  client c where c.id ="+ numeros.get(i) +"and ((select extract(year from (select joined from client where id = "+numeros.get(i)+")))="+anio+")));");
            ArrayList temp = (ArrayList) data.get(0);
            if (temp.get(0) != null) {
                meses.add((String) temp.get(0));
            }
        }
        //System.out.println(meses);
        ArrayList<String> x = new ArrayList();
        for (int i = 1; i <= 12; i++) {
            x.add(String.valueOf(i));
        }
//        System.out.println(x);
        ArrayList<String> y = new ArrayList();
        int contador = 0;
        for (int i = 0; i < x.size(); i++) {
            for (int j = 0; j < meses.size(); j++) {
                if (x.get(i).equals(meses.get(j))) {
                    contador = contador + 1;
                }
            }
            y.add(String.valueOf(contador));
            contador = 0;
        }
        return y;
        
    }
    
    public void boton2ActionPerformed(java.awt.event.ActionEvent evt){
        ArrayList<String> Paises = new ArrayList();
        ArrayList<String> PaisesDB = new ArrayList();
        JOptionPane.showMessageDialog(null, "Gráfica No. 2 - Países con más Clientes");
        ArrayList dataPais = dbman.executeQuery("select con.name from client c join country con on (c.country_id = con.id) join type t on (t.id = c.type_id);");
        ArrayList PaisTabla = dbman.executeQuery("select name from country order by id;");
        ArrayList dataUser = dbman.executeQuery("select t.name from client c join country con on (c.country_id = con.id) join type t on (t.id = c.type_id);");
        for (int i = 0; i < dataPais.size(); i++) {
            ArrayList temp = (ArrayList) dataPais.get(i);
            Paises.add((String) temp.get(0));
        }
        
        for (int i = 0; i < PaisTabla.size(); i++) {
            ArrayList temp = (ArrayList) PaisTabla.get(i);
            PaisesDB.add((String) temp.get(0));
        }

        ArrayList<String> y = new ArrayList();
        int cont = 0;
        for (int i = 0; i < PaisesDB.size(); i++) {
            for (int j = 0; j < Paises.size(); j++) {
                if (Paises.get(j).equals(PaisesDB.get(i))) {
                    cont = cont +1;
                }
            }
            y.add(String.valueOf(cont));
            cont = 0;
        }
        for (int i = 0; i < y.size(); i++) {
            if (y.size() == PaisesDB.size()) {
                Datos2.addValue(Integer.parseInt(y.get(i)),"Cantidad de Clientes", PaisesDB.get(i));
            }
        }
        Grafica2 = ChartFactory.createBarChart3D("Países con más clientes","Paises","Clientes",Datos2,PlotOrientation.VERTICAL,true,true,false);
        ChartPanel Panel = new ChartPanel(Grafica2);
        JFrame Ventana = new JFrame("Gráfica 2");
        Ventana.getContentPane().add(Panel);
        Ventana.pack();
        Ventana.setVisible(true);
    }
}
