package edu.cesur.fullstackProyecto.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.cesur.fullstackProyecto.entities.Usuario;
import edu.cesur.fullstackProyecto.services.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
    private LoginService loginService;

    @PostMapping("/acceder")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
    	String email = credentials.get("email");
        String password = credentials.get("password");

    	Usuario usuario = loginService.login(email, password);
        if (usuario != null) {
            return ResponseEntity.ok("Inicio de sesión exitoso");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
        }
    }
}
