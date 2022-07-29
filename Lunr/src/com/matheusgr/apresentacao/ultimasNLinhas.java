package com.matheusgr.apresentacao;

public class ultimasNLinhas implements representacao{

	
	private String texto;
	private int numlinhas;

	public ultimasNLinhas(String texto, int numLinhas) {
		this.texto  = texto;
		this.numlinhas = numLinhas;
	}

	@Override
	public String imprime() {
		
		String[] meuArray = texto.split("\n");
		
		
		
		return null;
	}

}


