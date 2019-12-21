package eu.epfc.c5255.packman;

import processing.core.PApplet;

public class Personage {
	/**
	 * référence sur le PApplet pour dessiner
	 */
	protected PApplet painter = null;

	/**
	 * en vie ou pas
	 */
	boolean alive = true;

	/**
	 * taille de personage
	 */
	private int diameter = 23;

	/**
	 * couleur du personnage
	 */
	protected int color;

	/**
	 * index de la ligne où se trouve personage (r: row)
	 */
	private int rIndex;

	/**
	 * index de la colonne où se trouve personage
	 */
	private int cIndex;

	/**
	 * nombre de colonnes que personage peut visiter
	 */
	private int nrColumns;

	/**
	 * nombre de lignes que personage peut visiter
	 */
	private int nrRows;

	/**
	 * direction du mouvement de personage
	 */
	protected int direction = 0;

	/**
	 * Contructeur de personage
	 * @param painter est une référence sur PApplet pour peindre
	 * @param nrColumns est le nombre de colonnes que personage peut visiter
	 * @param nrRows est le nombre de lignes que personage peut visiter
	 */
	public Personage(PApplet painter, int nrColumns, int nrRows) {
		// initialise le champs painter
		this.painter = painter;
		this.nrColumns = nrColumns;
		this.nrRows = nrRows;
		this.cIndex = (int) painter.random(nrColumns);
		this.rIndex = (int) painter.random(nrRows);
		this.color = painter.color(255, 255, 0); 	// jaune
	}

	/**
	 * @return l'indexe de la colonne où se trouve personage
	 */
	public int getCIndex() {
		return cIndex;
	}

	/**
	 * @return l'indexe de la ligne où se trouve personage
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
	 * déplace personage
	 */
	public void move() {
		if (alive) {
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
	}

	/**
	 * le personnage est tué
	 */
	public void killed() {
		alive = false;
	}

	/**
	 * dessine personage s'il est en vie
	 * @param x est la position x du centre de personage
	 * @param y est la position y du centre de personage
	 */
	public void draw(float x, float y) {
		if (alive) {
			// pas de trait
			painter.noStroke();

			// pinceau de remplissage jaune
			painter.fill(color);

			// dessine personage
			painter.ellipse(x, y, diameter, diameter);
		}
	}
}
