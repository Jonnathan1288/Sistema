/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ConectionPg;
import Modelo.ModeloPersona;
import Modelo.Persona;
import Vista.ViewPersonas;
import java.awt.ComponentOrientation;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
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
public class ControlPersona {

    private ModeloPersona modper;
    private ViewPersonas vistap;
    private JFileChooser jfc;
    Icon vistalogo;
    public ControlPersona(ModeloPersona modper, ViewPersonas vistap) {
        this.modper = modper;
        this.vistap = vistap;
//        vistap.setLocationRelativeTo(vistap);
        vistap.setVisible(true);
        ControlCampos();
        CargarPersona();
        CargaLogoVista();
//        coma();

    }
//    public void coma(){
//        if(!(vistap.getTxtSueldo().getText().contains("."))){
//          vistap.getTxtSueldo().setText(vistap.getTxtSueldo().getText()+".");  
//        }
//    }

    public void ControlBoton() {
        vistap.getBtnActualizar().addActionListener(l -> CargarPersona());
        vistap.getBtnCrear().addActionListener(l -> abrirDialogo(1));
        vistap.getBtnEditar().addActionListener(l -> abrirDialogo(2));
        //Escuchas del dialogo.
        vistap.getBtnAceptar().addActionListener(l -> crearEditarPersona());
        vistap.getBtnRemover().addActionListener(l -> EliminarPersona());
        vistap.getBtnCancelar().addActionListener(l -> Cancelar());
        vistap.getBtnExaminar().addActionListener(l -> ExaminarFoto());
        vistap.getBtnImprimir().addActionListener(l -> ImprimirListaPersonas());
    }

