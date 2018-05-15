import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
public class ConvexHull{


public static void main(String[] args){
	
Point[] random = new Point[1000];
java.util.Random numberGenerator = new java.util.Random();
int grenze2 = 90;
for(int i = 0; i < random.length; i++) {
	double x = Math.abs(numberGenerator.nextDouble()*grenze2)+10;
	double grenze = 110-x;
	double y =numberGenerator.nextDouble()*(grenze-10)+10;
	random[i] = new Point(2,x,y);
}

//random wird nach x-Koordiante sortiert
Arrays.sort(random, new Comparator<Point>() {
    @Override
    public int compare(Point first, Point second) {
    	//return first.get(1)().compareTo(second.get(1)())
    	if(first.get(1)<second.get(1)) {return -1;}
        else {return 1;}
    }
});
for(int i = 0; i < random.length;i++) {
	System.out.print(random[i].get(1)+", "+random[i].get(2)+" - ");
}
System.out.println(); 

Point p1 = new Point(2,10,10);
Point p2 = new Point(2,10,100);
Point p3 = new Point(2,100,10);

Point[] points = {p1,p2,p3};
LinkedList<Point> l = simpleConvex1(random);
Point[] b = {};
Point[] a = l.toArray(b);

int i = 0;
while(i<a.length) {
	int k = 1;
	while(k <= a[i].dim()) {
		System.out.print(a[i].get(k)+", ");
		k++;
	}
	i = i + k;
	System.out.println();
}


}


public static LinkedList<Point> simpleConvex(Point[] P){
   Point[] E = new Point[(P.length*10000)];
   int a = 0;
   for(int i = 0; i < P.length; i++){
	 for(int k = 0; k < P.length; k++){// k = 1 oder k = i+1??
		if(i!=k) {
		boolean valid = true;
	    for(int q = 0; q < P.length; q++){
		  if(q != i&& q != k && links(P[i],P[k],P[q])){
			valid = false;
		  }
		  if(valid){
			E[a] = P[i];
			E[a+1] = P[k];//muss ueberprueft werden, ob Punkte gleich sind
			a = a + 2;
			q = P.length;//der richtige Punkt wurde gefunden, der naechste kann gesucht werden
			
		  }}
	    }
	 }
   }
   LinkedList<Point> list = new LinkedList<Point>();
   for(int w = 0; w < E.length && E[w]!= null; w++){
	 list.add(E[w]);
	// w++;
   }
   return list;
}



public static boolean links(Point p1, Point p2, Point r){
	double x1 = p1.get(1);
	double x2 = p2.get(2);
	double y1 = p1.get(1);
	double y2 = p2.get(2);
	double r1 = r.get(1);
	double r2 = r.get(2);
	String richtung = richtung(p1,p2);
	if(richtung == "or") {
		if(r1 < x1) {return false;}
		else if(r1 > x2) {return true;}
		else if(r1 > x1 && r1 < x2) {//gerade berechnen}
		}
	}
	else if(richtung == "ur") {
		if(r1 > x2) {return false;}
		else if(r1 < x1) {return true;}
		else if(r1 > x1 && r1 < x2) {//gerade berechnen}}
		}
	}
	else if(richtung == "ul") {
		if(r1 > x1) {return false;}
		else if(r1 < x2) {return true;}
		else if (r1 < x1 && r1 > x2) {//gerade berechnen}
			
		}
	}
	else if(richtung == "ol") {
		if(r1>x1) {return false;}//?
		else if(r1>x2) {return true;}
		else if(r1<x1) {}//gerade berechnen
	}
	return false;
	
}




public static String richtung(Point p1, Point p2) {
	String richtung = "";
	double x1 = p1.get(1);
	double x2 = p2.get(2);
	double y1 = p1.get(1);
	double y2 = p2.get(2);
	if(x1 < x2 && y1 < y2) {//p2 liegt rechts ueberhalb p1
		richtung = "or";
	}
	else if(x1 < x2 && y1 > y2){//p2 liegt links neben p1
		richtung = "ur";
	}
	else if(x1 > x2 && y1 > y2){
		richtung = "ul"; 
	}
	else if(x1 > x2 && y1 < y2) {
		richtung = "ol";
	}
	return richtung;
	
	
}



public static LinkedList<Point> simpleConvex1(Point[] P){
	   Point[] E = new Point[(P.length*10000)];
	   int a = 0;
	   LinkedList<Point> list = new LinkedList<Point>();
	   for(int i = 0; i < P.length; i++){
		 for(int k = 0; k < P.length; k++){// k = 1 oder k = i+1??
			if(i!=k) {
			boolean valid = true;
		    for(int q = 0; q < P.length; q++){
			  if(q == i && q == k){
				valid = false;
			  }
			  double a1 = P[i].get(1)-P[q].get(1);
			  double a2 = P[i].get(2)-P[q].get(2);
			  double b1 = P[k].get(1)-P[q].get(1);
			  double b2 = P[k].get(2)-P[q].get(2);
			  
			  double kreuz = a1*b2-b1*a2;//p1.1*p2.2-p2.1+p1.2 wenn punt links dann negativ
			  if(kreuz < 0) {valid = false;}
			  if(valid){
				list.add(P[i]);
			  }}
		    }
		 }
	   }
	   return list;
	}

	
/*	
	import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
public class ConvexHull{


public static void main(String[] args){
  
Point[] random = new Point[1000];
java.util.Random numberGenerator = new java.util.Random();
int grenze2 = 90;
for(int i = 0; i < random.length; i++) {
  double x = Math.abs(numberGenerator.nextDouble()*grenze2)+10;
  double grenze = 110-x;
  double y =numberGenerator.nextDouble()*(grenze-10)+10;
  random[i] = new Point(2,x,y);
}

//random wird nach x-Koordiante sortiert
Arrays.sort(random, new Comparator<Point?) {
    @Override
    public int compare(Point first, Point second) {
      //return first.get(1)().compareTo(second.get(1)())
      if(first.get(1)<second.get(1)) {return -1;}
        else {return 1;}
    }
});
for(int i = 0; i < random.length;i++) {
  System.out.print(random[i].get(1)+", "+random[i].get(2)+" - ");
}
System.out.println(); 

LinkedList<Point> l = simpleConvex(random);
Point[] b = {};
Point[] a = l.toArray(b);
int i = 0;
while(i<a.length) {
  int k = 1;
  while(k <= a[i].dim()) {
    System.out.print(a[i].get(k)+", ");
    k++;
  }
  i = i + k;
  System.out.println();
}*/


}



