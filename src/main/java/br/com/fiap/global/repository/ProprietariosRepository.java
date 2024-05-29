package br.com.fiap.global.repository;

import br.com.fiap.global.entity.Proprietarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProprietariosRepository extends JpaRepository<Proprietarios, Long> {
}
