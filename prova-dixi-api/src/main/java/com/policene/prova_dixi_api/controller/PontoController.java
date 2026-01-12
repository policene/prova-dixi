package com.policene.prova_dixi_api.controller;

import com.policene.prova_dixi_api.dto.PontoRequestDTO;
import com.policene.prova_dixi_api.dto.PontoResponseDTO;
import com.policene.prova_dixi_api.service.PontoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/ponto")
public class PontoController {

    private final PontoService pontoService;

    public PontoController(PontoService pontoService) {
        this.pontoService = pontoService;
    }

    @PostMapping(value = "/baterPonto", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<PontoResponseDTO> baterPonto (
            @RequestPart("ponto") PontoRequestDTO ponto,
            @RequestPart(value = "foto", required = false) MultipartFile foto ) {
        return new ResponseEntity<>(pontoService.baterPonto(ponto, foto), HttpStatus.CREATED);
    }

}
