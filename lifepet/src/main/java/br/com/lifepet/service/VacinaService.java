package br.com.lifepet.service;

import br.com.lifepet.entity.Vacina;
import br.com.lifepet.exception.ResourceNotFoundException;
import br.com.lifepet.repository.VacinaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VacinaService {

    @Autowired
    private VacinaRepository repository;

    // LISTAR COM PAGINAÇÃO
    public Page<Vacina> listar(Pageable pageable) {
        return repository.findAll(pageable);
    }

    // BUSCAR POR ID
    public Vacina buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Vacina não encontrada com ID: " + id
                        )
                );
    }

    // SALVAR
    public Vacina salvar(Vacina vacina) {
        return repository.save(vacina);
    }

    // DELETAR (com validação)
    public void deletar(Long id) {

        Vacina vacina = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Vacina não encontrada com ID: " + id
                        )
                );

        repository.delete(vacina);
    }

    // BUSCAR POR NOME
    public List<Vacina> buscarPorNome(String nome) {
        return repository.findByNomeContainingIgnoreCase(nome);
    }
}