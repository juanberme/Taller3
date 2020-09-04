package com.example.taller3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class resultado extends AppCompatActivity {

    private Button calcular;
    private TextView nombrecito;
    private TextView notas;
    private ConstraintLayout padreResultado;
    float pro1;
    float pro2;
    float qui;
    float par1;
    float par2;
    float ejer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        //referenciar
        calcular = findViewById(R.id.calcular);
        nombrecito = findViewById(R.id.nombrecito);
        notas = findViewById(R.id.notas);
        padreResultado = findViewById(R.id.padreResultado);
        pro1 = Float.parseFloat(getIntent().getExtras().getString("pro1"));
        pro2 = Float.parseFloat(getIntent().getExtras().getString("pro2"));
        qui = Float.parseFloat(getIntent().getExtras().getString("qui"));
        par1 = Float.parseFloat(getIntent().getExtras().getString("par1"));
        par2 = Float.parseFloat(getIntent().getExtras().getString("par2"));
        ejer = Float.parseFloat(getIntent().getExtras().getString("ejer"));
        contar();
        String nombre = getSharedPreferences("nombre", MODE_PRIVATE).getString("usuario", "mrp");
        nombrecito.setText(nombre);

        calcular.setOnClickListener(
                (view) ->{

                    Intent p = new Intent(this, nombrepantalla.class);
                    startActivity(p);
                    finish();
                }
        );
    }
    public void contar(){
        float rPro1 = (float) (pro1 * 0.25);
        float rPro2 = (float) (pro2 * 0.25);
        float rQui = (float) (qui * 0.15);
        float rPar1 = (float) (par1 * 0.15);
        float rPar2 = (float) (par2 * 0.15);
        float rEjer = (float) (ejer * 0.05);
        float suma = rPro1+rPro2+rQui+rPar1+rPar2+rEjer;
        notas.setText("" +suma);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences preferences = getSharedPreferences("fondos", MODE_PRIVATE);
        String color = preferences.getString("color", "noHallo");
        if (color.equals("black")){
            padreResultado.setBackgroundColor(Color.rgb(0,0,0));
        }
        if(color.equals("white")){
            padreResultado.setBackgroundColor(Color.rgb(255,255,255));
        }
        if(color.equals("blue")){
            padreResultado.setBackgroundColor(Color.rgb(0,0,255));
        }
    }
}