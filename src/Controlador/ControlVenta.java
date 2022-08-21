/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ConectionPg;
import Modelo.DetalleFactura;
import Modelo.ModeloDetalleFactura;
import Modelo.ModeloFactura;
import Modelo.ModeloProducto;
import Modelo.ModeloVenta;
import Modelo.Producto;
import Modelo.Venta;
import Vista.ViewProducto;
import Vista.ViewVenta;
import Vista.secciones.PanelFrutas;
import Vista.secciones.PanelHelados;
import Vista.secciones.PanelVegetales;
import Vista.secciones.VistaGeneralProductos;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.xml.ws.Holder;
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
public class ControlVenta {

    //Modelo y Vistas.
    private ModeloVenta modVenta;
    private ViewVenta vistaVen;
    private PanelFrutas vistafruta;
    private PanelVegetales vistaVeget;

    //Variables Auxiliares.
    String tipSeccion = null;
    private int valorAuxDecremento;
    ArrayList<ModeloVenta> listaVenta = new ArrayList<ModeloVenta>();
    ArrayList<DetalleFactura> listaDetalle = new ArrayList<DetalleFactura>();
    LocalDate fechaActual = LocalDate.now();
    double totalPagar;
    private String nombres = null;
    PanelHelados vistaHelado = new PanelHelados();
    VistaGeneralProductos vistageneProdu = new VistaGeneralProductos();
    Icon vistalogo;

    //Constructor
    public ControlVenta(ModeloVenta modVenta, ViewVenta vistaVen, PanelFrutas vistafruta, PanelVegetales vistaVeget) {
        this.modVenta = modVenta;
        this.vistaVen = vistaVen;
        this.vistafruta = vistafruta;
        this.vistaVeget = vistaVeget;
        vistaVen.setVisible(true);
        EventosBotones();
        contolesIniciales();
        this.vistaVen.getLblFechaActual().setText(fechaActual + "");
        CargarProductoDiferente();
        CargaLogoVista();
    }

    private void CargaLogoVista() {
        vistalogo = new ImageIcon("src/Image/milLogo.jpg");
        vistaVen.getLblFotoFonfo().setIcon(vistalogo);
    }

    private void contolesIniciales() {
        ControlBotonVFruta();
        ControlBotonVegetal();
        ControlBotonHelado();
        ControlEdicionBoton();
        ControlBotonProductoGeneralVen();
        ControlEnvioDetalle_Y_Factura();
        IngrementoIDFacuraBD();
        Ev();
    }

    //Metodo de incremento de la factura-----------------------------------------------------
    private void IngrementoIDFacuraBD() {
        vistaVen.getTxtIDfacturaIncremento().setText(String.valueOf(modVenta.IncrementoCodigo()));
    }

    //Control de todos los botones referentes a la vista de venta-------------------------
    public void controlBoton() {
        vistaVen.getBtnFrutasVen().addActionListener(l -> CargaPanelFrutas());
        vistaVen.getBtnVegetalesVis().addActionListener(l -> CargaPanelVegetales());
        vistaVen.getBtnHeladosVenta().addActionListener(l -> CargaPanelHelados());
        vistaVen.getBtnGuardarVen().addActionListener(l -> ValidoFacDetalle());
        vistaVen.getBtnCancelarproductoVen().addActionListener(l -> editarDetalle());
        vistaVen.getBtnOtrosProductos().addActionListener(l -> CargaPanelGeneralProductos());
        vistaVen.getBtnAceptarVV().addActionListener(l -> AceptarProductoDiferente());
        vistaVen.getBtnCancelarVV().addActionListener(l -> CacelarVistaDialogoPrincipal());
        vistaVen.getBtnEditarCantidadProductoVis().addActionListener(l -> EditarCantidadProducto());
        vistaVen.getBtnCancelarFacturaTotalVen().addActionListener(l -> CancelarFacturaTot());
        vistaVen.getBtnEliminarProdcutoFacturaVen().addActionListener(l -> EliminarRegistroTBDetalleFactura());
        vistaVen.getBtnCancelarproductoVen().addActionListener(l -> limpiarDatosT());
    }

