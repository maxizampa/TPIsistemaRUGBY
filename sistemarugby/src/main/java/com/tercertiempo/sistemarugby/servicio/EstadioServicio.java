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

    public Optional<Estadio> obtenerPorId(Integer id) {
        return estadioRepositorio.findById(id);
    }

    public boolean existePorId(Integer id) {
        return estadioRepositorio.existsById(id);
    }

    public long contarEstadios() {
        return estadioRepositorio.count();
    }

    public Estadio guardarEstadio(Estadio estadio) {
        return estadioRepositorio.save(estadio);
    }

    
    public void eliminarPorId(Integer id) {
        if (estadioRepositorio.existsById(id)) {
            estadioRepositorio.deleteById(id);
        }
    }

    // Métodos personalizados para búsqueda
    public List<Estadio> buscarPorNombre(String nombre) {
        return estadioRepositorio.findByNombre(nombre);
    }

    public List<Estadio> buscarPorApellido(String apellido) {
        return estadioRepositorio.findByApellido(apellido);
    }
}
