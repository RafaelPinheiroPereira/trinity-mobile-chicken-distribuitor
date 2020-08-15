package com.br.tmchickendistributor.ui.mvp.visualizar;

import com.br.tmchickendistributor.data.dao.ClienteDAO;
import com.br.tmchickendistributor.data.dao.EmpresaDAO;
import com.br.tmchickendistributor.data.dao.ItemPedidoDAO;
import com.br.tmchickendistributor.data.dao.PedidoDAO;
import com.br.tmchickendistributor.data.model.Cliente;
import com.br.tmchickendistributor.data.model.Empresa;
import com.br.tmchickendistributor.data.model.Pedido;
import com.br.tmchickendistributor.data.realm.ClienteORM;
import com.br.tmchickendistributor.data.realm.EmpresaORM;
import com.br.tmchickendistributor.data.realm.ItemPedidoORM;
import com.br.tmchickendistributor.data.realm.PedidoORM;

public class Model implements IViewOrderMVP.IModel {

  ClienteDAO mClienteDAO = ClienteDAO.getInstace(ClienteORM.class);

  PedidoDAO mPedidoDAO = PedidoDAO.getInstace(PedidoORM.class);

  ItemPedidoDAO mItemPedidoDAO = ItemPedidoDAO.getInstace(ItemPedidoORM.class);

  EmpresaDAO mEmpresaDAO = EmpresaDAO.getInstace(EmpresaORM.class);

  IViewOrderMVP.IPresenter mPresenter;

  public Model(final Presenter presenter) {
    this.mPresenter = presenter;
  }

  @Override
  public void atualizarPedido(final Pedido pedido) {
    this.mPedidoDAO.alterar(new PedidoORM(pedido));
  }

  @Override
  public Cliente pesquisarClientePorID(final long codigoCliente) {
    return new Cliente(this.mClienteDAO.findById(codigoCliente));
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
