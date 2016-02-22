package br.edu.ufcg.labpii.quarto.logic;
/*
 * UFCG - Universidade Federal de Campina Grande
 * DSC - Departamento de Sistemas e Computa��o
 * Disciplina: Laborat�rio de Programa��o II
 * Projeto: Quarto!
 */

/**
 * Classe que representa um jogador para o jogo Quarto!
 * @version 1.0
 * @author Demetrio Gomes Mestre - 20311032
 * @author Gustavo de Farias Costa - 20311393
 * @author Helton Souza Lima - 20311010
 * @author Lucas Albertins de Lima - 20311022
 * @author Pablo Diego Batista de Almeira - 20311033
 * @author Willames Carlos Magalh�es Ribeiro - 20311026
 */
public class Player {
	protected int vitorias; 		// Numero de Vitorias
  	protected String nome;  		// Nome do Jogador
	protected Piece pecaSelecionada; // A peca selecionada pelo Jogador
	
	/**
	 * Constr�i um jogador para o jogo Quarto!
	 * @param nome o nome do jogador
	 */
	public Player (String nome) {
		this.nome = nome;
		vitorias = 0;
		pecaSelecionada = null;
	}
	
	/**
	 * Retorna o n�mero de vit�rias do jogador
	 * @return o n�mero de vit�rias do jogador
	 */
	public int getVitorias () {
		return vitorias;
	}
	
	/**
	 * Retorna o nome do jogador
	 * @return o nome do jogador
	 */
	public String getNome () {
		return nome;
	}
	
	/**
	 * Retorna a pe�a selecionda pelo jogador
	 * @return a pe�a atualmente selecionada pelo jogador
	 */
	public Piece getPecaSelecionada () {
		return pecaSelecionada;
	}
	
	/**
	 * Adiciona uma vit�ria ao jogador
	 */
	public void adicionaVitoria () {
		vitorias++;
	} 
	
	/**
	 * Seta uma determinada pe�a como a pe�a selecionada
	 * @param aPeca a pe�a que o jogador vai ter como selecionada
	 */
	public void setPecaSelecionada (Piece aPeca) {
		pecaSelecionada = aPeca;
	}

	// remove a pe�a selecionada
	public void removePecaSelecionada () {
		pecaSelecionada = null;
	}
	
	/**
	 * Coloca a pe�a selecionada na regi�o de sugest�o do tabuleiro
	 * @param oTabuleiro o tabuleiro onde a pe�a vai ser sugerida
	 */
	public void sugerePeca (Board oTabuleiro) {
		oTabuleiro.setPecaSugerida(getPecaSelecionada());
		removePecaSelecionada();
	}

	/**
	 * Joga a pe�a sugerida de um tabuleiro numa casa do tabuleiro
	 * @param oTabuleiro o tabuleiro onde vai ocorrer a jogada
	 * @param linha a linha onde ocorrer� a jogada
	 * @param coluna a coluna onde ocorrer� a jogada
	 */
	public void jogar (Board oTabuleiro, byte linha, byte coluna) {
		oTabuleiro.recebePeca(linha,coluna);
	}
}