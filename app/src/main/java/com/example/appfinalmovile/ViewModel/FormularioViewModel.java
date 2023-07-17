package com.example.appfinalmovile.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.appfinalmovile.RetroFit.Request.RequestReservacion;
import com.example.appfinalmovile.RetroFit.ReservacionCliente;
import com.example.appfinalmovile.RetroFit.Response.ResponseReservacion;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FormularioViewModel extends AndroidViewModel {

    public MutableLiveData<ResponseReservacion> reservacionMutableLiveData
            = new MutableLiveData<>();

    public FormularioViewModel(@NonNull Application application) {
        super(application);
    }
    public void RegistrarFormulario(
            RequestReservacion requestReservacion){
        new ReservacionCliente().getINSTANCE().reservacion(requestReservacion)
                .enqueue(new Callback<ResponseReservacion>() {
                    @Override
                    public void onResponse(Call<ResponseReservacion> call, Response<ResponseReservacion> response) {
                        reservacionMutableLiveData.setValue(response.body());
                    }
                    @Override
                    public void onFailure(Call<ResponseReservacion> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
    }

}
