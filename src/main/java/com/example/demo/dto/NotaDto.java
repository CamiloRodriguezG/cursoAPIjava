package com.example.demo.dto;

import java.util.Date;

import com.example.demo.model.Nota;

public class NotaDto{

    public String titulo;
    public String contenido;
    public Date fecha;
    public Long userId;

    public Nota getNotaFromDto(){
        Nota nota = new Nota();
        nota.setTitulo(titulo);
        nota.setContenido(contenido);
        nota.setFecha(fecha);

        return nota;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}