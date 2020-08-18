package com.br.tmchickendistributor.ui.mvp.login;

import com.br.tmchickendistributor.data.dao.EmpresaDAO;
import com.br.tmchickendistributor.data.dao.FuncionarioDAO;
import com.br.tmchickendistributor.data.dao.NucleoDAO;
import com.br.tmchickendistributor.data.model.Empresa;
import com.br.tmchickendistributor.data.model.Funcionario;
import com.br.tmchickendistributor.data.model.Nucleo;
import com.br.tmchickendistributor.data.realm.EmpresaORM;
import com.br.tmchickendistributor.data.realm.FuncionarioORM;
import com.br.tmchickendistributor.data.realm.NucleoORM;
import com.br.tmchickendistributor.ui.mvp.login.ILoginMVP.IModel;
import io.realm.Realm;
import java.util.List;

public class Model implements IModel {
    private Presenter mPresenter;

    private NucleoDAO mNucleoDAO = NucleoDAO.getInstace(NucleoORM.class);
    private EmpresaDAO mEmpresaDAO= EmpresaDAO.getInstace(EmpresaORM.class);


    public Model(final Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void atualizarNucleo(final Nucleo nucleo) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(new NucleoORM(nucleo));
        realm.commitTransaction();

    }

    @Override
    public Empresa pesquisarEmpresaRegistrada() {
        return mEmpresaDAO.pesquisarEmpresaRegistradaNoDispositivo();
    }

    @Override
    public List<Nucleo> pesquisarTodosNucleos() {
        return mNucleoDAO.getAllNucleos();
    }

    @Override
    public void salvarFuncionario(final Funcionario funcionario) {
        FuncionarioORM funcionarioORM= new FuncionarioORM(funcionario);
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(funcionarioORM);
        realm.commitTransaction();

    }
}
