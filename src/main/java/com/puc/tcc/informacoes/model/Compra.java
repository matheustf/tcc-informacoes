package com.puc.tcc.informacoes.model;

import java.io.Serializable;
import java.math.BigDecimal;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Compra implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	
	private String codigoDoProduto;
	
	private BigDecimal valorDaCompra;
	
	private int quantidade;
	
	public Compra converterElastic( Compra compra) {
		Compra elasticCompra = new Compra();
		elasticCompra.setCodigoDoProduto(compra.getCodigoDoProduto());
		elasticCompra.setValorDaCompra(compra.getValorDaCompra());
		elasticCompra.setQuantidade(compra.getQuantidade());
		
		return elasticCompra;
	}
	

}
