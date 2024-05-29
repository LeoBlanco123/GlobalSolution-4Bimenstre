package br.com.fiap.global.dto.response;

import lombok.Builder;

@Builder
public record IncidentesResponse(

        Long id,
        EmbarcacoesResponse embarcacao,
        String data,
        String descricao,
        String tipoPoluicao,
        String severidade
) {
}