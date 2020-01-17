package com.planilla.empleado.service;

import java.sql.SQLException;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class ReportService implements IReportService {
    private Log logger = LogFactory.getLog(getClass());

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void onViewPago() {
        HashMap params = new HashMap();
        params.put("image", ReportService.class.getClassLoader().getResourceAsStream("logo.jpg"));
        JasperReport jreport;
        try {
            jreport = JasperCompileManager.compileReport(ReportService.class.getClassLoader().getResourceAsStream("report/Pagos.jrxml"));
            JasperPrint jprint = JasperFillManager.fillReport(jreport, params, jdbcTemplate.getDataSource().getConnection());
            JasperViewer.viewReport(jprint, false);
        } catch (JRException ex) {
            logger.error(ex);
            ex.printStackTrace();
        } catch (SQLException ex) {
            logger.error(ex);
            ex.printStackTrace();
        }
    }

    @Override
    public void onViewEmpleado() {
         HashMap params = new HashMap();
         params.put("image", ReportService.class.getClassLoader().getResourceAsStream("logo.jpg"));
        JasperReport jreport;
        try {
            jreport = JasperCompileManager.compileReport(ReportService.class.getClassLoader().getResourceAsStream("report/Empleados.jrxml"));
            JasperPrint jprint = JasperFillManager.fillReport(jreport, params, jdbcTemplate.getDataSource().getConnection());
            JasperViewer.viewReport(jprint, false);
        } catch (JRException ex) {
            logger.error(ex);
            ex.printStackTrace();
        } catch (SQLException ex) {
            logger.error(ex);
            ex.printStackTrace();
        }
    }

    @Override
    public void onViewActividad() {
        HashMap params = new HashMap();
        params.put("image", ReportService.class.getClassLoader().getResourceAsStream("logo.jpg"));
        JasperReport jreport;
        try {
            jreport = JasperCompileManager.compileReport(ReportService.class.getClassLoader().getResourceAsStream("report/Actividad.jrxml"));
            JasperPrint jprint = JasperFillManager.fillReport(jreport, params, jdbcTemplate.getDataSource().getConnection());
            JasperViewer.viewReport(jprint, false);
        } catch (JRException ex) {
            logger.error(ex);
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
            logger.error(ex);
        }
    }
}

interface IReportService {

    public void onViewPago();

    public void onViewEmpleado();

    public void onViewActividad();
}
