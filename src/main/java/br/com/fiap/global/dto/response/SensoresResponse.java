package br.com.fiap.global.dto.response;

import lombok.Builder;

@Builder
public record SensoresResponse(

        Long id,
        String tipo,
        String localizacao,
        String dataInstalacao,
        String status
) {
}