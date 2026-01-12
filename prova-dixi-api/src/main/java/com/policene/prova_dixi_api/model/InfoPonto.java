package com.policene.prova_dixi_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

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
    @OneToOne
    private Ponto ponto;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;

    @NotNull
    private boolean considerada;

    private String motivo;

    @NotNull
    private boolean possuiFoto;

    private String urlFoto;

    @NotNull
    private boolean possuiLocalizacao;

    private BigDecimal latitude;

    private BigDecimal longitude;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Ponto getPonto() {
        return ponto;
    }

    public void setPonto(Ponto ponto) {
        this.ponto = ponto;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public boolean isConsiderada() {
        return considerada;
    }

    public void setConsiderada(boolean considerada) {
        this.considerada = considerada;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public boolean isPossuiFoto() {
        return possuiFoto;
    }

    public void setPossuiFoto(boolean possuiFoto) {
        this.possuiFoto = possuiFoto;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public boolean isPossuiLocalizacao() {
        return possuiLocalizacao;
    }

    public void setPossuiLocalizacao(boolean possuiLocalizacao) {
        this.possuiLocalizacao = possuiLocalizacao;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }
}
