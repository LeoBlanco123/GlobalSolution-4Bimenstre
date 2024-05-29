package br.com.fiap.global.repository;

import br.com.fiap.global.entity.Sensores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensoresRepository extends JpaRepository<Sensores, Long> {
}
