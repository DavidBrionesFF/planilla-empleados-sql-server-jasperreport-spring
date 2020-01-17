package com.planilla.empleado;

import com.planilla.empleado.view.IniciarSesionView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class App implements CommandLineRunner{
    @Autowired
    private IniciarSesionView iniciarSesion;
    
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(App.class)
                .headless(false)
                .run(args);
        
    }

    @Override
    public void run(String... args) throws Exception {
        iniciarSesion.setLocationRelativeTo(null);
        iniciarSesion.setResizable(false);
        iniciarSesion.setVisible(true);
    }
}
