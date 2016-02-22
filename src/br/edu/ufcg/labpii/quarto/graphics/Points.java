package br.edu.ufcg.labpii.quarto.graphics;

import br.edu.ufcg.labpii.quarto.util.Point2D;
/*
 * UFCG - Universidade Federal de Campina Grande
 * DSC - Departamento de Sistemas e Computação
 * Disciplina: Laboratório de Programação II
 * Projeto: Quarto!
 */
 	    	   
/**
 * Interface que contém os pontos que serão usados para mapear as imagens quando o usuário clicar
 * @version 1.0
 * @author Demetrio Gomes Mestre - 20311032
 * @author Gustavo de Farias Costa - 20311393
 * @author Helton Souza Lima - 20311010
 * @author Lucas Albertins de Lima - 20311022
 * @author Pablo Diego Batista de Almeira - 20311033
 * @author Willames Carlos Magalhães Ribeiro - 20311026
 */
public interface Points {

	// caixa de peças
	public static final int x1 = 596;
	public static final int x2 = x1 + 33;
	public static final int x3 = x2 + 2;
	public static final int x4 = x3 + 33;
	public static final int x5 = x4 + 2;
	public static final int x6 = x5 + 33;
	public static final int x7 = x6 + 2;
	public static final int x8 = x7 + 33;

    // caixa de peças
	public static final int y1 = 85;
	public static final int y2 = y1 + 89;
	public static final int y3 = y2 + 2;
	public static final int y4 = y3 + 89;
	public static final int y5 = y4 + 2;
	public static final int y6 = y5 + 89;
	public static final int y7 = y6 + 2;
	public static final int y8 = y7 + 89;

	// caixa de peças
	public static final Point2D[] pontos1  = {new Point2D(x1, y1), new Point2D(x2, y2)};
	public static final Point2D[] pontos2  = {new Point2D(x3, y1), new Point2D(x4, y2)};
	public static final Point2D[] pontos3  = {new Point2D(x5, y1), new Point2D(x6, y2)};
	public static final Point2D[] pontos4  = {new Point2D(x7, y1), new Point2D(x8, y2)};
	public static final Point2D[] pontos5  = {new Point2D(x1, y3), new Point2D(x2, y4)};
	public static final Point2D[] pontos6  = {new Point2D(x3, y3), new Point2D(x4, y4)};
	public static final Point2D[] pontos7  = {new Point2D(x5, y3), new Point2D(x6, y4)};
	public static final Point2D[] pontos8  = {new Point2D(x7, y3), new Point2D(x8, y4)};
	public static final Point2D[] pontos9  = {new Point2D(x1, y5), new Point2D(x2, y6)};
	public static final Point2D[] pontos10 = {new Point2D(x3, y5), new Point2D(x4, y6)};
	public static final Point2D[] pontos11 = {new Point2D(x5, y5), new Point2D(x6, y6)};
	public static final Point2D[] pontos12 = {new Point2D(x7, y5), new Point2D(x8, y6)};
	public static final Point2D[] pontos13 = {new Point2D(x1, y7), new Point2D(x2, y8)};
	public static final Point2D[] pontos14 = {new Point2D(x3, y7), new Point2D(x4, y8)};
	public static final Point2D[] pontos15 = {new Point2D(x5, y7), new Point2D(x6, y8)};
	public static final Point2D[] pontos16 = {new Point2D(x7, y7), new Point2D(x8, y8)};

    // tabuleiro
	public static final int X1 = 175;
	public static final int X2 = X1 + 77;
	public static final int X3 = X2 + 14;
	public static final int X4 = X3 + 77;
	public static final int X5 = X4 + 14;
	public static final int X6 = X5 + 77;
	public static final int X7 = X6 + 14;
	public static final int X8 = X7 + 77;

	// tabuleiro
	public static final int Y1 = 153;
	public static final int Y2 = Y1 + 77;
	public static final int Y3 = Y2 + 14;
	public static final int Y4 = Y3 + 77;
	public static final int Y5 = Y4 + 14;
	public static final int Y6 = Y5 + 77;
	public static final int Y7 = Y6 + 14;
	public static final int Y8 = Y7 + 77;
	
	// tabuleiro
	public static final Point2D[] pontos1Tab  = {new Point2D(X1, Y1), new Point2D(X2, Y2)};
	public static final Point2D[] pontos2Tab  = {new Point2D(X3, Y1), new Point2D(X4, Y2)};
	public static final Point2D[] pontos3Tab  = {new Point2D(X5, Y1), new Point2D(X6, Y2)};
	public static final Point2D[] pontos4Tab  = {new Point2D(X7, Y1), new Point2D(X8, Y2)};
	public static final Point2D[] pontos5Tab  = {new Point2D(X1, Y3), new Point2D(X2, Y4)};
	public static final Point2D[] pontos6Tab  = {new Point2D(X3, Y3), new Point2D(X4, Y4)};
	public static final Point2D[] pontos7Tab  = {new Point2D(X5, Y3), new Point2D(X6, Y4)};
	public static final Point2D[] pontos8Tab  = {new Point2D(X7, Y3), new Point2D(X8, Y4)};
	public static final Point2D[] pontos9Tab  = {new Point2D(X1, Y5), new Point2D(X2, Y6)};
	public static final Point2D[] pontos10Tab = {new Point2D(X3, Y5), new Point2D(X4, Y6)};
	public static final Point2D[] pontos11Tab = {new Point2D(X5, Y5), new Point2D(X6, Y6)};
	public static final Point2D[] pontos12Tab = {new Point2D(X7, Y5), new Point2D(X8, Y6)};
	public static final Point2D[] pontos13Tab = {new Point2D(X1, Y7), new Point2D(X2, Y8)};
	public static final Point2D[] pontos14Tab = {new Point2D(X3, Y7), new Point2D(X4, Y8)};
	public static final Point2D[] pontos15Tab = {new Point2D(X5, Y7), new Point2D(X6, Y8)};
	public static final Point2D[] pontos16Tab = {new Point2D(X7, Y7), new Point2D(X8, Y8)};

	// peca sugerida
	public static final Point2D[] pontosPecaSugerida = {new Point2D(42, 211), new Point2D(119, 288)};

    // botao quarto
	public static final Point2D[] pontosQuarto = {new Point2D(15, 359), new Point2D(146, 410)};
}