package com.br.tmchickendistributor.data.model;

import com.br.tmchickendistributor.data.realm.ImpressoraORM;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Impressora implements Serializable {

  private String endereco;
  private String nome;

  private boolean ativo = false;

  public Impressora(ImpressoraORM impressoraORM) {

    this.nome = impressoraORM.getNome();
    this.ativo = impressoraORM.isAtivo();
    this.endereco = impressoraORM.getEndereco();
  }
}
