package com.puc.tcc.informacoes.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.puc.tcc.informacoes.exceptions.ConsumerPedidoException;
import com.puc.tcc.informacoes.model.Pedido;
import com.puc.tcc.informacoes.service.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
	
	private PedidoService pedidoService;

	@Autowired
	public PedidoController(PedidoService pedidoService) {
		this.pedidoService = pedidoService;
	}

	@GetMapping()
	@RequestMapping("")
	public ResponseEntity<List<Pedido>> buscarTodos() {

		List<Pedido> listPedidos = pedidoService.buscarTodos();

		return new ResponseEntity<List<Pedido>>(listPedidos, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pedido> consultar(@PathVariable(value = "id") String idPedido) throws ConsumerPedidoException {

		Pedido pedido = pedidoService.consultar(idPedido);

		return new ResponseEntity<Pedido>(pedido, HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Pedido> incluir(@RequestBody @Valid Pedido pedido) throws ConsumerPedidoException {

		Pedido responsePedidoDTO = pedidoService.incluir(pedido);
		return new ResponseEntity<Pedido>(responsePedidoDTO, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Pedido> atualizar(@PathVariable(value = "id") String id, @RequestBody @Valid Pedido pedidoDetails) throws ConsumerPedidoException {

		Pedido pedido = pedidoService.atualizar(id, pedidoDetails);

		return new ResponseEntity<Pedido>(pedido, HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Pedido> deletar(@PathVariable(value = "id") String id) throws ConsumerPedidoException {

		ResponseEntity<Pedido> response = pedidoService.deletar(id);
		
		return response;
	}
	

}