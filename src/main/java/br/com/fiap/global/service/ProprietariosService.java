package br.com.fiap.global.service;

import br.com.fiap.global.dto.request.ProprietariosRequest;
import br.com.fiap.global.dto.response.ProprietariosResponse;
import br.com.fiap.global.entity.Proprietarios;
import br.com.fiap.global.repository.ProprietariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.*;

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

    private Map<String, String> createLink(String rel, String href) {
        Map<String, String> link = new HashMap<>();
        link.put("rel", rel);
        link.put("href", href);
        return link;
    }

    @Override
    public ProprietariosResponse toResponse(Proprietarios e) {

        List<Map<String, String>> links = new ArrayList<>();

        links.add(createLink("GET by Example", "http://localhost/proprietarios/1"));
        links.add(createLink("GET", "http://localhost/proprietarios/1"));
        links.add(createLink("POST", "http://localhost/proprietarios"));

        links.add(createLink("GET by Example", "http://localhost/embarcacoes/1"));
        links.add(createLink("GET", "http://localhost/embarcacoes/1"));
        links.add(createLink("POST", "http://localhost/embarcacoes"));

        links.add(createLink("GET by Example", "http://localhost/sensores/1"));
        links.add(createLink("GET", "http://localhost/sensores/1"));
        links.add(createLink("POST", "http://localhost/sensores"));

        links.add(createLink("GET by Example", "http://localhost/incidentes/1"));
        links.add(createLink("GET", "http://localhost/incidentes/1"));
        links.add(createLink("POST", "http://localhost/incidentes"));

        links.add(createLink("GET by Example", "http://localhost/monitoramentos/1"));
        links.add(createLink("GET", "http://localhost/monitoramentos/1"));
        links.add(createLink("POST", "http://localhost/monitoramentos"));

        links.add(createLink("GET by Example", "http://localhost/registros-poluicao/1"));
        links.add(createLink("GET", "http://localhost/registros-poluicao/1"));
        links.add(createLink("POST", "http://localhost/registros-poluicao"));

        return ProprietariosResponse.builder()
                .id(e.getId())
                .email(e.getEmail())
                .endereco(e.getEndereco())
                .nome(e.getNome())
                .telefone(e.getTelefone())
                .links(links)
                .build();
    }
}
