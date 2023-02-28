package com.oguztasgin.MovieAppJava5.dto.request;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserLoginRequestDto {
    private String email;
    private String password;
}
