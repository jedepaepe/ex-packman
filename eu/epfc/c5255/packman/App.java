package eu.epfc.c5255.packman;

//utilise la classe processing PApplet
import processing.core.PApplet;

/**
 * Classe principale de l'application
 */
public class App extends PApplet {
	// damier packman
	static PackPanel panel = new PackPanel(); 
	
	/**
	 * point d'entrée du programme
	 * @param args sont les arguments passés par la ligne de commande
	 */
	public static void main(String[] args) {
		// démarre le moteur Processing (la GUI)
		PApplet.main(App.class.getName());
	}
	
	/**
	 * configure l'application
	 */
	@Override
	public void settings () {
		size(panel.getSize(), panel.getSize());
	}
	
	/**
	 * dessine l'image de base
	 */
	@Override
	public void setup () {
		panel.draw(this);
	}
	
	@Override
	public void draw () {
	}
	
	/**
	 * calcule la nouvelle position de packman
	 */
	@Override
	public void keyPressed () {
		panel.keyPresset(this);
		panel.draw(this);
	}	
}
