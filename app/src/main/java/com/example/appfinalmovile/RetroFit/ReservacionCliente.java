package com.example.appfinalmovile.RetroFit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ReservacionCliente {
    private static final String BASE_URL = "https://api-reservacion-service.herokuapp.com/SERVICE_RESERVACIONES/";

    private ReservacionServicio INSTANCE;

    public ReservacionCliente(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        INSTANCE = retrofit.create(ReservacionServicio.class);
    }

    public ReservacionServicio getINSTANCE(){
        return INSTANCE;
    }
}
