package com.desafiolatam.desafio;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.desafiolatam.desafio.databinding.FragmentSecondBinding;
public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        // Configurar el botón para volver al primer fragmento
        binding.backButton.setOnClickListener(v -> {
            Navigation.findNavController(v).navigateUp();
        });

        return view;
    }

}