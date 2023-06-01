    /*
Descripción: Clase para la conexión con la BD de la aplicación
Fecha: 03-agosto-2022
Nombre: Enzo Alejandro Maciel Núñez
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
    public Connection abrirConexion() throws SQLException{
        Connection con;
        //Para conectarnos a nuestra base de datos
        try{
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/netpicsFotografia2","root",""); // Se establece la conexión
        }catch(SQLException e){
            System.out.println("NO se pudo abrir conexión");            
            con = null;
        }            
        return con;
    }
    
    public void cerrarConexion(Connection c) throws SQLException{        
        try{
            if(!c.isClosed()){
                c.close();
            }
        }catch(SQLException e){
            System.out.println("Error al cerrar la conexión");
        }        
    }
    
    
}










//con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto","angelica", "123456");