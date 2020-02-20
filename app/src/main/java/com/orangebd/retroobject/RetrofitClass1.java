package com.orangebd.retroobject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClass1 {

    private static final String BASE_URL="http://eksheba.gov.bd/";
    //private static final String BASE_URL="http://admin.service.gov.bd/";
    private static Retrofit retrofit;




    public static Retrofit getRetrofitInstance(){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        if (retrofit == null){

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }

}
