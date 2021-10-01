package com.example.demo.controller;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.example.demo.dto.NotaDto;
import com.example.demo.model.Nota;
import com.example.demo.model.User;
import com.example.demo.service.impl.NotaServiceImpl;
import com.example.demo.service.impl.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/nota")
public class NotaController {
    @Autowired
    private NotaServiceImpl notaService;
    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    private Nota saveNota(@RequestBody NotaDto nota, HttpServletResponse response) throws IOException{
        if (nota.getTitulo() == null){
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
        if(nota.getContenido() == null){
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
        User user = userService.findById(nota.getUserId()).get();
        Nota nota2 = nota.getNotaFromDto();
        nota2.setUser(user);

        return notaService.save(nota2);
    }
    @GetMapping("/byUser/{nombre}")
    public List<Nota> porInicial( @PathVariable(value="nombre") String nombre ){
        return notaService.findByUser(userService.findOne(nombre).get());
    }

}
