package com.br.edu.infnet.microservices.veiculoservice.service;

import com.br.edu.infnet.microservices.veiculoservice.model.Veiculo;

import java.util.List;

public interface VeiculoService {
    List<Veiculo> getAll();

    Veiculo create(Veiculo veiculo);

    void deleteById(long id);

    Veiculo update(long id, Veiculo veiculo);

    Veiculo getById(long id);
}
