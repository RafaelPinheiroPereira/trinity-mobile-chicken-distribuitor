package com.br.tmchickendistributor.data.dao;

import com.br.tmchickendistributor.data.realm.ClienteVendedorIDORM;
import com.br.tmchickendistributor.data.realm.ClienteVendedorORM;

public class ClienteVendedorIDDAO extends  GenericsDAO<ClienteVendedorIDORM> {
    public ClienteVendedorIDDAO(Class<ClienteVendedorIDORM> entity) {
        super(entity);
    }
    public static ClienteVendedorIDDAO getInstace(final Class<ClienteVendedorIDORM> type) {
        return new ClienteVendedorIDDAO(type);
    }
}
