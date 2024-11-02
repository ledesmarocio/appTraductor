package com.example.apptraductor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.apptraductor.databinding.ActivitySegundaBinding;

public class SegundaActivity extends AppCompatActivity {
private ActivitySegundaBinding binding;
private TraductorViewModel traductorViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding=ActivitySegundaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        traductorViewModel= new ViewModelProvider(this).get(TraductorViewModel.class);
        String palEspanol= getIntent().getStringExtra("PalabraEsp");

        if(palEspanol!=null){
            traductorViewModel.traducirPalabra(palEspanol);
        }
        traductorViewModel.getPalabraTraducida().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String palabraTraducida) {
                binding.etEnglish.setText(palabraTraducida);
            }
        });
        traductorViewModel.getImagen().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer imagen) {
                binding.ivImage.setImageResource(imagen);
            }
        });
    binding.btBack.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent= new Intent(SegundaActivity.this, MainActivity.class);
            startActivity(intent);
        }
    });
    }
}