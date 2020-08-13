package com.br.tmchickendistributor.ui.mvp.configuracao;

import android.app.Activity;
import android.content.Context;
import com.br.tmchickendistributor.data.model.Configuracao;
import com.br.tmchickendistributor.network.tarefa.ConfiguracaoTask;
import com.br.tmchickendistributor.ui.mvp.configuracao.IConfiguracaoMVP.IModel;
import com.br.tmchickendistributor.ui.mvp.configuracao.IConfiguracaoMVP.IPresenter;
import com.br.tmchickendistributor.ui.mvp.configuracao.IConfiguracaoMVP.IView;
import com.br.tmchickendistributor.util.ArquivoUtils;
import com.br.tmchickendistributor.util.ControleSessao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Presenter implements IPresenter {

    IView mView;
    IModel mIModel;

    String mac;
    String cnpj;
    ControleSessao mControleSessao;


    private ArquivoUtils mArquivoUtils ;



    private ConfiguracaoTask mConfiguracaoTask;

    public Presenter(final IView view) {
        mView = view;
        mIModel = new Model(this);
    }

    @Override
    public void criarPastasDasImagens() {
        this.mArquivoUtils=new ArquivoUtils();
        this.mArquivoUtils.criarPastas((Activity) this.getContext());
    }

    @Override
    public Context getContext() {
        return (Context) this.mView;
    }

   
    @Override
    public String statusSistema() {
        return this.mIModel.statusSistema();
    }

    @Override
    public void realizarConfiguracao() {
        mConfiguracaoTask = new ConfiguracaoTask(this);
        mConfiguracaoTask.execute();
    }

    @Override
    public void salvarConfiguracoes(final Configuracao configuracao) {
        this.mIModel.salvarConfiguracao(configuracao);
    }

    @Override
    public String getMac() {
        return mac;
    }

    @Override
    public String getCnpj() {
        return cnpj;
    }

    @Override
    public void setMac(final String mac) {
        this.mac = mac;
    }

    @Override
    public void setCnpj(final String cnpj) {
        this.cnpj = cnpj;
    }
    @Override
    public ArquivoUtils getArquivoUtils() {
        return mArquivoUtils;
    }
    @Override
    public void setArquivoUtils(final ArquivoUtils arquivoUtils) {
        mArquivoUtils = arquivoUtils;
    }

    @Override
    public boolean verificarLogin() {
        this.mControleSessao = new ControleSessao(getContext());
        this.setControleSessao(this.mControleSessao);
        return mControleSessao.checkLogin();
    }

    @Override
    public ControleSessao getControleSessao() {
        return mControleSessao;
    }
    @Override
    public void setControleSessao(final ControleSessao mControleSessao) {
        this.mControleSessao = mControleSessao;
    }
}
