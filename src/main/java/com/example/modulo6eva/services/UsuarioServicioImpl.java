package com.example.modulo6eva.services;

import com.example.modulo6eva.exception.InvalidAlumnoDataException;
import com.example.modulo6eva.model.Role;
import com.example.modulo6eva.model.User;
import com.example.modulo6eva.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioServicioImpl implements UsuarioServicio {
    private final UserRepository userRepository;

    public User validateUser(String username, String password) {
        System.out.println("2.-----------------------------------------------------");
        return userRepository.findByUsername(username)
                .map(user -> {
                    if (password == user.getPassword()) {
                        System.out.println("3.----------------------------------------------");
                        return user;
                    }
                    throw new InvalidAlumnoDataException("Contraseña incorrecta");
                })
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));
    }

    public User signup(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("Username is already taken!");
        }
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email is already in use!");
        }

        user.setPassword(user.getPassword());
        user.setRol(Role.ROLE_CLIENT);
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        return null;
    }
}