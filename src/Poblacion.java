import java.util.ArrayList;

public class Poblacion{

	private ArrayList<Hierba> poblacion;
	
	public ArrayList<Hierba> getPop(){
		return poblacion;
	}
	
	public Poblacion(){
		this.poblacion = poblacion;
	}

	public double peorFitness(){
	    ArrayList<Hierba> poblado = this.getPop();
	    double peor = poblado.get(0).getFitness();
	    double fitHierba = 0.0;
	    for(Hierba h: poblado){
		fitHierba = h.getFitness();
		if(fitHierba < peor)
		    peor = fitHierba;
	    }
	    return peor;
	}
	
	public double mejorFitness(){
	    ArrayList<Hierba> poblado = this.getPop();
	    double mejor = poblado.get(0).getFitness();
	    double fitHierba = 0.0;
	    for(Hierba h: poblado){
		fitHierba = h.getFitness();
		if(fitHierba > mejor)
		    mejor = fitHierba;
	    }
	    return mejor;
	}

}
