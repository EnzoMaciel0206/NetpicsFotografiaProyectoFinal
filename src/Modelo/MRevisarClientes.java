/*
Descripción: Clase para Revisar clientes
Fecha: 10-Agosto-2022
Nombre: Giancarlo Martin Ibarra
 */
package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

public class MRevisarClientes {
    // Atributo
    private Conexion conexion = new Conexion();
    
   //Insertar usuarios
        public boolean clientesInsertar(String nombre,String apellidoPat,String apellidoMat,int edad,String ciudad,String telefono,String correo){
        try{
            //Para abrir una conexion a la BD
            Connection con = conexion.abrirConexion();            
            //Para ejecutar la instrucción
            Statement s = con.createStatement();
        String cadenaSQL =  "insert into Clientes(Nombre,ApellidoPat,ApellidoMat,Edad,Ciudad,Tel,Correo) values ('" 
        + nombre + "','" + apellidoPat + "','" + apellidoMat +"','" + edad + "','" + ciudad + "','" + telefono + "','" + correo + "');"; 
            //Update en la tabla usuarios
            int registro = s.executeUpdate(cadenaSQL);           
            conexion.cerrarConexion(con);
            return true;
        }catch(SQLException e){
            return false;
        }
    } 
        
    //Consultar
      public DefaultTableModel clientesConsultar(){
        try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            
            ResultSet rs = s.executeQuery("select * from Clientes;");  // Ejecuta la consulta
            //DefaultTableModel dtm = new DefaultTableModel();
            DefaultTableModel dtm = new DefaultTableModel() {

                @Override
                public boolean isCellEditable(int row, int column) {
                   //all cells false
                   return false;
                }
            };
            
            ResultSetMetaData rsMd =  rs.getMetaData();
            int columnas = rsMd.getColumnCount(); // regresa el número de columnas
            // ciclo para las columnas
            for(int i=1; i <= columnas; i++){  // sirve para obtener los nombres de cada columna (encabezado)
                dtm.addColumn(rsMd.getColumnLabel(i));
            }
            
            // ciclo para las filas
            while(rs.next()){
                Object[] fila = new Object[columnas];
                for(int i=0; i< columnas; i++){
                    fila[i] = rs.getObject(i+1);
                }
                dtm.addRow(fila);
            }
                    
            return dtm;
        }catch(SQLException e){
            System.out.println(e);
            return null;
        }
    }
       public DefaultTableModel clientesBuscar(int id){
        try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            
            ResultSet rs = s.executeQuery("select * from Clientes where Id = "+ id + ";");  // Ejecuta la consulta
            DefaultTableModel dtm = new DefaultTableModel() {

                @Override
                public boolean isCellEditable(int row, int column) {
                   //all cells false
                   return false;
                }
            };
            
            ResultSetMetaData rsMd =  rs.getMetaData();
            int columnas = rsMd.getColumnCount(); // regresa el número de columnas
            // ciclo para las columnas
            for(int i=1; i <= columnas; i++){  // sirve para obtener los nombres de cada columna (encabezado)
                dtm.addColumn(rsMd.getColumnLabel(i));
            }
            
            // ciclo para las filas
            while(rs.next()){
                Object[] fila = new Object[columnas];
                for(int i=0; i< columnas; i++){
                    fila[i] = rs.getObject(i+1);
                }
                dtm.addRow(fila);
            }
                    
            return dtm;
        }catch(SQLException e){
            System.out.println(e);
            return null;
        }
    }
    
        //Modificar
        public boolean clientesActualizar(int id,String nombre,String apellidoPat,String apellidoMat,int edad,String ciudad,String telefono,String correo){
        try{
            //Para abrir una conexion a la BD
            Connection con = conexion.abrirConexion();            
            //Para ejecutar la consulta
            Statement s = con.createStatement();
            String cadenaSQL =  "update Clientes set Nombre = '" + nombre + "', ApellidoPat = '" + apellidoPat 
           + "', ApellidoMat = '" + apellidoMat + "', Edad = '" + edad + "',Ciudad = '" + ciudad + "',Tel = '" + telefono + "',  Correo='" + correo + "' where Id = " + id + ";";
            //Update en la tabla usuarios
            int registro = s.executeUpdate(cadenaSQL);
            conexion.cerrarConexion(con);
            return true;
        }catch(SQLException e){
            System.out.print(e);
            return false;
        }
    }
    
    //Eliminar Clientes
    public boolean clientesEliminar(int id){
        try{
            //Para abrir la conexión a la base de datos
            Connection con = conexion.abrirConexion();            
            //Para generar la consulta
            Statement s = con.createStatement();            
            //Borra en la tabla usuarios            
            int registro = s.executeUpdate("delete from Clientes where Id = " + id + ";");            
            conexion.cerrarConexion(con);    
            return true;
        }catch(SQLException e){
            return false;
        }
    }
    
}
