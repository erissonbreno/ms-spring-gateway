package com.br.edu.infnet.aluguelservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AluguelServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AluguelServiceApplication.class, args);
	}

}
