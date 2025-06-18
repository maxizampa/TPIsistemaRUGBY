package com.tercertiempo.sistemarugby.modelo.util;


public enum TipoUsuario {
    ADMINISTRADOR("Adm;inistrador"),
    PERIODISTA("periodista"),
    FAN("fan");

    private final String descripcion;

    TipoUsuario(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
