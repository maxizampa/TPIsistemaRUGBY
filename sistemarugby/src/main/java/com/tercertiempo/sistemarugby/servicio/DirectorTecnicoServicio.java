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

    public Optional<DirectorTecnico> obtenerPorId(Integer id) {
        return directorTecnicoRepositorio.findById(id);
    }

    public boolean existePorId(Integer id) {
        return directorTecnicoRepositorio.existsById(id);
    }

    public long contarDirectoresTecnicos() {
        return directorTecnicoRepositorio.count();
    }

    public DirectorTecnico guardarDirectorTecnico(DirectorTecnico directorTecnico) {
        return directorTecnicoRepositorio.save(directorTecnico);
    }

    public void eliminarPorId(Integer id) {
        if (directorTecnicoRepositorio.existsById(id)) {
            directorTecnicoRepositorio.deleteById(id);
        }
    }

    // Métodos personalizados para búsqueda
    public List<DirectorTecnico> buscarPorNombre(String nombre) {
        return directorTecnicoRepositorio.findByNombre(nombre);
    }

    public List<DirectorTecnico> buscarPorApellido(String apellido) {
        return directorTecnicoRepositorio.findByApellido(apellido);
    }
}
