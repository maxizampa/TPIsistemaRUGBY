package com.tercertiempo.sistemarugby.modelo.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "eventos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_evento")
    private int id;

    private String nombre;
    private String descripcion;
    private LocalDateTime fechaHora;

    @ManyToOne
    @JoinColumn(name = "equipo_id")
    private Equipo equipo;
}
