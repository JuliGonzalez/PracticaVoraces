import java.util.ArrayList;

/**
 * Created by matrix on 10/11/17.
 */
public class UtilArrays {
    public UtilArrays() {

    }

    /* Método que genera tantos números aleatorios comprendidos entre 1 y 9
       como le indique el parámetro numeroCifras que recibe y los introduce en
       un ArrayList que luego devuelve
    */
    public ArrayList<Integer> rellenaCandidatos(int numeroCifras){
        ArrayList<Integer> candidato =new ArrayList<Integer>();
        int numero;
        numero = (int) (Math.random() * 9) + 1;
        for(int i=0;i<numeroCifras;i++){
            numero = (int) (Math.random() * 9) + 1;
            candidato.add(numero);
        }

        return candidato;
    }
    /* Método que imprime los elementos de un ArrayList
   */
    public void imprimeArray(ArrayList<Integer> miArray){
        int numero;
        System.out.print("Los " + miArray.size()+ " números del ArrayList son: ");
        for(int i=0;i<miArray.size();i++){
            numero = miArray.get(i);
            if (i!=miArray.size()-1)System.out.print(numero+ ",");
            else System.out.print(numero);
        }
        System.out.println();
    }
}
