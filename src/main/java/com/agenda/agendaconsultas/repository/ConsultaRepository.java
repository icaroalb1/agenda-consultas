package com.agenda.agendaconsultas.repository;

import com.agenda.agendaconsultas.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
}
