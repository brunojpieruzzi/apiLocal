package com.brunopieruzzi.api_local_comercial.services;

import com.brunopieruzzi.api_local_comercial.models.Pago;
import com.brunopieruzzi.api_local_comercial.repositories.PagoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PagoService {
    @Autowired
    PagoRepo pagoRepo;

    public List<Pago> getPagosByProveedor(String idProv) {
        List<Pago> pagos = pagoRepo.findAll();
        return pagos.stream()
                .filter(pago -> pago.getIdProveedor().equals(idProv))
                .collect(Collectors.toList());
    }

}
