package com.tercertiempo.sistemarugby.repositorio;

import com.tercertiempo.sistemarugby.modelo.entidades.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface JugadorRepositorio extends JpaRepository<Jugador, Integer> {
    List<Jugador> buscaPorNombre(String nombre);

    List<Jugador> buscaPorApellido(String apellido);

    List<Jugador> buscaPorPosicion(String posicion);

    List<Jugador> buscaPorEquipoNombre(String Equipo);
    List<Jugador> buscaPorEquipoId(int id);

    List<Jugador> buscaPorEdadMenorOigualQue(int edad);

    


}