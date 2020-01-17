package com.planilla.empleado.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioRepository implements UsuarioRep{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean existsByNombreUsuarioAndContrasena(String NombreUsuario, String Contrasena) {
        return jdbcTemplate.queryForObject("select COUNT(*) from usuario where nombre_usuario = ? and contrasena = ?",
                new Object[]{
                   NombreUsuario,
                   Contrasena
                },
                Long.class) > 0;
    }
}

interface UsuarioRep{
    public boolean existsByNombreUsuarioAndContrasena(String NombreUsuario, String Contrasena);
}
