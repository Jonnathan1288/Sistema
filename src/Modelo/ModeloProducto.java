/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
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
import javax.swing.ImageIcon;

/**
 *
 * @author DELL
 */
public class ModeloProducto extends Producto {

    ConectionPg cp = new ConectionPg();

    public ModeloProducto() {
    }

    public ModeloProducto(int id_producto, String nombre, double precio, int cantidad, String descripcion, Image foto) {
        super(id_producto, nombre, precio, cantidad, descripcion, foto);
    }

    public List<Producto> CargarProducto() {
        List<Producto> listaProducto = new ArrayList<Producto>();
        String sql = "select * from producto";
        ResultSet rs = cp.consulta(sql);
        byte[] bytea;
        try {
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setId_producto(rs.getInt("idproducto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setCantidad(rs.getInt("cantidad"));
                bytea = rs.getBytes("foto");
                if (bytea != null) {
                    try {
                        producto.setFoto(obtenerImagen(bytea));
                    } catch (IOException ex) {
                        Logger.getLogger(ModeloPersona.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setSeccionProducto(rs.getString("seccion"));
                listaProducto.add(producto);

            }
            rs.close();
            return listaProducto;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloProducto.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public List<Producto> TraerImagen(int in) {
        List<Producto> listaProducto = new ArrayList<Producto>();
        String sql = "select idproducto, foto from producto where idproducto = '"+in+"'";
        ResultSet rs = cp.consulta(sql);
        byte[] bytea;
        try {
            while (rs.next()) {
                Producto producto = new Producto();
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
            Logger.getLogger(ModeloProducto.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

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

    public boolean CrearProductoBy() {
        try {
            String sql = "INSERT INTO public.producto(\n"
                    + "	idproducto, nombre, precio, cantidad, foto, descripcion, seccion)\n"
                    + "	VALUES (?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement ps = cp.getCon().prepareStatement(sql);
            ps.setInt(1, getId_producto());
            ps.setString(2, getNombre());
            ps.setDouble(3, getPrecio());
            ps.setInt(4, getCantidad());
            ps.setBinaryStream(5, getImagen(), getLargo());
            ps.setString(6, getDescripcion());
            ps.setString(7, getSeccionProducto());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloProducto.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean ModificarProductoBy() {
        try {
            String sql = "UPDATE public.producto\n"
                    + "	SET idproducto=?, nombre=?, precio=?, cantidad=?, foto=?, descripcion=?, seccion=?\n"
                    + "	WHERE idproducto = '" + getId_producto() + "';";
            PreparedStatement ps = cp.getCon().prepareStatement(sql);
            ps.setInt(1, getId_producto());
            ps.setString(2, getNombre());
            ps.setDouble(3, getPrecio());
            ps.setInt(4, getCantidad());
            ps.setBinaryStream(5, getImagen(), getLargo());
            ps.setString(6, getDescripcion());
             ps.setString(7, getSeccionProducto());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloProducto.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean ModificarProductoBy1() {
        try {
            String sql = "UPDATE public.producto\n"
                    + "	SET idproducto=?, nombre=?, precio=?, cantidad=?, descripcion=?, seccion=?\n"
                    + "	WHERE idproducto = '" + getId_producto() + "';";
            PreparedStatement ps = cp.getCon().prepareStatement(sql);
            ps.setInt(1, getId_producto());
            ps.setString(2, getNombre());
            ps.setDouble(3, getPrecio());
            ps.setInt(4, getCantidad());
            ps.setString(5, getDescripcion());
             ps.setString(6, getSeccionProducto());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloProducto.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean crearProducto() {
        String sql = "INSERT INTO producto(\n"
                + "	idproducto, nombre, precio, cantidad, descripcion)\n"
                + "	VALUES ('" + getId_producto() + "', '" + getNombre() + "', '" + getPrecio() + "', '" + getCantidad() + "', '" + getDescripcion() + "');";
        System.out.println("" + sql);
        return cp.accion(sql);
    }

    public boolean ModificarProducto() {
        String sql = "UPDATE producto\n"
                + "	SET nombre='" + getNombre() + "', precio='" + getPrecio() + "', cantidad='" + getCantidad() + "', descripcion='" + getDescripcion() + "'\n"
                + "	WHERE idproducto = '" + getId_producto() + "';";
        System.out.println("" + sql);
        return cp.accion(sql);
    }

    public boolean EliminarProducto(String idproduc) {
        String sql = "delete from producto where idproducto = '" + idproduc + "'";
        System.out.println("" + sql);
        return cp.accion(sql);
    }
    public List<Producto> BuscarProducto(String texto) {
        List<Producto> listaProducto = new ArrayList<Producto>();
        String sql = "select * from producto where CAST(idproducto AS TEXT) LIKE '" + texto + "%' or lower(nombre) like '" + texto + "%'";
        ResultSet rs = cp.consulta(sql);
        byte[] bytea;
        try {
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setId_producto(rs.getInt("idproducto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setCantidad(rs.getInt("cantidad"));

                bytea = rs.getBytes("foto");
                if (bytea != null) {
                    //Decodificando del formato de la base.(Base64)

//                bytea=Base64.decode(bytea,0,bytea.length);
                    try {
                        producto.setFoto(obtenerImagen(bytea));
                    } catch (IOException ex) {
                        Logger.getLogger(ModeloPersona.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                producto.setDescripcion(rs.getString("descripcion"));
                listaProducto.add(producto);

            }
            rs.close();
            return listaProducto;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloProducto.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<Producto> filtroBusqueda(String texto) {
        List<Producto> BuscaProducto = new ArrayList<Producto>();
//        String sql = "select * from producto where idproducto like "+'"'+texto+'"'+"_%";
        String sql = "select * from producto where CAST(idproducto AS TEXT) LIKE '" + texto + "%' or lower(nombre) like '" + texto + "%'";
        ResultSet rs = cp.consulta(sql);
        try {
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setId_producto(rs.getInt("idproducto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setCantidad(rs.getInt("cantidad"));
                producto.setDescripcion(rs.getString("descripcion"));
                BuscaProducto.add(producto);
            }
            rs.close();
            return BuscaProducto;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloProducto.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    //Método que permite incrementar el ID del atributo de la entidad Persona.
    public int IncrementoIdProducto(){
        int incremento = 1;
        try {
            String sql = "select max(idproducto) from producto";
            ResultSet rs = cp.consulta(sql);
            while (rs.next()) {
                incremento = rs.getInt(1) + 1;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return incremento;
    }
}
