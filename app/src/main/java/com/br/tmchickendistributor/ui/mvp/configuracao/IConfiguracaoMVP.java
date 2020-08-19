package com.br.tmchickendistributor.ui.mvp.configuracao;

import android.content.Context;
import com.br.tmchickendistributor.data.model.Configuracao;
import com.br.tmchickendistributor.util.ArquivoUtils;

public interface IConfiguracaoMVP {

    interface IPresenter {

        void criarPastasDasImagens();

        Context getContext();


        String statusSistema();

        void realizarConfiguracao();

        void salvarConfiguracoes(final Configuracao configuracao);

        String getMac();

        String getCnpj();

        void setMac(String mac);

        void setCnpj(String cnpj);

        ArquivoUtils getArquivoUtils();

        void setArquivoUtils(ArquivoUtils arquivoUtils);

        boolean estaLogado();




    }

    interface IModel {

        boolean estaAtivo();

        String statusSistema();

        void salvarConfiguracao(final Configuracao configuracao);
    }

    interface IView {

        boolean estaVazioOCNPJ();
    }
}
