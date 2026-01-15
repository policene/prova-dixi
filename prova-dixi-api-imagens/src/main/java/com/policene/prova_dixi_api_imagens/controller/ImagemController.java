package com.policene.prova_dixi_api_imagens.controller;

import com.policene.prova_dixi_api_imagens.dto.ImagemRequestDTO;
import com.policene.prova_dixi_api_imagens.service.ImagemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/imagens")
@CrossOrigin(origins = "http://localhost:8080", allowCredentials = "true")
public class ImagemController {

    private final ImagemService imagemService;

    public ImagemController(ImagemService imagemService) {
        this.imagemService = imagemService;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFoto (@RequestBody ImagemRequestDTO request) {
        return new ResponseEntity<>(imagemService.salvarImagem(request.foto()), HttpStatus.CREATED);
    }
}


