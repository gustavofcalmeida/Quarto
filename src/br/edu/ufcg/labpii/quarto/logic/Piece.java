package br.edu.ufcg.labpii.quarto.logic;
/*
 * UFCG - Universidade Federal de Campina Grande
 * DSC - Departamento de Sistemas e Computação
 * Disciplina: Laboratório de Programação II
 * Projeto: Quarto!
 */
 	    	   
/**
 * Classe de uma peça para o jogo Quarto! 
 * @version 1.0
 * @author Demetrio Gomes Mestre - 20311032
 * @author Gustavo de Farias Costa - 20311393
 * @author Helton Souza Lima - 20311010
 * @author Lucas Albertins de Lima - 20311022
 * @author Pablo Diego Batista de Almeira - 20311033
 * @author Willames Carlos Magalhães Ribeiro - 20311026
 */
public class Piece {
	//Informação responsável pelas características da peça
	private byte codigo;
	
	/**
	 * Construtor da classe Peca
	 * codigo o código da peça (0 a 15)
	 */
	public Piece (byte codigo) {
		this.codigo = codigo;
	}

	/**
	 * Retorna o código da cor da peça
	 * @return 0 se a peça é marrom ou 1 se for amarela
	 */
	public byte getCor () {
		if ((getCodigo() & (byte)8) == 0) {
			return 0;
		}
		return 1;
	}
	
	/**
	 * Retorna o código da altura da peça
	 * @return 0 se a peça é baixa ou 1 se a peça for alta
	 */
	public byte getAltura () {
		if ((getCodigo() & (byte)4) == 0) {
			return 0;
		}
		return 1;
	} 
	
	/**
	 * Retorna o código da forma da peça
	 * @return 0 se a peça é redonda ou 1 se a peça for quadrada
	 */
	public byte getForma () {
		if ((getCodigo() & (byte)2) == 0) {
			return 0;
		}
		return 1;
	} 
	
	/**
	 * Retorna o código da pintura da peça
	 * @return 0 se a peça é limpa ou 1 se a peça for pintada
	 */
	public byte getPintura () {
		if ((getCodigo() & (byte)1) == 0) {
			return 0;
		}
		return 1;
	} 
	
	/**
	 * Retorna o código da peça
	 * @return o código da peça
	 */
	public byte getCodigo () {
		return codigo;
	} 
	
	/**
	 * Representa a peça em forma de String
	 * @return a String representando a peça
	 */
	public String toString () {
		return "" + getCor() + getForma() + getAltura() + getPintura();
	} 
}