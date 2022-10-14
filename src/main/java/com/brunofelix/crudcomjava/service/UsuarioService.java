package com.brunofelix.crudcomjava.service;

import com.brunofelix.crudcomjava.model.Usuario;
import com.brunofelix.crudcomjava.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }


    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }
}