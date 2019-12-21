package eu.epfc.c5255.packman;

import processing.core.PApplet;

public class Packman {
	/**
	 * référence sur le PApplet pour dessiner
	 */
	private PApplet painter = null;

	/**
	 * taille de packman
	 */
	private int diameter = 23;

	/**
	 * index de la ligne où se trouve packman (r: row)
	 */
	private int rIndex = 10;

	/**
	 * index de la colonne où se trouve packman
	 */
	private int cIndex = 15;

	/**
	 * Contructeur de Packman
	 * @param painter est une référence sur PApplet pour peindre
	 */
	public Packman(PApplet painter) {
		// initialise le champs painter
		this.painter = painter;
	}

	/**
	 * @return l'indexe de la colonne où se trouve Packman
	 */
	public int getCIndex() {
		return cIndex;
	}

	/**
	 * @return l'indexe de la ligne où se trouve Packman
	 */
	public int getRIndex() {
		return rIndex;
	}

	/**
	 * calcule l'indice de la ligne suite à un déplacement vers le haut
	 * @param nrLines est le nombre de lignes
	 */
	public void moveUp(int nrLines) {
		rIndex = (--rIndex + nrLines) % nrLines;
	}

	/**
	 * calcule l'indice de la colonne suite à un déplacement vers la droite
	 * @param nrColumns est le nombre de colonnes
	 */
	public void moveRigh(int nrColumns) {
		cIndex = (++cIndex + nrColumns) % nrColumns;
	}

	/**
	 * calcule l'indice de la ligne suite à un déplacement vers le bas
	 * @param nrLines est l'indice maximum
	 */
	public void moveDown(int nrLines) {
		rIndex = (++rIndex + nrLines) % nrLines;
	}

	/**
	 * calcule l'indice de la colonne suite à un déplacement vers le base
	 * @param nrColumns est le nombre de colonnes
	 */
	public void moveLeft(int nrColumns) {
		cIndex = (--cIndex + nrColumns) % nrColumns;
	}

	/**
	 * dessine Packman
	 * @param x est la position x du centre de packman
	 * @param y est la position y du centre de packman
	 */
	public void draw(float x, float y) {
		// pas de trait
		painter.noStroke();

		// pinceau de remplissage jaune
		painter.fill(255, 255, 0);

		// dessine packman
		painter.ellipse(x, y, diameter, diameter);
	}

	/**
	 * traite les événement de touches claviers enfoncés
	 */
	public void keyPressed(int nrColumns, int nrLines) {
		// dépendant la touche clavier enfoncée
		switch (painter.keyCode) {
		case PApplet.UP:
			moveUp(nrLines);
			break;
		case PApplet.RIGHT:
			moveRigh(nrColumns);
			break;
		case PApplet.DOWN:
			moveDown(nrLines);;
			break;
		case PApplet.LEFT:
			moveLeft(nrColumns);
			break;
		}
	}
}
