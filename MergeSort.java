import java.util.*;

public class MergeSort {
    public int counter = 0;

    public MergeSort() {
        Integer[] lista = crearLista(-1);

        System.out.println("Lista original: ");
        System.out.println(Arrays.toString(lista));

        mergeSort(lista);

        System.out.println("Lista ordenada: ");
        System.out.println(Arrays.toString(lista));

        System.out.println("Elementos: " + lista.length);
        System.out.println("Comparaciones: " + counter);
    }

    public MergeSort(int cantTerminos) {

        Integer[] lista = crearLista(cantTerminos);
        mergeSort(lista);

        System.out.println("Elementos: " + lista.length);
        System.out.println("Comparaciones: " + counter);
    }

    public Integer[] crearLista(int cantTerminos) {
        // Crear lista con términos aleatorios.

        if (cantTerminos < 0) {
            System.out.println("Ingrese la cantidad de términos:");
            Scanner in = new Scanner(System.in);
            cantTerminos = Integer.parseInt(in.nextLine());
            in.close();
        }

        Integer[] lista = new Integer[cantTerminos];

        for (int i = 0; i < cantTerminos; i++) {
            lista[i] = (int) Math.floor(Math.random() * 100);
        }

        return lista;
    }

    public Integer[] mergeSort(Integer[] list) {
        // Caso base
        if (list.length <= 1) {
            return list;
        }

        // Temporales
        Integer[] primero = new Integer[list.length / 2];
        Integer[] segundo = new Integer[list.length - primero.length];

        // Copiar a los temporales
        System.arraycopy(list, 0, primero, 0, primero.length);
        System.arraycopy(list, primero.length, segundo, 0, segundo.length);

        mergeSort(primero);
        mergeSort(segundo);

        merge(primero, segundo, list);
        return list;
    }

    private void merge(Integer[] primero, Integer[] segundo, Integer[] resp) {
        int iPr = 0, iSg = 0, iMgd = 0;
        counter++;

        while (iPr < primero.length && iSg < segundo.length) {
            if (primero[iPr].compareTo(segundo[iSg]) < 0) {
                resp[iMgd] = primero[iPr];
                iPr++;
            } else {
                resp[iMgd] = segundo[iSg];
                iSg++;
            }
            iMgd++;
        }

        System.arraycopy(primero, iPr, resp, iMgd, primero.length - iPr);
        System.arraycopy(segundo, iSg, resp, iMgd, segundo.length - iSg);
    }
}