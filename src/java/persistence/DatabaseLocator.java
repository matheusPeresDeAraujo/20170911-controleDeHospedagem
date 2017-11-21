/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author matheus
 */
public class DatabaseLocator {
    
    private static DatabaseLocator instance = new DatabaseLocator();
    
    private DatabaseLocator(){}
    
    public static DatabaseLocator getInstance(){
        return instance;
    }
    
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/controleDeHospedagem","root","");
        
        return conn;
    }
    
}
