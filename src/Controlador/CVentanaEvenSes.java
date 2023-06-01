/*
Descripción: Controlador de ventana EventoSesion
Fecha: 11-Agosto-2022
Nombre: Halach Uinic Dominguez Sarabia
 */
package Controlador;

import Modelo.MVentanaEvenSes;
import Vista.Menu;
import Vista.VentanaEvenSes;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.DefaultCellEditor;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.table.TableColumn;

public class CVentanaEvenSes implements ActionListener, MouseListener{
    private MVentanaEvenSes modelo;
    private VentanaEvenSes vista;
    
    public CVentanaEvenSes(MVentanaEvenSes modelo, VentanaEvenSes vista) {
        this.modelo = modelo;
        this.vista = vista;
        this.vista.btnAgregarES.addActionListener(this);
        this.vista.btnEliminarES.addActionListener(this);
        this.vista.btnModificarES.addActionListener(this);
        this.vista.btnRegresarES.addActionListener(this);
        this.vista.tabDatosES.addMouseListener(this);
        this.vista.btnBuscarES.addActionListener(this);
    }
    
    public void iniciarVista() {
        vista.setTitle("Ventana EvenSes");
        vista.pack();
        vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vista.setLocationRelativeTo(null);
        vista.tabDatosES.setModel(modelo.evensesconsultar());
        vista.setVisible(true);
    }
    
    // Clase interna para crear hilos
    public class HiloBuscar implements Runnable{

        @Override
        public void run() {
            if(Thread.currentThread().getName().equals("Buscar")){
                try {
                    vista.tabDatosES.setModel(modelo.evensesBuscar(Integer.parseInt(vista.tfBuscarES.getText())));
                    Thread.sleep(5000);
                    vista.tabDatosES.setModel(modelo.evensesconsultar()); 
                } catch (InterruptedException ex) {
                    System.out.println("Ocurrió un error");
                }
            }
        vista.btnBuscarES.setEnabled(true);
        }
    
    }
    
