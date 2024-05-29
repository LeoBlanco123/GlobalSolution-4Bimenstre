package br.com.fiap.global.service;

import br.com.fiap.global.dto.request.ProprietariosRequest;
import br.com.fiap.global.dto.response.ProprietariosResponse;
import br.com.fiap.global.entity.Proprietarios;
import br.com.fiap.global.repository.ProprietariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ProprietariosService  implements ServiceDTO<Proprietarios, ProprietariosRequest, ProprietariosResponse>{

    @Autowired
    private ProprietariosRepository repo;

    @Override
    public Collection<Proprietarios> findAll() {
        return repo.findAll();
    }

    @Override
    public Collection<Proprietarios> findAll(Example<Proprietarios> example) {
        return repo.findAll(example);
    }

    @Override
    public Proprietarios findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Proprietarios save(Proprietarios e) {
        return repo.save(e);
    }

    @Override
    public Proprietarios toEntity(ProprietariosRequest dto) {
        return Proprietarios.builder()
                .email(dto.email())
                .endereco(dto.endereco())
                .nome(dto.nome())
                .telefone(dto.telefone())
                .build();
    }

    @Override
    public ProprietariosResponse toResponse(Proprietarios e) {
        return ProprietariosResponse.builder()
                .id(e.getId())
                .email(e.getEmail())
                .endereco(e.getEndereco())
                .nome(e.getNome())
                .telefone(e.getTelefone())
                .build();
    }
}
