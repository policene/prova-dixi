package com.policene.prova_dixi_api_imagens.service;

import com.policene.prova_dixi_api_imagens.dto.ImagemRequestDTO;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.UUID;

@Service
public class ImagemService {

    public String salvarImagem (String foto) {
        try {
            String extensao = foto.split(";")[0].split("/")[1];
            String uuid = String.valueOf(UUID.randomUUID());
            String nomeArquivo = uuid + "." + extensao;
            byte[] bytesFoto = Base64.getDecoder().decode(foto.split(",")[1]);

            Path path = Paths.get(System.getProperty("user.dir"), "imagens");

            File file = new File(path + "/" + nomeArquivo);
            FileOutputStream in = new FileOutputStream(file);
            in.write(bytesFoto);
            in.close();

            return nomeArquivo;

        } catch (IOException e) {
            return null;
        }
    }

}
