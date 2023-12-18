package com.br.edu.infnet.microservices.veiculoservice.service.impl;

import com.br.edu.infnet.microservices.veiculoservice.exception.VeiculoNotFoundException;
import com.br.edu.infnet.microservices.veiculoservice.model.Veiculo;
import com.br.edu.infnet.microservices.veiculoservice.repository.VeiculoRepository;
import com.br.edu.infnet.microservices.veiculoservice.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoServiceImpl implements VeiculoService {
    @Autowired
    VeiculoRepository repository;

    @Override
    public List<Veiculo> getAll() {
        return repository.findAll();
    }

    @Override
    public Veiculo create(Veiculo veiculo) {
        return repository.save(veiculo);
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }

    @Override
    public Veiculo update(long id, Veiculo veiculo) {
        veiculo.setId(id);
        return create(veiculo);
    }

    @Override
    public Veiculo getById(long id) {
        return repository.findById(id).orElseThrow(VeiculoNotFoundException::new);
    }
}
