package com.puc.tcc.informacoes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.puc.tcc.informacoes.consts.Constants;
import com.puc.tcc.informacoes.exceptions.ConsumerPedidoException;
import com.puc.tcc.informacoes.model.Pedido;
import com.puc.tcc.informacoes.repository.PedidoRepository;

@Service
public class PedidoServiceImpl implements PedidoService {

	PedidoRepository pedidoRepository;
	
	@Autowired
	public PedidoServiceImpl(PedidoRepository pedidoRepository) {
		this.pedidoRepository = pedidoRepository;
	}

	@Override
	public Pedido consultar(String id) throws ConsumerPedidoException {
		
		Optional<Pedido> optional = pedidoRepository.findById(id);
		Pedido pedido = validarPedido(optional);
		
		return pedido;
	}

	@Override
	public List<Pedido> buscarTodos() {

		List<Pedido> pedidos = (List<Pedido>) pedidoRepository.findAll();

		return pedidos;
	}

	@Override
	public Pedido incluir(Pedido pedido) {
		
		pedidoRepository.save(pedido);
		
		return pedido;
	}

	@Override
	public Pedido atualizar(String id, Pedido pedidoDetails) throws ConsumerPedidoException {
		
		Optional<Pedido> optional = pedidoRepository.findById(id);
		Pedido pedido = validarPedido(optional);
		
		pedidoRepository.save(pedido);

		return pedido;
	}

	@Override
	public ResponseEntity<Pedido> deletar(String id) throws ConsumerPedidoException {
		
		Optional<Pedido> optional = pedidoRepository.findById(id);
		validarPedido(optional);
		
		pedidoRepository.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}

	private Pedido validarPedido(Optional<Pedido> optional) throws ConsumerPedidoException {
		return Optional.ofNullable(optional).get()
		.orElseThrow(() -> new ConsumerPedidoException(HttpStatus.NOT_FOUND, Constants.ITEM_NOT_FOUND));
	}
	
	@Override
	public Pedido gerarRelatorio(String id) throws ConsumerPedidoException {
		
		Optional<Pedido> optional = pedidoRepository.findById(id);
		Pedido pedido = validarPedido(optional);
		
		return pedido;
	}
	
	@Override
	public List<Pedido> buscarPorData(String data) {
		return pedidoRepository.findByDataDoPedido(data, PageRequest.of(0,500));
	}
}
