/*
Descripción: Clase para el controlador de la ventana RevisarClientes
Fecha: 10-agosto-2022
Nombre: Giancarlo Martin Ibarra
 */
package Controlador;

import Modelo.MRevisarClientes;
import Vista.Menu;
import Vista.RevisarClientes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.DefaultCellEditor;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.table.TableColumn;

public class CRevisarClientes implements ActionListener, MouseListener {
    private MRevisarClientes modelo;
    private RevisarClientes vista;

    public CRevisarClientes(MRevisarClientes modelo, RevisarClientes vista){
    this.modelo = modelo;
    this.vista = vista;
    this.vista.btnBuscarCLI.addActionListener(this);
    this.vista.btnEliminarCLI.addActionListener(this);
    this.vista.btnModificarCLI.addActionListener(this);
    this.vista.btnAgregarCLI.addActionListener(this);
    this.vista.btnRegresarCLI.addActionListener(this);
    this.vista.tabClientesCLI.addMouseListener(this);
    
}
    
    // Clase interna para crear hilos
    public class HiloBuscar implements Runnable{

        @Override
        public void run() {
            if(Thread.currentThread().getName().equals("Buscar")){
                try {
                    vista.tabClientesCLI.setModel(modelo.clientesBuscar(Integer.parseInt(vista.tfBuscarCLI.getText())));
                    Thread.sleep(5000);
                    vista.tabClientesCLI.setModel(modelo.clientesConsultar()); 
                } catch (InterruptedException ex) {
                    System.out.println("Ocurrió un error");
                }
            }
        vista.btnBuscarCLI.setEnabled(true);
        }
    
    }
    
    public void iniciarVista() {
        vista.setTitle("Ventana de Clientes");
        vista.pack();
        vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vista.setLocationRelativeTo(null);
            //tabClientesCLI                 ClientesConsultar -> 
        vista.tabClientesCLI.setModel(modelo.clientesConsultar());
        //ocultarContraseñaEnTabla();
        vista.setVisible(true);
    }
    
    //Limpiar todas las cajas de texto
    public void limpiarCajasTexto(){
        vista.tfNombreCLI.setText("");
        vista.tfAPCLI.setText("");
        vista.tfAMCLI.setText("");
        vista.tfEdadCLI.setText("");
        vista.tfCiudadCLI.setText("");
        vista.tfTelefonoCLI.setText("");
        vista.tfCorreoCLI.setText("");
        vista.tfNombreACLI.setText("");
        vista.tfAPACLI.setText("");
        vista.tfAMACLI.setText("");
        vista.tfEdadACLI.setText("");
        vista.tfCiudadACLI.setText("");
        vista.tfTelefonoACLI.setText("");
        vista.tfCorreoACLI.setText("");
        vista.tfBuscarCLI.setText("");
        vista.tfEliminarCLI.setText("");
        vista.tfModificarCLI.setText("");
    }
    

