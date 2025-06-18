package com.tercertiempo.sistemarugby.modelo.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "equipos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_equipo")
    private int id;

    private String nombre;
    private String ciudad;
    private String categoria;
    private String siglas;

    @OneToMany(mappedBy = "equipo")
    private List<Jugador> jugadores;
}
