package com.tercertiempo.sistemarugby.repositorio;

import com.tercertiempo.sistemarugby.modelo.entidades.Estadio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EstadioRepositorio extends JpaRepository<Estadio, Integer> {

    List<Estadio> buscaPorNombre(String nombre); 

    List<Estadio> buscaPorUbicacion(String ubicacion); 

    List<Estadio> buscaPorCapacidadMayorOigualQue(int capacidad);
}
