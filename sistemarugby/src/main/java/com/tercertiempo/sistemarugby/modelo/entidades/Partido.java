package com.tercertiempo.sistemarugby.modelo.entidades;

import jakarta.persistence.*;
import lombok.*;
import com.tercertiempo.sistemarugby.modelo.util.EstadoPartido;
import com.tercertiempo.sistemarugby.modelo.util.ResultadoPartido;


import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "partidos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Partido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_partido")
    private int id;

    private LocalDate fecha;
    private String estadio;

    @ManyToOne
    @JoinColumn(name = "equipo_local_id", nullable = false)
    private Equipo equipoLocal;

    @ManyToOne
    @JoinColumn(name = "temporada_id")
    private Temporada temporada;

    @ManyToOne
    @JoinColumn(name = "equipo_visitante_id", nullable = false)
    private Equipo equipoVisitante;

    @Enumerated(EnumType.STRING)
    private EstadoPartido estado;

    private int puntosLocal;
    private int puntosVisitante;
    
    @Enumerated(EnumType.STRING)
    private ResultadoPartido resultado;

    // Relación ManyToMany con Arbitros
    @ManyToMany
    @JoinTable(
        name = "partido_arbitro",
        joinColumns = @JoinColumn(name = "id_partido"),
        inverseJoinColumns = @JoinColumn(name = "id_arbitro")
    )
    private List<Arbitro> arbitros;
}
