package br.com.fiap.global.resource;

import br.com.fiap.global.dto.request.IncidentesRequest;
import br.com.fiap.global.dto.response.IncidentesResponse;
import br.com.fiap.global.entity.Incidentes;
import br.com.fiap.global.service.IncidentesService;
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
@RequestMapping(value = "/incidentes")
public class IncidentesResource implements ResourceDTO<IncidentesRequest, IncidentesResponse> {

    @Autowired
    private IncidentesService service;

    @Autowired
    private EmbarcacoesRepository embarcacoesRepository;

    @GetMapping
    public ResponseEntity<Collection<IncidentesResponse>> findAll(
            @RequestParam(name = "idEmbarcacao", required = false) Long idEmbarcacao,
            @RequestParam(name = "data", required = false) String data,
            @RequestParam(name = "descricao", required = false) String descricao,
            @RequestParam(name = "tipoPoluicao", required = false) String tipoPoluicao,
            @RequestParam(name = "severidade", required = false) String severidade
    ) {
        var embarcacao = Objects.nonNull(idEmbarcacao) ? embarcacoesRepository
                .findById(idEmbarcacao)
                .orElse(null) : null;

        Incidentes incidente = Incidentes.builder()
                .embarcacao(embarcacao)
                .data(data)
                .descricao(descricao)
                .tipoPoluicao(tipoPoluicao)
                .severidade(severidade)
                .build();

        ExampleMatcher matcher = ExampleMatcher.matchingAll()
                .withIgnoreNullValues()
                .withIgnoreCase();

        Example<Incidentes> example = Example.of(incidente, matcher);

        var encontrados = service.findAll(example);
        if (encontrados.isEmpty()) return ResponseEntity.notFound().build();
        var resposta = encontrados.stream()
                .map(service::toResponse)
                .toList();
        return ResponseEntity.ok(resposta);
    }

    @Override
    @GetMapping(value = "/{id}")
    public ResponseEntity<IncidentesResponse> findById(@PathVariable Long id) {
        var encontrado = service.findById(id);

        if (encontrado == null) return ResponseEntity.notFound().build();

        var resposta = service.toResponse(encontrado);
        return ResponseEntity.ok(resposta);
    }

    @Override
    @Transactional
    @PostMapping
    public ResponseEntity<IncidentesResponse> save(@RequestBody @Valid IncidentesRequest r) {
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
