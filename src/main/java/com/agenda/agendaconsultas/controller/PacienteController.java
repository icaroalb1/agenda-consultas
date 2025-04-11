package com.agenda.agendaconsultas.controller;

import com.agenda.agendaconsultas.dto.CriarPacienteDTO;
import com.agenda.agendaconsultas.dto.DetalhesPacienteDTO;
import com.agenda.agendaconsultas.service.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public EntityModel<DetalhesPacienteDTO> cadastrar(@RequestBody @Valid CriarPacienteDTO dto) {
        DetalhesPacienteDTO paciente = pacienteService.cadastrar(dto);

        return EntityModel.of(paciente,
                linkTo(methodOn(PacienteController.class).buscarPorId(paciente.getId())).withSelfRel(),
                linkTo(methodOn(PacienteController.class).listar()).withRel("todos"));
    }

    @GetMapping
    public List<DetalhesPacienteDTO> listar() {
        return pacienteService.listarTodos();
    }

    @GetMapping("/{id}")
    public EntityModel<DetalhesPacienteDTO> buscarPorId(@PathVariable Long id) {
        DetalhesPacienteDTO paciente = pacienteService.buscarPorId(id);

        return EntityModel.of(paciente,
                linkTo(methodOn(PacienteController.class).buscarPorId(id)).withSelfRel(),
                linkTo(methodOn(PacienteController.class).listar()).withRel("todos"));
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        pacienteService.deletar(id);
    }
}
