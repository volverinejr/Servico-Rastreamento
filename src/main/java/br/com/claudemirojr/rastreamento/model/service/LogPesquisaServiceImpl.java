package br.com.claudemirojr.rastreamento.model.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import br.com.claudemirojr.rastreamento.converter.DozerConverter;
import br.com.claudemirojr.rastreamento.dto.LogPesquisaDto;
import br.com.claudemirojr.rastreamento.dto.LogPesquisaResponseDto;
import br.com.claudemirojr.rastreamento.exception.ResourceNotFoundException;
import br.com.claudemirojr.rastreamento.model.ParamsRequestModel;
import br.com.claudemirojr.rastreamento.model.entity.LogPesquisa;
import br.com.claudemirojr.rastreamento.model.repository.LogPesquisaRepository;

@Service
public class LogPesquisaServiceImpl implements LogPesquisaService {

	@Autowired
	private LogPesquisaRepository logPesquisaRepository;

	private LogPesquisaResponseDto convertToLogPesquisaResponseDto(LogPesquisa entity) {
		return DozerConverter.parseObject(entity, LogPesquisaResponseDto.class);
	}

	@Override
	@Async("asyncExecutor")
	public CompletableFuture<LogPesquisaResponseDto> criar(LogPesquisaDto logPesquisaCriarDto) {
		var entity = DozerConverter.parseObject(logPesquisaCriarDto, LogPesquisa.class);

		var pagina = logPesquisaRepository.save(entity);

		return CompletableFuture.completedFuture(convertToLogPesquisaResponseDto(pagina));
	}

	@Override
	public Page<LogPesquisaResponseDto> findAll(ParamsRequestModel prm) {
		Pageable pageable = prm.toSpringPageRequest();

		var page = logPesquisaRepository.findAll(pageable);

		return page.map(this::convertToLogPesquisaResponseDto);
	}

	@Override
	public LogPesquisaResponseDto findById(String id) {
		var entity = logPesquisaRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException(String.format("Log Pesquisa não encontrada para id %d", id)));

		return convertToLogPesquisaResponseDto(entity);
	}

}
