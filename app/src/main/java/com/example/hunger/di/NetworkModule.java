package com.example.hunger.di;

import com.example.hunger.api.SpoonacularApi;
import com.example.hunger.util.SpoonacularConstants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


@Module
@InstallIn(ApplicationComponent.class)
public class NetworkModule {

    @Provides
    @Singleton
    public static Retrofit provideRetrofit(){
        return new Retrofit.Builder()
                .baseUrl(SpoonacularConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    public static SpoonacularApi provideSpoonacularApi(Retrofit retrofit){
        return retrofit.create(SpoonacularApi.class);
    }
}
