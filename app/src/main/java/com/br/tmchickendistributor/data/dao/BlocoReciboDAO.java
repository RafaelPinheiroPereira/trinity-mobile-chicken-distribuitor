package com.br.tmchickendistributor.data.dao;

import android.os.Build.VERSION;
import android.os.Build.VERSION_CODES;
import com.br.tmchickendistributor.data.model.BlocoRecibo;
import com.br.tmchickendistributor.data.realm.BlocoReciboORM;
import io.realm.RealmResults;
import java.util.ArrayList;
import java.util.List;

public class BlocoReciboDAO extends GenericsDAO<BlocoReciboORM> {



    public static BlocoReciboDAO getInstace(final Class<BlocoReciboORM> type) {
        return new BlocoReciboDAO(type);
    }


    public BlocoReciboDAO(final Class<BlocoReciboORM> entity) {
        super(entity);
    }

    public BlocoRecibo consultarBlocoReciboPorNome(final String name) {

        return new BlocoRecibo( where().equalTo("nomeFoto",name).findFirst());
    }

    public void deletarRecibos() {
    }

    public List<BlocoRecibo> getRecibosNaoMigrados() {
        List<BlocoRecibo> recibos = new ArrayList<>();
        RealmResults<BlocoReciboORM> results =
                where().equalTo("fotoMigrada", false).findAll();
        if (results.size() > 0 && results != null) {
            if (VERSION.SDK_INT >= VERSION_CODES.N) {
                results.forEach(blocoReciboORM->recibos.add(new BlocoRecibo(blocoReciboORM)));
            } else {
                for (BlocoReciboORM blocoReciboORM : results) {
                    recibos.add(new BlocoRecibo(blocoReciboORM));
                }
            }
        }

        return recibos;

    }

    public List<BlocoRecibo> pesquisarBlocos() {

        List<BlocoRecibo> recibos = new ArrayList<>();
        RealmResults<BlocoReciboORM> results =
                where().findAll();
        if (results.size() > 0 && results != null) {
            if (VERSION.SDK_INT >= VERSION_CODES.N) {
                results.forEach(blocoReciboORM->recibos.add(new BlocoRecibo(blocoReciboORM)));
            } else {
                for (BlocoReciboORM blocoReciboORM : results) {
                    recibos.add(new BlocoRecibo(blocoReciboORM));
                }
            }
        }

        return recibos;
    }
}
