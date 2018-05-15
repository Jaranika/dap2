public class Point{

private double[] coordinates;
private int dim = 0;


public Point(int d, double ... values){
   dim = d;
   coordinates = values;
   if(d%coordinates.length!=0){throw new IllegalArgumentException();}//die Koordinatenanzahl muss der Dimension entsprechen
}

public double get(int i){
   if(i<0){
	 throw new IllegalArgumentException();
   }
   return coordinates[i-1];
}

public int dim(){
   return dim;
}

}