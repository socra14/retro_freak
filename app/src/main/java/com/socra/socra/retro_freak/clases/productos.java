package com.socra.socra.retro_freak.clases;

public class productos {

    private int foto;
    private String descripcion;
    private String precio;


    public productos(String descripcion, String precio){}




    public productos (int foto, String descripcion, String precio){

        this.descripcion = descripcion;
        this.foto = foto;
        this.precio = precio;

    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
}
