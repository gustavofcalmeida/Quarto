package br.edu.ufcg.labpii.quarto.util;

import javax.swing.ImageIcon;

public class ImageLoader {
	
	private static final String RESOURCE_PATH = "br/edu/ufcg/labpii/quarto/pics/";
	
	/**
	 * Obtém uma imagem que está como um recurso
	 * dentro das pastas de código fonte.
	 * @param nome o nome do arquivo de imagem.
	 * @return A imagem.
	 */
	public static ImageIcon getImagem( String nome ) {
		return new ImageIcon( ImageLoader.class.getClassLoader().getResource( ImageLoader.RESOURCE_PATH + nome ) );
	}
}