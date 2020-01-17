package com.planilla.empleado.model;

import java.util.Date;

public class Actividad {
    private int id;
    private Date fecha_entrada;
    private Date fecha_integracion;
    private Date fecha_salida;
    private int empleado;
    private boolean trabajado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha_entrada() {
        return fecha_entrada;
    }

    public void setFecha_entrada(Date fecha_entrada) {
        this.fecha_entrada = fecha_entrada;
    }

    public Date getFecha_integracion() {
        return fecha_integracion;
    }

    public void setFecha_integracion(Date fecha_integracion) {
        this.fecha_integracion = fecha_integracion;
    }

    public Date getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(Date fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public int getEmpleado() {
        return empleado;
    }

    public void setEmpleado(int empleado) {
        this.empleado = empleado;
    }

    public boolean isTrabajado() {
        return trabajado;
    }

    public void setTrabajado(boolean trabajado) {
        this.trabajado = trabajado;
    }
}
