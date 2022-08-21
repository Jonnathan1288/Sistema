/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ConectionPg;
import Modelo.ModeloProducto;
import Modelo.Producto;
import Vista.ViewProducto;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
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
public class ControlProducto {

    ModeloProducto modelopro;
    ViewProducto vistapro;
    private JFileChooser jfc;
    Icon visP;
    Icon visProd;

    public ControlProducto(ModeloProducto modelopro, ViewProducto vistapro) {
        this.modelopro = modelopro;
        this.vistapro = vistapro;
        IncremetoID();
        cargarProductos();
        vistapro.setVisible(true);
        controlEvento();
        CargaLogoVista();
    }

    private void IncremetoID() {
        System.out.println("-->" + modelopro.IncrementoIdProducto());
//        vistapro.getTxtDescripcionProducto().setText(String.valueOf(modelopro.IncrementoIdProducto()));
        vistapro.getTxtIdProductot().setText(String.valueOf(modelopro.IncrementoIdProducto()));
        System.out.println("-->" + modelopro.IncrementoIdProducto());
    }

    private void CargaLogoVista() {
        visP = new ImageIcon("src/Vista/Ico/Produ.png");
        visProd = new ImageIcon("src/Vista/Ico/imgprin.png");
    }

    public void controlBoton() {
        vistapro.getBtnCrearProducto().addActionListener(l -> cargarDialogoPro(1));
        vistapro.getBtnEditarProdcuto().addActionListener(l -> cargarDialogoPro(2));
        vistapro.getBtnAceptarP().addActionListener(l -> CrearEditarPrducto());
        vistapro.getBtnRemoverProducto().addActionListener(l -> EliminarPrdcuto());
        vistapro.getBtnExaminar().addActionListener(l -> ExaminarFoto());
        vistapro.getBtnActualizar().addActionListener(l -> cargarProductos());
        vistapro.getBtnCancelarP().addActionListener(l -> CancelarVistaEdicionCreacion());
        vistapro.getBtnImprimirProducto().addActionListener(l -> TipoImprimir());

    }

    private void TipoImprimir() {
        String[] cade = {"Cantidad", "Filtro", "Cancelar"};
        int nu = JOptionPane.showOptionDialog(null, "Elija el tipo de impresión que desea realizar.", "Opción de imprimir.", 0, JOptionPane.DEFAULT_OPTION, visProd, cade, "Cancelar");
        if (nu == 0) {
            System.out.println("Catidad");
            ImprimirNormal();
        }
        if (nu == 1) {
            System.out.println("Filtro");
            ImprimirListaProductos();
        }
    }

