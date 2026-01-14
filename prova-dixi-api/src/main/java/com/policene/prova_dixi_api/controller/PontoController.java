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
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class PontoController {

    private final PontoService pontoService;

    public PontoController(PontoService pontoService) {
        this.pontoService = pontoService;
    }

    @PostMapping(value = "/baterPonto")
    public ResponseEntity<PontoResponseDTO> baterPonto (@RequestBody PontoRequestDTO ponto) {
        return new ResponseEntity<>(pontoService.baterPonto(ponto), HttpStatus.CREATED);
    }

}
