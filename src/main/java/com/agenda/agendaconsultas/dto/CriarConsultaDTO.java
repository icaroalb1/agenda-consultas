package com.agenda.agendaconsultas.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

public class CriarConsultaDTO {

    @NotNull(message = "Data/hora é obrigatória")
    @Future(message = "A data deve estar no futuro")
    private LocalDateTime dataHora;

    @NotBlank(message = "Especialidade é obrigatória")
    private String especialidade;

    @NotNull(message = "Paciente é obrigatório")
    private Long pacienteId;

    // Getters e setters
    public LocalDateTime getDataHora() { return dataHora; }
    public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }

    public String getEspecialidade() { return especialidade; }
    public void setEspecialidade(String especialidade) { this.especialidade = especialidade; }

    public Long getPacienteId() { return pacienteId; }
    public void setPacienteId(Long pacienteId) { this.pacienteId = pacienteId; }
}
