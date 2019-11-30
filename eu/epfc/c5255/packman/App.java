package eu.epfc.c5255.packman;

import processing.core.PApplet;

/**
 * Classe principale de l'application
 * 
 */
public class App extends PApplet {
	static int margin = 25;
	static int nrCells = 28;
	static int nrPixelPerCell = 21;

	public static void main(String[] args) {
		// start GUI
		PApplet.main(App.class.getName());
	}
	
	@Override
	public void settings () {
		size(nrCells * nrPixelPerCell + 2 * margin, nrCells * nrPixelPerCell + 2 * margin);
	}
	
	@Override
	public void setup () {
		background(0);
		stroke(128, 0, 255);
		// draw panel
		for (int i = 0; i <= nrCells; ++i) {
			line(margin, margin + i * nrPixelPerCell, margin + nrCells * nrPixelPerCell, margin + i * nrPixelPerCell);
			line(margin + i * nrPixelPerCell, margin, margin + i * nrPixelPerCell, margin + nrCells * nrPixelPerCell);
		}
		
	}
	
	@Override
	public void draw () {
		
	}

}
