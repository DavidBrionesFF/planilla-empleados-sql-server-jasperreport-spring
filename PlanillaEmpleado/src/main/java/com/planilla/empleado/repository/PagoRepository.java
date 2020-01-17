package com.planilla.empleado.repository;

import com.planilla.empleado.mapper.PagoMapper;
import com.planilla.empleado.model.Pago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PagoRepository implements PegoRep{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean save(Pago pago) {
        try{
            String sql = String.format("insert into pago (empleado, monto, cargos) values (%d,'%s','%s');",
                    pago.getEmpleado(), pago.getMonto()+ "", pago.getCargos() + "");
            jdbcTemplate.execute(sql);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Pago pago) {
        if (pago.getId() > 0){
            String sql = String.format("update pago set empleado='%d', monto='%s', cargos='%s' where id=%d",
                    pago.getEmpleado(), pago.getMonto()+ "", pago.getCargos() + "", pago.getId());
            jdbcTemplate.execute(sql);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        try{
            jdbcTemplate.execute("delete from pago where id = %d".replaceFirst("/\\%+d/", Integer.toString(id)));
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public Pago findById(int id) {
        return jdbcTemplate
                .queryForObject("select * from pago where id = ?", 
                        new Object[]{id}, 
                        new PagoMapper());
    }

    @Override
    public List<Pago> findAll() {
        return jdbcTemplate
                .query("select * from pago", new PagoMapper());
    }

    @Override
    public List<Pago> findLikeEmpleado(int idEmpleado) {
        return jdbcTemplate
                .query("select * from pago where empleado=?", 
                        new Object[]{idEmpleado}, 
                        new PagoMapper());
    }
}

interface PegoRep{
    boolean save(Pago pago);
    boolean update(Pago pago);
    boolean deleteById(int id);
    Pago findById(int id);
    List<Pago> findAll();
    List<Pago> findLikeEmpleado(int idEmpleado);
}
