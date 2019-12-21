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
	private int rIndex;

	/**
	 * index de la colonne où se trouve packman
	 */
	private int cIndex;

	/**
	 * nombre de colonnes que Packman peut visiter
	 */
	private int nrColumns;

	/**
	 * nombre de lignes que Packman peut visiter
	 */
	private int nrRows;

	/**
	 * direction du mouvement de packman
	 */
	private int direction = 0;

	/**
	 * Contructeur de Packman
	 * @param painter est une référence sur PApplet pour peindre
	 * @param nrColumns est le nombre de colonnes que Packman peut visiter
	 * @param nrRows est le nombre de lignes que Packman peut visiter
	 */
	public Packman(PApplet painter, int nrColumns, int nrRows) {
		// initialise le champs painter
		this.painter = painter;
		this.nrColumns = nrColumns;
		this.nrRows = nrRows;
		this.cIndex = (int) painter.random(nrColumns);
		this.rIndex = (int) painter.random(nrRows);
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
	 */
	public void moveUp() {
		rIndex = (--rIndex + nrRows) % nrRows;
	}

	/**
	 * calcule l'indice de la colonne suite à un déplacement vers la droite
	 */
	public void moveRigh() {
		cIndex = (++cIndex + nrColumns) % nrColumns;
	}

	/**
	 * calcule l'indice de la ligne suite à un déplacement vers le bas
	 */
	public void moveDown() {
		rIndex = (++rIndex + nrRows) % nrRows;
	}

	/**
	 * calcule l'indice de la colonne suite à un déplacement vers le base
	 */
	public void moveLeft() {
		cIndex = (--cIndex + nrColumns) % nrColumns;
	}

	/**
	 * déplace packman
	 */
	public void move() {
		switch(direction) {
		case PApplet.UP:
			moveUp();
			break;
		case PApplet.RIGHT:
			moveRigh();
			break;
		case PApplet.DOWN:
			moveDown();
			break;
		case PApplet.LEFT:
			moveLeft();
			break;
		}
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
		// si space : packman s'arrête
		if (painter.key == ' ') direction = 0;

		// si flèche packman bouge
		switch (painter.keyCode) {
		case PApplet.UP:
		case PApplet.RIGHT:
		case PApplet.DOWN:
		case PApplet.LEFT:
			direction = painter.keyCode;
			break;
		}
	}
}
