package br.com.fiap.global.dto.response;

import lombok.Builder;

@Builder
public record RegistrosPoluicaoResponse(

        Long id,
        EmbarcacoesResponse embarcacao,
        String data,
        String hora,
        String localizacao,
        String tipoPoluicao,
        Double quantidadePoluida,
        String testemunhas
) {
}