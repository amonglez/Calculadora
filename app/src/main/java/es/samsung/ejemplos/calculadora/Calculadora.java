package es.samsung.ejemplos.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Calculadora extends AppCompatActivity {

    Operacion operacion;
    int valor1, valor2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        TextView textViewResultado = findViewById(R.id.textViewResultado);
        //textViewResultado.setText(VALOR);

        operacion = (Operacion) getIntent().getExtras().getSerializable("Operacion");
        valor1 = operacion.getValor1();
        valor2 = operacion.getValor2();


    }
}
