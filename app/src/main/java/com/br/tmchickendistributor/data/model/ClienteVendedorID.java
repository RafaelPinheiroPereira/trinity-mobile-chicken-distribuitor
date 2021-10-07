package com.br.tmchickendistributor.data.model;

import com.br.tmchickendistributor.data.realm.ClienteVendedorIDORM;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ClienteVendedorID  implements Serializable {

    private long idEmpresa;

    private long idCliente;

    private long idFuncionario;

    private long idTipoRecebimento;

    public ClienteVendedorID(ClienteVendedorIDORM clienteVendedorIDORM){
        this.idCliente=clienteVendedorIDORM.getIdCliente();
        this.idFuncionario=clienteVendedorIDORM.getIdFuncionario();
    }
}
