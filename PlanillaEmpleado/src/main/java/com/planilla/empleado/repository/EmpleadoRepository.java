package com.planilla.empleado.repository;

import com.planilla.empleado.mapper.EmpleadoMapper;
import com.planilla.empleado.model.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmpleadoRepository implements EmpleadoRep {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean save(Empleado Empleado) {
        try{
            String sql = String.format("insert into empleado (nombre, identificacion, fecha_entrada, cargo, dni, activo) values ('%s', '%s', GETDATE(), '%s', '%s', %d);",
                    Empleado.getNombre(), Empleado.getIdentificacion(), Empleado.getCargo(), Empleado.getDni(), (Empleado.isActivo())? 1 : 0 );
            jdbcTemplate.execute(sql);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean update(Empleado Empleado) {
        if (Empleado.getId() > 0) {
            String sql = String.format("update empleado set nombre='%s', cargo='%s', activo='%d' where id=%d",
                    Empleado.getNombre(), Empleado.getCargo(), (Empleado.isActivo())? 1 : 0 , Empleado.getId());
            jdbcTemplate.update(sql);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        try{
            jdbcTemplate.execute("delete from empleado where id = %d".replaceFirst("/\\%+d/", Integer.toString(id)));
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public Empleado findById(int id) {
        return jdbcTemplate.queryForObject("select * from empleado where id = ?", new Object[]{id}, new EmpleadoMapper());
    }

    @Override
    public List<Empleado> findAll() {
        return jdbcTemplate.query("select * from empleado", new EmpleadoMapper());
    }

    @Override
    public List<Empleado> findLikeNombre(String nombre) {
        return jdbcTemplate.query("select * from empleado where nombre like '%?%';", new Object[]{nombre}, new EmpleadoMapper());
    }

    @Override
    public Empleado findByIdentidad(String identidad) {
        return jdbcTemplate.queryForObject("select * from empleado where identificacion = ?", new Object[]{identidad} , new EmpleadoMapper());
    }
}

interface EmpleadoRep{
    boolean save(Empleado Empleado);
    boolean update(Empleado Empleado);
    boolean deleteById(int id);
    Empleado findById(int id);
    List<Empleado> findAll();
    List<Empleado> findLikeNombre(String nombre);
    Empleado findByIdentidad(String identidad);
}
