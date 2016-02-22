package br.edu.ufcg.labpii.quarto.logic;
/*
 * UFCG - Universidade Federal de Campina Grande
 * DSC - Departamento de Sistemas e Computação
 * Disciplina: Laboratório de Programação II
 * Projeto: Quarto!
 */

import java.util.Vector;

/**
 * Classe de uma caixa de peças para o jogo Quarto! 
 * @version 1.0
 * @author Demetrio Gomes Mestre - 20311032
 * @author Gustavo de Farias Costa - 20311393
 * @author Helton Souza Lima - 20311010
 * @author Lucas Albertins de Lima - 20311022
 * @author Pablo Diego Batista de Almeira - 20311033
 * @author Willames Carlos Magalhães Ribeiro - 20311026
 */
public class PiecesBox {
	// Intancia referente a criacao de uma caixa de peca
	private Piece[] caixa;

	/**
	 * Constrói uma caixa de peças vazia
	 */
	public PiecesBox() {
		caixa = new Piece[16];
		resetCaixaDePecas();
	}
	
	/**
	 * Retorna um peça de determinada posição da caixa de peças 
	 * @param indice a posição na caixa
	 * @return Um objeto Peca
	 */
	public Piece getPeca(byte indice) {
		return caixa[indice];
	}
	
	/**
	 * Remove uma peça de determinada posição da caixa de peças
	 * @param indice a posição na caixa
	 */
	public void removePeca(byte indice) {
		caixa[indice] = null;
	}
	
	/**
	 * Adiciona determinada peça em uma posição da caixa de peças
	 * @param aPeca a peça a ser adicionada
	 * @param indice a posição onde a peça vai ser inserida
	 */
	public void adicionaPeca(Piece aPeca, byte indice) {
		caixa[indice] = aPeca;
	}
	
	/**
	 * Esvazia a caixa de peças 
	 */
	public void resetCaixaDePecas() {
		for (byte i = 0; i < caixa.length; i++) {
			caixa[i] = null;
		}
	}
	
	/**
	 * Verifica se a caixa de peças está vazia
	 * @return true se estiver vazia e false caso contrário
	 */
	public boolean estaVazia() {
		for (byte i = 0; i < caixa.length; i++) {
			if (caixa[i] != null) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Retorna as peças que ainda estão na caixa 
	 * @return um Vector das pecas que ainda estão na caixa de peças 
	 */
	public Vector<Piece> pecasAindaJogaveis(){
		// Instancia do vector de retorno das pecas
		Vector<Piece> jogadasPossiveis = new Vector<Piece>();		
		// Varre a caixa de peca, procurando as pecas restantes 
		for (byte posicao=0 ; posicao<16 ; posicao++){
			Piece pecaCorrente = getPeca(posicao);
			if (pecaCorrente != null){
				jogadasPossiveis.add(new Piece(pecaCorrente.getCodigo()));
			}
		}	
		return jogadasPossiveis;
	}
}