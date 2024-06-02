package br.com.fiap.global.service;

import br.com.fiap.global.dto.request.EmbarcacoesRequest;
import br.com.fiap.global.dto.response.EmbarcacoesResponse;
import br.com.fiap.global.entity.Embarcacoes;
import br.com.fiap.global.repository.EmbarcacoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class EmbarcacoesService implements ServiceDTO<Embarcacoes, EmbarcacoesRequest, EmbarcacoesResponse> {

    @Autowired
    private EmbarcacoesRepository repo;

    @Autowired
    private ProprietariosService proprietariosService;

    @Override
    public Collection<Embarcacoes> findAll() {
        return repo.findAll();
    }

    @Override
    public Collection<Embarcacoes> findAll(Example<Embarcacoes> example) {
        return repo.findAll(example);
    }

    @Override
    public Embarcacoes findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Embarcacoes save(Embarcacoes e) {
        return repo.save(e);
    }

    @Override
    public Embarcacoes toEntity(EmbarcacoesRequest dto) {

        var proprietario = proprietariosService.findById(dto.proprietarios().id());

        return Embarcacoes.builder()
                .nome(dto.nome())
                .tipo(dto.tipo())
                .bandeira(dto.bandeira())
                .capacidade(dto.capacidade())
                .anoFabricacao(dto.anoFabricacao())
                .proprietario(proprietario)
                .build();
    }

    @Override
    public EmbarcacoesResponse toResponse(Embarcacoes e) {

        var proprietario = proprietariosService.toResponse(e.getProprietario());

        return EmbarcacoesResponse.builder()
                .id(e.getId())
                .nome(e.getNome())
                .tipo(e.getTipo())
                .bandeira(e.getBandeira())
                .capacidade(e.getCapacidade())
                .anoFabricacao(e.getAnoFabricacao())
                .proprietario(proprietario)
                .build();
    }
}
