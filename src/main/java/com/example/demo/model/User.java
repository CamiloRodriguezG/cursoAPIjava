package com.example.demo.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; //la base de datos


    @Column
    private String username;//logeo
    @Column
    private String password;//logeo
    @Column
    private String name;//info extra
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "USER_ROLES", 
        joinColumns = {
            @JoinColumn(name = "USER_ID")
        },
        inverseJoinColumns = {
            @JoinColumn(name = "ROLE_ID")
        }
    )
    private Set<Role> roles;
    

    @OneToMany(mappedBy = "user")
    private List<Nota> notas;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

    public void addRole(Role role){
        if(this.roles!=null){
            this.roles.add(role);
        }else{
            this.roles = new HashSet<>();
            this.roles.add(role);
        }
    }

}
