package br.com.fiap.global.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record RegistrosPoluicaoRequest(

        @NotNull(message = "A data é obrigatória")
        String data,
        @NotNull(message = "A hora é obrigatória")
        String hora,
        @NotNull(message = "A localização é obrigatória")
        String localizacao,
        @NotNull(message = "O tipo de poluição é obrigatório")
        String tipoPoluicao,
        @NotNull(message = "A quantidade poluída é obrigatória")
        Double quantidadePoluida,
        String testemunhas,
        @Valid
        @NotNull(message = "O id é obrigatório")
        AbstractRequest embarcacoes
) {
}
