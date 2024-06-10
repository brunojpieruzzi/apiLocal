package com.brunopieruzzi.api_local_comercial.services;

import com.brunopieruzzi.api_local_comercial.models.Pago;
import com.brunopieruzzi.api_local_comercial.models.Proveedores;
import com.brunopieruzzi.api_local_comercial.repositories.PagoRepo;
import com.brunopieruzzi.api_local_comercial.repositories.ProveedoresRepo;
import com.brunopieruzzi.api_local_comercial.repositories.SearchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProveedoresService {

    @Autowired
    ProveedoresRepo proveedoresRepo;

    @Autowired
    SearchRepo searchRepo;
    @Autowired
    PagoRepo pagoRepo;

    public List<Proveedores> getAllProveedores() {
        return proveedoresRepo.findAll();
    }

    public List<Proveedores> searchProveedor(String text) {
        return searchRepo.searchProvByText(text);
    }

    public Proveedores findById(String id){
        return proveedoresRepo.findById(id)
                .orElseThrow(()->new RuntimeException("no se encontro el Proveedor"));
    }

    public Proveedores createProveedor (Proveedores proveedores){
        return proveedoresRepo.save(proveedores);
    }

//    public Proveedores pagoParcial(String id, Double monto){
//        Proveedores proveedore= findById(id);
//        Double nuevoSaldo=proveedore.getSaldo()-monto;
//        if (nuevoSaldo<0){
//            throw new IllegalArgumentException("El monto del pago excede el saldo del proveedor");
//        }
//        proveedore.setSaldo(nuevoSaldo);
//        proveedoresRepo.save(proveedore);
//
//        Pago pago=new Pago(id,monto,new Date());
//        pagoRepo.save(pago);
//        return proveedore;
//    }

    public Proveedores pagoParcial(String id, Double monto) {
        Proveedores proveedor = findById(id);

        if (monto <= 0) {
            throw new IllegalArgumentException("El monto del pago debe ser positivo");
        }

        Double nuevoSaldo = proveedor.getSaldo() - monto;
        if (nuevoSaldo < 0) {
            throw new IllegalArgumentException("El monto del pago excede el saldo del proveedor");
        }

        proveedor.setSaldo(nuevoSaldo);
        proveedoresRepo.save(proveedor);

        Pago pago = new Pago(id, monto, new Date());
        pagoRepo.save(pago);

        return proveedor;
    }

    public Proveedores pagoTotal (String id){
        Proveedores proveedor = findById(id);
        proveedor.setSaldo((double) 0);
        proveedoresRepo.save(proveedor);

        Pago pago= new Pago(id,proveedor.getSaldo(),new Date());
        pagoRepo.save(pago);

        return proveedor;
    }
    //TODO
//    public List<Pago> pagosProveedor (String id){
//
//    }

}
