package com.tercertiempo.sistemarugby.servicio;

import com.tercertiempo.sistemarugby.modelo.entidades.Evento;
import com.tercertiempo.sistemarugby.repositorio.EventoRepositorio;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EventoServicio {

    private final EventoRepositorio eventoRepositorio;

    public EventoServicio(EventoRepositorio eventoRepositorio) {
        this.eventoRepositorio = eventoRepositorio;
    }

    public List<Evento> obtenerTodos() {
        return eventoRepositorio.findAll();
    }

    public Optional<Evento> obtenerPorId(Integer id) {
        return eventoRepositorio.findById(id);
    }

    public boolean existePorId(Integer id) {
        return eventoRepositorio.existsById(id);
    }

    public long contarEventos() {
        return eventoRepositorio.count();
    }

    public Evento guardarEvento(Evento evento) {
        return eventoRepositorio.save(evento);
    }

    public void eliminarPorId(Integer id) {
        if (eventoRepositorio.existsById(id)) {
            eventoRepositorio.deleteById(id);
        }
    }

    // Métodos personalizados para búsqueda
    public List<Evento> buscarPorNombre(String nombre) {
        return eventoRepositorio.findByNombre(nombre);
    }

    public List<Evento> buscarPorApellido(String apellido) {
        return eventoRepositorio.findByApellido(apellido);
    }
    public List<Evento> buscarPorFecha(LocalDate fecha) {
    return eventoRepositorio.findByFecha(fecha);
    }

    public List<Evento> buscarPorRangoDeFechas(LocalDate inicio, LocalDate fin) {
        return eventoRepositorio.findByEntreFechas(inicio, fin);
}
}
