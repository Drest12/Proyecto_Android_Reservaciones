package com.example.appfinalmovile.View.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.appfinalmovile.R;
import com.example.appfinalmovile.RetroFit.Response.ResponseReservacion;
import com.example.appfinalmovile.View.adapter.ReservacionAdapter;
import com.example.appfinalmovile.ViewModel.ReservacionViewModel;
import com.example.appfinalmovile.databinding.FragmentReservacionesBinding;

import java.util.List;


public class ReservacionesFragment extends Fragment {

    private FragmentReservacionesBinding binding;
    private ReservacionViewModel ReservacionViewModel;
    private ReservacionAdapter adapter = new ReservacionAdapter();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentReservacionesBinding.inflate(inflater, container,
                false);
        ReservacionViewModel = new ViewModelProvider(requireActivity())
                .get(ReservacionViewModel.class);
        binding.rvReservaciones.setLayoutManager(
                new LinearLayoutManager(requireActivity()));
        binding.rvReservaciones.setAdapter(adapter);
        ReservacionViewModel.listarReservacion();
        ReservacionViewModel.listReservacionMutableLiveData.observe(getViewLifecycleOwner(),
                new Observer<List<ResponseReservacion>>() {
                    @Override
                    public void onChanged(List<ResponseReservacion> responseReservacions) {
                        adapter.setReservaciones(responseReservacions);
                    }
                });
        return binding.getRoot();
    }


}