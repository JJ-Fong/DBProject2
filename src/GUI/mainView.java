/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Logic.DBManager;
import Logic.dateManager;
import java.io.File;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Javier Fong
 */
public class mainView extends javax.swing.JFrame {

    /**
     * Creates new form mainView
     */
    DBManager dbman; 
    String queryActual; 
    ArrayList data, title; 
    
    public mainView(){}
    
    public mainView(String query) {
        initComponents();
        dbman = new DBManager();
        queryActual = query;
        this.prepTable(query); 
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setRollover(true);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/FinalAdd.png"))); // NOI18N
        jButton1.setText("Nuevo");
        jButton1.setBorderPainted(false);
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/FinalDelete.png"))); // NOI18N
        jButton2.setText("Eliminar");
        jButton2.setBorderPainted(false);
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/FinalEdit.png"))); // NOI18N
        jButton3.setText("Modificar");
        jButton3.setBorderPainted(false);
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/FinalSettings.png"))); // NOI18N
        jButton6.setText("Filtrar");
        jButton6.setBorderPainted(false);
        jButton6.setFocusable(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton6);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/FinalTweet.png"))); // NOI18N
        jButton5.setText("Social Net.");
        jButton5.setBorderPainted(false);
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton5);

        jMenu1.setText("Menu");

        jMenu3.setText("Configuracion");

        jMenuItem2.setText("Agregar Campo");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenu1.add(jMenu3);

        jMenuItem1.setText("Ayuda");
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Reportes");

        jMenu4.setText("Reportes Detalle");

        jMenuItem3.setText("jMenuItem3");
        jMenu4.add(jMenuItem3);

        jMenuItem4.setText("jMenuItem4");
        jMenu4.add(jMenuItem4);

        jMenuItem5.setText("jMenuItem5");
        jMenu4.add(jMenuItem5);

        jMenuItem6.setText("jMenuItem6");
        jMenu4.add(jMenuItem6);

        jMenuItem7.setText("jMenuItem7");
        jMenu4.add(jMenuItem7);

        jMenu2.add(jMenu4);

        jMenu5.setText("Reportes Resumen");
        jMenu5.setToolTipText("");

        jMenuItem8.setText("jMenuItem8");
        jMenu5.add(jMenuItem8);

        jMenuItem9.setText("jMenuItem9");
        jMenu5.add(jMenuItem9);

        jMenuItem10.setText("jMenuItem10");
        jMenu5.add(jMenuItem10);

        jMenuItem11.setText("jMenuItem11");
        jMenu5.add(jMenuItem11);

        jMenuItem12.setText("jMenuItem12");
        jMenu5.add(jMenuItem12);

        jMenu2.add(jMenu5);

        jMenu6.setText("Graficas");

        jMenuItem13.setText("jMenuItem13");
        jMenu6.add(jMenuItem13);

        jMenuItem14.setText("jMenuItem14");
        jMenu6.add(jMenuItem14);

        jMenuItem15.setText("jMenuItem15");
        jMenu6.add(jMenuItem15);

        jMenuItem16.setText("jMenuItem16");
        jMenu6.add(jMenuItem16);

        jMenuItem17.setText("jMenuItem17");
        jMenu6.add(jMenuItem17);

