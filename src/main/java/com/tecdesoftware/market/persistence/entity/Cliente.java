package com.tecdesoftware.market.persistence.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "clientes")

public class Cliente {

    @Id
    // porque el ID sera la CURP, será manual @GeneratedValue

    private Integer id;
    private  String nombre;
    private  String apellido;
    //Private Integer Celular:
    private  Long celular; //999,156,2372
    private  String Direccion;
    @Column(name = "correo_electonico")
    private  String correoElectronico;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Long getCelular() {
        return celular;
    }

    public void setCelular(Long celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
}
