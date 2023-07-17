package com.example.appfinalmovile.View.Fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.appfinalmovile.RetroFit.Response.ResponseLocales;
import com.example.appfinalmovile.View.adapter.LocalAdapter;
import com.example.appfinalmovile.ViewModel.LocalesViewModel;
import com.example.appfinalmovile.databinding.FragmentPrincipalBinding;

import java.util.List;


public class PrincipalFragment extends Fragment {

    private FragmentPrincipalBinding binding;
    private LocalesViewModel localesViewModel;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        LocalAdapter adapter = new LocalAdapter(getActivity());
        binding = FragmentPrincipalBinding.inflate(inflater, container,
                false);

        localesViewModel = new ViewModelProvider(requireActivity())
                .get(LocalesViewModel.class);
        binding.rvLocales.setLayoutManager(
                new LinearLayoutManager(requireActivity()));
        binding.rvLocales.setAdapter(adapter);
        localesViewModel.listarLocales();
        localesViewModel.listLocalesMutableLiveData.observe(getViewLifecycleOwner(),
                new Observer<List<ResponseLocales>>() {
                    @Override
                    public void onChanged(List<ResponseLocales> responseLocales) {
                        adapter.setLocales(responseLocales);
                    }
                });
        return binding.getRoot();
    }

}