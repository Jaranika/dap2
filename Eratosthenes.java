public class Eratosthenes {
  
  public static boolean[] makeArray( int n )    //methode, die ein Feld der richtigen groesse erstellt
  {
    boolean[] arr = new boolean[n+1];
    for(int i = 0; i < arr.length; i++)
    {
      arr[i] = true;              //vor bearbeitung sollen alle zahlen als Primzahlen 
    }                      //angesehen werden
    return arr;
  }
  
  public static int countPrimes( int n )      //methode, die die anzahl der Primzahlen zurückgibt
  {
    boolean[] arr = makeArray(n);
    int count = 0;
    for(int i = 2; i<arr.length/2; i++)      //durch zwei, da j = i*2 ab dort immer > arr.length wäre
    {
      if(arr[i])                //wenn !arr[i] gilt, sind seine Vielfachen bereits false
      {
        int j = i * 2;
        while(j < arr.length)
        {
          arr[j] = false;
          j = j + i;            //um die i-er Reihe durchzugehen (alle vielfachen von i)
        }
      }
    }
    for(int l = 3; l < arr.length; l++)      //extra for-Schleife, die die übrigen true-werte zählt
    {
      if(arr[l])
      {
        count++;
      }
    }
    return count;
  }
  
  public static String showPrimes( int n )
  {
    boolean[] arr = makeArray(n);
    String s = "";
    for(int i = 2; i<arr.length/2; i++)
    {
      if(arr[i])
      {
        int j = i * 2;
        while(j < arr.length)
        {
          arr[j] = false;
          j = j + i;
        }
      }
    }                      //bis hier die selbe methode wie countPrimes
    for( int k = 3; k<arr.length; k++)      //extra for-Schleife, um den String mit primzahlen zu
    {                      //ergänzen (es gild immer k = arr [k]
      if(arr[k])
      {
        s += k + ",";
      }
    }
    return s;
  }

  public static void main(String[] args)
  {
    try
    {
      if(args.length != 1 && args.length != 2)
      {
        throw new Exception("bitte genau zwei Parameter angeben");
      }
      int grenze = Integer.parseInt(args[0]); String ergebnis = "";
      if(args.length == 1)
      {
        ergebnis += countPrimes(grenze);
      }
      else
      {
        if(args[1].equals("-o") )
        {
          ergebnis += countPrimes(grenze) + showPrimes(grenze);
        }
      }
      System.out.println(ergebnis);
    }
    catch(Exception e) { System.out.println("bitte als ersten Parameter eine Zahl und als zweiten optionalen -o auswählen");}
  }
}
