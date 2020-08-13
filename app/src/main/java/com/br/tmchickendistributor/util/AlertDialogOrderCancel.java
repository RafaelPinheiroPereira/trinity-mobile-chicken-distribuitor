package com.br.tmchickendistributor.util;

import android.app.AlertDialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import com.br.tmchickendistributor.data.model.Pedido;
import com.br.tmchickendistributor.ui.mvp.pedido.IPedidoMVP;
import com.br.tmchickendistributor.ui.mvp.pedido.IPedidoMVP.IPresenter;
import com.br.tmchickendristributor.R;

public class AlertDialogOrderCancel {


    @BindView(R.id.btnNo)
    Button btnNo;

    @BindView(R.id.btnOk)
    Button btnOk;

    @BindView(R.id.edtCancelingMotive)
    EditText edtCancelingMotive;

    IPedidoMVP.IPresenter mPresenter;


    public AlertDialogOrderCancel(final IPresenter presenter) {
        mPresenter = presenter;
    }

    @OnClick(R.id.btnNo)
    public void btnNoCliked(View view) {
        mPresenter.dismiss();
    }

    @OnClick(R.id.btnOk)
    public void btnOkCliked(View view) {
        if (!TextUtils.isEmpty(edtCancelingMotive.getText().toString())) {
            mPresenter.cancelarPedido(edtCancelingMotive.getText().toString());
        } else {
            edtCancelingMotive.setError("Motivo Obrigatório");
        }
    }

    public AlertDialog builder(Pedido pedido) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(mPresenter.getContext());
        LayoutInflater inflater = (LayoutInflater) mPresenter.getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View dialogView = inflater.inflate(R.layout.cancela_pedido_dialog, null);
        ButterKnife.bind(this, dialogView);
        dialogBuilder.setView(dialogView);
        return dialogBuilder.create();

    }
}
