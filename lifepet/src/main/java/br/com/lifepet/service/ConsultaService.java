package br.com.lifepet.service;

import br.com.lifepet.entity.Consulta;
import br.com.lifepet.exception.ResourceNotFoundException;
import br.com.lifepet.repository.ConsultaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository repository;

    // LISTAR COM PAGINAÇÃO
    public Page<Consulta> listar(Pageable pageable) {
        return repository.findAll(pageable);
    }

    // BUSCAR POR ID
    public Consulta buscarPorId(Long id) {

        return repository.findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException(
                                "Consulta com ID " + id + " não encontrada"
                        )
                );
    }

    // SALVAR
    public Consulta salvar(Consulta consulta) {
        return repository.save(consulta);
    }

    // DELETAR
    public void deletar(Long id) {

        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException(
                    "Consulta com ID " + id + " não encontrada"
            );
        }

        repository.deleteById(id);
    }
}
