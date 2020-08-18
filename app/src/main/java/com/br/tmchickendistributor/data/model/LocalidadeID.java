package com.br.tmchickendistributor.data.model;

import com.br.tmchickendistributor.data.realm.LocalidadeIDORM;
import com.br.tmchickendistributor.data.realm.LocalidadeORM;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class LocalidadeID implements Serializable {

    String id;
    long idEmpresa;
    long idLocalidade;


    public LocalidadeID(LocalidadeIDORM localidadeIDORM) {

        this.id=localidadeIDORM.getId();
        this.idEmpresa=localidadeIDORM.getIdEmpresa();
        this.idLocalidade=localidadeIDORM.getIdLocalidade();

    }
}
