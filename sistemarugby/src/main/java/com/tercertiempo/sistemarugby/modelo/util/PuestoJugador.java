package com.tercertiempo.sistemarugby.modelo.util;

public enum PuestoJugador {
    PILAR("Pilar"),
    HOOKER("Hooker"),
    SEGUNDA_LINEA("Segunda línea"),
    TERCERA_LINEA("Tercera línea"),
    OCTAVO("Octavo"),
    MEDIO_SCRUM("Medio scrum"),
    APERTURA("Apertura"),
    CENTRO("Centro"),
    WING("Wing"),
    FULL_BACK("Fullback");

    private final String descripcion;

    PuestoJugador(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return descripcion;
    }
}