package com.tercertiempo.sistemarugby.repositorio;

import com.tercertiempo.sistemarugby.modelo.entidades.Equipo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;


@Repository // Anotación para indicar que esta interfaz es un repositorio
public interface EquipoRepositorio extends JpaRepository<Equipo, Integer> {
    
     // Métodos CRUD explícitos usando JpaRepository
    @NonNull// esto indica que el método no debe devolver null 
    List<Equipo> findAll(); // LISTA TODOS
    boolean existsById(@NonNull Integer id); // VERIFICA SI EXISTE POR ID
    List<Equipo> findByNombre(String nombre); // BUSCA POR NOMBRE
    List<Equipo> findByCiudad(String ciudad); // BUSCA POR CIUDAD
    List<Equipo> findByCategoria(String Categoria);
    //List<Equipo> findByApellido(String apellido); // BUSCA POR APELLIDO
    long count(); // CUENTA TODOS LOS Equipo  
    // El método save ya está provisto por JpaRepository y no necesita ser redeclarado
    
    void deleteById(@NonNull Integer id); // ELIMINA POR ID

    // metodo personalizado


    @Query("SELECT e FROM Equipo e WHERE LOWER(e.ciudad) = LOWER(:ciudad)")
    List<Equipo> buscarEquipoPorCiudad(@Param("ciudad") String ciudad);

    
}
