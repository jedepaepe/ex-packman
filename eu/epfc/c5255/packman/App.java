package eu.epfc.c5255.packman;

import processing.core.PApplet;

/**
 * Classe principale de l'application
 */
public class App extends PApplet {
	/**
	 * taille de la marge ne pixels
	 */
	static int margin = 25;
	
	/**
	 * nombre de cellules par damier
	 */
	static int nrCells = 28;
	
	/**
	 * taille des cellules
	 */
	static int nrPixelPerCell = 21;

	/**
	 * point d'entrée du programme
	 * @param args sont les arguments passés par la ligne de commande
	 */
	public static void main(String[] args) {
		// démarre le moteur Processing (la GUI)
		PApplet.main(App.class.getName());
	}
	
	/**
	 * configure l'application
	 */
	@Override
	public void settings () {
		/**
		 * la taille de la fenêtre est:
		 * largeur = marge + nr_de_cellules * taille_de_la_cellule + marge
		 * hauteur = marge + nr_de_cellules * taille_de_la_cellule + marge
		 */
		size(nrCells * nrPixelPerCell + 2 * margin, nrCells * nrPixelPerCell + 2 * margin);
	}
	
	/**
	 * dessine l'image de base
	 */
	@Override
	public void setup () {
		// couleur de fond noir
		background(0);
		// pinceau de trait mauve
		stroke(128, 0, 255);
		// dessine le damier
		for (int i = 0; i <= nrCells; ++i) {
			// ligne horizontale
			line(margin, margin + i * nrPixelPerCell, margin + nrCells * nrPixelPerCell, margin + i * nrPixelPerCell);
			// ligne verticale
			line(margin + i * nrPixelPerCell, margin, margin + i * nrPixelPerCell, margin + nrCells * nrPixelPerCell);
		}
	}
	
	@Override
	public void draw () {
		
	}

}
