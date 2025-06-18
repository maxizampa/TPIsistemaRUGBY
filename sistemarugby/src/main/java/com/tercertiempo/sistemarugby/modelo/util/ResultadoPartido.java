package com.tercertiempo.sistemarugby.modelo.util;

public enum ResultadoPartido {
    LOCAL_GANA("Local Gana"),
    VISITANTE_GANA("Visitante Gana"),
    EMPATE("Empate"),
    SIN_RESULTADO("Sin Resultado");

    private final String descripcion;

    ResultadoPartido(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

}
