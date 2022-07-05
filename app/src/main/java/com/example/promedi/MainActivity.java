package com.example.promedi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText Nota1, Nota2, Nota3, Nota4;
    private TextView display1, display2, display3;
    private int nota1, nota2, nota3, nota4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Nota1 = findViewById(R.id.txt1);
        Nota2 = findViewById(R.id.txt2);
        Nota3 = findViewById(R.id.txt3);
        Nota4 = findViewById(R.id.txt4);

        display1 = findViewById(R.id.display1);
        display2 = findViewById(R.id.display2);
        display3 = findViewById(R.id.display3);
    }

    private void getValues(){
        nota1 = Integer.parseInt(Nota1.getText().toString());
        nota2 = Integer.parseInt(Nota2.getText().toString());
        nota3 = Integer.parseInt(Nota3.getText().toString());
        nota4 = Integer.parseInt(Nota4.getText().toString());
    }

    private boolean valid (int val){
        if (val >= 10 && val <= 100){
            return true;
        }else{
            return false;
        }
    }

    @SuppressLint("SetTextI18n")
    public void Promediate(View view){
        getValues();
        if (valid(nota1) && valid(nota2) && valid(nota3) && valid(nota3)){
            double prom = (double) (nota1+nota2+nota3+nota4)/4;

            if(prom > 70){
                display1.setText("Aprobado con " + prom);
                Toast.makeText(this, "Felicidades", Toast.LENGTH_SHORT).show();
            }else{
                display1.setText("Reprobado con " + prom);
                Toast.makeText(this, "Continua estudiando", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Entradas incorrectas", Toast.LENGTH_SHORT).show();
        }
    }

    public void Mayor(View view) {
        getValues();
        if (valid(nota1) && valid(nota2) && valid(nota3) && valid(nota3)) {
            int[] lista = {nota1, nota2, nota3, nota4};
            int may = nota1;
            for (int i = 0; i > lista.length; i++) {
                if (lista[i] > may) {
                    may = lista[i];
                }
            }
            display2.setText(String.valueOf(may));
        } else {
            Toast.makeText(this, "Entradas incorrectas", Toast.LENGTH_SHORT).show();
        }
    }

    public void Menor(View view) {
        getValues();
        if (valid(nota1) && valid(nota2) && valid(nota3) && valid(nota3)) {
            int lista[] = {nota1, nota2, nota3, nota4};
            int min = nota1;
            for (int i = 0; i < lista.length; i++) {
                if (lista[i] < min) {
                    min = lista[i];
                }
            }
            display3.setText(String.valueOf(min));
        } else {
            Toast.makeText(this, "Entradas incorrectas", Toast.LENGTH_SHORT).show();
        }
    }
}