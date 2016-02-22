package br.edu.ufcg.labpii.quarto.gui;

import br.edu.ufcg.labpii.quarto.logic.HumanLogicalGame;

// classe respons�vel pelo entrala�amento entre l�gica e gr�ficos num jogo entre jogadores humanos
public class HumanGame extends Game {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -608716926298347591L;
	
	// construtor do jogo gr�fico humano
	public HumanGame (String jogador1, String jogador2, MainMenu mp) {
		super(new HumanLogicalGame(jogador1, jogador2), mp);
	}

	// sobrescreve o m�todo da classe m�e devido as diferen�as com rela��o aos turnos
	public void executaSelecionarMouse (byte indice) {
		executaSelecionar(indice);
	}

	// sobrescreve o m�todo da classe m�e devido as diferen�as com rela��o aos turnos
	public void executaSugerirMouse () {
		executaSugerir();
	}

	// sobrescreve o m�todo da classe m�e devido as diferen�as com rela��o aos turnos
	public void executaJogarMouse (byte linha, byte coluna) {
		executaJogar(linha,coluna);
	}

	// sobrescreve o m�todo da classe m�e devido as diferen�as com rela��o aos turnos
	public void gritaQuartoMouse() {
		gritaQuarto();
	}
}