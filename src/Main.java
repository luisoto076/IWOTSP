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
    	String instancia = args[3];
		int semilla = Integer.parseInt(args[0]);
		double wini = Double.parseDouble(args[1]);
		double wfin = 0.001;
		int n = 5;
		int indiceMod = 2;
		int iterMax = Integer.parseInt(args[2]) ;
		int maxPop = 200;
		int maxReproducion = 50;
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
		Iwo iwo = new Iwo(csa,rep,wini,wfin,n,indiceMod,iterMax,maxPop,semilla,problem.getDimension());
		Poblacion res = iwo.algoritmo();
		@SuppressWarnings("unchecked") ArrayList<Hierba> l = new ArrayList(res.values());
		l.sort((a, b) -> a.compareTo(b)); 
		for(Hierba h : l){
			Tour t = Tour.createTour(h.getHierba());
			System.out.println(t+" "+(100*(t.distance(problem)-min)/ min));
		}
	}
}
