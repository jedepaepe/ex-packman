package eu.epfc.c5255.packman;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import processing.core.PApplet;

/**
 * Classe principale de l'application
 */
public class App extends PApplet {
	/**
	 * référence sur le damier
	 */
	private Panel panel = null;

	/**
	 * référence sur le tableau de bord
	 */
	private DashBoard dashboard = null;

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
		// instancie le damier en passant une référence sur le PApplet pour pouvoir dessiner
		panel = new Panel(this);

		// instancie le dashboard
		dashboard = new DashBoard(this, 0, panel.getHeight());

		// change la taille de la fenêtre
		size(panel.getWidth(), panel.getHeight() + dashboard.getHeigth());
	}

	/**
	 * initialisation
	 */
	@Override
	public void setup () {
		// 4 rafraichissements par seconde
		frameRate(4);
	}

	/**
	 * peindre la fenêtre (appelée par Processing)
	 */
	@Override
	public void draw () {
		// met à jour l'état du jeu
		panel.updateState();
		dashboard.setScore(panel.getScore());

		// dessine
		// couleur de fond noir
		background(0);

		// dessine le damier
		panel.draw();

		// dessine le dashboard
		dashboard.draw();
	}

	/**
	 * traiter les événements clavier (appelé par Processing)
	 */
	@Override
	public void keyPressed () {
		switch(key) {
		case 'L':
		case 'l':
			load();
			break;
		case 'S':
		case 's':
			save();
			break;
		default:
			panel.keyPressed();
		}
	}

	/**
	 * sauve l'état du jeu
	 */
	public void save () {
		try {
			FileWriter fw = new FileWriter(new File("packman.txt"));
			fw.write(panel.serialize());
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * charge l'état du jeu
	 */
	public void load () {
		try (Scanner scanner = new Scanner(new File("packman.txt"))) {
			String config = scanner.nextLine();
			panel.deserialize(this, config);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
