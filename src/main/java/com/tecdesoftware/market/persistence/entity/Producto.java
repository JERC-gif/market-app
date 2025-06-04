package com.tecdesoftware.market.persistence.entity;

import jakarta.persistence.*;

import javax.naming.Name;

@Entity
@Table (name = "Producto")
public class Producto {

    @Id //Es la llave primaria
    //Autogenera ids autoincrementables
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_prodcuto")
    private  int idProducto;

    private String nombre;

    @Column (name = "id_categoria")
    private int idCategoria;

    @Column (name = "codigo_barras")
    private String CodigoBarras;

    @Column (name = "precio_venta")
    private  Double PrecioVenta;

    @Column (name = "cantidad_stock")
    private Integer cantidadStock;

    private Boolean estado;

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCodigoBarras() {
        return CodigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        CodigoBarras = codigoBarras;
    }

    public Double getPrecioVenta() {
        return PrecioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        PrecioVenta = precioVenta;
    }

    public Integer getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(Integer cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

}
