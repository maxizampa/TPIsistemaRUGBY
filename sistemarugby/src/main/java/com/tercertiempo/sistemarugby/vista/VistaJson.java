package com.tercertiempo.sistemarugby.vista;

import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
@RequestMapping("/vista/json")
public class VistaJson<T> extends Vista<T> {

    private final ObjectMapper objectMapper = new ObjectMapper();

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

    // manejo de excepciones y errores 
    @Override
    protected void mostrarError(String mensaje) {
        try {
            System.out.println(objectMapper.writeValueAsString(new ErrorJson(400, mensaje)));
        } catch (com.fasterxml.jackson.core.JsonProcessingException e) {
            System.out.println("{\"estado\":400,\"mensaje\":\"Error al procesar JSON: " + e.getMessage() + "\"}");
        }
    }
}

    class ErrorJson {
        private int estado;
        private String mensaje;

        public ErrorJson(int estado, String mensaje) {
            this.estado = estado;
            this.mensaje = mensaje;
        }

        public int getEstado() { return estado; }
        public String getMensaje() { return mensaje; }
    }

