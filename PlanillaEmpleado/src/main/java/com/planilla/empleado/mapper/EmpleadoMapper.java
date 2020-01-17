package com.planilla.empleado.mapper;

import com.planilla.empleado.model.Empleado;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpleadoMapper implements RowMapper<Empleado> {
    @Override
    public Empleado mapRow(ResultSet resultSet, int i) throws SQLException {
        Empleado empleado = new Empleado();
        empleado.setCargo(resultSet.getString("cargo"));
        empleado.setFecha_entrada(resultSet.getDate("fecha_entrada"));
        empleado.setFecha_integracion(resultSet.getDate("fecha_integracion"));
        empleado.setId(resultSet.getInt("id"));
        empleado.setNombre(resultSet.getString("nombre"));
        empleado.setIdentificacion(resultSet.getString("identificacion"));
        empleado.setDni(resultSet.getString("dni"));
        empleado.setActivo(resultSet.getBoolean("activo"));
        return empleado;
    }
}
