import java.util.ArrayList;

public class Reproduccion{

	private int maxReproducion;
	private CreaSolucionAleatoria csa;
	
	public Reproduccion(int maxReproducion, CreaSolucionAleatoria csa){
		this.maxReproducion = maxReproducion;
		this.csa = csa;
	}
	
	public Poblacion reproduceUno(int total, Hierba hierba){
		Poblacion semillas = new Poblacion();
		for(int i = 0; i< hierba.getHierba().length;i++){
			semillas.add(csa.creaSolucioAleatoria(hierba.getHierba()));
		}
		return semillas;
	}
	
	private int calculaRepNum(Poblacion pop, Hierba h){
		return (int)(1 + (maxReproducion-1)*((h.getFitness()-pop.peorFitness())/(pop.mejorFitness()-pop.peorFitness())));
	}
	
	public Poblacion reproduceTodos(Poblacion pop){
		Poblacion seedpop = new Poblacion();
		for(Hierba h : pop){
			seedpop.addAll(reproduceUno(calculaRepNum(pop,h),h));
		}
		return seedpop;
	}


}
