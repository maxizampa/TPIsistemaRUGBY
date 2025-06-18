package com.tercertiempo.sistemarugby.vista;

public abstract class Vista<T> { // Clase abstracta para vistas genéricas con tipo genérico T

    public abstract T leer(); // Obtiene los datos
    // tengo que sobrecargar el método leer para que pueda recibir un mensaje y un tipo específico
    public abstract T leer(String mensaje, Class<T> tipo); // Obtiene los datos con un mensaje y tipo específico
    
    public abstract void escribir(T datos); // Muestra o guarda los datos

    public void error(String mensaje) { // delego a mostrar error
        mostrarError(mensaje);
    }

    // Método para manejar errores, protected para que cada vista decida como maneja los errres
    protected abstract void mostrarError(String mensaje);
}
