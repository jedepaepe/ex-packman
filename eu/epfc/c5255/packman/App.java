package eu.epfc.c5255.packman;

import processing.core.PApplet;

/**
 * Classe principale de l'application
 */
public class App extends PApplet {
	/**
	 * champ global nécessaire pour dessiner
	 */
	static public App app = null;

	/**
	 * référence sur le damier
	 */
	public Panel panel = new Panel();

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
		// initialisation de l'App
		app = this;

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

		// dessine packman
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

	/**
	 * dessine packman
	 */
	public void drawPackman () {
		// pas de trait
		noStroke();

		// pinceau de remplissage jaune
		fill(255, 255, 0);

		// dessine packman
		ellipse(
				panel.margin + (panel.packman.x + 0.5F) * panel.cellSize,
				panel.margin + (panel.packman.y + 0.5F) * panel.cellSize,
				panel.packman.diameter, panel.packman.diameter);
	}
}
