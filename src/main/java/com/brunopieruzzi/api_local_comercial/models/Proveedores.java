package com.brunopieruzzi.api_local_comercial.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document(collection = "proveedores")
public class Proveedores {
    @Id
    private String id;
    private String nombre;
    private Integer numeroDeFactura;
    private Double totalDeFactura;
    private Double saldo;

    public Proveedores() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNumeroDeFactura() {
        return numeroDeFactura;
    }

    public void setNumeroDeFactura(Integer numeroDeFactura) {
        this.numeroDeFactura = numeroDeFactura;
    }

    public Double getTotalDeFactura() {
        return totalDeFactura;
    }

    public void setTotalDeFactura(Double totalDeFactura) {
        this.totalDeFactura = totalDeFactura;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
}
