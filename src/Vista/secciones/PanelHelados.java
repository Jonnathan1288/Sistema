/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.secciones;

import javax.swing.JButton;

/**
 *
 * @author DELL
 */
public class PanelHelados extends javax.swing.JPanel {

    /**
     * Creates new form PanelHelados
     */
    public PanelHelados() {
        initComponents();
    }

    public JButton getBtnHeladoChocolate() {
        return BtnHeladoChocolate;
    }

    public void setBtnHeladoChocolate(JButton BtnHeladoChocolate) {
        this.BtnHeladoChocolate = BtnHeladoChocolate;
    }

    public JButton getBtnHeladoCoco() {
        return BtnHeladoCoco;
    }

    public void setBtnHeladoCoco(JButton BtnHeladoCoco) {
        this.BtnHeladoCoco = BtnHeladoCoco;
    }

    public JButton getBtnHeladoFresa() {
        return BtnHeladoFresa;
    }

    public void setBtnHeladoFresa(JButton BtnHeladoFresa) {
        this.BtnHeladoFresa = BtnHeladoFresa;
    }

    public JButton getBtnHeladoNatural() {
        return BtnHeladoNatural;
    }

    public void setBtnHeladoNatural(JButton BtnHeladoNatural) {
        this.BtnHeladoNatural = BtnHeladoNatural;
    }

    public JButton getBtnHeladoVainilla() {
        return BtnHeladoVainilla;
    }

    public void setBtnHeladoVainilla(JButton BtnHeladoVainilla) {
        this.BtnHeladoVainilla = BtnHeladoVainilla;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BtnHeladoChocolate = new javax.swing.JButton();
        BtnHeladoCoco = new javax.swing.JButton();
        BtnHeladoNatural = new javax.swing.JButton();
        BtnHeladoFresa = new javax.swing.JButton();
        BtnHeladoVainilla = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Productos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        setPreferredSize(new java.awt.Dimension(407, 327));

        BtnHeladoChocolate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BtnHeladoChocolate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/secciones/Img/HeladoChocolate.png"))); // NOI18N
        BtnHeladoChocolate.setText("Chocolate");
        BtnHeladoChocolate.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnHeladoChocolate.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        BtnHeladoCoco.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BtnHeladoCoco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/secciones/Img/HeladoCoco.png"))); // NOI18N
        BtnHeladoCoco.setText("Coco");
        BtnHeladoCoco.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnHeladoCoco.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        BtnHeladoNatural.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BtnHeladoNatural.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/secciones/Img/HeladoNatural.png"))); // NOI18N
        BtnHeladoNatural.setText("Narural");
        BtnHeladoNatural.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnHeladoNatural.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        BtnHeladoFresa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BtnHeladoFresa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/secciones/Img/HeladoFresa.png"))); // NOI18N
        BtnHeladoFresa.setText("Fresa");
        BtnHeladoFresa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnHeladoFresa.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        BtnHeladoVainilla.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BtnHeladoVainilla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/secciones/Img/HeladoVainilla.png"))); // NOI18N
        BtnHeladoVainilla.setText("Vainilla");
        BtnHeladoVainilla.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnHeladoVainilla.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BtnHeladoFresa, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnHeladoChocolate, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnHeladoVainilla, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnHeladoCoco, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addComponent(BtnHeladoNatural, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BtnHeladoChocolate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnHeladoCoco, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                    .addComponent(BtnHeladoNatural, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BtnHeladoFresa, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                    .addComponent(BtnHeladoVainilla, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
                .addContainerGap(33, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnHeladoChocolate;
    private javax.swing.JButton BtnHeladoCoco;
    private javax.swing.JButton BtnHeladoFresa;
    private javax.swing.JButton BtnHeladoNatural;
    private javax.swing.JButton BtnHeladoVainilla;
    // End of variables declaration//GEN-END:variables
}
