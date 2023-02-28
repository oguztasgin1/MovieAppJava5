package com.oguztasgin.MovieAppJava5.repository;

import com.oguztasgin.MovieAppJava5.repository.entity.Genre;
import com.oguztasgin.MovieAppJava5.repository.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional
public interface IMovieRepository extends JpaRepository<Movie,Long> {



    List<Movie> findAllByRatingGreaterThan(double rate);


    List<Movie> findAllByGenresInOrderByRatingDesc(List<Genre> genres);

    List<Movie> findAllByPremieredBefore(LocalDate date);

    @Query(value = "select count(m.rating), rating from Movie as m group by m.rating having m.rating = ?1")
    Object [] searchByRating(double rating);

    @Query(value = "select count(m.rating), rating from Movie as m group by m.rating")
    List<Object> searchByRating();

    Long countByRatingEquals(double rating);

    List<Movie> findAllByRatingIn(List<Double> ratings);

    List<Movie> findAllByNameIn(String [] names);

    @Query(value = "select count(m.country), country from Movie as m group by m.country ")
    Object [] searchByCountry();

}
