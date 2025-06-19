package com.tercertiempo.sistemarugby.servicio;

import com.tercertiempo.sistemarugby.modelo.entidades.Arbitro;
import com.tercertiempo.sistemarugby.repositorio.ArbitroRepositorio;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ArbitroServicio {

    private final ArbitroRepositorio arbitroRepositorio;

    public ArbitroServicio(ArbitroRepositorio arbitroRepositorio) {
        this.arbitroRepositorio = arbitroRepositorio;
    }

    public List<Arbitro> obtenerTodos() {
        return arbitroRepositorio.findAll();
    }

    public Optional<Arbitro> obtenerPorId(Integer id) {
        return arbitroRepositorio.findById(id);
    }

    public boolean existePorId(Integer id) {
        return arbitroRepositorio.existsById(id);
    }

    public long contarArbitros() {
        return arbitroRepositorio.count();
    }

    public Arbitro guardarArbitro(Arbitro arbitro) {
        return arbitroRepositorio.save(arbitro);
    }

    public void eliminarPorId(Integer id) {
        if (arbitroRepositorio.existsById(id)) {
            arbitroRepositorio.deleteById(id);
        }
    }

    public List<Arbitro> buscarPorNombre(String nombre) {
        return arbitroRepositorio.findByNombre(nombre);
    }

    public List<Arbitro> buscarPorApellido(String apellido) {
        return arbitroRepositorio.findByApellido(apellido);
    }

    public List<Arbitro> buscarPorNombreYApellido(String nombre, String apellido) {
        return arbitroRepositorio.buscarPorNombreYApellido(nombre, apellido);
    }
}
