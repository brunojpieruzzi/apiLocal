package com.brunopieruzzi.api_local_comercial.services;

import com.brunopieruzzi.api_local_comercial.models.ItemVenta;
import com.brunopieruzzi.api_local_comercial.models.Products;
import com.brunopieruzzi.api_local_comercial.models.Ventas;
import com.brunopieruzzi.api_local_comercial.repositories.VentasRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VentaService {

    @Autowired
    private VentasRepo ventasRepo;

    @Autowired
    private ProductsService productsService;

    public List<Ventas> getAllVentas (){
        return ventasRepo.findAll();
    }

    @Transactional
    public void createVenta(Ventas ventas) {
        if (ventas == null||ventas.getItemVenta()==null||ventas.getItemVenta().isEmpty()) {
            throw new IllegalArgumentException("ventas");
        }

        for (ItemVenta itemVenta : ventas.getItemVenta()) {
            String idProduct = itemVenta.getProducts().getId();
            Products products = productsService.getProductById(idProduct);
            if (products == null) {
                throw new IllegalArgumentException("No se encontró el producto con el Id: " + idProduct);
            }
            Integer cantidadVendida = itemVenta.getCantidad();
            if (products.getCantidad() < cantidadVendida) {
                throw new IllegalArgumentException("No hay suficiente stock para el producto con el Id: " + idProduct);
            }
            products.setCantidad(products.getCantidad() - cantidadVendida);
            productsService.upDateProduct(idProduct, products);
            itemVenta.setProducts(products);
        }

        Double precioTotal = calcularPrecioTotalVenta(ventas.getItemVenta());
        ventas.setPrecioTotal(precioTotal);
        ventasRepo.save(ventas);
    }

    private Double calcularPrecioTotalVenta(List<ItemVenta> itemVentas) {
        return itemVentas.stream()
                .mapToDouble(item -> item.getCantidad() * item.getProducts().getPrecio())
                .sum();
    }
}





