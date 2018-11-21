package com.socra.socra.retro_freak.clases;

public class categorias {

    private int foto;
    private String nombre;

    public categorias(){}


    public categorias(int foto,String nombre){
        this.foto = foto;
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
