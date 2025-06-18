package com.tercertiempo.sistemarugby.servicio;

import com.tercertiempo.sistemarugby.modelo.entidades.Equipo;
import com.tercertiempo.sistemarugby.repositorio.EquipoRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioEquipo {

    private final EquipoRepositorio equipoRepositorio;

    public ServicioEquipo(EquipoRepositorio equipoRepositorio) {
        this.equipoRepositorio = equipoRepositorio;
    }

    public List<Equipo> listarEquipos() {
        return equipoRepositorio.findAll();
    }

    public Optional<Equipo> obtenerPorId(Integer id) {
        return equipoRepositorio.findById(id);
    }

    public Equipo guardarEquipo(Equipo equipo) {
        return equipoRepositorio.save(equipo);
    }
    public Optional<Equipo> obtenerPorNombreEquipo(String nombreEquipo) {
        return Optional.ofNullable(equipoRepositorio.findByNombre(nombreEquipo));
    }
    public Optional<Equipo> obtenerPorSiglas(String siglas) {
        return Optional.ofNullable(equipoRepositorio.findBySiglas(siglas));
    }
}
