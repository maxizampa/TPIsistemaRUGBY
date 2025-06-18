package com.tercertiempo.sistemarugby.modelo.entidades;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "directores_tecnicos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DirectorTecnico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_director_tecnico")
    private int id;

    private String nombre;
    private String apellido;
    private int experiencia; // Años de experiencia en el rugby

    @ManyToOne
    @JoinColumn(name = "equipo_id")
    private Equipo equipo;
}
