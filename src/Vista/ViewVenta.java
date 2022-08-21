/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author DELL
 */
public class ViewVenta extends javax.swing.JInternalFrame {

    /**
     * Creates new form ViewVenta
     */
    public ViewVenta() {
        initComponents();
    } 

    public JTextField getTxtBuscarCedula() {
        return TxtBuscarCedula;
    }

    public void setTxtBuscarCedula(JTextField TxtBuscarCedula) {
        this.TxtBuscarCedula = TxtBuscarCedula;
    }
    

    public JButton getBtnFrutasVen() {
        return BtnFrutasVen;
    }

    public void setBtnFrutasVen(JButton BtnFrutasVen) {
        this.BtnFrutasVen = BtnFrutasVen;
    }

    public JPanel getPanelContenedorPro() {
        return PanelContenedorPro;
    }

    public void setPanelContenedorPro(JPanel PanelContenedorPro) {
        this.PanelContenedorPro = PanelContenedorPro;
    }

    public JButton getBtnVegetalesVis() {
        return BtnVegetalesVis;
    }

    public void setBtnVegetalesVis(JButton BtnVegetalesVis) {
        this.BtnVegetalesVis = BtnVegetalesVis;
    }

    public JButton getBtnGuardarVen() {
        return BtnGuardarVen;
    }

    public void setBtnGuardarVen(JButton BtnGuardarVen) {
        this.BtnGuardarVen = BtnGuardarVen;
    }

    public JTextField getTxtCantidadVen() {
        return TxtCantidadVen;
    }

    public void setTxtCantidadVen(JTextField TxtCantidadVen) {
        this.TxtCantidadVen = TxtCantidadVen;
    }

    public JTextField getTxtIdProductoVen() {
        return TxtIdProductoVen;
    }

    public void setTxtIdProductoVen(JTextField TxtIdProductoVen) {
        this.TxtIdProductoVen = TxtIdProductoVen;
    }

    public JTextField getTxtNombresVen() {
        return TxtNombresVen;
    }

    public void setTxtNombresVen(JTextField TxtNombresVen) {
        this.TxtNombresVen = TxtNombresVen;
    }

    public JTextField getTxtTotalVen() {
        return TxtTotalVen;
    }

    public void setTxtTotalVen(JTextField TxtTotalVen) {
        this.TxtTotalVen = TxtTotalVen;
    }

    public JTextField getTxtPrecioVen() {
        return TxtPrecioVen;
    }

    public void setTxtPrecioVen(JTextField TxtPrecioVen) {
        this.TxtPrecioVen = TxtPrecioVen;
    }

    public JTable getTablaFacturaVenta() {
        return TablaFacturaVenta;
    }

    public void setTablaFacturaVenta(JTable TablaFacturaVenta) {
        this.TablaFacturaVenta = TablaFacturaVenta;
    }

    public JLabel getLblFechaActual() {
        return LblFechaActual;
    }

    public void setLblFechaActual(JLabel LblFechaActual) {
        this.LblFechaActual = LblFechaActual;
    }

    public JButton getBtnGenerarfacturaV() {
        return BtnGenerarfacturaV;
    }

    public void setBtnGenerarfacturaV(JButton BtnGenerarfacturaV) {
        this.BtnGenerarfacturaV = BtnGenerarfacturaV;
    }

    public JTextField getTxtIVAVen() {
        return TxtIVAVen;
    }

    public void setTxtIVAVen(JTextField TxtIVAVen) {
        this.TxtIVAVen = TxtIVAVen;
    }

    public JTextField getTxtSubtotalVen() {
        return TxtSubtotalVen;
    }

    public void setTxtSubtotalVen(JTextField TxtSubtotalVen) {
        this.TxtSubtotalVen = TxtSubtotalVen;
    }

    public JTextField getTxtTotalPagarven() {
        return TxtTotalPagarven;
    }

    public void setTxtTotalPagarven(JTextField TxtTotalPagarven) {
        this.TxtTotalPagarven = TxtTotalPagarven;
    }

    public JTextField getTxtIDfacturaIncremento() {
        return TxtIDfacturaIncremento;
    }

    public void setTxtIDfacturaIncremento(JTextField TxtIDfacturaIncremento) {
        this.TxtIDfacturaIncremento = TxtIDfacturaIncremento;
    }

