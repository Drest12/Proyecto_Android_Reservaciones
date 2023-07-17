package com.example.appfinalmovile.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.appfinalmovile.RetroFit.ReservacionCliente;

import com.example.appfinalmovile.RetroFit.Response.ResponseReservacion;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReservacionViewModel extends AndroidViewModel {
    public MutableLiveData<List<ResponseReservacion>> listReservacionMutableLiveData
            = new MutableLiveData<>();


    public ReservacionViewModel(@NonNull Application application) {
        super(application);
    }

    public void listarReservacion(){
        new ReservacionCliente().getINSTANCE().listarReseservacion()
                .enqueue(new Callback<List<ResponseReservacion>>() {
                    @Override
                    public void onResponse(Call<List<ResponseReservacion>> call, Response<List<ResponseReservacion>> response) {
                        listReservacionMutableLiveData.setValue(response.body());
                    }
                    @Override
                    public void onFailure(Call<List<ResponseReservacion>> call, Throwable t) {

                    }
                });
    }
}
