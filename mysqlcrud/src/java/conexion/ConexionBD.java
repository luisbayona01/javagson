/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author igoodbad
 */
public class ConexionBD {
    Connection conectar = null;
    public ConexionBD(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conectar = DriverManager.getConnection("jdbc:mysql://localhost/prueba","root","");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public Connection getConnection(){
        return conectar;
    }
    public void desconectar(){
        conectar = null;
    }
}
