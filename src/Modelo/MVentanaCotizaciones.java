/*
Descripcion: Modelo de ventana VentanaCotizaciones
Nombre: Enzo Alejandro Maciel Núñez
Fecha: 03-agosto-2022
 */
package Modelo;

//import java.sql.*;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

public class MVentanaCotizaciones {
    
    // Atributo
    private Conexion conexion = new Conexion();
    
    public boolean CotizacionesModificar(int IdCotizacion, int IdSolicitud, int EventoOSesion,String Tipo, Double Anticipo, int EstadoAnticipo, Double AnticipoProm, int EstadoAnticipoProm, String FechaLimiteProm){
        try{
            //Para abrir una conexion a la BD
            Connection con = conexion.abrirConexion();            
            //Para ejecutar la consulta
            Statement s = con.createStatement();
            String cadenaSQL =  "update Cotizaciones set IdSolicitud = '" + IdSolicitud+ "', EvenOSes='" + EventoOSesion +"', Tipo='" + Tipo +
                    "', Anticipo='" + Anticipo +"', EstadoAnticipo='"+ EstadoAnticipo +"', AnticipoProm='"+ AnticipoProm +"', EstadoAnticipoProm='"
                    + EstadoAnticipoProm +"', FechaLimProm='" + FechaLimiteProm + "' where IdCotizacion = " + IdCotizacion + ";";
            //Update en la tabla usuarios
            int registro = s.executeUpdate(cadenaSQL);
            conexion.cerrarConexion(con);
            return true;
        }catch(SQLException e){
            System.out.println(e);
            return false;
        }
    }
    

    public boolean CotizacionesEliminar(int IdCotizacion){
        try{
            //Para abrir la conexión a la base de datos
            Connection con = conexion.abrirConexion();            
            //Para generar la consulta
            Statement s = con.createStatement();            
            //Borra en la tabla Cotizaciones            
            int registro = s.executeUpdate("delete from Cotizaciones where IdCotizacion = " + IdCotizacion + ";");            
            conexion.cerrarConexion(con);    
            return true;
        }catch(SQLException e){
            return false;
        }
    }
    
    public boolean CotizacionesCotizar(int IdSolicitud){
        try{
            //Para abrir una conexion a la BD
            Connection con = conexion.abrirConexion();
            //Para ejecutar la instrucción
            Statement s = con.createStatement();
            String cadenaSQL =  "call `sp_asignar_anticipos`("+IdSolicitud+");";
            //Update en la tabla usuarios
            int registro = s.executeUpdate(cadenaSQL);           
            conexion.cerrarConexion(con);
            return true;
        }catch(SQLException e){
            System.out.println(e);
            return false;
        }
    }
    
    public boolean CotizacionesAgregar(int IdSolicitud, int EventoOSesion,String Tipo, Double Anticipo, int EstadoAnticipo, Double AnticipoProm, int EstadoAnticipoProm, String FechaLimiteProm){
        try{
            //Para abrir una conexion a la BD
            Connection con = conexion.abrirConexion();            
            //Para ejecutar la consulta
            Statement s = con.createStatement();
            String cadenaSQL =  "insert into Cotizaciones (IdCotizacion, IdSolicitud, EvenOSes, Tipo, Anticipo, EstadoAnticipo, AnticipoProm,"
                    + " EstadoAnticipoProm, FechaLimProm) values ('0','" + IdSolicitud+ "','" + EventoOSesion +"','" + Tipo +
                    "','" + Anticipo +"','"+ EstadoAnticipo +"','"+ AnticipoProm +"','"+ EstadoAnticipoProm +"','" + FechaLimiteProm 
                    + "');";
            //Update en la tabla usuarios
            int registro = s.executeUpdate(cadenaSQL);
            conexion.cerrarConexion(con);
            return true;
        }catch(SQLException e){
            System.out.println(e);
            return false;
        }
    }
    
    public DefaultTableModel CotizacionesMostrar(){
        try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            
            ResultSet rs = s.executeQuery("select * from Cotizaciones;");  // Ejecuta la consulta
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
            return null;
        }
    }
    
    
    public DefaultTableModel CotizacionesBuscar(int IdCotizacion){
        try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            
            ResultSet rs = s.executeQuery("select * from Cotizaciones where IdCotizacion ="+IdCotizacion+";");  // Ejecuta la consulta
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
            return null;
        }
    }
    
}
