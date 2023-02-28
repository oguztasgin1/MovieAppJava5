package com.oguztasgin.MovieAppJava5.service;

import com.oguztasgin.MovieAppJava5.repository.IGenreRepository;
import com.oguztasgin.MovieAppJava5.repository.entity.Genre;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GenreService {

    private final IGenreRepository genreRepository;

    public List<Genre> createGenresWithNames(List<String> genres) {
        List<Genre> genreList = new ArrayList<>();

        for (String name: genres){
            Optional<Genre> genre = genreRepository.findOptionalByName(name);

            if (genre.isPresent()){
                genreList.add(genre.get());
            }else{
                Genre genre1 = Genre.builder().name(name).build();
                genreRepository.save(genre1);
                genreList.add(genre1);
            }
        }

        return genreList;
    }
}
