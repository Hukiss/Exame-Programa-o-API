package com.criandoapi.projeto.controller;
import com.criandoapi.projeto.model.Usuarios;
import com.criandoapi.projeto.services.UsuarioServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/usuarios")
public class UsuariosController {

    private UsuarioServices usuarioService;

    public UsuariosController(UsuarioServices usuarioServices) {
        this.usuarioService = usuarioServices;
    }

    @GetMapping
    public ResponseEntity<List<Usuarios>> listaUsuarios() {
        return ResponseEntity.status(200).body(usuarioService.listaUsuarios());
    }

    @PostMapping
    public ResponseEntity<Usuarios> criarUsuarios(@RequestBody Usuarios usuarios) {
        return ResponseEntity.status(201).body(usuarioService.criarUsuario(usuarios));
    }

    @PutMapping
    public ResponseEntity<Usuarios> editarUsuarios(@RequestBody Usuarios usuarios) {
        return ResponseEntity.status(200).body(usuarioService.editarUsuarios(usuarios));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUsuarios(@PathVariable Integer id) {
        usuarioService.deletarUsuariosPorID(id);
        return ResponseEntity.status(204).build();
    }

    @PostMapping("/login")
    public ResponseEntity<Usuarios> verificarSenha(@RequestBody Usuarios usuario){
        Boolean validar = usuarioService.validarSenha(usuario);
        if (!validar) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        return ResponseEntity.status(200).build();
    }
}
