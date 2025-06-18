package com.tercertiempo.sistemarugby.vista;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RestController
@RequestMapping("/vista/json")
public class VistaJson<T> extends Vista<T> {

    @Override
    public T leer() {
        return null; // En JSON, los datos se reciben desde una solicitud HTTP
    }

    @Override
    public T leer(String mensaje, Class<T> tipo) {
        return null; // No se obtiene entrada manual, los datos vienen en el cuerpo de la petición
    }

    @Override
    @PostMapping
    public void escribir(@RequestBody T datos) {
        // Implementación vacía o lógica según la definición en Vista<T>
    }

    @Override
    protected void mostrarError(String mensaje) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ERROR JSON: " + mensaje);
    }
}
