package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.dto.UserDto;
import com.example.demo.model.User;

//Interfaz para definir las caracteristicas de un servicio
//más no la implementación

public interface UserService{
    User save(UserDto userInf);
    List <User> findAll();
    Optional <User> findOne (String username);

    List <User> findByInitial(String letra);

    Optional <User> findByName(String name);

    Optional<User> findById(Long id);
}
