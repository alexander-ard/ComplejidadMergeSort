import java.util.Scanner;

public class Graficador {

    public MergeSort ms;

    public Graficador() {
        crearLista();
    }

    public void crearLista() {
        System.out.print("Ingrese la cantidad de términos: ");

        Scanner in = new Scanner(System.in);
        int cantTerminos = Integer.parseInt(in.nextLine());
        in.close();

        Integer[][] list = new Integer[cantTerminos][2];

        int counter = 0;

        for (int i = 0; i < cantTerminos; i++) {
            list[i][0] = counter;
            ms = new MergeSort(counter);
            list[i][1] = ms.counter;
            counter += 50;
        }    
        
        graficar(list);
    }

    public void graficar(Integer[][] list) {
        new Grafica(list); 
    }
}
