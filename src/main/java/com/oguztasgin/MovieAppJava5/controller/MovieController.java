package com.oguztasgin.MovieAppJava5.controller;

import com.oguztasgin.MovieAppJava5.repository.entity.Movie;
import com.oguztasgin.MovieAppJava5.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @GetMapping("/findall")
    public ResponseEntity<List<Movie>> findAll(){
        return ResponseEntity.ok(movieService.findAll());
    }

    @GetMapping("/findbyrate")
    public   ResponseEntity<List<Movie>>  findAllByRatingGreaterThan(double rate){
        return ResponseEntity.ok(movieService.findAllByRatingGreaterThan(rate));
    }
    @GetMapping("/findbyusersgenres")
    public ResponseEntity<List<Movie>>  findMoviesByUsersGenres(Long id){
        return ResponseEntity.ok(movieService.findMoviesByUsersGenres(id));
    }

    @GetMapping("/findbydatebefore")
    public ResponseEntity<List<Movie>> findAllByPremieredBefore(String date){
        return ResponseEntity.ok(movieService.findAllByPremieredBefore(date));
    }

    @GetMapping("/searchbeyrating")
    public ResponseEntity<Object []> searchByRating(double rating){
        return ResponseEntity.ok(movieService.searchByRating(rating));
    }

    @GetMapping("/searchbeyrating2")
    public ResponseEntity<List<Object> >   searchByRating(){
        return ResponseEntity.ok( movieService.searchByRating());
    }

    @GetMapping("/searchbeyrating3")
    public ResponseEntity<Long> countByRatingEquals(double rating){
        return ResponseEntity.ok(movieService.countByRatingEquals(rating));
    }


    @GetMapping("/getmyspecial")
    public ResponseEntity<List<Movie>> findAllByRatingInEquals(){
        return ResponseEntity.ok(movieService.findAllByRatingIn());
    }

    /**
     * Dısarıdan veri Liste olarak alınamaz Array olarak almak zorundayız.
     * @param names
     * @return
     */
    @GetMapping("/getmymovienames")
    public  List<Movie> findAllByNameIn(String [] names){
        return movieService.findAllByNameIn(names);
    }

    @GetMapping("/countbycountry")
    public ResponseEntity<Object []> searchByCountry(){
        return ResponseEntity.ok(movieService.searchByCountry());
    }

}
