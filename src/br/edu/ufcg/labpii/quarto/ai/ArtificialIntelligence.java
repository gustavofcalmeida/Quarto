package br.edu.ufcg.labpii.quarto.ai;
/*
 * UFCG - Universidade Federal de Campina Grande
 * DSC - Departamento de Sistemas e Computação
 * Disciplina: Laboratório de Programação II
 * Projeto: Quarto!
 */

import java.util.Iterator;
import java.util.Vector;

import br.edu.ufcg.labpii.quarto.logic.PiecesBox;
import br.edu.ufcg.labpii.quarto.logic.Piece;
import br.edu.ufcg.labpii.quarto.logic.Board;

/**
 * Classe que implementa a inteligência artificial do jogo Quarto!
 * @version 1.0 
 * @author Demetrio Gomes Mestre - 20311032
 * @author Gustavo de Farias Costa - 20311393
 * @author Helton Souza Lima - 20311010
 * @author Lucas Albertins de Lima - 20311022
 * @author Pablo Diego Batista de Almeira - 20311033
 * @author Willames Carlos Magalhães Ribeiro - 20311026
 */
public class ArtificialIntelligence {

	/**
	 * Método que indica uma posição para o JogadorCPU jogar
	 * @param tabuleiro o tabuleiro onde é preciso jogar
 	 * @param caixa a caixa onde estão as peças
 	 * @return array com a linha e acoluna para se jogar
 	 */	
	public static byte[] indicaJogada (Board tabuleiro, PiecesBox caixa) {
		//Primeiramente, testa se ha alguma possibilidade de vitoria com a peca sugerida
		byte[] jogadaVencedora = vencerComTresPecas(tabuleiro);
		if (jogadaVencedora[0] != -1) {		
			return jogadaVencedora;	
		}
		//Se nao, tenta jogar a peca de forma que a CPU sugira alguma peca com que o
		//jogador adversario nao ganhe
		byte[] jogadaNormal = jogarNormal(tabuleiro,caixa);
		return jogadaNormal;
	}

	/**
	 * Método que indica uma peça para o JogadorCPU sugerir
	 * @param tabuleiro o tabuleiro onde é preciso jogar
 	 * @param caixa a caixa onde estão as peças
 	 * @return array com a linha e acoluna para se jogar
 	 */	
	public static byte indicaPeca (Board tabuleiro, PiecesBox caixa) {
		//Pega uma peca com a qual o jogador adversario nao possa ganhar
		Piece peca = pecaSegura(tabuleiro,caixa);
		//Talvez nao tenha nenhuma peca segura
		if (peca != null){
			return peca.getCodigo();
		}
		//Caso nao haja nenhuma peca segura, ele deve jogar aleatoriamente
		//de modo que provavelmente ira perder
		Vector<Piece> possiveisJogadas = caixa.pecasAindaJogaveis();
		peca = possiveisJogadas.get(0);
		return peca.getCodigo();
	}
	
	//Metodo que testa se ha alguma possibilidade para vencer imediatamente
	//Neste caso, so ha esta possibilidade se houver no tabuleiro alguma
	//fila com tres pecas
	private static byte[] vencerComTresPecas(Board tabuleiro){
		Board original = tabuleiro.getCloneTabuleiro();
		//Recebe as filas com tres pecas
		Vector<Byte> filasTresPecas = original.getFilaComTresPecas();
		
		//Caso nao venca, array de derrota
		byte[] perdeu = new byte[2];
		perdeu[0] = -1;
		perdeu[1] = -1;
		
		//Testa cada fila com tres pecas		
		if (!filasTresPecas.isEmpty()){		
			Iterator<Byte> fila =	filasTresPecas.iterator();	
			while(fila.hasNext()){
				Byte f = fila.next();
				byte[] coordDaVitoria = vencer(f.byteValue(),original);//Chama outro metodo private
				if (coordDaVitoria[0] != -1){
					return coordDaVitoria;
				}//if-2
			}//while
		}//if-1
		
		return perdeu;	
	}//metodo
	
	
	//Retorna as coordenadas para a vitoria
	private static byte[] vencer(byte numeroDaFila, Board tabuleiro){
		Board original = tabuleiro.getCloneTabuleiro(); //Pode trabalhar apenas com o original

		//Variavel de auxilio
		Piece[] fila = original.getFila(numeroDaFila);
		
		//Coordenadas de determinada peca no tabuleiro, caso venca
		byte[] coordenada;
		
		//Caso nao venca, array de derrota
		byte[] perdeu = new byte[2];
		perdeu[0] = -1;
		perdeu[1] = -1;
				
		//Varre todas as filas
		for (byte posicao=0 ; posicao<4 ; posicao++){
			if (fila[posicao] == null){
				
				//Insere a peca sugerida em posicao vazia
				coordenada = Board.getLinhaColuna(numeroDaFila,posicao);
				original.recebePeca(coordenada[0],coordenada[1]);
				
				//Testa se com determinada peca ha um quarto nesta fila
				if (original.haQuartoNaFila(numeroDaFila)){
					return coordenada;
				}//if-2
				
			}//if-1
		}//for
		return perdeu;
	}//metodo
	
