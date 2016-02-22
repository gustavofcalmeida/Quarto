package br.edu.ufcg.labpii.quarto.gui;
/*
 * UFCG - Universidade Federal de Campina Grande
 * DSC - Departamento de Sistemas e Computação
 * Disciplina: Laboratório de Programação II
 * Projeto: Quarto!
 */

import javax.swing.*;

import br.edu.ufcg.labpii.quarto.graphics.Nodes;
import br.edu.ufcg.labpii.quarto.logic.LogicalGame;
import br.edu.ufcg.labpii.quarto.logic.Board;
import br.edu.ufcg.labpii.quarto.util.ImageLoader;
import br.edu.ufcg.labpii.quarto.util.Point2D;

import java.awt.*;
import java.awt.event.*;

// A principal classe gráfica do jogo, responsável pelo entralaçamento entre lógica e gráficos.
public abstract class Game extends JFrame implements Nodes {
	private static final long serialVersionUID = 1L;
	protected LogicalGame jogo; // o jogo lógico
	private MainMenu menuPrincipal;
	protected Graficos graficos; // responsável pelos métodos gráficos

	// as figuras utilizadas no jogo
	private ImageIcon tabuleiro = ImageLoader.getImagem("scenario.png");
	private ImageIcon marcaTurno = ImageLoader.getImagem("turn.png"); 
	private ImageIcon botaoQuarto = ImageLoader.getImagem("quartoButton.png"); 
	protected ImageIcon vitoria = ImageLoader.getImagem("victory.png");
	protected ImageIcon empate = ImageLoader.getImagem("draw.png");
	private ImageIcon[] pecas = new ImageIcon[16];
	private ImageIcon[] pecasSelecionadas = new ImageIcon[16];
	private ImageIcon[] marcasVitoria = new ImageIcon[4];

	private final int LIMBO = Integer.MIN_VALUE;
	private int posicoesXdasPecas[] = new int[16];
	private int posicoesYdasPecas[] = new int[16];
	private int posicoesXdasPecasSelecionadas[] = new int[16];
	private int posicoesYdasPecasSelecionadas[] = new int[16];
	private Point2D[][] pontosDoTabuleiro = {
		{pontos1Tab[0], pontos2Tab[0], pontos3Tab[0], pontos4Tab[0]},
		{pontos5Tab[0], pontos6Tab[0], pontos7Tab[0], pontos8Tab[0]},
		{pontos9Tab[0], pontos10Tab[0],pontos11Tab[0],pontos12Tab[0]},
		{pontos13Tab[0],pontos14Tab[0],pontos15Tab[0],pontos16Tab[0]}
	};

	// construtor do jogo gráfico
	public Game (LogicalGame jogo, MainMenu mp) {
		super(java.util.ResourceBundle.getBundle("br/edu/ufcg/labpii/quarto/local_strings").getString("JG_Quarto"));
		this.menuPrincipal = mp;
		this.jogo = jogo;
		
		for (byte k = 0; k < pecas.length; k++) {
			pecas[k] = ImageLoader.getImagem("piece" + k + ".png");
			pecasSelecionadas[k] = ImageLoader.getImagem("pieceS" + k + ".png");
		}
		marcasVitoria[0] = ImageLoader.getImagem("victoryMark.gif");
		marcasVitoria[1] = ImageLoader.getImagem("victoryMark.gif");
		marcasVitoria[2] = ImageLoader.getImagem("victoryMark.gif");
		marcasVitoria[3] = ImageLoader.getImagem("victoryMark.gif");
		
		// adicina o listener responsável por captar o mouse
		addMouseListener (new MouseAdapter() {
			public void mousePressed (MouseEvent evento) {
				evento.translatePoint(-getInsets().left, -getInsets().top);

				for (int k = 0; k < nodos.length; k++) {
					if (nodos[k].dentro(evento)) {
						executaSelecionarMouse((byte)k);
					} //fim do if
				} //fim do for

				if (nodoPecaSugerida.dentro(evento)) {
					executaSugerirMouse();
				}

				for (int k = 0; k < nodosTabuleiro.length; k++) {
					if (nodosTabuleiro[k].dentro(evento)) {
						executaJogarMouse(nodosTabuleiro[k].getLinha(),nodosTabuleiro[k].getColuna());
					} //fim do if
				} //fim do for

				if(nodoQuarto.dentro(evento)){
					gritaQuartoMouse();
				}
			} //fim do mouse event
		});
		adicionaListener();
		
		ImageIcon i = ImageLoader.getImagem("icon.png");
		setIconImage(i.getImage());
		setResizable(false);
		
		this.inicia();
	}
	
