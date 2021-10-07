package com.br.tmchickendistributor.data.realm;

import com.br.tmchickendistributor.data.model.ClienteVendedor;
import com.br.tmchickendistributor.data.model.ClienteVendedorID;

import java.io.Serializable;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ClienteVendedorORM extends RealmObject implements Serializable {
    @PrimaryKey
    private String id;

    ClienteVendedorIDORM chavesClienteVendedorIDORM;
    private long cliprz;

    public ClienteVendedorORM(ClienteVendedor clienteVendedor) {
        this.id= clienteVendedor.getId();
        this.cliprz = clienteVendedor.getCliprz();
        this.chavesClienteVendedorIDORM = new ClienteVendedorIDORM(clienteVendedor.getChavesClienteVendedorID());


    }

}
