package com.br.tmchickendistributor.data.dao;

import com.br.tmchickendistributor.data.model.Funcionario;
import com.br.tmchickendistributor.data.model.Nucleo;
import com.br.tmchickendistributor.data.realm.FuncionarioORM;
import com.br.tmchickendistributor.data.realm.NucleoORM;
import io.realm.RealmResults;
import java.util.ArrayList;
import java.util.List;

public class NucleoDAO extends GenericsDAO<NucleoORM> {

    public static NucleoDAO getInstace(final Class<NucleoORM> type) {
        return new NucleoDAO(type);
    }

    public NucleoDAO(final Class<NucleoORM> entity) {
        super(entity);
    }

    public List<Nucleo> getAllNucleos() {
        RealmResults<NucleoORM > realmResults= where().findAll();
        if(realmResults!=null && realmResults.size()>0){
            List<Nucleo> nucleos =new ArrayList<>();
            nucleos.add(new Nucleo(0,"SELECIONE UM NÚCLEO"));
            for(NucleoORM nucleoORM:realmResults){
                nucleos.add(new Nucleo(nucleoORM));
            }
            return  nucleos;

        }else{return new ArrayList<>();}
    }

    public Nucleo pesquisarNucleoAtivo(){
        NucleoORM realmResults= where().equalTo("ativo",true).findFirst();
        if(realmResults!=null){
            return new Nucleo(realmResults);
        }else{
            return new Nucleo();
        }
    }
}
