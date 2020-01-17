package com.planilla.empleado.mapper;

import com.planilla.empleado.model.Pago;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PagoMapper implements RowMapper<Pago> {
    @Override
    public Pago mapRow(ResultSet resultSet, int i) throws SQLException {
        Pago pago = new Pago();
        pago.setCargos(resultSet.getDouble("cargos"));
        pago.setEmpleado(resultSet.getInt("empleado"));
        pago.setId(resultSet.getInt("id"));
        pago.setMonto(resultSet.getDouble("monto"));
        pago.setFecha_pago(resultSet.getDate("fecha_pago"));
        return pago;
    }
}
