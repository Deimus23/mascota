package itacademy.mascota.service;

import itacademy.mascota.configuration.JwtTokenUtil;
import itacademy.mascota.dto.AuthRequestDTO;
import itacademy.mascota.dto.AuthResponseDTO;
import itacademy.mascota.model.User;
import itacademy.mascota.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final JwtTokenUtil tokenUtil;
    private final PasswordEncoder encoder;
    public AuthResponseDTO register(AuthRequestDTO registerDTO) {
        String username = registerDTO.getUsername();
        if (userRepository.findByUsername(username).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Username already exists");
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(encoder.encode(registerDTO.getPassword()));
        userRepository.save(user);
        String token = tokenUtil.generateToken(user.getUsername());
        return new AuthResponseDTO(token);
    }

    public AuthResponseDTO login(AuthRequestDTO loginDTO) {
        String name = loginDTO.getUsername();
        Optional<User> userOptional = userRepository.findByUsername(name);
        if (userOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(401));
        }
        User user = userOptional.get();
        boolean passMatches=encoder.matches(loginDTO.getPassword(),user.getPassword());
        if(!passMatches){
            throw new ResponseStatusException(HttpStatusCode.valueOf(401));
        }
        String token=tokenUtil.generateToken(user.getUsername());
        return new AuthResponseDTO(token);
    }
    public User getCurrentUser(){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user;
    }

}
