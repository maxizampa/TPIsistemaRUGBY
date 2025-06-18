package com.tercertiempo.sistemarugby.modelo.entidades;

import jakarta.persistence.*;
import com.tercertiempo.sistemarugby.modelo.util.PuestoJugador;
import lombok.*;

@Entity
@Table(name = "jugadores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_jugador")
    private int id;

    private String nombre;
    private String apellido;
    private int edad;

    @Enumerated(EnumType.STRING) // Guarda el nombre del enum en la BD
    @Column(name = "posicion") //esto es de hibernate
    private PuestoJugador posicion;

    @ManyToOne
    @JoinColumn(name = "equipo_id", nullable = false)
    private Equipo equipo;
}
