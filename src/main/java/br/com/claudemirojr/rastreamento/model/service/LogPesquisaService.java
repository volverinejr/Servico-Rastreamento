package br.com.claudemirojr.rastreamento.model.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.data.domain.Page;
import org.springframework.scheduling.annotation.Async;

import br.com.claudemirojr.rastreamento.dto.LogPesquisaDto;
import br.com.claudemirojr.rastreamento.dto.LogPesquisaResponseDto;
import br.com.claudemirojr.rastreamento.model.ParamsRequestModel;

public interface LogPesquisaService {

	@Async("asyncExecutor")
	public CompletableFuture<LogPesquisaResponseDto> criar(LogPesquisaDto logPesquisaCriarDto);

	public Page<LogPesquisaResponseDto> findAll(ParamsRequestModel prm);

	public LogPesquisaResponseDto findById(String id);

}
