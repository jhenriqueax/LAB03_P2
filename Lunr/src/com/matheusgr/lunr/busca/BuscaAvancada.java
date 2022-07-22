package com.matheusgr.lunr.busca;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.matheusgr.lunr.documento.Documento;
import com.matheusgr.lunr.documento.DocumentoService;

public class BuscaAvancada implements Busca {

	private Map<String, String> mapa;

	// aqui eu crei um construtor igual o construtor de busca simples, só que ele
	// recebe um MAPA como parametro.
	public BuscaAvancada(Map<String, String> metaDados) {
		(new ValidadorBusca()).valida(metaDados);

		this.mapa = metaDados;

	}

	// criei o método de busca que será usado no controler
	public Map<Documento, Integer> busca(DocumentoService ds) {

		Map<Documento, Integer> respostaDocumento = new HashMap<>();
		
		Map<Documento, Integer> filtro = new HashMap<>();

		for (String chave : this.mapa.keySet()) {

			String valor = this.mapa.get(chave);

			for (Documento d : ds.busca(chave, valor)) {

				respostaDocumento.put(d, respostaDocumento.getOrDefault(d, 0) + 1);


			}
		}

		for (Documento doc : respostaDocumento.keySet()) {
			
			int valor = respostaDocumento.get(doc);

			if (valor == mapa.size()) {
				filtro.put(doc, valor);
			}

		}
		return filtro;
	}

	// criar esse método
	@Override
	public String[][] descreveConsulta() {

		String[][] resultado = new String[this.mapa.size()][];

		Set<String> chaves = mapa.keySet();
		for (String chave : chaves) {
			if (chave != null) {

				for (int i = 0; i < this.mapa.size(); i++) {

					resultado[i] = new String[] { "TERMO " + (i + 1), this.mapa.get(chave) };

				}
			}

		}
		return resultado;
	}
}
