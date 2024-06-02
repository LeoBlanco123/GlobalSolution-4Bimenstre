package br.com.fiap.global.resource;

import br.com.fiap.global.dto.request.ProprietariosRequest;
import br.com.fiap.global.dto.response.ProprietariosResponse;
import br.com.fiap.global.entity.Proprietarios;
import br.com.fiap.global.service.ProprietariosService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Collection;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/proprietarios")
public class ProprietariosResource implements ResourceDTO<ProprietariosRequest, ProprietariosResponse> {

    @Autowired
    private ProprietariosService service;

    @GetMapping
    public ResponseEntity<Collection<ProprietariosResponse>> findAll(
            @RequestParam(name = "nome", required = false) String nome,
            @RequestParam(name = "endereco", required = false) String endereco,
            @RequestParam(name = "telefone", required = false) String telefone,
            @RequestParam(name = "email", required = false) String email
    ) {
        Proprietarios proprietario = Proprietarios.builder()
                .nome(nome)
                .endereco(endereco)
                .telefone(telefone)
                .email(email)
                .build();

        ExampleMatcher matcher = ExampleMatcher.matchingAll()
                .withIgnoreNullValues()
                .withIgnoreCase();

        Example<Proprietarios> example = Example.of(proprietario, matcher);

        var encontrados = service.findAll(example);
        if (encontrados.isEmpty()) return ResponseEntity.notFound().build();
        var resposta = encontrados.stream()
                .map(service::toResponse)
                .toList();
        return ResponseEntity.ok(resposta);
    }

    @Override
    @GetMapping(value = "/{id}")
    public ResponseEntity<ProprietariosResponse> findById(@PathVariable Long id) {
        var encontrado = service.findById(id);

        if (encontrado == null) return ResponseEntity.notFound().build();

        var resposta = service.toResponse(encontrado);
        return ResponseEntity.ok(resposta);
    }

    @Override
    @Transactional
    @PostMapping
    public ResponseEntity<ProprietariosResponse> save(@RequestBody @Valid ProprietariosRequest r) {
        var entity = service.toEntity(r);
        var saved = service.save(entity);
        var resposta = service.toResponse(saved);

        var uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(saved.getId())
                .toUri();
        return ResponseEntity.created(uri).body(resposta);
    }
}
