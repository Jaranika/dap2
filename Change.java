import java.io.*;
public class Change{
    
    public static void main(String args[]){
      try{  
        if(args.length == 2){
            int[] wechsel;
            if(args[0].equals("Euro")){
                int[] w = {200,100,50,20,10,5,2,1};
                wechsel = w;
            }
            else if(args[0].equals("Alternative")){//nicht optimal für 8 z.b
                int[] w = {200,100,50,20,10,5,4,2,1};
                wechsel = w;
            }
            else{throw new IOException();}

            int b = Integer.parseInt(args[1]);
            if(b < 0){throw new IllegalArgumentException();}
            int[] geld = change(b, wechsel);
            
            System.out.print("Wechselgeld: "+geld[0]);
            for(int i = 1; i < geld.length; i++){
                System.out.print(" + "+geld[i]);
            }
            System.out.println();
        }
        else{throw new IOException();}
    
    
        }
       catch(NumberFormatException e){System.out.println("Sie haben keine Zahl angegeben.\nSyntax: java Change Euro/Alternative Zahl");}
       catch(IllegalArgumentException e){System.out.println("Bitte geben sie eine positive Zahl ein.\nSyntax: java Change Euro/Alternative Zahl");}
       catch(IOException e){System.out.println("Sie haben falsche Parameter angegeben.\nSyntax: java Change Euro/Alternative Zahl");}
       catch(Exception e){System.out.println("Die Eingabe war falsch.\nSyntax: java Change Euro/Alternative Zahl");}
    }
    
    public static int[] change(int b, int[] w){
        int k = 0;
        int[] out = new int[w.length];
        while(k < w.length){
            if(b >= w[k]){
                int n = 0;
                while((0 <= b - n*w[k]) && !(b - n*w[k] < w[k])){
                    n++;
                }
                out[k] = n;
                
                b = b - (n*w[k]);
            }
            k++;
            
        }
        return out;
    }
    //gierige Algorithmen wählen immer das zurzeit beste aus 

}
