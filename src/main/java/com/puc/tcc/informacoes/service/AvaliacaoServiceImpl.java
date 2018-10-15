package com.puc.tcc.informacoes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.puc.tcc.informacoes.consts.Constants;
import com.puc.tcc.informacoes.exceptions.ConsumerAvaliacaoException;
import com.puc.tcc.informacoes.model.Avaliacao;
import com.puc.tcc.informacoes.repository.AvaliacaoRepository;

@Service
public class AvaliacaoServiceImpl implements AvaliacaoService {

	AvaliacaoRepository avaliacaoRepository;

	@Autowired
	public AvaliacaoServiceImpl(AvaliacaoRepository avaliacaoRepository) {
		this.avaliacaoRepository = avaliacaoRepository;
	}

	@Override
	public Avaliacao consultar(String id) throws ConsumerAvaliacaoException {

		Optional<Avaliacao> optional = avaliacaoRepository.findById(id);
		Avaliacao avaliacao = validarAvaliacao(optional);

		return avaliacao;
	}

	@Override
	public List<Avaliacao> buscarTodos() {

		List<Avaliacao> avaliacoes = (List<Avaliacao>) avaliacaoRepository.findAll();

		return avaliacoes;
	}

	@Override
	public Avaliacao incluir(Avaliacao avaliacao) {

		avaliacaoRepository.save(avaliacao);

		return avaliacao;
	}

	@Override
	public Avaliacao atualizar(String id, Avaliacao avaliacaoDetails) throws ConsumerAvaliacaoException {

		Optional<Avaliacao> optional = avaliacaoRepository.findById(id);
		Avaliacao avaliacao = validarAvaliacao(optional);

		avaliacaoRepository.save(avaliacao);

		return avaliacao;
	}

	@Override
	public ResponseEntity<Avaliacao> deletar(String id) throws ConsumerAvaliacaoException {

		Optional<Avaliacao> optional = avaliacaoRepository.findById(id);
		validarAvaliacao(optional);

		avaliacaoRepository.deleteById(id);

		return ResponseEntity.noContent().build();
	}

	private Avaliacao validarAvaliacao(Optional<Avaliacao> optional) throws ConsumerAvaliacaoException {
		return Optional.ofNullable(optional).get()
				.orElseThrow(() -> new ConsumerAvaliacaoException(HttpStatus.NOT_FOUND, Constants.ITEM_NOT_FOUND));
	}

	@Override
	public List<Avaliacao> buscarPorData(String data) {
		return avaliacaoRepository.findByDataDaAvaliacao(data, PageRequest.of(0,500));
	}
}
