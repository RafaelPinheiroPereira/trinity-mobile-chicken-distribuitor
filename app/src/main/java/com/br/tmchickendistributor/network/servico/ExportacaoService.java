package com.br.tmchickendistributor.network.servico;

import com.br.tmchickendistributor.data.model.Exportacao;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ExportacaoService {
		
		@POST("exportacoes/pedidos")
        Call<Boolean> realizarExportacao(@Body Exportacao exportacao);
		
}
