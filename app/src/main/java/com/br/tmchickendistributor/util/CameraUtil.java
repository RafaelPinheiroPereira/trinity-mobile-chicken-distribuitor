package com.br.tmchickendistributor.util;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Build.VERSION_CODES;
import android.os.Environment;
import android.provider.MediaStore;
import androidx.core.content.FileProvider;

import com.br.tmchickendristributor.BuildConfig;
import java.io.File;
import java.io.IOException;

public class CameraUtil {

    public static String LOCAL_ONDE_A_IMAGEM_FOI_SALVA = "";

    public static final int RESULTADO_INTENCAO_FOTO = 72;




    Activity mActivity;

    public CameraUtil(final Activity activity) {
        mActivity = activity;
    }

    public void tirarFoto(String nomeDiretorio, String nomeFoto) throws IOException {
        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        File photoFile = this.criarArquivoDaImagem(nomeFoto,nomeDiretorio);

        if (VERSION.SDK_INT >= VERSION_CODES.N) {
            Uri fotoURI =
                    FileProvider.getUriForFile(
                            this.mActivity, BuildConfig.APPLICATION_ID + ".provider", photoFile);
            i.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);

            i.putExtra(MediaStore.EXTRA_OUTPUT, fotoURI);

        } else {

            i.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(photoFile));
        }

        LOCAL_ONDE_A_IMAGEM_FOI_SALVA = photoFile.getPath();

        mActivity.startActivityForResult(i, RESULTADO_INTENCAO_FOTO);
    }

    private File criarArquivoDaImagem(String nomeFoto,String  diretorio)  {

        File filesDir;
        // Make sure it's available
        if (android.os.Build.VERSION.SDK_INT <= 28) {
            filesDir = new File(Environment.getExternalStorageDirectory()+ "/Trinity_Mobile/",diretorio);
        } else {
            filesDir = new File(this.mActivity.getExternalMediaDirs()[0].getAbsolutePath() + File.separator+"Trinity_Mobile"+ File.separator +diretorio);
        }

        if(!filesDir.exists()) filesDir.mkdirs();
        return new File(filesDir,nomeFoto + ".jpg");
    }
}
