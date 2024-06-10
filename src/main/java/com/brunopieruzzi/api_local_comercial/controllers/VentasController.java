package com.brunopieruzzi.api_local_comercial.controllers;

import com.brunopieruzzi.api_local_comercial.models.Ventas;
import com.brunopieruzzi.api_local_comercial.services.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class VentasController {

    @Autowired
    VentaService ventaServise;

    @GetMapping("/ventas")
    public List<Ventas> getAllVentas(){
        return ventaServise.getAllVentas();
    }
    @PostMapping("/venta")
    public ResponseEntity<String> createVentas (@RequestBody Ventas venta){
        try {
            ventaServise.createVenta(venta);
            return ResponseEntity.ok("venta creada con exito");
        }catch (IllegalArgumentException err){
            return ResponseEntity.badRequest().body(err.getMessage());
        }
    }
}
