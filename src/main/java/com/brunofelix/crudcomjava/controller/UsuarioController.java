package com.brunofelix.crudcomjava.controller;

import com.brunofelix.crudcomjava.model.Usuario;
import com.brunofelix.crudcomjava.service.UsuarioService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/salvar") /* salvar usuario no banco */
    public ResponseEntity<Object> salvarUsuario(@RequestBody Usuario u) {
        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(u, usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.salvar(usuario));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Usuario>> listarTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarId(@PathVariable(value = "id") Long id) {
        Optional<Usuario> optionalUsuario = usuarioService.buscarId(id);
        if (!optionalUsuario.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(optionalUsuario.get());
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Object> DeletarUsuario(@PathVariable(value = "id") Long id) {
        Optional<Usuario> optionalUsuario = usuarioService.buscarId(id);
        if (!optionalUsuario.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não encontrado!");
        }
        usuarioService.deletarUsuario(optionalUsuario.get());
        return ResponseEntity.status(HttpStatus.OK).body("Usuario deletado com sucesso");
    }
}
