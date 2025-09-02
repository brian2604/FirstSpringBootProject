package com.primerproyecto.primerproyecto.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.primerproyecto.primerproyecto.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primerproyecto.primerproyecto.dto.UsuarioDTO;
import com.primerproyecto.primerproyecto.entity.Usuario;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioDTO> obtenerUsuarios() {
        return usuarioRepository.findAll()
                .stream()
                .map(usuario -> UsuarioDTO.builder()
                        .id(usuario.getId())
                        .nombre(usuario.getNombre())
                        .correo(usuario.getCorreo())
                        .clave(usuario.getClave())
                        .fechaCreacion(usuario.getFechaCreacion())
                        .build())
                .collect(Collectors.toList());
    }

    public UsuarioDTO guardarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setCorreo(usuarioDTO.getCorreo());
        usuario.setClave(usuarioDTO.getClave());

        Usuario guardado = usuarioRepository.save(usuario);

        return UsuarioDTO.builder()
                .id(guardado.getId())
                .nombre(guardado.getNombre())
                .correo(guardado.getCorreo())
                .clave(guardado.getClave())
                .fechaCreacion(guardado.getFechaCreacion())
                .build();
    }

    public UsuarioDTO actualizarUsuario(Long id, Usuario usuarioEntity ) {
        Optional<Usuario> listaUsuarios= usuarioRepository.findById(id);  
        
        if (listaUsuarios.isPresent()) {
        
            Usuario usuarioEncontrado = listaUsuarios.get();
            usuarioEncontrado.setNombre(usuarioEntity.getNombre());
            usuarioEncontrado.setCorreo(usuarioEntity.getCorreo());
            usuarioEncontrado.setClave(usuarioEntity.getClave());

            Usuario usuarioActualizado = usuarioRepository.save(usuarioEncontrado);

        return UsuarioDTO.builder()
                        .id(usuarioActualizado.getId())
                        .nombre(usuarioActualizado.getNombre())
                        .correo(usuarioActualizado.getCorreo())
                        .clave(usuarioActualizado.getClave())
                        .fechaCreacion(usuarioActualizado.getFechaCreacion())
                        .build();
        } else{
            return null;
        }
    }

    public UsuarioDTO encontrarUsuario(Long id) {
        return usuarioRepository.findById(id)
                .map(usuario -> UsuarioDTO.builder()
                        .id(usuario.getId())
                        .nombre(usuario.getNombre())
                        .correo(usuario.getCorreo())
                        .clave(usuario.getClave())
                        .fechaCreacion(usuario.getFechaCreacion())
                        .build())
                .orElse(null);
    }

    public UsuarioDTO eliminarUsuario(Long id){
        return usuarioRepository.findById(id)
        .map(usuario-> {usuarioRepository.delete(usuario);
        return UsuarioDTO.builder()
                        .id(usuario.getId())
                        .nombre(usuario.getNombre())
                        .correo(usuario.getCorreo())
                        .clave(usuario.getClave())
                        .fechaCreacion(usuario.getFechaCreacion())
                        .build();
        }).orElse(null);                
    }
}