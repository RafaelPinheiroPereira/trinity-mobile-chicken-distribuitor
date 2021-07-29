package com.br.tmchickendistributor.util;

import android.app.Activity;
import android.os.Environment;
import android.util.Log;

import com.br.tmchickendistributor.ui.abstracts.AbstractActivity;

import java.io.File;

public class ArquivoUtils {

    public void criarPastasDasImagens(Activity activity) {
        File diretorioVendas = null;
        File diretorioPagamentos = null;
        if (existeCartaoDeMemoria()) {
            diretorioPagamentos = criarArquivo(activity, ConstantsUtil.CAMINHO_IMAGEM_RECEBIMENTOS);
            diretorioVendas = criarArquivo(activity, ConstantsUtil.CAMINHO_IMAGEM_VENDAS);
        } else {
            Log.d(ArquivoUtils.class.getName(), "Nao existe sd card");
        }
        if (!diretorioVendas.exists()) {
            diretorioVendas.mkdirs();
        }
        if (!diretorioPagamentos.exists()) {
            diretorioPagamentos.mkdirs();
        }

        if (!diretorioVendas.exists() || !diretorioVendas.exists()) {
            AbstractActivity.showToast(activity.getApplicationContext(), "Não foi posível criar as pastas de imagens.");
        } else
            AbstractActivity.showToast(activity.getApplicationContext(), "Pastas criadas com sucesso.");

    }

    public File[] lerFotosDoDiretorio(Activity activity, String nomeDiretorio) {
        return criarArquivo(activity,nomeDiretorio).listFiles();
    }

    public boolean existeCartaoDeMemoria() {
        return Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState());
    }

    private File criarArquivo(Activity activity, String nomeDiretorio) {

        if (android.os.Build.VERSION.SDK_INT >= 29) {
            String pathMedia = activity.getExternalMediaDirs()[0].getAbsolutePath();
            return new File(
                    pathMedia + File.separator + "Trinity_Mobile" + File.separator, nomeDiretorio);
        } else {
            return new File(
                    Environment.getExternalStorageDirectory() + File.separator + "Trinity_Mobile" + File.separator, nomeDiretorio);
        }


    }
}
