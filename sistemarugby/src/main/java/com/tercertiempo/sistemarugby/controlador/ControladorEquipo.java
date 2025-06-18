package com.tercertiempo.sistemarugby.controlador;

import com.tercertiempo.sistemarugby.modelo.entidades.Equipo;
import com.tercertiempo.sistemarugby.servicio.EquipoServicio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipos")
public class ControladorEquipo {

        private final EquipoServicio ServicioEquipo;

    public ControladorEquipo(EquipoServicio ServicioEquipo) {
        this.ServicioEquipo = ServicioEquipo;
    }

    @GetMapping // Listar todos los Equipos evita escribir el método en el servicio
    public List<Equipo> obtenerEquipos() {
        return ServicioEquipo.listarEquipos();
    }

    @PostMapping // Registrar un nuevo Equipo
    public Equipo registrarEquipo(@RequestBody Equipo Equipo) {
        return ServicioEquipo.guardarEquipo(Equipo);
    }

    @GetMapping("/{id}") // Obtener un Equipo por ID
    public ResponseEntity<Equipo> obtenerEquipoPorId(@PathVariable Integer id) {
        return ServicioEquipo.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/nombre/{nombreEquipo}") // Obtener un Equipo por nombre de Equipo
    public ResponseEntity<Equipo> obtenerEquipoPorNombre(@PathVariable String nombreEquipo) {
        return ServicioEquipo.obtenerPorNombreEquipo(nombreEquipo)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}


