package com.example.appfinalmovile.RetroFit;

import com.example.appfinalmovile.RetroFit.Request.RequestReservacion;
import com.example.appfinalmovile.RetroFit.Response.ResponseLocales;
import com.example.appfinalmovile.RetroFit.Response.ResponseReservacion;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ReservacionServicio {

    @GET("reservacion")
    public Call<List<ResponseReservacion>> listarReseservacion();

    @POST("reservacion")
    public Call<ResponseReservacion> reservacion(@Body RequestReservacion requestReservacion);

    @GET("locales")
    public Call<List<ResponseLocales>> listarLocales();

}
