package br.com.lifepet.service;

import br.com.lifepet.entity.Medicamento;
import br.com.lifepet.exception.ResourceNotFoundException;
import br.com.lifepet.repository.MedicamentoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MedicamentoService {

    @Autowired
    private MedicamentoRepository repository;

    // LISTAR COM PAGINAÇÃO
    public Page<Medicamento> listar(Pageable pageable) {
        return repository.findAll(pageable);
    }

    // BUSCAR POR ID
    public Medicamento buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Medicamento não encontrado com ID: " + id
                        )
                );
    }

    // SALVAR
    public Medicamento salvar(Medicamento medicamento) {
        return repository.save(medicamento);
    }

    // DELETAR
    public void deletar(Long id) {

        Medicamento medicamento = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Medicamento não encontrado com ID: " + id
                        )
                );

        repository.delete(medicamento);
    }
}