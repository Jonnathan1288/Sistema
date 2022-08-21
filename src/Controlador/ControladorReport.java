/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ConectionPg;
import Vista.MenuPrincipal;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author DELL
 */
public class ControladorReport {

    private MenuPrincipal vistamenup;

    public ControladorReport(MenuPrincipal vistamenup) {
        this.vistamenup = vistamenup;
    }

    public void ControlViewReportButton() {
        vistamenup.getJmenuCatalogoP().addActionListener(l->ImprimirCatalogo());
        vistamenup.getJmenuCat().addActionListener(l->ImprimirCatalogo());
    }

    private void ImprimirCatalogo() {
        ConectionPg cp = new ConectionPg();
        try {
            JasperReport jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/Vista/Reportes/Catalogo.jasper"));
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("fondo", "fondo.png");
            JasperPrint jp = JasperFillManager.fillReport(jr, map, cp.getCon());
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(ControlProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
