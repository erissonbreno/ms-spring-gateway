package com.br.edu.infnet.microservices.veiculoservice.repository;

import com.br.edu.infnet.microservices.veiculoservice.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
}