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
	static int nrCells = 29;

	/**
	 * taille des cellules
	 */
	static int nrPixelPerCell = 21;

	/**
	 * taille de packman
	 */
	static int packmanDiameter = (int) (nrPixelPerCell * 1.1);

	/**
	 * absisse (x) de packman (premiére cellule = 0)
	 */
	static int packmanX = nrCells / 2;

	/**
	 * coordonnée (y) de packman (premiére cellule = 0)
	 */
	static int packmanY = 10;

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
		 * la taille de la fenètre est:
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
	}

	@Override
	public void draw () {
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

		drawPackman();
	}

	/**
	 * calcule la nouvelle position de packman
	 */
	@Override
	public void keyPressed () {
		// dépendant la touche clavier enfoncée
		switch (keyCode) {
		case UP:
			packmanY = --packmanY % nrCells;
			break;
		case RIGHT:
			packmanX = ++packmanX % nrCells;
			break;
		case DOWN:
			packmanY = ++packmanY % nrCells;
			break;
		case LEFT:
			packmanX = --packmanX % nrCells;
			break;
		}
		// appliquer une translation de nrCells si négatif
		if (packmanX < 0) packmanX +=nrCells;
		if (packmanY < 0) packmanY +=nrCells;
	}

	/**
	 * dessine packman
	 */
	public void drawPackman () {
		// pas de trait
		noStroke();

		// pinceau de remplissage jaune
		fill(255, 255, 0);

		// dessine packman
		ellipse(margin + (packmanX + 0.5F) * nrPixelPerCell, margin + (packmanY + 0.5F) * nrPixelPerCell, packmanDiameter, packmanDiameter);
	}
}
