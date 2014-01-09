/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presionchart;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JoseCarlos
 */
public class FechasParser {

    public static String parseString(Date fecha) { //recibe un objto date
        //devuelve un String en formato 2014-02-01 se usa para 
        DateFormat df;                              //formatear lacadena que va a BD    
        String fechaString = null;

        df = new SimpleDateFormat("yyyy-MM-dd");

        fechaString = df.format(fecha);
        return fechaString;

    }

    public static String parseString2(String fechaOriginal) {//recibe fecha en String 2014-02-01
        //devuelve un String en formato 1-feb-2014 

        Date fecha;
        fecha = parseDate(fechaOriginal);

        DateFormat df;
        String fechaString = null;

        df = new SimpleDateFormat("dd-MMM-yyyy");

        fechaString = df.format(fecha);
        return fechaString;

    }

    public static Date parseDate(String fecha) {//recibe fecha en String 2014-02-01
        //devuelve un objeto date  

        DateFormat df;
        Date fechaDate = new Date();

        df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            fechaDate = df.parse(fecha);
        } catch (ParseException ex) {
            Logger.getLogger(FechasParser.class.getName()).log(Level.SEVERE, null, ex);
        }


        return fechaDate;
    }

    public static Date parseDate2(String fecha) { //recibe fecha en String 2-feb-2014
        //devuelve un objeto date  
        DateFormat df;
        Date fechaDate = new Date();

        df = new SimpleDateFormat("dd-MMM-yyyy");
        try {
            fechaDate = df.parse(fecha);
        } catch (ParseException ex) {
            Logger.getLogger(FechasParser.class.getName()).log(Level.SEVERE, null, ex);
        }


        return fechaDate;

    }

    public static String fecha_calendario(Date cal) {
        //SimpleDateFormat sdf;
        DateFormat df;
        //sdf = new SimpleDateFormat("yyyy-MM-dd");
        df = DateFormat.getDateInstance(DateFormat.LONG);

        String fec = df.format(cal);
        return fec;
    }
}
