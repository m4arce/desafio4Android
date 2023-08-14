package com.desafiolatam.desafio;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import com.desafiolatam.desafio.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    //prueba de cambios al proyecto DESAFIO 4

    private FragmentHomeBinding binding;

    TextView textView;
    EditText editText;
    Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        //return inflater.inflate(R.layout.fragment_home, container, false);

        textView = binding.textView2;
        editText = binding.password;
        button = binding.button;

        binding.password.addTextChangedListener(password);

        // Configuramos el OnClickListener para el botón
        binding.button.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_homeFragment_to_secondFragment);
        });

        return view;

    }

    // TextWatcher para validar la contraseña en tiempo real
    private TextWatcher password = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void afterTextChanged(Editable editable) {

            boolean isValidPassword = validatePassword(editable.toString());
            binding.button.setEnabled(isValidPassword);
        }

        private boolean validatePassword(String password) {
            // Validamos los criterios (longitud y al menos una letra mayúscula)
            return password.length() > 5 && !password.equals(password.toLowerCase());
        }

    };
}


