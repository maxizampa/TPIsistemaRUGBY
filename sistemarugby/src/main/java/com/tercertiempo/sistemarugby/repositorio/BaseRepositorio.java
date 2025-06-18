package com.tercertiempo.sistemarugby.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface BaseRepositorio<T, ID> extends JpaRepository<T, ID> { //T ES LA ENTIDAD Y ID ES EL TIPO DE DATO DEL ID

    Optional<T> findById(ID id);// Método para buscar una entidad por su ID, devuelve un Optional para manejar la ausencia de resultados de manera segura

}
