package com.parra.lfelipe.geometria;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView iFigura;
    private TextView tAviso, tResultados;
    private int selector=1;
    private double area, perimetro, volumen;
    private TextInputLayout tilLongiud;
    private EditText eLongitud;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iFigura = (ImageView) findViewById(R.id.iFigura);
        tAviso = (TextView) findViewById(R.id.tAviso);
        eLongitud = (EditText) findViewById(R.id.eLongitud);
        tResultados = (TextView) findViewById(R.id.tResultados);
        tilLongiud = (TextInputLayout) findViewById(R.id.tilLongitud);
        eLongitud.setFocusable(true);
    }

    public void cambiarFigura(View view) {
        int id = view.getId();
        switch (id){
            case R.id.rCuadrado:
                iFigura.setImageResource(R.drawable.cuadrado);
                tAviso.setText(R.string.aviso2);
                selector=1;
                break;
            case R.id.rCírculo:
                iFigura.setImageResource(R.drawable.circulo);
                tAviso.setText(R.string.aviso4);
                selector=2;
                break;
            case R.id.rTriangulo:
                iFigura.setImageResource(R.drawable.triangulo);
                tAviso.setText(R.string.aviso2);
                selector=3;
                break;
            case R.id.rCubo:
                iFigura.setImageResource(R.drawable.cubo);
                tAviso.setText(R.string.aviso2);
                selector=4;
                break;
        }
    }
    public void calcularGeo(View view) {
        if(!eLongitud.getText().toString().equals("")){
            int x = Integer.parseInt(eLongitud.getText().toString());
            tilLongiud.setError(null);
            switch (selector){
                case 1:
                    area = x*x;
                    perimetro = x*4;
                    tResultados.setText("Cuadrado:\nArea = " + Double.toString(Math.round(area))
                            + "\nPerímetro = " + Double.toString(Math.round(perimetro))
                            +"\nVolumen = No definido" );
                    break;
                case 2:
                    area = Math.PI*Math.pow(x,2);
                    perimetro = Math.PI*2*x;
                    tResultados.setText("Círculo:\nArea = " + Double.toString(Math.round(area))
                            + "\nPerímetro = " + Double.toString(Math.round(perimetro))
                            +"\nVolumen = No definido" );
                    break;
                case 3:
                    area = x*x/2;
                    perimetro = 2*x+Math.sqrt(2)*x;
                    tResultados.setText("Triángulo:\nArea = " + Double.toString(Math.round(area))
                            + "\nPerímetro = " + Double.toString(Math.round(perimetro))
                            +"\nVolumen = No definido" );
                    break;
                case 4:
                    volumen = Math.pow(x,3);
                    tResultados.setText("Cubo:\nArea = No definido"
                            + "\nPerímetro = No definido"
                            +"\nVolumen = " + Double.toString(Math.round(volumen)));
                    break;
            }
        }else{
            Context context = getApplicationContext();
            String text = getResources().getString(R.string.empty);
            String error = getResources().getString(R.string.error);
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            tilLongiud.setError(error);
        }
    }
}
