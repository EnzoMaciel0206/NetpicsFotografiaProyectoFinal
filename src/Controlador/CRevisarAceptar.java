/*
Descripción: Controlador RevisarAceptar
Fecha: 11-Agosto-2022
Nombre: Juan Ramon Aramburo Osuna
 */

package Controlador;

import Modelo.MRevisarAceptar;
import Vista.Menu;
import Vista.RevisarAceptar;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CRevisarAceptar implements ActionListener, MouseListener{
    private MRevisarAceptar Modelo;
    private RevisarAceptar Vista;
    
    public CRevisarAceptar(MRevisarAceptar Modelo, RevisarAceptar Vista) {
        this.Modelo = Modelo;
        this.Vista = Vista;
        this.Vista.btnBuscar44.addActionListener(this);
        this.Vista.btnEliminar44.addActionListener(this);
        this.Vista.btnAgregar.addActionListener(this);
        this.Vista.btnModificar.addActionListener(this);
        this.Vista.btnRegresarRA.addActionListener(this);
        this.Vista.tbSolicitudes43.addMouseListener(this);
        
    }
    
    // Clase interna para crear hilos
    public class HiloBuscar implements Runnable{

        @Override
        public void run() {
            if(Thread.currentThread().getName().equals("Buscar")){
                try {
                    Vista.tbSolicitudes43.setModel(Modelo.SolicitudesBuscar(Integer.parseInt(Vista.tfBuscar44.getText())));
                    Thread.sleep(5000);
                    Vista.tbSolicitudes43.setModel(Modelo.SolicitudesConsultar()); 
                } catch (InterruptedException ex) {
                    System.out.println("Ocurrió un error");
                }
            }
        Vista.btnBuscar44.setEnabled(true);
        }
    
    }
    
    public void iniciarVista() {
        Vista.setTitle("Ventana de Solicitudes");
        Vista.pack();
        Vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Vista.setLocationRelativeTo(null);
        Vista.tbSolicitudes43.setModel(Modelo.SolicitudesConsultar());
        Vista.tbLugares.setModel(Modelo.LugaresConsultar());
        Vista.setVisible(true);
        Calendar hora= new GregorianCalendar();
        Vista.calFechaSolicitud45.setCalendar(hora);
        Vista.calFechaSolicitud46.setCalendar(hora);
    }
    
    public void limpiarCajasTexto(){
        
        Vista.tfBuscar44.setText("");
        Vista.tfEliminar44.setText("");
        Vista.tfEOS45.setText("");
        Vista.tfNumHoras45.setText("");
        Vista.tfNumPersonas45.setText("");
        Vista.tfIDLugar45.setText("");
        Vista.tfIDCliente45.setText("");
        Vista.tfInfoLugar45.setText("");
        Vista.tfInfoLugar45.setText("");
        Vista.tfIDES46.setText("");
        Vista.tfEOS46.setText("");
        Vista.tfNumHoras46.setText("");
        Vista.tfNumPersonas46.setText("");
        Vista.tfIDLugar46.setText("");
        Vista.tfIDCliente46.setText("");
        Vista.tfIExtra46.setText("");
        Vista.tfInfoLugar46.setText("");
        Vista.tfIExtra45.setText("");
        Vista.calFecha45.setDate(null);
        Vista.calFecha46.setDate(null);
        Vista.calFechaSolicitud45.setDate(null);
        Vista.calFechaSolicitud46.setDate(null);
        Vista.calHora.setDate(null);
        Vista.calHora2.setDate(null);
    }
    
    public void actionPerformed(ActionEvent evento) {
//            Date hora = Vista.calHora.getDate();
//            long h1 = hora.getTime();
//            java.sql.Date hora1 = new java.sql.Date(h1);
//            String Hora1 = hora1.toString();
//            
//            Date hora2 = Vista.calHora2.getDate();
//            long h2 = hora2.getTime();
//            java.sql.Date hora22 = new java.sql.Date(h2);
//            String Hora2 = hora22.toString();
            
            //Vista.calHora.getDate().toInstant().atZone(ZoneId.systemDefault());      
            
            //Date hor = Vista.calHora.getDate();
            //String strDate = DateFormat.getDateInstance().format(hor);
            
            //String hor777  = ((JTextField)Vista.calHora.getDateEditor().getUiComponent()).getText();
            

        if(Vista.btnAgregar == evento.getSource()) {
            //Vista.calHora.getDate();
            Date date = (Date) Vista.calFecha45.getDate();
            long d2 = date.getTime();
            java.sql.Date fecha2 = new java.sql.Date(d2);
            String FechaMod2 = fecha2.toString();
            
            Date date3 = (Date) Vista.calFechaSolicitud45.getDate();
            long d3 = date3.getTime();
            java.sql.Date fecha3 = new java.sql.Date(d3);
            String FechaMod3 = fecha3.toString();
            

            String hor777  = ((JTextField)Vista.calHora.getDateEditor().getUiComponent()).getText();
            
            if(Modelo.SolicitudesAgregar(
                    Vista.tfEOS45.getText(),FechaMod2,hor777,
                    Integer.parseInt(Vista.tfNumHoras45.getText()),Integer.parseInt(Vista.tfNumPersonas45.getText()),FechaMod3,
                    Integer.parseInt(Vista.tfIDLugar45.getText()),Integer.parseInt(Vista.tfIDCliente45.getText()),Vista.tfIExtra45.getText(),Vista.tfInfoLugar45.getText())){
                JOptionPane.showMessageDialog(null, "Registro Agregado exitosamente");
                this.Vista.tbSolicitudes43.setModel(Modelo.SolicitudesConsultar());
                limpiarCajasTexto();
            }else{
                JOptionPane.showMessageDialog(null, "No se pudo insertar");
            }
        }else if(Vista.btnEliminar44 == evento.getSource()){
            if(Modelo.SolicitudesEliminar(Integer.parseInt(Vista.tfEliminar44.getText()))){
                JOptionPane.showMessageDialog(null, "Registro eliminado exitosamente");
                this.Vista.tbSolicitudes43.setModel(Modelo.SolicitudesConsultar());
                limpiarCajasTexto();
            }else{
                JOptionPane.showMessageDialog(null, "No se pudo eliminar");
            }
        }else if(Vista.btnModificar == evento.getSource()){
            Date date = (Date) Vista.calFecha46.getDate();
            long d1 = date.getTime();
            java.sql.Date fecha3 = new java.sql.Date(d1);
            String FechaMod3 = fecha3.toString();
            
            Date date4 = (Date) Vista.calFechaSolicitud46.getDate();
            long d4 = date4.getTime();
            java.sql.Date fecha4 = new java.sql.Date(d4);
            String FechaMod4 = fecha4.toString();
            
            String hor777  = ((JTextField)Vista.calHora2.getDateEditor().getUiComponent()).getText();
            
            if(Modelo.SolicitudesModificar(
                    Integer.parseInt(Vista.tfIDES46.getText()),Vista.tfEOS46.getText(),FechaMod3,hor777,
                    Integer.parseInt(Vista.tfNumHoras46.getText()),Integer.parseInt(Vista.tfNumPersonas46.getText()),FechaMod4,
                    Integer.parseInt(Vista.tfIDLugar46.getText()),Integer.parseInt(Vista.tfIDCliente46.getText()),Vista.tfIExtra46.getText(),Vista.tfInfoLugar46.getText())){
                JOptionPane.showMessageDialog(null, "Registro modificado exitosamente");
                this.Vista.tbSolicitudes43.setModel(Modelo.SolicitudesConsultar());                        
                limpiarCajasTexto();
            }else{
                JOptionPane.showMessageDialog(null, "No se pudo actualizar");
            }
        } else if(Vista.btnBuscar44 == evento.getSource()){
            try{
                new Thread(new HiloBuscar(),"Buscar").start();
                Vista.btnBuscar44.setEnabled(false);
                //Vista.tbSolicitudes43.setModel(Modelo.SolicitudesBuscar(Integer.parseInt(Vista.tfBuscar44.getText())));
            }catch(Exception e){
                System.out.println(e);
                JOptionPane.showMessageDialog(null, "No se encontró ese registro");
            }
        } else if(Vista.btnRegresarRA==evento.getSource()){
            Menu MEN = new Menu();
            CMenu controladorM = new CMenu(MEN);
            controladorM.iniciarVista();
            Vista.dispose();
        }
    }
    
    public void mouseClicked(MouseEvent e) {
        if(Vista.tbSolicitudes43 == e.getSource()){
            int  fila = Vista.tbSolicitudes43.rowAtPoint(e.getPoint());
            if (fila > -1){
                Vista.tfBuscar44.setText(String.valueOf(Vista.tbSolicitudes43.getValueAt(fila, 0)));
                Vista.tfEliminar44.setText(String.valueOf(Vista.tbSolicitudes43.getValueAt(fila, 0)));
                
                
                Vista.tfEOS45.setText(String.valueOf(Vista.tbSolicitudes43.getValueAt(fila, 1)));
                Vista.tfIDCliente45.setText(String.valueOf(Vista.tbSolicitudes43.getValueAt(fila, 2)));
                Vista.tfNumHoras45.setText(String.valueOf(Vista.tbSolicitudes43.getValueAt(fila, 5)));
                Vista.tfNumPersonas45.setText(String.valueOf(Vista.tbSolicitudes43.getValueAt(fila, 4))); 
                
                Vista.tfIDLugar45.setText(String.valueOf(Vista.tbSolicitudes43.getValueAt(fila, 8)));
                Vista.tfIExtra45.setText(String.valueOf(Vista.tbSolicitudes43.getValueAt(fila, 9)));
                Vista.tfInfoLugar45.setText(String.valueOf(Vista.tbSolicitudes43.getValueAt(fila, 10)));
                
                // Obtener fecha
                SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
                Date fechatxt1;
                try {
                    fechatxt1 = formatoFecha.parse(String.valueOf(Vista.tbSolicitudes43.getValueAt(fila, 6)));
                    Vista.calFecha45.setDate(fechatxt1);
                } catch (Exception ex) {
                    System.out.println("Error en la fecha y el calendario");
                }

                try {
                    fechatxt1 = formatoFecha.parse(String.valueOf(Vista.tbSolicitudes43.getValueAt(fila, 6)));
                    Vista.calFecha46.setDate(fechatxt1);
                } catch (Exception ex) {
                    System.out.println("Error en la fecha y el calendario");
                }
                        
//                // Obtener hora
//                SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm::ss");
//                Date horatxt1;
//                try {
//                    horatxt1 = formatoHora.parse(String.valueOf(Vista.tbSolicitudes42.getValueAt(fila, 7)));
//                    Vista.calHora.setDate(horatxt1);
//                } catch (Exception ex) {
//                    System.out.println("Error en la fecha y el calendario");
//                }

                Vista.tfIDES46.setText(String.valueOf(Vista.tbSolicitudes43.getValueAt(fila, 0)));
                Vista.tfEOS46.setText(String.valueOf(Vista.tbSolicitudes43.getValueAt(fila, 1)));
                Vista.tfIDCliente46.setText(String.valueOf(Vista.tbSolicitudes43.getValueAt(fila, 2)));
                Vista.tfNumHoras46.setText(String.valueOf(Vista.tbSolicitudes43.getValueAt(fila, 5)));
                Vista.tfNumPersonas46.setText(String.valueOf(Vista.tbSolicitudes43.getValueAt(fila, 4))); 
                
                Vista.tfIDLugar46.setText(String.valueOf(Vista.tbSolicitudes43.getValueAt(fila, 8)));
                Vista.tfIExtra46.setText(String.valueOf(Vista.tbSolicitudes43.getValueAt(fila, 9)));
                Vista.tfInfoLugar46.setText(String.valueOf(Vista.tbSolicitudes43.getValueAt(fila, 10)));
                
                // Obtener fecha
                        Date fechatxt2;
                        try {
                            fechatxt2 = formatoFecha.parse(String.valueOf(Vista.tbSolicitudes43.getValueAt(fila, 3)));
                            Vista.calFechaSolicitud45.setDate(fechatxt2);
                        } catch (Exception ex) {
                            System.out.println("Error en la fecha y el calendario");
                        }
                        
                        Date fechatxt3;
                        try {
                            fechatxt2 = formatoFecha.parse(String.valueOf(Vista.tbSolicitudes43.getValueAt(fila, 3)));
                            Vista.calFechaSolicitud46.setDate(fechatxt2);
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
