package com.tercertiempo.sistemarugby.controlador;

import com.tercertiempo.sistemarugby.modelo.entidades.Equipo;
import com.tercertiempo.sistemarugby.servicio.EquipoServicio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipos")
public class ControladorEquipo {

        private final EquipoServicio EquipoServicio;

    public ControladorEquipo(EquipoServicio EquipoServicio) {
        this.EquipoServicio = EquipoServicio;
    }

    @GetMapping // Listar todos los Equipos evita escribir el método en el servicio
    public List<Equipo> obtenerEquipos() {
        return EquipoServicio.obtenerTodos();    }

    @PostMapping // Registrar un nuevo Equipo
    public Equipo registrarEquipo(@RequestBody Equipo Equipo) {
        return EquipoServicio.guardarEquipo(Equipo);
    }

    @GetMapping("/{id}") // Obtener un Equipo por ID
    public ResponseEntity<Equipo> obtenerEquipoPorId(@PathVariable Integer id) {
        return EquipoServicio.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/nombre/{nombreEquipo}") // Obtener un Equipo por nombre de Equipo
    public ResponseEntity<Equipo> obtenerEquipoPorNombre(@PathVariable String nombreEquipo) {
        List<Equipo> equipos = EquipoServicio.buscarPorNombre(nombreEquipo);
        if (equipos == null || equipos.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(equipos.get(0)); // Devuelve el primer equipo encontrado
        }
    }

}


