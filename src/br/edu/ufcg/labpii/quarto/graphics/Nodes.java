package br.edu.ufcg.labpii.quarto.graphics;

 	    	   
/**
 * Interface que contém todos os nodos a serem criados
 * @version 1.0
 * @author Demetrio Gomes Mestre - 20311032
 * @author Gustavo de Farias Costa - 20311393
 * @author Helton Souza Lima - 20311010
 * @author Lucas Albertins de Lima - 20311022
 * @author Pablo Diego Batista de Almeira - 20311033
 * @author Willames Carlos Magalhães Ribeiro - 20311026
 */
public interface Nodes extends Points {

	// constante com os nodos da caixa de peças
	public static final ImageNode[] nodos = {
		new ImageNode(pontos1),
		new ImageNode(pontos2),
		new ImageNode(pontos3), 
		new ImageNode(pontos4),
		new ImageNode(pontos5), 
		new ImageNode(pontos6),
		new ImageNode(pontos7), 
		new ImageNode(pontos8),
		new ImageNode(pontos9), 
		new ImageNode(pontos10),
		new ImageNode(pontos11),
		new ImageNode(pontos12),
		new ImageNode(pontos13),
		new ImageNode(pontos14),
		new ImageNode(pontos15),
		new ImageNode(pontos16)
	};

	// constante com os nodos do tabuleiro 
	public static final BoardNode[] nodosTabuleiro = {
		new BoardNode(pontos1Tab, (byte)0, (byte)0),
		new BoardNode(pontos2Tab, (byte)0, (byte)1),
		new BoardNode(pontos3Tab, (byte)0, (byte)2),
		new BoardNode(pontos4Tab, (byte)0, (byte)3),
		new BoardNode(pontos5Tab, (byte)1, (byte)0),
		new BoardNode(pontos6Tab, (byte)1, (byte)1),
		new BoardNode(pontos7Tab, (byte)1, (byte)2),
		new BoardNode(pontos8Tab, (byte)1, (byte)3),
		new BoardNode(pontos9Tab, (byte)2, (byte)0),
		new BoardNode(pontos10Tab,(byte)2, (byte)1),
		new BoardNode(pontos11Tab,(byte)2, (byte)2),
		new BoardNode(pontos12Tab,(byte)2, (byte)3),
		new BoardNode(pontos13Tab,(byte)3, (byte)0),
		new BoardNode(pontos14Tab,(byte)3, (byte)1),
		new BoardNode(pontos15Tab,(byte)3, (byte)2),
		new BoardNode(pontos16Tab,(byte)3, (byte)3)
	};

	// constante com o nodo da região da peça sugerida
	public static final ImageNode nodoPecaSugerida = new ImageNode(pontosPecaSugerida);

	// constante para o botão quarto
	public static final ImageNode nodoQuarto = new ImageNode(pontosQuarto);
}