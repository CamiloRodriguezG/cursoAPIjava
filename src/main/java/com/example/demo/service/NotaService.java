package com.example.demo.service;

import com.example.demo.dto.NotaDto;
import com.example.demo.model.Nota;
import com.example.demo.model.User;
import java.util.List;
import java.util.Optional;

public interface NotaService{
    Nota save(NotaDto notaData);

    List<Nota> findByUser (User user);

    Optional<Nota> findById (Long id);
}