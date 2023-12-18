package com.br.edu.infnet.aluguelservice.service;

import com.br.edu.infnet.aluguelservice.model.Veiculo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "veiculo-service", url = "http://localhost:9090/api/veiculo")
public interface VeiculoApiService {
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    Veiculo getById(@PathVariable Long id);
}
