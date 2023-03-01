package adriel.ordenamiento_act2;

import java.util.Scanner;

public class Ordenamiento_act2 {

    public static void main(String[] args) {

        /* 
            adriel
         */
        boolean salir = false;
        do {
            System.out.println("Selecciona el metodo de ordenamiento por hacer: ");
            System.out.println("1.- Insercion Ascendente");
            System.out.println("2.- Seleccion Ascendente");
            System.out.println("3.- Shellsort Ascendente");
            System.out.println("4.- Quicksort Ascendente");
            System.out.println("5.- Insercion Descendente");
            System.out.println("6.- Seleccion Descendente");
            System.out.println("7.- Shellsort Descendente");
            System.out.println("8.- Salir");

            Scanner entrada = new Scanner(System.in);
            int opcion;
            int m[] = new int[10];
            do {
                opcion = entrada.nextInt();
                switch (opcion) {

                    case 1:
                        m = crearVector();
                        System.out.println("Insercion ascendente: ");
                        System.out.println("Vector desordenado: ");
                        imprimirVector(m);
                        insercion(m);
                        System.out.println("Vector ordenado: ");
                        imprimirVector(m);
                        break;

                    case 2:
                        m = crearVector();
                        System.out.println("Seleccion ascendente: ");
                        System.out.println("Vector desordenado: ");
                        imprimirVector(m);
                        seleccion(m);
                        System.out.println("Vector ordenado: ");
                        imprimirVector(m);
                        break;

                    case 3:
                        m = crearVector();
                        System.out.println("Shellsort ascendente: ");
                        System.out.println("Vector desordenado: ");
                        imprimirVector(m);
                        shellSort(m);
                        System.out.println("Vector ordenado: ");
                        imprimirVector(m);
                        break;

                    case 4:
                        m = crearVector();
                        System.out.println("Quicksort ascendente: ");
                        System.out.println("Vector desordenado: ");
                        imprimirVector(m);
                        quickSort(m, 0, m.length - 1);
                        System.out.println("Vector ordenado: ");
                        imprimirVector(m);
                        break;

                    case 5:
                        m = crearVector();
                        System.out.println("Insercion descendente: ");
                        System.out.println("Vector desordenado: ");
                        imprimirVector(m);
                        insercionDesc(m);
                        System.out.println("Vector ordenado: ");
                        imprimirVector(m);
                        break;

                    case 6:
                        m = crearVector();
                        System.out.println("Seleccion descendente: ");
                        System.out.println("Vector desordenado: ");
                        imprimirVector(m);
                        seleccionDesc(m);
                        System.out.println("Vector ordenado: ");
                        imprimirVector(m);
                        break;

                    case 7:
                        m = crearVector();
                        System.out.println("Shellsort descendente: ");
                        System.out.println("Vector desordenado: ");
                        imprimirVector(m);
                        shellSortDesc(m);
                        System.out.println("Vector ordenado: ");
                        imprimirVector(m);
                        break;

                    case 8:
                        System.out.println("Lo lograste! ");
                        salir = true;
                }
            } while (opcion > 8 || opcion < 1);
        } while (salir == false);
    }

    private static int[] crearVector() {
        int m[] = new int[10];
        for (int i = 0; i < m.length; i++) {
            m[i] = (int) (Math.random() * 99) + 1;
        }
        return m;
    }

    private static void imprimirVector(int m[]) {
        for (int i = 1; i <= m.length; i++) {
            System.out.print("  " + m[i - 1] + "    ");
        }
        System.out.println("");
    }

    //Insercion ascendente
    private static void insercion(int m[]) {
        int temp;
        for (int i = 0; i < m.length - 1; i++) {
            for (int j = i + 1; j < m.length; j++) {
                if (m[i] > m[j]) {
                    temp = m[i];
                    m[i] = m[j];
                    m[j] = temp;
                }
            }
        }
    }

    //Seleccion ascendente
    private static void seleccion(int m[]) {

        int i, k, p, buffer;
        int limit = m.length - 1;
        for (k = 0; k < limit; k++) {
            p = k;
            for (i = k + 1; i <= limit; i++) {
                if (m[i] < m[p]) {
                    p = i;
                }
            }
            if (p != k) {
                buffer = m[p];
                m[p] = m[k];
                m[k] = buffer;
            }
        }
    }

    //Shellshort ascendente
    private static void shellSort(int m[]) {

        for (int incremento = m.length / 2; incremento > 0; incremento = (incremento == 2 ? 1 : (int) Math.round(incremento / 2.2))) {
            for (int i = incremento; i < m.length; i++) {
                for (int j = i; j >= incremento && m[j - incremento] > m[j]; j -= incremento) {
                    int temp = m[j];
                    m[j] = m[j - incremento];
                    m[j - incremento] = temp;
                }
            }
        }
    }

    //Quicksort ascendente
    private static void quickSort(int m[], int izq, int der) {

        int pivote = m[izq];
        int aux;
        int i = izq;
        int j = der;

        while (i < j) {
            while (m[i] <= pivote && i < j) {
                i++;
            }
            while (m[j] > pivote) {
                j--;
            }
            if (i < j) {
                aux = m[i];
                m[i] = m[j];
                m[j] = aux;
            }
        }

        m[izq] = m[j];
        m[j] = pivote;

        if (izq < j - 1) {
            quickSort(m, izq, j - 1);
        }
        if (j + 1 < der) {
            quickSort(m, j + 1, der);
        }
    }

    //Descendente
    //Insercion descendente
    private static void insercionDesc(int m[]) {
        int temp;
        for (int i = 0; i < m.length - 1; i++) {
            for (int j = i + 1; j < m.length; j++) {
                if (m[i] < m[j]) {
                    temp = m[i];
                    m[i] = m[j];
                    m[j] = temp;
                }
            }
        }
    }

    //Seleccion descendente
    private static void seleccionDesc(int m[]) {

        int i, j, k, p, buffer;
        int limit = m.length - 1;
        for (k = 0; k < limit; k++) {
            p = k;
            for (i = k + 1; i <= limit; i++) {
                if (m[i] > m[p]) {
                    p = i;
                }
            }
            if (p != k) {
                buffer = m[p];
                m[p] = m[k];
                m[k] = buffer;
            }
        }
    }

    //Shellshort descendente
    private static void shellSortDesc(int m[]) {

        for (int incremento = m.length / 2; incremento > 0; incremento = (incremento == 2 ? 1 : (int) Math.round(incremento / 2.2))) {
            for (int i = incremento; i < m.length; i++) {
                for (int j = i; j >= incremento && m[j - incremento] < m[j]; j -= incremento) {
                    int temp = m[j];
                    m[j] = m[j - incremento];
                    m[j - incremento] = temp;
                }
            }
        }
    }
}
