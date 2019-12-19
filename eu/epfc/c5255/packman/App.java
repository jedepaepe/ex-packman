package eu.epfc.c5255.packman;

import processing.core.PApplet;

/**
 * Classe principale de l'application
 */
public class App extends PApplet {
	public Panel panel = new Panel();
	
	/**
	 * point d'entr�e du programme
	 * @param args sont les arguments pass�s par la ligne de commande
	 */
	public static void main(String[] args) {
		// d�marre le moteur Processing (la GUI)
		PApplet.main(App.class.getName());
	}
	
	/**
	 * configure l'application
	 */
	@Override
	public void settings () {
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
		// d�pendant la touche clavier enfonc�e
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
