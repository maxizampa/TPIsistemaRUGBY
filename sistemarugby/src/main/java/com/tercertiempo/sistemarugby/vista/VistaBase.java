package com.tercertiempo.sistemarugby.vista;

public abstract class VistaBase<T> { // clase abstracta para vistas genéricas

    public abstract T leer(); // Obtiene los datos
    public abstract void escribir(T datos); // Muestra o guarda los datos
    public void error(String mensaje) { // Método común para manejar errores solo a la consola
        System.out.println("Error: " + mensaje);
    }
}
