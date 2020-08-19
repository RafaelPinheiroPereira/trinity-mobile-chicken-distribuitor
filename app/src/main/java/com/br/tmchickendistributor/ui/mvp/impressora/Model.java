package com.br.tmchickendistributor.ui.mvp.impressora;

import com.br.tmchickendistributor.data.dao.ImpressoraDAO;
import com.br.tmchickendistributor.data.model.Impressora;
import com.br.tmchickendistributor.data.realm.ImpressoraORM;

public class Model implements IImpressoraMVP.IModel {

    IImpressoraMVP.IPresenter mPresenter;

    ImpressoraDAO impressoraDAO = ImpressoraDAO.getInstance(ImpressoraORM.class);

    public Model(final Presenter presenter) {

        this.mPresenter = presenter;
    }

    @Override
    public void atualizarImpressora(final Impressora impressora) {
        this.impressoraDAO.alterar(new ImpressoraORM(impressora));
    }

    @Override
    public void inserirImpresora(final Impressora impressora) {
        this.impressoraDAO.inserir(new ImpressoraORM(impressora));
    }

    @Override
    public boolean existeImpressoraAtiva() {
        return impressoraDAO.pesquisarImpressoraAtiva().isAtivo();
    }

    @Override
    public Impressora pequisarImpressoraAtiva() {
        return impressoraDAO.pesquisarImpressoraAtiva();
    }

    @Override
    public Impressora pesquisarImpressoraPorEndereco(final String endereco) {
        return  impressoraDAO.pesquisarImpressoraPorEndereco(endereco);
    }
}
