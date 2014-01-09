/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDeDatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import presionchart.Medicion;

/**
 *
 * @author JoseCarlos
 */
public class GestorBD extends Conexion {

    public GestorBD(String rut) {
        ruta = rut;

    }

    private boolean ejecutarSQL(String sql) {
        Boolean valor = true;
        try {
            consulta.execute(sql);
            valor = true;
        } catch (SQLException e) {
            valor = false;
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            try {
                consulta.close();
                conexion.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return valor;
    }

    public ResultSet ejecutarQuery(String sql) {
        conectar();
        ResultSet resultado = null;
        try {
            resultado = consulta.executeQuery(sql);

        } catch (SQLException e) {
            System.out.println("Mensaje:" + e.getMessage());
            System.out.println("Estado:" + e.getSQLState());
            System.out.println("Codigo del error:" + e.getErrorCode());
            JOptionPane.showMessageDialog(null, "" + e.getMessage());
        }

        return resultado;
    }

    public boolean insertar(Medicion med) {
        conectar();
        String sql = "insert into Mediciones values(" + null
                + "," + med.getIdPersona()
                + ",\"" + med.getFecha()
                + "\"," + String.valueOf(med.getSistolico())
                + "," + String.valueOf(med.getDiastolico())
                + "," + String.valueOf(med.getEstado()) + ")";                  //kitar aki

        //System.out.println(sql);
        return ejecutarSQL(sql);
    }

    public boolean insertarPersona(String nombre, String apellido, int edad, String sexo) {
        conectar();
        String sql = "insert into Persona values(" + null
                + ",\"" + nombre.trim()
                + "\",\"" + apellido.trim()
                + "\"," + String.valueOf(edad)
                + ",\"" + sexo.trim()
                + "\")";

        //System.out.println(sql);
        return ejecutarSQL(sql);
    }

    public ResultSet getIdPersona(String nombre, String apellido, int edad, String sexo) {

        String sql = "select persona.id, Persona.Nombre , persona.Apellido from Persona where "
                + "Persona.Nombre = \"" + nombre + "\" and "
                + "Persona.Apellido = \"" + apellido + "\" and "
                + "Persona.Edad = " + String.valueOf(edad) + " and "
                + "Persona.Sexo = \"" + sexo + "\"Order by Persona.id desc Limit 1";

        ResultSet datos;
        //int filas = 0;
        datos = ejecutarQuery(sql);
        return datos;
    }

    public boolean actualizarMedicion(int idMedicion, Medicion med) {
        String sql = "Update Mediciones set "
                + "Fecha = \"" + med.getFecha() + "\", "
                + "Sistolico = " + String.valueOf(med.getSistolico()) + ", "
                + "Diastolico = " + String.valueOf(med.getDiastolico()) + ", "
                + "Estado = " + String.valueOf(med.getEstado()) + " " //Kitar aki 
                + "where id = " + String.valueOf(idMedicion);
        //System.out.println(sql);
        return ejecutarSQL(sql);
    }

    public boolean actualizarPersona(int id, String nombre, String apellido, int edad, String sexo) {

        String sql = "UPDATE Persona set "
                + "Nombre = \"" + nombre + "\" ,"
                + "Apellido = \"" + apellido + "\" , "
                + "Edad = " + String.valueOf(edad) + " , "
                + "Sexo = \"" + sexo + "\" "
                + "where id = " + String.valueOf(id);
        //System.out.println(sql);
        return ejecutarSQL(sql);
    }

    public boolean eliminarMedicion(int idMedicion) {
        String sql = "DELETE from Mediciones where id = " + String.valueOf(idMedicion);
        return ejecutarSQL(sql);
    }

    public boolean eliminarMedicionPersona(int id) {
        String sql = "DELETE from Mediciones where idPersona = " + String.valueOf(id);
        return ejecutarSQL(sql);
    }

    public boolean eliminarPersona(int id) {
        String sql = "DELETE from Persona where id = " + String.valueOf(id);
        return ejecutarSQL(sql);
    }

    public ResultSet getDatosMedicion(int idPersona, int limite) throws SQLException {
        //Medicion resultado[];
        String sql = "Select * from Mediciones where idPersona = " + String.valueOf(idPersona)
                + " order by Fecha desc limit " + String.valueOf(limite);
        ResultSet datos;
        //int filas = 0;
        datos = ejecutarQuery(sql);
        return datos;
    }

    public ResultSet getDatosPersona(int idPersona) throws SQLException {
        //Medicion resultado[];
        String sql = "Select * from Persona where id = " + String.valueOf(idPersona);
        ResultSet datos;
        //int filas = 0;
        datos = ejecutarQuery(sql);
        return datos;
    }

    private int obtenerId() {
        int id = -1;
        String sql = "Select MAX(id) From Mediciones ";

        ResultSet dato = ejecutarQuery(sql);

        if (dato != null) {
            try {
                id = dato.getInt("MAX(id)");
            } catch (Exception x) {
            }
        }

        return id;
    }
}
