package eu.epfc.c5255.packman;

import processing.core.PApplet;

/**
 * Dashboard est le tableau de bord de l'application Packman
 */
public class DashBoard {
	/**
	 * référence vers le PApplet pour pouvoir dessiner
	 */
	private PApplet painter = null;

	/**
	 * position x du dashboard
	 */
	private float x;

	/**
	 * position y du dashboard
	 */
	private float y;

	/**
	 * score du jeu
	 */
	private int score = 0;

	/**
	 * constructeur du dashboard
	 * @param painter est la référence vers le PApplet permettant de dessiner
	 * @param x est la coordonnée x du sommet supérieur gauche du dashboard
	 * @param y est la coordonnée y du sommet supérieur gauche du dashboard
	 */
	public DashBoard(PApplet painter, float x, float y) {
		this.painter = painter;
		this.x = x;
		this.y = y;
	}

	/**
	 * @return le score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * assigne une nouvelle valeur au score
	 * @param score est la nouvelle valeur
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * @return la hauteur du dashboard
	 */
	public int getHeigth() {
		return 100;
	}

	/**
	 * dessine le dashboard
	 */
	public void draw() {
		painter.textSize(32);
		painter.text(score, x + 80, y + 50);
	}
}
