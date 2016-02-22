package br.edu.ufcg.labpii.quarto.graphics;
/*
 * UFCG - Universidade Federal de Campina Grande
 * DSC - Departamento de Sistemas e Computação
 * Disciplina: Laboratório de Programação II
 * Projeto: Quarto!
 */

import java.awt.event.*;

import br.edu.ufcg.labpii.quarto.util.Point2D;

/**
 * Classe que cria um nodo na tela a ser clicado
 * @version 1.0
 * @author Demetrio Gomes Mestre - 20311032
 * @author Gustavo de Farias Costa - 20311393
 * @author Helton Souza Lima - 20311010
 * @author Lucas Albertins de Lima - 20311022
 * @author Pablo Diego Batista de Almeira - 20311033
 * @author Willames Carlos Magalhães Ribeiro - 20311026
 */
public class ImageNode {

	private Point2D vertice1;
	private Point2D vertice2;

	/**
	 * Contrutor do nodo
	 * @param extremos array com os vértices do nodo
	 */
	public ImageNode (Point2D[] extremos) {
    	// no final de tudo configura os valores dos vertices
		this.vertice1 = extremos[0];
		this.vertice2 = extremos[1];
	}

	/**
	 * Verifica se um evento ocorreu dentro da região
	 * @param MouseEvent um evento do mouse
	 * @return true se o evento aconteceu nessa região ou false em caso contrário
	 */
	public boolean dentro (MouseEvent evento) {
		return evento.getX() >= vertice1.x &&
			   evento.getX() <= vertice2.x &&
			   evento.getY() >= vertice1.y &&
			   evento.getY() <= vertice2.y;
	}

	/**
	 * Recupera um ponto do nodo
	 * @param indice o índice do ponto a ser pego
	 * @return o ponto no índice
	 */
	public Point2D getPonto (int indice) {
    	switch (indice) {
			case 0: return this.vertice1;
			case 1: return this.vertice2;
			default: return null;
		}
	}
}