package m3.uf1.arrays;

/**programa que crea i mostra per pantalla una ‘sopa de lletres’ aleatòria de
10 files per 10 columnes
 *
 * @author CARLOS FLORES
 * @version 2.0 05-dic-2018
 */
public class Ex88Sopa {
    public static void main(String[] args) {
         char[][] taula;
        taula = new char[15][15];
        int fila = 0;
        while (fila < taula.length) {
            int columna = 0;
            //passar per totes les columnes de la fila 0
            while (columna < taula[fila].length) {
                int n = (int) (Math.random() *('Z'-'A'+1)+'A');
                char n2=(char)n;
                taula[fila][columna] = n2;
                System.out.print(taula[fila][columna]+" ");
                columna++;
            }
            //System.out.println("\n--------------------------");
            System.out.println("");
            fila++;       
        }
    }
}
