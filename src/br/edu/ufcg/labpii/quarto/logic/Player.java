package br.edu.ufcg.labpii.quarto.logic;
/*
 * UFCG - Universidade Federal de Campina Grande
 * DSC - Departamento de Sistemas e Computação
 * Disciplina: Laboratório de Programação II
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
 * @author Willames Carlos Magalhães Ribeiro - 20311026
 */
public class Player {
	protected int vitorias; 		// Numero de Vitorias
  	protected String nome;  		// Nome do Jogador
	protected Piece pecaSelecionada; // A peca selecionada pelo Jogador
	
	/**
	 * Constrói um jogador para o jogo Quarto!
	 * @param nome o nome do jogador
	 */
	public Player (String nome) {
		this.nome = nome;
		vitorias = 0;
		pecaSelecionada = null;
	}
	
	/**
	 * Retorna o número de vitórias do jogador
	 * @return o número de vitórias do jogador
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
	 * Retorna a peça selecionda pelo jogador
	 * @return a peça atualmente selecionada pelo jogador
	 */
	public Piece getPecaSelecionada () {
		return pecaSelecionada;
	}
	
	/**
	 * Adiciona uma vitória ao jogador
	 */
	public void adicionaVitoria () {
		vitorias++;
	} 
	
	/**
	 * Seta uma determinada peça como a peça selecionada
	 * @param aPeca a peça que o jogador vai ter como selecionada
	 */
	public void setPecaSelecionada (Piece aPeca) {
		pecaSelecionada = aPeca;
	}

	// remove a peça selecionada
	public void removePecaSelecionada () {
		pecaSelecionada = null;
	}
	
	/**
	 * Coloca a peça selecionada na região de sugestão do tabuleiro
	 * @param oTabuleiro o tabuleiro onde a peça vai ser sugerida
	 */
	public void sugerePeca (Board oTabuleiro) {
		oTabuleiro.setPecaSugerida(getPecaSelecionada());
		removePecaSelecionada();
	}

	/**
	 * Joga a peça sugerida de um tabuleiro numa casa do tabuleiro
	 * @param oTabuleiro o tabuleiro onde vai ocorrer a jogada
	 * @param linha a linha onde ocorrerá a jogada
	 * @param coluna a coluna onde ocorrerá a jogada
	 */
	public void jogar (Board oTabuleiro, byte linha, byte coluna) {
		oTabuleiro.recebePeca(linha,coluna);
	}
}