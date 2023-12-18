package com.br.edu.infnet.microservices.veiculoservice;

import com.br.edu.infnet.microservices.veiculoservice.model.Veiculo;
import com.br.edu.infnet.microservices.veiculoservice.repository.VeiculoRepository;
import com.br.edu.infnet.microservices.veiculoservice.service.VeiculoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@ActiveProfiles(value = "test")
public class ProdutoServiceTest {

    @Autowired
    VeiculoRepository repository;
    @Autowired
    VeiculoService veiculo;

    Logger LOGGER = LoggerFactory.getLogger(ProdutoServiceTest.class);

    @BeforeEach
    public void setUp() {
        List<Veiculo> listVeiculos = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            listVeiculos.add(Veiculo.builder().marca("Marca" + i).preco(new BigDecimal((i+1) * 5460)).build());
        }
        repository.saveAll(listVeiculos);
        LOGGER.info("Before Each");
    }
    @Test
    public void testGetAll() {
        List<Veiculo> all = veiculo.getAll();
        Assertions.assertEquals(100, all.size());
    }
}
