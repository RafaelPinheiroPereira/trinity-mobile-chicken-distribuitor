package com.br.tmchickendistributor.ui.mvp.home;

import android.content.Context;
import android.os.Bundle;

import com.br.tmchickendistributor.data.model.BlocoRecibo;
import com.br.tmchickendistributor.data.model.Cliente;
import com.br.tmchickendistributor.data.model.ClienteGrupo;
import com.br.tmchickendistributor.data.model.Empresa;
import com.br.tmchickendistributor.data.model.Funcionario;
import com.br.tmchickendistributor.data.model.Nucleo;
import com.br.tmchickendistributor.data.model.Pedido;
import com.br.tmchickendistributor.data.model.Recebimento;
import com.br.tmchickendistributor.data.model.Rota;
import com.br.tmchickendistributor.util.DriveServiceHelper;

import java.util.Collection;
import java.util.List;

public interface IHomeMVP {

    interface IPresenter {

        void atualizarBlocoReciboPorNomeDaFoto(String name);

        void atualizarPedidoPorNomeDaFoto(String name);

        List<Pedido> consultarPedidosNaoMigrados();

        List<BlocoRecibo> consultarRecibosNaoMigrados();

        void desativarNucleo();

        void excluirBlocos();

        void excluirRecebimentos();

        Nucleo getNucleo();

        List<Recebimento> getRecebimentos();

        Nucleo pesquisarNucleoAtivo();

        Funcionario pesquisarUsuarioDaSesao();

        void retirarFuncionarioDaSessao();

        Funcionario getFuncionario();

        void setFuncionario(Funcionario funcionario);

        void criarPastasNoDrive(Funcionario funcionario);

        void salvarFotosNoDrive();

        void esconderProgressDialog();

        void exibirDialogClient(final Cliente cliente);

        void exibirDialogLogout();

        List<ClienteGrupo> obterTodasRedes();

        List<Rota> obterTodasRotas();

        List<Cliente> obterTodosClientes();

        List<Cliente> pesquisarClientePorRede(ClienteGrupo ClienteGrupo);

        List<Cliente> pesquisarClientePorRota(Rota rota);

        List<Recebimento> pesquisarRecebimentoPorCliente(Cliente cliente);

        void exibirProgressDialog();

        void exibirToast(String msg);

        Context getContext();

        void exportar();

        void fecharDrawer();


        DriveServiceHelper getDriveServiceHelper();

        void setDriveServiceHelper(DriveServiceHelper driveServiceHelper);

        void setDrawer(final Bundle savedInstanceState);


        void importar();

        void setAdapters();

        void navigateToReceiptsActivity(Cliente cliente);

        void navigateToSalesActivity(Cliente cliente);

        void obterClientesAposImportarDados();

        void obterRotasAposImportarDados();

        void setNucleo(Nucleo pesquisarNucleoAtivo);

        void verificarCredenciaisGoogleDrive();


        List<Pedido> getFotosPedidos();

        void setFotosPedidos(List<Pedido> fotosPedidos);

        List<BlocoRecibo> getFotosRecibos();

        void setFotosRecibos(List<BlocoRecibo> fotosRecibos);



    }

    interface IView {

        void fecharDrawer();

        void setAdapters();

        void setDrawer(final Bundle savedInstanceState);

        void showDialogClient(final Cliente cliente);

        void onShowProgressDialog();

        void onHideProgressDialog();

        void obterClientesAposImportarDados();

        void obterRotasAposImportarDados();

        void showDialogLogout();

        void verificarCredenciaisGoogleDrive();
    }

    interface IModel {

        void alterarFuncionario(Funcionario funcionario);

        void atualizarBlocoReciboParaMigrado(BlocoRecibo blocoRecibo);

        void atualizarPedidoParaMigrado(Pedido pedido);

        Pedido consultarPedidoPorNomeDaFoto(String name);

        void desativarNucleo();

        void excluirBlocos();

        void inativarFuncionarioDaSessao();

        List<ClienteGrupo> obterTodasRedes();

        List<Rota> obterTodasRotas();

        List<Cliente> obterTodosClientes();

        List<Pedido> obterTodosPedidos();

        List<Recebimento> obterRecebimentosRealizados();

        BlocoRecibo pesquisarBlocoReciboPorNomeDaFoto(String name);

        List<Cliente> pesquisarClientePorRede(ClienteGrupo clienteGrupo);

        Empresa pesquisarEmpresaRegistrada();

        Funcionario pesquisarFuncionarioDaSessao();

        Nucleo pesquisarNucleoAtivo();

        List<Pedido> pesquisarPedidosNaoMigrados();

        List<Recebimento> pesquisarRecebimentoPorCliente(Cliente cliente);

        List<BlocoRecibo> pesquisarRecibosNaoMigrados();

        List<Recebimento> pesquisarTodosRecebimentos();

        void sincronizarFotos();

        void salvarRecebimento(Recebimento recebimento);

        void excluirRecebimentos();

        List<Cliente> pesquisarClientePorRota(Rota rota);
    }
}
