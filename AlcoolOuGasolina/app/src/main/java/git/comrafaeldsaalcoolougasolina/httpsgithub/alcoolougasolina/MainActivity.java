package git.comrafaeldsaalcoolougasolina.httpsgithub.alcoolougasolina;

import android.content.Context;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    int valorGasolina = 0;
    Vibrator v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Carregando a seekbar e o valor da gasolina.
        final SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar2);
        final TextView txtGasolina = (TextView) findViewById(R.id.txtValorGasolina);
        final Button btn = (Button)findViewById(R.id.btn);
        final TextView txtResultado = (TextView)findViewById(R.id.txtResultado);
        //Tamanho da Seekbar
        seekBar.setMax(1000);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                valorGasolina = progress;
                String texto = "R$ ";
                texto += formataValor(valorGasolina/100.0);
                txtGasolina.setText(texto);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                    txtResultado.setText("Clique em calcular para saber o Resultado!");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double valorResultado = (valorGasolina * 0.7) / 100.0;
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