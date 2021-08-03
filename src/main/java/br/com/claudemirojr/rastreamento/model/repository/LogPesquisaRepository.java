package br.com.claudemirojr.rastreamento.model.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.claudemirojr.rastreamento.model.entity.LogPesquisa;

public interface LogPesquisaRepository extends MongoRepository<LogPesquisa, String> {
}
