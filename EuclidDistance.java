public class EuclidDistance implements Distance {

	public double distance(Point p1, Point p2) {
		if (p1.dim() != p2.dim()) {// Punkte muessen dieselbe Dimension haben
			throw new IllegalArgumentException();
		}
		double abstand = 0;
		double quad = 0;
		for (int i = 1; i <= p1.dim(); i++) {// berechnet wird mit der euklidschen Formel
			quad = p1.get(i) - p2.get(i);
			quad = quad * quad;
			abstand = abstand + quad;
		}
		abstand = Math.sqrt(abstand);
		return abstand;
	}

}
