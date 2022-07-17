package com.matheusgr.lunr.documento;


import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;


/**
 * Repositório de documentos. O repositório pode ter opreações simples de busca,
 * mas a lógica de ranking, limitação e ordenação deve ficar em outra entidade.
 * 
 * O ID de um documento é único.
 */
class DocumentoRepository {

	private Map<String, Documento> documentos;
	private ValidadorDocumentos validador;

	/**
	 * Construção padrão do repositório de documentos.
	 */
	DocumentoRepository() {
		this.documentos = new HashMap<String, Documento>();
		this.validador = new ValidadorDocumentos();
	}

	/**
	 * Adiciona o documento. O documento é validado para garantir a consistência do
	 * documento (sem termos e id vazios).
	 * 
	 * @param documentos Documento a ser adicionado.
	 */
	void adiciona(Documento documentos) {
		this.validador.validacao(documentos.getId(), documentos.getTexto());
		this.documentos.put(documentos.getId(), documentos);
	}

	/**
	 * Recupera um documento do repositório.
	 * 
	 * @param id ID do documento.
	 * @return Documento, caso exista.
	 */
	Optional<Documento> recupera(String id) {
		Documento doc = null;
		this.validador.validacao(id);

		Set<String> chaves = documentos.keySet();
		for (String chave : chaves) {
			if (chave != null) {

				for (int i = 0; i < this.documentos.size(); i++) {
					if (id == this.documentos.get(chave).getId()) {

						doc = this.documentos.get(chave);
					}
				}
			}
		}
		return Optional.ofNullable(doc);
	}

	/**
	 * Retorna o total de documentos cadastrados.
	 * 
	 * @return O total de documentos cadastrados.
	 */
	int totalDocumentos() {
		return this.documentos.size();
	}

	/**
	 * Realiza uma busca pelos termos .
	 * 
	 * @param termo Termo a ser buscado.
	 * @return Conjunto de documentos com o termo.
	 */
	public Set<Documento> busca(String termo) {

		Set<Documento> listaBuscar = new HashSet<>();

		Set<String> chaves = documentos.keySet();
		for (String chave : chaves) {
			if (chave != null) {

				for (int i = 0; i < this.documentos.size(); i++) {
					String[] texto = documentos.get(chave).getTexto();
					if (Arrays.stream(texto).anyMatch(termo::equals)) {
						listaBuscar.add(documentos.get(chave));
					}

				}
			}

		}

		return listaBuscar;
	}
}
