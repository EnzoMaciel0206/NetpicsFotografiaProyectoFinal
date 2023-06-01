/*
Descripción: Modelo de la ventana EventoSesion
Fecha: 12-agosto-2022
Nombre: Halach Uinic Dominguez Sarabia
 */
package Modelo;

//import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Date;
import javax.swing.table.DefaultTableModel;

public class MVentanaEvenSes {
    
     private Conexion conexion = new Conexion();
     
     public boolean EvenSesEliminar (int id){
        try{
            //Para abrir la conexión a la base de datos
            Connection con = conexion.abrirConexion();            
            //Para generar la consulta
            Statement s = con.createStatement();            
            //Borra en la tabla EventoSesion            
            int registro = s.executeUpdate("delete from EventoSesion where IdEventoSesion = " + id + ";");         
            conexion.cerrarConexion(con);    
            return true;
        }catch(SQLException e){
            return false;
        }
     }




public boolean EvenSesAgregar(int IdCotizacion, String Fecha, String Hora, String Locacion, int NumHoras, int NumPersonas, int Estado,  String Fechaliquidacion, double Restanteliquidado, double Ganancia){ 
        try{
            //Para abrir una conexion a la BD
            Connection con = conexion.abrirConexion();            
            //Para ejecutar la instrucción
            Statement s = con.createStatement();
        String cadenaSQL =  "insert into EventoSesion (IdEventoSesion,IdCotizacion,Fecha,Hora,Lugar,NumHoras,NumPersonas,Estado,FechaLiquid,RestanteLiquid,Ganancia) values (0,'" + IdCotizacion + "','" + Fecha + "','" + Hora +"','" + Locacion +"','" + NumHoras +"','" + NumPersonas +"','" + Estado +"','" + Fechaliquidacion +"','" + Restanteliquidado +"','"+ Ganancia +"');";
            //Update en la tabla usuarios
            int registro = s.executeUpdate(cadenaSQL);           
            conexion.cerrarConexion(con);
            return true;
        }catch(SQLException e){
            System.out.println(e);
            return false;
        }
    }
    


public boolean EvenSesModificar (int IdEventoSesion,int IdCotizacion, String Fecha, String Hora, String Locacion, int NumHoras, int NumPersonas, int Estado,  String Fechaliquidacion, double Restanteliquidado, double Ganancia){
        try{
            //Para abrir una conexion a la BD
            Connection con = conexion.abrirConexion();            
            //Para ejecutar la consulta
            Statement s = con.createStatement();
            String cadenaSQL =  "update EventoSesion set IdCotizacion = '" + IdCotizacion + 
"', Fecha ='" + Fecha + "', Hora = '" + Hora + "', Lugar = '" + Locacion + "', NumHoras = '" + NumHoras + "', NumPersonas = '" + NumPersonas +
"', Estado = '" + Estado + "', FechaLiquid = '" + Fechaliquidacion + "', RestanteLiquid = '" + Restanteliquidado + "', Ganancia = '" + Ganancia + "' where IdEventoSesion = " + IdEventoSesion + ";";
            //Update en la tabla usuarios
            int registro = s.executeUpdate(cadenaSQL);
            conexion.cerrarConexion(con);
            return true;
        }catch(SQLException e){
            System.out.println(e);
            return false;
        }
    }  

public DefaultTableModel evensesconsultar(){
        try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            
            ResultSet rs = s.executeQuery("select * from EventoSesion;");  // Ejecuta la consulta
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

public DefaultTableModel evensesBuscar(int ideventosesion){
        try{
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            
            ResultSet rs = s.executeQuery("select * from EventoSesion where IdEventoSesion="+ideventosesion+";");  // Ejecuta la consulta
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