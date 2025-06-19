package com.tercertiempo.sistemarugby.servicio;

import com.tercertiempo.sistemarugby.modelo.entidades.Jugador;
import com.tercertiempo.sistemarugby.repositorio.JugadorRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JugadorServicio {

    private final JugadorRepositorio jugadorRepositorio;

    public JugadorServicio(JugadorRepositorio jugadorRepositorio) {
        this.jugadorRepositorio = jugadorRepositorio;
    }

    // Listar todos los jugadores
    public List<Jugador> obtenerTodos() {
        return jugadorRepositorio.findAll();
    }

    // Buscar jugador por ID con manejo de Optional
    public Optional<Jugador> obtenerPorId(Integer id) {
        return jugadorRepositorio.findById(id);
    }

    // Verificar si existe un jugador por ID
    public boolean existePorId(Integer id) {
        return jugadorRepositorio.existsById(id);
    }

    // Contar total de jugadores
    public long contarJugadores() {
        return jugadorRepositorio.count();
    }

    public Jugador guardarJugador(Jugador jugador) {
        // EL JUGADOR ESTA REGISTRADO?
        if (jugadorRepositorio.existsById(jugador.getId())) {
            throw new IllegalArgumentException("El jugador ya está registrado.");
        }

        // EL JUGADOR TIENE EQUIPO ASIGNADO
        if (jugador.getEquipo() != null && jugadorRepositorio.existsById(jugador.getId())) {
            throw new IllegalArgumentException("El jugador ya pertenece a un equipo y no puede estar en otro.");
        }

        return jugadorRepositorio.save(jugador);
    }

    // Eliminar jugador por ID 
    public void eliminarPorId(Integer id) {
        if (jugadorRepositorio.existsById(id)) {
            jugadorRepositorio.deleteById(id);
        }
    }

    // Métodos personalizados para búsqueda
    public List<Jugador> buscarPorNombre(String nombre) {
        return jugadorRepositorio.findByNombre(nombre);
    }
}

