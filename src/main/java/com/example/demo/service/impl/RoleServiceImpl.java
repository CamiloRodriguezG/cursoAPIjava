package com.example.demo.service.impl;

import com.example.demo.dao.RoleDao;
import com.example.demo.model.Role;
import com.example.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "roleService")
public class RoleServiceImpl implements RoleService{
    
    @Autowired
    private RoleDao roleDao;

    @Override
    public Role findByName(String name) {
        return roleDao.findRoleByName(name);
    }
    
    @Override
    public Role save(Role role) {
        return roleDao.save(role);
    }
    
}