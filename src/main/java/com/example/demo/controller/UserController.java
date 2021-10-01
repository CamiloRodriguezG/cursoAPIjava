package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.example.demo.dto.UserDto;
import com.example.demo.model.User;
import com.example.demo.service.impl.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public User saveUser(@RequestBody UserDto user, HttpServletResponse response) throws IOException {
        if (user.getUsername() == null){
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
        return userService.save(user);
    }
    @GetMapping("/listUsers")
    public List<User> listUsers(){
        return userService.findAll();
    }
    @GetMapping("/byInitial/{letra}")
    public List <User> porInicial( @PathVariable(value="letra") String letra ){
        return userService.findByInitial(letra);
    }
}
