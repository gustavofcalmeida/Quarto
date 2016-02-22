package br.edu.ufcg.labpii.quarto.logic;

import br.edu.ufcg.labpii.quarto.ai.ArtificialIntelligence;
import br.edu.ufcg.labpii.quarto.gui.CPUGame;

/**
 * Classe que representa um jogador controlado pelo computador para o jogo Quarto!
 * @version 1.0
 * @author Demetrio Gomes Mestre - 20311032
 * @author Gustavo de Farias Costa - 20311393
 * @author Helton Souza Lima - 20311010
 * @author Lucas Albertins de Lima - 20311022
 * @author Pablo Diego Batista de Almeira - 20311033
 * @author Willames Carlos Magalhães Ribeiro - 20311026
 */
public class CPUPlayer extends Player {
	/**
	 * Construtor de um jogador CPU para o jogo Quarto!
	 */
	public CPUPlayer () {
		super(java.util.ResourceBundle.getBundle("br/edu/ufcg/labpii/quarto/local_strings").getString("JC_CPU"));
	}

	/**
	 * Executa todas as ações necessárias para que a CPU jogue automaticamente. Chama a IA.
	 * @param j o JogoGraficoCPU onde as ações vão ocorrer
	 */
	public void jogaAutomatico (CPUGame j) {
		if (!j.gritaQuarto()) {
			// a inteligência artificial é invocada nesse ponto
			byte[] indicacaoJogada = ArtificialIntelligence.indicaJogada((j.getJogo()).getTabuleiro(),(j.getJogo()).getCaixaDePecas());
			j.executaJogar(indicacaoJogada[0],indicacaoJogada[1]);

			if (!((j.getJogo()).getTabuleiro()).estaCheio()) {
				if (!j.gritaQuarto()) {
					// a inteligência artificial é invocada nesse ponto
					byte indicacaoPeca = ArtificialIntelligence.indicaPeca ((j.getJogo()).getTabuleiro(),(j.getJogo()).getCaixaDePecas());
					j.executaSelecionar(indicacaoPeca);
					j.executaSugerir();
				}
			}
		}
	}	
}