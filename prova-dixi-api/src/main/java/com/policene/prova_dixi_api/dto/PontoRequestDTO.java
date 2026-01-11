package com.policene.prova_dixi_api.model.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;

public record PontoRequestDTO(
        @NotNull
        Long idFuncionario,
        @Nullable
        Double latitude,
        @Nullable
        Double longitude
) {
}
