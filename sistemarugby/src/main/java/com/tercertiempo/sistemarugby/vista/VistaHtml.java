package com.tercertiempo.sistemarugby.vista;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VistaHtml<T> extends Vista<T> {
    // Extiende de VistaBase para manejar datos de tipo Model
// por eso extiende de VistaBase con tipo Model, permitiendo manejar datos para vistas Thymeleaf
// Esta clase es responsable de preparar los datos para ser renderizados en una vista HTML
// Se usa en controladores para enviar datos a la vista. Permite agregar variables que Thymeleaf puede mostrar en HTML Se comporta como un mapa (Map<String, Object>

    @Override
    public T leer() {
        return null; // En HTML no se obtiene entrada directa
    }

    @Override
    public T leer(String mensaje, Class<T> tipo) {
        return null; // En HTML, los datos vienen desde la petición HTTP
    }

    @Override
    public void escribir(T datos) {
        // Este método es obligatorio y debe existir
        // En HTML, podrías almacenar el dato en una variable si lo necesitas
    }

    @GetMapping("/vista/html")
    public String mostrarVista(@RequestParam(required = false) T datos, Model model) {
        model.addAttribute("mensaje", datos != null ? datos : "Ingrese un valor");
        return "vistaHtml"; // Retorna la vista Thymeleaf
    }

    @Override
    protected void mostrarError(String mensaje) {
        // Manejo de errores en el HTML usando atributos en el modelo
    }
}
