package com.agenda.agendaconsultas.service;

import com.agenda.agendaconsultas.dto.CriarPacienteDTO;
import com.agenda.agendaconsultas.dto.DetalhesPacienteDTO;
import com.agenda.agendaconsultas.model.Paciente;
import com.agenda.agendaconsultas.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public DetalhesPacienteDTO cadastrar(CriarPacienteDTO dto) {
        Paciente paciente = new Paciente(null, dto.getNome(), dto.getTelefone(), dto.getEmail(), dto.getCpf());
        paciente = pacienteRepository.save(paciente);
        return new DetalhesPacienteDTO(paciente.getId(), paciente.getNome(), paciente.getTelefone(), paciente.getEmail(), paciente.getCpf());
    }

    public List<DetalhesPacienteDTO> listarTodos() {
        return pacienteRepository.findAll().stream()
                .map(p -> new DetalhesPacienteDTO(p.getId(), p.getNome(), p.getTelefone(), p.getEmail(), p.getCpf()))
                .collect(Collectors.toList());
    }

    public DetalhesPacienteDTO buscarPorId(Long id) {
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));

        return new DetalhesPacienteDTO(paciente.getId(), paciente.getNome(), paciente.getTelefone(), paciente.getEmail(), paciente.getCpf());
    }

    public void deletar(Long id) {
        pacienteRepository.deleteById(id);
    }
}
