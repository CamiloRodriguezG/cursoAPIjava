package com.example.demo.dao;

import com.example.demo.model.Nota;
import com.example.demo.model.User;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface NotaDao extends CrudRepository <Nota, Long>{
    List <Nota> findByUser (User user);
    Optional<Nota> findById(Long id);
}
