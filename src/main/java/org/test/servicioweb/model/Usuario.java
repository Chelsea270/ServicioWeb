package org.test.servicioweb.model;

public class Usuario {
    private int id;
    private String nombre;
    private String username;
    private String email;
    private String telefono;
    private String ciudad;
    private String empresa;

    public Usuario() {
    }

    public Usuario(int id, String empresa, String ciudad, String telefono, String email, String username, String nombre) {
        this.id = id;
        this.empresa = empresa;
        this.ciudad = ciudad;
        this.telefono = telefono;
        this.email = email;
        this.username = username;
        this.nombre = nombre;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
