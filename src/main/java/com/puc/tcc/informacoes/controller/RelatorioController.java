package com.puc.tcc.informacoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.puc.tcc.informacoes.model.Avaliacao;
import com.puc.tcc.informacoes.model.Entrega;
import com.puc.tcc.informacoes.model.Pedido;
import com.puc.tcc.informacoes.service.AvaliacaoService;
import com.puc.tcc.informacoes.service.EntregaService;
import com.puc.tcc.informacoes.service.PedidoService;
import com.puc.tcc.informacoes.utils.Util;

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

	@GetMapping("/avaliacoes/{data}")
	public ResponseEntity<List<Avaliacao>> buscarAvaliacoes(@PathVariable(value = "data") String data) {
		
		data = Util.formatarData(data);
		
		List<Avaliacao> listAvaliacoes = avaliacaoService.buscarPorData(data);

		return new ResponseEntity<List<Avaliacao>>(listAvaliacoes, HttpStatus.OK);
	}
	
	@GetMapping("/pedidos/{data}")
	public ResponseEntity<List<Pedido>> buscarPedidos(@PathVariable(value = "data") String data) {
		
		data = Util.formatarData(data);
		
		List<Pedido> listPedidos = pedidoService.buscarPorData(data);

		return new ResponseEntity<List<Pedido>>(listPedidos, HttpStatus.OK);
	}
	
	@GetMapping("/entregas/{data}")
	public ResponseEntity<List<Entrega>> buscarEntregas(@PathVariable(value = "data") String data) {
		
		data = Util.formatarData(data);
		
		List<Entrega> listEntregas = entregaService.buscarPorData(data);

		return new ResponseEntity<List<Entrega>>(listEntregas, HttpStatus.OK);
	}
	
}