package br.com.fiap.global.service;

import br.com.fiap.global.dto.request.SensoresRequest;
import br.com.fiap.global.dto.response.SensoresResponse;
import br.com.fiap.global.entity.Sensores;
import br.com.fiap.global.repository.SensoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class SensoresService implements ServiceDTO<Sensores, SensoresRequest, SensoresResponse> {

    @Autowired
    private SensoresRepository repo;

    @Override
    public Collection<Sensores> findAll() {
        return repo.findAll();
    }

    @Override
    public Collection<Sensores> findAll(Example<Sensores> example) {
        return repo.findAll(example);
    }

    @Override
    public Sensores findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Sensores save(Sensores e) {
        return repo.save(e);
    }

    @Override
    public Sensores toEntity(SensoresRequest dto) {
        return Sensores.builder()
                .tipo(dto.tipo())
                .localizacao(dto.localizacao())
                .dataInstalacao(dto.dataInstalacao())
                .status(dto.status())
                .build();
    }

    @Override
    public SensoresResponse toResponse(Sensores e) {
        return SensoresResponse.builder()
                .id(e.getId())
                .tipo(e.getTipo())
                .localizacao(e.getLocalizacao())
                .dataInstalacao(e.getDataInstalacao())
                .status(e.getStatus())
                .build();
    }
}
