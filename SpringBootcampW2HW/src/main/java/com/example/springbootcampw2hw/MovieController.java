package com.example.springbootcampw2hw;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
public class MovieController {

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public Movie createMovie(@RequestBody Movie movie){
        /*
        A body must be passed to create a movie
        id and point are not meant to pass, id is random, point is default starts from 0
         */
        return Movie.builder()
                .id(new Random().nextInt())
                .name(movie.getName())
                .releaseYear(movie.getReleaseYear())
                .genre(movie.getGenre())
                .director(movie.getDirector())
                .cast(movie.getCast())
                .point(0)
                .build();
    }

    @GetMapping("/movies")
    public List<Movie> getMovies(){
        // returns list of movies in the database
        return List.of(
                Movie.builder()
                        .id(625384)
                        .name("Skyfall")
                        .releaseYear(1995)
                        .genre(Genre.science)
                        .director("Stephen Hawking")
                        .cast(List.of("James Bond", "Antony Hopkins"))
                        .point(0)
                        .build(),

                Movie.builder()
                        .id(938083)
                        .name("Mountain")
                        .releaseYear(1997)
                        .genre(Genre.musical)
                        .director("Jonathan Hawking")
                        .cast(List.of("Neo", "Trinity"))
                        .point(0)
                        .build()
        );
    }

    @DeleteMapping("/movies/delete/{movieID}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMovie(@PathVariable int movieID){
    /*
    Supposed to delete the movie with id as movieId from the database
     */
    }
}
