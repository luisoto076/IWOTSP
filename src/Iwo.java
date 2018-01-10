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
	private int semilla;
	private int tamS;
		
	public Iwo(CreaSolucionAleatoria csa,Reproduccion rep, double wini, double wfin, int n, int indiceMod, int iterMax, int maxPop, int semilla, int tamS){
		this.csa = csa;
		this.rep = rep;
		this.wini = wini;
		this.wfin = wfin;
		this.n = n;
		this.indiceMod = indiceMod;
		this.iterMax = iterMax;
		this.maxPop = maxPop;
		this.semilla = semilla;
		this.tamS = tamS;
	}
	
	public Poblacion algoritmo(){
		Poblacion pop = csa.creaPoblacionInicial(n,tamS,semilla);
		int iter = 0;
		double wi = wini;
		while(iter < iterMax){
			System.out.println("iteracion: "+ (iter+1)+" de: "+csa.getDesvEst());
			Poblacion semillas = rep.reproduceTodos(pop);
			pop.addAll(semillas);
			if(pop.size() > maxPop){
				pop.competir(maxPop);
			}
			csa.setDesvEst(Evaluacion.desviacionEstandar(iterMax,iter,indiceMod,wini,wfin));
			iter = iter +1;
		}
		
		return pop;
		
	}

}
