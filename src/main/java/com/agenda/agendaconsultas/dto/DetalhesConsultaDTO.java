package com.agenda.agendaconsultas.dto;

import com.agenda.agendaconsultas.model.StatusConsulta;

import java.time.LocalDateTime;

public class DetalhesConsultaDTO {

    private Long id;
    private LocalDateTime dataHora;
    private String especialidade;
    private StatusConsulta status;
    private String nomePaciente;

    public DetalhesConsultaDTO(Long id, LocalDateTime dataHora, String especialidade, StatusConsulta status, String nomePaciente) {
        this.id = id;
        this.dataHora = dataHora;
        this.especialidade = especialidade;
        this.status = status;
        this.nomePaciente = nomePaciente;
    }

    // Getters
    public Long getId() { return id; }
    public LocalDateTime getDataHora() { return dataHora; }
    public String getEspecialidade() { return especialidade; }
    public StatusConsulta getStatus() { return status; }
    public String getNomePaciente() { return nomePaciente; }
}
