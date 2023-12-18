package com.br.edu.infnet.microservices.veiculoservice;

import info.schnatterer.mobynamesgenerator.MobyNamesGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class VeiculoArquiteturaMicroservicosApplicationTests {

	@Test
	void contextLoads() {
		System.out.println(MobyNamesGenerator.getRandomName());
	}

}
