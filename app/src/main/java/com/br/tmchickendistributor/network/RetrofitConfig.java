package com.br.tmchickendistributor.network;

import com.br.tmchickendistributor.network.servico.AutenticacaoService;
import com.br.tmchickendistributor.network.servico.ConfiguracaoService;
import com.br.tmchickendistributor.network.servico.ExportacaoService;
import com.br.tmchickendistributor.network.servico.ImportacaoService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitConfig {

  private Retrofit retrofit;

  public RetrofitConfig() {

    Gson gson =
        new GsonBuilder()
             .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
           // .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
            .create();

    OkHttpClient okHttpClient =
        new OkHttpClient()
            .newBuilder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .build();
    this.retrofit =
        new Retrofit.Builder()
            // .baseUrl("http://10.0.2.2:8080/api/")
            //.baseUrl("http://192.168.25.5:8080/api/")
            .baseUrl("https://tm-api-chicken-distributor.herokuapp.com/api/")
            /** AMBIENTE DE DESENVOLVIMENTO */
            .client(okHttpClient)

            .addConverterFactory(GsonConverterFactory.create(gson))
            //.addConverterFactory(JacksonConverterFactory.create())
            .build();
  }

  public ExportacaoService getExportacaoService() {
    return this.retrofit.create(ExportacaoService.class);
  }

  public ImportacaoService getImportacaoService() {

    return this.retrofit.create(ImportacaoService.class);
  }

  public AutenticacaoService getLoginService() {
    return this.retrofit.create(AutenticacaoService.class);
  }

  public ConfiguracaoService getConfiguracaoService() {
    return this.retrofit.create(ConfiguracaoService.class);
  }
}
