package br.edu.ufcg.labpii.quarto.logic;
/*
 * UFCG - Universidade Federal de Campina Grande
 * DSC - Departamento de Sistemas e Computação
 * Disciplina: Laboratório de Programação II
 * Projeto: Quarto!
 */

import java.util.Vector;

/**
 * Classe que implementa um tabuleiro para o jogo Quarto!
 * @version 1.0
 * @author Demetrio Gomes Mestre - 20311032
 * @author Gustavo de Farias Costa - 20311393
 * @author Helton Souza Lima - 20311010
 * @author Lucas Albertins de Lima - 20311022
 * @author Pablo Diego Batista de Almeira - 20311033
 * @author Willames Carlos Magalhães Ribeiro - 20311026
 */
public class Board {
	// atributos
	private Piece[][] casas;
	private Piece pecaSugerida;  
	
	/**
	 * Construtor de Tabuleiro, que não recebe parâmetros
	 * Cria 16 instâncias da classe Peca
	 * e reseta todas as casas, assim como a peça sugerida
	 */
	public Board () {
		casas = new Piece[4][4];
		resetPecaSugerida();
		resetCasas();
	}

	/**
	 * Retorna a peça sugerida por algum dos jogadores
	 * @return a peça sugerida
	 */
	public Piece getPecaSugerida () {
		return pecaSugerida;
	}
	
	/**
	 * Retorna a peça de determinada linha e coluna do tabuleiro
	 * @param linha A linha do tabuleiro em que está a peça
	 * @param coluna A coluna do tabuleiro em que está a peça
	 * @return A peça da linha e coluna correspondente
	 */
	public Piece getPeca (byte linha, byte coluna) {
		return casas[linha][coluna];
	}  
	
	/**
	 * Modifica a peça sugerida do tabuleiro
	 * @param peca A peça a ser sugerida
	 */
	public void setPecaSugerida (Piece peca) {
		pecaSugerida = peca;
	}
	
	/**
	 * Retira a peca que está sugerida e insere no tabuleiro em determinada linha e coluna
	 * @param linha A linha onde a peça deve ser jogada
	 * @param coluna A coluna onde a peça deve ser jogada
	 */
	public void recebePeca (byte linha, byte coluna) {
		casas[linha][coluna] = getPecaSugerida();
		resetPecaSugerida();//Deixa peca sugerida como null
	}
	
	// adiciona uma peça ao tabuleiro, porém pode ser qualquer peça e não apenas a sugerida
	private void addPeca(Piece peca, byte coordX, byte coordY){
	  casas[coordX][coordY] = peca;
	}
	
	/**
	 * Coloca o atributo peça sugerida como null
	 */
	private void resetPecaSugerida() {
		pecaSugerida = null;
	} 
	
	/**
	 * Esvazia todas as casas do tabuleiro, todas como null
	 */
	private void resetCasas () {
		for (byte l = 0; l <= 3; l++) {
			for (byte c = 0; c <= 3; c++) {
				casas[l][c] = null;
			}
		}
	} 
	
