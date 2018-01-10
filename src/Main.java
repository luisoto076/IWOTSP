import org.moeaframework.problem.tsplib.TSPInstance;
import org.moeaframework.problem.tsplib.DistanceTable;
import org.moeaframework.problem.tsplib.Tour;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Ejemplo de como leer los archivos tsp
 */
public class Main{

    public static void main(String[] args) throws IOException{
    	String instancia = "ulysses16";
		int semilla = Integer.parseInt(args[0]);
		double wini = Double.parseDouble(args[1]);
		double wfin = 0.001;
		int n = 10;
		int indiceMod = 3;
		int iterMax = Integer.parseInt(args[2]) ;
		int maxPop = 500;
		int maxReproducion = 40;
		CreaSolucionAleatoria csa = new CreaSolucionAleatoria(wini,semilla);
    	Reproduccion rep = new Reproduccion(maxReproducion,csa);
		TSPInstance problem = new TSPInstance(new File(String.format("data/tsp/%s.tsp",instancia)));
		Evaluacion.inicializaTSPInstance(problem);
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
		Hashtable<String,Integer[]> pop = new Hashtable<>();
		Integer[] y = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
		Integer[] z = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
		//Hierba t1 = new Hierba(y);
		//Hierba t2 = new Hierba(z);
		pop.put("Hola",y);
		pop.put("Hola",z);
		System.out.println(pop);
		Iwo iwo = new Iwo(csa,rep,wini,wfin,n,indiceMod,iterMax,maxPop,semilla,16);
		Poblacion res = iwo.algoritmo();
		for(Hierba h:res){
			Tour t = Tour.createTour(h.getHierba());
			System.out.println(t+" "+t.distance(problem));
		}
	}
}
