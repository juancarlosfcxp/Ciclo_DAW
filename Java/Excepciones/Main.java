/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.jaumebalmes.pguitart.excepcionsmain;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author pere
 */
public class Main {

    private static Scanner entrada = new Scanner(System.in);

    public static void metode1() {
        try {
            metode2();
        } catch (NullPointerException ex) {
            System.out.println("Capturada");
            //ex.printStackTrace();
        } finally {
            System.out.println("Finally");
        }
    }

    public static void nullPointer() {
        String[] s = new String[10];

        s[0].concat("Peta"); //!null.concat
    }

    private static int divideix() throws NoMajorQue10Exception {

        int a, b;

        a = Integer.MIN_VALUE;
        while (a == Integer.MIN_VALUE) {
            try {
                System.out.print("Entra un numero mes gran que 10: ");
                a = llegirEnter();
            } catch (InputMismatchException ex) {
                entrada.nextLine(); //netegem per a que faci nova lectura
                a = Integer.MIN_VALUE; //Pedaç lleig per a repetir entrada
            }
        }

        if (a <= 10) { //creem una nova excepcio
            throw new NoMajorQue10Exception("NO ES MES GRAN QUE 10!");
        }
        System.out.print("Entra el segon numero: ");
        b = llegirEnter();
        return a / b;

    }

    private static void metode2() {
        nullPointer();
    }

    private static int llegirEnter() throws InputMismatchException {
        return entrada.nextInt();
    }

    public static void main(String[] args) {
        try {
            //metode1(); //nullPointerException
            System.out.println("Resultat : " + divideix());
        } catch (NoMajorQue10Exception ex) {
            System.out.println(ex.getMessage());
            Main.main(args);
            //Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
