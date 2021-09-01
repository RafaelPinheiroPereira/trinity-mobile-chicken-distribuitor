package com.br.tmchickendistributor.data.model;

import com.br.tmchickendistributor.data.realm.RotaORM;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Rota  implements Serializable {
    private long id;
    private double idEmpresa;
    private String descricao;

    public Rota(RotaORM rotaORM) {
        this.id=rotaORM.getId();
        this.descricao=rotaORM.getDescricao();
        this.idEmpresa=rotaORM.getIdEmpresa();
    }

    @Override
    public String toString() {
        return this.getDescricao();
    }
}
