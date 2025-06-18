package com.tercertiempo.sistemarugby.repositorio;

import com.tercertiempo.sistemarugby.modelo.entidades.DirectorTecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DirectorTecnicoRepositorio extends JpaRepository<DirectorTecnico, Integer> {

    List<DirectorTecnico> buscaPorNombre(String nombre); 

    List<DirectorTecnico> buscaPorApellido(String apellido); 

    List<DirectorTecnico> buscaPorExperienciaGreaterThanEqual(int experiencia); 

    List<DirectorTecnico> buscaPorEquipoNombre(String nombreEquipo); 
}
