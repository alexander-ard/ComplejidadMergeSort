import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("¿Qué operacion quiere realizar?: ");
        System.out.println("1. Ordenar y contar operaciones para un Array aleatorio de tamaño n");
        System.out.println("2. Graficar operaciones para un Array[n] con valores multiplos de 50.");

        Scanner in = new Scanner(System.in);
        int opcion = Integer.parseInt(in.nextLine());
        
        if (opcion == 1) {
            new MergeSort();
        } 
        else if (opcion == 2) {
            new Graficador();
        } 
        else {
            return; 
        }
    }
}
