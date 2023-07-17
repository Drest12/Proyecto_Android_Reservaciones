package com.example.appfinalmovile.ViewModel;



import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;


import com.example.appfinalmovile.RetroFit.ReservacionCliente;
import com.example.appfinalmovile.RetroFit.Response.ResponseLocales;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LocalesViewModel extends AndroidViewModel {
    public MutableLiveData<List<ResponseLocales>> listLocalesMutableLiveData
            = new MutableLiveData<>();


    public LocalesViewModel(@NonNull Application application) {
        super(application);
    }

    public void listarLocales(){
        new ReservacionCliente().getINSTANCE().listarLocales()
                .enqueue(new Callback<List<ResponseLocales>>() {
                    @Override
                    public void onResponse(Call<List<ResponseLocales>> call, Response<List<ResponseLocales>> response) {
                        listLocalesMutableLiveData.setValue(response.body());
                    }
                    @Override
                    public void onFailure(Call<List<ResponseLocales>> call, Throwable t) {

                    }
                });
    }
}



