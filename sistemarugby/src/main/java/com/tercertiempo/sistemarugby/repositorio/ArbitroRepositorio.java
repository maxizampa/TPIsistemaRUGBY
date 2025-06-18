package com.tercertiempo.sistemarugby.repositorio;

import com.tercertiempo.sistemarugby.modelo.entidades.Arbitro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository// da acceso automatico a los metodos crud extendiendo desde JpaRepository
public interface ArbitroRepositorio extends JpaRepository<Arbitro, Integer> {

    List<Arbitro> buscaPorNombre(String nombre); 

    List<Arbitro> buscaPorApellido(String apellido); 

    List<Arbitro> buscaPorExperienciaMayorOIgualque(int experiencia);

    // metodo query para buscar por nombre y apellido a travez de jpa query
    @Query("SELECT a FROM Arbitro a WHERE LOWER(a.nombre) = LOWER(:nombre) AND LOWER(a.apellido) = LOWER(:apellido)")
    List<Arbitro> buscarPorNombreYApellido(@Param("nombre") String nombre, @Param("apellido") String apellido);
}