     public void actionPerformed(ActionEvent evento) {
        if(vista.btnAgregarCLI == evento.getSource()) {
            if(modelo.clientesInsertar(
                    
                    vista.tfNombreACLI.getText(),vista.tfAPACLI.getText(),vista.tfAMACLI.getText(),Integer.parseInt(vista.tfEdadACLI.getText()),vista.tfCiudadACLI.getText(),
            vista.tfTelefonoACLI.getText(),vista.tfCorreoACLI.getText())){
                JOptionPane.showMessageDialog(null, "Registro insertado exitosamente");
                this.vista.tabClientesCLI.setModel(modelo.clientesConsultar());
               
                limpiarCajasTexto();
            }else{
                JOptionPane.showMessageDialog(null, "No se pudo insertar");
            }
        }else if(vista.btnEliminarCLI == evento.getSource()){
            if(modelo.clientesEliminar(Integer.parseInt(vista.tfEliminarCLI.getText()))){
                JOptionPane.showMessageDialog(null, "Registro eliminado exitosamente");
                this.vista.tabClientesCLI.setModel(modelo.clientesConsultar());
                limpiarCajasTexto();
            }else{
                JOptionPane.showMessageDialog(null, "No se pudo eliminar");
            }
        }else if(vista.btnModificarCLI == evento.getSource()){
            if(modelo.clientesActualizar(
                    Integer.parseInt(vista.tfModificarCLI.getText()),
                    vista.tfNombreCLI.getText(),vista.tfAPCLI.getText(),vista.tfAMCLI.getText(),Integer.parseInt(vista.tfEdadCLI.getText()),vista.tfCiudadCLI.getText(),
            vista.tfTelefonoCLI.getText(),vista.tfCorreoCLI.getText())){
                JOptionPane.showMessageDialog(null, "Registro modificado exitosamente");
                this.vista.tabClientesCLI.setModel(modelo.clientesConsultar());                                        
                limpiarCajasTexto();
            }else{
                JOptionPane.showMessageDialog(null, "No se pudo actualizar");
            }            
        }       //tfNombreCLI
        else if(vista.btnBuscarCLI==evento.getSource()){
            try{
                new Thread(new HiloBuscar(),"Buscar").start();
                vista.btnBuscarCLI.setEnabled(false);
                //vista.tabClientesCLI.setModel(modelo.clientesBuscar(Integer.parseInt(vista.tfBuscarCLI.getText())));
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "No se encontró ese registro");
            }
        } else if(vista.btnRegresarCLI==evento.getSource()){
            Menu MEN = new Menu();
            CMenu controladorM = new CMenu(MEN);
            controladorM.iniciarVista();
            vista.dispose();
        }
    }
 
     public void mouseClicked(MouseEvent e) {
        if(vista.tabClientesCLI == e.getSource()){
            int  fila = vista.tabClientesCLI.rowAtPoint(e.getPoint());
            if (fila > -1){
                vista.tfBuscarCLI.setText(String.valueOf(vista.tabClientesCLI.getValueAt(fila, 0)));
                vista.tfModificarCLI.setText(String.valueOf(vista.tabClientesCLI.getValueAt(fila, 0)));
                vista.tfEliminarCLI.setText(String.valueOf(vista.tabClientesCLI.getValueAt(fila, 0)));
                vista.tfNombreCLI.setText(String.valueOf(vista.tabClientesCLI.getValueAt(fila, 1)));
                vista.tfAPCLI.setText(String.valueOf(vista.tabClientesCLI.getValueAt(fila, 2)));
                vista.tfAMCLI.setText(String.valueOf(vista.tabClientesCLI.getValueAt(fila, 3)));
                vista.tfEdadCLI.setText(String.valueOf(vista.tabClientesCLI.getValueAt(fila, 4)));
                vista.tfCiudadCLI.setText(String.valueOf(vista.tabClientesCLI.getValueAt(fila, 5)));
                vista.tfTelefonoCLI.setText(String.valueOf(vista.tabClientesCLI.getValueAt(fila, 6)));
                vista.tfCorreoCLI.setText(String.valueOf(vista.tabClientesCLI.getValueAt(fila, 7)));
                vista.tfNombreACLI.setText(String.valueOf(vista.tabClientesCLI.getValueAt(fila, 1)));
                vista.tfAPACLI.setText(String.valueOf(vista.tabClientesCLI.getValueAt(fila, 2)));
                vista.tfAMACLI.setText(String.valueOf(vista.tabClientesCLI.getValueAt(fila, 3)));
                vista.tfEdadACLI.setText(String.valueOf(vista.tabClientesCLI.getValueAt(fila, 4)));
                vista.tfCiudadACLI.setText(String.valueOf(vista.tabClientesCLI.getValueAt(fila, 5)));
                vista.tfTelefonoACLI.setText(String.valueOf(vista.tabClientesCLI.getValueAt(fila, 6)));
                vista.tfCorreoACLI.setText(String.valueOf(vista.tabClientesCLI.getValueAt(fila, 7)));
             }
        }
    }

//    @Override
//    public void mouseClicked(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

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
