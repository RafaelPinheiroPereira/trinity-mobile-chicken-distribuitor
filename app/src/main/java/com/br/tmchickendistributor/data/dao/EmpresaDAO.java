package com.br.tmchickendistributor.data.dao;

import com.br.tmchickendistributor.data.model.Empresa;
import com.br.tmchickendistributor.data.realm.EmpresaORM;
import io.realm.RealmResults;

public class EmpresaDAO extends GenericsDAO<EmpresaORM> {

    public static EmpresaDAO getInstace(final Class<EmpresaORM> type) {
        return new EmpresaDAO(type);
    }

    public EmpresaDAO(final Class<EmpresaORM> entity) {
        super(entity);
    }

    public Empresa pesquisarEmpresaRegistradaNoDispositivo() {

        RealmResults<EmpresaORM> realmResults = where().findAll();
        if(realmResults!=null && realmResults.size()>0){
            return  new Empresa(realmResults.first());
        }else{
            return  null;
        }
    }
}
