package com.criandoapi.projeto.repository;

import com.criandoapi.projeto.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuario extends JpaRepository<Usuarios, Integer> {
}
