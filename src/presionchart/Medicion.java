/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presionchart;

import java.util.Date;

/**
 *
 * @author JoseCarlos
 */
public class Medicion {

    private int idPersona;
    private String fecha;
    private float diastolico;
    private float sistolico;
    private int estado;

    public Medicion(int id, String fecha, float sist, float diast) {//, int estado) {
        this.idPersona = id;
        this.fecha = fecha;
        this.diastolico = diast;
        this.sistolico = sist;
        this.estado = determinarEstado(sistolico, diastolico);
    }

    public Medicion(int id, String fecha, float sist, float diast, int estado) {//, int estado) {
        this.idPersona = id;
        this.fecha = fecha;
        this.diastolico = diast;
        this.sistolico = sist;
        this.estado = estado;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public String getFecha() {
        return fecha;
    }

    public float getDiastolico() {
        return diastolico;
    }

    public float getSistolico() {
        return sistolico;
    }

    public int getEstado() {
        return estado;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setDiastolico(float diastolico) {
        this.diastolico = diastolico;
    }

    public void setSistolico(float sistolico) {
        this.sistolico = sistolico;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public static int determinarEstado(float preSistolica, float preDiastolica) {
        int estado = -1;

        if (preSistolica > preDiastolica) {
            if (preSistolica <= 100) {
                estado = 0;
            } else if (preSistolica > 100 && preSistolica <= 120) {
                estado = 1;
            } else if (preSistolica > 120 && preSistolica <= 130) {
                estado = 2;
            } else if (preSistolica > 130 && preSistolica <= 140) {
                estado = 3;
            } else if (preSistolica > 140 && preSistolica <= 160) {
                estado = 4;
            } else if (preSistolica > 160 && preSistolica < 180) {
                estado = 5;
            } else if (preSistolica >= 180) {
                estado = 6;
            }
        } else if (preSistolica < preDiastolica) {
            if (preDiastolica <= 60) {
                estado = 0;
            } else if (preDiastolica > 60 && preDiastolica <= 80) {
                estado = 1;
            } else if (preDiastolica > 80 && preDiastolica <= 85) {
                estado = 2;
            } else if (preDiastolica > 85 && preDiastolica <= 90) {
                estado = 3;
            } else if (preDiastolica > 90 && preDiastolica <= 100) {
                estado = 4;
            } else if (preDiastolica > 100 && preDiastolica < 110) {
                estado = 5;
            } else if (preDiastolica >= 110) {
                estado = 6;
            }
        }
        return estado;
    }
}
