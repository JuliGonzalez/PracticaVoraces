import java.util.ArrayList;

public class Pruebas {
    private static final int cifras=36;
    public static void main(String[] args){
        NumeroMasCercanos rm = new NumeroMasCercanos();
        UtilArrays genNumeros=new UtilArrays();
        ArrayList<Integer> conjuntoCifras;
        long [] resul;

        conjuntoCifras=genNumeros.rellenaCandidatos(cifras);
        genNumeros.imprimeArray(conjuntoCifras);
        resul=rm.VorazNumerosCercanos(conjuntoCifras);

        System.out.println("El primer  Numero es: " +resul[0]);
        System.out.println("El segundo Numero es: " +resul[1]);

      }
    }

