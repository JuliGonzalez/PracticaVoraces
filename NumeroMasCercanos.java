import java.util.ArrayList;

/**
 * Created by matrix on 30/10/17.
 */
public class NumeroMasCercanos {
 private boolean primerosSolos;

    public boolean isPrimerosSolos() {
        return primerosSolos;
    }

    public void setPrimerosSolos(boolean primerosSolos) {
        this.primerosSolos = primerosSolos;
    }

    public NumeroMasCercanos() {

    }

     /* Metodo que recibe como parametro un ArrayList de números entre 1 y 9
       e implementa un algoritmo basado en un esquema Voraz para devolver
       los dos numeros mas cercanos que se pueden generar a partir de todos
       los numeros del ArrayList.
       Se pueden utilizar otros métodos adicionales
   */
    public long[] VorazNumerosCercanos(ArrayList<Integer> conjuntoNumeros) {
        long[] solucion = new long[2];
        ArrayList<Integer> solucionAux1 = new ArrayList<Integer>();
        setPrimerosSolos(false);
        String aux1 = "";
        String aux = "";
        int valor1, valor2;
        int[] cuenta = new int[10];
        for (int i = 0; i < cuenta.length; i++) {
            for (int j = 0; j < conjuntoNumeros.size(); j++) {
                if (conjuntoNumeros.get(j) == i)
                    cuenta[i]++;
            }
        }

        while (!conjuntoNumeros.isEmpty()) {
            solucionAux1 = seleccionarCandidato(cuenta,primerosSolos);
            conjuntoNumeros.remove(new Integer(solucionAux1.get(0)));
            conjuntoNumeros.remove(new Integer(solucionAux1.get(1)));
            aux = aux + solucionAux1.get(0);
            aux1 = aux1 + solucionAux1.get(1);
        }
        solucion[0] = Long.parseLong(aux);
        solucion[1] = Long.parseLong(aux1);
        return solucion;
    }

    private ArrayList<Integer> seleccionarCandidato(int[] cuenta, boolean primerosSolos) {
        ArrayList<Integer> candidatos = new ArrayList<Integer>();
        ArrayList<Integer> candidatosSolos = new ArrayList<Integer>();
        int diferencia = 9, diferenciaActual = 0, candidato = 0, candidato1 = 0, j=9;
        boolean HayParejas = false;
        while (!HayParejas && j>0){
            if (cuenta[j] > 1) HayParejas = true;
            j--;
        }

        if (HayParejas) {
            for (int i = 9; i >= 0; i--) {
                if (cuenta[i] > 1) {
                    candidatos.add(i);
                    candidatos.add(i);
                    cuenta[i] = cuenta[i] - 2;
                    return candidatos;
                }

            }
        } else {candidatosSolos = menosDiferencia(cuenta);
            if (!primerosSolos) {

                for (int z = 0; z < candidatosSolos.size() - 1; z++) {
                    diferenciaActual = candidatosSolos.get(z) - candidatosSolos.get(z + 1);
                    if (diferenciaActual <= diferencia) {
                        diferencia = diferenciaActual;
                        candidato = candidatosSolos.get(z);
                        candidato1 = candidatosSolos.get(z + 1);
                    }
                }
                candidatos.add(candidato);
                cuenta[candidato]--;
                cuenta[candidato1]-- ;
                candidatos.add(candidato1);
                candidatosSolos.remove(new Integer(candidato));
                candidatosSolos.remove(new Integer(candidato1));
                setPrimerosSolos(true);
                return candidatos;

            }else {
                for (int a = 0; a < candidatosSolos.size(); a++) {
                    candidato = candidatosSolos.get(0);
                    candidato1 = candidatosSolos.get(candidatosSolos.size() - 1);
                    candidatos.add(candidato1);
                    candidatos.add(candidato);
                    cuenta[candidato]--;
                    cuenta[candidato1]-- ;
                    candidatosSolos.remove(new Integer(candidato));
                    candidatosSolos.remove(new Integer(candidato1));
                    return candidatos;
                }
            }
        }
        return null;
    }

    private ArrayList<Integer> menosDiferencia(int[] cuenta) {
        ArrayList<Integer> resul = new ArrayList<Integer>();
        for (int j=9; j>=0;j--) {
            if (cuenta[j] > 0)
                resul.add(j);
        }
        return resul;
    }
}

