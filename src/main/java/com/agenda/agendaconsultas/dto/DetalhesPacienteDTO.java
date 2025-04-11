package com.agenda.agendaconsultas.dto;

public class DetalhesPacienteDTO {

    private Long id;
    private String nome;
    private String telefone;
    private String email;
    private String cpf;

    public DetalhesPacienteDTO(Long id, String nome, String telefone, String email, String cpf) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
    }

    // Getters
    public Long getId() { return id; }
    public String getNome() { return nome; }
    public String getTelefone() { return telefone; }
    public String getEmail() { return email; }
    public String getCpf() { return cpf; }
}
