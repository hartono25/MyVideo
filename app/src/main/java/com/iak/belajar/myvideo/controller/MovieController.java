package com.iak.belajar.myvideo.controller;

import com.iak.belajar.myvideo.App;
import com.iak.belajar.myvideo.event.MovieDetailErrorEvent;
import com.iak.belajar.myvideo.event.MovieDetailEvent;
import com.iak.belajar.myvideo.event.MovieErrorEvent;
import com.iak.belajar.myvideo.event.MovieEvent;
import com.iak.belajar.myvideo.model.Movie;
import com.iak.belajar.myvideo.model.MovieResponse;
import com.iak.belajar.myvideo.restapi.RestAPIURL;
import com.iak.belajar.myvideo.utility.AppConstant;

import org.greenrobot.eventbus.EventBus;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MovieController {
    private EventBus eventBus = App.getInstance().getEventBus();

    public void getDataSearch(String query, int page) {
        Call<MovieResponse> movieResponseCall = App.getInstance().getApiService().getSearchMovies(RestAPIURL.getApiKey(), query, RestAPIURL.getLangSource(), page);
        movieResponseCall.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                eventBus.post(new MovieEvent(response.message(), response.body()));
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                eventBus.post(new MovieErrorEvent(t.getMessage()));
            }
        });
    }

    public void getMovies(int type, int page) {
        Call<MovieResponse> movieResponseCall = App.getInstance().getApiService().getMovies(AppConstant.MOVIE_LIST_TYPE[type], RestAPIURL.getApiKey(), RestAPIURL.getLangSource(), page, RestAPIURL.getMoviesRegion());
        movieResponseCall.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                eventBus.post(new MovieEvent(response.message(), response.body()));
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                eventBus.post(new MovieErrorEvent(t.getMessage()));
            }
        });
    }

    public void getNowPlayingMovies(int page) {
        getMovies(0, page);
    }

    public void getPopularMovies(int page) {
        getMovies(1, page);
    }

    public void getTopRatedMovies(int page) {
        getMovies(2, page);
    }

    public void getComingSoonMovies(int page) {
        getMovies(3, page);
    }

    public void getMovieDetail(int idMovies) {
        Call<Movie> movieCall = App.getInstance().getApiService().getMovieDetails(idMovies, RestAPIURL.getApiKey(), RestAPIURL.getLangSource(), RestAPIURL.getMovieAppendToResponse());
        movieCall.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                eventBus.post(new MovieDetailEvent(response.message(), response.body()));
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                eventBus.post(new MovieDetailErrorEvent(t.getMessage()));
            }
        });
    }

}