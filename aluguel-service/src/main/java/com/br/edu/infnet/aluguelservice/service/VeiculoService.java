package com.br.edu.infnet.aluguelservice.service;

import com.br.edu.infnet.aluguelservice.model.Veiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoService {

    @Autowired
    VeiculoApiService veiculoApiService;

    public List<Veiculo> getAllVeiculos(List<Long> ids) {
        return ids.stream().map(id -> veiculoApiService.getById(id)).toList();
    }
}
