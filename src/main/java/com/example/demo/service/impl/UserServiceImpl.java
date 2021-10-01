package com.example.demo.service.impl;

import com.example.demo.dao.RoleDao;
import com.example.demo.dao.UserDao;
import com.example.demo.dto.UserDto;
import com.example.demo.service.UserService;
import com.example.demo.model.User;
import com.example.demo.model.Role;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "userService")
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;
    // METODOS DEFINIDOS POR LA INTERFACE
    @Override
    public List<User> findAll() {
        return (List<User>) userDao.findAll();
    }

    @Override
    public Optional<User> findOne(String username) {
        return userDao.findByUsername(username);
    }
    
    @Override
    public User save(UserDto userInf) {
        User userToSave = userInf.getUserFromDto();
        Role usr = roleDao.findRoleByName("Usuario");
        userToSave.addRole(usr);
        //Optional<Role> usr = roleDao.findById((long) 1);
        //userToSave.addRole(usr.get());
        
        return userDao.save(userToSave);
    }
    
    public User alterSave(User userInf) {
        return userDao.save(userInf);
    }

    @Override
    public List<User> findByInitial(String letra) {
        return userDao.findByInitial(letra);
    }

    @Override
    public Optional<User> findByName(String name) {
        return findByName(name);
    }

    @Override
    public Optional<User> findById(Long id){
        return userDao.findById(id);
    }
}