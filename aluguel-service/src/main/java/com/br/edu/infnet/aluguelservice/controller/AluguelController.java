package com.br.edu.infnet.aluguelservice.controller;

import com.br.edu.infnet.aluguelservice.model.Veiculo;
import com.br.edu.infnet.aluguelservice.payload.AluguelPayload;
import com.br.edu.infnet.aluguelservice.payload.AluguelResponse;
import com.br.edu.infnet.aluguelservice.service.VeiculoService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/")
@CrossOrigin
@OpenAPIDefinition
public class AluguelController {

    @Autowired
    VeiculoService veiculoService;

    @PostMapping
    public AluguelResponse realizaAluguel(@RequestBody AluguelPayload aluguelPayload) {
        List<Veiculo> allVeiculos = veiculoService.getAllVeiculos(aluguelPayload.getVeiculos());
        return AluguelResponse.builder()
                .veiculos(allVeiculos.stream().map(Veiculo::getNome).collect(Collectors.toList()))
                .valorDiaria(calculaValorAluguel(aluguelPayload.getQtdDias(), allVeiculos))
                .build();
    }

    private BigDecimal calculaValorAluguel(int qtdDias, List<Veiculo> veiculos) {
        BigDecimal somaValor = veiculos.stream()
                .map(Veiculo::getPreco)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return somaValor
                .multiply(new BigDecimal(qtdDias * 0.001))
                .setScale(2, BigDecimal.ROUND_HALF_UP);

    }
}
