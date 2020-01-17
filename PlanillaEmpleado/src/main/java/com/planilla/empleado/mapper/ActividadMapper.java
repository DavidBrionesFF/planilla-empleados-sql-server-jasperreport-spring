package com.planilla.empleado.mapper;

import com.planilla.empleado.model.Actividad;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ActividadMapper implements RowMapper<Actividad> {
    @Override
    public Actividad mapRow(ResultSet resultSet, int i) throws SQLException {
        Actividad actividad = new Actividad();
        actividad.setEmpleado(resultSet.getInt("empleado"));
        actividad.setFecha_entrada(resultSet.getDate("fecha_entrada"));
        actividad.setFecha_integracion(resultSet.getDate("fecha_integracion"));
        actividad.setId(resultSet.getInt("id"));
        actividad.setFecha_salida(resultSet.getDate("fecha_salida"));
        actividad.setTrabajado(resultSet.getBoolean("trabajado"));
        return actividad;
    }
}
