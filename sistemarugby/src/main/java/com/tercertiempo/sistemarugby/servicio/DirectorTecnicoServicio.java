package com.tercertiempo.sistemarugby.servicio;

import com.tercertiempo.sistemarugby.modelo.entidades.DirectorTecnico;
import com.tercertiempo.sistemarugby.repositorio.DirectorTecnicoRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DirectorTecnicoServicio {

    private final DirectorTecnicoRepositorio directorTecnicoRepositorio;

    public DirectorTecnicoServicio(DirectorTecnicoRepositorio directorTecnicoRepositorio) {
        this.directorTecnicoRepositorio = directorTecnicoRepositorio;
    }

    public List<DirectorTecnico> obtenerTodos() {
        return directorTecnicoRepositorio.findAll();
    }

    public Optional<DirectorTecnico> obtenerPorId(int id) {
        return directorTecnicoRepositorio.findById(id);
    }

    public DirectorTecnico guardarDirectorTecnico(DirectorTecnico directorTecnico) {
        return directorTecnicoRepositorio.save(directorTecnico);
    }

    public void eliminarDirectorTecnico(int id) {
        directorTecnicoRepositorio.deleteById(id);
    }
}
