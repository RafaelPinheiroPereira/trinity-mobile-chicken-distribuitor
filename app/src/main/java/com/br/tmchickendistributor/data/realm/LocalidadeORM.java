package com.br.tmchickendistributor.data.realm;

import com.br.tmchickendistributor.data.model.Localidade;
import com.br.tmchickendistributor.data.model.LocalidadeID;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class LocalidadeORM extends RealmObject implements Serializable {

    @PrimaryKey
    private long id;
    private String nome;
    private double idEmpresa;
    private long idRota;





    public LocalidadeORM(Localidade localidade) {
        this.id=localidade.getId();
        this.nome = localidade.getNome();
        this.idEmpresa=localidade.getIdEmpresa();
        this.idRota= localidade.getIdRota();


    }
}
