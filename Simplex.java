public abstract class Simplex{

private Point[] point;

public Simplex(int d, Point ... points){
   if(d+1 != points.length){
	 throw new IllegalArgumentException();
   }
   point = points;
   for(int i = 0; i < points.length; i++){
	 if(points[i].dim()!= d){
	    throw new IllegalArgumentException();//ueberpruefung ob die Dimensionen der Punkte uebereinstimmen
	 }
   } 
}


public Point get(int i){
   if(i < 0){
	 throw new IllegalArgumentException();
   }
   return point[i-1];
}

public abstract boolean validate();

public double perimeter(){//berechnet die Summer aller Kantenlaengen
   double sum = 0;
   EuclidDistance e = new EuclidDistance();
   for(int i = 0; i < point.length-1;i++){
      for(int k = i+1; k < point.length; k++){
	    sum = sum + e.distance(point[i],point[k]);
      }
   }
   return sum;
}


}
