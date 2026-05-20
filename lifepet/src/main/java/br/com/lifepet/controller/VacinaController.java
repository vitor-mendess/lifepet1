package br.com.lifepet.controller;

import br.com.lifepet.dto.VacinaDTO;
import br.com.lifepet.entity.Pet;
import br.com.lifepet.entity.Vacina;
import br.com.lifepet.service.PetService;
import br.com.lifepet.service.VacinaService;

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

import java.time.LocalDate;
import java.util.List;

@Tag(
        name = "Vacinas",
        description = "Gerenciamento de vacinas dos pets"
)
@RestController
@RequestMapping("/vacinas")
public class VacinaController {

    @Autowired
    private VacinaService service;

    @Autowired
    private PetService petService;

    // LISTAR COM PAGINAÇÃO
    @Operation(summary = "Listar vacinas com paginação")
    @GetMapping
    public Page<Vacina> listar(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "nome") String sort
    ) {

        Pageable pageable = PageRequest.of(
                page,
                size,
                Sort.by(sort)
        );

        return service.listar(pageable);
    }

    // VACINAS ATRASADAS
    @Operation(summary = "Listar vacinas atrasadas")
    @GetMapping("/atrasadas")
    public List<Vacina> vacinasAtrasadas() {

        Pageable pageable = PageRequest.of(0, 100);

        return service.listar(pageable)
                .stream()
                .filter(v -> v.getProximaDose() != null
                        && v.getProximaDose().isBefore(LocalDate.now()))
                .toList();
    }

    // BUSCAR POR ID
    @Operation(summary = "Buscar vacina por ID")
    @GetMapping("/{id}")
    public ResponseEntity<Vacina> buscarPorId(@PathVariable Long id) {

        return ResponseEntity.ok(
                service.buscarPorId(id)
        );
    }

    // BUSCAR POR NOME
    @Operation(summary = "Buscar vacina por nome")
    @GetMapping("/buscar")
    public List<Vacina> buscarPorNome(@RequestParam String nome) {

        return service.buscarPorNome(nome);
    }

    // CADASTRAR
    @Operation(summary = "Cadastrar nova vacina")
    @PostMapping
    public ResponseEntity<VacinaDTO> salvar(@Valid @RequestBody VacinaDTO dto) {

        Vacina vacina = new Vacina();

        vacina.setNome(dto.getNome());
        vacina.setDataAplicacao(dto.getDataAplicacao());
        vacina.setProximaDose(dto.getProximaDose());

        if (dto.getPetId() != null) {
            Pet pet = petService.buscarPorId(dto.getPetId());
            vacina.setPet(pet);
        }

        Vacina salva = service.salvar(vacina);

        VacinaDTO resposta = new VacinaDTO();

        resposta.setId(salva.getId());
        resposta.setNome(salva.getNome());
        resposta.setDataAplicacao(salva.getDataAplicacao());
        resposta.setProximaDose(salva.getProximaDose());

        if (salva.getPet() != null) {
            resposta.setPetId(salva.getPet().getId());
        }

        return ResponseEntity.ok(resposta);
    }

    // ATUALIZAR
    @Operation(summary = "Atualizar vacina")
    @PutMapping("/{id}")
    public ResponseEntity<Vacina> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody Vacina vacina
    ) {

        vacina.setId(id);

        return ResponseEntity.ok(
                service.salvar(vacina)
        );
    }

    // EXCLUIR
    @Operation(summary = "Excluir vacina")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {

        service.deletar(id);

        return ResponseEntity.noContent().build();
    }
}