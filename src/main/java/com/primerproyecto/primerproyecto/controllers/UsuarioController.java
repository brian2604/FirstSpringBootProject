package com.primerproyecto.primerproyecto.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.primerproyecto.primerproyecto.dto.UsuarioDTO;
import com.primerproyecto.primerproyecto.entity.Usuario;
import com.primerproyecto.primerproyecto.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listarUsuarios() {
        List<UsuarioDTO> usuarios = usuarioService.obtenerUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> crearUsuario(@RequestBody UsuarioDTO usuario) {
        UsuarioDTO guardado = usuarioService.guardarUsuario(usuario);
        return ResponseEntity.ok(guardado);
    }

    @GetMapping ("/{id}")
    public ResponseEntity<UsuarioDTO> encontrarUsuario(@PathVariable Long id) {
        UsuarioDTO usuario = usuarioService.encontrarUsuario(id);

        if (id != null) {
            return ResponseEntity.ok(usuario);
        } else {
            return null;
        }
    }

    @PutMapping ("/{id}")
    public ResponseEntity<UsuarioDTO> actualizarUsuario(@PathVariable Long id,@RequestBody Usuario usuarioEntity){
        UsuarioDTO usuarioActualizado = usuarioService.actualizarUsuario(id, usuarioEntity);
        return ResponseEntity.ok(usuarioActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UsuarioDTO> eliminarUsuario(@PathVariable Long id) {
        UsuarioDTO eliminado = usuarioService.eliminarUsuario(id);

        if (id != null) {
            return ResponseEntity.ok(eliminado);
        } else {
            return null;
        }
    }
}