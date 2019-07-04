/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import clasDAO.UsuariosDAO;
import classVO.UsuariosVO;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luis
 */
public class crearusuario extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        
        /* request.getParameter()*/
        try (PrintWriter out = response.getWriter()) {
            try {
                ///out.println(request.getParameter("procesar"));
                String   accion=request.getParameter("procesar");
               UsuariosVO usuarios =new  UsuariosVO();
                switch(accion){
                case"0":
                  String resp = UsuariosDAO.cargardatos();
                out.println(resp);  
                    break;
                case"1": // insertar
                 String Nombres= request.getParameter("Nombres");
                 String Apellidos= request.getParameter("Apellidos");
                 String Edad =request.getParameter("Edad");
                 usuarios.setNombre(Nombres);  
                 usuarios.setApellido(Apellidos);
                 usuarios.setEdad(Edad);
                 
               String respuesta = UsuariosDAO.registrarUsuarios(usuarios);
        
                out.println(respuesta);
                break; 
               case"2":// eliminar 
                   
                String  iduser=  request.getParameter("idsusario");   
                int id = Integer.parseInt(iduser);	
                usuarios.setId_usuarios(id);
                String respuestadelete = UsuariosDAO.eliminarUsusarios(usuarios);
                out.println(respuestadelete);
                   break;
                
        //System.out.println(respinsert);
                 
                 //break; 
 
 
                
                }
               
            } catch (Exception ex) {
                out.println("eror"+ex);
                Logger.getLogger(crearusuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
   

}
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    

