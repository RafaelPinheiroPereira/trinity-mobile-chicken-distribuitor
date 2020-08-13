package com.br.tmchickendistributor.ui.mvp.impressora;

public class Model implements IImpressoraMVP.IModel {

    IImpressoraMVP.IPresenter mPresenter;

    public Model(final Presenter presenter) {

        this.mPresenter = presenter;
    }
}
