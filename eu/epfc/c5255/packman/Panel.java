package eu.epfc.c5255.packman;

import java.util.Arrays;

import processing.core.PApplet;

/**
 * Le damier du jeu, contient aussi les règles du jeu
 *
 */
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
	 * les fantômes
	 */
	private Ghost[] ghosts = new Ghost[10];

	/**
	 * Constructeur du Panel
	 * @param painter est une référence sur un PApplet, pour pouvoir dessiner
	 */
	public Panel(PApplet painter) {
		// initialise le champs painter
		this.painter = painter;

		// crée les Ghosts
		for (int n = 0; n < ghosts.length; ++n) {
			ghosts[n] = new Ghost(painter, nrCells, nrCells);
		}

		// crée un objet Packman
		packman = new Packman(painter, nrCells, nrCells);

		// initialise les trésors
		for (int c = 0; c < treasures.length; ++ c) {
			for (int r = 0; r < treasures[c].length; ++r) {
				// il y a un trésor
				if (c != packman.getCIndex() || r != packman.getRIndex()) {
					treasures[c][r] = true;
				}
			}
		}
	}

	/**
	 * @return la largeur du damier
	 */
	public int getWidth() {
		return nrCells * cellSize + 2 * margin;
	}

	/**
	 * @return la hauteur du damier
	 */
	public int getHeight() {
		return nrCells * cellSize + 2 * margin;
	}

	/**
	 * @return le score
	 */
	public int getScore() {
		int score = -1;
		for (int c = 0; c < treasures.length; ++c) {
			for (int r = 0; r < treasures[c].length; ++r) {
				if (! treasures[c][r]) ++score;
			}
		}
		return score;
	}

	/**
	 * met à jour l'état du jeu
	 */
	public void updateState() {
		// bouge Packman
		packman.move();

		// bouge les fantômes
		for (int n = 0; n < ghosts.length; ++n) {
			ghosts[n].move();
		}

		// Packman meurt s'il touche un fantôme
		for (int n = 0; n < ghosts.length; ++n) {
			Ghost g = ghosts[n];
			if (packman.getCIndex() == g.getCIndex() && packman.getRIndex() == g.getRIndex()) {
				packman.killed();
			}
		}

		// packman mange le trésor
		treasures[packman.getCIndex()][packman.getRIndex()] = false;
	}

	/**
	 * dessine le damier et ses composants
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

		// dessine packman
		packman.draw(getCellCenterX(packman.getCIndex()), getCellCenterY(packman.getRIndex()));

		for (int n = 0; n < ghosts.length; ++n) {
			ghosts[n].draw(getCellCenterX(ghosts[n].getCIndex()), getCellCenterX(ghosts[n].getRIndex()));
		}

		// pinceaux blancs
		painter.fill(255);

		// dessine les trésors
		for (int c = 0; c < nrCells; ++c) {
			for (int r = 0; r < nrCells; ++r) {
				if (treasures[c][r]) {
					painter.ellipse(getCellCenterX(c), getCellCenterY(r), treasureDiameter, treasureDiameter);
				}
			}
		}
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

	public String serialize() {
		StringBuilder sb = new StringBuilder()
				.append(margin)
				.append(";")
				.append(nrCells)
				.append(";")
				.append(cellSize)
				.append(";")
				.append(treasureDiameter)
				.append(";");
		for (int c = 0; c < treasures.length; ++c) {
			for (int r = 0; r < treasures[c].length; ++r) {
				sb.append(treasures[c][r]).append(";");
			}
		}
		for (int n = 0; n < ghosts.length; ++n) {
			sb.append(ghosts[n].serialize()).append(";");
		}
		sb.append(packman.serialize());
		return sb.toString();
	}

	public void deserialize(PApplet painter, String state) {
		String[] values = state.split(";");
		int index = 0;
		margin = Integer.parseInt(values[index++]);
		nrCells = Integer.parseInt(values[index++]);
		cellSize = Integer.parseInt(values[index++]);
		treasureDiameter = Float.parseFloat(values[index++]);
		treasures = new boolean[nrCells][nrCells];
		for (int c = 0; c < treasures.length; ++c) {
			for (int r = 0; r < treasures[c].length; ++r) {
				treasures[c][r] = Boolean.parseBoolean(values[index++]);
			}
		}
		for (int nr = 0; nr < ghosts.length; ++nr) {
			ghosts[nr] = new Ghost(painter, nrCells, nrCells);
			ghosts[nr].deserialise(Arrays.copyOfRange(values, index, index + 6));
			index += 6;
		}
		packman = new Packman(painter, nrCells, nrCells);
		packman.deserialise(Arrays.copyOfRange(values, index, index + 6));
	}
}
