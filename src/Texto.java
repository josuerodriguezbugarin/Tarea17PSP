import java.util.Scanner;

public class Texto {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] consonantes = new char[5];
        System.out.println("Contador consonantes:");
        for (int i = 0; i < 5; i++) { //pedir 5 consonantes
            System.out.print("Introduce la consonante " + (i + 1) + ": ");
            consonantes[i] = sc.next().charAt(0);
        }
        sc.nextLine(); // Limpia toso
        System.out.print("Introduce el texto: ");
        String textoBase = sc.nextLine();
        String textoRepetido = textoBase.repeat(2000); //repetir las 2000 veces

        Contador contadorCompartido = new Contador();
        Consonantes[] hilos = new Consonantes[5];
        for (int i = 0; i < 5; i++) { // crear y lanzar los 5 hilos
            hilos[i] = new Consonantes(consonantes[i], textoRepetido, contadorCompartido);
            hilos[i].start();
        }
        for (int i = 0; i < 5; i++) { //esperar con join()
            try {
                hilos[i].join();
            } catch (InterruptedException e) {
                System.err.println("Hilo interrunpido");
            }
        }
        System.out.println("Resultado");
        int sumaIndividuales = 0;

        for (int i = 0; i < 5; i++) {
            System.out.println("Hilo [" + hilos[i].getConsonante() + "]: " + hilos[i].getConteoPropio() + " apariciones");
            sumaIndividuales += hilos[i].getConteoPropio();
        }
        System.out.println("-------------------------------------------");
        System.out.println("Suma de los conteos individuales: " + sumaIndividuales);
        System.out.println("Valor final en el contador compartido: " + contadorCompartido.getValor());
    }
}