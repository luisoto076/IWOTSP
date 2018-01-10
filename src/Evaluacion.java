import org.moeaframework.problem.tsplib.TSPInstance;
import org.moeaframework.problem.tsplib.Tour;

public class Evaluacion{

	private static TSPInstance problem = null;
	
	public static void inicializaTSPInstance(TSPInstance p){
		problem = p;
	}

    public static double evalua(int[] base){
		double max = 200000 - Tour.createTour(base).distance(problem);
		for(int i = 0; i < base.length; i++){
			for(int j = 0; j < base.length; j++){
				if(base[i] == base[j] && i != j){
					max = max - 8000;
				}
			}
		}
		return max;
    }

    public static double desviacionEstandar(int iterMax,int iterAct,int indiceMod,double valorIni,double valorFin){
		double div = (iterMax - iterAct) / (iterMax*(1.0));
		double exp = Math.pow(div,indiceMod);
		double desvEst = exp * (valorIni - valorFin) + valorFin;
		return desvEst;
    }

}
