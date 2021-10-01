package com.example.demo.service.impl;

import com.example.demo.dao.NotaDao;
import com.example.demo.dto.NotaDto;
// import com.example.demo.dto.NotaDto;
import com.example.demo.model.Nota;
import com.example.demo.model.User;
import com.example.demo.service.NotaService;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service(value="notaService")
public class NotaServiceImpl implements NotaService{
    @Autowired
    private NotaDao notaDao;

    @Override
    public Nota save(NotaDto notaData) {
        Nota nota = new Nota();
        nota.setTitulo(notaData.getTitulo());
        nota.setContenido(notaData.getContenido());
        nota.setFecha(notaData.getFecha());

        return notaDao.save(nota);
    } 
    
    public Nota save(Nota nota) {
        return notaDao.save(nota);
    }

    @Override
    public List<Nota> findByUser(User user) {
        return notaDao.findByUser(user);
    }

    @Override
    public Optional<Nota> findById(Long id) {
        return notaDao.findById(id);
    }

    
}