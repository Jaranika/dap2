public class Interval implements Comparable<Interval>{
    
    int start, end;
    
    public Interval(int a, int b){
        start = a;
        end = b;
    }
    
    public int getStart(){return start;}
    
    public int getEnd(){return end;}
    
    public String toString(){return "["+start+", "+end+"]";}
    
    @Override
    public int compareTo(Interval other){
        if(this.getEnd() < other.getEnd()){return -1;}
        else if(this.getEnd() == other.getEnd()){return 0;}
        else {return 1;}
    }

}
