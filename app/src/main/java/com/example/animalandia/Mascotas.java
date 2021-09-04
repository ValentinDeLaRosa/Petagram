package com.example.animalandia;

public class Mascotas implements Comparable<Mascotas> {
    private int id;
    private String nombre;
    private int foto;
    private int conteo;

    public int getId() {
        return id;
    }

    public Mascotas (int id, int foto, String nombre, int conteo){
        this.id = id;
        this.nombre = nombre;
        this.foto = foto;
        this.conteo = conteo;
    }

    public Mascotas() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getConteo() {return conteo; }

    public void setConteo(int conteo) { this.conteo = conteo; }

    @Override
    public int compareTo(Mascotas o) {
        return (o.getConteo() - this.conteo);
    }
}
