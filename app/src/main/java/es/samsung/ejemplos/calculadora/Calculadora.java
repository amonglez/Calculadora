package es.samsung.ejemplos.calculadora;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Calculadora extends AppCompatActivity {

    Operacion operacion;
    int valor1, valor2;
    double resultado;
    TextView textViewValor1, textViewValor2, textViewResultado;
    Button suma, resta, multiplicacion, potencia, division, resto;
    Button botonGuardar, botonCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        textViewValor1 = findViewById(R.id.textViewValor1);
        textViewValor2 = findViewById(R.id.textViewValor2);
        textViewResultado = findViewById(R.id.textViewResultado);

        operacion = (Operacion) getIntent().getExtras().getSerializable("Operacion");
        valor1 = operacion.getValor1();
        valor2 = operacion.getValor2();

        textViewValor1.setText(String.valueOf(valor1));
        textViewValor2.setText(String.valueOf(valor2));

        suma = findViewById(R.id.botonSuma);
        resta = findViewById(R.id.botonResta);
        multiplicacion = findViewById(R.id.botonMultiplicacion);
        potencia = findViewById(R.id.botonPotencia);
        division = findViewById(R.id.botonDivision);
        resto = findViewById(R.id.botonResto);

        botonGuardar = findViewById(R.id.botonGuardar);
        botonCancelar = findViewById(R.id.botonCancelar);

        suma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    resultado = operacion.sumar();
                    textViewResultado.setText(String.valueOf(resultado));
                } catch (ArithmeticException ae) {
                    textViewResultado.setText("ERROR");
                }
            }
        });

        resta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    resultado = operacion.restar();
                    textViewResultado.setText(String.valueOf(resultado));
                } catch (ArithmeticException ae) {
                    textViewResultado.setText("ERROR");
                }
            }
        });

        multiplicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    resultado = operacion.multiplicar();
                    textViewResultado.setText(String.valueOf(resultado));
                } catch (ArithmeticException ae) {
                    textViewResultado.setText("ERROR");
                }
            }
        });

        potencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    resultado = operacion.potencia();
                    textViewResultado.setText(String.valueOf(resultado));
                } catch (ArithmeticException ae) {
                    textViewResultado.setText("ERROR");
                }
            }
        });

        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    resultado = operacion.dividir();
                    textViewResultado.setText(String.valueOf(resultado));
                } catch (ArithmeticException ae) {
                    textViewResultado.setText("ERROR");
                }
            }
        });

        resto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    resultado = operacion.resto();
                    textViewResultado.setText(String.valueOf(resultado));
                } catch (ArithmeticException ae) {
                    textViewResultado.setText("ERROR");
                }
            }
        });

        botonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardar(view);
            }
        });

        botonCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancelar(view);
            }
        });
    }

    private void guardar(View view) {
        Intent intent = new Intent ();
        intent.putExtra("Operacion", operacion);

        setResult(RESULT_OK, intent);
        finish();
    }

    private void cancelar(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
