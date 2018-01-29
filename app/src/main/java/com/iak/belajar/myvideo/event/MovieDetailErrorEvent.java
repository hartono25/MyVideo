package com.iak.belajar.myvideo.event;

public class MovieDetailErrorEvent extends BaseEvent {
    public MovieDetailErrorEvent(String message) {
        super(message);
    }
}