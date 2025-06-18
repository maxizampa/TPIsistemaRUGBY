package com.tercertiempo.sistemarugby.servicio;

import com.tercertiempo.sistemarugby.modelo.entidades.Partido;
import com.tercertiempo.sistemarugby.modelo.util.EstadoPartido;
import com.tercertiempo.sistemarugby.modelo.util.ResultadoPartido;
import com.tercertiempo.sistemarugby.repositorio.PartidoRepositorio;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PartidoServicio {

    private final PartidoRepositorio partidoRepositorio;

    public PartidoServicio(PartidoRepositorio partidoRepositorio) {
        this.partidoRepositorio = partidoRepositorio;
    }

    public List<Partido> obtenerTodos() {
        return partidoRepositorio.findAll();
    }

    public Optional<Partido> obtenerPorId(int id) {
        return partidoRepositorio.findById(id);
    }

    public List<Partido> buscarPorFecha(LocalDate fecha) {
        return partidoRepositorio.buscaPorFecha(fecha);
    }

    public List<Partido> buscarPorEquipoLocal(String nombreEquipoLocal) {
        return partidoRepositorio.buscaPorEquipoLocalNombre(nombreEquipoLocal);
    }

    public List<Partido> buscarPorEquipoVisitante(String nombreEquipoVisitante) {
        return partidoRepositorio.buscaPorEquipoVisitanteNombre(nombreEquipoVisitante);
    }

    public List<Partido> buscarPorEstadio(String nombreEstadio) {
        return partidoRepositorio.buscaPorEstadioNombre(nombreEstadio);
    }

    public List<Partido> buscarPorArbitro(String nombreArbitro) {
        return partidoRepositorio.buscaPorArbitroNombre(nombreArbitro);
    }

    public List<Partido> buscarPorEstadoPartido(EstadoPartido estadoPartido) {
        return partidoRepositorio.buscaPorEstadoPartido(estadoPartido);
    }

    public List<Partido> buscarPorResultadoPartido(ResultadoPartido resultadoPartido) {
        return partidoRepositorio.buscaPorResultaPartido(resultadoPartido);
    }

    public Partido guardarPartido(Partido partido) {
        return partidoRepositorio.save(partido);
    }

    public void eliminarPartido(int id) {
        partidoRepositorio.deleteById(id);
    }

    public void actualizarResultado(Partido partido) {
        if (partido.getPuntosLocal() > partido.getPuntosVisitante()) {
            partido.setResultado(ResultadoPartido.LOCAL_GANA);
        } else if (partido.getPuntosLocal() < partido.getPuntosVisitante()) {
            partido.setResultado(ResultadoPartido.VISITANTE_GANA);
        } else {
            partido.setResultado(ResultadoPartido.EMPATE);
        }
        partidoRepositorio.save(partido);
    }
}
