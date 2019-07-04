/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classVO;

/**
 *
 * @author luis
 */
public class UsuariosVO {
   
    
    private Integer  Id_usuarios;
    private String   Nombre; 
    private  String  Edad;  
    private  String  Apellido;
    private  String  Respuesta;
    
    
    public String getRespuesta() {
        return Respuesta;
    }

    public void setRespuesta(String Respuesta) {
        this.Respuesta = Respuesta;
    }
 
    
    
    public Integer getId_usuarios() {
        return Id_usuarios;
    }

    public void setId_usuarios(Integer Id_usuarios) {
        this.Id_usuarios = Id_usuarios;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getEdad() {
        return Edad;
    }

    public void setEdad(String Edad) {
        this.Edad = Edad;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }
    
    
    
   
}
