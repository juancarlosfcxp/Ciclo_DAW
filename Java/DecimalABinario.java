package m3.uf1.arrays;

import java.util.Scanner;

/**
 * Donat un enter llegit de teclat, mostra la seva conversió a binari.
 *
 *
 * @author CARLOS FLORES
 * @version 2.0 04-dic-2018
 */
public class Ex81Binario {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int[] array;
        array = new int[50];
        int cont;

        System.out.println("introduce un valor");
        int n1 = entrada.nextInt();

        cont = 0;

        for (int n2; n1 > 0; cont++) {
            n2 = n1 % 2;
            n1 = n1 / 2;
            array[cont] = n2;
        }

        while (cont > 0) {
            System.out.print(array[cont - 1]);
            cont--;

        }
        System.out.println("");
    }
}
