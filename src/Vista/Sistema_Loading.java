/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javax.swing.JLabel;
import javax.swing.JProgressBar;

/**
 *
 * @author DELL
 */
public class Sistema_Loading extends javax.swing.JFrame {

    /**
     * Creates new form Sistema_Loading
     */
    public Sistema_Loading() {
        initComponents();
    }

    public JLabel getLblNombresPorcesos() {
        return LblNombresPorcesos;
    }

    public void setLblNombresPorcesos(JLabel LblNombresPorcesos) {
        this.LblNombresPorcesos = LblNombresPorcesos;
    }

    public JLabel getLblPorcentaje() {
        return LblPorcentaje;
    }

    public void setLblPorcentaje(JLabel LblPorcentaje) {
        this.LblPorcentaje = LblPorcentaje;
    }

    public JProgressBar getLoading() {
        return Loading;
    }

    public void setLoading(JProgressBar Loading) {
        this.Loading = Loading;
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        LblLogoPrincipal = new javax.swing.JLabel();
        Loading = new javax.swing.JProgressBar();
        LblPorcentaje = new javax.swing.JLabel();
        LblNombresPorcesos = new javax.swing.JLabel();
        fSLabel1 = new LIB.FSLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LblLogoPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/icons2/LogoMis.jpg"))); // NOI18N
        LblLogoPrincipal.setText("jLabel3");

        LblPorcentaje.setText("0 %");

        LblNombresPorcesos.setText("Cargando..");

        fSLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/icons2/icons8-ice-cream-20.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Loading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LblPorcentaje)
                .addGap(28, 28, 28))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(LblNombresPorcesos))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(LblLogoPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 678, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(fSLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(112, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addComponent(fSLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LblLogoPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LblPorcentaje)
                .addGap(8, 8, 8)
                .addComponent(LblNombresPorcesos)
                .addGap(18, 18, 18)
                .addComponent(Loading, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LblLogoPrincipal;
    private javax.swing.JLabel LblNombresPorcesos;
    private javax.swing.JLabel LblPorcentaje;
    private javax.swing.JProgressBar Loading;
    private LIB.FSLabel fSLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}