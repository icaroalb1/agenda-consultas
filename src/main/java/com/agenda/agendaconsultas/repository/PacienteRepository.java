package com.agenda.agendaconsultas.repository;

import com.agenda.agendaconsultas.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
