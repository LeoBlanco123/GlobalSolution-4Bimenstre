package br.com.fiap.global.dto.request;

import jakarta.validation.constraints.NotNull;
public record SensoresRequest(

        @NotNull(message = "O tipo é obrigatório")
        String tipo,
        @NotNull(message = "A localização é obrigatória")
        String localizacao,
        @NotNull(message = "A data de instalação é obrigatória")
        String dataInstalacao,
        @NotNull(message = "O status é obrigatório")
        String status
) {
}