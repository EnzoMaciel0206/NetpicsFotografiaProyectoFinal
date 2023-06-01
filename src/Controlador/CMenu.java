/*
Descripción: Clase para el controlador del Menu principal
Fecha: 12-agosto-2022
Nombre: Enzo Alejandro Maciel Núñez
 */
package Controlador;

import Vista.Menu;
//import Modelo.MRevisarClientes;
//import Modelo.MRevisarAceptar;
//import Modelo.MVentanaCotizaciones;
//import Modelo.MVentanaEvenSes;
//import Vista.RevisarClientes;
//import Vista.RevisarAceptar;
//import Vista.VVentanaCotizaciones;
//import Vista.VentanaEvenSes;
import javax.swing.JFrame;

/**
 *
 * @author Just Gaming
 */
public class CMenu{
    private Menu vista;
    
    public CMenu(Menu vista) {
        this.vista = vista;
//        this.vista.btnIrCLI.addActionListener(this);
//        this.vista.btnIrSol.addActionListener(this);
//        this.vista.btnIrCot.addActionListener(this);
//        this.vista.btnIrES.addActionListener(this);
    }
    
    public void iniciarVista() {
        vista.setTitle("Menu Principal");
        vista.pack();
        vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }
    
//    public void actionPerformed(ActionEvent evento){
//        if(vista.btnIrCLI == evento.getSource()) {
//            CrearVentanaES();
//            
//        }else if(vista.btnIrSol == evento.getSource()) {
//            modelo.IrSolicitudes();
//            
//        }else if(vista.btnIrCot == evento.getSource()) {
//            modelo.IrCotizaciones();
//            
//        }else if(vista.btnIrES == evento.getSource()) {
//            modelo.IrEventoSesiones();
//            
//        }
//    }
   

}
    

