package com.oguztasgin.MovieAppJava5.controller;

import com.oguztasgin.MovieAppJava5.repository.entity.MovieComment;
import com.oguztasgin.MovieAppJava5.service.MovieCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("moviecomment")
@RequiredArgsConstructor
public class MovieCommentController {

    private final MovieCommentService movieCommentService;


    @GetMapping("/findallbymovie")
    public ResponseEntity<List<MovieComment>> findAllByMyMovies(Long movieId) {
        return ResponseEntity.ok(movieCommentService.findAllByMyMovies(movieId));
    }

    @GetMapping("/findallbymovie2")
    public ResponseEntity<List<MovieComment>> findAllByMovie_Id(Long movieId) {
        return ResponseEntity.ok(movieCommentService.findAllByMovie_Id(movieId));
    }

    @GetMapping("/findallbyuser")
    public ResponseEntity<List<MovieComment>> findAllByUser_Id(Long userId) {
        return ResponseEntity.ok(movieCommentService.findAllByUser_Id(userId));
    }

    @GetMapping("/findbydatebetweenanduserid")
    public ResponseEntity<List<MovieComment>> findAllByDateBetweenAndUser_Id(String start, String end, Long userId) {
        return ResponseEntity.ok(movieCommentService.findAllByDateBetweenAndUser_Id(start, end, userId));
    }

    @GetMapping("/findbydatebetweenandmovieid")
    public ResponseEntity<List<MovieComment>> findAllByDateBetweenAndMovie_Id(String start, String end, Long movieId) {
        return ResponseEntity.ok(movieCommentService.findAllByDateBetweenAndMovie_Id(start, end, movieId));
    }

    @GetMapping("/findbycontentcontains")
    public ResponseEntity<List<MovieComment>> findAllByContentContainingIgnoreCase(String value) {

        return ResponseEntity.ok(movieCommentService.findAllByContentContainingIgnoreCase(value));
    }

    @GetMapping("/findbycontentsize")
    public ResponseEntity<List<MovieComment>> findAllByContentSize(int length) {

        return ResponseEntity.ok(movieCommentService.findAllByContentSize(length));
    }


    @GetMapping("/findbycontentsize2")
    public ResponseEntity<List<String>> findAllByContentSizeString(int length) {

        return ResponseEntity.ok(movieCommentService.findAllByContentSizeString(length));
    }



}