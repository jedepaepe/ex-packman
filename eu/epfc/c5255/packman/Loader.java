package eu.epfc.c5255.packman;

import processing.core.PApplet;

/**
 * Classe qui charge l'application
 *
 */
public class Loader {

	/**
	 * point d'entrée du programme
	 * @param args sont les arguments passés par la ligne de commande
	 * demande à PApplet de charger App
	 */
	public static void main(String[] args) {
		PApplet.main(App.class.getName());
	}

}