        jMenu2.add(jMenu6);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 1335, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(562, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        Filtros fil = new Filtros(queryActual); 
        fil.setVisible(true);
        this.dispose(); 
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        boolean error = true;
        String fName = "";
        String LName = "";
        String email = "";
        String joined = "";
        String birthday = "";
        double points = 0.0;
        int phone = 0;
        String gName = "";
        String pic = "";
        String country = "";
        String type = ""; //Premium, Gold, Regular
        String username = "";
        
        ArrayList IDcliente = dbman.executeQuery("select * from client order by id");
        ArrayList IDcountry = dbman.executeQuery("select * from country order by id");
        ArrayList IDgender = dbman.executeQuery("select * from gender order by id");
        ArrayList IDtwitter = dbman.executeQuery("select * from twitter order by id");
        ArrayList IDtype = dbman.executeQuery("select * from type order by id");
        
        ArrayList cliente = (ArrayList) IDcliente.get(IDcliente.size()-1);
        int idC =Integer.parseInt((String) cliente.get(0))+1;   
        int idcont=0; //id Country
        int idg=0; //id Gender
        int idt=0; //id type
        while (error) { //validacion e ingreso del nombre del cliente
            fName = JOptionPane.showInputDialog(null, "Ingrese el Nombre del Cliente:",  "First_Name (text)", JOptionPane.WARNING_MESSAGE);
            if (fName != null && fName.length()>0) {
                error = false;
            }
        }
        while (!error){//validacion e ingreso del apellido del cliente
            LName = JOptionPane.showInputDialog(null, "Ingrese el Apellido del Cliente:",  "Last_Name (text)", JOptionPane.WARNING_MESSAGE);
            if (LName != null && LName.length()>0) {
                error = true;
            }
        }
        while (error){  //validacion e ingreso del email del cliente
            email = JOptionPane.showInputDialog(null, "Ingrese el E-Mail del Cliente","e-mail (text)",JOptionPane.WARNING_MESSAGE);
            if (email != null && email.length()>0){
                if (email.contains("@") && email.contains(".com")){
                    String[] parts = email.split("@");
                    String part2 = parts[1];
                    if (part2.length()>6) {
                        error = false;
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "ERROR! El e-mail debe contener un nombre@ejemplo.com correctamente");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "ERROR! El e-mail debe contener un @ejemplo.com");
                }
            }
        }
        while (!error){//validacion e ingreso de fecha de join del cliente
            joined = JOptionPane.showInputDialog(null, "Ingrese la fecha en que se unió el cliente:",  "joined_date ('YYYY-MM-DD')", JOptionPane.WARNING_MESSAGE);
            if (joined != null && joined.length()>0){
                dateManager dm = new dateManager();
                error = dm.checkSintax(joined);
                if (!error)
                    JOptionPane.showMessageDialog(null, "ERROR! Fecha Join Incorrecta");
                //error = true;
            }
        }
        while (error){//validacion del cumpleanios del cliente
            birthday = JOptionPane.showInputDialog(null, "Ingrese la fecha de Cumpleaños/Nacimiento del Cliente:", "birthday ('YYYY-MM-DD')", JOptionPane.WARNING_MESSAGE);
            if (birthday != null && birthday.length()>0) {
                dateManager dm = new dateManager();
                boolean fl = true;
                fl = dm.checkSintax(birthday);
                if (fl) {
                    error = false;
                }
                if (error)
                    JOptionPane.showMessageDialog(null, "ERROR! Fecha Birthday Incorrecta");
            }
        }
        while (!error){//validacion de puntuacion
            try{
                points = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese la Puntuacion del Cliente:", "points (double)", JOptionPane.WARNING_MESSAGE));
                if (points >=0 && points<=10000) {
                    error = true;
                }
                else{
                    JOptionPane.showMessageDialog(null, "ERROR! El punteo del cliente debe de estar entre 0 y 10000");
                }
            }catch (Exception ee){
                JOptionPane.showMessageDialog(null, "ERROR! Debe de ingresar un numero.");
            }
        }
        while (error){ //validacion del numero de telefono
            String tel = JOptionPane.showInputDialog(null, "Ingrese el Número de Teléfono del Cliente:", "phone_number (int)", JOptionPane.WARNING_MESSAGE);
            if (tel !=null && tel.length()>0){
                if (tel.length()==8){
                    try{
                        phone = Integer.parseInt(tel);
                        if(phone>=20000000 && phone <= 79999999){
                            error = false;
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "ERROR! Debe ingresar un numero valido");
                        }
                    }
                    catch (Exception ee){
                        JOptionPane.showMessageDialog(null, "ERROR! Debe ingresar un numero");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "ERROR! Debe ingresar un numero de 8 digitos.");
                }
            }
        }
        while(!error){ //validacion del genero
            ArrayList tip = dbman.executeQuery("select name from gender;");
            ArrayList ids = dbman.executeQuery("select id from gender;");
            ArrayList<String> elem = new ArrayList();
            ArrayList<String> id = new ArrayList();
            for (int i = 0; i < tip.size(); i++) {
                ArrayList temp = (ArrayList) tip.get(i);
                ArrayList temp2 = (ArrayList) ids.get(i);
                elem.add((String) temp.get(0));
                id.add((String)temp2.get(0));
            }
            DefaultComboBoxModel model = new DefaultComboBoxModel(elem.toArray());
            JComboBox cb = new JComboBox();
            cb.setModel(model);
            JOptionPane.showMessageDialog(null, cb, "Ingrese el Genero del Cliente", JOptionPane.QUESTION_MESSAGE);
            gName = (String) cb.getSelectedItem();
            //System.out.println("genero "+ gName);
            for (int i = 0; i < ids.size(); i++) {
                if (id.size() == elem.size()){
                    if(gName.equals(elem.get(i))){
                        idg = Integer.parseInt(id.get(i));
                    }
                }
            }
            //System.out.println("idg: "+idg);
            error = true;
        }
        while (error){//validacion de pais
            ArrayList tip = dbman.executeQuery("select name from country;");
            ArrayList ids = dbman.executeQuery("select id from country;");
            ArrayList<String> elem = new ArrayList();
            ArrayList<String> id = new ArrayList();
            for (int i = 0; i < tip.size(); i++) {
                ArrayList temp = (ArrayList) tip.get(i);
                ArrayList temp2 = (ArrayList) ids.get(i);
                elem.add((String) temp.get(0));
                id.add((String)temp2.get(0));
            }
            DefaultComboBoxModel model = new DefaultComboBoxModel(elem.toArray());
            JComboBox cb = new JComboBox();
            cb.setModel(model);
            JOptionPane.showMessageDialog(null, cb, "Ingrese el Pais del Cliente", JOptionPane.QUESTION_MESSAGE);
            country = (String) cb.getSelectedItem();
            //System.out.println("country: "+ country);
            for (int i = 0; i < ids.size(); i++) {
                if (id.size() == elem.size()){
                    if(country.equals(elem.get(i))){
                        idcont = Integer.parseInt(id.get(i));
                    }
                }
            }
//            System.out.println("idcont: "+idcont);
            error = false;
        }
        while(!error){ //validacion del tipo
            ArrayList tip = dbman.executeQuery("select name from type;");
            ArrayList ids = dbman.executeQuery("select id from type;");
            ArrayList<String> elem = new ArrayList();
            ArrayList<String> id = new ArrayList();
            for (int i = 0; i < tip.size(); i++) {
                ArrayList temp = (ArrayList) tip.get(i);
                ArrayList temp2 = (ArrayList) ids.get(i);
                elem.add((String) temp.get(0));
                id.add((String)temp2.get(0));
            }
            DefaultComboBoxModel model = new DefaultComboBoxModel(elem.toArray());
            JComboBox cb = new JComboBox();
            cb.setModel(model);
            JOptionPane.showMessageDialog(null, cb, "Ingrese el Tipo del Cliente", JOptionPane.QUESTION_MESSAGE);
            type = (String) cb.getSelectedItem();
            //System.out.println("tipo"+ type);
            for (int i = 0; i < ids.size(); i++) {
                if (id.size() == elem.size()){
                    if(type.equals(elem.get(i))){
                        idt = Integer.parseInt(id.get(i));
                    }
                }
            }
            //System.out.println("idt: "+idt);
            error = true;
        }
        while(error){//validacion de la imagen del usuario
            try{
                JFileChooser chooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");
                chooser.setFileFilter(filter);
                int returnVal = chooser.showOpenDialog(null);
                chooser.setDialogTitle("Now Please Select the Client's Profile Picture");
                if(returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = chooser.getSelectedFile();
                    pic = file.getAbsolutePath();
                    //System.out.println("PATHH: "+pic);
                    JOptionPane.showMessageDialog(null, "You chose this profile picture: "+chooser.getSelectedFile());
                   if (!pic.contains(".jpg")){
                       JOptionPane.showMessageDialog(null, "ERROR! Debes de escoger una imagen .jpg");
                   }
                   else{
                       error = false;
                   }
                }
            }
            catch (Exception ee){
                JOptionPane.showMessageDialog(null,"Ha ocurrido un error con el ingreso de la imagen");
            }
        }
        while(!error){
            username = JOptionPane.showInputDialog(null, "username (text)", "Ingrese el usuario de Twitter del cliente:", JOptionPane.WARNING_MESSAGE);
            if (username != null && username.length()>0) {
                error = true;
            }
        }
        //INSERTO DATOS PARA EL NUEVO CLIENTE
        try{
            String queryClient = "INSERT INTO client VALUES (DEFAULT, '"+ fName + "', '"+LName+ "', '"+email+ "', "+idg+",'"+joined+ "', '"+birthday+ "', "+idcont+ ", "+points+", "+idt+ ", '"+phone+ "', '"+pic+"')";
            String queryTwitter = "INSERT INTO twitter VALUES ("+idC + ", '"+username+"')";
            if (!queryClient.isEmpty()){
                JOptionPane.showMessageDialog(null, "Cliente creado exitosamente");
                dbman.executeQuery(queryClient);
                dbman.executeQuery(queryTwitter);
            }
            else{
                JOptionPane.showMessageDialog(null, "Hubo un error con la creacion de un nuevo cliente.");
            }
        }catch (Exception ee){
            JOptionPane.showMessageDialog(null, "Hubo un error con la creacion de un nuevo cliente.");
        }
        prepTable(queryActual); 
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int row = jTable1.getSelectedRow(); 
        if (row > -1) { 
            ArrayList reg = (ArrayList) data.get(row); 
            String id = String.valueOf(reg.get(0)); 
            dbman.executeQuery("DELETE FROM client WHERE id = "+id+";");
            prepTable(queryActual); 
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int row = jTable1.getSelectedRow(); 
        if (row > -1) { 
            ArrayList reg = (ArrayList) data.get(row); 
            String id = String.valueOf(reg.get(0)); 
            //AQUI VA ACTUALIZAR - EN ID ESTA EL ID
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        String field = JOptionPane.showInputDialog(null, "Nombre del campo:");
        if (!field.equals("null")){
            String[] types = new String[] {"Entero","Real","Fecha","Texto"};
            
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed
    
    private void prepTable(String query) { 
        title = new ArrayList();
        data = new ArrayList(); 
        try { 
            ResultSet res = dbman.executeQueryV2(query); 
            ResultSetMetaData rsmd = res.getMetaData(); 
            
            int colcount = rsmd.getColumnCount(); 
            for (int i = 0; i < colcount; i++) {
                title.add(rsmd.getColumnName(i+1)); 
            } 
            
            int j = 0; 
            while (res.next()) { 
                ArrayList row = new ArrayList(); 
                for (int i = 0; i < rsmd.getColumnCount(); i++){
                    row.add(res.getString(i+1)); 
                }
                data.add(row); 
            }
            
            this.setTable();
        } catch(Exception e) { 
            JOptionPane.showMessageDialog(null,"Error, por favor vuelva a intentarlo"); 
        }
    }
    
    private void setTable() {
        Object[] titleArray = new Object[title.size()-1];
        for (int i = 1; i < title.size(); i++) { 
            titleArray[i-1] = title.get(i);
        }
        Object[][] dataArray = new Object[data.size()][title.size()-1]; 
        for (int i = 0; i < data.size(); i++) { 
            ArrayList row = (ArrayList) data.get(i); 
            for (int j = 1; j < row.size(); j++) {
                dataArray[i][j-1] = row.get(j);
            }
        }
        
        
        DefaultTableModel model = new DefaultTableModel(dataArray, titleArray); 
        jTable1.setModel(new DefaultTableModel(dataArray, titleArray){
            
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        });
    }
    
    /*
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(mainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainView().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
