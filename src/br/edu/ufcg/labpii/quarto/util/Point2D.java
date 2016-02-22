package br.edu.ufcg.labpii.quarto.util;
/*
 * UFCG - Universidade Federal de Campina Grande
 * DSC - Departamento de Sistemas e Computação
 * Disciplina: Laboratório de Programação II
 * Projeto: Quarto!
 */

/**
 * Classe que cria um ponto com coordenadas x e y
 * @version 1.0
 * @author Demetrio Gomes Mestre - 20311032
 * @author Gustavo de Farias Costa - 20311393
 * @author Helton Souza Lima - 20311010
 * @author Lucas Albertins de Lima - 20311022
 * @author Pablo Diego Batista de Almeira - 20311033
 * @author Willames Carlos Magalhães Ribeiro - 20311026
 */
public class Point2D {

	// coordenadas
	public final int x;
	public final int y;

	/**
	 * Contrutor que cria um ponto a partir das coordenadas x e y
	 * @param x coordenada x
	 * @param y coordenada y
	 */
	public Point2D (int x, int y) {
		this.x = x;
		this.y = y;
	}
}