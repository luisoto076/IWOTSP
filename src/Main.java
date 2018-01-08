import org.moeaframework.problem.tsplib.TSPInstance;
import org.moeaframework.problem.tsplib.DistanceTable;
import org.moeaframework.problem.tsplib.Tour;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

/**
 * Ejemplo de como leer los archivos tsp
 */
public class Main{

    public static void main(String[] args) throws IOException{
    	String instancia = "ulysses16";
		int semilla = 3;
		double wini = 0.5;
		double wfin = 0.001;
		int n = 10;
		int indiceMod = 3;
		int iterMax = 100;
		int maxPop = 1000;
		int maxReproducion = 20;
		CreaSolucionAleatoria csa = new CreaSolucionAleatoria(wini,semilla);
    	Reproduccion rep = new Reproduccion(maxReproducion,csa);
		int[] inicial = csa.creaSolucionInicial(16,semilla);
		TSPInstance problem = new TSPInstance(new File(String.format("data/tsp/%s.tsp",instancia)));
		System.out.println(problem.getName());
		System.out.println(problem.getDimension());
		double max = 100000;
		double min = 0;
		int[] p = null;
		try{
			problem.addTour(new File(String.format("data/tsp/%s.opt.tour",instancia)));
			for(Tour tour: problem.getTours()){
				System.out.println(tour);
				min = tour.distance(problem);
				p = tour.toArray();
				System.out.println(min);
			}
		}catch(Exception e){
		}
		Iwo iwo = new Iwo(csa,rep,wini,wfin,n,indiceMod,iterMax,maxPop,inicial);
		Poblacion res = iwo.algoritmo();
		for(Hierba h:res){
			Tour t = Tour.createTour(h.getHierba());
			System.out.println(t.distance(problem));
		}
	}
}
