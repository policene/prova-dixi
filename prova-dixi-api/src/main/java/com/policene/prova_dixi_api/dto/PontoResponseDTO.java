package com.policene.prova_dixi_api.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public record PontoResponseDTO(

        @NotNull
        LocalDate data,
        @NotNull
        LocalTime hora,
        @NotNull
        Boolean considerada,
        @Nullable
        String motivo
) {
}
