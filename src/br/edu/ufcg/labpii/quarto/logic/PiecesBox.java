package br.edu.ufcg.labpii.quarto.logic;
/*
 * UFCG - Universidade Federal de Campina Grande
 * DSC - Departamento de Sistemas e Computa��o
 * Disciplina: Laborat�rio de Programa��o II
 * Projeto: Quarto!
 */

import java.util.Vector;

/**
 * Classe de uma caixa de pe�as para o jogo Quarto! 
 * @version 1.0
 * @author Demetrio Gomes Mestre - 20311032
 * @author Gustavo de Farias Costa - 20311393
 * @author Helton Souza Lima - 20311010
 * @author Lucas Albertins de Lima - 20311022
 * @author Pablo Diego Batista de Almeira - 20311033
 * @author Willames Carlos Magalh�es Ribeiro - 20311026
 */
public class PiecesBox {
	// Intancia referente a criacao de uma caixa de peca
	private Piece[] caixa;

	/**
	 * Constr�i uma caixa de pe�as vazia
	 */
	public PiecesBox() {
		caixa = new Piece[16];
		resetCaixaDePecas();
	}
	
	/**
	 * Retorna um pe�a de determinada posi��o da caixa de pe�as 
	 * @param indice a posi��o na caixa
	 * @return Um objeto Peca
	 */
	public Piece getPeca(byte indice) {
		return caixa[indice];
	}
	
	/**
	 * Remove uma pe�a de determinada posi��o da caixa de pe�as
	 * @param indice a posi��o na caixa
	 */
	public void removePeca(byte indice) {
		caixa[indice] = null;
	}
	
	/**
	 * Adiciona determinada pe�a em uma posi��o da caixa de pe�as
	 * @param aPeca a pe�a a ser adicionada
	 * @param indice a posi��o onde a pe�a vai ser inserida
	 */
	public void adicionaPeca(Piece aPeca, byte indice) {
		caixa[indice] = aPeca;
	}
	
	/**
	 * Esvazia a caixa de pe�as 
	 */
	public void resetCaixaDePecas() {
		for (byte i = 0; i < caixa.length; i++) {
			caixa[i] = null;
		}
	}
	
	/**
	 * Verifica se a caixa de pe�as est� vazia
	 * @return true se estiver vazia e false caso contr�rio
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
	 * Retorna as pe�as que ainda est�o na caixa 
	 * @return um Vector das pecas que ainda est�o na caixa de pe�as 
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