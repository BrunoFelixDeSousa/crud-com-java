package com.brunofelix.crudcomjava.service;

import com.brunofelix.crudcomjava.model.Usuario;
import com.brunofelix.crudcomjava.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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


    public Optional<Usuario> buscarId(Long id) {
        return usuarioRepository.findById(id);
    }


    public void deletarUsuario(Usuario usuario) {
        usuarioRepository.delete(usuario);
    }
}