package br.com.fiap.global.dto.response;

import lombok.Builder;

@Builder
public record ProprietariosResponse(

        Long id,
        String nome,
        String endereco,
        String telefone,
        String email
) {
}