package com.haedal.spring.bootcamp.ResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserSimpleResponseDTO {
    private Long id;
    private String username;
    private String name;
    private String imageData;
    private Boolean isFollowing;
}