    private void ImprimirListaProductos() {
        String sexo = null;
        String[] cade = {"Vegetales", "Frutas", "Bebidas Gaseosas", "Bebidas Alcohólicas", "Lácteos"};
        String seccion = (String) JOptionPane.showInputDialog(null, "Selecciones el tipo de seccion que desea filtrar\n", "FILTRO SECCION", JOptionPane.DEFAULT_OPTION, visP, cade, cade[0]);
        System.out.println("-->" + seccion);
        if (seccion == null) {

        } else {
            String n = null;
            int cantidad = 0;
            boolean aux = false;
            do {
                do {
                    n = JOptionPane.showInputDialog(vistapro, "Ingrese cantidad desde donde se va verificar los productos a punto de agotar.");
                    System.out.println("cantidad->>" + n);
                    if (n == null) {
                        n = "";
                        aux = true;
                    }
                } while (n.equals(""));
            } while (validarnumero(n));

            cantidad = Integer.parseInt(n);

            ConectionPg cp = new ConectionPg();
            try {
                JasperReport jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/Vista/Reportes/ReporteProductos.jasper"));
                Map<String, Object> map = new HashMap<String, Object>();
                //map.put("LogoG", "milLogo.jpg");
                map.put("puntoAgotar", cantidad);
                map.put("sec", seccion);
                JasperPrint jp = JasperFillManager.fillReport(jr, map, cp.getCon());
                JasperViewer jv = new JasperViewer(jp, false);
                jv.setVisible(true);
            } catch (JRException ex) {
                Logger.getLogger(ControlProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void ImprimirNormal() {
        int cantidad = 0;
        boolean aux = false;
        String n = null;
        do {
            do {
                n = JOptionPane.showInputDialog(vistapro, "Ingrese cantidad desde donde se va verificar los productos a punto de agotar.");
                System.out.println("cantidad->>" + n);
                if (n == null) {
                    n = "";
                    aux = true;
                }
            } while (n.equals(""));
        } while (validarnumero(n));

        cantidad = Integer.parseInt(n);

        ConectionPg cp = new ConectionPg();
        try {
            JasperReport jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/Vista/Reportes/ReporteProductosF.jasper"));
            Map<String, Object> map = new HashMap<String, Object>();
            //map.put("LogoG", "milLogo.jpg");
            map.put("puntoAgotar", cantidad);
            JasperPrint jp = JasperFillManager.fillReport(jr, map, cp.getCon());
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(ControlProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   

    private boolean validarnumero(String numero) {
        boolean num;
        if (numero.matches("^[0-9]*$")) {
            num = false;
        } else {
            JOptionPane.showMessageDialog(vistapro, "Ingrese solo numeros.");
            num = true;
        }
        return num;
    }

    private void CancelarVistaEdicionCreacion() {
        if (vistapro.getDlgDialogoProductos().getName().equals("Crear")) {
            int confirmar = JOptionPane.showConfirmDialog(vistapro, "¿Está seguro que desea cancelar la creación del Producto?", "Cancelar.", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (confirmar == JOptionPane.YES_OPTION) {
                try {
                    Thread.sleep(1000);
                    vistapro.getDlgDialogoProductos().dispose();
                } catch (InterruptedException ex) {
                    Logger.getLogger(ControlPersona.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            int confirmar = JOptionPane.showConfirmDialog(vistapro, "¿Está seguro que desea cancelar la edición del Producto?", "Cancelar.", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (confirmar == JOptionPane.YES_OPTION) {
                try {
                    Thread.sleep(1200);
                    vistapro.getDlgDialogoProductos().dispose();
                } catch (InterruptedException ex) {
                    Logger.getLogger(ControlPersona.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    public void controlEvento() {
        KeyListener bus = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("Ingreso al evento.");
                String bu = vistapro.getTxtBuscarProducto().getText();
                String busqueda = bu.toLowerCase();
                filtrosBusqueda(busqueda);
                System.out.println("Paso de la busqueda.");
            }
        };
        KeyListener id = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (c < '0' || c > '9') {
                    e.consume();
                }
                if (Character.isLetter(c)) {
                    e.consume();
                    JOptionPane.showMessageDialog(vistapro, "Por favor, debe ingresar solo números en este campo.", "ID.", JOptionPane.WARNING_MESSAGE);
                }
                if (vistapro.getTxtIdProductot().getText().length() == 7) {
                    e.consume();
                    JOptionPane.showMessageDialog(vistapro, "El ID ya no se puede exeder", "Numero de dígitos.", JOptionPane.ERROR_MESSAGE);
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        };
        ItemListener ComboSeccion = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

                if (vistapro.getComboSeccionProducto().getSelectedItem().toString().equals("Vegetales")) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        if (vistapro.getComboSeccionProducto().getSelectedIndex() > 0) {
                            vistapro.getComboNombreProductoVen().setModel(new DefaultComboBoxModel(SeccionVegetales(vistapro.getComboSeccionProducto().getSelectedItem().toString())));
                        }
                    }
                } else {
                    if (vistapro.getComboSeccionProducto().getSelectedItem().toString().equals("Frutas")) {
                        if (e.getStateChange() == ItemEvent.SELECTED) {
                            if (vistapro.getComboSeccionProducto().getSelectedIndex() > 0) {
                                vistapro.getComboNombreProductoVen().setModel(new DefaultComboBoxModel(SeccionFrutas(vistapro.getComboSeccionProducto().getSelectedItem().toString())));
                            }
                        }
                    } else {
                        if (vistapro.getComboSeccionProducto().getSelectedItem().toString().equals("Helado")) {
                            if (e.getStateChange() == ItemEvent.SELECTED) {
                                if (vistapro.getComboSeccionProducto().getSelectedIndex() > 0) {
                                    vistapro.getComboNombreProductoVen().setModel(new DefaultComboBoxModel(SeccionHelados(vistapro.getComboSeccionProducto().getSelectedItem().toString())));
                                }
                            }
                        } else {
                            if (vistapro.getComboSeccionProducto().getSelectedItem().toString().equals("Bebidas Gaseosas")) {
                                if (e.getStateChange() == ItemEvent.SELECTED) {
                                    if (vistapro.getComboSeccionProducto().getSelectedIndex() > 0) {
                                        vistapro.getComboNombreProductoVen().setModel(new DefaultComboBoxModel(SeccionBebidasGaseosas(vistapro.getComboSeccionProducto().getSelectedItem().toString())));
                                    }
                                }
                            } else {
                                if (vistapro.getComboSeccionProducto().getSelectedItem().toString().equals("Bebidas Alcohólicas")) {
                                    if (e.getStateChange() == ItemEvent.SELECTED) {
                                        if (vistapro.getComboSeccionProducto().getSelectedIndex() > 0) {
                                            vistapro.getComboNombreProductoVen().setModel(new DefaultComboBoxModel(SeccionBebidasAlcoholicas(vistapro.getComboSeccionProducto().getSelectedItem().toString())));
                                        }
                                    }
                                } else {
                                    if (vistapro.getComboSeccionProducto().getSelectedItem().toString().equals("Lácteos")) {
                                        System.out.println("Entre al evento de selec lac");

                                        if (e.getStateChange() == ItemEvent.SELECTED) {
                                            if (vistapro.getComboSeccionProducto().getSelectedIndex() > 0) {
                                                vistapro.getComboNombreProductoVen().setModel(new DefaultComboBoxModel(SeccionLacteos(vistapro.getComboSeccionProducto().getSelectedItem().toString())));
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        };
        vistapro.getTxtIdProductot().addKeyListener(id);
        vistapro.getTxtBuscarProducto().addKeyListener(bus);
        vistapro.getComboSeccionProducto().addItemListener(ComboSeccion);
    }

    private void ExaminarFoto() {
        jfc = new JFileChooser();
//        FileNameExtensionFilter tipo = new FileNameExtensionFilter("JGP, PNG & GIF", "jpg", "png", "gif");
        FileNameExtensionFilter tipo = new FileNameExtensionFilter("JPG, PNG", "jpg", "png");
        jfc.setFileFilter(tipo);
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int estado = jfc.showOpenDialog(vistapro);
        if (estado == JFileChooser.APPROVE_OPTION) {
            try {
                Image imagen = ImageIO.read(jfc.getSelectedFile()).getScaledInstance(
                        vistapro.getLblFoto().getWidth(),
                        vistapro.getLblFoto().getHeight(),
                        Image.SCALE_DEFAULT);

                Icon icono = new ImageIcon(imagen);
                vistapro.getLblFoto().setIcon(icono);
                vistapro.getLblFoto().updateUI();
            } catch (IOException ex) {
                Logger.getLogger(ControlPersona.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void filtrosBusqueda(String fil) {
        vistapro.getTblProductos().setDefaultRenderer(Object.class, new ImagenTable());
        vistapro.getTblProductos().setRowHeight(100);
        DefaultTableModel tablaProducto = (DefaultTableModel) vistapro.getTblProductos().getModel();
        tablaProducto.setNumRows(0);
        List<Producto> listaPro = modelopro.BuscarProducto(fil);
        Holder<Integer> i = new Holder<>(0);
        listaPro.stream().forEach(pr -> {
            tablaProducto.addRow(new Object[6]);
            vistapro.getTblProductos().setValueAt(pr.getId_producto(), i.value, 0);
            vistapro.getTblProductos().setValueAt(pr.getNombre(), i.value, 1);
            vistapro.getTblProductos().setValueAt(pr.getPrecio(), i.value, 2);
            vistapro.getTblProductos().setValueAt(pr.getCantidad(), i.value, 3);
            Image foto = pr.getFoto();
            if (foto != null) {
                Image nimg = foto.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                ImageIcon icono = new ImageIcon(nimg);
                DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
                renderer.setIcon(icono);
                vistapro.getTblProductos().setValueAt(new JLabel(icono), i.value, 4);
            } else {
                vistapro.getTblProductos().setValueAt(null, i.value, 4);
            }
            vistapro.getTblProductos().setValueAt(pr.getDescripcion(), i.value, 5);
            i.value++;
        });
    }

    private void cargarProductos() {
        vistapro.getTblProductos().setDefaultRenderer(Object.class, new ImagenTable());
        vistapro.getTblProductos().setRowHeight(100);
        DefaultTableModel tablaProducto = (DefaultTableModel) vistapro.getTblProductos().getModel();
        tablaProducto.setNumRows(0);
        List<Producto> listaPro = modelopro.CargarProducto();
        Holder<Integer> i = new Holder<>(0);
        listaPro.stream().forEach(pr -> {
            tablaProducto.addRow(new Object[6]);
            vistapro.getTblProductos().setValueAt(pr.getId_producto(), i.value, 0);
            vistapro.getTblProductos().setValueAt(pr.getNombre(), i.value, 1);
            vistapro.getTblProductos().setValueAt(pr.getPrecio(), i.value, 2);
            vistapro.getTblProductos().setValueAt(pr.getCantidad(), i.value, 3);
            Image foto = pr.getFoto();
            if (foto != null) {
                Image nimg = foto.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                ImageIcon icono = new ImageIcon(nimg);
                DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
                renderer.setIcon(icono);
                vistapro.getTblProductos().setValueAt(new JLabel(icono), i.value, 4);
            } else {
                vistapro.getTblProductos().setValueAt(null, i.value, 4);
            }
            vistapro.getTblProductos().setValueAt(pr.getDescripcion(), i.value, 5);
            i.value++;
        });
    }

    private void cargarDialogoPro(int numero) {
        String nombre = null;
        if (numero == 1) {
            //limpiarDatos();
            nombre = "Crear nuevo Producto";
            vistapro.getDlgDialogoProductos().setName("Crear");
            vistapro.getDlgDialogoProductos().setVisible(true);
            vistapro.getTxtIdProductot().setEditable(false);
        } else {
            if (numero == 2) {
                int i = vistapro.getTblProductos().getSelectedRow();
                if (i != -1) {
                    CargarDatos();
                    vistapro.getTxtIdProductot().setEditable(false);
                    nombre = "Editar Producto";
                    vistapro.getDlgDialogoProductos().setName("Editar");
                    vistapro.getDlgDialogoProductos().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(vistapro, "Error, debe seleccionar una fila para la edición.", "Modificación.", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
//        vistapro.getDlgDialogoProductos().setVisible(true);
        vistapro.getDlgDialogoProductos().setLocation(10, 10);
        vistapro.getDlgDialogoProductos().setSize(600, 400);
        vistapro.getDlgDialogoProductos().setTitle(nombre);

    }

    private void CrearEditarPrducto() {
        System.out.println("ss");
        if (vistapro.getDlgDialogoProductos().getName().equals("Crear")) {
            System.out.println("sas");
            if (vistapro.getTxtIdProductot().getText().isEmpty() || vistapro.getComboNombreProductoVen().getSelectedItem().toString().equals("")
                    || vistapro.getTxtPrecioProducto().getText().isEmpty() || vistapro.getSpnCantidadProducto().getValue().toString().equals("0")
                    || vistapro.getTxtDescripcionProducto().getText().isEmpty() || vistapro.getLblFoto().getIcon() == null
                    || vistapro.getComboSeccionProducto().getSelectedItem().toString().equals("Seleccione")) {
                JOptionPane.showMessageDialog(vistapro, "Por favor, compruebe si todos los campos están llenos, y con la información correcta.", "Validar", JOptionPane.WARNING_MESSAGE);
            } else {
                CrearProdcuto();
            }
        } else {
            if (vistapro.getDlgDialogoProductos().getName().equals("Editar")) {
                if (vistapro.getComboNombreProductoVen().getSelectedItem().toString().equals("") || vistapro.getTxtPrecioProducto().getText().isEmpty()
                        || vistapro.getSpnCantidadProducto().getValue().toString().equals("0")
                        || vistapro.getTxtDescripcionProducto().getText().isEmpty() || vistapro.getLblFoto().getIcon() == null
                        || vistapro.getComboSeccionProducto().getSelectedItem().toString().equals("Seleccione")) {
                    JOptionPane.showMessageDialog(vistapro, "Por favor, compruebe si todos los campos están llenos, y con la información correcta.", "Validar", JOptionPane.WARNING_MESSAGE);
                } else {
                    EditarProducto();
                }
            }
        }
    }

    private void CrearProdcuto() {
        ModeloProducto modproducto = new ModeloProducto();
        modproducto.setId_producto(Integer.parseInt(vistapro.getTxtIdProductot().getText()));
        //Combo nombre
        modproducto.setNombre(vistapro.getComboNombreProductoVen().getSelectedItem().toString());
//        modproducto.setNombre(vistapro.getTxtNombreProducto().getText());
        modproducto.setPrecio(Double.parseDouble(vistapro.getTxtPrecioProducto().getText()));
        modproducto.setCantidad(Integer.parseInt(vistapro.getSpnCantidadProducto().getValue().toString()));
        modproducto.setDescripcion(vistapro.getTxtDescripcionProducto().getText());
        modproducto.setSeccionProducto(vistapro.getComboSeccionProducto().getSelectedItem().toString());
        try {
            FileInputStream img = new FileInputStream(jfc.getSelectedFile());
            int largo = (int) jfc.getSelectedFile().length();
            modproducto.setImagen(img);
            modproducto.setLargo(largo);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ControlProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (ValidarId(Integer.parseInt(vistapro.getTxtIdProductot().getText())) == true) {
            JOptionPane.showMessageDialog(vistapro, "Error el ID ya existe en la base de datos. ", "ID Duplicada.", JOptionPane.ERROR_MESSAGE);
        } else {
            if (modproducto.CrearProductoBy()) {
                JOptionPane.showMessageDialog(vistapro, "Correcto");
                vistapro.getDlgDialogoProductos().setVisible(false);
                limpiarDatos();
                cargarProductos();
                IncremetoID();
            }
        }
        jfc = null;
    }

    private void EditarProducto() {
        ModeloProducto modp = new ModeloProducto();
        modp.setId_producto(Integer.parseInt(vistapro.getTxtIdProductot().getText()));
//        modp.setNombre(vistapro.getTxtNombreProducto().getText());
        //Combo
        modp.setNombre(vistapro.getComboNombreProductoVen().getSelectedItem().toString());
        modp.setPrecio(Double.parseDouble(vistapro.getTxtPrecioProducto().getText()));
        modp.setCantidad(Integer.parseInt(vistapro.getSpnCantidadProducto().getValue().toString()));
        modp.setDescripcion(vistapro.getTxtDescripcionProducto().getText());
        modp.setSeccionProducto(vistapro.getComboSeccionProducto().getSelectedItem().toString());
        if (jfc == null) {
            if (modp.ModificarProductoBy1()) {
                JOptionPane.showMessageDialog(vistapro, "Correcta modificación del producto.");
                cargarProductos();
            } else {
                JOptionPane.showMessageDialog(vistapro, "Se a producido un error al modificar el producto.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {

            if (jfc != null) {
                try {
                    System.out.println("Hola como estas");
                    FileInputStream img = new FileInputStream(jfc.getSelectedFile());
                    int largo = (int) jfc.getSelectedFile().length();
                    modp.setImagen(img);
                    modp.setLargo(largo);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ControlProducto.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (modp.ModificarProductoBy()) {
                JOptionPane.showMessageDialog(vistapro, "Correcta modificación del producto.");
                cargarProductos();
            } else {
                JOptionPane.showMessageDialog(vistapro, "Se a producido un error al modificar el producto.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void CargarDatos() {
        int i = vistapro.getTblProductos().getSelectedRow();
        if (i != -1) {
            String id = vistapro.getTblProductos().getValueAt(i, 0).toString();
            int cod = Integer.parseInt(id);
            vistapro.getTxtIdProductot().setText(id);
            vistapro.getTxtPrecioProducto().setText(vistapro.getTblProductos().getValueAt(i, 2).toString());
            vistapro.getSpnCantidadProducto().setValue(Integer.parseInt(vistapro.getTblProductos().getValueAt(i, 3).toString()));
            vistapro.getTxtDescripcionProducto().setText(vistapro.getTblProductos().getValueAt(i, 5).toString());

            List<Producto> listaSeeecion = modelopro.CargarProducto();
            for (int j = 0; j < listaSeeecion.size(); j++) {
                if (listaSeeecion.get(j).getId_producto() == cod) {
                    vistapro.getComboSeccionProducto().setSelectedItem(listaSeeecion.get(j).getSeccionProducto());
                    vistapro.getComboNombreProductoVen().setSelectedItem(listaSeeecion.get(j).getNombre());
                }
            }
            List<Producto> lis = modelopro.TraerImagen(cod);
            for (int j = 0; j < lis.size(); j++) {
                if (lis.get(j).getId_producto() == cod) {
                    if (lis.get(j).getFoto() == null) {
                        vistapro.getLblFoto().setIcon(null);
                    } else {
                        Image in = lis.get(j).getFoto();
                        Image img = in.getScaledInstance(133, 147, java.awt.Image.SCALE_SMOOTH);
                        Icon icono = new ImageIcon(img);
                        vistapro.getLblFoto().setIcon(icono);
                    }
                }
            }
        }
    }

    private void EliminarPrdcuto() {
        int i = vistapro.getTblProductos().getSelectedRow();
        if (i != -1) {
            String id = vistapro.getTblProductos().getValueAt(i, 0).toString();
            int result = JOptionPane.showConfirmDialog(vistapro, "Esta seguro que desea eliminar este producto", "Confirmación .", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (result == JOptionPane.YES_OPTION) {
                if (modelopro.EliminarProducto(id)) {
                    JOptionPane.showMessageDialog(vistapro, "El registro a sido eliminado correctamente de la base de datos.");
                    cargarProductos();
                } else {
                    JOptionPane.showMessageDialog(vistapro, "Se ha producido un error al rato de eliminar el producto.", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(vistapro, "Producto cancelado para su eliminación.");
            }
        } else {
            JOptionPane.showMessageDialog(vistapro, "Error, debe seleccionar una fila para la eliminacion", "Eliminar.", JOptionPane.ERROR_MESSAGE);

        }
    }

    private boolean ValidarId(int id) {
        boolean valida = false;
        List<Producto> listaValida = modelopro.CargarProducto();
        for (int i = 0; i < listaValida.size(); i++) {
            if (listaValida.get(i).getId_producto() == id) {
                valida = true;
            }
        }
        return valida;
    }

    private void limpiarDatos() {
        //vistapro.getTxtIdProductot().setText("");
        vistapro.getComboSeccionProducto().setSelectedItem("");

//        vistapro.getTxtNombreProducto().setText("");
        vistapro.getTxtPrecioProducto().setText("");
        vistapro.getSpnCantidadProducto().setValue(Integer.parseInt("1"));
        vistapro.getTxtDescripcionProducto().setText("");
        vistapro.getLblFoto().setIcon(null);
        vistapro.getComboSeccionProducto().setSelectedItem("Seleccione");
    }

    //Combos Anidados------------------------------------
//    private String[] Seleccionep(String prod) {
//        String[] Produ = new String[1];
//        if (prod.equalsIgnoreCase("Seleccione")) {
//            Produ[0] = "";
//        }
//        return Produ;
//    }
    private String[] SeccionVegetales(String datos) {
        String[] vegetales = new String[4];
        if (datos.equalsIgnoreCase("Vegetales")) {
            vegetales[0] = "Lechuga";
            vegetales[1] = "Tomate";
            vegetales[2] = "Cebolla";
            vegetales[3] = "Brócoli";
        }
        return vegetales;
    }

    private String[] SeccionFrutas(String fruta) {
        String[] frutas = new String[4];
        if (fruta.equalsIgnoreCase("Frutas")) {
            frutas[0] = "Papaya";
            frutas[1] = "Sandia";
            frutas[2] = "Naranja";
            frutas[3] = "Mandarina";
        }
        return frutas;
    }

    private String[] SeccionHelados(String helado) {
        String[] heladito = new String[5];
        if (helado.equalsIgnoreCase("Helado")) {
            heladito[0] = "Chocolate";
            heladito[1] = "Coco";
            heladito[2] = "Natural";
            heladito[3] = "Fresa";
            heladito[4] = "Vainilla";
        }
        return heladito;
    }

    private String[] SeccionBebidasGaseosas(String bebida) {
        String[] bebiGace = new String[5];
        if (bebida.equalsIgnoreCase("Bebidas Gaseosas")) {
            bebiGace[0] = "Coca Cola";
            bebiGace[1] = "Sprite";
            bebiGace[2] = "Pepsi";
            bebiGace[3] = "Inca Kola";
            bebiGace[4] = "Fanta";
        }
        return bebiGace;
    }

    private String[] SeccionBebidasAlcoholicas(String bebida) {
        String[] bebiAlco = new String[7];
        if (bebida.equalsIgnoreCase("Bebidas Alcohólicas")) {
            bebiAlco[0] = "Vodka";
            bebiAlco[1] = "Tequila";
            bebiAlco[2] = "Ron";
            bebiAlco[3] = "Whisky";
            bebiAlco[4] = "Ginebra";
            bebiAlco[5] = "Coñac";
            bebiAlco[6] = "ZHUMIR";
        }
        return bebiAlco;
    }

    private String[] SeccionLacteos(String lactio) {
        String[] lacti = new String[3];
        if (lactio.equalsIgnoreCase("Lácteos")) {
            lacti[0] = "Leche";
            lacti[1] = "Yogur";
            lacti[2] = "Queso";
        }
        return lacti;
    }
}
