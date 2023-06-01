/*
Descripción: Clase para el controlador de la ventana VentanaCotizaciones
Fecha: 04-agosto-2022
Nombre: Enzo Alejandro Maciel Núñez
 */
package Controlador;

import Modelo.MVentanaCotizaciones;
import Vista.Menu;
import Vista.VVentanaCotizaciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.BigDecimal;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.table.TableColumn;

public class CVentanaCotizaciones implements ActionListener, MouseListener{
    private MVentanaCotizaciones modelo;
    private VVentanaCotizaciones vista;
    
    public CVentanaCotizaciones(MVentanaCotizaciones modelo, VVentanaCotizaciones vista) {
        this.modelo = modelo;
        this.vista = vista;
        //this.vista.btnAgregarCot.addActionListener(this);
        this.vista.btnEliminarCot.addActionListener(this);
        this.vista.btnModificarCot.addActionListener(this);
        this.vista.btnBuscarCot.addActionListener(this);
        this.vista.btnAgregarCot.addActionListener(this);
        this.vista.btnCotizarCot.addActionListener(this);
        this.vista.btnRegresarCot.addActionListener(this);
        this.vista.TabDatosCot.addMouseListener(this);
        
    }
    
    // Clase interna para crear hilos
    public class HiloBuscar implements Runnable{

        @Override
        public void run() {
            if(Thread.currentThread().getName().equals("Buscar")){
                try {
                    vista.TabDatosCot.setModel(modelo.CotizacionesBuscar(Integer.parseInt(vista.tfBuscarCot.getText())));
                    Thread.sleep(5000);
                    vista.TabDatosCot.setModel(modelo.CotizacionesMostrar()); 
                } catch (InterruptedException ex) {
                    System.out.println("Ocurrió un error");
                }
            }
        vista.btnBuscarCot.setEnabled(true);
        }
    
    }
    
    public void iniciarVista() {
        vista.setTitle("Ventana de Cotizaciones");
        vista.pack();
        vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vista.setLocationRelativeTo(null);
        vista.TabDatosCot.setModel(modelo.CotizacionesMostrar());
        //ocultarContraseñaEnTabla();
        vista.setVisible(true);
    }
    
    public void limpiarCajasTexto(){
        vista.tfCotizarCot.setText("");
        vista.tfBuscarCot.setText("");
        vista.tfEliminarCot.setText("");
        vista.tfModificarCot.setText("");
        vista.tfIDSCot.setText("");
        vista.tfEOSCot.setText("");
        vista.tfTipoCot.setText("");
        vista.tfAnticipoCot.setText("");
        vista.tfEACot.setText("");
        vista.tfAnticipoPromCot.setText("");
        vista.tfTPCot.setText("");
        vista.tfIDSCot2.setText("");
        vista.tfEOSCot2.setText("");
        vista.tfTipoCot2.setText("");
        vista.tfAnticipoCot2.setText("");
         vista.tfAnticipoPromCot2.setText("");
        vista.tfEACot2.setText("");
        vista.tfTPCot2.setText("");
        vista.calLimiteCot.setDate(null);
        vista.calLimiteCot2.setDate(null);
    }
    
