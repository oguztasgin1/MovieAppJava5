package com.oguztasgin.MovieAppJava5.repository.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "tblmoviecomment")
public class MovieComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 500)
    private String content;
    @Builder.Default
    private LocalDate date = LocalDate.now();

    @ManyToOne
    private User user;

    @ManyToOne
    private Movie movie;
}