    public JTextField getTxtNombreProductoVenta() {
        return TxtNombreProductoVenta;
    }

    public void setTxtNombreProductoVenta(JTextField TxtNombreProductoVenta) {
        this.TxtNombreProductoVenta = TxtNombreProductoVenta;
    }

    public JButton getBtnHeladosVenta() {
        return BtnHeladosVenta;
    }

    public void setBtnHeladosVenta(JButton BtnHeladosVenta) {
        this.BtnHeladosVenta = BtnHeladosVenta;
    }

    public JButton getBtnAceptarVV() {
        return BtnAceptarVV;
    }

    public void setBtnAceptarVV(JButton BtnAceptarVV) {
        this.BtnAceptarVV = BtnAceptarVV;
    }

    public JButton getBtnCancelarVV() {
        return BtnCancelarVV;
    }

    public void setBtnCancelarVV(JButton BtnCancelarVV) {
        this.BtnCancelarVV = BtnCancelarVV;
    }

    public JDialog getDialogoVentaPrincipal() {
        return DialogoVentaPrincipal;
    }

    public void setDialogoVentaPrincipal(JDialog DialogoVentaPrincipal) {
        this.DialogoVentaPrincipal = DialogoVentaPrincipal;
    }

    public JSpinner getSpinerCantidadPrincipalV() {
        return SpinerCantidadPrincipalV;
    }

    public void setSpinerCantidadPrincipalV(JSpinner SpinerCantidadPrincipalV) {
        this.SpinerCantidadPrincipalV = SpinerCantidadPrincipalV;
    }

    public JTable getTablaProductoPrincipalV() {
        return TablaProductoPrincipalV;
    }

    public void setTablaProductoPrincipalV(JTable TablaProductoPrincipalV) {
        this.TablaProductoPrincipalV = TablaProductoPrincipalV;
    }

    public JButton getBtnOtrosProductos() {
        return BtnOtrosProductos;
    }

    public void setBtnOtrosProductos(JButton BtnOtrosProductos) {
        this.BtnOtrosProductos = BtnOtrosProductos;
    }

    public JTextField getTxtBuscarProductoVentaGeneral() {
        return TxtBuscarProductoVentaGeneral;
    }

    public void setTxtBuscarProductoVentaGeneral(JTextField TxtBuscarProductoVentaGeneral) {
        this.TxtBuscarProductoVentaGeneral = TxtBuscarProductoVentaGeneral;
    }

    public JLabel getLblFotoFonfo() {
        return LblFotoFonfo;
    }

    public void setLblFotoFonfo(JLabel LblFotoFonfo) {
        this.LblFotoFonfo = LblFotoFonfo;
    }

    public JLabel getLblFotoClienteBusqueda() {
        return LblFotoClienteBusqueda;
    }

    public void setLblFotoClienteBusqueda(JLabel LblFotoClienteBusqueda) {
        this.LblFotoClienteBusqueda = LblFotoClienteBusqueda;
    }

    public JButton getBtnCancelarproductoVen() {
        return BtnCancelarproductoVen;
    }

    public void setBtnCancelarproductoVen(JButton BtnCancelarproductoVen) {
        this.BtnCancelarproductoVen = BtnCancelarproductoVen;
    }

    public JButton getBtnEditarCantidadProductoVis() {
        return BtnEditarCantidadProductoVis;
    }

    public void setBtnEditarCantidadProductoVis(JButton BtnEditarCantidadProductoVis) {
        this.BtnEditarCantidadProductoVis = BtnEditarCantidadProductoVis;
    }

    public JButton getBtnCancelarFacturaTotalVen() {
        return BtnCancelarFacturaTotalVen;
    }

    public void setBtnCancelarFacturaTotalVen(JButton BtnCancelarFacturaTotalVen) {
        this.BtnCancelarFacturaTotalVen = BtnCancelarFacturaTotalVen;
    }

    public JButton getBtnEliminarProdcutoFacturaVen() {
        return jButton2;
    }

