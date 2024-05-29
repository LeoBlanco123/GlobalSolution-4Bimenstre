package br.com.fiap.global.dto.response;

import lombok.Builder;

@Builder
public record MonitoramentosResponse(

        Long id,
        EmbarcacoesResponse embarcacao,
        SensoresResponse sensor,
        String data,
        String hora,
        String localizacao,
        Double nivelPoluicao
) {
}