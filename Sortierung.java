import java.util.Random;
public class Sortierung{

public static void main(String args[]){
try{
   int anzahl = Integer.parseInt(args[0]);
   if(anzahl < 0){throw new Exception();}
   assert anzahl > 0 : anzahl + "ist kleiner als 0";
   int[] array = new int[anzahl];
   java.util.Random numberGenerator = new java.util.Random();// Zufallszahlengenerator
   
   //Füllen des Arrays anhand des zweiten Parameters
   if(args.length == 2){
      if(args[1].equals("auf")){
        array[0] = numberGenerator.nextInt();
        for(int i = 1; i < array.length; i++){
           array[i] = numberGenerator.nextInt() + array[i-1];
        }
      }
      else if (args[1].equals("ab")){
        array[array.length-1] = numberGenerator.nextInt();
        for(int k = array.length-1; k > 0; k--){
           array[k-1] = numberGenerator.nextInt() + array[k];
        }
      }
      else if (args[1].equals("rand")){
        for(int l = 0; l < array.length; l++){
           array[l] = numberGenerator.nextInt();
         }
      }
      else {throw new Exception();}
    }
    else{ //wenn kein zweiter Parameter angegeben ist, wird das Array mit Zufallszahlen gefüllt
      for(int l = 0; l < array.length; l++){
         array[l] = numberGenerator.nextInt();
      }
    }
    
    // Messung der Laufzeit während der Sortierung
    long tStart, tEnd, msecs;
    tStart = System.currentTimeMillis();
      insertionSort(array); 
    tEnd = System.currentTimeMillis();
    msecs = tEnd - tStart;
   
   //Überprüfung, ob das Array korrekt sortiert ist
   if(isSorted(array)){ System.out.println("Feld sortiert!");}
   else{System.out.println("Feld NICHT sortiert!");}
   
   //Ausgabe der benötigten Zeit und des Arrays, falls es höchstens 100 Elemente hat
   System.out.println("Benötigte Zeit:"+ msecs);
   if(anzahl <=100){
     for(int w = 0; w < array.length; w++){
        System.out.print(array[w]+",");
     }
    System.out.println();
   }
}
catch(Exception e){ System.out.println("Die Eingabe war nicht korrekt. Der richtige Syntax lautet: java Sortierung zahl (optional: auf, ab oder rand - für die Art der Füllung des Arrays).");}
}

public static void insertionSort(int[] array){
   for(int k = 1; k < array.length; k++){
      int key = array[k];
      int q = k-1;
    while(q >= 0 && array[q] > key){
       array[q+1] = array[q];
       q = q-1;
       array[q+1] = key;
     }
   }
}

public static boolean isSorted(int[] array){
   for(int m = 1; m < array.length; m++){
      if(array[m-1]>array[m]){
        return false;
      }
   }
   return true;
}


}
