/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModeloFactura;
import Modelo.ModeloPersona;
import Modelo.ModeloProducto;
import Modelo.ModeloVenta;
import Vista.MenuPrincipal;
import Vista.ViewPersonas;
import Vista.ViewProducto;
import Vista.ViewVenta;
import Vista.secciones.PanelFrutas;
import Vista.secciones.PanelVegetales;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class ControlMenuPrincipal {
    MenuPrincipal vistamp;

    public ControlMenuPrincipal(MenuPrincipal vistamp) {
        this.vistamp = vistamp;
        vistamp.setVisible(true);
        vistamp.setLocationRelativeTo(null);
        Report_Cat();
//        Factura();
    }
    
    public void iniciaControl(){
        vistamp.getMenuCrudPersona().addActionListener(l -> crudPersonas());
        vistamp.getBtnPersonas().addActionListener(l ->crudPersonas());
        vistamp.getBtnCProducto().addActionListener(l -> CrudProductos());
        vistamp.getMenuCrearProducto().addActionListener(l -> CrudProductos());
        vistamp.getMenuSalirSistema().addActionListener(l -> SalirSistema());
        vistamp.getMenuVenderProducto().addActionListener(l -> PuntoVenta());
        vistamp.getBtnVenProdu().addActionListener(l -> PuntoVenta());
    }
    
    private void crudPersonas(){
        ModeloPersona modP = new ModeloPersona();
        ViewPersonas visP = new ViewPersonas();
        vistamp.getDesktopPrincipal().add(visP);
        ControlPersona conP = new ControlPersona(modP, visP);
        conP.ControlBoton();
    }
    
    private void CrudProductos(){
        ModeloProducto modPro = new ModeloProducto();
        ViewProducto visPro = new ViewProducto();
        vistamp.getDesktopPrincipal().add(visPro);
        ControlProducto conP = new ControlProducto(modPro, visPro);
        conP.controlBoton();
    }
    
    private void PuntoVenta(){
        ModeloVenta modVen = new ModeloVenta();
        ViewVenta visPro = new ViewVenta();
        PanelFrutas panfru = new PanelFrutas();
        PanelVegetales panVege = new PanelVegetales();
        vistamp.getDesktopPrincipal().add(visPro);
        ControlVenta conP = new ControlVenta(modVen, visPro, panfru, panVege);
        conP.controlBoton();
    }
    
    private void SalirSistema(){
        try {
            Thread.sleep(500);
            System.exit(0);
        } catch (InterruptedException ex) {
            Logger.getLogger(ControlMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void Report_Cat(){
        ControladorReport cr = new ControladorReport(vistamp);
        cr.ControlViewReportButton();
    }
    
}
