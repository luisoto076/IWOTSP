import java.util.Hashtable;
import java.util.ArrayList;

public class Poblacion extends Hashtable<String,Hierba>{
	
	public Poblacion(){
		super();
	}

	public double peorFitness(){
	    double peor = Double.POSITIVE_INFINITY;
	    double fitHierba = 0.0;
	    for(Hierba h: this.values()){
			fitHierba = h.getFitness();
			if(fitHierba < peor)
		    	peor = fitHierba;
	    }
	    return peor;
	}
	
	public Hierba mejorHierba(){
	    double mejor = Double.NEGATIVE_INFINITY;
	    double fitHierba = 0.0;
	    Hierba hm = null;
	    for(Hierba h: this.values()){
			fitHierba = h.getFitness();
			if(fitHierba > mejor){
		    	mejor = fitHierba;
		    	hm = h;
		    }
	    }
	    return hm;
	}
	
	public void add(Hierba h){
		this.put(h.toString(),h);
	}
	
	public double mejorFitness(){
	    double mejor = Double.NEGATIVE_INFINITY;
	    double fitHierba = 0.0;
	    for(Hierba h: this.values()){
		fitHierba = h.getFitness();
		if(fitHierba > mejor)
		    mejor = fitHierba;
	    }
	    return mejor;
	}
	
	
	
	public void competir(int maxPop){
		@SuppressWarnings("unchecked") ArrayList<Hierba> alh = new ArrayList(this.values());
		alh.sort((a, b) -> a.compareTo(b));
		for(int i = maxPop; i < alh.size();i++){
			this.remove(alh.get(i).toString());	
		}
	}

}
