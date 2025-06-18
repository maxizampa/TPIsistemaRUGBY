package com.tercertiempo.sistemarugby.modelo.util;

public enum EstadoPartido {
    PROGRAMADO("Programado"),
    EN_JUEGO("En Juego"),
    FINALIZADO("Finalizado"),
    CANCELADO("Cancelado");

    private final String descripcion;

    EstadoPartido(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

}
