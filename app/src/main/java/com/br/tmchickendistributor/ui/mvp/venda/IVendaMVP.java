package com.br.tmchickendistributor.ui.mvp.venda;

import android.content.Context;

import androidx.appcompat.app.AlertDialog;

import com.br.tmchickendistributor.data.model.Cliente;
import com.br.tmchickendistributor.data.model.Empresa;
import com.br.tmchickendistributor.data.model.Funcionario;
import com.br.tmchickendistributor.data.model.Impressora;
import com.br.tmchickendistributor.data.model.ItemPedido;
import com.br.tmchickendistributor.data.model.ItemPedidoID;
import com.br.tmchickendistributor.data.model.Nucleo;
import com.br.tmchickendistributor.data.model.Pedido;
import com.br.tmchickendistributor.data.model.Preco;
import com.br.tmchickendistributor.data.model.Produto;
import com.br.tmchickendistributor.data.model.Unidade;
import com.br.tmchickendistributor.data.realm.PedidoORM;
import com.br.tmchickendistributor.util.DriveServiceHelper;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public interface IVendaMVP {

    interface IPresenter {

        Impressora getImpressora();

        Nucleo getNucleo();

        void salvarNomeFoto(final Pedido pedido);

        Funcionario getFuncionario();

        void atualizarActCodigoProduto();

        void atualizarProdutoSelecionadoView();

        void atualizarRecyclerItens();

        void atualizarSpinnerLotes();

        long configurarSequenceDoPedido();

        DriveServiceHelper getDriveServiceHelper();

        void setDriveServiceHelper(DriveServiceHelper driveServiceHelper);

        void error(String msg);

        void esperarPorConexao();

        Double calcularTotalDaVenda();

        void exibirBotaoFotografar();

        void dissmis();

        void atualizarPedido(Pedido orderSale);

        AlertDialog getAlertDialog();

        ArrayList<String> carregarIdProdutos(List<Produto> produtos);

        void fecharConexaoAtiva();

        int getBicos();

        Empresa pesquisarEmpresaRegistrada();

        void setAlertDialog(AlertDialog alertDialog);

        List<Produto> carregarProdutos();

        ArrayList<String> carregarProdutosPorNome(List<Produto> produtos);

        Context getContext();

        void setBicos(int bicos);

        ItemPedido getItemPedido();

        void setItemPedido(ItemPedido itemPedido);

        List<ItemPedido> getItens();

        void setItens(List<ItemPedido> itens);

        void carregarVenda() throws Throwable;

        Preco getPreco();

        void setPreco(final Preco preco);

        Produto getProdutoSelecionado();

        void setProdutoSelecionado(final Produto produtoSelecionado);

        List<Unidade> carregarUnidades();

        ArrayList<String> carregarUnidadesEmString(List<Unidade> unidades);

        Unidade carregarUnidadePadraoDoProduto();

        void desabilitarBotaoSalvarPedido();

        void exibirDialogAlterarItemPedido(int position);

        Cliente getCliente();

        void setCliente(final Cliente cliente);

        void getParametros();

        Pedido getPedido();

        Unidade getUnidadeSelecionada();

        void setPedido(Pedido Pedido);

        BigDecimal getQuantidadeProdutos();

        void setUnidadeSelecionada(Unidade unidadeSelecionada);

        void setQuantidadeProdutos(BigDecimal quantidadeProdutos);

        Preco pesquisarPrecoDaUnidadePorProduto(String unityID);

        Produto pesquisarProdutoPorId(long parseLong);

        Produto pesquisarProdutoPorNome(String productName);

        BigDecimal getTotalDaVenda();

        void setTotalDaVenda(BigDecimal totalDaVenda);

        BigDecimal getValorTotalProduto();

        Cliente pesquisarClientePorId(long codigoCliente);

        Preco pesquisarPrecoPorProduto();

        Pedido pesquisarVendaPorId(long keyPedido);

        void setSpinnerProdutoSelecionado();

        void setTotalProductValue(BigDecimal totalProductValue);

        Pedido salvarVenda(final long sequencePedido) throws ParseException;

        void updateTxtAmountOrderSale();

        void updateTxtAmountProducts();

        void imprimirComprovante();

        boolean validarCamposAntesDeAdicionarItem();

        void setLoteSelecionado(String loteSelecionado);

        String getLoteSelecionado();
    }

    interface IView {

        void atualizarSpinnerLotes();

        void atualizarViewsDoProdutoSelecionado();

        void atualizarTextViewTotalVenda();

        void dissmiss();

        void error(String msg);

        void carregarVenda() throws Throwable;

        void exibirBotaoImprimir();

        void atualizarTextViewValorTotalProduto();

        void desabilitarCliqueBotaoSalvarVenda();

        void exibirBotaoFotografar();

        void setSpinnerProductSelected();


        void exibirDialogAlterarItemPedido(int position);

        void updateActCodigoProduto();

        void updateRecyclerItens();

        void getParametros();

        boolean validarCamposAntesDeAdicionarItem();
    }

    interface IModel {

        long addItemPedido(ItemPedido item);

        void atualizarChaveItemPedido(ItemPedidoID chavesItemPedido);

        void atualizarItemPedido(ItemPedido item);

        Preco carregarPrecoPorProduto();

        Preco carregarPrecoUnidadePorProduto(String item);

        ArrayList<String> carregarProdutoPorId(List<Produto> products);

        long configurarSequenceDoPedido();

        void copyOrUpdateSaleOrder(Pedido pedido);

        ArrayList<String> carregarProdutoPorNome(List<Produto> produto);

        ArrayList<String> converterUnidadeParaString(List<Unidade> unidades);

        void criarChaveItemPedido(ItemPedidoID chavesItemPedido);

        Cliente pesquisarClientePorId(Long id);

        long pesquisarCodigoMaximoDeVendaDoFuncionario(int idUsuario);

        Empresa pesquisarEmpresaRegistrada();

        Funcionario pesquisarFuncionarioAtivo();

        Impressora pesquisarImpressoraAtiva();

        Nucleo pesquisarNucleoAtivo();

        Produto pesquisarProdutoPorId(long id);

        Produto pesquisarProdutoPorNome(String productName);

        List<Produto> getAllProducts();

        List<Unidade> getAllUnitys();

        void atualizarIdMaximoDeVenda(long idVendaMaxima);

        Unidade pesquisarUnidadePadraoDoProduto();

        Pedido pesquisarVendaPorId(Long id);

        /**
         * @return saleOrderIdSaved
         */
        void salvarPedido(final PedidoORM saleOrderToSave);
    }
}
