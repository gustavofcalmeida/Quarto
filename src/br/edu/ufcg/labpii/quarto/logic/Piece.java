package br.edu.ufcg.labpii.quarto.logic;
/*
 * UFCG - Universidade Federal de Campina Grande
 * DSC - Departamento de Sistemas e Computa��o
 * Disciplina: Laborat�rio de Programa��o II
 * Projeto: Quarto!
 */
 	    	   
/**
 * Classe de uma pe�a para o jogo Quarto! 
 * @version 1.0
 * @author Demetrio Gomes Mestre - 20311032
 * @author Gustavo de Farias Costa - 20311393
 * @author Helton Souza Lima - 20311010
 * @author Lucas Albertins de Lima - 20311022
 * @author Pablo Diego Batista de Almeira - 20311033
 * @author Willames Carlos Magalh�es Ribeiro - 20311026
 */
public class Piece {
	//Informa��o respons�vel pelas caracter�sticas da pe�a
	private byte codigo;
	
	/**
	 * Construtor da classe Peca
	 * codigo o c�digo da pe�a (0 a 15)
	 */
	public Piece (byte codigo) {
		this.codigo = codigo;
	}

	/**
	 * Retorna o c�digo da cor da pe�a
	 * @return 0 se a pe�a � marrom ou 1 se for amarela
	 */
	public byte getCor () {
		if ((getCodigo() & (byte)8) == 0) {
			return 0;
		}
		return 1;
	}
	
	/**
	 * Retorna o c�digo da altura da pe�a
	 * @return 0 se a pe�a � baixa ou 1 se a pe�a for alta
	 */
	public byte getAltura () {
		if ((getCodigo() & (byte)4) == 0) {
			return 0;
		}
		return 1;
	} 
	
	/**
	 * Retorna o c�digo da forma da pe�a
	 * @return 0 se a pe�a � redonda ou 1 se a pe�a for quadrada
	 */
	public byte getForma () {
		if ((getCodigo() & (byte)2) == 0) {
			return 0;
		}
		return 1;
	} 
	
	/**
	 * Retorna o c�digo da pintura da pe�a
	 * @return 0 se a pe�a � limpa ou 1 se a pe�a for pintada
	 */
	public byte getPintura () {
		if ((getCodigo() & (byte)1) == 0) {
			return 0;
		}
		return 1;
	} 
	
	/**
	 * Retorna o c�digo da pe�a
	 * @return o c�digo da pe�a
	 */
	public byte getCodigo () {
		return codigo;
	} 
	
	/**
	 * Representa a pe�a em forma de String
	 * @return a String representando a pe�a
	 */
	public String toString () {
		return "" + getCor() + getForma() + getAltura() + getPintura();
	} 
}