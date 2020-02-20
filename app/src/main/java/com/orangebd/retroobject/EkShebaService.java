package com.orangebd.retroobject;
import com.google.gson.JsonObject;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface EkShebaService {

    @GET
    Call<JsonObject> getMinistryData(@Url String url);

}