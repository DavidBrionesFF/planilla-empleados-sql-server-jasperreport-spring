package com.planilla.empleado.repository;

import com.planilla.empleado.mapper.ActividadMapper;
import com.planilla.empleado.model.Actividad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class ActividadRepository implements ActividadRep{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public boolean save(Actividad actividad) {
        try {
            String sql = String.format("insert into actividad (fecha_entrada, fecha_salida, empleado, trabajado) values (getDate(), getDate(), %d, %d);",
                    actividad.getEmpleado(),
                    (actividad.isTrabajado())? 1 : 0);
            jdbcTemplate.execute(sql);
            return true;
        }catch(Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(Actividad actividad) {
        if (actividad.getId()>0){
            String sql = String.format("update actividad set fecha_entrada=%s, fecha_salida=%s, empleado=%d, trabajado=%d where id=%d",
                    new Timestamp(actividad.getFecha_entrada().getTime()), new Timestamp(actividad.getFecha_salida().getTime()), actividad.getEmpleado(),
                    (actividad.isTrabajado())? 1 : 0,
                    actividad.getId());
            jdbcTemplate.execute(sql);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        try{
            jdbcTemplate.execute("delete from actividad where id = %d".replaceFirst("/\\%+d/", Integer.toString(id)));
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public Actividad findById(int id) {
        return jdbcTemplate.queryForObject("select * from actividad where id=?", new Object[]{id}, new ActividadMapper());
    }

    @Override
    public List<Actividad> findAll() {
        return jdbcTemplate.query("select * from actividad", new ActividadMapper());
    }

    @Override
    public List<Actividad> findByEmpleado(int idEmpleado) {
        return jdbcTemplate.query("select * from actividad where empleado=?", new Object[]{idEmpleado}, new ActividadMapper());
    }
}

interface ActividadRep{
    boolean save(Actividad actividad);
    boolean update(Actividad actividad);
    boolean deleteById(int id);
    Actividad findById(int id);
    List<Actividad> findAll();
    List<Actividad> findByEmpleado(int idEmpleado);
}
