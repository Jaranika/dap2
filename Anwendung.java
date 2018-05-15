import java.io.*;  //importiert FileReader, BufferedReaderund Exceptions
import java.util.*;  //importiert ArrayList, Collections, StringTokenizer und NoSuchElementException
public class Anwendung{

    public static void main(String args[]){
        try{
            if(args.length == 2){
                boolean interval;
                if(args[0].equals("Interval")){interval = true;}
                else if(args[0].equals("Lateness")){interval = false;}
                else{throw new IOException();}
                String path = args[1];
                if(interval){
                    ArrayList<Interval> arraylist = new ArrayList<Interval>();
                    BufferedReader file = new BufferedReader(new FileReader(path));
                    String zeile = file.readLine();
                    while(zeile != null){
                        StringTokenizer st = new StringTokenizer(zeile,",");
                        int start = Integer.parseInt(st.nextToken());
                        int ende = Integer.parseInt(st.nextToken());
                        Interval v = new Interval(start, ende);
                        arraylist.add(v);
                        zeile = file.readLine();
                    }
                
                    
                    //Ausgabe vorher
                    String filename = path.substring(path.lastIndexOf("\\")+path.indexOf("aten"));
                    filename = "\"" + filename +"\"";
                    System.out.println("Bearbeite Datei: "+filename+".\n");
                    System.out.println("Es wurden "+arraylist.size()+" Zeilen mit folgendem Inhalt gelesen:");
                    System.out.print("[");
                    for(int i = 0; i < arraylist.size()-1; i++){
                        System.out.print(arraylist.get(i).toString()+", ");
                    }
                    System.out.print(arraylist.get(arraylist.size()-1));
                    System.out.print("]");
                    System.out.println("\n");
                
                    //Sortierung
                    Collections.sort(arraylist);
                
                    
                    //Ausgabe sortiert
                    System.out.println("Sortiert:");
                    System.out.print("[");
                    for(int k = 0; k < arraylist.size()-1; k++){
                        System.out.print(arraylist.get(k).toString()+", ");
                    }
                    System.out.print(arraylist.get(arraylist.size()-1));
                    System.out.print("]");
                    System.out.println("\n");
                
                    //Intervallscheduling
                    ArrayList<Interval> ergebnis = intervalScheduling(arraylist);
                
                    //Ausgabe Ergebnis
                    System.out.println("Berechnete Intervallscheduling:");
                    System.out.print("[");
                    for(int q = 0; q < ergebnis.size()-1; q++){
                        System.out.print(ergebnis.get(q).toString()+", ");
                    }
                    System.out.print(ergebnis.get(ergebnis.size()-1));
                    System.out.print("]");
                    System.out.println();
                    
                    
                 }
                else{
                    ArrayList<Job> arraylist = new ArrayList<Job>();
                    BufferedReader file = new BufferedReader(new FileReader(path));
                    String zeile = file.readLine();
                    while(zeile != null){
                        StringTokenizer st = new StringTokenizer(zeile,",");
                        int dauer = Integer.parseInt(st.nextToken());
                        int abgabe = Integer.parseInt(st.nextToken());
                        Job j = new Job(dauer, abgabe);
                        arraylist.add(j);
                        zeile = file.readLine();
                    }
                    
                    //Ausgabe vorher
                    String filename = path.substring(path.lastIndexOf("\\")+path.indexOf("aten"));
                    filename = "\"" + filename +"\"";
                    System.out.println("Bearbeite Datei: "+filename+".\n");
                    System.out.println("Es wurden "+arraylist.size()+" Zeilen mit folgendem Inhalt gelesen:");
                    System.out.print("[");
                    for(int i = 0; i < arraylist.size()-1; i++){
                        System.out.print(arraylist.get(i).toString()+", ");
                    }
                    System.out.print(arraylist.get(arraylist.size()-1));
                    System.out.print("]");
                    System.out.println("\n");
                
                    //Sortierung
                    Collections.sort(arraylist);
                
                    
                    //Ausgabe sortiert
                    System.out.println("Sortiert:");
                    System.out.print("[");
                    for(int k = 0; k < arraylist.size()-1; k++){
                        System.out.print(arraylist.get(k).toString()+", ");
                    }
                    System.out.print(arraylist.get(arraylist.size()-1));
                    System.out.print("]");
                    System.out.println("\n");
                
                    //Latenessscheduling
                    int[] ergebnis = latenessScheduling(arraylist);
                
                    //Ausgabe Ergebnis
                    System.out.println("Berechnetes Latenessscheduling:");
                    System.out.print("[");
                    for(int q = 0; q < ergebnis.length-1; q++){
                        System.out.print(ergebnis[q]+", ");
                    }
                    System.out.print(ergebnis[ergebnis.length-1]);
                    System.out.print("]");
                    System.out.println("\n");
                    
                }
            
            }
           else{throw new IllegalArgumentException();}
        }
        catch(NumberFormatException e){//wird geworfen falls aus der Datei kein int-Wert geparst werden konnte
            System.out.println("Fehler beim Einlesen der Datei.\nKeine Zahlen zum Einlesen gefunden.");}
        catch(NoSuchElementException e){//wird von StringTokenizer geworfen, falls keine weiteren Elemente in der Zeile vorhanden sind
            System.out.println("Fehler beim Einlesen der Datei.\nKeine weiteren Zeichen vorhanden.");}
        catch(NullPointerException e){//wird von StringTokenizer geworfen, falls keine weitere Zeile vorhanden ist
            System.out.println("Fehler beim Einlesen der Datei.\nKeine weiteren Zeilen vorhanden.");}
        catch(FileNotFoundException e){//wird von FileReader geworfen
            System.out.println("Dateipfad nicht gefunden.");}
        catch(IllegalArgumentException e){//wird bei falscher Paramteranzahl geworfen
            System.out.println("Falsche Parameteranzahl.\nSyntax: java Anwendung Interval/Lateness Dateipfad");}
        catch(IOException e){//wird von BufferedReader geworfen
            System.out.println("Falsche Eingabe des Dateipfads.");}
        catch(Exception e){System.out.println("Falsche Eingabe");}
    
    }
    
     public static ArrayList<Interval> intervalScheduling(ArrayList<Interval> intervals){
        ArrayList<Interval> ergebnis = new ArrayList<Interval>();
        ergebnis.add(intervals.get(0));
        int j = 0;
        for(int i = 1; i < intervals.size(); i++){//arraylist bei 0 oder 1?
            if(intervals.get(i).getStart() >= intervals.get(j).getEnd()){
                ergebnis.add(intervals.get(i));
                j = i;
            }
        
        }
        return ergebnis;
    } 
    
    public static int[] latenessScheduling(ArrayList<Job> jobs){
        int[] ergebnis = new int[jobs.size()];
        int z = 0;
        for(int i = 0; i < jobs.size(); i++){
            ergebnis[i] = z;
            z = z + jobs.get(i).getDauer();
        }
        return ergebnis;
    
    
    }
}