    public void setBtnEliminarProdcutoFacturaVen(JButton BtnEliminarProdcutoFacturaVen) {
        this.jButton2 = BtnEliminarProdcutoFacturaVen;
    }

    
    
    
    
   
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DialogoVentaPrincipal = new javax.swing.JDialog();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaProductoPrincipalV = new javax.swing.JTable();
        SpinerCantidadPrincipalV = new javax.swing.JSpinner();
        jLabel11 = new javax.swing.JLabel();
        BtnAceptarVV = new javax.swing.JButton();
        BtnCancelarVV = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        TxtBuscarProductoVentaGeneral = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        PanelContenedorPro = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        BtnVegetalesVis = new javax.swing.JButton();
        BtnFrutasVen = new javax.swing.JButton();
        BtnHeladosVenta = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        BtnOtrosProductos = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        LblFotoFonfo = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaFacturaVenta = new javax.swing.JTable();
        BtnGenerarfacturaV = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        TxtIDfacturaIncremento = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        LblFechaActual = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        TxtSubtotalVen = new javax.swing.JTextField();
        TxtIVAVen = new javax.swing.JTextField();
        TxtTotalPagarven = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        BtnCancelarFacturaTotalVen = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        TxtCantidadVen = new javax.swing.JTextField();
        TxtTotalVen = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TxtIdProductoVen = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        TxtPrecioVen = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        TxtNombreProductoVenta = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        TxtBuscarCedula = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        TxtNombresVen = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        LblFotoClienteBusqueda = new javax.swing.JLabel();
        BtnGuardarVen = new javax.swing.JButton();
        BtnCancelarproductoVen = new javax.swing.JButton();
        BtnEditarCantidadProductoVis = new javax.swing.JButton();

