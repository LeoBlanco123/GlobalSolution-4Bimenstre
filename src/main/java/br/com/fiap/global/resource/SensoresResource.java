package br.com.fiap.global.resource;

import br.com.fiap.global.dto.request.SensoresRequest;
import br.com.fiap.global.dto.response.SensoresResponse;
import br.com.fiap.global.entity.Sensores;
import br.com.fiap.global.repository.SensoresRepository;
import br.com.fiap.global.service.SensoresService;
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
@RequestMapping(value = "/sensores")
public class SensoresResource implements ResourceDTO<SensoresRequest, SensoresResponse> {

    @Autowired
    private SensoresService service;

    @GetMapping
    public ResponseEntity<Collection<SensoresResponse>> findAll(
            @RequestParam(name = "tipo", required = false) String tipo,
            @RequestParam(name = "localizacao", required = false) String localizacao,
            @RequestParam(name = "dataInstalacao", required = false) String dataInstalacao,
            @RequestParam(name = "status", required = false) String status
    ) {
        Sensores sensor = Sensores.builder()
                .tipo(tipo)
                .localizacao(localizacao)
                .dataInstalacao(dataInstalacao)
                .status(status)
                .build();

        ExampleMatcher matcher = ExampleMatcher.matchingAll()
                .withIgnoreNullValues()
                .withIgnoreCase();

        Example<Sensores> example = Example.of(sensor, matcher);

        var encontrados = service.findAll(example);
        if (encontrados.isEmpty()) return ResponseEntity.notFound().build();
        var resposta = encontrados.stream()
                .map(service::toResponse)
                .toList();
        return ResponseEntity.ok(resposta);
    }

    @Override
    @GetMapping(value = "/{id}")
    public ResponseEntity<SensoresResponse> findById(@PathVariable Long id) {
        var encontrado = service.findById(id);

        if (encontrado == null) return ResponseEntity.notFound().build();

        var resposta = service.toResponse(encontrado);
        return ResponseEntity.ok(resposta);
    }

    @Override
    @Transactional
    @PostMapping
    public ResponseEntity<SensoresResponse> save(@RequestBody @Valid SensoresRequest r) {
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
