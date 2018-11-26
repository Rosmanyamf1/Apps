package com.rafaeldsa.alcoolougasolina;


import android.content.Context;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Usuario user;
    Vibrator v;
    EditText preco;
    double valorResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user = new Usuario();

        preco = (EditText)findViewById(R.id.preco);
        final Button btn = (Button)findViewById(R.id.btn);
        final TextView txtResultado = (TextView)findViewById(R.id.txtResultado);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valorResultado = (Double.parseDouble(preco.getText().toString()) * 0.7);
                String texto = "Abasteça com Álcool se ele custar até: R$ ";
                texto += formataValor(valorResultado);
                txtResultado.setText(texto);

                v = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
                v.vibrate(500);
            }
        });

    }
   
    private String formataValor(double valor) {
        return String.format(Locale.FRANCE,"%.2f",valor);
    }


}

