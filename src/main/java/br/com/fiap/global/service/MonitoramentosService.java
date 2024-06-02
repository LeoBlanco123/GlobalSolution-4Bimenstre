package br.com.fiap.global.service;

import br.com.fiap.global.dto.request.MonitoramentosRequest;
import br.com.fiap.global.dto.response.MonitoramentosResponse;
import br.com.fiap.global.entity.Monitoramentos;
import br.com.fiap.global.repository.MonitoramentosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MonitoramentosService implements ServiceDTO<Monitoramentos, MonitoramentosRequest, MonitoramentosResponse> {

    @Autowired
    private MonitoramentosRepository repo;

    @Autowired
    private EmbarcacoesService embarcacoesService;

    @Autowired
    private SensoresService sensoresService;

    @Override
    public Collection<Monitoramentos> findAll() {
        return repo.findAll();
    }

    @Override
    public Collection<Monitoramentos> findAll(Example<Monitoramentos> example) {
        return repo.findAll(example);
    }

    @Override
    public Monitoramentos findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Monitoramentos save(Monitoramentos e) {
        return repo.save(e);
    }

    @Override
    public Monitoramentos toEntity(MonitoramentosRequest dto) {

        var embarcacao = embarcacoesService.findById(dto.embarcacoes().id());
        var sensor = sensoresService.findById(dto.sensores().id());

        return Monitoramentos.builder()
                .embarcacao(embarcacao)
                .sensor(sensor)
                .data(dto.data())
                .hora(dto.hora())
                .localizacao(dto.localizacao())
                .nivelPoluicao(dto.nivelPoluicao())
                .build();
    }

    @Override
    public MonitoramentosResponse toResponse(Monitoramentos e) {

        var embarcacao = embarcacoesService.toResponse(e.getEmbarcacao());
        var sensor = sensoresService.toResponse(e.getSensor());

        return MonitoramentosResponse.builder()
                .id(e.getId())
                .embarcacao(embarcacao)
                .sensor(sensor)
                .data(e.getData())
                .hora(e.getHora())
                .localizacao(e.getLocalizacao())
                .nivelPoluicao(e.getNivelPoluicao())
                .build();
    }
}
