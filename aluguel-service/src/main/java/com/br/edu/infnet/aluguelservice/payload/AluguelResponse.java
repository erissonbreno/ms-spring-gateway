package com.br.edu.infnet.aluguelservice.payload;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class AluguelResponse {
    private List<String> veiculos;
    private BigDecimal valorDiaria;
}
