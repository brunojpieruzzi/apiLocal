package com.brunopieruzzi.api_local_comercial.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "pago")
public class Pago {
    @Id
    private String id;
    private String idProveedor;
    private Double monto;
    private Date fecha;

    public Pago() {
    }

    public Pago(String idProveedor, Double monto, Date fecha) {
        this.idProveedor = idProveedor;
        this.monto = monto;
        this.fecha = fecha;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(String idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
