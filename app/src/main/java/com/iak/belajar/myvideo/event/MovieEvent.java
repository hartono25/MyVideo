package com.iak.belajar.myvideo.event;


import com.iak.belajar.myvideo.model.MovieResponse;

public class MovieEvent extends BaseEvent {
    private MovieResponse body;

    public MovieEvent(String message, MovieResponse body) {
        super(message);
        this.body = body;
    }

    public MovieResponse getBody() {
        return body;
    }
}