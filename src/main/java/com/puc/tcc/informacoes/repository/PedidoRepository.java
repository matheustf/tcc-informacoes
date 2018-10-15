package com.puc.tcc.informacoes.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.puc.tcc.informacoes.model.Pedido;

@Repository
public interface PedidoRepository extends ElasticsearchRepository<Pedido, String> {
	
	public List<Pedido> findByDataDoPedido(String data, Pageable pageable);
}