	//Procura, na caixa de pecas, alguma peca com a qual o adversario nao possa ganhar o jogo
	private static Piece pecaSegura(Board tabuleiro, PiecesBox caixa){
		//Cria uma outra instancia de tabuleiro para podermos modificar
		//sem perder as referencias para o primeiro (original)
		Board original = tabuleiro.getCloneTabuleiro();
		
		//Aqui sera armazenadas todas as pecas seguras
		Vector<Piece> pecasSeguras = new Vector<Piece>();
		
		//Aqui sao recebidas todas as pecas da caixa que podem ser jogadas
		Vector<Piece> pecasDaCaixa = caixa.pecasAindaJogaveis();
		Iterator<Piece> setorCaixa = pecasDaCaixa.iterator();
		
		//Varre cada peca da caixa ainda a ser jogada		
		while(setorCaixa.hasNext()){
			//Iterator basico
			Piece pecaCorrente = setorCaixa.next();
			
			//Modifica o tabuleiro para ser testado: sugere uma peca
			original.setPecaSugerida(pecaCorrente);
			
			//Verifica, com o metodo vencerComTresPecas, se ha possibilidade de vitoria
			byte[] vencerComTresArray = vencerComTresPecas(original);
			if (vencerComTresArray[0] == -1){
				pecasSeguras.add(new Piece(pecaCorrente.getCodigo()));//Se nao, insere a peca no Vector
			}
			
			//Retorna ao tabuleiro original para testar outra vez			
			original = tabuleiro.getCloneTabuleiro();
		}
		
		//Escolhe alguma peca, randomicamente, dentre as pecas seguras encontradas
		if (!pecasSeguras.isEmpty()) {
			int indiceRandomico = (int)(Math.random()*pecasSeguras.size()); 
			return (Piece)(pecasSeguras.get(indiceRandomico));
		}
		
		return null; //No caso de nao haver peca segura
	}
	
	//Casos em que nao ha possibilidade de vitoria imediata
	private static byte[] jogarNormal(Board tabuleiro, PiecesBox caixa){
		//Cria um clone do tabuleiro original
		Board original = tabuleiro.getCloneTabuleiro();
		//Recebe as jogadas possiveis no tabuleiro
		Vector<byte[]> jogadasPossiveis = original.posicoesDeJogada();

		//Coordenada utilizada caso nao tenha uma peca segura
		int indiceRandomico = (int)(Math.random()*jogadasPossiveis.size());
		byte[] coordenadaNaoSegura = jogadasPossiveis.get(indiceRandomico);
		
		//Varre as jogadas possiveis e testa cada uma		
		while(!jogadasPossiveis.isEmpty()){	
			//Recebe uma jogada aleatoria
			indiceRandomico = (int)(Math.random()*jogadasPossiveis.size());
			//Recebe as coordenadas da jogada
			byte[] coordenadaSegura = jogadasPossiveis.get(indiceRandomico);
			//Insere, ainda no teste, a peca sugerida
			original.recebePeca(coordenadaSegura[0], coordenadaSegura[1]);
			//Verifica se ha alguma peca segura depois da jogada
			Piece peca = pecaSegura(original,caixa);
			//Se houver peca segura, retorna imediatamente a coordenada
			if (peca != null){
				return coordenadaSegura;
			}
			//Se nao, remove a jogada possivel do Vector
			jogadasPossiveis.removeElementAt(indiceRandomico);
			//E recebe o tabuleiro original novamente
			original = tabuleiro.getCloneTabuleiro();
		}

		return coordenadaNaoSegura; //Se nao houver jogadas seguras, retorna uma nao segura
	}//jogarNormal
}//Class