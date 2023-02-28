package com.oguztasgin.MovieAppJava5.dto.response;

import com.oguztasgin.MovieAppJava5.repository.entity.Genre;
import com.oguztasgin.MovieAppJava5.repository.entity.Movie;
import com.oguztasgin.MovieAppJava5.repository.entity.MovieComment;
import com.oguztasgin.MovieAppJava5.repository.entity.UserType;
import lombok.*;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
public class UserFindAllResponseDto {
    private Long id;
    private String name;
    private String surName;
    private String email;
    private String phone;
    private UserType userType;
    private List<Movie> favMovies;
    private List<Genre> genres;
    private List<String> movieCommentsContent;
    private Map<String,String> commentMap;
}
