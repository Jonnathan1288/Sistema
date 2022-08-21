/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

/**
 *
 * @author DELL
 */
public class ModeloVenta extends Venta{
    ConectionPg cp = new ConectionPg();

    public ModeloVenta() {
    }

    public ModeloVenta(int id_producto, String NombreProducto, double precio, int cantidad, String cedula, double total) {
        super(id_producto, NombreProducto, precio, cantidad, cedula, total);
    }

    public ModeloVenta(int id_producto, String nombre, String cedula, double total) {
        super(id_producto, nombre, cedula, total);
    }

    public ModeloVenta(int id_producto, String nombre, double precio, int cantidad, String descripcion, Image foto, String seccionProducto) {
        super(id_producto, nombre, precio, cantidad, descripcion, foto, seccionProducto);
    }
    

//    private int id_producto;
//    private String nombre;
//    private double precio;
//    private int cantidad;
//    private String descripcion;
//    private Image foto;
//    private String seccionProducto;
//    
//    private String cedula;
//    private double total;
//    private String apellidos;
//
//    public String getApellidos() {
//        return apellidos;
//    }
//
//    public void setApellidos(String apellidos) {
//        this.apellidos = apellidos;
//    }
//    
//    public ModeloVenta() {
//    }
//    
//    public ModeloVenta(int id_producto, String nombre, String cedula, double total) {
//        this.id_producto = id_producto;
//        this.nombre = nombre;
//        this.cedula = cedula;
//        this.total = total;
//    }
//    
//    public ModeloVenta(int id_producto, String nombre, double precio, int cantidad, String descripcion, Image foto, String seccionProducto) {
//        this.id_producto = id_producto;
//        this.nombre = nombre;
//        this.precio = precio;
//        this.cantidad = cantidad;
//        this.descripcion = descripcion;
//        this.foto = foto;
//        this.seccionProducto = seccionProducto;
//    }
//
//    public String getCedula() {
//        return cedula;
//    }
//
//    public void setCedula(String cedula) {
//        this.cedula = cedula;
//    }
//
//    public double getTotal() {
//        return total;
//    }
//
//    public void setTotal(double total) {
//        this.total = total;
//    }
//
//    public ConectionPg getCp() {
//        return cp;
//    }
//
//    public void setCp(ConectionPg cp) {
//        this.cp = cp;
//    }
//    
//
//    public int getId_producto() {
//        return id_producto;
//    }
//
//    public void setId_producto(int id_producto) {
//        this.id_producto = id_producto;
//    }
//
//    public String getNombre() {
//        return nombre;
//    }
//
//    public void setNombre(String nombre) {
//        this.nombre = nombre;
//    }
//
//    public double getPrecio() {
//        return precio;
//    }
//
//    public void setPrecio(double precio) {
//        this.precio = precio;
//    }
//
//    public int getCantidad() {
//        return cantidad;
//    }
//
//    public void setCantidad(int cantidad) {
//        this.cantidad = cantidad;
//    }
//
//    public String getDescripcion() {
//        return descripcion;
//    }
//
//    public void setDescripcion(String descripcion) {
//        this.descripcion = descripcion;
//    }
//
//    public Image getFoto() {
//        return foto;
//    }
//
//    public void setFoto(Image foto) {
//        this.foto = foto;
//    }
//
//    public String getSeccionProducto() {
//        return seccionProducto;
//    }
//
//    public void setSeccionProducto(String seccionProducto) {
//        this.seccionProducto = seccionProducto;
//    }
//    
    
//    Connection cn = cp.conectar();//--
    //Consultas
    public List<ModeloVenta> CargarProducto(String seccion) {
        List<ModeloVenta> listaProdu = new ArrayList<ModeloVenta>();
        String sql = "select * from producto where seccion = '" + seccion + "'";
        ResultSet rs = cp.consulta(sql);
        byte[] bytea;
        try {
            while (rs.next()) {
                ModeloVenta modven = new ModeloVenta();
                modven.setId_producto(rs.getInt("idproducto"));
                modven.setNombre(rs.getString("nombre"));
                modven.setPrecio(rs.getDouble("precio"));
                modven.setCantidad(rs.getInt("cantidad"));
                bytea = rs.getBytes("foto");
                if (bytea != null) {
                    try {
                        modven.setFoto(obtenerImagen(bytea));
                    } catch (IOException ex) {
                        Logger.getLogger(ModeloPersona.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                modven.setDescripcion(rs.getString("descripcion"));
                modven.setSeccionProducto(rs.getString("seccion"));
                listaProdu.add(modven);

            }
            rs.close();
            return listaProdu;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloVenta.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public List<ModeloVenta> BusquedaProducto(String buscar, String seccion) {
        List<ModeloVenta> listaProdu = new ArrayList<ModeloVenta>();
        String sql = "select * from producto where CAST(idproducto AS TEXT) LIKE '" + buscar + "%' or lower(nombre) like '" + buscar + "%' and seccion ='" + seccion + "'";
        ResultSet rs = cp.consulta(sql);
        byte[] bytea;
        try {
            while (rs.next()) {
                ModeloVenta modven = new ModeloVenta();
                modven.setId_producto(rs.getInt("idproducto"));
                modven.setNombre(rs.getString("nombre"));
                modven.setPrecio(rs.getDouble("precio"));
                modven.setCantidad(rs.getInt("cantidad"));
                bytea = rs.getBytes("foto");
                if (bytea != null) {
                    try {
                        modven.setFoto(obtenerImagen(bytea));
                    } catch (IOException ex) {
                        Logger.getLogger(ModeloPersona.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                modven.setDescripcion(rs.getString("descripcion"));
                modven.setSeccionProducto(rs.getString("seccion"));
                listaProdu.add(modven);
            }
            rs.close();
            return listaProdu;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloVenta.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    //--
    public List<ModeloVenta> CargarPro(String tip) {
        List<ModeloVenta> listaProducto = new ArrayList<ModeloVenta>();
        String sql = "select * from producto where nombre= '"+tip+"'";
        ResultSet rs = cp.consulta(sql);
        byte[] bytea;
        try {
            while (rs.next()) {
                ModeloVenta modven = new ModeloVenta();
                modven.setId_producto(rs.getInt("idproducto"));
                modven.setNombre(rs.getString("nombre"));
                modven.setPrecio(rs.getDouble("precio"));
                modven.setCantidad(rs.getInt("cantidad"));
                bytea = rs.getBytes("foto");
                if (bytea != null) {
                    try {
                        modven.setFoto(obtenerImagen(bytea));
                    } catch (IOException ex) {
                        Logger.getLogger(ModeloPersona.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                modven.setDescripcion(rs.getString("descripcion"));
                modven.setSeccionProducto(rs.getString("seccion"));
                listaProducto.add(modven);

            }
            rs.close();
            return listaProducto;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloVenta.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<Venta> TraerImagen(int in) {
        List<Venta> listaProducto = new ArrayList<Venta>();
        String sql = "select idproducto, foto from producto where idproducto = '" + in + "'";
        ResultSet rs = cp.consulta(sql);
        byte[] bytea;
        try {
            while (rs.next()) {
                Venta producto = new Venta();
                producto.setId_producto(rs.getInt("idproducto"));
                bytea = rs.getBytes("foto");
                if (bytea != null) {
                    try {
                        producto.setFoto(obtenerImagen(bytea));
                    } catch (IOException ex) {
                        Logger.getLogger(ModeloPersona.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                listaProducto.add(producto);

            }
            rs.close();
            return listaProducto;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloVenta.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    //__
    private Image obtenerImagen(byte[] bytes) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        Iterator it = ImageIO.getImageReadersByFormatName("jpeg");
        ImageReader reader = (ImageReader) it.next();
        Object source = bis;
        ImageInputStream iis = ImageIO.createImageInputStream(source);
        reader.setInput(iis, true);
        ImageReadParam param = reader.getDefaultReadParam();
        param.setSourceSubsampling(1, 1, 0, 0);
        return reader.read(0, param);
    }
    
    public List<ModeloVenta> TraerNombre(String cedula) {
        List<ModeloVenta> listapersona = new ArrayList<ModeloVenta>();
        String sql = "select idpersona, nombres, apellidos, foto from persona where idpersona like '" + cedula + "%'";
        ResultSet rs = cp.consulta(sql);
        byte[] bytea;
        try {
            while (rs.next()) {
                ModeloVenta modVen = new ModeloVenta();
                modVen.setCedula(rs.getString("idpersona"));
                modVen.setNombre(rs.getString("nombres"));
                modVen.setApellidos(rs.getString("apellidos"));
                bytea = rs.getBytes("foto");
                if (bytea != null) {
                    try {
                        modVen.setFoto(obtenerImagen(bytea));
                    } catch (IOException ex) {
                        Logger.getLogger(ModeloVenta.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                listapersona.add(modVen);

            }
            rs.close();
            return listapersona;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloVenta.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public int IncrementoCodigo(){
        int incremento = 1;
        try {
            String sql = "select max(idfactura) from factura";
            ResultSet rs = cp.consulta(sql);
            while (rs.next()) {
                incremento = rs.getInt(1) + 1;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return incremento;
    }
    
    //Consulta para descargar producto.
    public List<ModeloVenta> TraerProductoDespacho() {
        List<ModeloVenta> listaProductoV = new ArrayList<ModeloVenta>();
        String sql = "select * from producto";
        ResultSet rs = cp.consulta(sql);
        byte[] bytea;
        try {
            while (rs.next()) {
                ModeloVenta producto = new ModeloVenta();
                producto.setId_producto(rs.getInt("idproducto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setCantidad(rs.getInt("cantidad"));
                listaProductoV.add(producto);
            }
            rs.close();
            return listaProductoV;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloVenta.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public boolean ModificarProductoStock() {
        try {
            String sql = "UPDATE public.producto\n"
                    + "	SET cantidad=?\n"
                    + "	WHERE idproducto = '" + getId_producto() + "';";
            PreparedStatement ps = cp.getCon().prepareStatement(sql);
            ps.setInt(1, getCantidad());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloVenta.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    //Cargar todos los productos---------------------------------------------------------------------------
    public List<ModeloVenta> CargarProductoDiferente(String productob) {
        List<ModeloVenta> listaProdu = new ArrayList<ModeloVenta>();
        String sql = "select * from producto where CAST(idproducto AS TEXT) LIKE '" + productob + "%' or lower(nombre) like '" + productob + "%' and seccion != 'Frutas' and seccion != 'Vegetales' and seccion != 'Helado'";
        ResultSet rs = cp.consulta(sql);
        byte[] bytea;
        try {
            while (rs.next()) {
                ModeloVenta modven = new ModeloVenta();
                modven.setId_producto(rs.getInt("idproducto"));
                modven.setNombre(rs.getString("nombre"));
                modven.setPrecio(rs.getDouble("precio"));
                modven.setCantidad(rs.getInt("cantidad"));
                bytea = rs.getBytes("foto");
                if (bytea != null) {
                    try {
                        modven.setFoto(obtenerImagen(bytea));
                    } catch (IOException ex) {
                        Logger.getLogger(ModeloPersona.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                modven.setDescripcion(rs.getString("descripcion"));
                modven.setSeccionProducto(rs.getString("seccion"));
                listaProdu.add(modven);

            }
            rs.close();
            return listaProdu;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloVenta.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
    
    public List<ModeloVenta> CargarProductoDiferenteCad() {
        List<ModeloVenta> listaProdu = new ArrayList<ModeloVenta>();
        String sql = "select * from producto where seccion != 'Frutas' and seccion != 'Vegetales' and seccion != 'Helado'";

        ResultSet rs = cp.consulta(sql);
        byte[] bytea;
        try {
            while (rs.next()) {
                ModeloVenta modven = new ModeloVenta();
                modven.setId_producto(rs.getInt("idproducto"));
                modven.setNombre(rs.getString("nombre"));
                modven.setPrecio(rs.getDouble("precio"));
                modven.setCantidad(rs.getInt("cantidad"));
                bytea = rs.getBytes("foto");
                if (bytea != null) {
                    try {
                        modven.setFoto(obtenerImagen(bytea));
                    } catch (IOException ex) {
                        Logger.getLogger(ModeloPersona.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                modven.setDescripcion(rs.getString("descripcion"));
                modven.setSeccionProducto(rs.getString("seccion"));
                listaProdu.add(modven);

            }
            rs.close();
            return listaProdu;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloVenta.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

}
