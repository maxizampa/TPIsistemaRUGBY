package com.tercertiempo.sistemarugby.repositorio;

import com.tercertiempo.sistemarugby.modelo.entidades.Arbitro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.lang.NonNull;
import java.util.List;
//import java.util.Optional;

@Repository// da acceso automatico a los metodos crud extendiendo desde JpaRepository
public interface ArbitroRepositorio extends JpaRepository<Arbitro, Integer> {

    // Métodos CRUD explícitos usando JpaRepository
    @NonNull// esto indica que el método no debe devolver null 
    List<Arbitro> findAll(); // LISTA TODOS
    boolean existsById(@NonNull Integer id); // VERIFICA SI EXISTE POR ID
    List<Arbitro> findByNombre(String nombre); // BUSCA POR NOMBRE
    List<Arbitro> findByApellido(String apellido); // BUSCA POR APELLIDO
    long count(); // CUENTA TODOS LOS ARBITRO  
    // El método save ya está provisto por JpaRepository y no necesita ser redeclarado
    
    void deleteById(@NonNull Integer id); // ELIMINA POR ID
    


    // metodo query para buscar por nombre y apellido a travez de jpa query
    @Query("SELECT a FROM Arbitro a WHERE LOWER(a.nombre) = LOWER(:nombre) AND LOWER(a.apellido) = LOWER(:apellido)")
    List<Arbitro> buscarPorNombreYApellido(@Param("nombre") String nombre, @Param("apellido") String apellido);
}

