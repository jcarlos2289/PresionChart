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
public class ServiciosBD {

    public ServiciosBD() {
    }

    public boolean crearBD(String ruta) {
        try {
            Class.forName("org.sqlite.JDBC");//especificamos el driver
            try (Connection conn = DriverManager.getConnection("jdbc:sqlite:" + ruta)) {
                Statement stat = (Statement) conn.createStatement();
                stat.executeUpdate(
                        "CREATE TABLE [Mediciones] ("
                        + "[id] INTEGER  PRIMARY KEY AUTOINCREMENT NOT NULL,"
                        + "[idPersona] INTEGER  NOT NULL,"
                        + "[Fecha] DATE DEFAULT CURRENT_DATE NOT NULL,"
                        + "[Sistolico] FLOAT  NOT NULL,"
                        + "[Diastolico] FLOAT  NOT NULL,"
                        + "[Estado] INTEGER  NULL);"
                        + "CREATE TABLE [Persona] ("
                        + "[id] INTEGER  NOT NULL PRIMARY KEY AUTOINCREMENT,"
                        + "[Nombre] NVARCHAR(20)  NOT NULL,"
                        + "[Apellido] NVARCHAR(20)  NOT NULL,"
                        + "[Edad] INTEGER  NULL,"
                        + "[Sexo] NVARCHAR(1)  NOT NULL);"
                        + "CREATE VIEW [ListaMediciones] AS "
                        + "select Persona.Nombre, Persona.Apellido, Mediciones.Fecha, Mediciones.Sistolico , Mediciones.Diastolico, "
                        + "Mediciones.Estado from Persona join Mediciones where persona.id = Mediciones.idPersona  order by Persona.id;"
                        + "CREATE TRIGGER [BorrarMedicionesYPersona] "
                        + "AFTER DELETE ON [Persona] "
                        + "FOR EACH ROW "
                        + "BEGIN "
                        + "Delete from Mediciones where MEDICIONES.idPersona = OLD.id; "
                        + "END;");


                stat.executeUpdate("insert into Persona values( null, \"Usuario\", \"Default\", 45, \"M\");");
                stat.executeUpdate("insert into Mediciones values (null, 1, \"2014-01-01\", 150, 90,4)");
                stat.close();

                //rutaDB = ruta;
                return true;
                //JOptionPane.showMessageDialog(null, "Se creo el archivo correctamente.");
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            return false;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }


    }

    public boolean borrarBD(String ruta) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:" + ruta);
            Statement stat = conn.createStatement();
            stat.executeUpdate("DELETE FROM Persona");
            stat.executeUpdate("DELETE FROM Mediciones");
            stat.executeUpdate("DELETE FROM sqlite_sequence WHERE name='Mediciones'");
            stat.executeUpdate("DELETE FROM sqlite_sequence WHERE name='Persona'");
            stat.executeUpdate("insert into Persona values( null, \"Usuario\", \"Default\", 45, \"M\");");
            stat.executeUpdate("insert into Mediciones values (null, 1, \"2014-01-01\", 150, 90,4)");

            stat.close();
            conn.close();
            return true;
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            return false;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }

    }
}
