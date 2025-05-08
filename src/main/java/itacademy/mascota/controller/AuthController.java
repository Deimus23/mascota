package itacademy.mascota.controller;

import itacademy.mascota.dto.AuthRequestDTO;
import itacademy.mascota.dto.AuthResponseDTO;
import itacademy.mascota.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    @PostMapping("/register")
    public ResponseEntity<AuthResponseDTO> resgister(@RequestBody AuthRequestDTO registerDTO){
        return ResponseEntity.ok(this.authService.register(registerDTO));
    }
    @PostMapping("/loging")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody AuthRequestDTO loginDTO){
        return ResponseEntity.ok(this.authService.login(loginDTO));
    }


}
