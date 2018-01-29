package com.iak.belajar.myvideo;

import android.app.Application;

import com.iak.belajar.myvideo.restapi.RestAPIInterface;
import com.iak.belajar.myvideo.restapi.RestAPIURL;

import org.greenrobot.eventbus.EventBus;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application {
    private static App instance;
    private static Retrofit retrofit;
    private EventBus eventBus;

    public App() {
        instance = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        createEventBus();
        createRetrofitClient();

    }

    private void createRetrofitClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl(RestAPIURL.getBaseUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public Retrofit getRetrofitClient() {
        return retrofit;
    }

    private void createEventBus() {
        eventBus = EventBus.builder()
                .logNoSubscriberMessages(false)
                .sendNoSubscriberEvent(false)
                .build();
    }

    public static App getInstance() {
        return instance;
    }

    public EventBus getEventBus() {
        return eventBus;
    }

    public RestAPIInterface getApiService() {
        return getRetrofitClient().create(RestAPIInterface.class);
    }
}