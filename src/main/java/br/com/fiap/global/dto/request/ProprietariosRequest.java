package br.com.fiap.global.dto.request;

import jakarta.validation.constraints.NotNull;

public record ProprietariosRequest(

        @NotNull(message = "O nome é obrigatório")
        String nome,
        @NotNull(message = "O endereço é obrigatório")
        String endereco,
        @NotNull(message = "O telefone é obrigatório")
        String telefone,
        @NotNull(message = "O email é obrigatório")
        String email
) {
}