package com.example.springbootcampw2hw;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class MemberController {

    @PutMapping("/{memberId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void givePoint(@PathVariable int memberId, @RequestParam int movieId, @RequestParam int point){

        Member member = Member.builder()
                .id(memberId)
                .name("John")
                .watchlist(new ArrayList<>())
                .build();

        member.givePoint(movieId, point);
    }

    @PostMapping("/{memberId}/new")
    @ResponseStatus(HttpStatus.CREATED)
    public void createWatchlist(@PathVariable int memberId, @RequestParam String watchlistName){
        Member member = Member.builder()
                .id(memberId)
                .name("John")
                .watchlist(new ArrayList<>())
                .build();

       member.createWatchlist(watchlistName);
    }

    @PutMapping("/{memberId}/{watchlistId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addToWatchlist(@PathVariable int memberId, @PathVariable int watchlistId, @RequestParam int movieId){
        Member member = Member.builder()
                .id(memberId)
                .name("John")
                .watchlist(new ArrayList<>())
                .build();

        member.addToWatchlist(watchlistId, movieId);
    }

}
