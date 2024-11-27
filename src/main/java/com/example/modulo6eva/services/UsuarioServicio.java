package com.example.modulo6eva.services;

import com.example.modulo6eva.model.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioServicio {
    User validateUser(String username, String password);
    User signup(User user);
    UserDetails loadUserByUsername(String username);
}
