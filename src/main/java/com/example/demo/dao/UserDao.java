package com.example.demo.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.User;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public interface UserDao extends CrudRepository <User, Long> {
    
    Optional<User> findByUsername(String username);
    Optional<User> findById(Long id);
    Optional<User> findByName(String name);

    @Query("from User u where u.name like CONCAT('%',:letra,'%')")
    List<User> findByInitial( @Param("letra") String letra);
    
}