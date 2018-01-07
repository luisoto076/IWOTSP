import java.util.Random;
import java.util.ArrayList;

public class CreaSolucionAleatoria{

	private int tamanio;
	private Random random;
	
	public CreaSolucionAleatoria(int tamanio,int semilla){
		this.tamanio = tamanio;
		this.random = new Random(semilla);
	}

	public Hierba creaSolucioAleatoria(int[] base){
		int[] q = new int[base.length];
		for(int i = 0; i < base.length;i++){
			q[i] = (int)Math.round(random.nextGaussian() * 0.5 + base[i]);
		}
		return new Hierba(q);
	}
	
	public ArrayList<Hierba> creaPoblacionInicial(int tam, int[] base){
		ArrayList<Hierba> pop = new ArrayList<>();
		for(int i = 0; i < tam; i++){
			pop.add(creaSolucioAleatoria(base));
		}
		return pop;
	}

}
