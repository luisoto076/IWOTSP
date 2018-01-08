import java.util.ArrayList;

public class Iwo{

	private CreaSolucionAleatoria csa;
	private Reproduccion rep;
	private double wini;
	private double wfin;
	private int n;
	private int indiceMod;
	private int iterMax;
	private int maxPop;
	private int[] inicial;
		
	public Iwo(CreaSolucionAleatoria csa,Reproduccion rep, double wini, double wfin, int n, int indiceMod, int iterMax, int maxPop, int[] inicial){
		this.csa = csa;
		this.rep = rep;
		this.wini = wini;
		this.wfin = wfin;
		this.n = n;
		this.indiceMod = indiceMod;
		this.iterMax = iterMax;
		this.maxPop = maxPop;
		this.inicial = inicial;
	}
	
	public Poblacion algoritmo(){
		Poblacion pop = csa.creaPoblacionInicial(n,inicial);
		System.out.println(pop);
		pop.sort((a, b) -> a.compareTo(b));
		System.out.println(pop);
		int iter = 0;
		double wi = wini;
		while(iter < iterMax){
			System.out.println("iteracion: "+ (iter+1));
			Poblacion semillas = rep.reproduceTodos(pop);
			pop.addAll(semillas);
			if(!(semillas.size()+semillas.size() < maxPop)){
				pop.competir(maxPop);
			}
			csa.setDesvEst(Evaluacion.desviacionEstandar(iterMax,iter,indiceMod,wini,wfin));
			iter = iter +1;
		}
		
		return pop;
		
	}

}
