package com.planilla.empleado.mapper;

import com.planilla.empleado.model.Usuario;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioMapper implements RowMapper<Usuario> {
    @Override
    public Usuario mapRow(ResultSet resultSet, int i) throws SQLException {
        Usuario usuario = new Usuario();
        usuario.setContrasena(resultSet.getString("contrasena"));
        usuario.setId(resultSet.getInt("id"));
        usuario.setNombre_usuario("nombre_usuario");
        return usuario;
    }
}
