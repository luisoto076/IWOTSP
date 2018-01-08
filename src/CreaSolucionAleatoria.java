import java.util.Random;
import java.util.ArrayList;

public class CreaSolucionAleatoria{

	private double desvEst;
	private Random random;
	
	public int[] creaSolucionInicial(int tamanio, int semilla){
		Random r = new Random(semilla);
		int[] sol = new int[tamanio];
		for(int i = 1; i<tamanio+1;i++){
			sol[i-1] = i;
		}
		
		for(int i = 0; i < tamanio * 2; i++){
			int j = r.nextInt(tamanio);
			int k = r.nextInt(tamanio);
			int aux = sol[j];
			sol[j] = sol[k];
			sol[k] = aux;
		}
		
		return sol;
		
	}
	
	public CreaSolucionAleatoria(double desvEst,int semilla){
		this.desvEst = desvEst;
		this.random = new Random(semilla);
	}
	
	public void setDesvEst(double desvEst){
		this.desvEst = desvEst;
	}

	public Hierba creaSolucioAleatoria(int[] base){
		int[] q = new int[base.length];
		for(int i = 0; i < base.length;i++){
			q[i] = (int)Math.round(random.nextGaussian() * this.desvEst + base[i]);
		}
		return new Hierba(q);
	}
	
	public Poblacion creaPoblacionInicial(int tam, int[] base){
		Poblacion pop = new Poblacion();
		for(int i = 0; i < tam; i++){
			pop.add(creaSolucioAleatoria(base));
		}
		return pop;
	}

}
