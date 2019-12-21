package eu.epfc.c5255.packman;

import processing.core.PApplet;

public class Panel {
	/**
	 * référence sur le PApplet pour dessiner
	 */
	private PApplet painter = null;

	/**
	 * taille de la marge ne pixels
	 */
	private int margin = 25;

	/**
	 * nombre de cellules par damier
	 */
	private int nrCells = 29;

	/**
	 * taille des cellules
	 */
	private int cellSize = 21;

	/**
	 * références sur l'objet packman
	 */
	private Packman packman = null;

	/**
	 * diametre des trésors
	 */
	private float treasureDiameter = 3;

	/**
	 * les trésors
	 */
	private boolean[][] treasures = new boolean[nrCells][nrCells];

	/**
	 * Constructeur du Panel
	 * @param painter est une référence sur un PApplet, pour pouvoir dessiner
	 */
	public Panel(PApplet painter) {
		// initialise le champs painter
		this.painter = painter;

		// crée un objet Packman
		packman = new Packman(painter);

		// initialise les trésors
		for (int c = 0; c < nrCells; ++ c) {
			for (int r = 0; r < nrCells; ++r) {
				// il y a un trésor
				treasures[c][r] = true;
			}
		}
	}

	/**
	 * @return la largeur du damier
	 */
	int getWidth() {
		return nrCells * cellSize + 2 * margin;
	}

	/**
	 * @return la hauteur du damier
	 */
	int getHeight() {
		return nrCells * cellSize + 2 * margin;
	}

	/**
	 * dessine le damier et ses composant
	 */
	public void draw() {
		// pinceau de trait mauve
		painter.stroke(128, 0, 255);

		// dessine le damier
		for (int i = 0; i <= nrCells; ++i) {
			// ligne horizontale
			painter.line(margin, margin + i * cellSize, margin + nrCells * cellSize, margin + i * cellSize);
			// ligne verticale
			painter.line(margin + i * cellSize, margin, margin + i * cellSize, margin + nrCells * cellSize);
		}

		// pinceaux blancs
		painter.fill(255);

		// dessine les trésors
		for (int c = 0; c < nrCells; ++c) {
			for (int r = 0; r < nrCells; ++r) {
				painter.ellipse(getCellCenterX(c), getCellCenterY(r), treasureDiameter, treasureDiameter);
			}
		}

		// dessine packman
		packman.draw(getCellCenterX(packman.getCIndex()), getCellCenterY(packman.getRIndex()));
	}

	/**
	 * Traite l'événement touche clavier
	 */
	public void keyPressed() {
		packman.keyPressed(nrCells, nrCells);
	}

	/**
	 * @param cIndex est l'index de colonne de la cellule
	 * @return la position x du centre de la cellule
	 */
	public float getCellCenterX(int cIndex) {
		return margin + (cIndex + 0.5F) * cellSize;
	}

	/**
	 * @param lIndex est l'index de la ligne de la cellule
	 * @return la position y du centre de la cellule
	 */
	public float getCellCenterY(int lIndex) {
		return margin + (lIndex + 0.5F) * cellSize;
	}
}
