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
    
    public ArrayList<Integer> obtenCiudades(){
	ArrayList<Integer> ciudades = new ArrayList<>();
	int ciudad = 0;
	int[] hierba = this.getHierva();
	for(int i=0; i < hierba.length; i++){
	    ciudad = hierba[i];
	    ciudades.add(ciudad);
	}
	return ciudades;
    }

}
