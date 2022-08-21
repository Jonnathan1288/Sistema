/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jonnathangallegosmvc;

import Controlador.ControLoading;
import Controlador.ControlMenuPrincipal;
import Controlador.ControlPersona;
import Controlador.ControlProducto;
import Modelo.ModeloPersona;
import Modelo.ModeloProducto;
import Vista.MenuPrincipal;
import Vista.Sistema_Loading;
import Vista.ViewPersonas;
import Vista.ViewProducto;

/**
 *
 * @author DELL
 */
public class JonnathanGallegosMVC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        ModeloPersona modP = new ModeloPersona();
//        ViewPersonas visP = new ViewPersonas();
//        ControlPersona conP = new ControlPersona(modP, visP);
//        conP.ControlBoton();
//        ModeloProducto modP = new ModeloProducto();
//        ViewProducto visP = new ViewProducto();
//        ControlProducto conP = new ControlProducto(modP, visP);
//        conP.controlBoton();
//        
        MenuPrincipal mp = new MenuPrincipal();
        ControlMenuPrincipal controlmp = new ControlMenuPrincipal(mp);
        controlmp.iniciaControl();
          

//        Sistema_Loading mp = new Sistema_Loading();
//        ControLoading controlmp = new ControLoading(mp);
    }
    
}
