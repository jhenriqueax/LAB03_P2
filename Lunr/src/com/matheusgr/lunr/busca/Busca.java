package com.matheusgr.lunr.busca;

import java.util.Map;

import com.matheusgr.lunr.documento.Documento;
import com.matheusgr.lunr.documento.DocumentoService;

public interface Busca {
	
	
	/**
	 * 
	 * Método Busca que está presente na busca simples, bem como na busca avançada.
	 * 
	 * @param ds
	 * @return
	 */
	public Map<Documento, Integer> busca(DocumentoService ds);
	
	

}
