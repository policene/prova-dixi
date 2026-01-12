package com.policene.prova_dixi_api.service;

import com.policene.prova_dixi_api.model.Funcionario;
import com.policene.prova_dixi_api.model.InfoPonto;
import com.policene.prova_dixi_api.model.Ponto;
import com.policene.prova_dixi_api.dto.PontoRequestDTO;
import com.policene.prova_dixi_api.dto.PontoResponseDTO;
import com.policene.prova_dixi_api.repository.FuncionarioRepository;
import com.policene.prova_dixi_api.repository.InfoPontoRepository;
import com.policene.prova_dixi_api.repository.PontoRepository;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

@Service
public class PontoService {

    private final RedisTemplate<String, Object> redis;

    private final PontoRepository pontoRepository;
    private final InfoPontoRepository infoPontoRepository;

    private final FuncionarioService funcionarioService;
    private final FotoService fotoService;

    public PontoService(PontoRepository pontoRepository, InfoPontoRepository infoPontoRepository, FotoService fotoService, RedisTemplate<String, Object> redis, FuncionarioService funcionarioService) {
        this.pontoRepository = pontoRepository;
        this.infoPontoRepository = infoPontoRepository;
        this.funcionarioService = funcionarioService;
        this.fotoService = fotoService;
        this.redis = redis;
    }

    public String obterChave (Long idFuncionario) {
        // Geramos uma chave única para ser verificada ou cadastrada no Redis.
        LocalDateTime data = LocalDateTime.now();
        String dia = String.valueOf(data.getDayOfYear());
        String horario = String.valueOf((data.getHour() * 60) + data.getMinute());
        return (idFuncionario.toString() + ":" + dia + ":" + horario);
    }

    public boolean verificarProximidade (String chave) {
        // Verifica se há alguma batida de um funcionário no mesmo minuto
        if (redis.hasKey(chave)) {
            return true;
        } else {
            redis.opsForValue().set(chave, "", 60, TimeUnit.SECONDS);
            return false;
        }
    }

    public PontoResponseDTO baterPonto (PontoRequestDTO request, MultipartFile file) {

        String chave = obterChave(request.idFuncionario());

        Funcionario funcionario = funcionarioService.findById(request.idFuncionario());

        boolean considerada = true;
        String motivo = "";

        if (verificarProximidade(chave)) {
            considerada = false;
            motivo = "Marcação desconsiderada por proximidade.";
        }

        boolean possuiFoto = (!file.isEmpty());
        String urlFoto = "";

        boolean possuiLocalizacao = (request.longitude() != null && request.latitude() != null);


        if (possuiFoto) {
            urlFoto = salvarFoto(file);
        }

        // TODO - Lógica de validação do ponto...
        Ponto ponto = new Ponto();
        ponto.setData(LocalDate.now());
        ponto.setHora(LocalTime.now());
        Ponto pontoSalvo = pontoRepository.save(ponto);

        InfoPonto infoPonto = new InfoPonto();
        infoPonto.setPonto(pontoSalvo);
        infoPonto.setFuncionario(funcionario);
        infoPonto.setConsiderada(considerada);
        infoPonto.setMotivo(motivo);
        infoPonto.setPossuiFoto(possuiFoto);
        infoPonto.setUrlFoto(urlFoto);
        infoPonto.setPossuiLocalizacao(possuiLocalizacao);

        infoPontoRepository.save(infoPonto);

        return new PontoResponseDTO(
                ponto.getData(),
                ponto.getHora(),
                infoPonto.isConsiderada(),
                infoPonto.getMotivo()
        );
    }

    public String salvarFoto (MultipartFile file) {
        return fotoService.salvarFoto(file);
    }

}
