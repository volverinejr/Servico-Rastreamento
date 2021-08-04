package br.com.claudemirojr.rastreamento.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sun.net.httpserver.Authenticator.Success;

import br.com.claudemirojr.rastreamento.dto.LogPesquisaDto;
import br.com.claudemirojr.rastreamento.dto.LogPesquisaResponseDto;
import br.com.claudemirojr.rastreamento.model.ParamsRequestModel;
import br.com.claudemirojr.rastreamento.model.service.LogPesquisaService;

@RestController
@RequestMapping("/log-pesquisa/v1")
public class LogPesquisaController {

	@Autowired
	private LogPesquisaService logPesquisaService;

	@PostMapping
	public ResponseEntity<?> create(@RequestBody @Valid LogPesquisaDto logPesquisaDto) {
		logPesquisaService.criar(logPesquisaDto);

		return new ResponseEntity<Success>(HttpStatus.ACCEPTED);
	}
	
	
/*	
	@PostMapping
	public ResponseEntity<LogPesquisaResponseDto> create(@RequestBody @Valid LogPesquisaDto logPesquisaDto) {
		LogPesquisaResponseDto novo = logPesquisaService.criar(logPesquisaDto);

		return new ResponseEntity<>(novo, HttpStatus.CREATED);
	}
*/	
	
	@GetMapping
	public ResponseEntity<?> findAll(@RequestParam Map<String, String> params) {
		ParamsRequestModel prm = new ParamsRequestModel(params);

		Page<LogPesquisaResponseDto> registros = logPesquisaService.findAll(prm);

		return ResponseEntity.ok(registros);
	}

	@GetMapping("/{id}")
	public LogPesquisaResponseDto findById(@PathVariable("id") String id) {
		return logPesquisaService.findById(id);
	}

}
