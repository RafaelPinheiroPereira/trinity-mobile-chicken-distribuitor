package com.br.tmchickendistributor.ui.mvp.visualizar;

import com.br.tmchickendistributor.data.dao.ClienteDAO;
import com.br.tmchickendistributor.data.dao.EmpresaDAO;
import com.br.tmchickendistributor.data.dao.FuncionarioDAO;
import com.br.tmchickendistributor.data.dao.ImpressoraDAO;
import com.br.tmchickendistributor.data.dao.ItemPedidoDAO;
import com.br.tmchickendistributor.data.dao.NucleoDAO;
import com.br.tmchickendistributor.data.dao.PedidoDAO;
import com.br.tmchickendistributor.data.model.Cliente;
import com.br.tmchickendistributor.data.model.Empresa;
import com.br.tmchickendistributor.data.model.Funcionario;
import com.br.tmchickendistributor.data.model.Impressora;
import com.br.tmchickendistributor.data.model.Nucleo;
import com.br.tmchickendistributor.data.model.Pedido;
import com.br.tmchickendistributor.data.realm.ClienteORM;
import com.br.tmchickendistributor.data.realm.EmpresaORM;
import com.br.tmchickendistributor.data.realm.FuncionarioORM;
import com.br.tmchickendistributor.data.realm.ImpressoraORM;
import com.br.tmchickendistributor.data.realm.ItemPedidoORM;
import com.br.tmchickendistributor.data.realm.NucleoORM;
import com.br.tmchickendistributor.data.realm.PedidoORM;

public class Model implements IViewOrderMVP.IModel {

  ClienteDAO mClienteDAO = ClienteDAO.getInstace(ClienteORM.class);

  PedidoDAO mPedidoDAO = PedidoDAO.getInstace(PedidoORM.class);

  ItemPedidoDAO mItemPedidoDAO = ItemPedidoDAO.getInstace(ItemPedidoORM.class);

  EmpresaDAO mEmpresaDAO = EmpresaDAO.getInstace(EmpresaORM.class);

  ImpressoraDAO impressoraDAO = ImpressoraDAO.getInstance(ImpressoraORM.class);

  NucleoDAO nucleoDAO = NucleoDAO.getInstace(NucleoORM.class);

  FuncionarioDAO funcionarioDAO = FuncionarioDAO.getInstace(FuncionarioORM.class);
  IViewOrderMVP.IPresenter mPresenter;

  public Model(final Presenter presenter) {
    this.mPresenter = presenter;
  }

  @Override
  public void atualizarPedido(final Pedido pedido) {
    this.mPedidoDAO.alterar(new PedidoORM(pedido));
  }

  @Override
  public Funcionario pesquiarFuncionarioAtivo() {
    return funcionarioDAO.pesquisarFuncionarioAtivo();
  }

  @Override
  public Cliente pesquisarClientePorID(final long codigoCliente) {
    return new Cliente(this.mClienteDAO.findById(codigoCliente));
  }

  @Override
  public Impressora pesquisarImpressoraAtiva() {
    return this.impressoraDAO.pesquisarImpressoraAtiva();
  }

  @Override
  public Nucleo pesquisarNucleoAtivo() {
    return this.nucleoDAO.pesquisarNucleoAtivo();
  }

  @Override
  public Pedido pesquisarVendaPorId(final Long id) {

    PedidoORM pedidoORM = mPedidoDAO.findById(id);
    Pedido pedido = new Pedido(pedidoORM);
    pedido.setItens(PedidoORM.converterListRealmParaModel(pedidoORM.getItens()));
    return pedido;
  }

  @Override
  public Empresa pesquisarEmpresaRegistrada() {
    return mEmpresaDAO.pesquisarEmpresaRegistradaNoDispositivo();
  }
}
