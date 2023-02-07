package com.example.devilpetsforme;


import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface API {
    @GET("pet/{petId}")
    @POST("pet/{petId}")
    Call<Pets> repoPets(@Path("petId") int id);

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://petstore.swagger.io/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
