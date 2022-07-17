package com.matheusgr.lunr.busca;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.matheusgr.lunr.documento.Documento;

public class BuscaAvancada {

	private Map<String, String> termos;

	// Não estou sabendo cadastrar os meus termos ai dentro, já que
	// a estrututa precisa ser do tipo chave valor, pensei em usar String[0] e
	// String[1]

	public BuscaAvancada(String[] termos) {
		(new ValidadorBusca()).valida(termos);
		this.termos.put(null, null);

	}

	public Map<Documento, Integer> Busca(Map<String, String> meta) {

		// por que não posso instanciar com Documento

		HashMap<String, Documento> documentos = new HashMap<String, Documento>();

		Set<Documento> listaMatch = new HashSet<>();

		Set<String> chaves = documentos.keySet();

		for (String chave : chaves) {
			if (chave != null) {

				for (int i = 0; i < documentos.size(); i++) {
					String[] texto = documentos.get(chave).getTexto();
					
					//aqui precisa comparar o texto com o hash map passado MET
				}

			}
		}

		return null;
	}

}
