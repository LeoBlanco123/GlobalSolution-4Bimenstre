package br.com.fiap.global.dto.response;

import lombok.Builder;

@Builder
public record EmbarcacoesResponse(

        Long id,
        String nome,
        String tipo,
        String bandeira,
        Double capacidade,
        Integer anoFabricacao,
        ProprietariosResponse proprietario
) {
}