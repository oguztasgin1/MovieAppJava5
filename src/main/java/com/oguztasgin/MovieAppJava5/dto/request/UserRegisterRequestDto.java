package com.oguztasgin.MovieAppJava5.dto.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
public class UserRegisterRequestDto {
    private String name;
    private String surName;
    private String email;
    private String password;

    // Disaridan bir json object alıyor ve dto' da uyuyorsa setliyor. spring or spring-web
    // icindeki json objectleri cevirmeye yarar.

}
