package com.br.tmchickendistributor.data.realm;

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
public class ClienteVendedorIDORM extends RealmObject implements Serializable {

    @PrimaryKey
    private String id;
    private long idEmpresa;
    private long idCliente;
    private long idFuncionario;
    private long idTipoRecebimento;

    public  ClienteVendedorIDORM (ClienteVendedorID clienteVendedorID){
        this.id= clienteVendedorID.getIdCliente() +"-"+ clienteVendedorID.getIdFuncionario();
        this.idCliente=clienteVendedorID.getIdCliente();
        this.idFuncionario=clienteVendedorID.getIdFuncionario();

    }
}
