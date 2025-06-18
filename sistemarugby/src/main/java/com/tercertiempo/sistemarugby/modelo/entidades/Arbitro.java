package com.tercertiempo.sistemarugby.modelo.entidades;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "arbitros")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Arbitro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_arbitro")
    private int id;

    private String nombre;
    private String apellido;
    private int experiencia; // Años de experiencia arbitrando partidos

    @ManyToMany(mappedBy = "arbitros")
    private List<Partido> partidos;
}
