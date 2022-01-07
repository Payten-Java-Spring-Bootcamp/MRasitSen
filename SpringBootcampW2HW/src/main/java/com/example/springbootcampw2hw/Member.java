package com.example.springbootcampw2hw;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
@Setter
@Builder
public class Member {
    private int id;
    private String name;
    private List<Watchlist> watchlist;

    public void createWatchlist(String watchlistName){
        watchlist.add(
                Watchlist.builder()
                        .id(new Random().nextInt())
                        .name(watchlistName)
                        .listOfMovies(new ArrayList<>())
                        .build());
    }

    public void addToWatchlist(int watchlistId, int movieId){
            Watchlist.builder()
                    .name("no_name")
                    .id(watchlistId)
                    .listOfMovies(List.of(movieId))
                    .build();
    }


    public void givePoint(int movieId, int point){
        Movie movie = Movie.builder()
                .id(movieId)
                .name("Skyfall")
                .releaseYear(1995)
                .genre(Genre.science)
                .director("Stephen Hawking")
                .cast(List.of("James Bond", "Antony Hopkins"))
                .point(0)
                .build();

        movie.setPoint(movie.getPoint() + point);
    }

}


