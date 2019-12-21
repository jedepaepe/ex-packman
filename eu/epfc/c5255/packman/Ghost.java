package eu.epfc.c5255.packman;

import processing.core.PApplet;

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

}
