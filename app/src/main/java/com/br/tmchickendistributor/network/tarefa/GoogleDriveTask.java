package com.br.tmchickendistributor.network.tarefa;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import com.br.tmchickendistributor.ui.mvp.home.IHomeMVP;
import com.br.tmchickendistributor.ui.mvp.home.Presenter;
import com.br.tmchickendistributor.util.ArquivoUtils;

public class GoogleDriveTask extends AsyncTask<Void, Void, Void> {

    IHomeMVP.IPresenter mHomePresenter;
    ProgressDialog progressDialog;
    ArquivoUtils mArquivoUtils;

    public GoogleDriveTask(final Presenter presenter) {
        this.mHomePresenter = presenter;
        mArquivoUtils = new ArquivoUtils();
    }

    @Override
    protected Void doInBackground(final Void... voids) {
         return estaSincronizado();
    }

    private Void estaSincronizado() {




         int[] count = {0};




        return null;
    }

    @Override
    protected void onPreExecute() {

        progressDialog = new ProgressDialog(mHomePresenter.getContext());
        progressDialog.setTitle("Fotos Google Drive");
        progressDialog.setMessage("Sincronizando fotos...");
        progressDialog.show();
    }


}
