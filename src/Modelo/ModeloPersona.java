    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

//import java.awt.Image;
//import java.io.ByteArrayInputStream;
//import java.sql.Date;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
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
public class ModeloPersona extends Persona {

    ConectionPg cp = new ConectionPg();

    public ModeloPersona() {
    }

    public ModeloPersona(String idPersona, String nombres, String apellidos, Date fechaNacimiento, String telefono, String sexo, double sueldo, int cupo, Image foto) {
        super(idPersona, nombres, apellidos, fechaNacimiento, telefono, sexo, sueldo, cupo, foto);
    }

    public List<Persona> listarPersonas() {
        List<Persona> lp = new ArrayList<Persona>();
        try {
            String sql = "select *from persona";
            ResultSet rs = cp.consulta(sql);
            byte[] bytea;
            while (rs.next()) {
                Persona persona = new Persona();
                persona.setIdPersona(rs.getString("idpersona"));
                persona.setNombres(rs.getString("nombres"));
                persona.setApellidos(rs.getString("apellidos"));
                persona.setFechaNacimiento(rs.getDate("fechanacimiento"));
                persona.setTelefono(rs.getString("telefono"));
                persona.setSexo(rs.getString("sexo"));
                persona.setSueldo(rs.getDouble("sueldo"));
                persona.setCupo(rs.getInt("cupo"));
                bytea = rs.getBytes("foto");
                if (bytea != null) {
                    try {
                        persona.setFoto(obtenerImagen(bytea));
                    } catch (IOException ex) {
                        Logger.getLogger(ModeloPersona.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                lp.add(persona);
            }
            rs.close();
            return lp;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloPersona.class.getName()).log(Level.SEVERE, null, ex);
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

    public boolean crearPersonaByte() {
        try {
            String sql;
            sql = "INSERT INTO persona (idpersona, nombres, apellidos, fechanacimiento, telefono, sexo, sueldo, cupo, foto)";
            sql += "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = cp.getCon().prepareStatement(sql);
            ps.setString(1, getIdPersona());
            ps.setString(2, getNombres());
            ps.setString(3, getApellidos());
            ps.setDate(4, getFechaNacimiento());
            ps.setString(5, getTelefono());
            ps.setString(6, getSexo());
            ps.setDouble(7, getSueldo());
            ps.setInt(8, getCupo());
            ps.setBinaryStream(9, getImagen(), getLargo());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloPersona.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean ModificarPersonaByte() {
        try {
            String sql = "UPDATE public.persona\n"
                    + "	SET idpersona=?, nombres=?, apellidos=?, fechanacimiento=?, telefono=?, sexo=?, sueldo=?, cupo=?, foto=?\n"
                    + "	WHERE idpersona ='" + getIdPersona() + "'";
            PreparedStatement ps = cp.getCon().prepareStatement(sql);
            ps.setString(1, getIdPersona());
            ps.setString(2, getNombres());
            ps.setString(3, getApellidos());
            ps.setDate(4, getFechaNacimiento());
            ps.setString(5, getTelefono());
            ps.setString(6, getSexo());
            ps.setDouble(7, getSueldo());
            ps.setInt(8, getCupo());
            ps.setBinaryStream(9, getImagen(), getLargo());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloPersona.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public boolean ModificarPersonaFT() {
        try {
            String sql = "UPDATE public.persona\n"
                    + "	SET idpersona=?, nombres=?, apellidos=?, fechanacimiento=?, telefono=?, sexo=?, sueldo=?, cupo=?\n"
                    + "	WHERE idpersona ='" + getIdPersona() + "'";
            PreparedStatement ps = cp.getCon().prepareStatement(sql);
            ps.setString(1, getIdPersona());
            ps.setString(2, getNombres());
            ps.setString(3, getApellidos());
            ps.setDate(4, getFechaNacimiento());
            ps.setString(5, getTelefono());
            ps.setString(6, getSexo());
            ps.setDouble(7, getSueldo());
            ps.setInt(8, getCupo());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloPersona.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean crearpersona() {
        String sql = "INSERT INTO persona(\n"
                + "	idpersona, nombres, apellidos, fechanacimiento, telefono, sexo, sueldo, cupo)\n"
                + "	VALUES ('" + getIdPersona() + "', '" + getNombres() + "', '" + getApellidos() + "', '" + getFechaNacimiento() + "', '" + getTelefono() + "', '" + getSexo() + "', '" + getSueldo() + "', '" + getCupo() + "');";

        System.out.println("" + sql);
        return cp.accion(sql);
    }

    public boolean eliminarPersona(String cedula) {
        String sql = "DELETE FROM persona WHERE idpersona = '" + cedula + "';";
        System.out.println("" + sql);
        return cp.accion(sql);
    }

    public boolean modificarPersona(String cedula) {
        String sql = "UPDATE persona SET nombres= '" + getNombres() + "', apellidos= '" + getApellidos() + "', fechanacimiento= '" + getFechaNacimiento() + "', telefono = '" + getTelefono() + "', sexo= '" + getSexo() + "', sueldo= '" + getSueldo() + "', cupo= '" + getCupo() + "' WHERE idpersona ='" + cedula + "'";
        System.out.println("" + sql);
        return cp.accion(sql);
    }
    
    public List<Persona> BuscarPersona(String busqueda) {
        List<Persona> lp = new ArrayList<Persona>();
        try {
        String sql = "select * from persona where idpersona like '" + busqueda + "%' or lower(nombres) like '" + busqueda + "%' or lower(apellidos) like '" + busqueda + "%';";
            ResultSet rs = cp.consulta(sql);
            byte[] bytea;
            while (rs.next()) {
                Persona persona = new Persona();
                persona.setIdPersona(rs.getString("idpersona"));
                persona.setNombres(rs.getString("nombres"));
                persona.setApellidos(rs.getString("apellidos"));
                persona.setFechaNacimiento(rs.getDate("fechanacimiento"));
                persona.setTelefono(rs.getString("telefono"));
                persona.setSexo(rs.getString("sexo"));
                persona.setSueldo(rs.getDouble("sueldo"));
                persona.setCupo(rs.getInt("cupo"));
                bytea = rs.getBytes("foto");
                if (bytea != null) {
                    //Decodificando del formato de la base.(Base64)

//                bytea=Base64.decode(bytea,0,bytea.length);
                    try {
                        persona.setFoto(obtenerImagen(bytea));
                    } catch (IOException ex) {
                        Logger.getLogger(ModeloPersona.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                lp.add(persona);
            }
            rs.close();
            return lp;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloPersona.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public List<Persona> BusquedaPersona(String busqueda) {
        List<Persona> listaBusqueda = new ArrayList<>();
        String sql = "select * from persona where idpersona like '" + busqueda + "%' or lower(nombres) like '" + busqueda + "%' or lower(apellidos) like '" + busqueda + "%';";
        ResultSet rs = cp.consulta(sql);
        try {
            while (rs.next()) {
                Persona person = new Persona();
                person.setIdPersona(rs.getString("idpersona"));
                person.setNombres(rs.getString("nombres"));
                person.setApellidos(rs.getString("apellidos"));
                person.setFechaNacimiento(rs.getDate("fechanacimiento"));
                person.setTelefono(rs.getString("telefono"));
                person.setSexo(rs.getString("sexo"));
                person.setSueldo(rs.getDouble("sueldo"));
                person.setCupo(rs.getInt("cupo"));
                listaBusqueda.add(person);
            }
            return listaBusqueda;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloPersona.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
