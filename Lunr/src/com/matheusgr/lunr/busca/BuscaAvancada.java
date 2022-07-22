package com.matheusgr.lunr.busca;


import java.util.HashMap;
import java.util.Map;


import com.matheusgr.lunr.documento.Documento;
import com.matheusgr.lunr.documento.DocumentoService;

public class BuscaAvancada implements Busca{

	private Map<String, String> mapa;

	
	// aqui eu crei um construtor igual o construtor de busca simples, só que ele recebe um MAPA como parametro.
	public BuscaAvancada(Map<String, String> metaDados) {
		(new ValidadorBusca()).valida(metaDados);;
		this.mapa.putAll(metaDados);

	}

	// criei o método de busca que será usado no controler 
	public Map<Documento, Integer> busca(DocumentoService ds) {
		
		Map<Documento, Integer> respostaDocumento = new HashMap<>();		
		for (String termo : this.mapa.values()) {
			if (termo.isBlank()) {
				continue;
			}
			for (Documento d : ds.busca(termo)) {
				respostaDocumento.put(d, respostaDocumento.getOrDefault(d, 0) + 1);
			}
		}
		return respostaDocumento;
	}

}

