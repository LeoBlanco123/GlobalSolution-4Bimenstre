package br.com.fiap.global.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
public record EmbarcacoesRequest(

        @NotNull(message = "O nome é obrigatório")
        String nome,
        @NotNull(message = "O tipo é obrigatório")
        String tipo,
        @NotNull(message = "A bandeira é obrigatória")
        String bandeira,
        @NotNull(message = "A capacidade é obrigatória")
        Double capacidade,
        @NotNull(message = "O ano de fabricação é obrigatório")
        Integer anoFabricacao,
        @Valid
        @NotNull(message = "O id é obrigatório")
        AbstractRequest proprietarios
) {
}