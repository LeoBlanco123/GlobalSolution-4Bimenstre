package br.com.fiap.global.resource;

import br.com.fiap.global.dto.request.RegistrosPoluicaoRequest;
import br.com.fiap.global.dto.response.RegistrosPoluicaoResponse;
import br.com.fiap.global.entity.RegistrosPoluicao;
import br.com.fiap.global.repository.RegistrosPoluicaoRepository;
import br.com.fiap.global.service.RegistrosPoluicaoService;
import br.com.fiap.global.repository.EmbarcacoesRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Collection;
import java.util.Objects;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/registros-poluicao")
public class RegistrosPoluicaoResource implements ResourceDTO<RegistrosPoluicaoRequest, RegistrosPoluicaoResponse> {

    @Autowired
    private RegistrosPoluicaoService service;

    @Autowired
    private EmbarcacoesRepository embarcacoesRepository;

    @GetMapping
    public ResponseEntity<Collection<RegistrosPoluicaoResponse>> findAll(
            @RequestParam(name = "idEmbarcacao", required = false) Long idEmbarcacao,
            @RequestParam(name = "data", required = false) String data,
            @RequestParam(name = "hora", required = false) String hora,
            @RequestParam(name = "localizacao", required = false) String localizacao,
            @RequestParam(name = "tipoPoluicao", required = false) String tipoPoluicao,
            @RequestParam(name = "quantidade", required = false) Double quantidade
    ) {
        var embarcacao = Objects.nonNull(idEmbarcacao) ? embarcacoesRepository
                .findById(idEmbarcacao)
                .orElse(null) : null;

        RegistrosPoluicao registro = RegistrosPoluicao.builder()
                .embarcacao(embarcacao)
                .data(data)
                .hora(hora)
                .localizacao(localizacao)
                .tipoPoluicao(tipoPoluicao)
                .quantidadePoluida(quantidade)
                .build();

        ExampleMatcher matcher = ExampleMatcher.matchingAll()
                .withIgnoreNullValues()
                .withIgnoreCase();

        Example<RegistrosPoluicao> example = Example.of(registro, matcher);

        var encontrados = service.findAll(example);
        if (encontrados.isEmpty()) return ResponseEntity.notFound().build();
        var resposta = encontrados.stream()
                .map(service::toResponse)
                .toList();
        return ResponseEntity.ok(resposta);
    }

    @Override
    @GetMapping(value = "/{id}")
    public ResponseEntity<RegistrosPoluicaoResponse> findById(@PathVariable Long id) {
        var encontrado = service.findById(id);

        if (encontrado == null) return ResponseEntity.notFound().build();

        var resposta = service.toResponse(encontrado);
        return ResponseEntity.ok(resposta);
    }

    @Override
    @Transactional
    @PostMapping
    public ResponseEntity<RegistrosPoluicaoResponse> save(@RequestBody @Valid RegistrosPoluicaoRequest r) {
        var entity = service.toEntity( r );
        var saved = service.save( entity );
        var resposta = service.toResponse( saved );

        var uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path( "/{id}" )
                .buildAndExpand( saved.getId() )
                .toUri();
        return ResponseEntity.created( uri ).body( resposta );
    }
}
