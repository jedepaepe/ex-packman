package eu.epfc.c5255.packman;

import processing.core.PApplet;

/**
 * Classe principale de l'application
 */
public class App extends PApplet {
	/**
	 * référence sur le damier
	 */
	public Panel panel;

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
		// instancie le damier en passant une référence sur le PApplet pour pouvoir dessiner
		panel = new Panel(this);

		// change la taille de la fenêtre
		size(panel.getWidth(), panel.getHeight());
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

		// dessine le damier
		panel.draw();
	}

	/**
	 * calcule la nouvelle position de packman
	 */
	@Override
	public void keyPressed () {
		// dépendant la touche clavier enfoncée
		switch (keyCode) {
		case UP:
			panel.packman.moveUp(panel.nrCells);
			break;
		case RIGHT:
			panel.packman.moveRigh(panel.nrCells);
			break;
		case DOWN:
			panel.packman.moveDown(panel.nrCells);;
			break;
		case LEFT:
			panel.packman.moveLeft(panel.nrCells);
			break;
		}
	}
}
