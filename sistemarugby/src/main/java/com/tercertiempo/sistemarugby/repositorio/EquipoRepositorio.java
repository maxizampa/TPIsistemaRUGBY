package com.tercertiempo.sistemarugby.repositorio;

import com.tercertiempo.sistemarugby.modelo.entidades.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository // Anotación para indicar que esta interfaz es un repositorio
public interface EquipoRepositorio extends JpaRepository<Equipo, Integer> {
    Equipo buscaPorId(int id);
    Equipo buscaPorNombre(String nombre); // Método para buscar un equipo por su nombre
    Equipo buscaPorSiglas(String siglas); // Método para buscar un equipo por sus siglas
    
}
