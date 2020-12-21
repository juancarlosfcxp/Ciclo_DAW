package practicaficheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * Programa que lee un archivo de texto y produce otro archivo con la característica de 
 * mantener la primera y la ultima letra de cada palabra y mezclando las letras del medio.
 *  mantiene la fisionomia del archivo original (saltos de linea, espacios en blanco y tabuladores.)
 *  las palabras que contienen numeros no se modifican
 * se mantienen los signos de puntuacion al principio y al final de cada psalabra
 * 
 * @author CARLOS FLORES
 * @version 2.0 11/05/2019
 */
public class PracticaFicheros {

    public static void main(String[] args) {
        
        JFileChooser selector = new JFileChooser();
        selector.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int ok = selector.showOpenDialog(null);

        if (ok != JFileChooser.APPROVE_OPTION) {
            JOptionPane.showMessageDialog(null, "Adios");
        } else {
            File fEntrada = selector.getSelectedFile();
            Scanner lectura;
            File fSalida = null;
            try {
                lectura = new Scanner(fEntrada, "iso-8859-1");
                try {
                    String linea = lectura.nextLine();
                    JFileChooser selector2 = new JFileChooser();
                    int ok2 = selector2.showSaveDialog(null);
                    if (ok2 != JFileChooser.APPROVE_OPTION) {
                        JOptionPane.showMessageDialog(null, "Adios");
                    } else {
                        fSalida = selector2.getSelectedFile();
                        printar(linea, fSalida);
                        while (lectura.hasNext()) {
                            linea = lectura.nextLine();
                            printar(linea, fSalida);
                        }
                    }
                } catch (NoSuchElementException e) {
                    System.out.println("El fichero esta vacio.");
                }
            } catch (FileNotFoundException e) {
                System.out.println("Fichero no encontrado.");
            }
        }
    }

    /**
     * Funcion printar que recibe un String "linea" y un archivo
     * y va printando cada palabra transformada, dentro dicho archivo.
     * Uso de la funcion transformar
     * Uso de la funcion esNum
     * @param linea
     * @param f
     */    
    
    
    public static void printar(String linea, File f) {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(f, true));
            String[] array = linea.split(" ");
            for (int i = 0; i < array.length; i++) {
                if (esNum(array[i])) {
                    pw.print(array[i] + " ");
                } else {
                    pw.print(transformar(array[i] + " "));
                }
            }
            pw.print("\r\n");
            pw.close();
        } catch (IOException e) {
            System.out.println("Problemas con FileWriter...");
        }

    }

    /**
    *Funcion esNum que recibe un String y verifica si existe algun numero dentro del String.
    * 
    * @param cadena
    * @return boolean[aux]
    */    
    
    public static boolean esNum(String cadena) {
        boolean aux = false;
        String numeros = "1234567890";
        for (int i = 0; i < cadena.length() && !aux; i++) {
            if (numeros.contains("" + cadena.charAt(i))) {
                aux = true;
            }
        }
        return aux;
    }

    
    /**
    * Funcion transformar que recibe un String que es una palabra y con el uso de la funcion permutar 
    * mezca las letras de dentro de la palabra conservando las letras de las puntas con sus respectivos signos de puntuacion.
    * 
     * @param pal
     * @return String [aux]
    */    
    public static String transformar(String pal) {
        String signos = "!\"·/()=?¿¡-:.,;[]{}\'\\ ";
        String aux="",ini= "", fi = "";
        boolean a = false, b = false;
        int l = pal.length();
        int indexa = 0, indexb = 0;

        if (pal.length() < 4) {
            return pal;
        } else {
            for (int i = 0; i < l / 2 && !a || !b; i++) {
                if (!a) {
                    if (signos.contains("" + pal.charAt(i))) {
                        ini = ini + pal.charAt(i);
                    } else {
                        ini = ini + pal.charAt(i);
                        a = true;
                        indexa = i + 1;
                    }
                }
                if (!b) {
                    if (signos.contains("" + pal.charAt(l - 1 - i))) {
                        fi = pal.charAt(l - 1 - i) + fi;
                    } else {
                        fi = pal.charAt(l - 1 - i) + fi;
                        b = true;
                        indexb = l - i - 1;
                    }
                }
            }
            aux=pal.substring(indexa, indexb);
            return ini + permutar(aux) + fi;
        }
    }

    
    /**
    * Funcion permutar que recibe un String y devuleve otro String con las mismas letras en orden aleatorio.
    * Uso de la funcion aparicion
    * @param s
    * @return String pal
    */    
    public static String permutar(String s) {
        String pal = "";
        if (s.length() == 1) {
            pal = "" + s.charAt(0);
        } else {
            for (int r, i = 0; i < s.length();) {
                r = (int) (Math.random() * s.length());
                if (!pal.contains("" + s.charAt(r))) {
                    pal = pal + s.charAt(r);
                    i++;
                } else if (aparicion(s, s.charAt(r), 0) > aparicion(pal, s.charAt(r), 0)) {
                    pal = pal + s.charAt(r);
                    i++;
                }
            }
        }
        return pal;
    }

    
    /**
    * Funcion recursiva aparicion que recibe un String, un char y un indice y devuelve 
    * el numero de veces que aparece el char dentro del String.
    * 
     * @param s
     * @param a
     * @param i
     * @return int
    */    
    public static int aparicion(String s, char a, int i) {
        if (s.indexOf(a, i) == -1) {
            return 0;
        } else {
            return aparicion(s, a, s.indexOf(a, i) + 1) + 1;
        }
    }
}
