package com.br.tmchickendistributor.data.realm;

import com.br.tmchickendistributor.data.model.Nucleo;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class NucleoORM  extends RealmObject implements Serializable {

    @PrimaryKey
    private long id;

    private String nome;

    private String cnpj;

    private Date dataInicio;

    private Date dataFim;
    private String nomeEmpresa;
    private String telefone;
    private String endereco;

    public NucleoORM(Nucleo nucleo){
        this.id=nucleo.getId();
        this.nome=nucleo.getNome();
        this.cnpj=nucleo.getCnpj();
        this.dataInicio=nucleo.getDataInicio();
        this.dataInicio=nucleo.getDataFim();
        this.nomeEmpresa=nucleo.getNomeEmpresa();
        this.telefone=nucleo.getTelefone();
        this.endereco=nucleo.getEndereco();
    }
}
