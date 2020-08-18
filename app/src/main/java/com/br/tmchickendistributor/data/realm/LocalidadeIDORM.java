package com.br.tmchickendistributor.data.realm;

import com.br.tmchickendistributor.data.model.LocalidadeID;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class LocalidadeIDORM extends RealmObject implements Serializable {
    @PrimaryKey
    String id;
    long idEmpresa;
    long idLocalidade;

    public LocalidadeIDORM(LocalidadeID localidadeID) {

        this.id=  localidadeID.getIdEmpresa() + "-" + localidadeID.getIdLocalidade();
        this.idEmpresa=localidadeID.getIdEmpresa();
        this.idLocalidade=localidadeID.getIdLocalidade();

    }
}
