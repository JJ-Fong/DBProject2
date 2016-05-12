/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbproject2;

import GUI.mainView;

/**
 *
 * @author Javier Fong
 */
public class DBProject2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String query = "SELECT * FROM principal";
        mainView mv = new mainView(query);
        mv.setTitle("CRM");
        mv.setVisible(true);
    }
    
}
