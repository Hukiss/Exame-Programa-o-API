package com.criandoapi.projeto.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "usuarios")
@Getter @Setter
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome", nullable = true, length =  200)
    private String nome;

    @Column(name = "email", length = 50 , nullable = true )
    private String email;

    @Column(name = "senha", nullable = true)
    private String senha;

    @Column(name = "contacto", nullable = true, length = 15)
    private String conctato;

}