    //Eventos de busqueda--------------------------------
    private void EventosBotones() {
        KeyListener buscar = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                String bu = vistaVen.getTxtBuscarCedula().getText();
                nombresBus(bu);
            }
        };
        KeyListener buscarProducto = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                String buscarP = vistaVen.getTxtBuscarProductoVentaGeneral().getText().toLowerCase();
                CargarProductoBusqueda_Dif(buscarP);
            }
        };
        KeyListener cedulaCliente = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (c < '0' || c > '9') {
                    e.consume();
                }
                if (Character.isLetter(c)) {
                    e.consume();
                    JOptionPane.showMessageDialog(vistaVen, "Por favor, debe ingresar solo números en este campo.", "Cédula.", JOptionPane.WARNING_MESSAGE);
                }
                if (vistaVen.getTxtBuscarCedula().getText().length() == 11) {
                    e.consume();
                    JOptionPane.showMessageDialog(vistaVen, "Ya están los 10 dígitos de la cedula.", "Numero de dígitos.", JOptionPane.ERROR_MESSAGE);
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        };

        vistaVen.getTxtBuscarCedula().addKeyListener(buscar);
        vistaVen.getTxtBuscarProductoVentaGeneral().addKeyListener(buscarProducto);
        vistaVen.getTxtBuscarCedula().addKeyListener(cedulaCliente);
    }

    private void CacelarVistaDialogoPrincipal() {
        vistaVen.getDialogoVentaPrincipal().dispose();
    }

    private void DialogoDemasProductos() {
        vistaVen.getDialogoVentaPrincipal().setVisible(true);
        vistaVen.getDialogoVentaPrincipal().setLocation(10, 10);
        vistaVen.getDialogoVentaPrincipal().setSize(600, 400);

    }

    private void CargarProductoDiferente() {
        vistaVen.getTablaProductoPrincipalV().setDefaultRenderer(Object.class, new ImagenTable());
        vistaVen.getTablaProductoPrincipalV().setRowHeight(100);
        DefaultTableModel tbGeneralProducto = (DefaultTableModel) vistaVen.getTablaProductoPrincipalV().getModel();
        tbGeneralProducto.setNumRows(0);
        List<ModeloVenta> listaproductoG = modVenta.CargarProductoDiferenteCad();
        Holder<Integer> i = new Holder<>(0);
        listaproductoG.stream().forEach(pr -> {
            tbGeneralProducto.addRow(new Object[5]);
            vistaVen.getTablaProductoPrincipalV().setValueAt(pr.getId_producto(), i.value, 0);
            vistaVen.getTablaProductoPrincipalV().setValueAt(pr.getNombre(), i.value, 1);
            vistaVen.getTablaProductoPrincipalV().setValueAt(pr.getPrecio(), i.value, 2);
            vistaVen.getTablaProductoPrincipalV().setValueAt(pr.getCantidad(), i.value, 3);
            Image foto = pr.getFoto();
            if (foto != null) {
                Image nimg = foto.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                ImageIcon icono = new ImageIcon(nimg);
                DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
                renderer.setIcon(icono);
                vistaVen.getTablaProductoPrincipalV().setValueAt(new JLabel(icono), i.value, 4);
            } else {
                vistaVen.getTablaProductoPrincipalV().setValueAt(null, i.value, 4);
            }
            i.value++;
        });
    }

    private void CargarProductoBusqueda_Dif(String productoBus) {
        vistaVen.getTablaProductoPrincipalV().setDefaultRenderer(Object.class, new ImagenTable());
        vistaVen.getTablaProductoPrincipalV().setRowHeight(100);
        DefaultTableModel tbGeneralProducto = (DefaultTableModel) vistaVen.getTablaProductoPrincipalV().getModel();
        tbGeneralProducto.setNumRows(0);
        List<ModeloVenta> listaproducto = modVenta.CargarProductoDiferente(productoBus);
        Holder<Integer> i = new Holder<>(0);
        listaproducto.stream().forEach(pr -> {
            tbGeneralProducto.addRow(new Object[5]);
            vistaVen.getTablaProductoPrincipalV().setValueAt(pr.getId_producto(), i.value, 0);
            vistaVen.getTablaProductoPrincipalV().setValueAt(pr.getNombre(), i.value, 1);
            vistaVen.getTablaProductoPrincipalV().setValueAt(pr.getPrecio(), i.value, 2);
            vistaVen.getTablaProductoPrincipalV().setValueAt(pr.getCantidad(), i.value, 3);
            Image foto = pr.getFoto();
            if (foto != null) {
                Image nimg = foto.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                ImageIcon icono = new ImageIcon(nimg);
                DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
                renderer.setIcon(icono);
                vistaVen.getTablaProductoPrincipalV().setValueAt(new JLabel(icono), i.value, 4);
            } else {
                vistaVen.getTablaProductoPrincipalV().setValueAt(null, i.value, 4);
            }
            i.value++;
        });
    }

    private void AceptarProductoDiferente() {
        int i = vistaVen.getTablaProductoPrincipalV().getSelectedRow();
        if (i != -1) {
            if (vistaVen.getSpinerCantidadPrincipalV().getValue().toString().equals("0")) {
                JOptionPane.showMessageDialog(vistaVen, "Debe seleccionar la cantidad", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                int cantidadStock = Integer.parseInt(vistaVen.getTablaProductoPrincipalV().getValueAt(i, 3).toString());
                int Despacho = Integer.parseInt(vistaVen.getSpinerCantidadPrincipalV().getValue().toString());
                if (Despacho > cantidadStock) {
                    JOptionPane.showMessageDialog(vistaVen, "Error usted no puede seleccionar un numero mayor al stock.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    vistaVen.getTxtIdProductoVen().setText(vistaVen.getTablaProductoPrincipalV().getValueAt(i, 0).toString());
                    vistaVen.getTxtNombreProductoVenta().setText(vistaVen.getTablaProductoPrincipalV().getValueAt(i, 1).toString());
                    vistaVen.getTxtPrecioVen().setText(vistaVen.getTablaProductoPrincipalV().getValueAt(i, 2).toString());
                    vistaVen.getTxtCantidadVen().setText(vistaVen.getSpinerCantidadPrincipalV().getValue().toString());
                    calcularTotalProducto();
                    vistaVen.getSpinerCantidadPrincipalV().setValue(Integer.parseInt("0"));
                    vistaVen.getDialogoVentaPrincipal().dispose();
                }
            }
        } else {
            JOptionPane.showMessageDialog(vistafruta, "Debe seleccione el elemento de la tabla, por favor.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void ControlEnvioDetalle_Y_Factura() {
        vistaVen.getBtnGenerarfacturaV().addActionListener(l -> GeneroDetalle_Y_Factura());
    }

    //Llenado de tablas en la bda de datos detalle factura y factura.-----------------------------------
    private void GeneroDetalle_Y_Factura() {
        GenerarFactura();
        GenerarDetalleFactura();
        DescargarProductos();
        IngrementoIDFacuraBD();
//        GeneroFacturaParaCliente();
        LipiarArray();
        limpiarDatosViVenta();
        JOptionPane.showMessageDialog(vistaVen, "La factura a sido generada satisfactoriamente. :)");
        
        //FinFacturaCargaNuevosNumerosProductos();
        vistaVen.getTxtCantidadVen().setEditable(false);
        vistaVen.getBtnGenerarfacturaV().setEnabled(false);
        vistaVen.getBtnCancelarFacturaTotalVen().setEnabled(false);
        vistaVen.getBtnEliminarProdcutoFacturaVen().setEnabled(false);
    }

//    private void GeneroFacturaParaCliente() {
//        JasperReport jr;
//        ConectionPg cp = new ConectionPg();
//        try {
//            jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/Vista/Reportes/Factu.jasper"));
//            Map<String, Object> map = new HashMap<String, Object>();
//            for (int i = 0; i < listaVenta.size(); i++) {
//                //map.put("LogoG", "milLogo.jpg");
//                map.put("Cantidad", listaVenta.get(i).getCantidad());
//                map.put("Precio", listaVenta.get(i).getPrecio());
//                map.put("Producto", listaVenta.get(i).getNombreProducto());
//                map.put("Total", listaVenta.get(i).getTotal());
//            }
//            JasperPrint jp = JasperFillManager.fillReport(jr, map,cp.getCon());
//            JasperViewer jv = new JasperViewer(jp, false);
//            jv.setVisible(true);
//        } catch (JRException ex) {
//            Logger.getLogger(ControlVenta.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }

    //Lipio de array----------------------------------------------
    private void LipiarArray() {
        listaVenta.clear();
        listaDetalle.clear();
        CargarDatosFactura();
        LimpiarDatosVistaVenta();
    }

    //Limpiar todo los datos en la vista de ventas-------------------------------------
    private void LimpiarDatosVistaVenta() {
        vistaVen.getTxtSubtotalVen().setText("");
        vistaVen.getTxtIVAVen().setText("");
        vistaVen.getTxtTotalPagarven().setText("");
        vistaVen.getTxtBuscarCedula().setText("");
        vistaVen.getTxtNombresVen().setText("");
        vistaVen.getLblFotoClienteBusqueda().setIcon(null);
        vistaVen.getTxtBuscarCedula().setEditable(true);
    }

    public void ValidoFacDetalle() {
        ValidarDatosFruta();

    }

    private void ControlBotonVFruta() {
        vistafruta.getBtnPapaya().addActionListener(l -> DialogoFrutas("Papaya"));
        vistafruta.getBtnSandia().addActionListener(l -> DialogoFrutas("Sandia"));
        vistafruta.getBtnNaranja().addActionListener(l -> DialogoFrutas("Naranja"));
        vistafruta.getBtnMandarina().addActionListener(l -> DialogoFrutas("Mandarina"));
        vistafruta.getBtnAceptarPF().addActionListener(l -> AceptarF());
        vistafruta.getBtnCancelarPF().addActionListener(l -> CancelarF());
    }

    private void DialogoFrutas(String nombre) {
        if (nombre.equals("Papaya")) {
            CargarProducto("Papaya");
            vistafruta.getDialogoProductosF().setVisible(true);
            vistafruta.getDialogoProductosF().setLocation(10, 10);
            vistafruta.getDialogoProductosF().setSize(600, 400);
        } else if (nombre.equals("Sandia")) {
            CargarProducto("Sandia");
            vistafruta.getDialogoProductosF().setVisible(true);
            vistafruta.getDialogoProductosF().setLocation(10, 10);
            vistafruta.getDialogoProductosF().setSize(600, 400);
        } else if (nombre.equals("Naranja")) {
            CargarProducto("Naranja");
            vistafruta.getDialogoProductosF().setVisible(true);
            vistafruta.getDialogoProductosF().setLocation(10, 10);
            vistafruta.getDialogoProductosF().setSize(600, 400);
        } else if (nombre.equals("Mandarina")) {
            CargarProducto("Mandarina");
            vistafruta.getDialogoProductosF().setVisible(true);
            vistafruta.getDialogoProductosF().setLocation(10, 10);
            vistafruta.getDialogoProductosF().setSize(600, 400);
        }

    }

    private void AceptarF() {
        int i = vistafruta.getTablaProductoFru().getSelectedRow();
        if (i != -1) {
            if (vistafruta.getSpinerCantidadFruta().getValue().toString().equals("0")) {
                JOptionPane.showMessageDialog(vistafruta, "Debe seleccionar la cantidad", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                int cantidadStock = Integer.parseInt(vistafruta.getTablaProductoFru().getValueAt(i, 3).toString());
                int Despacho = Integer.parseInt(vistafruta.getSpinerCantidadFruta().getValue().toString());
                if (Despacho > cantidadStock) {
                    JOptionPane.showMessageDialog(vistafruta, "Error usted no puede seleccionar un numero mayor al stock.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    vistaVen.getTxtIdProductoVen().setText(vistafruta.getTablaProductoFru().getValueAt(i, 0).toString());
                    vistaVen.getTxtNombreProductoVenta().setText(vistafruta.getTablaProductoFru().getValueAt(i, 1).toString());
                    vistaVen.getTxtPrecioVen().setText(vistafruta.getTablaProductoFru().getValueAt(i, 2).toString());
                    vistaVen.getTxtCantidadVen().setText(vistafruta.getSpinerCantidadFruta().getValue().toString());
                    calcularTotalProducto();
                    vistafruta.getSpinerCantidadFruta().setValue(Integer.parseInt("0"));
                    vistafruta.getDialogoProductosF().dispose();
                }
            }
        } else {
            JOptionPane.showMessageDialog(vistafruta, "Debe seleccione el elemento de la tabla, por favor.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    //Calcula el total depues de la vista frura.----------------------------------------------------
    private void calcularTotalProducto() {
        int cantidad = 0;
        cantidad = Integer.parseInt(vistaVen.getTxtCantidadVen().getText());
        Double precio = Double.parseDouble(vistaVen.getTxtPrecioVen().getText());
        Double total = precio * cantidad;
        vistaVen.getTxtTotalVen().setText(String.valueOf(total));
    }

    //Calculat todo para estar listo a la bd-----------------------------------------------------------------------------
    public void CalcularTotalPagar() {
        DecimalFormatSymbols numeroSeparacion = new DecimalFormatSymbols();
        numeroSeparacion.setDecimalSeparator('.');
        DecimalFormat formatoprecio = new DecimalFormat("#.00", numeroSeparacion);
        double subtotal = 0;
        double iva = 0.12;
        double auxtotal = 0;
        double totalPagar = 0;
        for (int i = 0; i < listaVenta.size(); i++) {
            subtotal = subtotal + listaVenta.get(i).getTotal();
        }
        auxtotal = subtotal * iva;
        totalPagar = subtotal + auxtotal;
        vistaVen.getTxtSubtotalVen().setText(formatoprecio.format(subtotal));
        vistaVen.getTxtIVAVen().setText(formatoprecio.format(auxtotal));
        vistaVen.getTxtTotalPagarven().setText(formatoprecio.format(totalPagar));
    }

    private void CancelarF() {
        vistafruta.getDialogoProductosF().dispose();
    }

    //Cargar el dialogo con la el tipo o seccion de producto.
    private void CargarProducto(String seccion) {
        vistafruta.getTablaProductoFru().setDefaultRenderer(Object.class, new ImagenTable());
        vistafruta.getTablaProductoFru().setRowHeight(100);
        DefaultTableModel tbfruta = (DefaultTableModel) vistafruta.getTablaProductoFru().getModel();
        tbfruta.setNumRows(0);
        List<ModeloVenta> listafruta = modVenta.CargarPro(seccion);
        Holder<Integer> i = new Holder<>(0);
        listafruta.stream().forEach(pr -> {
            tbfruta.addRow(new Object[5]);
            vistafruta.getTablaProductoFru().setValueAt(pr.getId_producto(), i.value, 0);
            vistafruta.getTablaProductoFru().setValueAt(pr.getNombre(), i.value, 1);
            vistafruta.getTablaProductoFru().setValueAt(pr.getPrecio(), i.value, 2);
            vistafruta.getTablaProductoFru().setValueAt(pr.getCantidad(), i.value, 3);
            Image foto = pr.getFoto();
            if (foto != null) {
                Image nimg = foto.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                ImageIcon icono = new ImageIcon(nimg);
                DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
                renderer.setIcon(icono);
                vistafruta.getTablaProductoFru().setValueAt(new JLabel(icono), i.value, 4);
            } else {
                vistafruta.getTablaProductoFru().setValueAt(null, i.value, 4);
            }
            i.value++;
        });
    }

    private void CargaPanelFrutas() {
        vistafruta.setSize(429, 374);
        vistafruta.setLocation(0, 0);
        vistaVen.getPanelContenedorPro().removeAll();
        vistaVen.getPanelContenedorPro().add(vistafruta, BorderLayout.CENTER);
        vistaVen.getPanelContenedorPro().revalidate();
        vistaVen.getPanelContenedorPro().repaint();
        ControlTotalBotonVistaFruta();

    }

    private void CargaPanelVegetales() {
        vistaVeget.setSize(429, 374);
        vistaVeget.setLocation(0, 0);
        vistaVen.getPanelContenedorPro().removeAll();
        vistaVen.getPanelContenedorPro().add(vistaVeget, BorderLayout.CENTER);
        vistaVen.getPanelContenedorPro().revalidate();
        vistaVen.getPanelContenedorPro().repaint();
        ControlTotalBotonVistaVegetal();
    }

    private void CargaPanelHelados() {
        vistaHelado.setSize(429, 374);
        vistaHelado.setLocation(0, 0);
        vistaVen.getPanelContenedorPro().removeAll();
        vistaVen.getPanelContenedorPro().add(vistaHelado, BorderLayout.CENTER);
        vistaVen.getPanelContenedorPro().revalidate();
        vistaVen.getPanelContenedorPro().repaint();
        ControlTotalBotonVistaHelados();
    }

    private void CargaPanelGeneralProductos() {
        vistageneProdu.setSize(429, 374);
        vistageneProdu.setLocation(0, 0);
        vistaVen.getPanelContenedorPro().removeAll();
        vistaVen.getPanelContenedorPro().add(vistageneProdu, BorderLayout.CENTER);
        vistaVen.getPanelContenedorPro().revalidate();
        vistaVen.getPanelContenedorPro().repaint();
        ControlTotalBotonVistaProductosGenerales();
    }

    //Ingreso de datos a la lista de frutas-Tabla-------------------------------------------------------- 
    private void ValidarDatosFruta() {
        if (vistaVen.getTxtBuscarCedula().getText().isEmpty()) {
            JOptionPane.showMessageDialog(vistaVen, "Por favor usted debe ingresar a un cliente.", "Error cliente.", JOptionPane.WARNING_MESSAGE);
        } else {
            if (vistaVen.getTxtNombresVen().getText().isEmpty() || vistaVen.getTxtIdProductoVen().getText().isEmpty() || vistaVen.getTxtCantidadVen().getText().isEmpty()
                    || vistaVen.getTxtPrecioVen().getText().isEmpty() || vistaVen.getTxtTotalVen().getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaVen, "Debe llenar los campos para guardar el detalle, por favor.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                int idproducto = Integer.parseInt(vistaVen.getTxtIdProductoVen().getText());
                boolean MismoProducto = false;

                for (int i = 0; i < listaVenta.size(); i++) {
                    if (listaVenta.get(i).getId_producto() == idproducto) {
                        MismoProducto = true;
                        break;
                    }
                }
                if (MismoProducto == true) {
                    JOptionPane.showMessageDialog(vistaVen, "Error usted no puede ingresar el mismo producto.", "Error Producto", JOptionPane.ERROR_MESSAGE);
                } else {
                    int idpro = Integer.parseInt(vistaVen.getTxtIdProductoVen().getText());
                    String cedula = vistaVen.getTxtBuscarCedula().getText();
                    String nombrepro = vistaVen.getTxtNombreProductoVenta().getText();
                    double precioP = Double.parseDouble(vistaVen.getTxtPrecioVen().getText());
                    int cantidadP = Integer.parseInt(vistaVen.getTxtCantidadVen().getText());
                    double total = Double.parseDouble(vistaVen.getTxtTotalVen().getText());
                    ModeloVenta modelo = new ModeloVenta(idpro, nombrepro, precioP, cantidadP, cedula, total);
                    listaVenta.add(modelo);
                    CargarDatosFactura();
                    CalcularTotalPagar();
                    ValidarDetalleFactura();
                    vistaVen.getTxtBuscarCedula().setEditable(false);
                    vistaVen.getBtnGenerarfacturaV().setEnabled(true);
                    vistaVen.getBtnCancelarFacturaTotalVen().setEnabled(true);
                    vistaVen.getBtnEliminarProdcutoFacturaVen().setEnabled(true);
                    limpiarDatosViVenta();//Holaaaaaa
                }
            }
        }
    }

    //Ingreso de los datos al array de detalle factura--------------------------------------------------------------
    private void ValidarDetalleFactura() {
        if (vistaVen.getTxtIDfacturaIncremento().getText().isEmpty() || vistaVen.getTxtIdProductoVen().getText().isEmpty() || vistaVen.getTxtCantidadVen().getText().isEmpty()
                || vistaVen.getTxtPrecioVen().getText().isEmpty() || vistaVen.getTxtTotalVen().getText().isEmpty()) {
            System.out.println("Error en el detalle de la factura.");
        } else {
            System.out.println("Correto detalle factura");
            ModeloDetalleFactura modDetalle = new ModeloDetalleFactura();
            modDetalle.setIdFactura(Integer.parseInt(vistaVen.getTxtIDfacturaIncremento().getText()));
            modDetalle.setIdProducto(Integer.parseInt(vistaVen.getTxtIdProductoVen().getText()));
            modDetalle.setCantidad(Integer.parseInt(vistaVen.getTxtCantidadVen().getText()));
            modDetalle.setPrecio(Double.parseDouble(vistaVen.getTxtPrecioVen().getText()));
            modDetalle.setTotal(Double.parseDouble(vistaVen.getTxtTotalVen().getText()));
            System.out.println("Total helado" + vistaVen.getTxtTotalVen().getText());
            listaDetalle.add(modDetalle);
            System.out.println("Fin Correto detalle factura");
        }
    }

    private void editarDetalle() {
        vistaVen.getTxtCantidadVen().setEnabled(true);
    }

    //Controlar la edicion de la vista ventas--------------------------------------------------------------------
    private void ControlEdicionBoton() {
        vistaVen.getTxtNombreProductoVenta().setEditable(false);
        vistaVen.getTxtNombresVen().setEditable(false);
        vistaVen.getTxtIdProductoVen().setEditable(false);
        vistaVen.getTxtCantidadVen().setEditable(false);
        vistaVen.getTxtPrecioVen().setEditable(false);
        vistaVen.getTxtTotalVen().setEditable(false);
        vistaVen.getTxtIDfacturaIncremento().setEditable(false);
        vistaVen.getTxtSubtotalVen().setEditable(false);
        vistaVen.getTxtIVAVen().setEditable(false);
        vistaVen.getTxtTotalPagarven().setEditable(false);
        vistaVen.getBtnEditarCantidadProductoVis().setEnabled(false);
        vistaVen.getBtnGenerarfacturaV().setEnabled(false);
        vistaVen.getBtnCancelarFacturaTotalVen().setEnabled(false);
        vistaVen.getBtnEliminarProdcutoFacturaVen().setEnabled(false);

    }

    //Limpiar datos en el panel de Datos..------------------------------------------------------------------------
    private void limpiarDatosViVenta() {
        vistaVen.getTxtNombreProductoVenta().setText("");
        vistaVen.getTxtIdProductoVen().setText("");
        vistaVen.getTxtCantidadVen().setText("");
        vistaVen.getTxtPrecioVen().setText("");
        vistaVen.getTxtTotalVen().setText("");

    }

    private void limpiarDatosT() {
        vistaVen.getTxtNombreProductoVenta().setText("");
        vistaVen.getTxtIdProductoVen().setText("");
        vistaVen.getTxtCantidadVen().setText("");
        vistaVen.getTxtPrecioVen().setText("");
        vistaVen.getTxtTotalVen().setText("");
        vistaVen.getTxtCantidadVen().setEditable(false);
        vistaVen.getBtnGuardarVen().setEnabled(true);
        vistaVen.getBtnEditarCantidadProductoVis().setEnabled(false);
//        vistaVen.getTxtBuscarCedula().setEditable(true);
    }

    private void CargarDatosFactura() {
        DefaultTableModel tbfactura = (DefaultTableModel) vistaVen.getTablaFacturaVenta().getModel();
        tbfactura.setNumRows(0);
        listaVenta.stream().forEach(f -> {
            String[] per = {String.valueOf(f.getId_producto()), f.getCedula(), f.getNombreProducto(), String.valueOf(f.getPrecio()), String.valueOf(f.getCantidad()), String.valueOf(f.getTotal())};
            tbfactura.addRow(per);
        });
    }

    //Buscar nombres del cliente por ceudula-------------------------------------------------------------------------------------------------------
    private void nombresBus(String Cedula) {
        if (Cedula.equals("")) {
            nombres = "";
            vistaVen.getLblFotoClienteBusqueda().setIcon(null);
        } else {
            List<ModeloVenta> listNombre = modVenta.TraerNombre(Cedula);
            for (int i = 0; i < listNombre.size(); i++) {
                if (listNombre.get(i).getCedula().equals(Cedula)) {
                    String nombre = listNombre.get(i).getNombre();
                    String apellido = listNombre.get(i).getApellidos();
                    nombres = nombre + " " + apellido;
                    Image in = listNombre.get(i).getFoto();
                    Image img = in.getScaledInstance(133, 147, java.awt.Image.SCALE_SMOOTH);
                    Icon icono = new ImageIcon(img);
                    vistaVen.getLblFotoClienteBusqueda().setIcon(icono);
                }
            }
        }
        vistaVen.getTxtNombresVen().setText(nombres);
    }

    //Todo sobre panel vegetales----------------------------------------------------------------------------------------------------------------------------------------------
    private void ControlBotonVegetal() {
        vistaVeget.getBtnLechuga().addActionListener(l -> DialogoVegetales("Lechuga"));
        vistaVeget.getBtnTomate().addActionListener(l -> DialogoVegetales("Tomate"));
        vistaVeget.getBtnCebolla().addActionListener(l -> DialogoVegetales("Cebolla"));
        vistaVeget.getBtnBrocoli().addActionListener(l -> DialogoVegetales("Brócoli"));

    }

    private void DialogoVegetales(String nombre) {
        if (nombre.equals("Lechuga")) {
            CargarProducto("Lechuga");
            vistafruta.getDialogoProductosF().setVisible(true);
            vistafruta.getDialogoProductosF().setLocation(10, 10);
            vistafruta.getDialogoProductosF().setSize(600, 400);

        } else if (nombre.equals("Tomate")) {
            CargarProducto("Tomate");
            vistafruta.getDialogoProductosF().setVisible(true);
            vistafruta.getDialogoProductosF().setLocation(10, 10);
            vistafruta.getDialogoProductosF().setSize(600, 400);

        } else if (nombre.equals("Cebolla")) {
            CargarProducto("Cebolla");
            vistafruta.getDialogoProductosF().setVisible(true);
            vistafruta.getDialogoProductosF().setLocation(10, 10);
            vistafruta.getDialogoProductosF().setSize(600, 400);

        } else if (nombre.equals("Brócoli")) {
            CargarProducto("Brócoli");
            vistafruta.getDialogoProductosF().setVisible(true);
            vistafruta.getDialogoProductosF().setLocation(10, 10);
            vistafruta.getDialogoProductosF().setSize(600, 400);
        }

    }

    //Fin del todo panel vegetales--------------------------------------------------------------------------------------------------------------------------------------------
    //Todo sobre panel Helados----------------------------------------------------------------------------------------------------------------------------------------------
    private void ControlBotonHelado() {
        vistaHelado.getBtnHeladoChocolate().addActionListener(l -> DialogoHelados("Chocolate"));
        vistaHelado.getBtnHeladoCoco().addActionListener(l -> DialogoHelados("Coco"));
        vistaHelado.getBtnHeladoNatural().addActionListener(l -> DialogoHelados("Natural"));
        vistaHelado.getBtnHeladoFresa().addActionListener(l -> DialogoHelados("Fresa"));
        vistaHelado.getBtnHeladoVainilla().addActionListener(l -> DialogoHelados("Vainilla"));
    }

    private void DialogoHelados(String nombre) {
        if (nombre.equals("Chocolate")) {
            CargarProducto("Chocolate");
            vistafruta.getDialogoProductosF().setVisible(true);
            vistafruta.getDialogoProductosF().setLocation(10, 10);
            vistafruta.getDialogoProductosF().setSize(600, 400);

        } else if (nombre.equals("Coco")) {
            CargarProducto("Coco");
            vistafruta.getDialogoProductosF().setVisible(true);
            vistafruta.getDialogoProductosF().setLocation(10, 10);
            vistafruta.getDialogoProductosF().setSize(600, 400);

        } else if (nombre.equals("Natural")) {
            CargarProducto("Natural");
            vistafruta.getDialogoProductosF().setVisible(true);
            vistafruta.getDialogoProductosF().setLocation(10, 10);
            vistafruta.getDialogoProductosF().setSize(600, 400);

        } else if (nombre.equals("Fresa")) {
            CargarProducto("Fresa");
            vistafruta.getDialogoProductosF().setVisible(true);
            vistafruta.getDialogoProductosF().setLocation(10, 10);
            vistafruta.getDialogoProductosF().setSize(600, 400);

        } else if (nombre.equals("Vainilla")) {
            CargarProducto("Vainilla");
            vistafruta.getDialogoProductosF().setVisible(true);
            vistafruta.getDialogoProductosF().setLocation(10, 10);
            vistafruta.getDialogoProductosF().setSize(600, 400);
        }

    }
    //Fin del todo panel Helados--------------------------------------------------------------------------------------------------------------------------------------------

    //Todo sobre panel prodcutos varios----------------------------------------------------------------------------------------------------------------------------------------------
    private void ControlBotonProductoGeneralVen() {
        //Botones control seccion colas.
        vistageneProdu.getBtnCocaColaPG().addActionListener(l -> DialogoProductosGenerales("Coca Cola"));
        vistageneProdu.getBtnSpritePG().addActionListener(l -> DialogoProductosGenerales("Sprite"));
        vistageneProdu.getBtnPepsiPG().addActionListener(l -> DialogoProductosGenerales("Pepsi"));
        vistageneProdu.getBtnIncaKolaPG().addActionListener(l -> DialogoProductosGenerales("Inca Kola"));
        vistageneProdu.getBtnFantaPG().addActionListener(l -> DialogoProductosGenerales("Fanta"));

        //Botones control seccion Lactios.
        vistageneProdu.getBtnLechePG().addActionListener(l -> DialogoProductosGenerales("Leche"));
        vistageneProdu.getBtnYogurPG().addActionListener(l -> DialogoProductosGenerales("Yogur"));
        vistageneProdu.getBtnQuesoPG().addActionListener(l -> DialogoProductosGenerales("Queso"));

        //Botones control seccion Trago :).
        vistageneProdu.getBtnVodkaPG().addActionListener(l -> DialogoProductosGenerales("Vodka"));
        vistageneProdu.getBtnTequilaPG().addActionListener(l -> DialogoProductosGenerales("Tequila"));
        vistageneProdu.getBtnRonPG().addActionListener(l -> DialogoProductosGenerales("Ron"));
        vistageneProdu.getBtnWhiskyPG().addActionListener(l -> DialogoProductosGenerales("Whisky"));
        vistageneProdu.getBtnGinebraPG().addActionListener(l -> DialogoProductosGenerales("Ginebra"));
        vistageneProdu.getBtnCoñacPG().addActionListener(l -> DialogoProductosGenerales("Coñac"));
        vistageneProdu.getBtnZhumirPG().addActionListener(l -> DialogoProductosGenerales("ZHUMIR"));

    }

    private void DialogoProductosGenerales(String nombre) {
        if (nombre.equals("Coca Cola")) {
            CargarProducto("Coca Cola");
            vistafruta.getDialogoProductosF().setVisible(true);
            vistafruta.getDialogoProductosF().setLocation(10, 10);
            vistafruta.getDialogoProductosF().setSize(600, 400);

        } else if (nombre.equals("Sprite")) {
            CargarProducto("Sprite");
            vistafruta.getDialogoProductosF().setVisible(true);
            vistafruta.getDialogoProductosF().setLocation(10, 10);
            vistafruta.getDialogoProductosF().setSize(600, 400);

        } else if (nombre.equals("Pepsi")) {
            CargarProducto("Pepsi");
            vistafruta.getDialogoProductosF().setVisible(true);
            vistafruta.getDialogoProductosF().setLocation(10, 10);
            vistafruta.getDialogoProductosF().setSize(600, 400);

        } else if (nombre.equals("Inca Kola")) {
            CargarProducto("Inca Kola");
            vistafruta.getDialogoProductosF().setVisible(true);
            vistafruta.getDialogoProductosF().setLocation(10, 10);
            vistafruta.getDialogoProductosF().setSize(600, 400);

        } else if (nombre.equals("Fanta")) {
            CargarProducto("Fanta");
            vistafruta.getDialogoProductosF().setVisible(true);
            vistafruta.getDialogoProductosF().setLocation(10, 10);
            vistafruta.getDialogoProductosF().setSize(600, 400);
        }//Fin seccion colas
        else if (nombre.equals("Leche")) {
            CargarProducto("Leche");
            vistafruta.getDialogoProductosF().setVisible(true);
            vistafruta.getDialogoProductosF().setLocation(10, 10);
            vistafruta.getDialogoProductosF().setSize(600, 400);
        } else if (nombre.equals("Yogur")) {
            CargarProducto("Yogur");
            vistafruta.getDialogoProductosF().setVisible(true);
            vistafruta.getDialogoProductosF().setLocation(10, 10);
            vistafruta.getDialogoProductosF().setSize(600, 400);
        } else if (nombre.equals("Queso")) {
            CargarProducto("Queso");
            vistafruta.getDialogoProductosF().setVisible(true);
            vistafruta.getDialogoProductosF().setLocation(10, 10);
            vistafruta.getDialogoProductosF().setSize(600, 400);
        }//Fin seccion Lacteos
        else if (nombre.equals("Vodka")) {
            CargarProducto("Vodka");
            vistafruta.getDialogoProductosF().setVisible(true);
            vistafruta.getDialogoProductosF().setLocation(10, 10);
            vistafruta.getDialogoProductosF().setSize(600, 400);
        } else if (nombre.equals("Tequila")) {
            CargarProducto("Tequila");
            vistafruta.getDialogoProductosF().setVisible(true);
            vistafruta.getDialogoProductosF().setLocation(10, 10);
            vistafruta.getDialogoProductosF().setSize(600, 400);
        } else if (nombre.equals("Ron")) {
            CargarProducto("Ron");
            vistafruta.getDialogoProductosF().setVisible(true);
            vistafruta.getDialogoProductosF().setLocation(10, 10);
            vistafruta.getDialogoProductosF().setSize(600, 400);
        } else if (nombre.equals("Whisky")) {
            CargarProducto("Whisky");
            vistafruta.getDialogoProductosF().setVisible(true);
            vistafruta.getDialogoProductosF().setLocation(10, 10);
            vistafruta.getDialogoProductosF().setSize(600, 400);
        } else if (nombre.equals("Ginebra")) {
            CargarProducto("Ginebra");
            vistafruta.getDialogoProductosF().setVisible(true);
            vistafruta.getDialogoProductosF().setLocation(10, 10);
            vistafruta.getDialogoProductosF().setSize(600, 400);
        } else if (nombre.equals("Coñac")) {
            CargarProducto("Coñac");
            vistafruta.getDialogoProductosF().setVisible(true);
            vistafruta.getDialogoProductosF().setLocation(10, 10);
            vistafruta.getDialogoProductosF().setSize(600, 400);
        } else if (nombre.equals("ZHUMIR")) {
            CargarProducto("ZHUMIR");
            vistafruta.getDialogoProductosF().setVisible(true);
            vistafruta.getDialogoProductosF().setLocation(10, 10);
            vistafruta.getDialogoProductosF().setSize(600, 400);
        }
//        else if (nombre.equals("Fanta")) {
//            CargarProducto("Fanta");
//            vistafruta.getDialogoProductosF().setVisible(true);
//            vistafruta.getDialogoProductosF().setLocation(10, 10);
//            vistafruta.getDialogoProductosF().setSize(600, 400);
//        }else if (nombre.equals("Fanta")) {
//            CargarProducto("Fanta");
//            vistafruta.getDialogoProductosF().setVisible(true);
//            vistafruta.getDialogoProductosF().setLocation(10, 10);
//            vistafruta.getDialogoProductosF().setSize(600, 400);
//        }else if (nombre.equals("Fanta")) {
//            CargarProducto("Fanta");
//            vistafruta.getDialogoProductosF().setVisible(true);
//            vistafruta.getDialogoProductosF().setLocation(10, 10);
//            vistafruta.getDialogoProductosF().setSize(600, 400);
//        }

    }
    //Fin del todo panel prodcutos varios--------------------------------------------------------------------------------------------------------------------------------------------

    //Control de la factura-------------------------------------------------------------------------------------------------------
    public void GenerarFactura() {
        System.out.println("confirma");
        ModeloFactura modFac = new ModeloFactura();
        String fechaA = vistaVen.getLblFechaActual().getText();
        System.out.println("" + fechaA);
        Date fechaN = java.sql.Date.valueOf(fechaA);
        modFac.setFecha((java.sql.Date) fechaN);
        modFac.setTotal(Double.parseDouble(vistaVen.getTxtTotalPagarven().getText()));
        modFac.setCedula(vistaVen.getTxtBuscarCedula().getText());
        if (modFac.GenerarFacturaBy()) {
            System.out.println("correcto la factura esta generada");
        } else {
            System.out.println("Error ar crear la factura");
        }
    }

    //Control detalle factura-------------------------------------------------------------------------------------------------------
    public void GenerarDetalleFactura() {
        System.out.println("Entro a detalle factura");
        for (int i = 0; i < listaDetalle.size(); i++) {
            System.out.println("Inicio creacion de objeto detalle");
            ModeloDetalleFactura detalleingreso = new ModeloDetalleFactura();
            detalleingreso.setIdFactura(listaDetalle.get(i).getIdFactura());
            detalleingreso.setIdProducto(listaDetalle.get(i).getIdProducto());
            detalleingreso.setCantidad(listaDetalle.get(i).getCantidad());
            detalleingreso.setPrecio(listaDetalle.get(i).getPrecio());
            detalleingreso.setTotal(listaDetalle.get(i).getTotal());
            System.out.println("Fin creacion de detalle");
            if (detalleingreso.GenerarDetalleFacturaBy()) {
                System.out.println("Correcto el detalle factura esta generada");
            } else {
                System.out.println("Error al generar detalle factura");
            }

        }
    }

    //Descargar los productos para su actualización en la base de datos.------------------------------------------
    private void DescargarProductos() {
        System.out.println("Ingreso a descargar productos");
        List<ModeloVenta> CantidadPro = modVenta.TraerProductoDespacho();
        for (int i = 0; i < listaDetalle.size(); i++) {
            System.out.println("Ingreso al primer for descarga");
            for (int j = 0; j < CantidadPro.size(); j++) {
                System.out.println("Ingreso al segundo for descarga");
                int idbase = listaDetalle.get(i).getIdProducto();
                System.out.println("lista base->" + idbase);
                int BasedatosPro = CantidadPro.get(j).getId_producto();
                System.out.println("lista bd2->" + BasedatosPro);
                if (idbase == BasedatosPro) {
                    System.out.println("Ingreso al id de descarga");
                    ModeloVenta ModventaDescarga = new ModeloVenta();
                    int cantidadDesDetalle = listaDetalle.get(i).getCantidad();
                    int catidadActual = CantidadPro.get(j).getCantidad();
                    int NuevaCantidad = catidadActual - cantidadDesDetalle;
                    int idproducto = listaDetalle.get(i).getIdProducto();
                    ModventaDescarga.setId_producto(idproducto);
                    ModventaDescarga.setCantidad(NuevaCantidad);
                    if (ModventaDescarga.ModificarProductoStock()) {
                        System.out.println("Correcto despacho de productos");
                    } else {
                        System.out.println("Error al descargar los productos.");
                    }
                }
            }
        }
    }

    //Control total de los botones de la vista frutas---------------
    private void ControlTotalBotonVistaFruta() {
        List<ModeloVenta> controlesL = modVenta.TraerProductoDespacho();
        System.out.println("Infreso al metodo");
        for (int i = 0; i < controlesL.size(); i++) {
            if (controlesL.get(i).getNombre().equals(vistafruta.getBtnPapaya().getText())) {
                int cantidad = controlesL.get(i).getCantidad();
                if (cantidad == 0) {
                    vistafruta.getBtnPapaya().setEnabled(false);
                    break;
                } else {
                    vistafruta.getBtnPapaya().setEnabled(true);
                    break;
                }
            } else {
                vistafruta.getBtnPapaya().setEnabled(false);
            }
        }

        for (int i = 0; i < controlesL.size(); i++) {
            if (controlesL.get(i).getNombre().equals(vistafruta.getBtnSandia().getText())) {
                int cantidad = controlesL.get(i).getCantidad();
                if (cantidad == 0) {
                    vistafruta.getBtnSandia().setEnabled(false);
                    break;
                } else {
                    vistafruta.getBtnSandia().setEnabled(true);
                    break;
                }
            } else {
                vistafruta.getBtnSandia().setEnabled(false);
            }

        }

        for (int i = 0; i < controlesL.size(); i++) {
            if (controlesL.get(i).getNombre().equals(vistafruta.getBtnNaranja().getText())) {
                int cantidad = controlesL.get(i).getCantidad();
                if (cantidad == 0) {
                    vistafruta.getBtnNaranja().setEnabled(false);
                    break;
                } else {
                    vistafruta.getBtnNaranja().setEnabled(true);
                    break;
                }
            } else {
                vistafruta.getBtnNaranja().setEnabled(false);
            }

        }

        for (int i = 0; i < controlesL.size(); i++) {
            if (controlesL.get(i).getNombre().equals(vistafruta.getBtnMandarina().getText())) {
                int cantidad = controlesL.get(i).getCantidad();
                if (cantidad == 0) {
                    vistafruta.getBtnMandarina().setEnabled(false);
                    break;
                } else {
                    vistafruta.getBtnMandarina().setEnabled(true);
                    break;
                }
            } else {
                vistafruta.getBtnMandarina().setEnabled(false);
            }

        }
    }

    //Contro total de los botones de la vista Vegetales---------------------
    private void ControlTotalBotonVistaVegetal() {
        List<ModeloVenta> controlesL = modVenta.TraerProductoDespacho();
        System.out.println("Infreso al metodo");
        for (int i = 0; i < controlesL.size(); i++) {
            if (controlesL.get(i).getNombre().equals(vistaVeget.getBtnLechuga().getText())) {
                int cantidad = controlesL.get(i).getCantidad();
                if (cantidad == 0) {
                    vistaVeget.getBtnLechuga().setEnabled(false);
                    break;
                } else {
                    vistaVeget.getBtnLechuga().setEnabled(true);
                    break;
                }
            } else {
                vistaVeget.getBtnLechuga().setEnabled(false);
            }

        }

        for (int i = 0; i < controlesL.size(); i++) {
            if (controlesL.get(i).getNombre().equals(vistaVeget.getBtnTomate().getText())) {
                int cantidad = controlesL.get(i).getCantidad();
                if (cantidad == 0) {
                    vistaVeget.getBtnTomate().setEnabled(false);
                    break;
                } else {
                    vistaVeget.getBtnTomate().setEnabled(true);
                    break;
                }
            } else {
                vistaVeget.getBtnTomate().setEnabled(false);
            }

        }

        for (int i = 0; i < controlesL.size(); i++) {
            if (controlesL.get(i).getNombre().equals(vistaVeget.getBtnCebolla().getText())) {
                int cantidad = controlesL.get(i).getCantidad();
                if (cantidad == 0) {
                    vistaVeget.getBtnCebolla().setEnabled(false);
                    break;
                } else {
                    vistaVeget.getBtnCebolla().setEnabled(true);
                    break;
                }
            } else {
                vistaVeget.getBtnCebolla().setEnabled(false);
            }
        }

        for (int i = 0; i < controlesL.size(); i++) {
            if (controlesL.get(i).getNombre().equals(vistaVeget.getBtnBrocoli().getText())) {
                int cantidad = controlesL.get(i).getCantidad();
                if (cantidad == 0) {
                    vistaVeget.getBtnBrocoli().setEnabled(false);
                    break;
                } else {
                    vistaVeget.getBtnBrocoli().setEnabled(true);
                    break;
                }
            } else {
                vistaVeget.getBtnBrocoli().setEnabled(false);
            }
        }
    }

    //Control de la vista helados----------------------------------------
    private void ControlTotalBotonVistaHelados() {
        List<ModeloVenta> controlesL = modVenta.TraerProductoDespacho();
        System.out.println("Ingreso al metodo control helados");
        for (int i = 0; i < controlesL.size(); i++) {
            if (controlesL.get(i).getNombre().equals(vistaHelado.getBtnHeladoChocolate().getText())) {
                int cantidad = controlesL.get(i).getCantidad();
                if (cantidad == 0) {
                    vistaHelado.getBtnHeladoChocolate().setEnabled(false);
                    break;
                } else {
                    vistaHelado.getBtnHeladoChocolate().setEnabled(true);
                    break;
                }
            } else {
                vistaHelado.getBtnHeladoChocolate().setEnabled(false);
            }
        }

        for (int i = 0; i < controlesL.size(); i++) {
            if (controlesL.get(i).getNombre().equals(vistaHelado.getBtnHeladoCoco().getText())) {
                int cantidad = controlesL.get(i).getCantidad();
                if (cantidad == 0) {
                    vistaHelado.getBtnHeladoCoco().setEnabled(false);
                    break;
                } else {
                    vistaHelado.getBtnHeladoCoco().setEnabled(true);
                    break;
                }
            } else {
                vistaHelado.getBtnHeladoCoco().setEnabled(false);
            }
        }

        for (int i = 0; i < controlesL.size(); i++) {
            if (controlesL.get(i).getNombre().equals(vistaHelado.getBtnHeladoNatural().getText())) {
                int cantidad = controlesL.get(i).getCantidad();
                if (cantidad == 0) {
                    vistaHelado.getBtnHeladoNatural().setEnabled(false);
                    break;
                } else {
                    vistaHelado.getBtnHeladoNatural().setEnabled(true);
                    break;
                }
            } else {
                vistaHelado.getBtnHeladoNatural().setEnabled(false);
            }
        }

        for (int i = 0; i < controlesL.size(); i++) {
            if (controlesL.get(i).getNombre().equals(vistaHelado.getBtnHeladoFresa().getText())) {
                int cantidad = controlesL.get(i).getCantidad();
                if (cantidad == 0) {
                    vistaHelado.getBtnHeladoFresa().setEnabled(false);
                    break;
                } else {
                    vistaHelado.getBtnHeladoFresa().setEnabled(true);
                    break;
                }
            } else {
                vistaHelado.getBtnHeladoFresa().setEnabled(false);
            }
        }

        for (int i = 0; i < controlesL.size(); i++) {
            if (controlesL.get(i).getNombre().equals(vistaHelado.getBtnHeladoVainilla().getText())) {
                int cantidad = controlesL.get(i).getCantidad();
                if (cantidad == 0) {
                    vistaHelado.getBtnHeladoVainilla().setEnabled(false);
                    break;
                } else {
                    vistaHelado.getBtnHeladoVainilla().setEnabled(true);
                    break;
                }
            } else {
                vistaHelado.getBtnHeladoVainilla().setEnabled(false);
            }
        }
    }

    private void EditarCantidadProducto() {
        if (vistaVen.getTxtCantidadVen().getText().equals("")) {
            JOptionPane.showMessageDialog(vistaVen, "Por favor debe ingresar una cantidad, caso contrario aplaste el botón de Cancelar.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            int idProductoED = Integer.parseInt(vistaVen.getTxtIdProductoVen().getText());
            int cantidadProED = Integer.parseInt(vistaVen.getTxtCantidadVen().getText());
            List<ModeloVenta> listaDescarga = modVenta.TraerProductoDespacho();
            int cantidadBD = 0;
            for (int i = 0; i < listaDescarga.size(); i++) {
                if (listaDescarga.get(i).getId_producto() == idProductoED) {
                    cantidadBD = listaDescarga.get(i).getCantidad();
                    break;
                }
            }
            if (cantidadProED > cantidadBD) {
                JOptionPane.showMessageDialog(vistaVen, "Error usted no puede despachar la cantidad mayor al Stock, En Strock hay: ( " + cantidadBD + " )", "Error Despacho", JOptionPane.ERROR_MESSAGE);
            } else {
                //Onfire
                System.out.println("Onfire");
                for (int i = 0; i < listaVenta.size(); i++) {
                    if (listaVenta.get(i).getId_producto() == idProductoED) {
                        listaVenta.get(i).setCantidad(cantidadProED);
                        listaVenta.get(i).setTotal(Double.parseDouble(vistaVen.getTxtTotalVen().getText()));
                        System.out.println("Paso");
                    }
                }
                for (int i = 0; i < listaDetalle.size(); i++) {
                    if (listaDetalle.get(i).getIdProducto() == idProductoED) {
                        listaDetalle.get(i).setCantidad(cantidadProED);
                        listaDetalle.get(i).setTotal(Double.parseDouble(vistaVen.getTxtTotalVen().getText()));
                    }
                }
                //Correcta modifcasion del array :)
                System.out.println("Belleza");
                for (int i = 0; i < listaDetalle.size(); i++) {
                    System.out.println("->" + listaDetalle.get(i).getIdProducto() + " | " + listaDetalle.get(i).getCantidad() + " | " + listaDetalle.get(i).getTotal());
                }
                CargarDatosFactura();
                System.out.println("Nueva edicion control total");
                CalcularTotalPagar();//Confirmar si vale
                vistaVen.getTxtCantidadVen().setEditable(false);
                vistaVen.getBtnGuardarVen().setEnabled(true);
                vistaVen.getBtnEditarCantidadProductoVis().setEnabled(false);
                limpiarDatosViVenta();
            }
        }
    }

    private void EliminarRegistroTBDetalleFactura() {
        System.out.println("Entro al registro eliminar.");
        int elimina = vistaVen.getTablaFacturaVenta().getSelectedRow();
        for (int i = 0; i < listaDetalle.size(); i++) {
            System.out.println("->AEL " + listaDetalle.get(i).toString());
        }
        if (elimina != -1) {

            System.out.println("Entro en elimina");
            int codigoID = Integer.parseInt(vistaVen.getTablaFacturaVenta().getValueAt(elimina, 0).toString());
            System.out.println("Codigo de eliminar -> " + codigoID);
            listaVenta.remove(elimina);
            listaDetalle.remove(elimina);
            CalcularTotalPagar();
            CargarDatosFactura();
            vistaVen.getBtnGuardarVen().setEnabled(true);
            vistaVen.getTxtCantidadVen().setEditable(false);
            limpiarDatosViVenta();

        } else {
            JOptionPane.showMessageDialog(vistaVen, "Error debe seleccionar una fila");
        }
    }

    private void CancelarFacturaTot() {
        int conf = JOptionPane.showConfirmDialog(vistaVen, "¿Está seguro que desea cancelar la factura? ", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (conf == JOptionPane.YES_OPTION) {
            LipiarArray();
            LimpiarDatosVistaVenta();
            vistaVen.getBtnGenerarfacturaV().setEnabled(false);
            vistaVen.getBtnCancelarFacturaTotalVen().setEnabled(false);
            vistaVen.getBtnEliminarProdcutoFacturaVen().setEnabled(false);
        }
        if (conf == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(vistaVen, "La acción esta cancelada.", "Cancelar", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void Ev() {
        MouseListener m = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = vistaVen.getTablaFacturaVenta().getSelectedRow();
                if (i != -1) {
                    vistaVen.getTxtIdProductoVen().setText(vistaVen.getTablaFacturaVenta().getValueAt(i, 0).toString());
                    vistaVen.getTxtNombreProductoVenta().setText(vistaVen.getTablaFacturaVenta().getValueAt(i, 2).toString());
                    vistaVen.getTxtPrecioVen().setText(vistaVen.getTablaFacturaVenta().getValueAt(i, 3).toString());
                    vistaVen.getTxtCantidadVen().setText(vistaVen.getTablaFacturaVenta().getValueAt(i, 4).toString());
                    vistaVen.getTxtTotalVen().setText(vistaVen.getTablaFacturaVenta().getValueAt(i, 5).toString());
                    vistaVen.getTxtCantidadVen().setEditable(true);
                    vistaVen.getBtnEditarCantidadProductoVis().setEnabled(true);
                    vistaVen.getBtnGuardarVen().setEnabled(false);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        };
        KeyListener can = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

                char c = e.getKeyChar();
                if (c < '0' || c > '9') {
                    e.consume();
                }
                if (Character.isLetter(c)) {
                    e.consume();
                    JOptionPane.showMessageDialog(vistaVen, "Por favor, debe ingresar solo números en la cantidad.", "Numero de teléfono.", JOptionPane.WARNING_MESSAGE);
                }

                char va  = e.getKeyChar();
                if (va  == '0') {
                    JOptionPane.showMessageDialog(vistaVen, "Usted no puede ingresar la cantidad de 0.", "Error", JOptionPane.WARNING_MESSAGE);
                    e.consume();
                }
//                if (vistaVen.getTxtCantidadVen().getText().length() == 10) {
//                    e.consume();
//                    JOptionPane.showMessageDialog(vistaVen, "Ya están los 10 números de teléfono.", "Numero de dígitos.", JOptionPane.ERROR_MESSAGE);
//                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (vistaVen.getTxtCantidadVen().getText().equals("0")) {
                    e.consume();
                }
                if (vistaVen.getTxtCantidadVen().getText().equals("")) {

                } else {
                    calcularTotalProducto();

                }
            }
        };
        vistaVen.getTablaFacturaVenta().addMouseListener(m);
        vistaVen.getTxtCantidadVen().addKeyListener(can);
    }

    private void ControlTotalBotonVistaProductosGenerales() {
        List<ModeloVenta> listaproducto = modVenta.TraerProductoDespacho();
        for (int i = 0; i < listaproducto.size(); i++) {
            if (listaproducto.get(i).getNombre().equals(vistageneProdu.getBtnCocaColaPG().getText())) {
                int cantidad = listaproducto.get(i).getCantidad();
                if (cantidad == 0) {
                    vistageneProdu.getBtnCocaColaPG().setEnabled(false);
                    break;
                } else {
                    vistageneProdu.getBtnCocaColaPG().setEnabled(true);
                    break;
                }
            } else {
                vistageneProdu.getBtnCocaColaPG().setEnabled(false);
            }

        }
        for (int i = 0; i < listaproducto.size(); i++) {
            if (listaproducto.get(i).getNombre().equals(vistageneProdu.getBtnSpritePG().getText())) {
                int cantidad = listaproducto.get(i).getCantidad();
                if (cantidad == 0) {
                    vistageneProdu.getBtnSpritePG().setEnabled(false);
                    break;
                } else {
                    vistageneProdu.getBtnSpritePG().setEnabled(true);
                    break;
                }
            } else {
                vistageneProdu.getBtnSpritePG().setEnabled(false);
            }
        }
        for (int i = 0; i < listaproducto.size(); i++) {
            if (listaproducto.get(i).getNombre().equals(vistageneProdu.getBtnPepsiPG().getText())) {
                int cantidad = listaproducto.get(i).getCantidad();
                if (cantidad == 0) {
                    vistageneProdu.getBtnPepsiPG().setEnabled(false);
                    break;
                } else {
                    vistageneProdu.getBtnPepsiPG().setEnabled(true);
                    break;
                }
            } else {
                vistageneProdu.getBtnPepsiPG().setEnabled(false);
            }
        }
        for (int i = 0; i < listaproducto.size(); i++) {
            if (listaproducto.get(i).getNombre().equals(vistageneProdu.getBtnIncaKolaPG().getText())) {
                int cantidad = listaproducto.get(i).getCantidad();
                if (cantidad == 0) {
                    vistageneProdu.getBtnIncaKolaPG().setEnabled(false);
                    break;
                } else {
                    vistageneProdu.getBtnIncaKolaPG().setEnabled(true);
                    break;
                }
            } else {
                vistageneProdu.getBtnIncaKolaPG().setEnabled(false);
            }
        }
        for (int i = 0; i < listaproducto.size(); i++) {
            if (listaproducto.get(i).getNombre().equals(vistageneProdu.getBtnFantaPG().getText())) {
                int cantidad = listaproducto.get(i).getCantidad();
                if (cantidad == 0) {
                    vistageneProdu.getBtnFantaPG().setEnabled(false);
                    break;
                } else {
                    vistageneProdu.getBtnFantaPG().setEnabled(true);
                    break;
                }
            } else {
                vistageneProdu.getBtnFantaPG().setEnabled(false);
            }
        }
        for (int i = 0; i < listaproducto.size(); i++) {
            if (listaproducto.get(i).getNombre().equals(vistageneProdu.getBtnLechePG().getText())) {
                int cantidad = listaproducto.get(i).getCantidad();
                if (cantidad == 0) {
                    vistageneProdu.getBtnLechePG().setEnabled(false);
                    break;
                } else {
                    vistageneProdu.getBtnLechePG().setEnabled(true);
                    break;
                }
            } else {
                vistageneProdu.getBtnLechePG().setEnabled(false);
            }
        }
        for (int i = 0; i < listaproducto.size(); i++) {
            if (listaproducto.get(i).getNombre().equals(vistageneProdu.getBtnYogurPG().getText())) {
                int cantidad = listaproducto.get(i).getCantidad();
                if (cantidad == 0) {
                    vistageneProdu.getBtnYogurPG().setEnabled(false);
                    break;
                } else {
                    vistageneProdu.getBtnYogurPG().setEnabled(true);
                    break;
                }
            } else {
                vistageneProdu.getBtnYogurPG().setEnabled(false);
            }
        }
        for (int i = 0; i < listaproducto.size(); i++) {
            if (listaproducto.get(i).getNombre().equals(vistageneProdu.getBtnQuesoPG().getText())) {
                int cantidad = listaproducto.get(i).getCantidad();
                if (cantidad == 0) {
                    vistageneProdu.getBtnQuesoPG().setEnabled(false);
                    break;
                } else {
                    vistageneProdu.getBtnQuesoPG().setEnabled(true);
                    break;
                }
            } else {
                vistageneProdu.getBtnQuesoPG().setEnabled(false);
            }
        }
        for (int i = 0; i < listaproducto.size(); i++) {
            if (listaproducto.get(i).getNombre().equals(vistageneProdu.getBtnVodkaPG().getText())) {
                int cantidad = listaproducto.get(i).getCantidad();
                if (cantidad == 0) {
                    vistageneProdu.getBtnVodkaPG().setEnabled(false);
                    break;
                } else {
                    vistageneProdu.getBtnVodkaPG().setEnabled(true);
                    break;
                }
            } else {
                vistageneProdu.getBtnVodkaPG().setEnabled(false);
            }
        }
        for (int i = 0; i < listaproducto.size(); i++) {
            if (listaproducto.get(i).getNombre().equals(vistageneProdu.getBtnTequilaPG().getText())) {
                int cantidad = listaproducto.get(i).getCantidad();
                if (cantidad == 0) {
                    vistageneProdu.getBtnTequilaPG().setEnabled(false);
                    break;
                } else {
                    vistageneProdu.getBtnTequilaPG().setEnabled(true);
                    break;
                }
            } else {
                vistageneProdu.getBtnTequilaPG().setEnabled(false);
            }
        }
        for (int i = 0; i < listaproducto.size(); i++) {
            if (listaproducto.get(i).getNombre().equals(vistageneProdu.getBtnRonPG().getText())) {
                int cantidad = listaproducto.get(i).getCantidad();
                if (cantidad == 0) {
                    vistageneProdu.getBtnRonPG().setEnabled(false);
                    break;
                } else {
                    vistageneProdu.getBtnRonPG().setEnabled(true);
                    break;
                }
            } else {
                vistageneProdu.getBtnRonPG().setEnabled(false);
            }
        }
        for (int i = 0; i < listaproducto.size(); i++) {
            if (listaproducto.get(i).getNombre().equals(vistageneProdu.getBtnWhiskyPG().getText())) {
                int cantidad = listaproducto.get(i).getCantidad();
                if (cantidad == 0) {
                    vistageneProdu.getBtnWhiskyPG().setEnabled(false);
                    break;
                } else {
                    vistageneProdu.getBtnWhiskyPG().setEnabled(true);
                    break;
                }
            } else {
                vistageneProdu.getBtnWhiskyPG().setEnabled(false);
            }
        }
        for (int i = 0; i < listaproducto.size(); i++) {
            if (listaproducto.get(i).getNombre().equals(vistageneProdu.getBtnGinebraPG().getText())) {
                int cantidad = listaproducto.get(i).getCantidad();
                if (cantidad == 0) {
                    vistageneProdu.getBtnGinebraPG().setEnabled(false);
                    break;
                } else {
                    vistageneProdu.getBtnGinebraPG().setEnabled(true);
                    break;
                }
            } else {
                vistageneProdu.getBtnGinebraPG().setEnabled(false);
            }
        }
        for (int i = 0; i < listaproducto.size(); i++) {
            if (listaproducto.get(i).getNombre().equals(vistageneProdu.getBtnCoñacPG().getText())) {
                int cantidad = listaproducto.get(i).getCantidad();
                if (cantidad == 0) {
                    vistageneProdu.getBtnCoñacPG().setEnabled(false);
                    break;
                } else {
                    vistageneProdu.getBtnCoñacPG().setEnabled(true);
                    break;
                }
            } else {
                vistageneProdu.getBtnCoñacPG().setEnabled(false);
            }
        }
        for (int i = 0; i < listaproducto.size(); i++) {
            if (listaproducto.get(i).getNombre().equals(vistageneProdu.getBtnZhumirPG().getText())) {
                int cantidad = listaproducto.get(i).getCantidad();
                if (cantidad == 0) {
                    vistageneProdu.getBtnZhumirPG().setEnabled(false);
                    break;
                } else {
                    vistageneProdu.getBtnZhumirPG().setEnabled(true);
                    break;
                }
            } else {
                vistageneProdu.getBtnZhumirPG().setEnabled(false);
            }
        }
    }

    private void FinFacturaCargaNuevosNumerosProductos() {
        ControlTotalBotonVistaProductosGenerales();
        ControlTotalBotonVistaFruta();
        ControlTotalBotonVistaVegetal();
        ControlTotalBotonVistaHelados();
    }

//    private void cargaloading(){
//        vistaVen.getPanelPorcentaje().setVisible(true);
//        vistaVen.getPanelPorcentaje().setSize(593, 293);
////        LoadingFactura();
//        
//    }
//    
//    public void LoadingFactura() {
//        System.out.println("ingresoo al loading");
////       
//        try {
//            for (int i = 0; i <= 100; i++) {
//                System.out.println("Ingreso al for de loading");
//                Thread.sleep(i);
//                System.out.println(""+i);
//                vistaVen.getLblPorcentajeVis().setText(i + "%");
//                if (i == 30) {
//                    vistaVen.getLblCargaTextoVis().setText("Validando datos.");
//                }
//                if (i == 60) {
//                    vistaVen.getLblCargaTextoVis().setText("Procesando datos.");
//                }
//                if (i == 90) {
//                    vistaVen.getLblCargaTextoVis().setText("Ya casi está listo la factura.");
//                }
//                vistaVen.getBarProgresoVis().setValue(i);
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(vistaVen, e);
//        }
//        vistaVen.getPanelPorcentaje().setVisible(false);
//    }
}
