package com.tercertiempo.sistemarugby.modelo.util;

public enum EstadoTemporada {
    ACTIVA("Activa"),
    INACTIVA("Inactiva"),
    FINALIZADA("Finalizada");

    private final String descripcion;

    EstadoTemporada(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

}
