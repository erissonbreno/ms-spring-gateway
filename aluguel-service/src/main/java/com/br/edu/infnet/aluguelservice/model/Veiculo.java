package com.br.edu.infnet.aluguelservice.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Veiculo {
    private long id;
    private String nome;
    private String marca;
    private BigDecimal preco;
}
