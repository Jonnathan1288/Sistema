/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.secciones;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JSpinner;
import javax.swing.JTable;

/**
 *
 * @author DELL
 */
public class PanelVegetales extends javax.swing.JPanel {

    /**
     * Creates new form PanelVegetales
     */
    public PanelVegetales() {
        initComponents();
    }

    public JButton getBtnBrocoli() {
        return BtnBrocoli;
    }

    public void setBtnBrocoli(JButton BtnBrocoli) {
        this.BtnBrocoli = BtnBrocoli;
    }

    public JButton getBtnLechuga() {
        return BtnLechuga;
    }

    public void setBtnLechuga(JButton BtnLechuga) {
        this.BtnLechuga = BtnLechuga;
    }

    public JButton getBtnTomate() {
        return BtnTomate;
    }

    public void setBtnTomate(JButton BtnTomate) {
        this.BtnTomate = BtnTomate;
    }

    public JButton getBtnCebolla() {
        return BtnCebolla;
    }

    public void setBtnCebolla(JButton BtnCebolla) {
        this.BtnCebolla = BtnCebolla;
    }

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BtnLechuga = new javax.swing.JButton();
        BtnTomate = new javax.swing.JButton();
        BtnCebolla = new javax.swing.JButton();
        BtnBrocoli = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Productos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        setPreferredSize(new java.awt.Dimension(427, 411));

        BtnLechuga.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BtnLechuga.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/secciones/Img/Lechuga1.png"))); // NOI18N
        BtnLechuga.setText("Lechuga");
        BtnLechuga.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnLechuga.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        BtnTomate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BtnTomate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/secciones/Img/Tomates.png"))); // NOI18N
        BtnTomate.setText("Tomate");
        BtnTomate.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnTomate.setPreferredSize(new java.awt.Dimension(123, 120));
        BtnTomate.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        BtnCebolla.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BtnCebolla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/secciones/Img/Cebolla.png"))); // NOI18N
        BtnCebolla.setText("Cebolla");
        BtnCebolla.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnCebolla.setPreferredSize(new java.awt.Dimension(123, 120));
        BtnCebolla.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        BtnBrocoli.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BtnBrocoli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/secciones/Img/Br??coli.png"))); // NOI18N
        BtnBrocoli.setText("Br??coli");
        BtnBrocoli.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnBrocoli.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BtnBrocoli, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(BtnLechuga, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addComponent(BtnTomate, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(BtnCebolla, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BtnTomate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnCebolla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnLechuga, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(14, 14, 14)
                .addComponent(BtnBrocoli)
                .addContainerGap(86, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnBrocoli;
    private javax.swing.JButton BtnCebolla;
    private javax.swing.JButton BtnLechuga;
    private javax.swing.JButton BtnTomate;
    // End of variables declaration//GEN-END:variables
}
