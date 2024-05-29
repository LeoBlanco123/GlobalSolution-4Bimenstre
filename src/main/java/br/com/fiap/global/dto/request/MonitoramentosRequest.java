package br.com.fiap.global.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
public record MonitoramentosRequest(

        @NotNull(message = "A data é obrigatória")
        String data,
        @NotNull(message = "A hora é obrigatória")
        String hora,
        @NotNull(message = "A localização é obrigatória")
        String localizacao,
        @NotNull(message = "O nível de poluição é obrigatório")
        Double nivelPoluicao,
        @Valid
        @NotNull(message = "O id é obrigatório")
        AbstractRequest embarcacoes,
        @Valid
        @NotNull(message = "O id é obrigatório")
        AbstractRequest sensores
) {
}