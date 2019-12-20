package eu.epfc.c5255.packman;

public class Panel {

	/**
	 * taille de la marge ne pixels
	 */
	int margin = 25;

	/**
	 * nombre de cellules par damier
	 */
	int nrCells = 29;

	/**
	 * taille des cellules
	 */
	int cellSize = 21;

	/**
	 * packman object
	 */
	Packman packman = new Packman();

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
		App.app.stroke(128, 0, 255);

		// dessine le damier
		for (int i = 0; i <= nrCells; ++i) {
			// ligne horizontale
			App.app.line(margin, margin + i * cellSize, margin + nrCells * cellSize, margin + i * cellSize);
			// ligne verticale
			App.app.line(margin + i * cellSize, margin, margin + i * cellSize, margin + nrCells * cellSize);
		}

		// dessine packman
		packman.draw(getCellCenterX(packman.cIndex), getCellCenterY(packman.lIndex));
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
