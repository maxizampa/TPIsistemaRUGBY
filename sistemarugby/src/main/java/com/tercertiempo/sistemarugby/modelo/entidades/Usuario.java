package com.tercertiempo.sistemarugby.modelo.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

import com.tercertiempo.sistemarugby.modelo.util.TipoUsuario;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private int id;

    @NotBlank(message = "El nombre de usuario no puede estar vacío")
    @Column(unique = true) // Garantiza que no haya nombres de usuario duplicados
    private String nombreUsuario;
        
    

    @Email(message = "El email debe tener un formato válido") // ver mensajes como viaja
    @NotBlank(message = "El email no puede estar vacío")
    private String email;

    @NotBlank(message = "La contraseña no puede estar vacía")
    @Column(name = "contraseña")
    @ToString.Exclude // Excluye la contraseña del método toString para no exponerla
    private String contraseña;

    @Enumerated(EnumType.STRING)
    private TipoUsuario rol;

    @Column(updatable = false)
    private LocalDateTime fechaCreacion;

    @PrePersist
    protected void onCreate() {
    fechaCreacion = LocalDateTime.now();
}
}
