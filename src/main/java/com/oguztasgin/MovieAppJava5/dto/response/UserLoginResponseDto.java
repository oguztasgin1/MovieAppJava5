package com.oguztasgin.MovieAppJava5.dto.response;


import com.oguztasgin.MovieAppJava5.repository.entity.Movie;
import com.oguztasgin.MovieAppJava5.repository.entity.UserType;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserLoginResponseDto {
    private Long id;
    private String name;
    private String surName;
    private String email;
    private UserType userType;
}
