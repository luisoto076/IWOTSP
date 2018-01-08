import java.util.ArrayList;

public class Hierba{

    private int[] hierba;
    private double fitness;
	
    public double getFitness(){
	return fitness;
    }

    public int[] getHierba(){
	return this.hierba;
    }
	
    public Hierba(int[] hierba){
	this.hierba = hierba;
	this.fitness = Evaluacion.evalua(this.hierba); 
    }
    
    public int compareTo(Object o){
	if(!(o instanceof Hierba))
	    throw new IllegalArgumentException();
	Hierba h = (Hierba)o;
	double d = this.fitness - h.fitness;
	if( d < 0)
	    return 1;
	if(d  > 0)
	    return -1;
	return 0;
    }
    
    public String toString(){
    	return ""+ fitness;
    }
    

}
