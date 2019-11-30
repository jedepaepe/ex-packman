package eu.epfc.c5255.packman;

// utilise la classe processing PApplet
import processing.core.PApplet;

/**
 * Damier du jeu packman
 */
public class PackPanel {
	/**
	 * taille de la marge ne pixels
	 */
	public int margin = 25;
	
	/**
	 * nombre de cellules par damier
	 */
	public int nrCells = 29;
	
	/**
	 * taille des cellules
	 */
	public int nrPixelsPerCell = 21;
	
	/**
	 * personnage packman
	 */
	public Packman packman = new Packman();
	
	/**
	 * dessine le damier
	 * @param pApplet est le PApplet sur lequel le damier doit être dessiné 
	 */
	public void draw (PApplet pApplet) {
		// couleur de fond noir
		pApplet.background(0);
		
		// pinceau de trait mauve
		pApplet.stroke(128, 0, 255);
		
		// dessine le damier
		for (int i = 0; i <= nrCells; ++i) {
			// ligne horizontale
			pApplet.line(margin, margin + i * nrPixelsPerCell, margin + nrCells * nrPixelsPerCell, margin + i * nrPixelsPerCell);
			// ligne verticale
			pApplet.line(margin + i *nrPixelsPerCell, margin, margin + i * nrPixelsPerCell, margin + nrCells * nrPixelsPerCell);
		}
		
		// dessine packman
		packman.draw(pApplet, getXOfCell(packman.x), getYOfCell(packman.y));
	}
	
	public void keyPresset(PApplet pApplet) {
		// dépendant la touche clavier enfoncée
		switch (pApplet.keyCode) {
		case PApplet.UP:
			packman.moveUp();
			break;
		case PApplet.RIGHT:
			packman.moveRight();
			break;
		case PApplet.DOWN:
			packman.moveDown();
			break;
		case PApplet.LEFT:
			packman.moveLeft();
			break;
		}
	}
	
	/**
	 * calcule et retourne l'absisse X du centre de la cellule
	 * @param cellXIndex est l'index X de la cellule
	 * @return retourne l'absisse X du centre de la cellule
	 */
	public int getXOfCell (int cellXIndex) {
		// ramène l'index entre ]-nrCells, nrCell[
		cellXIndex %= nrCells;
		// ramène l'index entre [0, nrCell[
		if (cellXIndex < 0) cellXIndex += nrCells;
		
		return (int) (margin + (cellXIndex + 0.5F) * nrPixelsPerCell);
	}
	
	/**
	 * calcule et retourne la coordonnée Y du centre de la cellule
	 * @param cellXIndex est l'index Y de la cellule
	 * @return retourne la coordonnée Y du centre de la cellule
	 */
	public int getYOfCell (int cellYIndex) {
		return getXOfCell(cellYIndex);
	}
	
	/**
	 * @return la taille du panel (largeur = longueur) en pixels
	 */
	public int getSize () {
		return nrCells * nrPixelsPerCell + 2 * margin;
	}
}
