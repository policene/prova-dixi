package com.policene.prova_dixi_api.model.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record PontoResponseDTO(

        @NotNull
        LocalDate data,
        @NotNull
        LocalDateTime hora,
        @NotNull
        Boolean considerada,
        @Nullable
        String motivo
) {
}
