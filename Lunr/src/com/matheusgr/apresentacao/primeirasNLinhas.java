package com.matheusgr.apresentacao;


public class primeirasNLinhas implements representacao {
	
	private String texto;
	private int numlinhas;

	public primeirasNLinhas(String texto, int numLinhas) {
		this.texto  = texto;
		this.numlinhas = numLinhas;
	}

	@Override
	public String imprime() {
		
		String[] meuArray = texto.split("\n");
		
		String resultado = "";
		
		for (int i = 0; i < this.numlinhas; i++){
			
			resultado += meuArray[i] + " ";
		}
		
		
		
		return resultado;
	}

}
