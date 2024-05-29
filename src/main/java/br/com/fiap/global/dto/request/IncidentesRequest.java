package br.com.fiap.global.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record IncidentesRequest(

        @NotNull(message = "A data é obrigatória")
        String data,
        @NotNull(message = "A descrição é obrigatória")
        String descricao,
        @NotNull(message = "O tipo de poluição é obrigatório")
        String tipoPoluicao,
        @NotNull(message = "A severidade é obrigatória")
        String severidade,
        @Valid
        @NotNull(message = "O id é obrigatório")
        AbstractRequest embarcacoes
) {
}
