package br.com.fiap.global.repository;

import br.com.fiap.global.entity.Incidentes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncidentesRepository extends JpaRepository<Incidentes, Long> {
}
