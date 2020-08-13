package com.br.tmchickendistributor.ui.mvp.pedido;

import android.app.AlertDialog;
import android.content.Context;
import com.br.tmchickendistributor.data.model.Cliente;
import com.br.tmchickendistributor.data.model.Pedido;
import com.br.tmchickendistributor.data.realm.ClientePedido;
import java.util.List;

public interface IPedidoMVP {

    interface IPresenter {

        void cancelarPedido(String motivoCancelamento);

        void dismiss();

        List<ClientePedido> obterTodosClientePedido();

        Context getContext();

        AlertDialog getDialog();

        void setDialog(AlertDialog alertDialog);

        Pedido getPedido();

        void setPedido(Pedido pedidoSelecionado);

        String getNomeDaFoto();

        void setNomeDaFoto(String nomeDaFoto);

        void onNavigateToEditSalesOrderActivity(Pedido pedido);

        void onNavigateToViewSalesOrderActivity(Pedido pedido);

        void onShowBottoSheetDialog();

        void onShowDialogDeleteOrderSalle(Pedido pedido);
    }

    interface IView {

        void dismiss();

        void onShowBototoSheetDialog();

        void showDialogCanceling(Pedido pedido);
    }

    interface IModel {

        void cancelarPedido(String motivoCancelamento);

        List<Cliente> pesquisarClientePorPedido(List<Pedido> pedido);

        List<Pedido> todosPedidos();

        List<ClientePedido> getAllClientePedidos();
    }
}
