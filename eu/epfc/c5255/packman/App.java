package eu.epfc.c5255.packman;

import processing.core.PApplet;

/**
 * Classe principale de l'application
 */
public class App extends PApplet {
	/**
	 * référence sur le damier
	 */
	private Panel panel = null;

	/**
	 * référence sur le tableau de bord
	 */
	private DashBoard dashboard = null;

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

		// instancie le dashboard
		dashboard = new DashBoard(this, 0, panel.getHeight());

		// change la taille de la fenêtre
		size(panel.getWidth(), panel.getHeight() + dashboard.getHeigth());
	}

	/**
	 * dessine l'image de base
	 */
	@Override
	public void setup () {
		frameRate(4);
	}

	@Override
	public void draw () {
		// couleur de fond noir
		background(0);

		// dessine le damier
		panel.draw();

		// met à jour le score
		dashboard.setScore(panel.getScore());
		System.out.println(dashboard.getScore());

		// dessine le dashboard
		dashboard.draw();
	}

	/**
	 * calcule la nouvelle position de packman
	 */
	@Override
	public void keyPressed () {
		panel.keyPressed();
	}
}
