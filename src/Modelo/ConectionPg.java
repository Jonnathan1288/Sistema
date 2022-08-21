/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
//import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class ConectionPg {

    private Connection con;
    private 
//    String cadConexion = "jdbc:postgresql://ec2-52-3-2-245.compute-1.amazonaws.com:5432/dbss7qrorpvs3d";
//    String pgUser = "wckcaqfrzqgmwz";
//    String pgPaswd = "00317debbb5b708b6e0d370862739d620a8e215812be4aa55cdd9c902d4da281";

    String cadConexion = "jdbc:postgresql://localhost:5432/apersonam3a";
    String pgUser = "postgres"; 
    String pgPaswd = "jav123";
    public ConectionPg() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConectionPg.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con = DriverManager.getConnection(cadConexion, pgUser, pgPaswd);
            System.out.println("Conexion Ok");
        } catch (SQLException ex) {
            Logger.getLogger(ConectionPg.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet consulta(String sql) {
        try {
            Statement st = con.createStatement();
            return st.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConectionPg.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public boolean accion(String sql) {
        boolean correcto;
        try {
            System.out.println("");
            Statement st = con.createStatement();
            st.execute(sql);
            st.close();
            correcto = true;
        } catch (SQLException ex) {
            Logger.getLogger(ConectionPg.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            correcto = false;
        }
        return correcto;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
}
