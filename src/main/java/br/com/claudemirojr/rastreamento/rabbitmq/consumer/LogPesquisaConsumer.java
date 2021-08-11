package br.com.claudemirojr.rastreamento.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.claudemirojr.rastreamento.dto.LogPesquisaDto;
import br.com.claudemirojr.rastreamento.model.service.LogPesquisaService;

@Component
public class LogPesquisaConsumer {
	
	@Autowired
	private LogPesquisaService logPesquisaService;

	@RabbitListener(queues = { "${queue.order.name}" })
	public void receive(@Payload String log) {
		ObjectMapper obj =  new  ObjectMapper ();
		
		try {
			LogPesquisaDto logPesquisaDto = obj.readValue(log, LogPesquisaDto.class);
			
			logPesquisaService.criar(logPesquisaDto);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
