package com.iak.belajar.myvideo.event;

public class MovieErrorEvent extends BaseEvent {
    public MovieErrorEvent(String message) {
        super(message);
    }
}