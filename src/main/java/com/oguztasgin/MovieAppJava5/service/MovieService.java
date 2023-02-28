package com.oguztasgin.MovieAppJava5.service;

import com.oguztasgin.MovieAppJava5.repository.IMovieRepository;
import com.oguztasgin.MovieAppJava5.repository.entity.Genre;
import com.oguztasgin.MovieAppJava5.repository.entity.Movie;
import com.oguztasgin.MovieAppJava5.repository.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final IMovieRepository movieRepository;

    private final UserService userService;


    public Movie save(Movie movie) {

        return movieRepository.save(movie);
    }

    public List<Movie> findAllByIds(List<Long> ids) {
        return   ids.stream().map(x->movieRepository.findById(x).get()).collect(Collectors.toList());
    }

    public Movie findbyId(long id) {
        Optional<Movie> movie=movieRepository.findById(id);
        if (movie.isPresent()){
            return movie.get();
        }else{
            throw  new RuntimeException("KLullanýcý bulunamadý");
        }
    }

    public List<Movie> findAll() {
        return  movieRepository.findAll();
    }

    public  List<Movie> findAllByRatingGreaterThan(double rate){

        return movieRepository.findAllByRatingGreaterThan(rate);
    }

    public List<Movie> findMoviesByUsersGenres(Long id){
        Optional<User> user= userService.findById(id);
        if (user.isPresent()){
            List<Genre> genres=user.get().getFavGenres();
            return  movieRepository.findAllByGenresInOrderByRatingDesc(genres);
        }else{
            throw new RuntimeException("KullanfindAllByPremieredBefore(String date)ici bulunamadi");
        }
    }

    public List<Movie> findAllByPremieredBefore(String date){
        return movieRepository.findAllByPremieredBefore(LocalDate.parse(date));
    }

    public Object [] searchByRating(double rating){
        return movieRepository.searchByRating(rating);
    }

    public List<Object> searchByRating(){
        return movieRepository.searchByRating();
    }

    public Long countByRatingEquals(double rating){
        return movieRepository.countByRatingEquals(rating);
    }

    public List<Movie> findAllByRatingIn(){
        List<Double> ratings = List.of(7D,8D, 9D);
        return movieRepository.findAllByRatingIn(ratings);
    }

    public  List<Movie> findAllByNameIn(String [] names){
        return movieRepository.findAllByNameIn(names);
    }

    public Object [] searchByCountry(){
        return movieRepository.searchByCountry();
    }

}
