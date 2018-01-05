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
    	double tasaCruzamiento = 0.9;
    	double tasaMutacion = 0.9;
    	int semilla = 0;
    	int totalSeleccion = 2;
    	int maxIteracion = 2000;
    	int popSize = 200;
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
		Random random = new Random(semilla);
		for(int i = 0; i<10;i++){
			int[] q = new int[16];
			//System.out.println(Tour.createTour(p).distance(problem));
			for(int j = 0; j < 16;j++){
				q[j] = (int)Math.round(random.nextGaussian() * 0.5 + p[j]);
			}
			System.out.println(Tour.createTour(q));
			System.out.print("\n");
		}
		
	}
}
