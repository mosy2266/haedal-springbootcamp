package com.haedal.spring.bootcamp.service;

import com.haedal.spring.bootcamp.Repository.UserRepository;
import com.haedal.spring.bootcamp.ResponseDTO.UserSimpleResponseDTO;
import com.haedal.spring.bootcamp.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserSimpleResponseDTO saveUser(User newUser) {
        if (userRepository.existsByUsername(newUser.getUsername())) {
            throw new IllegalStateException("중복되는 username입니다.");
        }

        userRepository.save(newUser);
        return convertUserToSimpleDTO(newUser, newUser);
    }

    public UserSimpleResponseDTO convertUserToSimpleDTO(User currentUser, User targetUser) {
        return new UserSimpleResponseDTO(
                currentUser.getId(),
                currentUser.getUsername(),
                currentUser.getName(),
                null,
                false
        );
    }
}
