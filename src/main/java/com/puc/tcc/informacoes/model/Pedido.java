package com.puc.tcc.informacoes.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import com.puc.tcc.informacoes.enums.FormaDePagamento;
import com.puc.tcc.informacoes.enums.StatusDoPedido;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "pedido-store", type = "pedido", shards = 1, replicas = 1)
public class Pedido implements Serializable{



	/**
	 * 
	 */
	private static final long serialVersionUID = -911442392543637915L;

	@Id
	private String idPedido;
	
	private String codigoDoPedido;
	
	private String nomeDoCliente;
	
	private StatusDoPedido statusDoPedido;
	
	private FormaDePagamento formaDePagamento;
	
	private BigDecimal valorDoPedido;
	
	private String dataDoPedido;

	private int diasUteisParaEntrega;
	
	private List<Compra> compras;
	
}
