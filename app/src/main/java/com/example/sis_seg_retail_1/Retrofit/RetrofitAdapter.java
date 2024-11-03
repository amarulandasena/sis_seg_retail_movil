package com.example.sis_seg_retail_1.Retrofit;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitAdapter {

    private static RetrofitService serv;

    private static final String Base_url = "http://192.168.1.1:3001/";


    public static RetrofitService getService() {

        if(serv == null) {

            Retrofit retro = new Retrofit.Builder()
                    .baseUrl(Base_url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            serv = retro.create(RetrofitService.class);
            return serv;
        }
        return serv;
    }


}
