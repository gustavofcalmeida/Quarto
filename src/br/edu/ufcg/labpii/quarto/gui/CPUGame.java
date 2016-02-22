package br.edu.ufcg.labpii.quarto.gui;

import br.edu.ufcg.labpii.quarto.logic.Player;
import br.edu.ufcg.labpii.quarto.logic.CPUPlayer;
import br.edu.ufcg.labpii.quarto.logic.LogicalGame;

// classe respons�vel pelo entrala�amento entre l�gica e gr�ficos num jogo entre humano e CPU
public class CPUGame extends Game {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4190312623179752692L;
	
	// construtor de um jogo gr�fico CPU
	public CPUGame (String jogador1, MainMenu mp) {
		super(new LogicalGame(new Player(jogador1), new CPUPlayer()), mp);
	}

	// sobrescreve o m�todo da classe m�e para ativar o jogador CPU
	public void mudaTurno () {
		super.mudaTurno();
		if (jogo.getJogadorDaVez() == jogo.getJogador2()) {
			((CPUPlayer)(jogo.getJogador2())).jogaAutomatico(this);
		}
	}
}