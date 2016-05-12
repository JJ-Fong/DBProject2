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
        String query = "SELECT client.id, first_name, last_name, email, g.name as gender, joined, birthday, c.name as country, points, t.name as type, phone, picture as picturesDir FROM client INNER JOIN country c ON client.country_id = c.id JOIN gender g ON client.gender_id = g.id JOIN type t ON client.type_id = t.id;";
        mainView mv = new mainView(query);
        mv.setTitle("CRM");
        mv.setVisible(true);
    }
    
}
