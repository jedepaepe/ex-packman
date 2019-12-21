package eu.epfc.c5255.packman;

import processing.core.PApplet;

public class Packman extends Personage {

	/**
	 * Contructeur de Packman
	 * @param painter est une référence sur PApplet pour peindre
	 * @param nrColumns est le nombre de colonnes que Packman peut visiter
	 * @param nrRows est le nombre de lignes que Packman peut visiter
	 */
	public Packman(PApplet painter, int nrColumns, int nrRows) {
		super(painter, nrColumns, nrRows);
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
