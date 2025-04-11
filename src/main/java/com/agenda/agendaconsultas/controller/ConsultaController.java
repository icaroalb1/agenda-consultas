package com.agenda.agendaconsultas.controller;

import com.agenda.agendaconsultas.dto.CriarConsultaDTO;
import com.agenda.agendaconsultas.dto.DetalhesConsultaDTO;
import com.agenda.agendaconsultas.service.ConsultaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @PostMapping
    public EntityModel<DetalhesConsultaDTO> agendar(@RequestBody @Valid CriarConsultaDTO dto) {
        DetalhesConsultaDTO consulta = consultaService.agendar(dto);

        return EntityModel.of(consulta,
                linkTo(methodOn(ConsultaController.class).listar()).withRel("todas"),
                linkTo(methodOn(ConsultaController.class).cancelarComMensagem(consulta.getId())).withRel("cancelar"));
    }

    @GetMapping
    public List<DetalhesConsultaDTO> listar() {
        return consultaService.listarTodas();
    }


    @PutMapping("/{id}/cancelar")
    public EntityModel<String> cancelarComMensagem(@PathVariable Long id) {
        consultaService.cancelar(id);
        return EntityModel.of("Consulta cancelada com sucesso.",
                linkTo(methodOn(ConsultaController.class).listar()).withRel("todas"));
    }
}
