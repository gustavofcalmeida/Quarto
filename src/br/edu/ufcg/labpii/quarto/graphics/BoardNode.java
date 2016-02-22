package br.edu.ufcg.labpii.quarto.graphics;

import br.edu.ufcg.labpii.quarto.util.Point2D;
/*
 * UFCG - Universidade Federal de Campina Grande
 * DSC - Departamento de Sistemas e Computação
 * Disciplina: Laboratório de Programação II
 * Projeto: Quarto!
 */
 	    	   
/**
 * Classe que cria um nodo quadrado ou retangular que sera usado no tabuleiro
 * @version 1.0
 * @author Demetrio Gomes Mestre - 20311032
 * @author Gustavo de Farias Costa - 20311393
 * @author Helton Souza Lima - 20311010
 * @author Lucas Albertins de Lima - 20311022
 * @author Pablo Diego Batista de Almeira - 20311033
 * @author Willames Carlos Magalhães Ribeiro - 20311026
 */
public class BoardNode extends ImageNode {	
	//atributos que determinam em que linha e que coluna esta o nodo
	private byte linha;
	private byte coluna;
	
	/**
	 * Construtor de um nodo para o tabuleiro
	 * @param Ponto[] array com os pontos do nodo a ser criado
	 * @param linha a linha do tabuleiro
	 * @param coluna a coluna do tabuleiro
	 */
	public BoardNode (Point2D[] pontos, byte linha, byte coluna) {
		super(pontos);
		this.linha = linha;
		this.coluna = coluna;
	}

	/**
	 * Método que acessa a linha do nodo
	 * @return a linha em que o nodo está
	 */
	public byte getLinha () {
		return this.linha;
	}

	/**
	 * Método que acessa a coluna do nodo
	 * @return a coluna em que o nodo está
	 */
	public byte getColuna () {
		return this.coluna;
	}
}