    public void limpiarCajasTexto(){
        vista.tfAIdcotES.setText("");
        vista.AFechaES.setDate(null);
       
        vista.tfALocacionES.setText("");
        vista.calHORA.setCalendar(null);
        vista.tfALocacionES.setText("");
        vista.tfANhorasES.setText("");
        vista.tfANumPersonasES.setText("");
        vista.tfAEstadoES.setText("");
        vista.AFechaliqES.setDate(null);
        vista.tfARliquidadoES.setText("");
        vista.tfAGananciaES.setText("");
        
        vista.tfMIdcotES.setText("");
        vista.MfechaCalES.setDate(null);
        
        vista.tfMLocacionES.setText("");
        vista.tfMHorasES.setText("");
        vista.tfMNumPersonasES.setText("");
        vista.tfMEstadoES.setText("");
        vista.MfechaliqES.setDate(null);
        vista.tfMRliquidadoES.setText("");
        vista.tfMGananciaES.setText("");
        
    }
    
    
            
    
    public void actionPerformed(ActionEvent evento) {  
        if(vista.btnAgregarES == evento.getSource()) {
            Date date =  vista.AFechaES.getDate();
            long d2 = date.getTime();
            java.sql.Date fecha2 = new java.sql.Date(d2);
            String FechaAES = fecha2.toString();
            Date date3 =  vista.AFechaliqES.getDate();
            long d3 = date.getTime();
            java.sql.Date fecha3 = new java.sql.Date(d3);
            String FechaliqAES = fecha3.toString();
            String hora1  = ((JTextField)vista.calHORA.getDateEditor().getUiComponent()).getText();
            
            //boton agregar 
            if(modelo.EvenSesAgregar(
                    Integer.parseInt(vista.tfAIdcotES.getText()), 
                    FechaAES,
                    hora1,
                    vista.tfALocacionES.getText(),
                    Integer.parseInt(vista.tfANhorasES.getText()),
                    Integer.parseInt(vista.tfANumPersonasES.getText()),
                    Integer.parseInt(vista.tfAEstadoES.getText()),
                    FechaliqAES,
                    Double.parseDouble(vista.tfARliquidadoES.getText()),
                    Double.parseDouble(vista.tfAGananciaES.getText()))){
                //vista.txtNombre.getText() cambiar
                //Integer.parseInt(vista.txtNombre.getText())
                //Double.parseDouble(vista);
                JOptionPane.showMessageDialog(null, "Registro insertado exitosamente");
                this.vista.tabDatosES.setModel(modelo.evensesconsultar());
                //ocultarContraseñaEnTabla();
                limpiarCajasTexto();
            }else{
                
                JOptionPane.showMessageDialog(null, "No se pudo insertar");
            }
            
            //boton eliminar
        }else if(vista.btnEliminarES == evento.getSource()){
            if(modelo.EvenSesEliminar(
                    Integer.parseInt(vista.tfEliminarES.getText()))){
                JOptionPane.showMessageDialog(null, "Registro eliminado exitosamente");
                this.vista.tabDatosES.setModel(modelo.evensesconsultar());
                //ocultarContraseñaEnTabla();
                limpiarCajasTexto();
            }else{
                JOptionPane.showMessageDialog(null, "No se pudo eliminar");
            }
            
            
            //boton modificar
        }else if(vista.btnModificarES == evento.getSource()){
            Date date =  vista.MfechaCalES.getDate();
            long d4 = date.getTime();
            java.sql.Date fecha4 = new java.sql.Date(d4);
            String FechaAES2 = fecha4.toString();
            Date date5 =  vista.MfechaliqES.getDate();
            long d5 = date.getTime();
            java.sql.Date fecha5 = new java.sql.Date(d5);
            String FechaliqAES2 = fecha5.toString();
            String hora2  = ((JTextField)vista.calHORA2.getDateEditor().getUiComponent()).getText();
            
            if(modelo.EvenSesModificar(
                    Integer.parseInt(vista.tfModificarES.getText()),
                    Integer.parseInt(vista.tfMIdcotES.getText()), 
                    FechaAES2,
                    hora2,
                    vista.tfMLocacionES.getText(),
                    Integer.parseInt(vista.tfMHorasES.getText()),
                    Integer.parseInt(vista.tfMNumPersonasES.getText()),
                    Integer.parseInt(vista.tfMEstadoES.getText()),
                    FechaliqAES2,
                    Double.parseDouble(vista.tfMRliquidadoES.getText()),
                    Double.parseDouble(vista.tfMGananciaES.getText()))){
                JOptionPane.showMessageDialog(null, "Registro modificado exitosamente");
                this.vista.tabDatosES.setModel(modelo.evensesconsultar());               
                //ocultarContraseñaEnTabla();                            
                limpiarCajasTexto();
            }else{
                JOptionPane.showMessageDialog(null, "No se pudo actualizar");
            }            
        }else if(vista.btnBuscarES == evento.getSource()){
            try{
                new Thread(new HiloBuscar(),"Buscar").start();
                vista.btnBuscarES.setEnabled(false);
                //vista.tabDatosES.setModel(modelo.evensesBuscar(Integer.parseInt(vista.tfBuscarES.getText())));
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "No se encontró ese registro");
            }
            
        } else if(vista.btnRegresarES==evento.getSource()){
            Menu MEN = new Menu();
            CMenu controladorM = new CMenu(MEN);
            controladorM.iniciarVista();
            vista.dispose();
        }
        
    }
    
    
    /*private void ocultarContraseñaEnTabla(){
        // Código para ocultar la contraseña en la tabla
        TableColumn tc=this.vista.tbUsuarios.getColumnModel().getColumn(2);//Paso 1
        tc.setCellEditor(new DefaultCellEditor(new JPasswordField()));//Paso 2
        ClaveRender cr=new ClaveRender();
        tc.setCellRenderer(cr);//paso 3
    }
    */
    
    public void mouseClicked(MouseEvent e) {
        if(vista.tabDatosES == e.getSource()){
            
            int  fila = vista.tabDatosES.rowAtPoint(e.getPoint());
            if (fila > -1){
                vista.tfBuscarES.setText(String.valueOf(vista.tabDatosES.getValueAt(fila, 0)));
                vista.tfEliminarES.setText(String.valueOf(vista.tabDatosES.getValueAt(fila, 0)));
                vista.tfModificarES.setText(String.valueOf(vista.tabDatosES.getValueAt(fila, 0)));
                
                vista.tfAIdcotES.setText(String.valueOf(vista.tabDatosES.getValueAt(fila, 1)));
                //vista.tfAHoraES.setText(String.valueOf(vista.tabDatosES.getValueAt(fila, 3)));
                vista.tfALocacionES.setText(String.valueOf(vista.tabDatosES.getValueAt(fila, 9)));
                vista.tfANhorasES.setText(String.valueOf(vista.tabDatosES.getValueAt(fila, 5)));
                vista.tfANumPersonasES.setText(String.valueOf(vista.tabDatosES.getValueAt(fila, 6)));
                vista.tfAEstadoES.setText(String.valueOf(vista.tabDatosES.getValueAt(fila, 2)));
                vista.tfARliquidadoES.setText(String.valueOf(vista.tabDatosES.getValueAt(fila, 3)));
                vista.tfAGananciaES.setText(String.valueOf(vista.tabDatosES.getValueAt(fila,10)));
                
                
                vista.tfMIdcotES.setText(String.valueOf(vista.tabDatosES.getValueAt(fila, 1)));
                
                vista.tfMLocacionES.setText(String.valueOf(vista.tabDatosES.getValueAt(fila, 9)));
                vista.tfMHorasES.setText(String.valueOf(vista.tabDatosES.getValueAt(fila, 5)));
                vista.tfMNumPersonasES.setText(String.valueOf(vista.tabDatosES.getValueAt(fila, 6)));
                vista.tfMEstadoES.setText(String.valueOf(vista.tabDatosES.getValueAt(fila, 2)));
                vista.tfMRliquidadoES.setText(String.valueOf(vista.tabDatosES.getValueAt(fila, 3)));   
                vista.tfMGananciaES.setText(String.valueOf(vista.tabDatosES.getValueAt(fila, 10)));
                
                
                
                
                SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
                        Date fechatxt;
                        Date fechatxt2;
                        Date fechatxt3;
                        Date fechatxt4;
                        try{
                            fechatxt = (Date) formatoFecha.parse(String.valueOf(vista.tabDatosES.getValueAt(fila, 7)));
                            vista.AFechaES.setDate(fechatxt);
                        } catch (Exception ex){
                            System.out.println("Error en la fehca y el calendario");
                        }
                        try{
                            fechatxt = (Date) formatoFecha.parse(String.valueOf(vista.tabDatosES.getValueAt(fila, 7)));
                            vista.MfechaCalES.setDate(fechatxt);
                        } catch (Exception ex){
                            System.out.println("Error en la fehca y el calendario");
                        }
                        try{
                            fechatxt3 = (Date) formatoFecha.parse(String.valueOf(vista.tabDatosES.getValueAt(fila, 4)));
                            vista.AFechaliqES.setDate(fechatxt3);
                        } catch (Exception ex){
                            System.out.println("Error en la fehca y el calendario");
                        }
                        try{
                            fechatxt4 = (Date) formatoFecha.parse(String.valueOf(vista.tabDatosES.getValueAt(fila, 4)));
                            vista.MfechaliqES.setDate(fechatxt4);
                        } catch (Exception ex){
                            System.out.println("Error en la fehca y el calendario");
                        }
             }
        }
    }

    
    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
}