package br.edu.ufcg.labpii.quarto.logic;

/*
 * UFCG - Universidade Federal de Campina Grande
 * DSC - Departamento de Sistemas e Computação
 * Disciplina: Laboratório de Programação II
 * Projeto: Quarto!
 */

/**
 * Classe que constrói um jogo Quarto! entre dois jogadores humanos
 * 
 * @version 1.0
 * @author Demetrio Gomes Mestre - 20311032
 * @author Gustavo de Farias Costa - 20311393
 * @author Helton Souza Lima - 20311010
 * @author Lucas Albertins de Lima - 20311022
 * @author Pablo Diego Batista de Almeira - 20311033
 * @author Willames Carlos Magalhães Ribeiro - 20311026
 */
public class HumanLogicalGame extends LogicalGame {

	/**
	 * Construtor de um jogo entre dois jogadores humanos
	 * 
	 * @param j1
	 *            um JogadorHumano para ser o jogador 1
	 * @param j2
	 *            um JogadorHumano para ser o jogador 2
	 */
	public HumanLogicalGame(String jogador1, String jogador2) {
		super(new Player(jogador1), new Player(jogador2));

		if (((int) (Math.random() * 2)) == 0) {
			mudaTurno();
		}
	}

	/* (non-Javadoc)
	 * @see quarto.Jogo#resetaJogo()
	 */
	public void resetaJogo() {
		super.resetaJogo();

		if (((int) (Math.random() * 2)) == 0) {
			mudaTurno();
		}
	}
}