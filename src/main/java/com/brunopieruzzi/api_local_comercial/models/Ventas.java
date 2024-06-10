package com.brunopieruzzi.api_local_comercial.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.List;


@Document(collection = "ventas")
public class Ventas {
    @Id
    private String id;
    private Double precioTotal;
    private List<ItemVenta> itemVenta;

    public Ventas() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public List<ItemVenta> getItemVenta() {
        return itemVenta;
    }

    public void setItemVenta(List<ItemVenta> itemVenta) {
        this.itemVenta = itemVenta;
    }

}
