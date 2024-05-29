package br.com.fiap.global.repository;

import br.com.fiap.global.entity.Embarcacoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmbarcacoesRepository extends JpaRepository<Embarcacoes, Long> {
}
