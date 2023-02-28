package com.oguztasgin.MovieAppJava5.dto.response;


import com.oguztasgin.MovieAppJava5.repository.entity.UserType;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
public class UserRegisterResponseDto {

    private Long id;
    private String name;
    private String surName;
    private String email;
    private UserType userType;
}
