package com.br.tmchickendistributor.data.model;

import com.br.tmchickendistributor.data.realm.UnidadeProdutoIDORM;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class UnidadeProdutoID  implements Serializable {


    private String id;
    private long idProduto;
    private String idUnidade;

    public UnidadeProdutoID(UnidadeProdutoIDORM unidadeProdutoIDORM) {
        this.idProduto = unidadeProdutoIDORM.getIdProduto();
        this.idUnidade = unidadeProdutoIDORM.getIdUnidade();
        this.id=unidadeProdutoIDORM.getIdUnidade()+"-"+unidadeProdutoIDORM.getIdProduto();
    }
}
