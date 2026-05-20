package br.com.lifepet.controller;

import br.com.lifepet.dto.ConsultaDTO;
import br.com.lifepet.entity.Consulta;
import br.com.lifepet.entity.Pet;
import br.com.lifepet.service.ConsultaService;
import br.com.lifepet.service.PetService;

import jakarta.validation.Valid;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "Consultas",
        description = "Gerenciamento de consultas veterinárias"
)

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService service;

    @Autowired
    private PetService petService;


    // LISTAR COM PAGINAÇÃO
    @Operation(summary = "Listar consultas com paginação")
    @GetMapping
    public Page<Consulta> listar(

            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "data") String sort
    ) {

        Pageable pageable = PageRequest.of(
                page,
                size,
                Sort.by(sort)
        );

        return service.listar(pageable);
    }


    // BUSCAR POR ID
    @Operation(summary = "Buscar consulta por ID")
    @GetMapping("/{id}")
    public ResponseEntity<Consulta> buscarPorId(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                service.buscarPorId(id)
        );
    }


    // CADASTRAR
    @Operation(summary = "Cadastrar nova consulta")
    @PostMapping
    public ResponseEntity<ConsultaDTO> salvar(
            @Valid @RequestBody ConsultaDTO dto) {

        Consulta consulta = new Consulta();

        consulta.setData(dto.getData());
        consulta.setVeterinario(dto.getVeterinario());
        consulta.setObservacoes(dto.getObservacoes());

        Pet pet = petService.buscarPorId(dto.getPetId());

        consulta.setPet(pet);

        Consulta salva = service.salvar(consulta);

        ConsultaDTO resposta = new ConsultaDTO();

        resposta.setId(salva.getId());
        resposta.setData(salva.getData());
        resposta.setVeterinario(salva.getVeterinario());
        resposta.setObservacoes(salva.getObservacoes());
        resposta.setPetId(salva.getPet().getId());

        return ResponseEntity.ok(resposta);
    }


    // DELETAR
    @Operation(summary = "Excluir consulta")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(
            @PathVariable Long id) {

        service.deletar(id);

        return ResponseEntity.noContent().build();
    }
}