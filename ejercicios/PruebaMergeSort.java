import java.util.Scanner;

public class PruebaMergeSort {
    public static void iniciar(int tam){
      int arrayDesordenado[] = new int[tam];
      int der[] = new int[tam];
      int izq[] = new int[tam];

      for (int i = 0; i < tam; i++){
        int num;
        Scanner obj = new Scanner(System.in);
        System.out.print("Ingrese un numero: ");
        num = obj.nextInt();
        arrayDesordenado[i] = num;
      }

      System.out.println("Este es el array desordenado: ");
      System.out.print("{ ");
      for (int i = 0; i < tam; i++){
          System.out.print(arrayDesordenado[i] + " ");
      }
      System.out.println("}");

      ordenar (arrayDesordenado, der, izq, tam);

      System.out.println("Este es el array ordenado: ");
      System.out.print("{ ");
      for (int i = 0; i < tam; i++){
          System.out.print(arrayDesordenado[i] + " ");
      }
      System.out.println("}");
    }

    public static void ordenar(int arrayDesordenado[], int der[], int izq[], int tam) {
      if (tam < 2){
        return;
      }

      int mid = tam / 2;
      izq = new int[mid];
      der = new int[tam - mid];

      for (int i = 0; i < mid; i++){
        izq[i] = arrayDesordenado[i];
      }

      for (int i = mid; i < tam; i++){
        der[i - mid] = arrayDesordenado[i];
      }

      ordenar(izq, der, izq, mid);
      ordenar(der, der, izq, tam - mid);

      merge(arrayDesordenado, izq, der, mid, tam - mid);
    }

    public static void merge(int arrayDesordenado[], int izq[], int der[], int left, int right) {
      int i = 0, j = 0, k = 0;
      while (i < left && j < right) {
        if (izq[i] <= der[j]) {
          arrayDesordenado[k++] = izq[i++];
        } else {
          arrayDesordenado[k++] = der[j++];
        }
      }

      while (i < left) {
        arrayDesordenado[k++] = izq[i++];
      }

      while (j < right) {
        arrayDesordenado[k++] = der[j++];
      }
    }

    public static void definirTam(){
        int tam = 0;
        Scanner obj = new Scanner(System.in);
        System.out.print("Introduce el tamaño que deseas: ");
        tam = obj.nextInt();
        if (tam % 2 == 0){
            iniciar(tam);
        } else {
            System.out.println("Debes introducir un número par, intenta otra vez.");
            definirTam();
        }
    }

    public static void main(String[] args){
      definirTam();
    }
}