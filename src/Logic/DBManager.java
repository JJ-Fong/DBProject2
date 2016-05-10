/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Properties;

/**
 *
 * @author Javier Fong
 */
public class DBManager {
    Connection con; 
    Statement stm; 
    
    public DBManager() { 
        this.connect();//genera conexion 
    }
    
    /*
    METODO PARA CREAR CONEXION HACIA LA BASE DE DATOS
    HACE REFERENCIA AL ARCHIVO connectionSettings.properties DONDE SE ALMACENA LA INFORMACION REFERENTE A LA BASE DE DATOS
    */
    public void connect() { 
        try { 
            File file = new File("resources/connectionSettings.properties");
            FileInputStream fileInput = new FileInputStream(file);
            Properties properties = new Properties();
            properties.load(fileInput);
            fileInput.close();

            String server = properties.getProperty("server");
            String db = properties.getProperty("database");
            String user = properties.getProperty("user");
            String pw = properties.getProperty("password");
            Class.forName("org.postgresql.Driver"); 
            Connection con = DriverManager.getConnection("jdbc:postgresql://"+server+"/"+db,user,pw);
            if (con != null) {
                System.out.println("Connected");
            }
            
            stm = con.createStatement(); 
        } catch (Exception e) { 
            System.out.println("Unable to connect");
            e.printStackTrace();
        }
    }
    
    
    public Statement getStatement() {
        return stm;
    }
    
    /*
    REGRESA EL LISTADO DE COLUMNAS DE LA TABLA tableName
    */
    public ArrayList getColumns(String tableName){
        ArrayList columnNames = new ArrayList(); 
        if (stm != null) { 
            try { 
                ResultSet rs = stm.executeQuery("SELECT * FROM "+tableName);
                ResultSetMetaData rsmd = rs.getMetaData(); 
                int colcount = rsmd.getColumnCount(); 
                for (int i = 0; i < colcount; i++) {
                    columnNames.add(rsmd.getColumnName(i+1)); 
                }    
            } catch (Exception e) { 
                System.out.println("Query Failed. Columns unknown");
            }
        } else { 
            System.out.println("Connect to DB First");
        }
        return columnNames; 
    }
    
    /*
    EJECUTA EL QUERY INGRESADO COMO STRING, Y REGRESA EN UN ARRAYLIST LO QUE SEA QUE REQUIERA EL QUERY
    */
    public ArrayList executeQuery(String query) { 
        ArrayList result = new ArrayList(); 
        try { 
            ResultSet rs = stm.executeQuery(query); 
            ResultSetMetaData rsmd = rs.getMetaData();
            ArrayList row = new ArrayList(); 
            
            for (int i = 0; i < rsmd.getColumnCount(); i++){
                row.add(rs.getString(i+1)); 
            }
            result.add(row); 
        } catch (Exception e) { 
            result.add(e.getStackTrace().toString()); 
        }
        return result; 
    }
}
