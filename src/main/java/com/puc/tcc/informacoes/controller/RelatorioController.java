package com.puc.tcc.informacoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.puc.tcc.informacoes.model.Avaliacao;
import com.puc.tcc.informacoes.model.Entrega;
import com.puc.tcc.informacoes.model.Pedido;
import com.puc.tcc.informacoes.service.AvaliacaoService;
import com.puc.tcc.informacoes.service.EntregaService;
import com.puc.tcc.informacoes.service.PedidoService;

@RestController
@RequestMapping("/relatorio")
public class RelatorioController {
	
	private AvaliacaoService avaliacaoService;
	
	private PedidoService pedidoService;
	
	private EntregaService entregaService;

	@Autowired
	public RelatorioController(AvaliacaoService avaliacaoService, PedidoService pedidoService, EntregaService entregaService) {
		this.avaliacaoService = avaliacaoService;
		this.pedidoService = pedidoService;
		this.entregaService = entregaService;
	}

	@PostMapping("/avaliacao")
	public ResponseEntity<List<Avaliacao>> buscarAvaliacoes(@RequestBody String data) {
		
		List<Avaliacao> listAvaliacoes = avaliacaoService.buscarPorData(data);

		return new ResponseEntity<List<Avaliacao>>(listAvaliacoes, HttpStatus.OK);
	}
	
	@PostMapping("/pedido")
	public ResponseEntity<List<Pedido>> buscarPedidos(@RequestBody String data) {
		
		List<Pedido> listPedidos = pedidoService.buscarPorData(data);

		return new ResponseEntity<List<Pedido>>(listPedidos, HttpStatus.OK);
	}
	
	@PostMapping("/entrega")
	public ResponseEntity<List<Entrega>> buscarEntregas(@RequestBody String data) {
		
		List<Entrega> listEntregas = entregaService.buscarPorData(data);

		return new ResponseEntity<List<Entrega>>(listEntregas, HttpStatus.OK);
	}
	
}