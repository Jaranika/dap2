import java.io.*;
import java.lang.*;
public class BinarySearch{
public static void main(String args[]){
 try{  
   float zeit = Float.parseFloat(args[0]);
   if(zeit < 0 || args.length != 1){
   throw new IllegalArgumentException();
   }
   
   zeit = zeit*1000; // Umrechnung Sekunden in Millisekunden
   int anzahl = 1000;
   long msecs = laufzeit(anzahl);
   
   while(zeit >= msecs){//Länge des Arrays wird verdoppelt, solange die Laufzeit der Sortierung kleiner als die Eingabe ist
   anzahl = anzahl*2;
   msecs = laufzeit(anzahl);
   }
   
   int ergebnis = binarySearch(zeit, (anzahl/2), anzahl);//binäre Suche wird gestartet
   System.out.println("Eingabe: " + (zeit/1000) + " - Ergebnis " + ergebnis);   
 }
catch(Exception e){System.out.println("Bitte geben sie eine positive Zahl an.");}
}


public static long laufzeit(int anzahl){//misst die Laufzeit der Sortierung einer bestimmten Arraygröße
   long tStart, tEnd, msecs;
   msecs = tStart = tEnd = 0;
   int[] array;
   array = array(anzahl);
   
   tStart = System.currentTimeMillis();//Messung der Laufzeit
   bubbleSort(array);
   tEnd = System.currentTimeMillis();
   
   msecs = tEnd - tStart;
   return msecs;
}

   
public static int binarySearch(float x, int a1, int a2){//führt eine binäre Suche zwischen zwei Arraygrößen durch, um diejenige zu finden, die zu der
   int haelfte = (a1+a2)/2;                             //Eingabe passt
   long a,b,c;
   a = laufzeit(a1);//Messung der Laufzeiten der kleineren, mittleren und größeren Länge
   c = laufzeit(a2);
   b = laufzeit(haelfte);

   System.out.println("    Zeit in ms"+"  Länge\n"+"Kleiner: "+a+"    "+a1+"\nMitte:   "+b+"    "+haelfte+"\nGrößer:  "+c+"    "+a2+"\n");

   if(Math.abs(a-c) < 100){//wenn die Laufzeit innerhalb der Toleranzgrenze liegt, wird die Größe ausgegeben; (100 ms = 0.1 s)
   return a2;
   }
   else if(b < x){//wenn die Laufzeit der mittleren Arraylänge kleiner als die Eingabe ist, wird im Bereich zwischen der Hälfte und der oberen 
   return binarySearch(x,haelfte,a2); //Grenze gesucht
   }
   else{//sonst wird im Bereich zwischen der unteren Grenze und der Hälfte gesucht
   return binarySearch(x,a1,haelfte);
   }
}


public static void bubbleSort(int[] array){//Algorithmus des BubbleSorts aus der Aufgabe
   int n = array.length-1;
   for(int i = 0; i <= n; i++){
   for(int j = n; j > i; j--){
      if(array[j-1] > array[j]){
      int tmp = array[j];
      array[j] = array[j-1];
      array[j-1] = tmp;
      }
   }
   }
   assert isSorted(array):"Array nicht sortiert";
}


public static int[] array(int anzahl){//erzeugt ein Array mit der als Parameter übergebenen Länge
    int[] array = new int[anzahl];
    for(int i = 0; i < array.length; i++){
       array[i] = array.length-i;
    }
    return array;
}


public static boolean isSorted(int[] array){//überprüft ob das Array sortiert ist
   for(int m = 1; m < array.length; m++){
      if(array[m-1]>array[m]){
      return false;
      }
   }
   return true;
}














public static long laufzeit1(int anzahl){//misst die durchschnittliche Laufzeit der Sortierung eines Arrays mit der Länge anzahl(alternativ)
   long tStart, tEnd, msecs;
   msecs = tStart = tEnd = 0;
   int[] array;
   
   for(int i = 0; i < 10; i++){//die Laufzeit wird mehrmals gemessen um einen genaueren Wert zu erhalten
   array = array(anzahl);
   tStart = System.currentTimeMillis();
   bubbleSort(array);
   tEnd = System.currentTimeMillis();
   array = null;
   System.gc();//Garbage-Collector zur Verbesserung der Laufzeit
   msecs = tEnd - tStart + msecs;//alle Laufzeiten werden zur späteren Berechnung addiert
   }
   return msecs/10;//Durschnitt der Messungen wird berechnet
}

}
