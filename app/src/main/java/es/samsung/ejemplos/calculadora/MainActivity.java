package es.samsung.ejemplos.calculadora;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editTextNumero1, editTextNumero2;
    TextView textViewResultadoFinal;
    Button aceptar;
    Operacion operacion;
    String resultadoFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNumero1 = findViewById(R.id.editTextNumero1);
        editTextNumero2 = findViewById(R.id.editTextNumero2);
        textViewResultadoFinal = findViewById(R.id.textViewResultadoFinal);
        aceptar = findViewById(R.id.botonAceptar);

        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviarValor(view);
            }
        });
    }

    public void enviarValor(View view) {
        Intent intent = new Intent(this, Calculadora.class);
        operacion = new Operacion();
        operacion.setValor1(Integer.valueOf(editTextNumero1.getText().toString()));
        operacion.setValor2(Integer.valueOf(editTextNumero2.getText().toString()));

        intent.putExtra("Operacion", operacion);
        startActivityForResult(intent, 12);
    }

    protected void onActivityResult(int resultado, int codigo, Intent data) {
        if (resultado == 12 && codigo == RESULT_OK) {
            operacion = (Operacion) getIntent().getExtras().getSerializable("Operacion");
            resultadoFinal = String.valueOf(operacion.getResultado());
            textViewResultadoFinal.setText(resultadoFinal);
        }
    }
}