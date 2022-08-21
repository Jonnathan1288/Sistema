/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.MenuPrincipal;
import Vista.Sistema_Loading;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class ControLoading {
    private Sistema_Loading vistaLoading;

    public ControLoading(Sistema_Loading vistaLoading) {
        this.vistaLoading = vistaLoading;
        vistaLoading.setVisible(true);
        cargaLoadingSistema();
    }
    private void cargaLoadingSistema(){
        //Nimbus
        try {
            for(javax.swing.UIManager.LookAndFeelInfo info: javax.swing.UIManager.getInstalledLookAndFeels()){
                if("Window".equals(info.getName())){
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                }
            }
        } catch (ClassNotFoundException ex) {
            
        }catch(InstantiationException ex){
        }catch(IllegalAccessException ex){
        }catch(javax.swing.UnsupportedLookAndFeelException ex){
        }
        
        try {
            for (int i = 0; i <= 100; i++) {
               Thread.sleep(i);
                vistaLoading.getLblPorcentaje().setText(i +"%");
                if(i == 30){
                    vistaLoading.getLblNombresPorcesos().setText("Validando datos.");
                }
                if(i == 60){
                    vistaLoading.getLblNombresPorcesos().setText("Procesando datos.");
                }
                if(i == 90){
                    vistaLoading.getLblNombresPorcesos().setText("Ya casi está listo la factura.");
                }
                vistaLoading.getLoading().setValue(i);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vistaLoading, e);
        }
        vistaLoading.dispose();
        MenuPrincipal mp = new MenuPrincipal();
        ControlMenuPrincipal controlmp = new ControlMenuPrincipal(mp);
        controlmp.iniciaControl();
        
    }
    
}
