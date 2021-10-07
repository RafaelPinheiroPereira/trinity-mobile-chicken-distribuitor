package com.br.tmchickendistributor.data.dao;

import android.os.Build;

import com.br.tmchickendistributor.data.model.Cliente;
import com.br.tmchickendistributor.data.model.ClienteVendedor;
import com.br.tmchickendistributor.data.model.ItemPedido;
import com.br.tmchickendistributor.data.realm.ClienteVendedorORM;
import com.br.tmchickendistributor.data.realm.ItemPedidoORM;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmResults;

public class ClienteVendedorDAO extends GenericsDAO<ClienteVendedorORM> {
    public ClienteVendedorDAO(Class<ClienteVendedorORM> entity) {
        super(entity);
    }

    public static ClienteVendedorDAO getInstace(final Class<ClienteVendedorORM> type) {
        return new ClienteVendedorDAO(type);
    }

    public ClienteVendedor pesquisarFuncionarioPorCliente(Cliente cliente) {
        ClienteVendedorORM clienteVendedorORM =
                where().equalTo("chavesClienteVendedorIDORM.idCliente", cliente.getId())
                        .findFirst();

        if (clienteVendedorORM != null) {
            return new ClienteVendedor(clienteVendedorORM);
        }
        return null;
    }
}
