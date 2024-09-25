package com.haedal.spring.bootcamp.Controller;

import com.haedal.spring.bootcamp.RequestDTO.UserRegistrationRequestDTO;
import com.haedal.spring.bootcamp.ResponseDTO.UserSimpleResponseDTO;
import com.haedal.spring.bootcamp.domain.User;
import com.haedal.spring.bootcamp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/auth/register")
    public ResponseEntity<UserSimpleResponseDTO> registerUser
            (@RequestBody UserRegistrationRequestDTO userRegistrationRequestDTO) {
        User user = new User(
                userRegistrationRequestDTO.getUsername(),
                userRegistrationRequestDTO.getPassword(),
                userRegistrationRequestDTO.getName()
        );
        UserSimpleResponseDTO savedUser = userService.saveUser(user);

        return ResponseEntity.ok(savedUser);
    }
}
