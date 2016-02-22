package br.edu.ufcg.labpii.quarto.gui;

import br.edu.ufcg.labpii.quarto.logic.HumanLogicalGame;

// classe responsável pelo entralaçamento entre lógica e gráficos num jogo entre jogadores humanos
public class HumanGame extends Game {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -608716926298347591L;
	
	// construtor do jogo gráfico humano
	public HumanGame (String jogador1, String jogador2, MainMenu mp) {
		super(new HumanLogicalGame(jogador1, jogador2), mp);
	}

	// sobrescreve o método da classe mãe devido as diferenças com relação aos turnos
	public void executaSelecionarMouse (byte indice) {
		executaSelecionar(indice);
	}

	// sobrescreve o método da classe mãe devido as diferenças com relação aos turnos
	public void executaSugerirMouse () {
		executaSugerir();
	}

	// sobrescreve o método da classe mãe devido as diferenças com relação aos turnos
	public void executaJogarMouse (byte linha, byte coluna) {
		executaJogar(linha,coluna);
	}

	// sobrescreve o método da classe mãe devido as diferenças com relação aos turnos
	public void gritaQuartoMouse() {
		gritaQuarto();
	}
}