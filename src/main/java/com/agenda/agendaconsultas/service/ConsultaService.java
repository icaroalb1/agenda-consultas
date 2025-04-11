package com.agenda.agendaconsultas.service;

import com.agenda.agendaconsultas.dto.CriarConsultaDTO;
import com.agenda.agendaconsultas.dto.DetalhesConsultaDTO;
import com.agenda.agendaconsultas.model.Consulta;
import com.agenda.agendaconsultas.model.Paciente;
import com.agenda.agendaconsultas.model.StatusConsulta;
import com.agenda.agendaconsultas.repository.ConsultaRepository;
import com.agenda.agendaconsultas.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    public DetalhesConsultaDTO agendar(CriarConsultaDTO dto) {
        Paciente paciente = pacienteRepository.findById(dto.getPacienteId())
                .orElseThrow(() -> new RuntimeException("Paciente com ID " + dto.getPacienteId() + " não encontrado."));

        Consulta consulta = new Consulta();
        consulta.setDataHora(dto.getDataHora());
        consulta.setEspecialidade(dto.getEspecialidade());
        consulta.setStatus(StatusConsulta.AGENDADA);
        consulta.setPaciente(paciente);

        consulta = consultaRepository.save(consulta);

        return new DetalhesConsultaDTO(
                consulta.getId(),
                consulta.getDataHora(),
                consulta.getEspecialidade(),
                consulta.getStatus(),
                paciente.getNome()
        );
    }

    public List<DetalhesConsultaDTO> listarTodas() {
        return consultaRepository.findAll().stream()
                .map(c -> new DetalhesConsultaDTO(
                        c.getId(),
                        c.getDataHora(),
                        c.getEspecialidade(),
                        c.getStatus(),
                        c.getPaciente().getNome()))
                .collect(Collectors.toList());
    }

    public void cancelar(Long id) {
        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consulta com ID " + id + " não encontrada."));

        if (consulta.getStatus() == StatusConsulta.CANCELADA) {
            throw new RuntimeException("A consulta com ID " + id + " já está cancelada.");
        }

        consulta.setStatus(StatusConsulta.CANCELADA);
        consultaRepository.save(consulta);
    }
}
