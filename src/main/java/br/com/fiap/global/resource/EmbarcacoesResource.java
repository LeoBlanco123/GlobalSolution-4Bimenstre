package br.com.fiap.global.resource;

import br.com.fiap.global.dto.request.EmbarcacoesRequest;
import br.com.fiap.global.dto.response.EmbarcacoesResponse;
import br.com.fiap.global.entity.Embarcacoes;
import br.com.fiap.global.repository.ProprietariosRepository;
import br.com.fiap.global.service.EmbarcacoesService;
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
@RequestMapping(value = "/embarcacoes")
public class EmbarcacoesResource implements ResourceDTO<EmbarcacoesRequest, EmbarcacoesResponse> {

    @Autowired
    private EmbarcacoesService service;

    @Autowired
    private ProprietariosRepository proprietariosRepository;

    @GetMapping
    public ResponseEntity<Collection<EmbarcacoesResponse>> findAll(
            @RequestParam(name = "nome", required = false) String nome,
            @RequestParam(name = "tipo", required = false) String tipo,
            @RequestParam(name = "bandeira", required = false) String bandeira,
            @RequestParam(name = "capacidade", required = false) Double capacidade,
            @RequestParam(name = "anoFabricacao", required = false) Integer anoFabricacao,
            @RequestParam(name = "proprietarios.id", required = false) Long idProprietarios
    ) {
        var proprietarios = Objects.nonNull(idProprietarios) ? proprietariosRepository
                .findById(idProprietarios)
                .orElse(null) : null;

        Embarcacoes embarcacoes = Embarcacoes.builder()
                .nome(nome)
                .tipo(tipo)
                .bandeira(bandeira)
                .capacidade(capacidade)
                .anoFabricacao(anoFabricacao)
                .proprietario(proprietarios)
                .build();

        ExampleMatcher matcher = ExampleMatcher.matchingAll()
                .withIgnoreNullValues()
                .withIgnoreCase();

        Example<Embarcacoes> example = Example.of(embarcacoes, matcher);

        var encontrados = service.findAll(example);
        if (encontrados.isEmpty()) return ResponseEntity.notFound().build();
        var resposta = encontrados.stream()
                .map(service::toResponse)
                .toList();
        return ResponseEntity.ok(resposta);
    }

    @Override
    @GetMapping(value = "/{id}")
    public ResponseEntity<EmbarcacoesResponse> findById(@PathVariable Long id) {
        var encontrado = service.findById(id);

        if (encontrado == null) return ResponseEntity.notFound().build();

        var resposta = service.toResponse(encontrado);
        return ResponseEntity.ok(resposta);
    }

    @Override
    @Transactional
    @PostMapping
    public ResponseEntity<EmbarcacoesResponse> save(@RequestBody @Valid EmbarcacoesRequest r) {
        var entity = service.toEntity(r);
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
