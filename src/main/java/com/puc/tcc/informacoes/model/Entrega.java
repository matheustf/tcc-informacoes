package com.puc.tcc.informacoes.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import com.puc.tcc.informacoes.enums.StatusDaEntrega;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "entrega-store", type = "entrega", shards = 1, replicas = 1)
public class Entrega implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2043008054923050692L;

	@Id
	private String id;
	
	private String codigoDaEntrega;

	private String idCliente;
	
	private String idFornecedor;
	
	private String idPedido;
	
	private String estimativaDeEntrega;
	
	private StatusDaEntrega statusDaEntrega;
	
	private List<HistoricoDeEntrega> historicoDeEntrega;
	
	public Entrega update(Entrega entregaDoPedido, Entrega detailsEntregaDoPedido) {
		entregaDoPedido.setEstimativaDeEntrega(detailsEntregaDoPedido.getEstimativaDeEntrega());
		
		return entregaDoPedido;
	}
	
}