package com.example.demo;

import java.util.Date;

import com.example.demo.dto.UserDto;
import com.example.demo.model.Nota;
// import com.example.demo.model.Nota;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.service.impl.NotaServiceImpl;
import com.example.demo.service.impl.RoleServiceImpl;
import com.example.demo.service.impl.UserServiceImpl;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner initApp(UserServiceImpl userService, RoleServiceImpl roleService,
            NotaServiceImpl notaService) {
        return args -> {
            System.out.println("Hola");

            // creacion roles
            Role usuario = new Role();
            usuario.setDescription("Rol para usuarios");
            usuario.setName("Usuario");

            Role admin = new Role();
            admin.setDescription("Rol para administradores");
            admin.setName("Admin");

            admin = roleService.save(admin);
            usuario = roleService.save(usuario);

            User user1 = new User();
            user1.setName("camilo");
            user1.setPassword("123");
            user1.setUsername("camilo123");

            User savedUser = userService.alterSave(user1);

            Nota nota = new Nota();
            nota.setTitulo("titulo");
            nota.setContenido("contenido");
            nota.setFecha(new Date());
            nota.setUser(savedUser);

            notaService.save(nota);

            UserDto usr1 = new UserDto("coco", "coco123", "coco123456");
            UserDto usr2 = new UserDto("coca", "coca123", "coca123456");
            UserDto usr3 = new UserDto("caco", "caco123", "caco123456");
            userService.save(usr1);
            userService.save(usr2);
            userService.save(usr3);

        };
    }

}
