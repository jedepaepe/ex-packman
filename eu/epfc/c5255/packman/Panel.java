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

	int getWidth() {
		return nrCells * cellSize + 2 * margin;
	}

	int getHeight() {
		return nrCells * cellSize + 2 * margin;
	}

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

		drawPackman();
	}

	/**
	 * dessine packman
	 */
	public void drawPackman() {
		// pas de trait
		App.app.noStroke();

		// pinceau de remplissage jaune
		App.app.fill(255, 255, 0);

		// dessine packman
		App.app.ellipse(
				margin + (packman.cIndex + 0.5F) * cellSize,
				margin + (packman.lIndex + 0.5F) * cellSize,
				packman.diameter, packman.diameter);
	}
}