	// retorna o jogo lógico
	public LogicalGame getJogo() {
		return jogo;
	}

	// muda o turno lógica e graficamente
	public void mudaTurno () {
		jogo.mudaTurno();
		desenhaTurno();
	}

	// executa todos os métodos e testes lógicos e gáficos referentes ao 
	// ato de selecionar uma peça na caixa de peças
	public void executaSelecionar (byte indice) {
		if ((jogo.getTabuleiro()).getPecaSugerida() == null) {
			if ((jogo.getCaixaDePecas()).getPeca(indice) != null) {
				if ((jogo.getJogadorDaVez()).getPecaSelecionada() != null) {
					byte codigoPeca = ((jogo.getJogadorDaVez()).getPecaSelecionada()).getCodigo();
					graficos.desmarcaPecaCaixa(codigoPeca);
				}
				(jogo.getJogadorDaVez()).setPecaSelecionada((jogo.getCaixaDePecas()).getPeca(indice));
				graficos.marcaPecaCaixa(indice);
			}
		}
	}

	// executa todos os métodos e testes lógicos e gáficos referentes ao 
	// ato de sugerir uma peça
	public void executaSugerir () {
		if ((jogo.getJogadorDaVez()).getPecaSelecionada() != null) {
			(jogo.getJogadorDaVez()).sugerePeca(jogo.getTabuleiro());
			graficos.desenhaPecaSugerida();
			byte codigoPeca = ((jogo.getTabuleiro()).getPecaSugerida()).getCodigo();
			(jogo.getCaixaDePecas()).removePeca(codigoPeca);
			mudaTurno();
		}
	}

	// executa todos os métodos e testes lógicos e gáficos referentes ao 
	// ato de jogar uma peça no tabuleiro
	public void executaJogar (byte linha, byte coluna) {
		if ((jogo.getTabuleiro()).getPecaSugerida() != null) {
			if ((jogo.getTabuleiro()).getPeca(linha,coluna) == null) {
				(jogo.getJogadorDaVez()).jogar(jogo.getTabuleiro(),linha,coluna);
				graficos.desenhaPecaJogada(linha,coluna);
				if ((jogo.getTabuleiro()).estaCheio()) {
					gritaQuartoComEmpate();
				}
			}
		}
	}

	// o mesmo método porém a ser chamado pelo mouse
	public void executaSelecionarMouse (byte indice) {
		if (jogo.getJogadorDaVez() == jogo.getJogador1()) {
			executaSelecionar(indice);
		}
	}

	// o mesmo método porém a ser chamado pelo mouse
	public void executaSugerirMouse () {
		if (jogo.getJogadorDaVez() == jogo.getJogador1()) {
			executaSugerir();
		}
	}

	// o mesmo método porém a ser chamado pelo mouse
	public void executaJogarMouse (byte linha, byte coluna) {
		if (jogo.getJogadorDaVez() == jogo.getJogador1()) {
			executaJogar(linha,coluna);
		}
	}

	// invoca o método gráfico de desenhar a marca de turno
	public void desenhaTurno () {
		if (jogo.getJogadorDaVez() == jogo.getJogador1()) {
			graficos.desenhaMarcaTurno(11,6);
		}
		else {
			graficos.desenhaMarcaTurno(11,51);
		}
	}

	// destaca a fila onde há um Quarto
	public void pintaFila (byte fila) {
		for (byte p = 0; p <= 3; p++) {
			byte[] array = Board.getLinhaColuna(fila, p);
			graficos.circulaPeca(array[0],array[1],p);
		}
	}

