package eu.epfc.c5255.packman;

import processing.core.PApplet;

/**
 * Réprésente un fantôme
 */
public class Ghost extends Personage {

	/**
	 * constructeur du Ghost
	 * @param painter
	 * @param nrColumns
	 * @param nrRows
	 */
	public Ghost(PApplet painter, int nrColumns, int nrRows) {
		super(painter, nrColumns, nrRows);
		color = painter.color(255, 0, 0);
	}

	/**
	 * bouge le fantôme
	 */
	@Override
	public void move() {
		// recalcule la direction 1x sur 4 (en moyenne)
		if(painter.random(4) < 1) {
			// tire au hazard la direction
			int value = (int) painter.random(4);
			switch(value) {
			case 0:
				direction = PApplet.UP;
				break;
			case 1:
				direction = PApplet.RIGHT;
				break;
			case 2:
				direction = PApplet.DOWN;
				break;
			case 3:
				direction = PApplet.LEFT;
				break;
			}
		}
		super.move();
	}
}
