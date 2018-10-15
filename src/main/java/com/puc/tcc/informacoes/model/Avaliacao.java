package com.puc.tcc.informacoes.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "avaliacao-store", type = "avaliacao", shards = 1, replicas = 1)
public class Avaliacao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3588012881987809662L;

	@Id
	private String id;
	
	private String codigoDaAvaliacao;

	private String idCliente;
	
	private String idPedido;
	
	private int notaDeSatisfacao;
	
	private String titulo;

	private String descricao;
	
	private String dataDaAvaliacao;
	
	public Avaliacao update(Avaliacao avaliacao, Avaliacao detailsAvaliacao) {
		avaliacao.setTitulo(detailsAvaliacao.getTitulo());
		avaliacao.setNotaDeSatisfacao(avaliacao.getNotaDeSatisfacao());
		avaliacao.setTitulo(detailsAvaliacao.getDescricao());
		avaliacao.setDataDaAvaliacao(detailsAvaliacao.getDataDaAvaliacao());
		
		return avaliacao;
	}
	
}
