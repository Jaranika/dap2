public class Job implements Comparable<Job>{
    int dauer,abgabe;
    
    public Job(int a, int b){
        dauer = a;
        abgabe = b;
    }
    
    public int getDauer(){return dauer;}
    
    public int getAbgabe(){return abgabe;}
    
    public String toString(){return "["+dauer+", "+abgabe+"]";}
    
    @Override
    public int compareTo(Job other){
        if(this.getAbgabe() < other.getAbgabe()){return -1;}
        else if(this.getAbgabe() == other.getAbgabe()){return 0;}
        else{ return 1;}
    }

}
