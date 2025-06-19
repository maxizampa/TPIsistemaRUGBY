package com.tercertiempo.sistemarugby.Nuevas Clases;

import java.util.Scanner;
public class Menu1 {

import java.util.Scanner;

public class MenuApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vista vista = new Vista();
        int opcion;

        do {
            vista.imprimir("\nMenú:");
            vista.imprimir("1. Imprimir vista");
            vista.imprimir("2. Leer vista");
            vista.imprimir("0. Salir");
            opcion = vista.leer("Ingrese su opción: ", 0);

            switch (opcion) {
                case 1:
                    break;
                case 2:
                    vista.leer();
                    break;
                case 0:
                    break;
                default:
                    vista.imprimir("Opción no válida, intenta nuevamente.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}
