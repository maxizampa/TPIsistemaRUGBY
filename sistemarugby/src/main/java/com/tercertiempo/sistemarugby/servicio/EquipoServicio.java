package com.tercertiempo.sistemarugby.servicio;

import com.tercertiempo.sistemarugby.modelo.entidades.Equipo;
import com.tercertiempo.sistemarugby.repositorio.EquipoRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipoServicio {

    private final EquipoRepositorio equipoRepositorio;

    public EquipoServicio(EquipoRepositorio equipoRepositorio) {
        this.equipoRepositorio = equipoRepositorio;
    }


    public List<Equipo> obtenerTodos() {
        return equipoRepositorio.findAll();
    }

    public Optional<Equipo> obtenerPorId(Integer id) {
        return equipoRepositorio.findById(id);
    }

    public boolean existePorId(Integer id) {
        return equipoRepositorio.existsById(id);
    }

    public long contarEquipos() {
        return equipoRepositorio.count();
    }

    public Equipo guardarEquipo(Equipo equipo) {
        return equipoRepositorio.save(equipo);
    }

    public void eliminarPorId(Integer id) {
        if (equipoRepositorio.existsById(id)) {
            equipoRepositorio.deleteById(id);
        }
    }

    // Métodos personalizados para búsqueda
    public List<Equipo> buscarPorNombre(String nombre) {
        return equipoRepositorio.findByNombre(nombre);
    }

    public List<Equipo> buscarPorCiudad(String ciudad) {
        return equipoRepositorio.buscarEquipoPorCiudad(ciudad);
    }
}
