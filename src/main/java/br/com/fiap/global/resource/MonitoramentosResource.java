package br.com.fiap.global.resource;

import br.com.fiap.global.dto.request.MonitoramentosRequest;
import br.com.fiap.global.dto.response.MonitoramentosResponse;
import br.com.fiap.global.entity.Monitoramentos;
import br.com.fiap.global.service.MonitoramentosService;
import br.com.fiap.global.repository.EmbarcacoesRepository;
import br.com.fiap.global.repository.SensoresRepository;
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
@RequestMapping(value = "/monitoramentos")
public class MonitoramentosResource implements ResourceDTO<MonitoramentosRequest, MonitoramentosResponse> {

    @Autowired
    private MonitoramentosService service;

    @Autowired
    private EmbarcacoesRepository embarcacoesRepository;

    @Autowired
    private SensoresRepository sensoresRepository;

    @GetMapping
    public ResponseEntity<Collection<MonitoramentosResponse>> findAll(
            @RequestParam(name = "idEmbarcacao", required = false) Long idEmbarcacao,
            @RequestParam(name = "idSensor", required = false) Long idSensor,
            @RequestParam(name = "data", required = false) String data,
            @RequestParam(name = "hora", required = false) String hora,
            @RequestParam(name = "localizacao", required = false) String localizacao,
            @RequestParam(name = "nivelPoluicao", required = false) Double nivelPoluicao
    ) {
        var embarcacao = Objects.nonNull(idEmbarcacao) ? embarcacoesRepository
                .findById(idEmbarcacao)
                .orElse(null) : null;

        var sensor = Objects.nonNull(idSensor) ? sensoresRepository
                .findById(idSensor)
                .orElse(null) : null;

        Monitoramentos monitoramento = Monitoramentos.builder()
                .embarcacao(embarcacao)
                .sensor(sensor)
                .data(data)
                .hora(hora)
                .localizacao(localizacao)
                .nivelPoluicao(nivelPoluicao)
                .build();

        ExampleMatcher matcher = ExampleMatcher.matchingAll()
                .withIgnoreNullValues()
                .withIgnoreCase();

        Example<Monitoramentos> example = Example.of(monitoramento, matcher);

        var encontrados = service.findAll(example);
        if (encontrados.isEmpty()) return ResponseEntity.notFound().build();
        var resposta = encontrados.stream()
                .map(service::toResponse)
                .toList();
        return ResponseEntity.ok(resposta);
    }

    @Override
    @GetMapping(value = "/{id}")
    public ResponseEntity<MonitoramentosResponse> findById(@PathVariable Long id) {
        var encontrado = service.findById(id);

        if (encontrado == null) return ResponseEntity.notFound().build();

        var resposta = service.toResponse(encontrado);
        return ResponseEntity.ok(resposta);
    }
    @Override
    @Transactional
    @PostMapping
    public ResponseEntity<MonitoramentosResponse> save(@RequestBody @Valid MonitoramentosRequest r) {
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
