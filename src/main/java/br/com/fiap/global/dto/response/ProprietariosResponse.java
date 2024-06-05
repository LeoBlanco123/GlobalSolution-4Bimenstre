package br.com.fiap.global.dto.response;

import lombok.Builder;

import java.util.List;
import java.util.Map;

@Builder
public record ProprietariosResponse(

        Long id,
        String nome,
        String endereco,
        String telefone,
        String email,
        List<Map<String, String>> links
) {
}