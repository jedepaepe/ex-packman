package eu.epfc.c5255.packman;

//utilise la classe processing PApplet
import processing.core.PApplet;

/**
 * Le personnage packman
 */
public class Packman {
	/**
	 * diametre de packman en % de la taille d'une cellule 
	 */
	public float diameter = 1.1F * 21;
	
	/**
	 * absisse de packman (index x de la cellule o� se trouve packman)
	 */
	public int x = 14;
	
	/**
	 * coordonnee de packman (index y de la cellule o� se trouve packman)
	 */
	public int y = 14;
	
	/**
	 * dessine packman
	 * @param pApplet est le PApplet sur lequel packman doit �tre dessiner
	 * @param pixelX est l'absisse du centre de packman
	 * @param pixelY est la coordonn�e du centre de pakman
	 */
	public void draw (PApplet pApplet, int pixelX, int pixelY) {
		// pas de trait
		pApplet.noStroke();
		
		// pinceau de remplissage jaune
		pApplet.fill(255, 255, 0);
		
		// dessine packman
		pApplet.ellipse(pixelX, pixelY, diameter, diameter);
	}
	
	public void moveUp () {
		--y;
	}
	
	public void moveRight () {
		++x;
	}
	
	public void moveDown () {
		++y;
	}
	
	public void moveLeft () {
		--x;
	}
}
