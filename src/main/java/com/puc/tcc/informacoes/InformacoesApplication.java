package com.puc.tcc.informacoes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class InformacoesApplication {

	public static void main(String[] args) {
		SpringApplication.run(InformacoesApplication.class, args);
	}
}
