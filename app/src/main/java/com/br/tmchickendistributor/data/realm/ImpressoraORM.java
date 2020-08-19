package com.br.tmchickendistributor.data.realm;

import com.br.tmchickendistributor.data.model.Impressora;
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
public class ImpressoraORM extends RealmObject implements Serializable {


    private String nome;
    private  boolean ativo=false;

    @PrimaryKey
    private String endereco;

    public ImpressoraORM(Impressora impressora) {

        this.nome=impressora.getNome();
        this.ativo=impressora.isAtivo();
        this.endereco=impressora.getEndereco();
    }
}
