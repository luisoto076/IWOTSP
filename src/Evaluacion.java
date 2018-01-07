public class Evaluacion{

    public static double evalua(int[] base){
	double max = 10000;
	for(int i=0; i < base.length; i++){
	    for(int j=0; j < base.length; j++){
		if(base[i] == base[j] && i != j){
		    max = max - 100;
		}
	    }
	}
	return max;
    }

    public static double desviacionEstandar(int iterMax,int iterAct,int indiceMod,double valorIni,double valorFin){
	double div = (iterMax - iterAct) / iterMax;
	double exp = Math.pow(div,indiceMod);
	double desvEst = exp * (valorIni - valorFin) + valorFin;
	return desvEst;
    }

}
