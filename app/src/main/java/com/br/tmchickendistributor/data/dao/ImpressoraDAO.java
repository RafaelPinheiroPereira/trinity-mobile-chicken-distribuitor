package com.br.tmchickendistributor.data.dao;

import com.br.tmchickendistributor.data.model.Impressora;
import com.br.tmchickendistributor.data.realm.ImpressoraORM;

public class ImpressoraDAO extends GenericsDAO<ImpressoraORM> {

  public ImpressoraDAO(final Class<ImpressoraORM> entity) {
    super(entity);
  }

  public static ImpressoraDAO getInstance(final Class<ImpressoraORM> type) {
    return new ImpressoraDAO(type);
  }

    public Impressora pesquisarImpressoraAtiva(){
    ImpressoraORM realmResults= where().equalTo("ativo",true).findFirst();
    if(realmResults!=null){
      return new Impressora(realmResults);
    }else{
      return new Impressora();
    }
  }

  public Impressora pesquisarImpressoraPorEndereco(final String endereco) {
    ImpressoraORM realmResults= where().equalTo("endereco",endereco).findFirst();
    if(realmResults!=null){
      return new Impressora(realmResults);
    }else{
      return new Impressora();
    }
  }
}
