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

    public List<Jugador> obtenerTodos() {
        return jugadorRepositorio.findAll();
    }

    public Optional<Jugador> obtenerPorId(int id) {
        return jugadorRepositorio.findById(id);
    }

    public Jugador guardarJugador(Jugador jugador) {
        
        return jugadorRepositorio.save(jugador);
    }

    public void eliminarJugador(int id) {
        jugadorRepositorio.deleteById(id);
    }

    public List<Jugador> buscarPorEquipo(int equipoId) {
        return jugadorRepositorio.buscaPorEquipoId(equipoId);
    }

}
