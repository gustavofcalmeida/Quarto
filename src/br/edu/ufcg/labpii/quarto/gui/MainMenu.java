package br.edu.ufcg.labpii.quarto.gui;
/*
 * UFCG - Universidade Federal de Campina Grande
 * DSC - Departamento de Sistemas e Computação
 * Disciplina: Laboratório de Programação II
 * Projeto: Quarto!
 */

import java.awt.*;
import javax.swing.*;

import br.edu.ufcg.labpii.quarto.util.ImageLoader;

import java.awt.event.*;

/**
 * Classe que cria a janela do menu principal 
 * @version 1.0
 * @author Demetrio Gomes Mestre - 20311032
 * @author Gustavo de Farias Costa - 20311393
 * @author Helton Souza Lima - 20311010
 * @author Lucas Albertins de Lima - 20311022
 * @author Pablo Diego Batista de Almeira - 20311033
 * @author Willames Carlos Magalhães Ribeiro - 20311026
 */
public class MainMenu extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5648653896518037268L;
	
	private JLabel titulo;
	private JRadioButton umJogador,
						 doisJogadores;
	private JButton ok,
					comoJogar,
					creditos,
					sair;

	private ImageIcon figuraTitulo   = ImageLoader.getImagem("title.png");
	private ImageIcon figuraTipo1    = ImageLoader.getImagem("gameType1.gif");
	private ImageIcon figuraTipo2    = ImageLoader.getImagem("gameType2.gif");
	private ImageIcon figuraTutorial = ImageLoader.getImagem("tutorial.png");
	private ImageIcon figuraCreditos = ImageLoader.getImagem("credits.png");

	private PlayersMenu menuJogadores;

	/**
	 * Construtor do menu principal
	 * @param flag objeto boolean usado no controle de fluxo
	 * @param tipoDeJogo objeto byte usado para armazenar o tipo de jogo
	 */
	public MainMenu () {

		super(java.util.ResourceBundle.getBundle("br/edu/ufcg/labpii/quarto/local_strings").getString("MP_Menu_principal"));

		menuJogadores = new PlayersMenu();
		setMenuJogadores();

		Container janela = getContentPane();
		janela.setLayout(new FlowLayout());

//******************************************************************************

		titulo = new JLabel();
		titulo.setText(java.util.ResourceBundle.getBundle("br/edu/ufcg/labpii/quarto/local_strings").getString("MP_Escolha_uma_opcao"));
		titulo.setIcon(figuraTitulo);
		titulo.setFont(new Font("Serif",Font.PLAIN,20));
		titulo.setHorizontalTextPosition(SwingConstants.CENTER);
		titulo.setVerticalTextPosition(SwingConstants.BOTTOM);

		janela.add(titulo);

//******************************************************************************

		umJogador     = new JRadioButton(java.util.ResourceBundle.getBundle("br/edu/ufcg/labpii/quarto/local_strings").getString("MP_Jogador_vs_CPU"),figuraTipo1);
		doisJogadores = new JRadioButton(java.util.ResourceBundle.getBundle("br/edu/ufcg/labpii/quarto/local_strings").getString("MP_Multiplayer"),figuraTipo2);

		umJogador.setFont    (new Font("Serif",Font.PLAIN,17));
		doisJogadores.setFont(new Font("Serif",Font.PLAIN,17));

		JPanel painelOpcoes = new JPanel(new GridLayout(2,1));
		painelOpcoes.add(umJogador);
		painelOpcoes.add(doisJogadores);

		ButtonGroup botoes = new ButtonGroup();
		botoes.add(umJogador);
		botoes.add(doisJogadores);

		umJogador.setSelected(true);

		janela.add(painelOpcoes);

//******************************************************************************

		ok        = new JButton(java.util.ResourceBundle.getBundle("br/edu/ufcg/labpii/quarto/local_strings").getString("MP_OK"));
		comoJogar = new JButton(java.util.ResourceBundle.getBundle("br/edu/ufcg/labpii/quarto/local_strings").getString("MP_Como_jogar"));
		creditos  = new JButton(java.util.ResourceBundle.getBundle("br/edu/ufcg/labpii/quarto/local_strings").getString("MP_Sobre_Quarto"));
		sair      = new JButton(java.util.ResourceBundle.getBundle("br/edu/ufcg/labpii/quarto/local_strings").getString("MP_Sair"));

		ok.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent evento) {
				performMenuJogadores();
			}
        });

		comoJogar.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent evento) {

				String text = java.util.ResourceBundle.getBundle("br/edu/ufcg/labpii/quarto/local_help").getString("help_text");

				JTextArea areaTexto = new JTextArea( text, 23, 80);
				areaTexto.setFont(new Font("Monospaced", Font.PLAIN, 12));
				areaTexto.setEditable(false);
				JScrollPane scrollPane = new JScrollPane(areaTexto);

				JOptionPane.showMessageDialog(MainMenu.this,
											  scrollPane,
											  java.util.ResourceBundle.getBundle("br/edu/ufcg/labpii/quarto/local_strings").getString("MP_Como_jogar2"),
											  JOptionPane.PLAIN_MESSAGE,
											  figuraTutorial);
			}
        });

		creditos.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent evento) {
				String text = java.util.ResourceBundle.getBundle("br/edu/ufcg/labpii/quarto/local_about").getString("about_text");
				
				JOptionPane.showMessageDialog(MainMenu.this, text, java.util.ResourceBundle.getBundle("br/edu/ufcg/labpii/quarto/local_strings").getString("MP_Sobre_Quarto2"),JOptionPane.PLAIN_MESSAGE,figuraCreditos);
			}
        });

		sair.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent evento) {
				System.exit(0);
			}
        });

		JPanel painelBotoes = new JPanel(new GridLayout(2,3,10,20));
		painelBotoes.add(new JPanel());
		painelBotoes.add(ok);
		painelBotoes.add(new JPanel());
		painelBotoes.add(comoJogar);
		painelBotoes.add(creditos);
		painelBotoes.add(sair);

		janela.add(painelBotoes);

//******************************************************************************

		addWindowListener(new WindowAdapter() {
			public void windowClosing (WindowEvent evento) {
				System.exit(0);
			}
		});

		ImageIcon i = ImageLoader.getImagem("icon.png");
		setIconImage(i.getImage());

		setResizable(false);
		setSize(443,368);
		this.exibir();
	}
	
	public void exibir() {
		getRootPane().setDefaultButton(ok);
		this.umJogador.setSelected(true);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	protected void performMenuJogadores() {
		this.setVisible(false);
		
		if (this.umJogador.isSelected()) {
			this.menuJogadores.exibir(PlayersMenu.UM_JOGADOR);
		}
		else if (this.doisJogadores.isSelected()) {
			this.menuJogadores.exibir(PlayersMenu.MULTIPLAYER);
		}
	}

	private void setMenuJogadores () {
		menuJogadores.setMenuPrincipal(this);
	}

	public void iniciaJogo(String nome1, String nome2) {
		this.dispose();
		
		if (this.umJogador.isSelected()) {
			new CPUGame(nome1, this);
		}
		else if (this.doisJogadores.isSelected()) {
			new HumanGame(nome1, nome2, this);
		}
	}
}