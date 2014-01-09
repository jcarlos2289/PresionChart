/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author JoseCarlos
 */
public class Conexion {

    Connection conexion;
    Statement consulta;
    public String ruta;

    public Conexion() {
        //ruta = Conexion.class.getResource("/Assets/DatosPresion.db").getPath();//String.valueOf(this.getClass().getResource("/Assets/DatosPresion.s3db"));
        //ruta = "C:/Users/JoseCarlos/Desktop/DatosPresion.s3db";
        //ruta = "/Assets/DatosPresion.s3db";
        //System.out.print(ruta);
        //"C:/Users/JoseCarlos/Desktop/DatosPresion.s3db";//"C:/Users/JoseCarlos/Desktop/DatosPresion.s3db""/home/taniao/Escritorio/registro.db";
    }

    public void conectar() {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage() + " 1 ");
        }
        try {
            conexion = DriverManager.getConnection("jdbc:sqlite:" + ruta);
            consulta = conexion.createStatement();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage() + " 2 " + ruta);
            System.exit(0);
        }
    }
}