        TablaProductoPrincipalV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOMBRE", "PRECIO", "CANTIDAD", "FOTO"
            }
        ));
        jScrollPane2.setViewportView(TablaProductoPrincipalV);

        SpinerCantidadPrincipalV.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        jLabel11.setText("Cantidad:");

        BtnAceptarVV.setText("Aceptar");

        BtnCancelarVV.setText("Cancelar");

        jLabel13.setText("Buscar:");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(jLabel13)
                .addGap(52, 52, 52)
                .addComponent(TxtBuscarProductoVentaGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(TxtBuscarProductoVentaGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addComponent(BtnAceptarVV))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addComponent(BtnCancelarVV))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(SpinerCantidadPrincipalV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(105, Short.MAX_VALUE))
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(SpinerCantidadPrincipalV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnAceptarVV)
                    .addComponent(BtnCancelarVV))
                .addContainerGap(89, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout DialogoVentaPrincipalLayout = new javax.swing.GroupLayout(DialogoVentaPrincipal.getContentPane());
        DialogoVentaPrincipal.getContentPane().setLayout(DialogoVentaPrincipalLayout);
        DialogoVentaPrincipalLayout.setHorizontalGroup(
            DialogoVentaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        DialogoVentaPrincipalLayout.setVerticalGroup(
            DialogoVentaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DialogoVentaPrincipalLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setAutoscrolls(true);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 19, Short.MAX_VALUE)
        );

        PanelContenedorPro.setBackground(new java.awt.Color(255, 255, 255));
        PanelContenedorPro.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Productos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        javax.swing.GroupLayout PanelContenedorProLayout = new javax.swing.GroupLayout(PanelContenedorPro);
        PanelContenedorPro.setLayout(PanelContenedorProLayout);
        PanelContenedorProLayout.setHorizontalGroup(
            PanelContenedorProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 417, Short.MAX_VALUE)
        );
        PanelContenedorProLayout.setVerticalGroup(
            PanelContenedorProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtnVegetalesVis.setBackground(new java.awt.Color(255, 255, 255));
        BtnVegetalesVis.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BtnVegetalesVis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/icons2/icons8-vegetables-25.png"))); // NOI18N
        BtnVegetalesVis.setText("Vegetales");
        BtnVegetalesVis.setBorder(null);
        jPanel7.add(BtnVegetalesVis, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        BtnFrutasVen.setBackground(new java.awt.Color(255, 255, 255));
        BtnFrutasVen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BtnFrutasVen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/icons2/icons8-basket-25.png"))); // NOI18N
        BtnFrutasVen.setText("Frutas");
        BtnFrutasVen.setBorder(null);
        jPanel7.add(BtnFrutasVen, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        BtnHeladosVenta.setBackground(new java.awt.Color(255, 255, 255));
        BtnHeladosVenta.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BtnHeladosVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/icons2/icons8-ice-cream-25.png"))); // NOI18N
        BtnHeladosVenta.setText("Helados");
        BtnHeladosVenta.setBorder(null);
        jPanel7.add(BtnHeladosVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        jPanel8.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jPanel7.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 20));

        BtnOtrosProductos.setBackground(new java.awt.Color(255, 255, 255));
        BtnOtrosProductos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BtnOtrosProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/icons2/icons8-lista-de-quehaceres-25.png"))); // NOI18N
        BtnOtrosProductos.setText("Otros Productos");
        BtnOtrosProductos.setBorder(null);
        jPanel7.add(BtnOtrosProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, 20));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        LblFotoFonfo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255), 2));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LblFotoFonfo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(LblFotoFonfo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 21, Short.MAX_VALUE))
        );

        jPanel7.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jPanel12.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        jPanel7.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 20, 70));

        jPanel13.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        jPanel7.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 20, 70));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Factura"));

        TablaFacturaVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Producto", "Cédula", "Producto", "Precio", "Cantidad", "Total"
            }
        ));
        jScrollPane1.setViewportView(TablaFacturaVenta);

        BtnGenerarfacturaV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/icons/icons8-factura-20.png"))); // NOI18N
        BtnGenerarfacturaV.setText("Generar Factura");

        jLabel12.setText("Numero Factura:");

        TxtIDfacturaIncremento.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        TxtIDfacturaIncremento.setBorder(null);

        jLabel14.setText("Fecha:");

        LblFechaActual.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder("Totales"));

        TxtSubtotalVen.setBorder(null);

        TxtIVAVen.setBorder(null);

        TxtTotalPagarven.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        TxtTotalPagarven.setBorder(null);

        jLabel8.setText("SUBTOTAL:");

        jLabel1.setText("IVA 12%");

        jLabel9.setText("TOTAL:");

        jSeparator8.setForeground(new java.awt.Color(255, 255, 0));

        jSeparator9.setForeground(new java.awt.Color(204, 153, 0));

        jSeparator10.setForeground(new java.awt.Color(0, 153, 0));

        jLabel16.setText("$");

        jLabel17.setText("$");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("$");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator10, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                    .addComponent(jSeparator9)
                    .addComponent(jSeparator8)
                    .addComponent(TxtIVAVen, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TxtSubtotalVen, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TxtTotalPagarven))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtSubtotalVen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(2, 2, 2)
                        .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(14, 14, 14)))
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel18))
                        .addGap(2, 2, 2)
                        .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(TxtIVAVen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(TxtTotalPagarven, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        BtnCancelarFacturaTotalVen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/icons/icons8-cancelar-suscripción-20.png"))); // NOI18N
        BtnCancelarFacturaTotalVen.setText("CancelarFactura");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/icons/icons8-eliminar-20.png"))); // NOI18N
        jButton2.setText("Eliminar");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TxtIDfacturaIncremento, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(LblFechaActual, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(BtnGenerarfacturaV)
                            .addComponent(BtnCancelarFacturaTotalVen)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)))
                .addGap(5, 5, 5))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(BtnGenerarfacturaV)
                        .addGap(14, 14, 14)
                        .addComponent(BtnCancelarFacturaTotalVen)
                        .addGap(14, 14, 14)
                        .addComponent(jButton2))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel12)
                                .addComponent(TxtIDfacturaIncremento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(LblFechaActual, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel10.setBackground(new java.awt.Color(204, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Producto"));

        TxtCantidadVen.setBorder(null);

        TxtTotalVen.setBorder(null);

        jLabel4.setText("Cantidad:");

        jLabel5.setText("Total:");

        jLabel6.setText("ID Producto:");

        TxtIdProductoVen.setBorder(null);

        jLabel7.setText("Precio:");

        TxtPrecioVen.setBorder(null);

        jLabel10.setText("Producto:");

        TxtNombreProductoVenta.setBorder(null);

        jSeparator1.setForeground(new java.awt.Color(0, 0, 153));
        jSeparator1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jSeparator2.setForeground(new java.awt.Color(0, 0, 153));

        jSeparator3.setForeground(new java.awt.Color(0, 0, 153));

        jSeparator4.setForeground(new java.awt.Color(0, 0, 153));

        jSeparator5.setForeground(new java.awt.Color(0, 0, 153));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(TxtCantidadVen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
                            .addComponent(jLabel7))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator2)
                            .addComponent(jSeparator1)
                            .addComponent(jLabel6)
                            .addComponent(TxtIdProductoVen, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                            .addComponent(jLabel10)
                            .addComponent(TxtNombreProductoVenta)
                            .addComponent(TxtTotalVen)
                            .addComponent(TxtPrecioVen)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jSeparator4)
                            .addComponent(jSeparator5))
                        .addGap(0, 14, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addGap(10, 10, 10)
                .addComponent(TxtIdProductoVen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel10)
                .addGap(10, 10, 10)
                .addComponent(TxtNombreProductoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel4)
                .addGap(10, 10, 10)
                .addComponent(TxtCantidadVen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(TxtPrecioVen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel5)
                .addGap(10, 10, 10)
                .addComponent(TxtTotalVen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Cliente"));

        jLabel2.setText("Cédula:");

        TxtBuscarCedula.setBorder(null);

        jLabel3.setText("Nombres:");

        TxtNombresVen.setBorder(null);

        jSeparator6.setForeground(new java.awt.Color(0, 0, 153));

        jSeparator7.setForeground(new java.awt.Color(0, 0, 153));

        jLabel15.setText("Foto");

        LblFotoClienteBusqueda.setForeground(new java.awt.Color(0, 0, 204));
        LblFotoClienteBusqueda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(TxtNombresVen, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addComponent(jSeparator6)
                        .addComponent(jSeparator7)
                        .addComponent(TxtBuscarCedula))
                    .addComponent(jLabel3)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(LblFotoClienteBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(10, 10, 10)
                .addComponent(TxtBuscarCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel3)
                .addGap(10, 10, 10)
                .addComponent(TxtNombresVen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LblFotoClienteBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        BtnGuardarVen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/icons/icons8-guardar-20.png"))); // NOI18N
        BtnGuardarVen.setText("Guardar");

        BtnCancelarproductoVen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/icons/icons8-cancelar-20.png"))); // NOI18N
        BtnCancelarproductoVen.setText("Cancelar");

        BtnEditarCantidadProductoVis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/icons/icons8-editar-20.png"))); // NOI18N
        BtnEditarCantidadProductoVis.setText("Editar");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(BtnGuardarVen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnCancelarproductoVen)
                        .addGap(46, 46, 46)
                        .addComponent(BtnEditarCantidadProductoVis))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(2, 2, 2)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnGuardarVen)
                    .addComponent(BtnCancelarproductoVen)
                    .addComponent(BtnEditarCantidadProductoVis))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(PanelContenedorPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PanelContenedorPro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAceptarVV;
    private javax.swing.JButton BtnCancelarFacturaTotalVen;
    private javax.swing.JButton BtnCancelarVV;
    private javax.swing.JButton BtnCancelarproductoVen;
    private javax.swing.JButton BtnEditarCantidadProductoVis;
    private javax.swing.JButton BtnFrutasVen;
    private javax.swing.JButton BtnGenerarfacturaV;
    private javax.swing.JButton BtnGuardarVen;
    private javax.swing.JButton BtnHeladosVenta;
    private javax.swing.JButton BtnOtrosProductos;
    private javax.swing.JButton BtnVegetalesVis;
    private javax.swing.JDialog DialogoVentaPrincipal;
    private javax.swing.JLabel LblFechaActual;
    private javax.swing.JLabel LblFotoClienteBusqueda;
    private javax.swing.JLabel LblFotoFonfo;
    private javax.swing.JPanel PanelContenedorPro;
    private javax.swing.JSpinner SpinerCantidadPrincipalV;
    private javax.swing.JTable TablaFacturaVenta;
    private javax.swing.JTable TablaProductoPrincipalV;
    private javax.swing.JTextField TxtBuscarCedula;
    private javax.swing.JTextField TxtBuscarProductoVentaGeneral;
    private javax.swing.JTextField TxtCantidadVen;
    private javax.swing.JTextField TxtIDfacturaIncremento;
    private javax.swing.JTextField TxtIVAVen;
    private javax.swing.JTextField TxtIdProductoVen;
    private javax.swing.JTextField TxtNombreProductoVenta;
    private javax.swing.JTextField TxtNombresVen;
    private javax.swing.JTextField TxtPrecioVen;
    private javax.swing.JTextField TxtSubtotalVen;
    private javax.swing.JTextField TxtTotalPagarven;
    private javax.swing.JTextField TxtTotalVen;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    // End of variables declaration//GEN-END:variables
}
