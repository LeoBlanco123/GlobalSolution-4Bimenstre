package br.com.fiap.global.service;

import br.com.fiap.global.dto.request.IncidentesRequest;
import br.com.fiap.global.dto.response.IncidentesResponse;
import br.com.fiap.global.entity.Incidentes;
import br.com.fiap.global.repository.IncidentesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class IncidentesService implements ServiceDTO<Incidentes, IncidentesRequest, IncidentesResponse> {

    @Autowired
    private IncidentesRepository repo;

    @Autowired
    private EmbarcacoesService embarcacoesService;

    @Override
    public Collection<Incidentes> findAll() {
        return repo.findAll();
    }

    @Override
    public Collection<Incidentes> findAll(Example<Incidentes> example) {
        return repo.findAll(example);
    }

    @Override
    public Incidentes findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Incidentes save(Incidentes e) {
        return repo.save(e);
    }

    @Override
    public Incidentes toEntity(IncidentesRequest dto) {

        var embarcacao = embarcacoesService.findById(dto.embarcacoes().id());

        return Incidentes.builder()
                .embarcacao(embarcacao)
                .data(dto.data())
                .descricao(dto.descricao())
                .tipoPoluicao(dto.tipoPoluicao())
                .severidade(dto.severidade())
                .build();
    }

    @Override
    public IncidentesResponse toResponse(Incidentes e) {

        var embarcacao = embarcacoesService.toResponse(e.getEmbarcacao());

        return IncidentesResponse.builder()
                .id(e.getId())
                .embarcacao(embarcacao)
                .data(e.getData())
                .descricao(e.getDescricao())
                .tipoPoluicao(e.getTipoPoluicao())
                .severidade(e.getSeveridade())
                .build();
    }
}
