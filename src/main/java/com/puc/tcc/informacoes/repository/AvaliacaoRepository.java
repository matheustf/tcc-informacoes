package com.puc.tcc.informacoes.repository;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.puc.tcc.informacoes.model.Avaliacao;

@Repository
public interface AvaliacaoRepository extends ElasticsearchRepository<Avaliacao, String> {
	
	List<Avaliacao> findByDataDaAvaliacao(String data, Pageable pageable);

}