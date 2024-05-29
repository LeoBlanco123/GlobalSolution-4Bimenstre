package br.com.fiap.global.repository;

import br.com.fiap.global.entity.RegistrosPoluicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrosPoluicaoRepository extends JpaRepository<RegistrosPoluicao, Long> {
}
