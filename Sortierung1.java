import java.util.Random;
import java.io.*;
public class Sortierung1{

public static void main(String args[])throws Exception{
try{
   int anzahl = Integer.parseInt(args[0]);
   if(anzahl < 0){throw new IllegalArgumentException("a");}
   assert anzahl > 0 : anzahl + "ist kleiner als 0";
   int[] array = new int[anzahl];
   java.util.Random numberGenerator = new java.util.Random();// Zufallszahlengenerator
     
   //Füllen des Arrays anhand des dritten Parameters
   if(args.length == 3){
      if(args[2].equals("auf")){
        //array[0] = Math.abs(numberGenerator.nextInt());
        int randomNumber = numberGenerator.nextInt();
        for(int i = 0; i < array.length; i++){
           //array[i] = Math.abs(numberGenerator.nextInt()) + array[i-1];
           array[i] = randomNumber;
           randomNumber++;
        }
      }
      else if (args[2].equals("ab")){
        //array[array.length-1] = numberGenerator.nextInt();
        int randomNumber = numberGenerator.nextInt();
        for(int k = 0; k < array.length; k++){
           //array[k-1] = Math.abs(numberGenerator.nextInt()) + array[k];
           array[k] = randomNumber;
           randomNumber--;
        }
      }
      else if (args[2].equals("rand")){
        for(int l = 0; l < array.length; l++){
           array[l] = numberGenerator.nextInt();
         }
      }
      else {throw new IOException();}
    }
    else{ //wenn kein dritter Parameter angegeben ist, wird das Array mit Zufallszahlen gefüllt
      for(int l = 0; l < array.length; l++){
         array[l] = numberGenerator.nextInt();
      }
    }
    
    // Messung der Laufzeit während der Sortierung, die Sortierung wird anhand des zweiten Parameters bestimmt. Wenn kein zweiter gegeben
    // ist, wird mit MergeSort sortiert
    long tStart, tEnd, msecs;
    tStart = tEnd = 0;
    if(args.length == 1){
       tStart = System.currentTimeMillis();
       mergeSort(array);
       tEnd = System.currentTimeMillis();}
    else if(args.length >= 2 && args[1].equals("merge")){
       tStart = System.currentTimeMillis();
       mergeSort(array);
       tEnd = System.currentTimeMillis();}  
    else if(args.length >= 2 && args[1].equals("insert")){
       tStart = System.currentTimeMillis();
       insertionSort(array);
       tEnd = System.currentTimeMillis();}
    else if(args.length >= 2){ throw new IOException();}

    msecs = tEnd - tStart;
   
   //Überprüfung, ob das Array korrekt sortiert ist
   if(isSorted(array)){ System.out.println("Feld sortiert!");}
   else{System.out.println("Feld NICHT sortiert!");}
   
   //Ausgabe der benötigten Zeit und des Arrays, falls es höchstens 100 Elemente hat
   System.out.println("Benötigte Zeit: "+ msecs + " Millisekunden");
   if(anzahl <=100){
     for(int w = 0; w < array.length; w++){
        System.out.print(array[w]+",");
     }
    System.out.println();
   }
}
catch(NumberFormatException e){ System.out.println("Bitte geben sie eine Zahl ein. \nSyntax: java Sortierung1 Zahl (optional: insert oder merge (für die Sortierart) - auf, ab oder rand (für die Art der Füllung des Arrays)).");}
catch(IllegalArgumentException e){System.out.println("Bitte positiven Wert eingeben. \nSyntax: java Sortierung1 Zahl (optional: insert oder merge (für die Sortierart) - auf, ab oder rand (für die Art der Füllung des Arrays)).");}
catch(IOException e ){System.out.println("Sie haben falsche Parameter angegeben. \nSyntax: java Sortierung1 Zahl (optional: insert oder merge (für die Sortierart) - auf, ab oder rand (für die Art der Füllung des Arrays)).");}
catch(Exception e){System.out.println("Die Eingabe war nicht korrekt. \nDer richtige Syntax lautet: java Sortierung1 Zahl (optional: insert oder merge (für die Sortierart) - auf, ab oder rand (für die Art der Füllung des Arrays)).");}
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
        return false;}
   }
   return true;
}

public static void mergeSort(int[] array){
  int[] tmpArray = new int[array.length];
  mergeSort(array, tmpArray, 0, array.length-1);
  assert isSorted(array);
}

public static void mergeSort(int[] array, int[] tmpArray, int left, int right){
  if(left < right){
     int middle = (left+right)/2;
     mergeSort(array,tmpArray,left, middle);
     mergeSort(array,tmpArray,middle+1, right);
     merge(array,tmpArray,left,middle,right);
  }
}



private static void merge(int[] array, int[] tmpArray, int left, int middle, int right){
     tmpArray = array;
     int links = left;
     int rechts = middle+1;
     int index = left;
     
     while(links <= middle && rechts <= right){
         if(tmpArray[links] < tmpArray[rechts]){
           array[index] = tmpArray[links];
           links++;}
   else{
     array[index] = tmpArray[rechts];
     rechts++;}
   index++;  
     }
     
     while(links < middle){
   array[index]=tmpArray[links];
   links++;
   index++;
     }
     
//      while(rechts < right){
//          array[index]=tmpArray[rechts];
//          rechts++;
//          index++;
//      }wird weggelassen, da der Rest schon sortiert ist??
}
}
