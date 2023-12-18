package com.br.edu.infnet.microservices.veiculoservice.controller;

import com.br.edu.infnet.microservices.veiculoservice.exception.VeiculoNotFoundException;
import com.br.edu.infnet.microservices.veiculoservice.model.Veiculo;
import com.br.edu.infnet.microservices.veiculoservice.payload.ResponsePayload;
import com.br.edu.infnet.microservices.veiculoservice.service.VeiculoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping()
@Tag(name = "veiculo-api")
@CrossOrigin
public class VeiculoController {

    @Autowired
    VeiculoService veiculoService;

    Logger LOGGER = LoggerFactory.getLogger(VeiculoController.class);
    @GetMapping("/list")
    public ResponseEntity getAll(){
        List<Veiculo> all = veiculoService.getAll();
        LOGGER.info("GET ALL" + all);
        return ResponseEntity.ok().body(all);

    }

    @PostMapping()
    public ResponseEntity<Veiculo> create(@RequestBody Veiculo veiculo) {
        Veiculo veiculoCreated = veiculoService.create(veiculo);
        LOGGER.info("CREATE: " + veiculo);
        return ResponseEntity.status(HttpStatus.CREATED).body(veiculoCreated);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        veiculoService.deleteById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable long id, @RequestBody Veiculo veiculo) {
        veiculoService.update(id, veiculo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable long id) {
        try {
        Veiculo veiculo = veiculoService.getById(id);
        LOGGER.info("GET BY ID: " + veiculo);
        return ResponseEntity.ok(veiculo);

        } catch (VeiculoNotFoundException ex) {
            ResponsePayload notFound = ResponsePayload.builder().message("Not Found").timeStamp(LocalDateTime.now()).build();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(notFound);
        }
    }
}
