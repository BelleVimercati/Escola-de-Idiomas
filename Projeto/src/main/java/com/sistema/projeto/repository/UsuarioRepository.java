package com.sistema.projeto.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.sistema.projeto.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
} 
    

