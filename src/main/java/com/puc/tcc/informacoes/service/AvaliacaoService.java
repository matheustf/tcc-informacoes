package com.puc.tcc.informacoes.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.puc.tcc.informacoes.exceptions.ConsumerAvaliacaoException;
import com.puc.tcc.informacoes.model.Avaliacao;

public interface AvaliacaoService {

	Avaliacao consultar(String id) throws ConsumerAvaliacaoException;

	List<Avaliacao> buscarTodos();

	Avaliacao incluir(Avaliacao avaliacao);

	Avaliacao atualizar(String id, Avaliacao avaliacaoDetails) throws ConsumerAvaliacaoException;

	ResponseEntity<Avaliacao> deletar(String id) throws ConsumerAvaliacaoException;

	List<Avaliacao> buscarPorData(String data);
	

}
