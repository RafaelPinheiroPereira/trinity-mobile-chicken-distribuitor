package com.br.tmchickendistributor.data.dao;

import android.os.Build;

import com.br.tmchickendistributor.data.model.ClienteGrupo;
import com.br.tmchickendistributor.data.model.Rota;
import com.br.tmchickendistributor.data.realm.ClienteGrupoORM;
import com.br.tmchickendistributor.data.realm.ProdutoORM;
import com.br.tmchickendistributor.data.realm.RotaORM;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmResults;
import io.realm.Sort;

public class RotaDAO  extends GenericsDAO<RotaORM>{

    public static RotaDAO getInstace(final Class<RotaORM> type) {
        return new RotaDAO(type);
    }

    public RotaDAO(final Class<RotaORM> type) {
        super(type);
    }


    public List<Rota> pesquisarTodasAsRotas() {
        List<Rota> rotas = new ArrayList<>();
        rotas.add(new Rota(new RotaORM(0,0.0,"Selecione uma Rota")));
        RealmResults<RotaORM> results = where().findAll().sort("descricao", Sort.ASCENDING);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {

            results.forEach(item->rotas.add(new Rota(item)));
        } else {
            for (RotaORM item : results) {
                rotas.add(new Rota(item));

            }
        }
        return rotas;
    }

}
