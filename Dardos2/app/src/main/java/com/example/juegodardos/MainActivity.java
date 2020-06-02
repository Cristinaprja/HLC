package com.example.juegodardos;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int puntosActuales;
    int puntosAct;
    boolean doble = false;
    boolean triple = false;
    int jugadorActual = 1;
    EditText txtPuntos;
    TextView txtJugador;
    int puntosJug1 = 301;
    int puntosJug2 = 301;
    Button[] botones = new Button[27];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botones[0] = findViewById(R.id.btn1);
        botones[1] = findViewById(R.id.btn2);
        botones[2] = findViewById(R.id.btn3);
        botones[3] = findViewById(R.id.btn4);
        botones[4] = findViewById(R.id.btn5);
        botones[5] = findViewById(R.id.btn6);
        botones[6] = findViewById(R.id.btn7);
        botones[7] = findViewById(R.id.btn8);
        botones[8] = findViewById(R.id.btn9);
        botones[9] = findViewById(R.id.btn10);
        botones[10] = findViewById(R.id.btn11);
        botones[11] = findViewById(R.id.btn12);
        botones[12] = findViewById(R.id.btn13);
        botones[13] = findViewById(R.id.btn14);
        botones[14] = findViewById(R.id.btn15);
        botones[15] = findViewById(R.id.btn16);
        botones[16] = findViewById(R.id.btn17);
        botones[17] = findViewById(R.id.btn18);
        botones[18] = findViewById(R.id.btn19);
        botones[19] = findViewById(R.id.btn20);
        botones[20] = findViewById(R.id.btn25);
        botones[21] = findViewById(R.id.btn50);
        botones[22] = findViewById(R.id.btnDoble);
        botones[22].setOnClickListener(multip);
        botones[23] = findViewById(R.id.btnTriple);
        botones[23].setOnClickListener(multip);
        botones[24] = findViewById(R.id.btnJug1);
        botones[24].setOnClickListener(cambJug);
        botones[25] = findViewById(R.id.btnJug2);
        botones[25].setOnClickListener(cambJug);
        botones[26] = findViewById(R.id.btnReset);
        botones[26].setOnClickListener(reiniciar);

        for(int i=0; i<22; i++){
            botones[i].setOnClickListener(calc);
        }
        txtPuntos = findViewById(R.id.puntos);
        txtPuntos.setEnabled(false);
        txtPuntos.setText(Integer.toString(puntosJug1));
        txtPuntos.setText(Integer.toString(puntosJug2));

        txtJugador = findViewById(R.id.txtJugador);
    }
    private View.OnClickListener calc = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            puntosActuales = Integer.parseInt(txtPuntos.getText().toString());
            int puntos = 0;
            switch (v.getId()){
                case R.id.btn1:
                    puntos = 1;
                    break;
                case R.id.btn2:
                    puntos = 2;
                    break;
                case R.id.btn3:
                    puntos = 3;
                    break;
                case R.id.btn4:
                    puntos = 4;
                    break;
                case R.id.btn5:
                    puntos = 5;
                    break;
                case R.id.btn6:
                    puntos = 6;
                    break;
                case R.id.btn7:
                    puntos = 7;
                    break;
                case R.id.btn8:
                    puntos = 8;
                    break;
                case R.id.btn9:
                    puntos = 9;
                    break;
                case R.id.btn10:
                    puntos = 10;
                    break;
                case R.id.btn11:
                    puntos = 11;
                    break;
                case R.id.btn12:
                    puntos = 12;
                    break;
                case R.id.btn13:
                    puntos = 13;
                    break;
                case R.id.btn14:
                    puntos = 14;
                    break;
                case R.id.btn15:
                    puntos = 15;
                    break;
                case R.id.btn16:
                    puntos = 16;
                    break;
                case R.id.btn17:
                    puntos = 17;
                    break;
                case R.id.btn18:
                    puntos = 18;
                    break;
                case R.id.btn19:
                    puntos = 19;
                    break;
                case R.id.btn20:
                    puntos = 20;
                    break;
                case R.id.btn25:
                    puntos = 25;
                    break;
                case R.id.btn50:
                    puntos = 50;
                    break;
            }
            if(doble){
                puntosAct = puntos * 2;
                botones[22].setBackgroundColor(Color.LTGRAY);
                doble = false;
            }else if(triple){
                puntosAct = puntos * 3;
                triple = false;
                botones[23].setBackgroundColor(Color.LTGRAY);
            }else{
                puntosAct = puntos;
            }
            if(jugadorActual == 1){
                puntosJug1 -=puntosAct;
                txtPuntos.setText(Integer.toString(puntosJug1));
            }
            if(jugadorActual == 2) {
                puntosJug2 -= puntosAct;
                txtPuntos.setText(Integer.toString(puntosJug2));
            }
            if(puntosJug1<0){
                Toast victoria = Toast.makeText(getApplicationContext(), "Jugador 1 ha ganado!!", Toast.LENGTH_LONG);
                victoria.setGravity(Gravity.CENTER|Gravity.CENTER, 0,0);
                victoria.show();
                for(int i=0; i<26; i++){
                    botones[i].setEnabled(false);
                }
            }else if(puntosJug2<0){
                Toast victoria = Toast.makeText(getApplicationContext(), "Jugador 2 ha ganado!!", Toast.LENGTH_LONG);
                victoria.setGravity(Gravity.CENTER|Gravity.CENTER, 0,0);
                victoria.show();
                for(int i=0; i<26; i++){
                    botones[i].setEnabled(false);
                }
            }
        }
    };
    private View.OnClickListener multip = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case (R.id.btnDoble):
                    doble = true;
                    botones[22].setBackgroundColor(Color.RED);
                    break;
                case (R.id.btnTriple):
                    triple = true;
                    botones[23].setBackgroundColor(Color.RED);
                    break;
            }
        }
    };
    private View.OnClickListener cambJug = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case (R.id.btnJug1):
                    jugadorActual = 1;
                    botones[24].setBackgroundColor(Color.BLUE);
                    botones[25].setBackgroundColor(Color.GRAY);
                    txtJugador.setText("Jugador 1");
                    txtPuntos.setText(Integer.toString(puntosJug1));
                    break;
                case (R.id.btnJug2):
                    jugadorActual = 2;
                    botones[25].setBackgroundColor(Color.BLUE);
                    botones[24].setBackgroundColor(Color.GRAY);
                    txtJugador.setText("Jugador 2");
                    txtPuntos.setText(Integer.toString(puntosJug2));
                    break;
            }
        }
    };
    private View.OnClickListener reiniciar = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            puntosJug1 = 301;
            puntosJug2 = 301;
            txtPuntos.setText(Integer.toString(puntosJug1));
            txtPuntos.setText(Integer.toString(puntosJug2));
        }
    };
}
