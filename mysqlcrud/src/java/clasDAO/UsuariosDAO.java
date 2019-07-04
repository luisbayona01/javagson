/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasDAO;

import classVO.UsuariosVO;
import conexion.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuariosDAO {
 
   public  static String registrarUsuarios(UsuariosVO usuariosVO){
      
        String result = null, last = null;
        ConexionBD cc = new ConexionBD();
        Connection cn = cc.getConnection();
        PreparedStatement pst= null;
         String sql="INSERT INTO usuarios(nombre,apellido,edad) VALUES (?,?,?)" ; 
     try {
            if (cn != null) {
                pst = cn.prepareStatement(sql);
                pst.setString(1,usuariosVO.getNombre());
                pst.setString(2,usuariosVO.getApellido());
                pst.setString(3,usuariosVO.getEdad());
               int res= pst.executeUpdate();
               if(res>0){
               
                   result="usuarios  registradocorrectamente";
               }else{
                    result="fallo"; 
                   
               }
                
               //System.out.print(result);
               
            }
        } catch (SQLException e) {
            System.out.print("error"+sql+e.getMessage() );
            result = "Error durante el registro: " + e.getMessage();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                    pst.close();
                }
            } catch (Exception e) {
                result = "Error " + e;
            }
        }
        return result;
   } 
    
   
  
  public   static   String  eliminarUsusarios(UsuariosVO usuariosVO){
    ConexionBD cc = new ConexionBD();
           Connection cn = cc.getConnection();
           String  result=null;
           PreparedStatement pst= null;
           String sql="delete from usuarios where id = ?";
       try {
           if (cn != null) {
           pst = cn.prepareStatement(sql);
           pst.setInt(1,usuariosVO.getId_usuarios());
           pst.execute();
          result="eliminado con exito";
           
         }  
       } catch (SQLException ex) {
           //Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
      result="error "+ex;
       }finally {
            try {
                if (cn != null) {
                    cn.close();
                    pst.close();
                }
            } catch (Exception e) {
                result = "Error " + e;
            }
        }
        return result;
      
  } 
   
   
   
    public  static  String  cargardatos(){
  ConexionBD cc = new ConexionBD();
  Connection cn = cc.getConnection();
  PreparedStatement pst= null;
 String datos=""; 
         
   try {
            if (cn != null) {
               
                pst = cn.prepareStatement("SELECT *  FROM usuarios");
                ResultSet rs = pst.executeQuery();
            
              com.google.gson.JsonObject gson=new JsonObject(); 
              JsonArray array=new JsonArray();  
              
                while (rs.next()) {
  JsonObject item = new JsonObject();
  
  item.addProperty("idusuario",rs.getInt("id"));
  item.addProperty("nombre",rs.getString("nombre"));
  item.addProperty("edad",rs.getString("edad"));
  item.addProperty("apellido",rs.getString("apellido"));
  
  
//Object[] fila = new Object[4];     
          
              ////fila[0]=;
              //fila[1]=rs.getString("nombre");
              //fila[2]=
              //fila[3]=rs.getString("apellido");
          
            array.add(item);           
               
                }
             gson.add("datos",array);  
            datos=gson.toString();
              System.out.print(datos);
            }
        } catch (SQLException e) {
            //result = "Error durante el registro: " + e.getMessage();
              System.out.print(e);
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                    pst.close();
                }
            } catch (Exception e) {
               System.out.print(e);
//result = "Error " + e;
            }
        }
        return datos;
   }        

   
 
         
         
         
 }  
   

