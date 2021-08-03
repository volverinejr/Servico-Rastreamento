package br.com.claudemirojr.rastreamento.model.entity;

import java.util.Date;

import org.json.JSONObject;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "log_pesquisa")
public class LogPesquisa {

	@Id
	private String id;
	
	private String servico;
	
	private String usuario;
	
	private String className;
	
	private String metodo;
	
	private String argumento;
	
	private Object resultado;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private Date timestamp = new Date();
	
	public void setServico(String servico) {
		this.servico = servico.toUpperCase();
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario.toUpperCase();
	}
	
	public void setResultado(String resultado) {
		JSONObject jsonObject = new JSONObject(resultado);
		
		this.resultado = jsonObject;
	}
	
}
