package com.iesch.alfanjarin.ivan.a04_practica4_quizzes;

import static com.iesch.alfanjarin.ivan.a04_practica4_quizzes.R.string.correcto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.iesch.alfanjarin.ivan.a04_practica4_quizzes.databinding.ActivityMainBinding;
import com.iesch.alfanjarin.ivan.a04_practica4_quizzes.databinding.ActivityResultBinding;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityResultBinding binding = ActivityResultBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Bundle extras = getIntent().getExtras();

        String pregunta = extras.getString("pregunta");
        binding.preguntaTxt.setText(pregunta);
        int contador = extras.getInt("contador");
        boolean acierto = extras.getBoolean("acierto");
        if (acierto){
            binding.aciertoTxt.setText(correcto);
        }else {
            binding.aciertoTxt.setText(R.string.incorrecto);
        }
        binding.continuarBtn.setOnClickListener(v -> {
            abrirMain(contador);
                });
    }

    private void abrirMain(int contador) {
        Intent irAMain = new Intent(this,MainActivity.class);
        contador++;
        irAMain.putExtra("contador",contador);
        startActivity(irAMain);

    }
}