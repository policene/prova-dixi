package com.policene.prova_dixi_api_imagens.exceptions;

import java.time.LocalDateTime;

public record ErrorResponse (
        LocalDateTime timestamp,
        int status,
        String error
) {
}
