import java.util.*;
import java.io.*;

public class Application {

	public static void main(String args[]) {
		try {
			double x1, y1, x2, y2, x3, y3;
			if (args.length == 6) {

				x1 = Double.parseDouble(args[0]);
				y1 = Double.parseDouble(args[1]);
				x2 = Double.parseDouble(args[2]);
				y2 = Double.parseDouble(args[3]);
				x3 = Double.parseDouble(args[4]);
				y3 = Double.parseDouble(args[5]);

			} else if (args.length == 0) {// wenn keine Parameter gegeben sind, werden die Koordinaten zufaellig gewaehlt

				int grenze = 1000;
				java.util.Random numberGenerator = new java.util.Random();
				x1 = numberGenerator.nextDouble() * grenze;
				y1 = numberGenerator.nextDouble() * grenze;
				x2 = numberGenerator.nextDouble() * grenze;
				y2 = numberGenerator.nextDouble() * grenze;
				x3 = numberGenerator.nextDouble() * grenze;
				y3 = numberGenerator.nextDouble() * grenze;

			} else {
				throw new IOException();
			}

			Triangle t = new Triangle(new Point(2, x1, y1), new Point(2, x2, y2), new Point(2, x3, y3));// ein neues
																										// Dreieck wird
																										// erzeugt
			double ergebnis = t.perimeter();// die Summe der Kantenlaengen wird berechnet
			System.out.println("Ergebnis: " + ergebnis);
			System.out.println("Validate: " + t.validate());

		} catch (IllegalArgumentException e) {
			System.out.println("Es wurden falsche Paramter eingegeben");
		} catch (IOException e) {
			System.out.println("Bitte geben sie entweder 6 Zahlen oder keine Parameter an.");
		} catch (Exception e) {
			System.out.println("Bitte geben sie entweder 6 Zahlen oder keine Parameter an.");
		}
	}

}
