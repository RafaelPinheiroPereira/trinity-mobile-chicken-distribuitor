package com.br.tmchickendistributor.ui.mvp.impressora;

import android.content.Context;
import com.br.tmchickendistributor.data.model.Impressora;

public class Presenter implements IImpressoraMVP.IPresenter {

    private IImpressoraMVP.IModel model;

    private IImpressoraMVP.IView view;



    public Presenter(final IImpressoraMVP.IView view) {
        this.view = view;
        this.model = new Model(this);
    }

    @Override
    public void atualizarImpressora(final Impressora impressora) {
        this.model.atualizarImpressora(impressora);
    }

    @Override
    public boolean existeImpressoraAtiva() {
        return this.model.existeImpressoraAtiva();
    }

    @Override
    public Context getContext() {
        return (Context) this.view;
    }

    @Override
    public void inserirImpresora(final Impressora impressora) {
          this.model.inserirImpresora(impressora);
    }

    @Override
    public Impressora pequisarImpressoraAtiva() {
        return this.model.pequisarImpressoraAtiva();
    }

    @Override
    public Impressora pesquisarImpressora(final String address) {
        return this.model.pesquisarImpressoraPorEndereco(address);
    }
}
