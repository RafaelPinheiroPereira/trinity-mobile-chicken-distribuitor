package com.br.tmchickendistributor.data.realm;

import com.br.tmchickendistributor.data.model.Rota;

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
public class RotaORM  extends RealmObject implements Serializable {


    @PrimaryKey
    private long id;
    private double idEmpresa;
    private String descricao;

    public RotaORM(Rota rota) {
        this.id=rota.getId();
        this.descricao=rota.getDescricao();
        this.idEmpresa=rota.getIdEmpresa();
    }


}
