package br.edu.ufcg.labpii.quarto.gui;
/*
 * UFCG - Universidade Federal de Campina Grande
 * DSC - Departamento de Sistemas e Computação
 * Disciplina: Laboratório de Programação II
 * Projeto: Quarto!
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import br.edu.ufcg.labpii.quarto.util.ImageLoader;

/**
 * Classe que constrói um menu para adicionar os nomes dos jogadores do jogo Quarto!
 * @version 1.0
 * @author Demetrio Gomes Mestre - 20311032
 * @author Gustavo de Farias Costa - 20311393
 * @author Helton Souza Lima - 20311010
 * @author Lucas Albertins de Lima - 20311022
 * @author Pablo Diego Batista de Almeira - 20311033
 * @author Willames Carlos Magalhães Ribeiro - 20311026
 */
public class PlayersMenu extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3242691737943830047L;

	public static final int UM_JOGADOR = 1;

	public static final int MULTIPLAYER = 2;
	
	// atributos
	private JTextField nomeJogador1, nomeJogador2;
	private JLabel player1, player2;
	private String jogador1, jogador2;
	private JButton botaoOK;
	private MainMenu menuPrincipal;

	/**
	 * Construtor do menu onde se coloca os nomes dos jogadores
	 * @param flag a flag de execução do MAIN
	 */
	public PlayersMenu() {
		super(java.util.ResourceBundle.getBundle("br/edu/ufcg/labpii/quarto/local_strings").getString("MJ_Entre_com_o_nome_dos_jogadores"));

		// cria o container
		Container container = getContentPane();
		container.setLayout(new FlowLayout());	

		// cria os campos de texto
		nomeJogador1 = new JTextField(20);
		nomeJogador2 = new JTextField(20);
		player1 = new JLabel(java.util.ResourceBundle.getBundle("br/edu/ufcg/labpii/quarto/local_strings").getString("MJ_Jogador_1"));
		player2 = new JLabel(java.util.ResourceBundle.getBundle("br/edu/ufcg/labpii/quarto/local_strings").getString("MJ_Jogador_2"));

		JPanel painel1 = new JPanel();
		painel1.add(player1);
		painel1.add(nomeJogador1);

		JPanel painel2 = new JPanel();
		painel2.add(player2);
		painel2.add(nomeJogador2);

		// cria um botao Ok e inicializa os atributos
		botaoOK = new JButton(java.util.ResourceBundle.getBundle("br/edu/ufcg/labpii/quarto/local_strings").getString("MJ_OK"));
		jogador1 = "";
		jogador2 = "";
		
		Box caixa = Box.createVerticalBox();

		caixa.add(Box.createVerticalStrut(2));
		caixa.add(painel1);
		caixa.add(Box.createVerticalStrut(4));
		caixa.add(painel2);
		caixa.add(Box.createVerticalStrut(10));
		caixa.add(botaoOK);

		container.add(caixa);

		// Listener do botao
		botaoOK.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent evento) {

				// se nao digitar nada seta como default jogador 1
				if (nomeJogador1.getText().trim().equals("")) {
					jogador1 = java.util.ResourceBundle.getBundle("br/edu/ufcg/labpii/quarto/local_strings").getString("MJ_Jogador_12");
				}	
				else {
					jogador1 = nomeJogador1.getText().trim();
				}
				
				// se nao digitar nada seta como default jogador 2
				if (nomeJogador2.getText().trim().equals("")) {
					jogador2 = java.util.ResourceBundle.getBundle("br/edu/ufcg/labpii/quarto/local_strings").getString("MJ_Jogador_22");
				}
				else {
					jogador2 = nomeJogador2.getText().trim();
				}

				dispose();
				menuPrincipal.iniciaJogo(getNome1(), getNome2());
			}
		});

		// seta configuracoes de fechamento de janela
		addWindowListener(new WindowAdapter() {
			public void windowClosing (WindowEvent evento) {
				setVisible(false);
				menuPrincipal.exibir();
			}
		});

		// seta configuracoes do frame
		ImageIcon i = ImageLoader.getImagem("icon.png");
		setIconImage(i.getImage());

		setResizable(false);
		setSize(335,154);
		setLocationRelativeTo(null);
	}

	public void setMenuPrincipal (MainMenu mp) {
		menuPrincipal = mp;
	}
		
	/**
	 * Método para o campo do nome do jogador 2 não ser editável
	 */
	public void jogador2SemNome() {
		nomeJogador2.setEditable(false);
		nomeJogador2.setFocusable(false);
	}

	/**
	 * Método para o campo do nome do jogador 2 ser editável
	 */
	public void jogador2ComNome() {
		nomeJogador2.setEditable(true);
		nomeJogador2.setFocusable(true);
	}
	
	/**
	 * Método para retornar o nome do jogador 1
	 * @return o nome do jogador 1	 
	 */
	private String getNome1() {
		if (jogador1.length() > 23) {
			return jogador1.substring(0,23).trim();
		}
		return jogador1;
	}
	
	/**
	 * Método para retornar o nome do jogador 2
	 * @return o nome do jogador 2	 
	 */
	private String getNome2() {
		if (jogador2.length() > 23) {
			return jogador2.substring(0,23).trim();
		}
		return jogador2;
	}

	public void exibir(int modo) {
		getRootPane().setDefaultButton(botaoOK);

		this.nomeJogador1.setText("");
		this.nomeJogador2.setText("");
		this.setLocationRelativeTo(null);
		
		if (modo == PlayersMenu.UM_JOGADOR) {
			this.jogador2SemNome();
		}
		else if (modo == PlayersMenu.MULTIPLAYER) {
			this.jogador2ComNome();
		}
		this.setVisible(true);
	}	
}