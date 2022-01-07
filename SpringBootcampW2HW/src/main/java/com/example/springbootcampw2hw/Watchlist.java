package com.example.springbootcampw2hw;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class Watchlist {
    private int id;
    private String name;
    private List<Integer> listOfMovies;
}
