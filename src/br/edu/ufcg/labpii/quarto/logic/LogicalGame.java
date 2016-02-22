package br.edu.ufcg.labpii.quarto.logic;
/*
 * UFCG - Universidade Federal de Campina Grande
 * DSC - Departamento de Sistemas e Computação
 * Disciplina: Laboratório de Programação II
 * Projeto: Quarto!
 */
 	    	   
/**
 * Classe que constrói um jogo lógico entre dois jogadores de Quarto!
 * @version 1.0
 * @author Demetrio Gomes Mestre - 20311032
 * @author Gustavo de Farias Costa - 20311393
 * @author Helton Souza Lima - 20311010
 * @author Lucas Albertins de Lima - 20311022
 * @author Pablo Diego Batista de Almeira - 20311033
 * @author Willames Carlos Magalhães Ribeiro - 20311026
 */
public class LogicalGame {
	//Instancias de objetos utilizadas em um Jogo
	private Board tabuleiro;
	private PiecesBox caixaDePecas;
	private Player jogador1, 
					jogador2,
					jogadorDaVez;

	/**
	 * Construtor da classe Jogo
	 * @param J1 o jogador 1
	 * @param J2 o jogador 2
	 */
	public LogicalGame (Player j1, Player j2) {
		tabuleiro = new Board();
		caixaDePecas = new PiecesBox();
		for (byte i = 0; i < 16; i++) {
			caixaDePecas.adicionaPeca(new Piece(i),i);
		}
		jogador1 = j1;
		jogador2 = j2;
		jogadorDaVez = jogador1;
	}
	
	public void resetaJogo() {
		tabuleiro = new Board();
		caixaDePecas = new PiecesBox();
		for (byte i = 0; i < 16; i++) {
			caixaDePecas.adicionaPeca(new Piece(i),i);
		}
		
		this.jogador1.removePecaSelecionada();
		this.jogador2.removePecaSelecionada();
		jogadorDaVez = jogador1;
	}
	
	/**
	 * Método responsável por mudar o turno do jogo, modificando o jogador da vez
	 */
	public void mudaTurno () {
		if (jogadorDaVez == jogador1) {
			jogadorDaVez = jogador2;
		}
		else {
			jogadorDaVez = jogador1;
		}
	}

	/**
	 * Obtém o jogador da vez
	 * @return o jogador da vez
	 */
	public Player getJogadorDaVez () {
		return jogadorDaVez;
	}

	/**
	 * Retorna o tabuleiro do jogo
	 * @return um Tabuleiro
	 */
	public Board getTabuleiro () {
		return tabuleiro;
	}

	/**
	 * Retorna a caixa de peças do jogo
	 * @return uma caixa de peças
	 */
	public PiecesBox getCaixaDePecas () {
		return caixaDePecas;
	}

	/**
	 * Retorna o jogador 1 do jogo
	 * @return o jogador 1
	 */
	public Player getJogador1 () {
		return jogador1;
	}

	/**
	 * Retorna o jogador 2 do jogo
	 * @return o jogador 2
	 */
	public Player getJogador2 () {
		return jogador2;
	}
}