package com.br.tmchickendistributor.ui.mvp.visualizar;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.br.tmchickendistributor.data.model.Cliente;
import com.br.tmchickendistributor.data.model.Empresa;
import com.br.tmchickendistributor.data.model.Funcionario;
import com.br.tmchickendistributor.data.model.Impressora;
import com.br.tmchickendistributor.data.model.Nucleo;
import com.br.tmchickendistributor.data.model.Pedido;
import com.br.tmchickendistributor.ui.mvp.visualizar.IViewOrderMVP.IView;
import com.br.tmchickendistributor.util.DriveServiceHelper;
import com.br.tmchickendistributor.util.ImpressoraUtil;

public class Presenter implements IViewOrderMVP.IPresenter {

    Cliente mCliente;

    IViewOrderMVP.IModel mModel;

    Pedido mPedido;

    DriveServiceHelper mDriveServiceHelper;

    private String nomeDaFoto;



    IViewOrderMVP.IView mView;

    ImpressoraUtil mImpressoraUtil;

    public Presenter(final IView view) {
        mView = view;
        mModel = new Model(this);
        mImpressoraUtil = new ImpressoraUtil((Activity) getContext());
    }

    @Override
    public void atualizarPedido(final Pedido pedido) {
        this.mModel.atualizarPedido(pedido);
    }

    @Override
    public Impressora getImpressora() {
        return this.mModel.pesquisarImpressoraAtiva();
    }

    @Override
    public Nucleo getNucleo() {
        return this.mModel.pesquisarNucleoAtivo();
    }

    @Override
    public Pedido getParametrosDaVenda(final Bundle extras) {
        long id = extras.getLong("keyPedido");

        return this.mModel.pesquisarVendaPorId(id);
    }

    @Override
    public Cliente pesquisarClientePorID(final long codigoCliente) {
        return this.mModel.pesquisarClientePorID(codigoCliente);
    }
    @Override
    public String getNomeDaFoto() {
        return nomeDaFoto;
    }
    @Override
    public void setNomeDaFoto(final String nomeDaFoto) {
        this.nomeDaFoto = nomeDaFoto;
    }


    @Override
    public Cliente getCliente() {
        return mCliente;
    }


    public void setCliente(final Cliente cliente) {
        mCliente = cliente;
    }

    @Override
    public Pedido getPedido() {
        return mPedido;
    }

    @Override
    public void setPedido(final Pedido pedido) {
        mPedido = pedido;
    }
    @Override
    public DriveServiceHelper getDriveServiceHelper() {
        return mDriveServiceHelper;
    }
    @Override
    public void setDriveServiceHelper(final DriveServiceHelper driveServiceHelper) {
        mDriveServiceHelper = driveServiceHelper;
    }

    /**
     * Metodos relacionados a impressao
     */
    @Override
    public void esperarPorConexao() {
        if (this.mImpressoraUtil.esperarPorConexao(this.getImpressora())) {
            this.mView.exibirBotaoGerarRecibo();
        }
    }



    @Override
    public void setDataView() {
        this.mView.setDataView();
    }



    @Override
    public void fecharConexaoAtiva() {
        this.mImpressoraUtil.fecharConexaoAtiva();
    }

    @Override
    public Context getContext() {
        return (Context) this.mView;
    }

    @Override
    public void imprimirComprovante() {
        this.mImpressoraUtil.imprimirComprovantePedido(getPedido(), getCliente(),this.getNucleo(),this.getFuncionario());
    }

    @Override
    public void exibirBotaoFotografar() {
        this.mView.exibirBotaoFotografar();
    }

    @Override
    public void verificarCredenciaisGoogleDrive() {
        this.mView.verificarCredenciaisGoogleDrive();
    }
    @Override
    public Empresa pesquisarEmpresaRegistrada() {
        return this.mModel.pesquisarEmpresaRegistrada();
    }

    @Override
    public Funcionario getFuncionario(){
        return this.mModel.pesquiarFuncionarioAtivo();
    }
}
