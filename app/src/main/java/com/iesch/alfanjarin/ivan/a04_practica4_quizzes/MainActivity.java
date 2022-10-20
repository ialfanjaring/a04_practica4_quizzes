package com.iesch.alfanjarin.ivan.a04_practica4_quizzes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.iesch.alfanjarin.ivan.a04_practica4_quizzes.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        int contador = 1;
        //setContentView(R.layout.activity_main);
        setContentView(binding.getRoot());
        binding.responderBtn.setOnClickListener(v -> {
            String pregunta = binding.preguntaTxt.getText().toString();
            int opcion = binding.radioGroup.getCheckedRadioButtonId();

            abrirResultado(pregunta, opcion, contador);
        });
    }

    private void abrirResultado(String pregunta, int opcion, int contador) {
        Intent irADetalle = new Intent(this,ResultActivity.class);
        irADetalle.putExtra("pregunta",pregunta);
        irADetalle.putExtra("opcion",opcion);
        irADetalle.putExtra("contador",contador);
        startActivity(irADetalle);
    }
}