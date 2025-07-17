package com.sistema.projeto.auth;

import com.sistema.projeto.model.Funcionario;
import com.sistema.projeto.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
        Optional<Funcionario> funcionarioOpt = funcionarioRepository.findByEmail(request.getEmail());

        if (funcionarioOpt.isPresent()) {
            Funcionario funcionario = funcionarioOpt.get();
            if (funcionario.getSenha().equals(request.getSenha())) {
                String token = jwtUtil.generateToken(funcionario.getEmail(), funcionario.getCargo().name());
                
                return ResponseEntity.ok(
                    Map.of(
                        "token", token,
                        "cargo", funcionario.getCargo(),
                        "id", funcionario.getId()
                    )
                );
            }
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email ou senha inválidos");
    }
}
