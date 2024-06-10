package com.brunopieruzzi.api_local_comercial.controllers;

import com.brunopieruzzi.api_local_comercial.models.Pago;
import com.brunopieruzzi.api_local_comercial.repositories.PagoRepo;
import com.brunopieruzzi.api_local_comercial.services.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PagoController {

    @Autowired
    PagoService pagoService;

    @GetMapping("/pagos/{idProv}")
    public List<Pago> getPagosByProveedor(@PathVariable String idProv){
        return pagoService.getPagosByProveedor(idProv);
    }
}
