import java.util.ArrayList;

public class Hierba{

    private int[] hierva;
    private double fitness;
	
    public double getFitness(){
	return fitness;
    }

    public int[] getHierva(){
	return this.hierva;
    }
	
    public Hierba(int[] hierva){
	this.hierva = hierva;
	this.fitness = Evaluacion.evalua(this.hierva); 
    }
    
    public int compareTo(Object o){
	if(!(o instanceof Hierba))
	    throw new IllegalArgumentException();
	Hierba h = (Hierba)o;
	double d = this.fitness - h.fitness;
	if( d < 0)
	    return -1;
	if(d  > 0)
	    return 1;
	return 0;
    }
    

}
