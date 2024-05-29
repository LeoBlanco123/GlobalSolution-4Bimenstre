package br.com.fiap.global.repository;

import br.com.fiap.global.entity.Monitoramentos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonitoramentosRepository extends JpaRepository<Monitoramentos, Long> {
}
