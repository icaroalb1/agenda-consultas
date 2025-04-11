package com.agenda.agendaconsultas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Future(message = "A data da consulta deve estar no futuro")
    private LocalDateTime dataHora;

    @NotBlank(message = "Especialidade é obrigatória")
    private String especialidade;

    @Enumerated(EnumType.STRING)
    private StatusConsulta status;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;
}
