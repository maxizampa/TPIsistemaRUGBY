package vista;

import java.util.Scanner;
import com.tercertiempo.sistemarugby.modelo.util.FormatoTexto;

public class Vista {
    private Scanner scanner = new Scanner(System.in);

    // sin constructor 

    // Métodos para imprimir mensajes en cosola
    public void imprimir(String mensaje) {
        System.out.println(mensaje);
    }
    public void imprimir(int mensaje){
        System.out.println(mensaje);
    }
    public void imprimir(double mensaje){
        System.out.println(mensaje);
    }

    public void escribir(T datos) {
        System.out.println(FormatoTexto.format(datos));
    }

    public String leer(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    public int leer(String mensaje, int tipo) {
        int valor;
        while (true) {
            try {
                System.out.print(mensaje);
                valor = Integer.parseInt(scanner.nextLine());
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número entero.");
            }
        }
    }

    public Double leer(String mensaje, double tipo) {
        double valor;
        while (true) {
            try {
                System.out.print(mensaje);
                valor = Double.parseDouble(scanner.nextLine());
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número decimal válido.");
            }
        }
    }
    public void Error(String mensaje){
        System.err.println("Error: " + mensaje);
    }
    public void cerrarScanner() {
        if (scanner != null) {
            scanner.close();
        }

    }
}
