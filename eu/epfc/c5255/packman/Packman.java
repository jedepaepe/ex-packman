package eu.epfc.c5255.packman;

public class Packman {

	/**
	 * taille de packman
	 */
	int diameter = 23;

	/**
	 * index de la ligne où se trouve packman
	 */
	int lIndex = 10;

	/**
	 * index de la colonne où se trouve packman
	 */
	int cIndex = 15;

	/**
	 * calcule l'indice de la ligne suite à un déplacement vers le haut
	 * @param nrLines est le nombre de lignes
	 */
	public void moveUp(int nrLines) {
		lIndex = (--lIndex + nrLines) % nrLines;
	}

	/**
	 * calcule l'indice de la colonne suite à un déplacement vers la droite
	 * @param nrColumns est le nombre de colonnes
	 */
	public void moveRigh(int nrColumns) {
		cIndex = (++cIndex + nrColumns) % nrColumns;
	}

	/**
	 * calcule l'indice de la ligne suite à un déplacement vers le bas
	 * @param nrLines est l'indice maximum
	 */
	public void moveDown(int nrLines) {
		lIndex = (++lIndex + nrLines) % nrLines;
	}

	/**
	 * calcule l'indice de la colonne suite à un déplacement vers le base
	 * @param nrColumns est le nombre de colonnes
	 */
	public void moveLeft(int nrColumns) {
		cIndex = (--cIndex + nrColumns) % nrColumns;
	}
}
