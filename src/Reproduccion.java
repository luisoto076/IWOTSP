import java.util.ArrayList;

public class Reproduccion{

	private int maxReproducion;
	
	public ArrayList<Hierba> reproduceUno(int total, Hierba hierva){
		return null;
	}
	
	private int calculaRepNum(Poblacion pop, Hierba h){
		return (int)(1 + (maxReproducion-1)*((h.getFitness()-pop.peorFitness())/(pop.mejorFitness()-pop.peorFitness())));
	}
	
	public ArrayList<Hierba> reproduceTodos(Poblacion pop){
		ArrayList<Hierba> seedpop = new ArrayList<>();
		for(Hierba h : pop.getPop()){
			seedpop.addAll(reproduceUno(calculaRepNum(pop,h),h));
		}
		return seedpop;
	}


}
