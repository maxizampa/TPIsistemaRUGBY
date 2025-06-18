package com.tercertiempo.sistemarugby.vista;

import java.util.Scanner;

public class VistaConsola<T> extends Vista<T> {
    private final Scanner scanner = new Scanner(System.in);

    public T leer(String mensaje) {
        System.out.print(mensaje);
        String entrada = scanner.nextLine();

        // no se puede castear directamente a T, por lo que se maneja como String y luego se convierte
        try {
            if (entrada.matches("^-?\\d+$")) { // Detecta enteros
                return (T) Integer.valueOf(entrada);
            } else if (entrada.matches("^-?\\d*\\.\\d+$")) { // Detecta decimales
                return (T) Double.valueOf(entrada);
            } else {
                return (T) entrada; // Lo maneja como String por defecto
            }
        } catch (ClassCastException e) {
            mostrarError("de conversión, intente nuevamente.");
            return null;
        }
    }

    @Override
    public T leer() {
        return leer("Ingrese un valor: ");
    }

    @Override
    public T leer(String mensaje, Class<T> clazz) {
        System.out.print(mensaje);
        String entrada = scanner.nextLine();
        try {
            if (clazz == Integer.class) {
                return clazz.cast(Integer.valueOf(entrada));
            } else if (clazz == Double.class) {
                return clazz.cast(Double.valueOf(entrada));
            } else if (clazz == String.class) {
                return clazz.cast(entrada);
            } else {
                mostrarError("Tipo no soportado.");
                return null;
            }
        } catch (Exception e) {
            mostrarError("de conversión, intente nuevamente.");
            return null;
        }
    }

    @Override
    public void escribir(T datos) {
        System.out.println(datos);
    }

    @Override
    protected void mostrarError(String mensaje) {
        System.err.println("ERROR: " + mensaje);
    }
}
