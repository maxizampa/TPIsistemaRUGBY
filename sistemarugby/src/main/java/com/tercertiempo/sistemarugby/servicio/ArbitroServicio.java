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

    public Optional<Arbitro> obtenerPorId(int id) {
        return arbitroRepositorio.findById(id);
    }

    public Arbitro guardarArbitro(Arbitro arbitro) {
        return arbitroRepositorio.save(arbitro);
    }

    public void eliminarArbitro(int id) {
        arbitroRepositorio.deleteById(id);
    }

    
    public Optional<Arbitro> obtenerPorNombre(String nombre) {
        List<Arbitro> arbitros = arbitroRepositorio.buscaPorNombre(nombre);
        return arbitros.stream().findFirst();
    }
}
