package com.example.sis_seg_retail_1.Retrofit;

import com.example.sis_seg_retail_1.Models.DtoLogin;
import com.example.sis_seg_retail_1.Models.DtoRespuestaLogin;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RetrofitService {

    @POST("login")
    Call<DtoRespuestaLogin> login(@Body DtoLogin log);

    @GET("usuario/Usuario")
    Call<DtoRespuestaLogin> Usuario();
}
