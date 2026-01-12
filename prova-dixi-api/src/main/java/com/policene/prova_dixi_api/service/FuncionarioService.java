package com.policene.prova_dixi_api.service;

import com.policene.prova_dixi_api.model.Funcionario;
import com.policene.prova_dixi_api.repository.FuncionarioRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    @Cacheable(value = "funcionarios", key = "#id")
    public Funcionario findById (Long id) {
        return funcionarioRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Funcionário não encontrado com o ID " + id + "."));
    }
}
