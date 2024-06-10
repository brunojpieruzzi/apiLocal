package com.brunopieruzzi.api_local_comercial.controllers;

import com.brunopieruzzi.api_local_comercial.models.Proveedores;
import com.brunopieruzzi.api_local_comercial.services.ProveedoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProveedorController {
    @Autowired
    ProveedoresService proveedoresService;

    @GetMapping("/getprov")
    public List<Proveedores> getAllProveedores(){
        return  proveedoresService.getAllProveedores();
    }

    @GetMapping("/prov/{text}")
    public List<Proveedores> searchProveedores(@PathVariable String text){
        return proveedoresService.searchProveedor(text);
    }

    @PostMapping("/prov")
    public Proveedores createProveedor(@RequestBody Proveedores prov){
        return proveedoresService.createProveedor(prov);
    }
    @PostMapping("/prov/{id}/pago")
    public Proveedores pagoParcial(@PathVariable String id,@RequestParam Double monto){
        return proveedoresService.pagoParcial(id,monto);
    }
    @PostMapping("/prov/{Id}/pago-total")
    public Proveedores pagoTotal (@PathVariable String id){
        return proveedoresService.pagoTotal(id);
    }
}
