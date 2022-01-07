package com.example.springbootcampw2hw;


import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

enum Genre{
    romance,
    action,
    science,
    musical
}

@Setter
@Getter
@EqualsAndHashCode
@Builder
public class Movie {

    private int id;
    private String name;
    private int releaseYear;
    private Genre genre;
    private String director;
    private List<String> cast;
    private int point;
}