	// declara um vencedor e questiona quanto ao reinício da partida
	public void declaraVitoria () {
		(jogo.getJogadorDaVez()).adicionaVitoria();

		String[] opcoes = {java.util.ResourceBundle.getBundle("br/edu/ufcg/labpii/quarto/local_strings").getString("JG_Sim"), java.util.ResourceBundle.getBundle("br/edu/ufcg/labpii/quarto/local_strings").getString("JG_Nao")};
		int opcao = JOptionPane.showOptionDialog(this,
												 java.util.ResourceBundle.getBundle("br/edu/ufcg/labpii/quarto/local_strings").getString("JG_VENCEDOR") + jogo.getJogadorDaVez().getNome() + java.util.ResourceBundle.getBundle("br/edu/ufcg/labpii/quarto/local_strings").getString("JG_Deseja_reiniciar"),
												 java.util.ResourceBundle.getBundle("br/edu/ufcg/labpii/quarto/local_strings").getString("JG_Fim_de_jogo"),
												 JOptionPane.YES_NO_OPTION,
												 JOptionPane.PLAIN_MESSAGE,
												 vitoria,
												 opcoes,
												 opcoes[0]);

		if (opcao == 0) {
			this.dispose();
			this.jogo.resetaJogo();
			this.inicia();
		}
		else {
			this.fechar();
		}
	}

	// declara o empate e questiona quanto ao reinício da partida
	public void declaraEmpate () {
		String[] opcoes = {java.util.ResourceBundle.getBundle("br/edu/ufcg/labpii/quarto/local_strings").getString("JG_Sim2"), java.util.ResourceBundle.getBundle("br/edu/ufcg/labpii/quarto/local_strings").getString("JG_Nao2")};
		int opcao = JOptionPane.showOptionDialog(this,
												 java.util.ResourceBundle.getBundle("br/edu/ufcg/labpii/quarto/local_strings").getString("JG_EMPATE_Deseja_Reiniciar"),
												 java.util.ResourceBundle.getBundle("br/edu/ufcg/labpii/quarto/local_strings").getString("JG_Fim_de_Jogo2"),
												 JOptionPane.YES_NO_OPTION,
												 JOptionPane.PLAIN_MESSAGE,
												 empate,
												 opcoes,
												 opcoes[0]);

		if (opcao == 0) {
			this.dispose();
			this.jogo.resetaJogo();
			this.inicia();
		}
		else {
			this.fechar();
		}
	}

	// simula o ato de um jogador gritar Quarto!, podendo declarar a vitória ou não
	public boolean gritaQuarto () {
		byte fila = (jogo.getTabuleiro()).haQuarto();
		if (fila != -1) {
			pintaFila(fila);
			declaraVitoria();
			return true;
		}
		return false;
	}

	// o mesmo método porém a ser chamado pelo mouse
	public void gritaQuartoMouse () {
		if (jogo.getJogadorDaVez() == jogo.getJogador1()) {
			gritaQuarto();
		}
	}

	// um grito de Quarto! automático sempre que o tabuleiro está cheio
	public void gritaQuartoComEmpate () {
		byte fila = (jogo.getTabuleiro()).haQuarto();
		if (fila != -1) {
			pintaFila(fila);
			declaraVitoria();
		}
		else {
			declaraEmpate();
		}
	}

	// responsável por fazer o gráfico ser exibido na tela
	public void inicia () {
		graficos = new Graficos(); // inicialização do objeto responsável pelos desenhos
		this.getContentPane().removeAll();
		getContentPane().add(graficos,BorderLayout.CENTER);
		
		desenhaTurno();
            	
		// carrega as figuras e as coordenadas restantes
		for (byte k = 0; k < pecas.length; k++) {
			posicoesXdasPecas[k] = nodos[k].getPonto(0).x;
			posicoesYdasPecas[k] = nodos[k].getPonto(0).y;
			posicoesXdasPecasSelecionadas[k] = LIMBO;
			posicoesYdasPecasSelecionadas[k] = LIMBO;
		}

		pack();
		setSize(769 + getInsets().left + getInsets().right, 531 + getInsets().top + getInsets().bottom);
		setLocationRelativeTo(null);
		this.setVisible(true);

		// Limpa a janela em caso de reinício
		this.repaint();
	}