    private void CargaLogoVista() {
        vistalogo = new ImageIcon("src/Vista/Ico/gener.png");
        
    }
    private Icon imagenl(String dir, int al, int an){
        Icon img =new ImageIcon(new ImageIcon(getClass().getResource(dir)).getImage().getScaledInstance(al, an, java.awt.Image.SCALE_SMOOTH));
        return img;
    }
    private void ImprimirListaPersonas() {

//        int nu = JOptionPane.showOptionDialog(null, "", "", 0, JOptionPane.QUESTION_MESSAGE, null, cade, "Cancelar");
//        if (nu == 0) {
//            sexo = "MASCULINO";
//        }
//        if (nu == 1) {
//            sexo = "FEMENINO";
//        }
//        if (nu == 2) {
//            sexo = "nell";
//        }
//        if (sexo.equals("nell")) {
//            
//        } else {
        String sexo = null;
        String[] cade = {"MASCULINO", "FEMENINO"};
        String nume = (String) JOptionPane.showInputDialog(null, "Selecciones un genero, para pintar de un color todas las coincidencias. \n", "GENERO DE PERSONA", JOptionPane.DEFAULT_OPTION, vistalogo, cade, cade[0]);
        System.out.println("-->" + nume);
        if (nume == null) {

        } else {
            String n = null;
            int sueldo = 0;
            boolean aux = false;
            do {
                do {
                    n = JOptionPane.showInputDialog(vistap, "Ingrese sueldo desde donde se va verificar los mayores.");
                    System.out.println("sueldo->>" + n);
                    if (n == null) {
                        n = "0";
                        aux = true;
                    }
                } while (n.equals(""));
            } while (validarnumero(n));
            if (aux == true) {
                
                sueldo = 9999999;
            } else {
                sueldo = Integer.parseInt(n);
            }

            ConectionPg cp = new ConectionPg();
            try {
                JasperReport jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/Vista/Reportes/PracticaReportePersona.jasper"));
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("genee", nume);
                map.put("sueldomayor", sueldo);
               // map.put("ruta", "/Vista/Reportes/");
                // map.put("logop", "LogoGall.png");
                JasperPrint jp = JasperFillManager.fillReport(jr, map, cp.getCon());
                JasperViewer jv = new JasperViewer(jp, false);
                jv.setVisible(true);
            } catch (JRException ex) {
                Logger.getLogger(ControlPersona.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private boolean validarnumero(String numero) {
        boolean num;
        if (numero.matches("^[0-9]*$")) {
            num = false;
        } else {
            JOptionPane.showMessageDialog(vistap, "Ingrese numeros.");
            num = true;
        }
        return num;
    }

    private void ExaminarFoto() {
        jfc = new JFileChooser();
        FileNameExtensionFilter tipo = new FileNameExtensionFilter("JPG, JPEG", "jpg", "jpeg");
        jfc.setFileFilter(tipo);
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int estado = jfc.showOpenDialog(vistap);
        if (estado == JFileChooser.APPROVE_OPTION) {
            try {
                Image imagen = ImageIO.read(jfc.getSelectedFile()).getScaledInstance(
                        vistap.getLblFoto().getWidth(),
                        vistap.getLblFoto().getHeight(),
                        Image.SCALE_DEFAULT);

                Icon icono = new ImageIcon(imagen);
                vistap.getLblFoto().setIcon(icono);
                vistap.getLblFoto().updateUI();
            } catch (IOException ex) {
                Logger.getLogger(ControlPersona.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void ControlCampos() {
        KeyListener cedula = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (c < '0' || c > '9') {
                    e.consume();
                }
                if (Character.isLetter(c)) {
                    e.consume();
                    JOptionPane.showMessageDialog(vistap, "Por favor, debe ingresar solo números en este campo.", "Cédula.", JOptionPane.WARNING_MESSAGE);
                }
                if (vistap.getTxtCedula().getText().length() == 10) {
                    e.consume();
                    JOptionPane.showMessageDialog(vistap, "Ya están los 10 dígitos de la cedula.", "Numero de dígitos.", JOptionPane.ERROR_MESSAGE);
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        };
        KeyListener nombre_apellido = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char vn = e.getKeyChar();
                if (Character.isDigit(vn)) {
                    e.consume();
                    JOptionPane.showMessageDialog(null, "No debe ingresar números en este campo.", "Validación.", JOptionPane.WARNING_MESSAGE);
                }
                if (Character.isLowerCase(vn)) {
                    e.setKeyChar(Character.toUpperCase(vn));
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        };
        KeyListener telefono = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (c < '0' || c > '9') {
                    e.consume();
                }
                if (Character.isLetter(c)) {
                    e.consume();
                    JOptionPane.showMessageDialog(vistap, "Por favor, debe ingresar solo números en este campo.", "Numero de teléfono.", JOptionPane.WARNING_MESSAGE);
                }
                if (vistap.getTxtTelefono().getText().length() == 10) {
                    e.consume();
                    JOptionPane.showMessageDialog(vistap, "Ya están los 10 números de teléfono.", "Numero de dígitos.", JOptionPane.ERROR_MESSAGE);
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        };
        KeyListener busqueda = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                String busqueda = vistap.getTxtBuscar().getText();
                String envio = busqueda.toLowerCase();
                BusquedaPersona(envio);
            }
        };
        KeyListener sueldo = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != '.')) {
                    e.consume();
                }
                if (c == '.' && vistap.getTxtSueldo().getText().contains(".")) {
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        };
        vistap.getTxtCedula().addKeyListener(cedula);
        vistap.getTxtNombres().addKeyListener(nombre_apellido);
        vistap.getTxtApellidos().addKeyListener(nombre_apellido);
        vistap.getTxtTelefono().addKeyListener(telefono);
        vistap.getTxtBuscar().addKeyListener(busqueda);
        vistap.getTxtSueldo().addKeyListener(sueldo);
    }

    private void CargarPersona() {
        vistap.getTblPersonas().setDefaultRenderer(Object.class, new ImagenTable());
        vistap.getTblPersonas().setRowHeight(100);
        DefaultTableModel tb = (DefaultTableModel) vistap.getTblPersonas().getModel();
        tb.setNumRows(0);
        List<Persona> tablaP = modper.listarPersonas();
        Holder<Integer> i = new Holder<>(0);
        tablaP.stream().forEach(p -> {
            //----
            LocalDateTime fa = LocalDateTime.now();
            Period edad = Period.between(p.getFechaNacimiento().toLocalDate(), fa.toLocalDate());
            //----
            tb.addRow(new Object[9]);
            vistap.getTblPersonas().setValueAt(p.getIdPersona(), i.value, 0);
            vistap.getTblPersonas().setValueAt(p.getNombres(), i.value, 1);
            vistap.getTblPersonas().setValueAt(p.getApellidos(), i.value, 2);
            vistap.getTblPersonas().setValueAt(edad.getYears(), i.value, 3);
            vistap.getTblPersonas().setValueAt(p.getTelefono(), i.value, 4);
            vistap.getTblPersonas().setValueAt(p.getSexo(), i.value, 5);
            vistap.getTblPersonas().setValueAt(p.getSueldo(), i.value, 6);
            vistap.getTblPersonas().setValueAt(p.getCupo(), i.value, 7);
            Image foto = p.getFoto();
            if (foto != null) {
                Image nimg = foto.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                ImageIcon icono = new ImageIcon(nimg);
                DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
                renderer.setIcon(icono);
                vistap.getTblPersonas().setValueAt(new JLabel(icono), i.value, 8);
            } else {
                vistap.getTblPersonas().setValueAt(null, i.value, 8);
            }
            i.value++;
        });
    }

    private void BusquedaPersona(String busqueda) {
        vistap.getTblPersonas().setDefaultRenderer(Object.class, new ImagenTable());
        vistap.getTblPersonas().setRowHeight(100);
        DefaultTableModel tb = (DefaultTableModel) vistap.getTblPersonas().getModel();
        tb.setNumRows(0);
        List<Persona> ListaBusqueda = modper.BuscarPersona(busqueda);
        Holder<Integer> i = new Holder<>(0);
        ListaBusqueda.stream().forEach(p -> {
            tb.addRow(new Object[9]);
            vistap.getTblPersonas().setValueAt(p.getIdPersona(), i.value, 0);
            vistap.getTblPersonas().setValueAt(p.getNombres(), i.value, 1);
            vistap.getTblPersonas().setValueAt(p.getApellidos(), i.value, 2);
            vistap.getTblPersonas().setValueAt(p.getFechaNacimiento(), i.value, 3);
            vistap.getTblPersonas().setValueAt(p.getTelefono(), i.value, 4);
            vistap.getTblPersonas().setValueAt(p.getSexo(), i.value, 5);
            vistap.getTblPersonas().setValueAt(p.getSueldo(), i.value, 6);
            vistap.getTblPersonas().setValueAt(p.getCupo(), i.value, 7);
            Image foto = p.getFoto();
            if (foto != null) {
                Image nimg = foto.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                ImageIcon icono = new ImageIcon(nimg);
                DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
                renderer.setIcon(icono);
                vistap.getTblPersonas().setValueAt(new JLabel(icono), i.value, 8);
            } else {
                vistap.getTblPersonas().setValueAt(null, i.value, 8);
            }
            i.value++;
        });
    }

    private void abrirDialogo(int ce) {
        String title = null;
        if (ce == 1) {
            title = "Crear nueva Persona";
            vistap.getDlgPersona().setName("Crear");
            vistap.getTxtCedula().setEditable(true);
            vistap.getDlgPersona().setVisible(true);
            LimpiarDatosPersona();
        } else {
            if (ce == 2) {
                int i = vistap.getTblPersonas().getSelectedRow();
                if (i != -1) {
                    vistap.getTxtCedula().setEditable(false);
                    title = "Editar Persona";
                    vistap.getDlgPersona().setName("Editar");
                    cargarEdicion();
                    vistap.getDlgPersona().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(vistap, "Error, debe seleccionar una fila para la edición.", "Modificación de persona.", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        vistap.getDlgPersona().setLocation(600, 80);
        vistap.getDlgPersona().setSize(600, 450);
        vistap.getDlgPersona().setTitle(title);
    }

    private void Cancelar() {
        if (vistap.getDlgPersona().getName().equals("Crear")) {
            int confirmar = JOptionPane.showConfirmDialog(vistap, "¿Está seguro que desea cancelar la creación de la persona?", "Cancelar.", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (confirmar == JOptionPane.YES_OPTION) {
                try {
                    Thread.sleep(1000);
                    vistap.getDlgPersona().dispose();
                } catch (InterruptedException ex) {
                    Logger.getLogger(ControlPersona.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            int confirmar = JOptionPane.showConfirmDialog(vistap, "¿Está seguro que desea cancelar la edición de la persona?", "Cancelar.", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (confirmar == JOptionPane.YES_OPTION) {
                try {
                    Thread.sleep(1200);
                    vistap.getDlgPersona().dispose();
                } catch (InterruptedException ex) {
                    Logger.getLogger(ControlPersona.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    private void crearEditarPersona() {
        String fecha = ((JTextField) vistap.getDateFechaNacimiento().getDateEditor().getUiComponent()).getText();

        if (vistap.getDlgPersona().getName().equals("Crear")) {
            if (vistap.getTxtCedula().getText().isEmpty() || vistap.getTxtNombres().getText().isEmpty()
                    || vistap.getTxtApellidos().getText().isEmpty() || fecha.isEmpty() || vistap.getTxtTelefono().getText().isEmpty()
                    || vistap.getCmbSexo().getSelectedItem().toString().equals("Seleccione")
                    || vistap.getTxtSueldo().getText().isEmpty() || vistap.getSpnCupo().getValue().toString().equals("0")
                    || vistap.getLblFoto().getIcon() == null) {
                JOptionPane.showMessageDialog(vistap.getDlgPersona(), "Por favor, compruebe si todos los campos están llenos, y con la información correcta.", "Validar", JOptionPane.WARNING_MESSAGE);
            } else {
                CrearPersona();
            }
        } else {
            if (vistap.getDlgPersona().getName().equals("Editar")) {
                if (vistap.getTxtNombres().getText().isEmpty() || vistap.getTxtApellidos().getText().isEmpty()
                        || fecha.isEmpty() || vistap.getTxtTelefono().getText().isEmpty()
                        || vistap.getCmbSexo().getSelectedItem().toString().equals("Seleccione")
                        || vistap.getTxtSueldo().getText().isEmpty() || vistap.getSpnCupo().getValue().toString().equals("0")
                        || vistap.getLblFoto().getIcon() == null) {
                    JOptionPane.showMessageDialog(vistap.getDlgPersona(), "Algunos campos no están correctos, verifique.", "Validar Modificación.", JOptionPane.WARNING_MESSAGE);
                } else {
                    EditarPersona();
                }
            }
        }
    }

    private void CrearPersona() {
        ModeloPersona modpersona = new ModeloPersona();
        modpersona.setIdPersona(vistap.getTxtCedula().getText());
        modpersona.setNombres(vistap.getTxtNombres().getText());
        modpersona.setApellidos(vistap.getTxtApellidos().getText());
        String na = ((JTextField) vistap.getDateFechaNacimiento().getDateEditor().getUiComponent()).getText();
        Date fechaN = java.sql.Date.valueOf(na);
        modpersona.setFechaNacimiento((java.sql.Date) fechaN);
        modpersona.setTelefono(vistap.getTxtTelefono().getText());
        modpersona.setSexo(vistap.getCmbSexo().getSelectedItem().toString());
        modpersona.setSueldo(Double.parseDouble(vistap.getTxtSueldo().getText()));
        modpersona.setCupo(Integer.parseInt(vistap.getSpnCupo().getValue().toString()));

        try {
            FileInputStream img = new FileInputStream(jfc.getSelectedFile());
            int largo = (int) jfc.getSelectedFile().length();
            modpersona.setImagen(img);
            modpersona.setLargo(largo);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ControlPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (validarCedula(vistap.getTxtCedula().getText()) == true) {
            JOptionPane.showMessageDialog(vistap, "Error la cedula ya existe en la base de datos. ", "Cédula duplicada. ", JOptionPane.ERROR_MESSAGE);
        } else {
            if (modpersona.crearPersonaByte()) {
                vistap.getDlgPersona().setVisible(false);
                LimpiarDatosPersona();
                CargarPersona();
                JOptionPane.showMessageDialog(vistap, "Persona Creada Satisfactoriamente");
            } else {
                JOptionPane.showMessageDialog(vistap, "No se puedo crear la Persona");
            }
        }
    }

    private void EditarPersona() {
        System.out.println("HOLAAAA");
        ModeloPersona modp = new ModeloPersona();
        modp.setIdPersona(vistap.getTxtCedula().getText());
        modp.setNombres(vistap.getTxtNombres().getText());
        modp.setApellidos(vistap.getTxtApellidos().getText());
        String na = ((JTextField) vistap.getDateFechaNacimiento().getDateEditor().getUiComponent()).getText();
        Date fechaN = java.sql.Date.valueOf(na);
        modp.setFechaNacimiento((java.sql.Date) fechaN);
        modp.setTelefono(vistap.getTxtTelefono().getText());
        modp.setSexo(vistap.getCmbSexo().getSelectedItem().toString());
        modp.setSueldo(Double.parseDouble(vistap.getTxtSueldo().getText()));
        modp.setCupo(Integer.parseInt(vistap.getSpnCupo().getValue().toString()));
        System.out.println("nan");
        if (jfc == null) {
            if (modp.ModificarPersonaFT()) {
                JOptionPane.showMessageDialog(vistap, "Correcta modificación de la persona.");
                CargarPersona();
            } else {
                JOptionPane.showMessageDialog(vistap, "Se a producido un error al modificar la persona.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            if (jfc != null) {
                try {
                    System.out.println("Hola como estas");
                    FileInputStream img = new FileInputStream(jfc.getSelectedFile());
                    int largo = (int) jfc.getSelectedFile().length();
                    modp.setImagen(img);
                    modp.setLargo(largo);
                    System.out.println("Fin del Hola como estas");
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ControlPersona.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (modp.ModificarPersonaByte()) {
                CargarPersona();
                JOptionPane.showMessageDialog(vistap, "El registro a sido modificado satisfactoriamente.");

            } else {
                JOptionPane.showMessageDialog(vistap, "Error, no se pudo modificar la Persona.", "Error de modificación.", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private boolean validarCedula(String idcedula) {
        boolean valida = false;
        List<Persona> listaValida = modper.listarPersonas();
        for (int i = 0; i < listaValida.size(); i++) {
            if (listaValida.get(i).getIdPersona().equals(idcedula)) {
                valida = true;
            }
        }
        return valida;
    }

    private void cargarEdicion() {

        int i = vistap.getTblPersonas().getSelectedRow();
        if (i != -1) {
            String ve = vistap.getTblPersonas().getValueAt(i, 0).toString();
            System.out.println("Ver persona" + ve);
            System.out.println("Entro" + i);
            List<Persona> listaP = modper.listarPersonas();
            for (int j = 0; j < listaP.size(); j++) {
                System.out.println("Entro en el for" + j);
                if (listaP.get(j).getIdPersona().equals(ve)) {
                    System.out.println("->Entro en la condicional");
                    vistap.getTxtCedula().setText(listaP.get(j).getIdPersona());
                    vistap.getTxtNombres().setText(listaP.get(j).getNombres());
                    vistap.getTxtApellidos().setText(listaP.get(j).getApellidos());
                    Date fec = listaP.get(j).getFechaNacimiento();
                    vistap.getDateFechaNacimiento().setDate(fec);
                    vistap.getTxtTelefono().setText(listaP.get(j).getTelefono());
                    vistap.getCmbSexo().setSelectedItem(listaP.get(j).getSexo());
                    vistap.getTxtSueldo().setText(String.valueOf(listaP.get(j).getSueldo()));
                    vistap.getSpnCupo().setValue(Integer.parseInt(String.valueOf(listaP.get(j).getCupo())));
                    if (listaP.get(j).getFoto() == null) {
                        vistap.getLblFoto().setIcon(null);
                    } else {
                        Image in = listaP.get(j).getFoto();
//                        Image ja= in.getScaledInstance(vistap.getLblFoto().getWidth() ,vistap.getLblFoto().getWidth(), Image.SCALE_SMOOTH);
                        Image img = in.getScaledInstance(133, 147, Image.SCALE_SMOOTH);
                        Icon icono = new ImageIcon(img);
                        vistap.getLblFoto().setIcon(icono);
                    }

                }
            }
        } else {
            JOptionPane.showMessageDialog(vistap, "Error.");
        }
    }

    private void LimpiarDatosPersona() {
        vistap.getTxtCedula().setText("");
        vistap.getTxtNombres().setText("");
        vistap.getTxtApellidos().setText("");
        vistap.getDateFechaNacimiento().setDate(null);
        vistap.getTxtTelefono().setText("");
        vistap.getCmbSexo().setSelectedItem("Seleccione");
        vistap.getTxtSueldo().setText("");
        vistap.getSpnCupo().setValue(Integer.parseInt("1"));
        vistap.getLblFoto().setIcon(null);
    }

    private void EliminarPersona() {
        int i = vistap.getTblPersonas().getSelectedRow();
        if (i != -1) {
            String id = vistap.getTblPersonas().getValueAt(i, 0).toString();
            String Nombr = vistap.getTblPersonas().getValueAt(i, 1).toString();
            String App = vistap.getTblPersonas().getValueAt(i, 2).toString();
            int result = JOptionPane.showConfirmDialog(vistap, "Esta seguro que desea eliminar a " + Nombr + " " + App + " con la cédula " + id + "?", "Confirmación .", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (result == JOptionPane.YES_OPTION) {
                if (modper.eliminarPersona(id)) {
                    JOptionPane.showMessageDialog(vistap, "El registro a sido eliminado correctamente de la base de datos.");
                    CargarPersona();
                } else {
                    JOptionPane.showMessageDialog(vistap, "Se ha producido un error al rato de eliminar el registro.", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(vistap, "Registro cancelado para su eliminación.");
            }
        } else {
            JOptionPane.showMessageDialog(vistap, "Error, usted debe seleccionar un registro de la tabla para proceder a su eliminación.", "Eliminar.", JOptionPane.ERROR_MESSAGE);
        }
    }

}
