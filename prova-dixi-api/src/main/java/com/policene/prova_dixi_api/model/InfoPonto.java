package com.policene.prova_dixi_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "info_pontos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InfoPonto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Ponto ponto;

    @NotNull
    private Funcionario funcionario;

    @NotNull
    private boolean considerada;

    private String motivo;

    @NotNull
    private boolean temFoto;

    @NotNull
    private boolean possuiLocalizacao;

}