    public void actionPerformed(ActionEvent evento) {
        if(vista.btnEliminarCot == evento.getSource()){
            if(modelo.CotizacionesEliminar(Integer.parseInt(vista.tfEliminarCot.getText()))){
                JOptionPane.showMessageDialog(null, "Registro eliminado exitosamente");
                this.vista.TabDatosCot.setModel(modelo.CotizacionesMostrar());
                //ocultarContraseñaEnTabla();
                limpiarCajasTexto();
            }else{
                JOptionPane.showMessageDialog(null, "No se pudo eliminar");
            }
       }else if(vista.btnModificarCot == evento.getSource()){
            Date date =  vista.calLimiteCot.getDate();
            long d2 = date.getTime();
            java.sql.Date fecha2 = new java.sql.Date(d2);
            String FechaMod2 = fecha2.toString();
            if(modelo.CotizacionesModificar(
                    Integer.parseInt(vista.tfModificarCot.getText()),
                    Integer.parseInt(vista.tfIDSCot2.getText()),Integer.parseInt(vista.tfEOSCot2.getText()),vista.tfTipoCot2.getText(),
                    Double.parseDouble(vista.tfAnticipoCot2.getText()),Integer.parseInt(vista.tfEACot2.getText()),Double.parseDouble(vista.tfAnticipoPromCot2.getText()),
                    Integer.parseInt(vista.tfTPCot2.getText()),FechaMod2)){
                JOptionPane.showMessageDialog(null, "Registro modificado exitosamente");
                this.vista.TabDatosCot.setModel(modelo.CotizacionesMostrar());
                limpiarCajasTexto();
            }else{
                JOptionPane.showMessageDialog(null, "No se pudo actualizar");
            }            
        }else if(vista.btnAgregarCot == evento.getSource()){
            Date date =  vista.calLimiteCot.getDate();
            long d = date.getTime();
            java.sql.Date fecha = new java.sql.Date(d);
            String FechaMod = fecha.toString();
            if(modelo.CotizacionesAgregar(
                    Integer.parseInt(vista.tfIDSCot.getText()),Integer.parseInt(vista.tfEOSCot.getText()),vista.tfTipoCot.getText(),
                    Double.parseDouble(vista.tfAnticipoCot.getText()),Integer.parseInt(vista.tfEACot.getText()),Double.parseDouble(vista.tfAnticipoPromCot.getText()),
                    Integer.parseInt(vista.tfTPCot.getText()),FechaMod)){
                JOptionPane.showMessageDialog(null, "Registro agregado exitosamente");
                this.vista.TabDatosCot.setModel(modelo.CotizacionesMostrar());
                limpiarCajasTexto();
            }else{
                JOptionPane.showMessageDialog(null, "No se pudo agregar");
            }            
        }else if(vista.btnBuscarCot == evento.getSource()){
            try{
                new Thread(new HiloBuscar(),"Buscar").start();
                vista.btnBuscarCot.setEnabled(false);
                //vista.TabDatosCot.setModel(modelo.CotizacionesBuscar(Integer.parseInt(vista.tfBuscarCot.getText())));
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "No se encontró ese registro");
            }
                
        } else if(vista.btnRegresarCot==evento.getSource()){
            Menu MEN = new Menu();
            CMenu controladorM = new CMenu(MEN);
            controladorM.iniciarVista();
            vista.dispose();
        }else if(vista.btnCotizarCot == evento.getSource()){
            if(modelo.CotizacionesCotizar(Integer.parseInt(vista.tfCotizarCot.getText()))){
                JOptionPane.showMessageDialog(null, "Precio generado en la cotizacion exitosamente.");
                this.vista.TabDatosCot.setModel(modelo.CotizacionesMostrar());
            }
        }
   }
    
    public void mouseClicked(MouseEvent e) {
        if(vista.TabDatosCot == e.getSource()){
            int  fila = vista.TabDatosCot.rowAtPoint(e.getPoint());
            if (fila > -1){
                vista.tfCotizarCot.setText(String.valueOf(vista.TabDatosCot.getValueAt(fila, 1))); 
                vista.tfEliminarCot.setText(String.valueOf(vista.TabDatosCot.getValueAt(fila, 0)));
                vista.tfModificarCot.setText(String.valueOf(vista.TabDatosCot.getValueAt(fila, 0)));
                vista.tfBuscarCot.setText(String.valueOf(vista.TabDatosCot.getValueAt(fila, 0)));
                vista.tfIDSCot2.setText(String.valueOf(vista.TabDatosCot.getValueAt(fila, 1)));
                vista.tfEOSCot2.setText(String.valueOf(vista.TabDatosCot.getValueAt(fila, 2)));
                vista.tfTipoCot2.setText(String.valueOf(vista.TabDatosCot.getValueAt(fila, 3)));
                vista.tfAnticipoCot2.setText(String.valueOf(vista.TabDatosCot.getValueAt(fila, 4)));
                vista.tfEACot2.setText(String.valueOf(vista.TabDatosCot.getValueAt(fila, 5)));
                vista.tfAnticipoPromCot2.setText(String.valueOf(vista.TabDatosCot.getValueAt(fila, 6)));
                vista.tfTPCot2.setText(String.valueOf(vista.TabDatosCot.getValueAt(fila, 7)));
                
                vista.tfIDSCot.setText(String.valueOf(vista.TabDatosCot.getValueAt(fila, 1)));
                vista.tfEOSCot.setText(String.valueOf(vista.TabDatosCot.getValueAt(fila, 2)));
                vista.tfTipoCot.setText(String.valueOf(vista.TabDatosCot.getValueAt(fila, 3)));
                vista.tfAnticipoCot.setText(String.valueOf(vista.TabDatosCot.getValueAt(fila, 4)));
                vista.tfEACot.setText(String.valueOf(vista.TabDatosCot.getValueAt(fila, 5)));
                vista.tfAnticipoPromCot.setText(String.valueOf(vista.TabDatosCot.getValueAt(fila, 6)));
                vista.tfTPCot.setText(String.valueOf(vista.TabDatosCot.getValueAt(fila, 7)));
                
                // Obtener fecha
                SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
                        Date fechatxt;
                        try {
                            fechatxt = formatoFecha.parse(String.valueOf(vista.TabDatosCot.getValueAt(fila, 8)));
                            vista.calLimiteCot.setDate(fechatxt);
                        } catch (Exception ex) {
                            System.out.println("Error en la fecha y el calendario");
                        }
                        
                // Obtener fecha
                SimpleDateFormat formatoFecha2 = new SimpleDateFormat("yyyy-MM-dd");
                        Date fechatxt2;
                        try {
                            fechatxt2 = formatoFecha.parse(String.valueOf(vista.TabDatosCot.getValueAt(fila, 8)));
                            vista.calLimiteCot2.setDate(fechatxt2);
                        } catch (Exception ex) {
                            System.out.println("Error en la fecha y el calendario");
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
