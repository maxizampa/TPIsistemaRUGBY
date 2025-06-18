package com.tercertiempo.sistemarugby.modelo.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.time.Year;
import java.util.List;

import com.tercertiempo.sistemarugby.modelo.util.ResultadoPartido;

@Entity
@Table(name = "temporadas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Temporada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_temporada")
    private int id;

    private Year anio;

    @OneToMany(mappedBy = "temporada")
    private List<Partido> partidos;


}
