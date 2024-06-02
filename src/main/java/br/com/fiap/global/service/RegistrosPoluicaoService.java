package br.com.fiap.global.service;

import br.com.fiap.global.dto.request.RegistrosPoluicaoRequest;
import br.com.fiap.global.dto.response.RegistrosPoluicaoResponse;
import br.com.fiap.global.entity.RegistrosPoluicao;
import br.com.fiap.global.repository.RegistrosPoluicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class RegistrosPoluicaoService implements ServiceDTO<RegistrosPoluicao, RegistrosPoluicaoRequest, RegistrosPoluicaoResponse> {

    @Autowired
    private RegistrosPoluicaoRepository repo;

    @Autowired
    private EmbarcacoesService embarcacoesService;

    @Override
    public Collection<RegistrosPoluicao> findAll() {
        return repo.findAll();
    }

    @Override
    public Collection<RegistrosPoluicao> findAll(Example<RegistrosPoluicao> example) {
        return repo.findAll(example);
    }

    @Override
    public RegistrosPoluicao findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public RegistrosPoluicao save(RegistrosPoluicao e) {
        return repo.save(e);
    }

    @Override
    public RegistrosPoluicao toEntity(RegistrosPoluicaoRequest dto) {

        var embarcacao = embarcacoesService.findById(dto.embarcacoes().id());

        return RegistrosPoluicao.builder()
                .embarcacao(embarcacao)
                .data(dto.data())
                .hora(dto.hora())
                .localizacao(dto.localizacao())
                .tipoPoluicao(dto.tipoPoluicao())
                .quantidadePoluida(dto.quantidadePoluida())
                .testemunhas(dto.testemunhas())
                .build();
    }

    @Override
    public RegistrosPoluicaoResponse toResponse(RegistrosPoluicao e) {

        var embarcacao = embarcacoesService.toResponse(e.getEmbarcacao());

        return RegistrosPoluicaoResponse.builder()
                .id(e.getId())
                .embarcacao(embarcacao)
                .data(e.getData())
                .hora(e.getHora())
                .localizacao(e.getLocalizacao())
                .tipoPoluicao(e.getTipoPoluicao())
                .quantidadePoluida(e.getQuantidadePoluida())
                .testemunhas(e.getTestemunhas())
                .build();
    }
}
