package com.policene.prova_dixi_api.repository;

import com.policene.prova_dixi_api.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository <Funcionario, Long> { }
