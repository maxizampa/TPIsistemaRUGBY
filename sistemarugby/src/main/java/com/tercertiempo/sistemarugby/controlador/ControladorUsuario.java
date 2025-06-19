package com.tercertiempo.sistemarugby.controlador;

import com.tercertiempo.sistemarugby.modelo.entidades.Usuario;
import com.tercertiempo.sistemarugby.servicio.UsuarioServicio;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class ControladorUsuario {

    private final UsuarioServicio servicioUsuario;

    public ControladorUsuario(UsuarioServicio servicioUsuario) {
        this.servicioUsuario = servicioUsuario;
    }

    @GetMapping 
    public List<Usuario> obtenerUsuarios() {
        return servicioUsuario.listarUsuarios();
    }

    @PostMapping
    public ResponseEntity<?> registrarUsuario(@Valid @RequestBody Usuario usuario, BindingResult resultado) {
        if (resultado.hasErrors()) {
            List<String> errores = resultado.getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .toList();

            return ResponseEntity.badRequest().body(errores);
        }

        Usuario usuarioGuardado = servicioUsuario.guardarUsuario(usuario);
        return ResponseEntity.ok(usuarioGuardado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable Integer id) {
        return servicioUsuario.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/nombre/{nombreUsuario}")
    public ResponseEntity<Usuario> obtenerUsuarioPorNombre(@PathVariable String nombreUsuario) {
        List<Usuario> usuarios = servicioUsuario.obtenerPorNombreUsuario(nombreUsuario);
        if (usuarios.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(usuarios.get(0));
        }
    }
}
