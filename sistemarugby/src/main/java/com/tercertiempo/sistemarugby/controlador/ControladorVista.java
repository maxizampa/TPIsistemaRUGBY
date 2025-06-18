package com.tercertiempo.sistemarugby.controlador;

import com.tercertiempo.sistemarugby.vista.VistaConsola;
import com.tercertiempo.sistemarugby.vista.VistaHtml;
import com.tercertiempo.sistemarugby.vista.VistaJson;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/controlador")
public class ControladorVista<T> {
    // Instancias de las vistas

    private final VistaConsola<T> vistaConsola = new VistaConsola<>();
    private final VistaHtml<T> vistaHtml = new VistaHtml<>();
    private final VistaJson<T> vistaJson = new VistaJson<>();

    @PostMapping("/procesar")
    public Map<String, T> procesarDato(@RequestBody T datos, Model model) {
        // Escribir el dato en todas las vistas simultáneamente
        vistaConsola.escribir(datos);
        vistaHtml.escribir(datos);
        vistaJson.escribir(datos);

        // Preparar datos para la vista HTML
        model.addAttribute("mensaje", datos);

        // Retornar el JSON para la API REST
        return Map.of("json", datos);
    }

    // leeo los datos desde todas las vistas 
    @GetMapping("/leer")
    public void leerDatoDesdeTodos() {
        vistaConsola.escribir(vistaConsola.leer());
        vistaHtml.escribir(vistaHtml.leer());
        vistaJson.escribir(vistaJson.leer());
    }
}
