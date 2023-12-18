package com.br.edu.infnet.aluguelservice.payload;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class AluguelPayload {
    private List<Long> veiculos;
    private int qtdDias;
}
