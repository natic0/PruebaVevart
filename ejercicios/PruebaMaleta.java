import java.util.Scanner;

public class Main {

    public static void definirTam() {
        int tam = 0;
        Scanner obj = new Scanner(System.in);
        System.out.print("Introduce el límite que deseas para la maleta: ");
        tam = obj.nextInt();
        definirObj(tam);
    }

    public static void definirObj(int tam) {
        int objetos[][] = new int[5][2];
        Scanner obj = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            System.out.print("Ingrese el peso del objeto " + (i + 1) + ": ");
            objetos[i][0] = obj.nextInt();
            System.out.print("Ingrese el valor del objeto " + (i + 1) + ": ");
            objetos[i][1] = obj.nextInt();
        }

        System.out.println("Estos son los objetos ingresados: ");
        for (int i = 0; i < 5; i++) {
            System.out.println("Objeto " + (i + 1) + " - Peso: " + objetos[i][0] + ", Valor: " + objetos[i][1]);
        }
        knapsack(objetos, tam);
    }

    public static void knapsack(int objetos[][], int tam) {
        int n = objetos.length;
        double[] prioriza = new double[n];

        for (int i = 0; i < n; i++) {
            prioriza[i] = (double) objetos[i][1] / objetos[i][0];
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (prioriza[j] < prioriza[j + 1]) {
                    double tempPrioriza = prioriza[j];
                    prioriza[j] = prioriza[j + 1];
                    prioriza[j + 1] = tempPrioriza;

                    int[] temp = objetos[j];
                    objetos[j] = objetos[j + 1];
                    objetos[j + 1] = temp;
                }
            }
        }

        int pesoTotal = 0;
        double valorTotal = 0.0;

        System.out.println("Objetos seleccionados para la mochila: ");
        for (int i = 0; i < n; i++) {
            if (pesoTotal + objetos[i][0] <= tam) {
                pesoTotal += objetos[i][0];
                valorTotal += objetos[i][1];
                System.out.println("Objeto " + (i + 1) + " - Peso: " + objetos[i][0] + ", Valor: " + objetos[i][1]);
            } 
        }

        System.out.println("Peso total en la mochila: " + pesoTotal);
    }

    public static void main(String[] args) {
        definirTam();
    }
}
