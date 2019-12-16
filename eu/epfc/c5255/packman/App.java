package eu.epfc.c5255.packman;

import processing.core.PApplet;

/**
 * Classe principale de l'application
 */
public class App extends PApplet {
	public static App app = null;
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
		App.app = this;
		
		/**
		 * la taille de la fenêtre est:
		 * largeur = marge + nr_de_cellules * taille_de_la_cellule + marge
		 * hauteur = marge + nr_de_cellules * taille_de_la_cellule + marge
		 */
		size(panel.nrCells * panel.cellSize + 2 * panel.margin, panel.nrCells * panel.cellSize + 2 * panel.margin);
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
		for (int i = 0; i <= panel.nrCells; ++i) {
			// ligne horizontale
			line(panel.margin, panel.margin + i * panel.cellSize, panel.margin + panel.nrCells * panel.cellSize, panel.margin + i * panel.cellSize);
			// ligne verticale
			line(panel.margin + i * panel.cellSize, panel.margin, panel.margin + i * panel.cellSize, panel.margin + panel.nrCells * panel.cellSize);
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
			panel.packman.y = --panel.packman.y % panel.nrCells;
			break;
		case RIGHT:
			panel.packman.x = ++panel.packman.x % panel.nrCells;
			break;
		case DOWN:
			panel.packman.y = ++panel.packman.y % panel.nrCells;
			break;
		case LEFT:
			panel.packman.x = --panel.packman.x % panel.nrCells;
			break;
		}
		// appliquer une translation de nrCells si négatif
		if (panel.packman.x < 0) panel.packman.x += panel.nrCells;
		if (panel.packman.y < 0) panel.packman.y += panel.nrCells;
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
