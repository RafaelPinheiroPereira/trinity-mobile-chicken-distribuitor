package com.br.tmchickendistributor.ui.mvp.impressora;

import android.content.Context;
import com.br.tmchickendistributor.data.model.Impressora;

public interface IImpressoraMVP {

    interface IPresenter {

        void atualizarImpressora(Impressora impressoraAtiva);

        boolean existeImpressoraAtiva();

        Context getContext();

        void inserirImpresora(Impressora impressora);

        Impressora pequisarImpressoraAtiva();

        Impressora pesquisarImpressora(String address);
    }

    interface IModel {

        void atualizarImpressora(Impressora impressora);

        void inserirImpresora(final Impressora impressora);

        boolean existeImpressoraAtiva();

        Impressora pequisarImpressoraAtiva();

        Impressora pesquisarImpressoraPorEndereco(String address);
    }

    interface IView {

    }
}
