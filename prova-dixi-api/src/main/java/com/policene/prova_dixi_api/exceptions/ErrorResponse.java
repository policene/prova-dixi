package com.policene.prova_dixi_api.exceptions;

import java.time.LocalDateTime;

public record ErrorResponse (
    LocalDateTime timestamp,
    int status,
    String error,
    String path
) {
}
