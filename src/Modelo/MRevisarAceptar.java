/*
Descripción: Modelo Revisar Aceptar
Fecha: 11-Agosto-2022
Nombre: Juan Ramon Aramburo Osuna
 */
package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

public class MRevisarAceptar {
    
    private Conexion conexion = new Conexion();
    
    public boolean SolicitudesAgregar(String EvenOSes, String Fecha, String Hora, int NumHoras, int NumPersonas, String FechaSoli, int IdLugar, int IdCliente, String infoExtra, String infoLugar){
        try{
            //Para abrir una conexion a la BD
            Connection con = conexion.abrirConexion();
            //Para ejecutar la instrucción
            Statement s = con.createStatement();
            String cadenaSQL =  "insert into Solicitudes(IdSolicitud,EvenOSes,IdCliente,FechaSolicitud,NumPersonas,NumHoras,Fecha,Hora,IdLugar,InfoExtra,InfoLugar) values (0,'" 
            + EvenOSes + "','" + IdCliente + "','" + FechaSoli + "','" + NumPersonas + "','" + NumHoras + "','" + Fecha + "','" + Hora + "','" + IdLugar + "','" + infoExtra + "','" + infoLugar + "');";
            //Update en la tabla usuarios
            int registro = s.executeUpdate(cadenaSQL);           
            conexion.cerrarConexion(con);
            return true;
        }catch(SQLException e){
            System.out.println(e);
            return false;
        }
    }
    
    public boolean SolicitudesModificar(int IdSolicitud, String EvenOSes, String Fecha, String Hora, int NumHoras, int NumPersonas, String FechaSoli, int IdLugar, int IdCliente, String infoExtra, String infoLugar){
        try{
            //Para abrir una conexion a la BD
            Connection con = conexion.abrirConexion();            
            //Para ejecutar la consulta
            Statement s = con.createStatement();
            String cadenaSQL =  "update Solicitudes set EvenOSes='" + EvenOSes + "', Fecha='" + Fecha 
           + "', Hora='" + Hora + "', NumHoras = '" + NumHoras + "', NumPersonas = '" + NumPersonas 
           + "', FechaSolicitud='" + FechaSoli + "', IdLugar='" + IdLugar + "', IdCliente='" + IdCliente + "', InfoExtra='" + infoExtra + "', InfoLugar='" + infoLugar + "' where IdSolicitud=" + IdSolicitud + ";";
            //Update en la tabla usuarios
            int registro = s.executeUpdate(cadenaSQL);
            conexion.cerrarConexion(con);
            return true;
        }catch(SQLException e){
            System.out.println(e);
            return false;
        }
    }
    
    public boolean SolicitudesEliminar(int IdSolicitud){
        try{
            //Para abrir la conexión a la base de datos
            Connection con = conexion.abrirConexion();            
            //Para generar la consulta
            Statement s = con.createStatement();            
            //Borra en la tabla usuarios            
            int registro = s.executeUpdate("delete from Solicitudes where IdSolicitud = " + IdSolicitud + ";");            
            conexion.cerrarConexion(con);    
            return true;
        }catch(SQLException e){
            return false;
        }
    }
    
    public DefaultTableModel SolicitudesConsultar(){
        try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            
            ResultSet rs = s.executeQuery("select * from Solicitudes;");  // Ejecuta la consulta
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
    
    public DefaultTableModel LugaresConsultar(){
        try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            
            ResultSet rs = s.executeQuery("call `sp_consultar_lugares`;");  // Ejecuta la consulta 
            //DefaultTableModel atm = new DefaultTableModel();    
            DefaultTableModel atm = new DefaultTableModel() {

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
                atm.addColumn(rsMd.getColumnLabel(i));
            }
            
            // ciclo para las filas
            while(rs.next()){
                Object[] fila = new Object[columnas];
                for(int i=0; i< columnas; i++){
                    fila[i] = rs.getObject(i+1);
                }
                atm.addRow(fila);
            }
                    
            return atm;
        }catch(SQLException e){
            System.out.println(e);
            return null;
        }
    }

    public DefaultTableModel SolicitudesBuscar(int IdSolicitud){
        try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            
            ResultSet rs = s.executeQuery("select * from Solicitudes where IdSolicitud='"+IdSolicitud+"';");  // Ejecuta la consulta
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
    
}
