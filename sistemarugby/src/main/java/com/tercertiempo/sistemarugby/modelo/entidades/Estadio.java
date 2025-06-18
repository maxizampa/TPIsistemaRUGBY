package com.tercertiempo.sistemarugby.modelo.entidades;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "estadios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Estadio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estadio")
    private int id;

    private String nombre;
    private String ubicacion;
    private int capacidad; // Número máximo de espectadores

    @OneToMany(mappedBy = "estadio") // Relación con Partido
    private List<Partido> partidos;
}
