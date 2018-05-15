public class Triangle extends Simplex{

Point[] point;

public Triangle(Point ... points){
   super(2,points);
   point = points;
   if(!validate()){
	 throw new IllegalArgumentException();
   }
}

public boolean validate(){//ueberprueft ob es ein Dreieck ist, also 3 Punkte mit Dimension 2
   if(point.length != 3){
	 return false;
   }
   else if(point[0].dim()!= 2||point[1].dim()!= 2||point[2].dim()!= 2){
	 return false;
   }
   else{
	 return true;
   }
}

}