	/**
	 * Verifica se o tabuleiro está cheio de peças
	 * @return true se estiver cheio e false caso contrário
	 */
	public boolean estaCheio () {
		for (byte l = 0; l < 4; l++) {
			for (byte c = 0; c < 4; c++) {
				if (casas[l][c] == null) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Cria uma nova instância de tabuleiro com todas as peças em seus respectivos lugares e a peça sugerida correspondente
	 * @return Um clone do tabuleiro corrente
	 */
	public Board getCloneTabuleiro(){
		// Instancia do clone do Tabuleiro		
		Board tabuleiroClone = new Board();
		// Clona o Tabuleiro
		for (byte i=0 ; i<4 ; i++){
			for(byte j=0 ; j<4 ; j++){
				Piece pecaCorrente = this.getPeca(i,j);
				if (pecaCorrente != null) {
					tabuleiroClone.addPeca(new Piece(pecaCorrente.getCodigo()),i,j);
				}
			}
			
		}
		
		if (this.getPecaSugerida() != null) {
			tabuleiroClone.setPecaSugerida(new Piece(getPecaSugerida().getCodigo()));
		}
		
		return tabuleiroClone;
	}

	/**
	 * Retorna as filas contendo três peças
	 * @return Um Vector com as filas que contém três peças
	 */
	public Vector<Byte> getFilaComTresPecas(){
		// Variavel de retorno das filas com tres pecas
		Vector<Byte> conjuntoFila = new Vector<Byte>();
		// Varre as filas procurando aquelas com tres pecas		
		for (byte f=1 ; f<=10 ; f++){
			if (numeroDePecasFila(f) == 3) {
				conjuntoFila.addElement(f);
			}// if
		}// for
		return conjuntoFila;
	}// metodo
	
	/**
	 * Retorna a peça correspondente em uma posição de determinada fila 
	 * @param fila A fila da peça
	 * @param numero A posição da peça na ila
	 * @return A peça em uma posição de determinada fila
	 */
	public Piece getPecaFila (byte fila, byte numero) {
		switch (fila) {
			case  1:
			case  2:
			case  3:
	 		case  4: return casas[fila - 1][numero];
			case  5:
			case  6:
			case  7:
			case  8: return casas[numero][fila - 5];
			case  9: return casas[numero][numero];
		}
		return casas[numero][3 - numero];
	} 
	
	/**
	 * Retorna o número de peças em determinada fila
	 * @param fila A fila que se quer conhecer
	 * @return O número de peças na fila, em bytes
	 */
	public byte numeroDePecasFila (byte fila) {
		byte contador = 0;
		for (byte n = 0; n < 4; n++) {
			if (getPecaFila(fila,n) != null) {
				contador++;
			}
		}
		return contador;
	}
	
	/**
	 * Retorna um array de peças que contém as peças de determinada fila
	 * @param fila A fila que se quer conhecer
	 * @return Array de peças com as peças da fila
	 */
	public Piece[] getFila (byte fila) {
		Piece[] pecas = new Piece[4];
		for (byte p = 0; p <= 3; p++) {
			pecas[p] = getPecaFila (fila,p); 
		}
		return pecas;
	}
	
	/**
	 * Retorna a linha e a coluna de determinada posição em uma fila
	 * @param fila A fila que se quer conhecer sua linha e coluna
	 * @param numero A posição da fila
	 * @return Um array com duas posições: A primeira indica a linha e a segunda a coluna
	 */
	public static byte[] getLinhaColuna (byte fila, byte numero) {
		byte[] linhaColuna = new byte[2];
		switch (fila) {
			case  1:
			case  2:
			case  3:
	 		case  4: {
				linhaColuna[0] = (byte)(fila - 1);
				linhaColuna[1] = numero;
				return linhaColuna;
			}
			case  5:
			case  6:
			case  7:
			case  8: {
				linhaColuna[0] = numero;
				linhaColuna[1] = (byte)(fila - 5);
				return linhaColuna;
			}
			case  9: {
				linhaColuna[0] = numero;
				linhaColuna[1] = numero;
				return linhaColuna;
			}
		}
		linhaColuna[0] = numero;
		linhaColuna[1] = (byte)(3 - numero);
		return linhaColuna;
	}
	
	/**
	 * Indica se há uma situação de vitória no jogo (chama-se Quarto)
	 * @return True se há um Quarto
	 */
	public byte haQuarto () {
		for (byte f = 1; f <= 10; f++) {
			if (numeroDePecasFila(f) == 4) {
				Piece[] pecas = getFila(f);
				byte normal = (byte)(pecas[0].getCodigo() & pecas[1].getCodigo() & 
									 pecas[2].getCodigo() & pecas[3].getCodigo());
				byte inverso = (byte)(~pecas[0].getCodigo() & ~pecas[1].getCodigo() & 
									  ~pecas[2].getCodigo() & ~pecas[3].getCodigo());
				inverso <<= 4;
				inverso >>>= 4;
				if (normal != 0 || inverso != 0) {
					return f;
				}
			}
		}
		return -1;
	}
	
	/**
	 * Indica se há alguma vitória em determinada fila
	 * @param fila A fila a ser verificada
	 * @return True se houver um Quarto na fila
	 */
	public boolean haQuartoNaFila (byte fila) {
		if (numeroDePecasFila(fila) == 4) {
				Piece[] pecas = getFila(fila);
				byte normal = (byte)(pecas[0].getCodigo() & pecas[1].getCodigo() & 
									 pecas[2].getCodigo() & pecas[3].getCodigo());
				byte inverso = (byte)(~pecas[0].getCodigo() & ~pecas[1].getCodigo() & 
									  ~pecas[2].getCodigo() & ~pecas[3].getCodigo());
				inverso <<= 4;
				inverso >>>= 4;
				if (normal != 0 || inverso != 0) {
					return true;
				}
			}
		return false;
	}// metodo
	
	/**
	 * Retorna todas as posições do tabuleiro com possibilidades de receber alguma peça 
	 * @return um Vector com todas as posições de jogada possíveis
	 */
	public Vector<byte[]> posicoesDeJogada(){
		
		Vector<byte[]> jogadasPossiveis = new Vector<byte[]>();
		byte[] posicaoPeca;
				
		for (byte linha = 0; linha < 4 ; linha++){
			for (byte coluna = 0; coluna < 4; coluna++){
				if (this.getPeca(linha,coluna) == null){
					posicaoPeca = new byte[2]; 
					posicaoPeca[0] = linha;
					posicaoPeca[1] = coluna;
					jogadasPossiveis.add(posicaoPeca);
				}
			}
		}
		return jogadasPossiveis;
	}
}