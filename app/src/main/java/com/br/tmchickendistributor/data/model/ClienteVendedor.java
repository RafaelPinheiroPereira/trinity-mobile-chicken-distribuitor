package com.br.tmchickendistributor.data.model;


import com.br.tmchickendistributor.data.realm.ClienteVendedorIDORM;
import com.br.tmchickendistributor.data.realm.ClienteVendedorORM;

import java.io.Serializable;

import io.realm.annotations.PrimaryKey;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ClienteVendedor implements Serializable {
    ClienteVendedorID chavesClienteVendedorID;
    private long cliprz;
    String id;

    public  ClienteVendedor (ClienteVendedorORM clienteVendedorORM){
        this.id=clienteVendedorORM.getId();
        this.chavesClienteVendedorID=new ClienteVendedorID(clienteVendedorORM.getChavesClienteVendedorIDORM());
    }

}
