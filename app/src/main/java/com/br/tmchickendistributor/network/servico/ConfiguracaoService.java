package com.br.tmchickendistributor.network.servico;

import com.br.tmchickendistributor.data.model.Configuracao;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ConfiguracaoService {
    @GET("configuracoes/ativada")
    Call<Configuracao> verificarAtivacao(@Query("cnpj") String cnpj, @Query("mac") String mac);
}
