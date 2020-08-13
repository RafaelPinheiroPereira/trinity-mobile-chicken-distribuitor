package com.br.tmchickendistributor.data.model;

import com.br.tmchickendistributor.data.realm.UnidadeProdutoIDORM;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UnidadeProdutoID {

    private long idProduto;

    private String idUnidade;

    public UnidadeProdutoID(UnidadeProdutoIDORM unidadeProdutoIDORM) {
        this.idProduto = unidadeProdutoIDORM.getIdProduto();
        this.idUnidade = unidadeProdutoIDORM.getIdUnidade();
    }
}
