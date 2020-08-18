package com.br.tmchickendistributor.data.dao;

import com.br.tmchickendistributor.data.model.Funcionario;
import com.br.tmchickendistributor.data.realm.FuncionarioORM;

public class FuncionarioDAO extends GenericsDAO<FuncionarioORM> {
    public static FuncionarioDAO getInstace(final Class<FuncionarioORM> type) {
        return new FuncionarioDAO(type);
    }
    public FuncionarioDAO(final Class<FuncionarioORM> entity) {
        super(entity);
    }

    public Funcionario pesquisarPorId(long id){
        FuncionarioORM realmResults= where().equalTo("id",id).findAll().first();
        if(realmResults!=null){
            return new Funcionario(realmResults);
        }else{
            return new Funcionario();
        }
    }
    public Funcionario pesquisarFuncionarioAtivo(){
        FuncionarioORM realmResults= where().equalTo("ativo",true).findFirst();
        if(realmResults!=null){
            return new Funcionario(realmResults);
        }else{
            return new Funcionario();
        }
    }
}
