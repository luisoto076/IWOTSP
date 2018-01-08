import java.util.ArrayList;

public class Poblacion extends ArrayList<Hierba>{
	
	public Poblacion(){
		super();
	}

	public double peorFitness(){
	    double peor = this.get(0).getFitness();
	    double fitHierba = 0.0;
	    for(Hierba h: this){
			fitHierba = h.getFitness();
			if(fitHierba < peor)
		    	peor = fitHierba;
	    }
	    return peor;
	}
	
	public double mejorFitness(){
	    double mejor = this.get(0).getFitness();
	    double fitHierba = 0.0;
	    for(Hierba h: this){
		fitHierba = h.getFitness();
		if(fitHierba > mejor)
		    mejor = fitHierba;
	    }
	    return mejor;
	}
	
	public void competir(int maxPop){
		this.sort((a, b) -> a.compareTo(b));
		this.removeRange(maxPop,this.size());
	}

}
