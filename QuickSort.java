import java.util.*;
import java.io.*;
public class QuickSort{

public static void main(String args[]){
  try{  
    if(args.length == 1){
        int laenge = Integer.parseInt(args[0]);
        if(laenge < 0){throw new IllegalArgumentException();}
        int[] array = array(laenge);//array wird gefüllt
        long tEnd, tStart, msecs;
        
        tStart = System.currentTimeMillis();//Laufzeitmessung
        quicksort(array, 0, array.length-1);
        tEnd = System.currentTimeMillis();
        msecs = tEnd - tStart;
        
        System.out.println("Zeit: "+ msecs/100);
        System.out.println("Sorted: "+isSorted(array));
    }
    else{
        throw new IOException();
    }
  }
  catch(IOException e){System.out.println("Bitte geben sie eine Zahl ein.");}
  catch(NumberFormatException e){System.out.println("Bitte geben sie eine Zahl ein.");}
  catch(IllegalArgumentException e){System.out.println("Bitte geben sie eine positive Zahl ein.");}
  catch(Exception e){System.out.println("Die Eingabe war nicht korrekt.\nSyntax: java QuickSort Zahl");}

}


public static void quicksort(int[] a, int l, int r){
  if(l < r){
    int i = l;
    int k = r;
    int pivot = a[(l+r)/2];
    while(i < k){
        while(a[i]<pivot){
            i++;
        }
        while(a[k]> pivot){
            k--;
        }
        if(i <= k){
            int tmp = a[i];
            a[i] = a[k];
            a[k] = tmp;
            i++;
            k--;
        }
    }
    quicksort(a,l,k);
    quicksort(a,i,r);
  }
}

public static boolean isSorted(int[] a){//überprüft ob ein Array sortiert ist
    for(int i = 0; i < a.length-1; i++){
        if(a[i] > a[i+1] ){return false;}
    }
    return true;
}

public static int[] array(int laenge){//erzeugt ein Array gefüllt mit Zufallszahlen mit der eingegebenen Länge 
    java.util.Random numberGenerator = new java.util.Random();
    int[] array = new int [laenge];
    for(int i = 0; i < array.length; i++){
        array[i] = numberGenerator.nextInt();
    }
    return array;
}



}