	public void adicionaListener () {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evento){
				fechar();			
			}
		});
	}
	
	private void fechar() {
		dispose();
		this.menuPrincipal.exibir();
	}

	// classe interna responsável por desenhar e modificar as figuras
	private class Graficos extends JPanel {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = -8035590711617803982L;
		
		private byte selecionado = -1;
		private int xMarcaTurno = LIMBO,
					yMarcaTurno = LIMBO;

		private int[] xMarcaVitoria;
		private int[] yMarcaVitoria;

		public Graficos () {
			super();

			xMarcaVitoria = new int[4];
			yMarcaVitoria = new int[4];

			xMarcaVitoria[0] = LIMBO;
			yMarcaVitoria[0] = LIMBO;
			xMarcaVitoria[1] = LIMBO;
			yMarcaVitoria[1] = LIMBO;
			xMarcaVitoria[2] = LIMBO;
			yMarcaVitoria[2] = LIMBO;
			xMarcaVitoria[3] = LIMBO;
			yMarcaVitoria[3] = LIMBO;
		}

		// pinta as várias partes que formam o todo
		public void paintComponent (Graphics g) {
			super.paintComponent(g);

			tabuleiro.paintIcon(this,g,0,0);
			marcaTurno.paintIcon(this,g,xMarcaTurno,yMarcaTurno);
			botaoQuarto.paintIcon(this,g,15,359);

			g.setColor(Color.WHITE);
			g.setFont(new Font("SansSerif",Font.PLAIN,20));
			g.drawString((jogo.getJogador1()).getNome() + " (" + (jogo.getJogador1()).getVitorias() + ")",31,28);
			g.drawString((jogo.getJogador2()).getNome() + " (" + (jogo.getJogador2()).getVitorias() + ")",31,73);

			for (byte k = 0; k < 4; k++) {
				marcasVitoria[k].paintIcon(this,g,xMarcaVitoria[k],yMarcaVitoria[k]);
			}

			for (byte k = 0; k < pecas.length; k++) {
				pecas[k].paintIcon(this,g,posicoesXdasPecas[k],posicoesYdasPecas[k]);
				pecasSelecionadas[k].paintIcon(this,g,posicoesXdasPecasSelecionadas[k],posicoesYdasPecasSelecionadas[k]);
			}
		}

		// retira a seleção de uma peça selecionada
		public void desmarcaPecaCaixa (byte indice) {
			posicoesXdasPecasSelecionadas[indice] = LIMBO;
			posicoesYdasPecasSelecionadas[indice] = LIMBO;
			repaint();
		}

		// marca uma peça da caixa como selecionada
		public void marcaPecaCaixa (byte indice) {
			posicoesXdasPecasSelecionadas[indice] = posicoesXdasPecas[indice];
			posicoesYdasPecasSelecionadas[indice] = posicoesYdasPecas[indice];
			selecionado = indice;
			repaint();
		}

		// desenha a peça sugerida no local apropriado
		public void desenhaPecaSugerida () {
			posicoesXdasPecasSelecionadas[selecionado] = LIMBO;
			posicoesYdasPecasSelecionadas[selecionado] = LIMBO;
			posicoesXdasPecas[selecionado] = 64;
			posicoesYdasPecas[selecionado] = 169;
			repaint();
		}

		// desenha a peça no tabuleiro na posição em que foi jogada
		public void desenhaPecaJogada (byte linha, byte coluna) {
			posicoesXdasPecas[selecionado] = pontosDoTabuleiro[linha][coluna].x + 22;
			posicoesYdasPecas[selecionado] = pontosDoTabuleiro[linha][coluna].y - 42;
			selecionado = -1;
			repaint();
		}

		// desenha a marca de turno na posição certa
		public void desenhaMarcaTurno (int x, int y) {
			xMarcaTurno = x;
			yMarcaTurno = y;
			repaint();
		}

		// destaca as peças de uma fila
		public void circulaPeca (byte linha, byte coluna, byte num) {
			xMarcaVitoria[num] = pontosDoTabuleiro[linha][coluna].x;
			yMarcaVitoria[num] = pontosDoTabuleiro[linha][coluna].y;

			repaint();	
		}
	}
}