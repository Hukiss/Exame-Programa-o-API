package com.criandoapi.projeto.services;

import com.criandoapi.projeto.model.Usuarios;
import com.criandoapi.projeto.repository.IUsuario;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.System.err;

@Service
public class UsuarioServices {

    private IUsuario repository;
    private PasswordEncoder passwordEncoder;

    public UsuarioServices (IUsuario repository) {
        this.repository = repository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public List<Usuarios> listaUsuarios(){
        List<Usuarios> lista = repository.findAll();
        return lista;
    }

    public Usuarios criarUsuario(Usuarios usuarios){
        String encoder = this.passwordEncoder.encode(usuarios.getSenha());
        usuarios.setSenha(encoder);
        Usuarios usuariosNew = repository.save(usuarios);
        return usuariosNew;
    }

    public Usuarios editarUsuarios(Usuarios usuarios) {
        String encoder = this.passwordEncoder.encode(usuarios.getSenha());
        usuarios.setSenha(encoder);
        Usuarios usuariosNew = repository.save(usuarios);
        return usuariosNew;
    }

    public Boolean deletarUsuariosPorID(Integer id) {
        repository.deleteById(id);
        return true;
    }

    public Boolean validarSenha(Usuarios usuario) {
        String senha = repository.getById(usuario.getId()).getSenha() ;
        Boolean validar = passwordEncoder.matches(usuario.getSenha(), senha);
        return validar;
    }
}
