package com.br.tmchickendistributor.ui.mvp.visualizar;

import android.content.Context;
import android.os.Bundle;
import com.br.tmchickendistributor.data.model.Cliente;
import com.br.tmchickendistributor.data.model.Empresa;
import com.br.tmchickendistributor.data.model.Pedido;
import com.br.tmchickendistributor.util.DriveServiceHelper;

public interface IViewOrderMVP {

    interface IPresenter {

        void atualizarPedido(Pedido pedido);

        Pedido getParametrosDaVenda(final Bundle extras);

        Cliente pesquisarClientePorID(long codigoCliente);

        String getNomeDaFoto();

        void setNomeDaFoto(String nomeDaFoto);

        Cliente getCliente();

        void setCliente(Cliente cliente);

        Pedido getPedido();

        void setPedido(Pedido pedido);

        void setDataView();

        DriveServiceHelper getDriveServiceHelper();

        void setDriveServiceHelper(DriveServiceHelper driveServiceHelper);

        /** Metodos relacionados a impressao */
        void esperarPorConexao();

        void fecharConexaoAtiva();

        Context getContext();

        void imprimirComprovante();

        void exibirBotaoFotografar();

        void verificarCredenciaisGoogleDrive();
        Empresa pesquisarEmpresaRegistrada();
    }

    interface IModel {

        void atualizarPedido(Pedido pedido);

        Cliente pesquisarClientePorID(long codigoCliente);

        Pedido pesquisarVendaPorId(Long id);
        Empresa pesquisarEmpresaRegistrada();
    }

    interface IView {

        void exibirBotaoGerarRecibo();

        void setDataView();

        void exibirBotaoFotografar();

        void verificarCredenciaisGoogleDrive();
    }
}
