package br.com.claudemirojr.rastreamento.model.service;

import org.springframework.data.domain.Page;

import br.com.claudemirojr.rastreamento.dto.LogPesquisaDto;
import br.com.claudemirojr.rastreamento.dto.LogPesquisaResponseDto;
import br.com.claudemirojr.rastreamento.model.ParamsRequestModel;

public interface LogPesquisaService {

	public void criar(LogPesquisaDto logPesquisaCriarDto);

	public Page<LogPesquisaResponseDto> findAll(ParamsRequestModel prm);

	public LogPesquisaResponseDto findById(String id);

}
