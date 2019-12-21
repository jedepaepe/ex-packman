package eu.epfc.c5255.packman;

import processing.core.PApplet;

public class Packman {
	/**
	 * référence sur le PApplet pour dessiner
	 */
	PApplet painter = null;

	/**
	 * taille de packman
	 */
	int diameter = 23;

	/**
	 * index de la ligne où se trouve packman
	 */
	int lIndex = 10;

	/**
	 * index de la colonne où se trouve packman
	 */
	int cIndex = 15;

	/**
	 * Contructeur de Packman
	 * @param painter est une référence sur PApplet pour peindre
	 */
	public Packman(PApplet painter) {
		// initialise le champs painter
		this.painter = painter;
	}

	/**
	 * calcule l'indice de la ligne suite à un déplacement vers le haut
	 * @param nrLines est le nombre de lignes
	 */
	public void moveUp(int nrLines) {
		lIndex = (--lIndex + nrLines) % nrLines;
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
		lIndex = (++lIndex + nrLines) % nrLines;
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
}
