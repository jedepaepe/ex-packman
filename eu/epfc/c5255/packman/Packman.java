package eu.epfc.c5255.packman;

public class Packman {

	/**
	 * taille de packman
	 */
	int diameter = 23;
	
	/**
	 * coordonn�e (y) de packman (premi�re cellule = 0)
	 */
	int y = 10;
	
	/**
	 * absisse (x) de packman (premi�re cellule = 0)
	 */
	int x = 15;

	/**
	 * calcule l'indice de la ligne suite � un d�placement vers le haut
	 * @param nrLines est le nombre de lignes
	 */
	public void moveUp(int nrLines) {
		y = (--y + nrLines) % nrLines;
	}

	/**
	 * calcule l'indice de la colonne suite � un d�placement vers la droite 
	 * @param nrColumns est le nombre de colonnes
	 */
	public void moveRigh(int nrColumns) {
		x = (++x + nrColumns) % nrColumns;
	}
	
	/**
	 * calcule l'indice de la ligne suite � un d�placement vers le bas
	 * @param nrLines est l'indice maximum
	 */
	public void moveDown(int nrLines) {
		y = (++y + nrLines) % nrLines;
	}
	
	/**
	 * calcule l'indice de la colonne suite � un d�placement vers le base
	 * @param nrColumns est le nombre de colonnes
	 */
	public void moveLeft(int nrColumns) {
		x = (--x + nrColumns) % nrColumns;
	}
}
