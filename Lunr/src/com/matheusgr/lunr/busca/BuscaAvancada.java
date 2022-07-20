package com.matheusgr.lunr.busca;


import java.util.Map;


import com.matheusgr.lunr.documento.Documento;

public class BuscaAvancada {

	private Map<String, String> termos;

	public BuscaAvancada(Map<String, String> metaDados) {
		(new ValidadorBusca()).valida(termos);
		this.termos.put(null, null);

	}

	public Map<Documento, Integer> Busca(Map<String, String> meta) {



		return null;
	}

}
