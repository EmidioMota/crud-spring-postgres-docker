package br.com.midios.springapp.service;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.midios.springapp.model.Usuario;
import br.com.midios.springapp.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = new BCryptPasswordEncoder()  ;
    }

    public Usuario registrarUsuario(String username, String password) {
        String encodedPassword = passwordEncoder.encode(password);
        Usuario usuario = new Usuario(username, encodedPassword);
        return usuarioRepository.save(usuario);
    }
    
    public Optional<Usuario> buscarUsuarioPorUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }
}
