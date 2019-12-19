package eu.epfc.c5255.packman;

public class Packman {

	/**
	 * taille de packman
	 */
	int diameter = 23;
	
	/**
	 * coordonnée (y) de packman (première cellule = 0)
	 */
	int y = 10;
	
	/**
	 * absisse (x) de packman (première cellule = 0)
	 */
	int x = 15;

	/**
	 * calcule l'indice de la ligne suite à un déplacement vers le haut
	 * @param nrLines est le nombre de lignes
	 */
	public void moveUp(int nrLines) {
		y = (--y + nrLines) % nrLines;
	}

	/**
	 * calcule l'indice de la colonne suite à un déplacement vers la droite 
	 * @param nrColumns est le nombre de colonnes
	 */
	public void moveRigh(int nrColumns) {
		x = (++x + nrColumns) % nrColumns;
	}
	
	/**
	 * calcule l'indice de la ligne suite à un déplacement vers le bas
	 * @param nrLines est l'indice maximum
	 */
	public void moveDown(int nrLines) {
		y = (++y + nrLines) % nrLines;
	}
	
	/**
	 * calcule l'indice de la colonne suite à un déplacement vers le base
	 * @param nrColumns est le nombre de colonnes
	 */
	public void moveLeft(int nrColumns) {
		x = (--x + nrColumns) % nrColumns;
	}
}
