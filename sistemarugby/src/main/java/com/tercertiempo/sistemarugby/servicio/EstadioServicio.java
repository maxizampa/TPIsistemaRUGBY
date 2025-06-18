package com.tercertiempo.sistemarugby.servicio;

import com.tercertiempo.sistemarugby.modelo.entidades.Estadio;
import com.tercertiempo.sistemarugby.repositorio.EstadioRepositorio;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EstadioServicio {

    private final EstadioRepositorio estadioRepositorio;

    public EstadioServicio(EstadioRepositorio estadioRepositorio) {
        this.estadioRepositorio = estadioRepositorio;
    }

    public List<Estadio> obtenerTodos() {
        return estadioRepositorio.findAll();
    }

    public Optional<Estadio> obtenerPorId(int id) {
        return estadioRepositorio.findById(id);
    }

    public Estadio guardarEstadio(Estadio estadio) {
        return estadioRepositorio.save(estadio);
    }

    public void eliminarEstadio(int id) {
        estadioRepositorio.deleteById(id);
    }
}
