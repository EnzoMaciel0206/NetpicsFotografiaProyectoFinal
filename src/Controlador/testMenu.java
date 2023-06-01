/*
Descripción: Clase Main para correr el programa
Fecha: 13-agosto-2022
Nombre: Enzo Alejandro Maciel Núñez
 */
package Controlador;

import Vista.Menu;

public class testMenu {

    public static void main(String[] args) {
        Menu vista = new Menu();
        CMenu controladorM = new CMenu(vista);
        controladorM.iniciarVista();
    }
    
}
