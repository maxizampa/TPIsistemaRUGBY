package com.tercertiempo.sistemarugby.servicio;

import com.tercertiempo.sistemarugby.modelo.entidades.Partido;
import com.tercertiempo.sistemarugby.repositorio.PartidoRepositorio;
import org.springframework.stereotype.Service;
import com.tercertiempo.sistemarugby.modelo.util.EstadoPartido;
import com.tercertiempo.sistemarugby.modelo.util.ResultadoPartido;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PartidoServicio {

    private final PartidoRepositorio partidoRepositorio;

    public PartidoServicio(PartidoRepositorio partidoRepositorio) {
        this.partidoRepositorio = partidoRepositorio;
    }

    // Obtener todos los partidos
    public List<Partido> obtenerTodos() {
        return partidoRepositorio.findAll();
    }

    // Buscar partido por ID con manejo de Optional
    public Optional<Partido> obtenerPorId(Integer id) {
        return partidoRepositorio.findById(id);
    }

    // Verificar si existe un partido por ID
    public boolean existePorId(Integer id) {
        return partidoRepositorio.existsById(id);
    }

    // Guardar o actualizar un partido
    public Partido guardarPartido(Partido partido) {
        return partidoRepositorio.save(partido);
    }

    // Eliminar partido por ID con verificación previa
    public void eliminarPorId(Integer id) {
        if (partidoRepositorio.existsById(id)) {
            partidoRepositorio.deleteById(id);
        }
    }

    // Métodos personalizados para búsqueda
    public List<Partido> buscarPorEquipoLocalNombre(String nombreEquipoLocal) {
        return partidoRepositorio.findByEquipoLocalNombre(nombreEquipoLocal);
    }

    public List<Partido> buscarPorEquipoVisitanteNombre(String nombreEquipoVisitante) {
        return partidoRepositorio.findByEquipoVisitanteNombre(nombreEquipoVisitante);
    }

    public List<Partido> buscarPorFecha(LocalDate fecha) {
        return partidoRepositorio.findByFecha(fecha);
    }

    public List<Partido> buscarPorEstadioNombre(String nombreEstadio) {
        return partidoRepositorio.findByEstadioNombre(nombreEstadio);
    }

    public List<Partido> buscarPorArbitroNombre(String nombreArbitro) {
        return partidoRepositorio.findByArbitroNombre(nombreArbitro);
    }

    public List<Partido> buscarPorEstadoPartido(EstadoPartido estadoPartido) {
        return partidoRepositorio.findByEstadoPartido(estadoPartido);
    }

    public List<Partido> buscarPorResultadoPartido(ResultadoPartido resultadoPartido) {
        return partidoRepositorio.findByResultadoPartido(resultadoPartido);
    }
}

