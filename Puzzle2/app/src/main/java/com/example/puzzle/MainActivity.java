package com.example.puzzle;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    final int NUMPUZZLES = 5;
    private int cont1 = 0;
    private int cont2 = 0;
    private int cont3 = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button ficha1 = findViewById(R.id.img1);
        final Button ficha2 = findViewById(R.id.img2);
        final Button ficha3 = findViewById(R.id.img3);
        final Button reiniciar = findViewById(R.id.btnReiniciar);

        cont1 = (int) (Math.random()*NUMPUZZLES+1);
        String img1 = "f"+cont1+"1";
        ficha1.setBackgroundResource(getResources().getIdentifier(img1, "drawable", getPackageName()));

        cont2 = (int) (Math.random()*NUMPUZZLES);
        String img2 = "f"+cont2+"2";
        ficha2.setBackgroundResource(getResources().getIdentifier(img2, "drawable", getPackageName()));

        cont3 = (int) (Math.random()*NUMPUZZLES);
        String img3 = "f"+cont3+"3";
        ficha3.setBackgroundResource(getResources().getIdentifier(img3, "drawable", getPackageName()));

        ficha1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cont1 < NUMPUZZLES - 1) {
                    cont1++;
                } else {
                    cont1 = 1;
                }
                String img1 = "f" + cont1 + "1";
                ficha1.setBackgroundResource(getResources().getIdentifier(img1, "drawable", getPackageName()));

                if (cont1 == cont2 && cont2 == cont3 && cont3 == cont1) {
                    ficha1.setEnabled(false);
                    ficha2.setEnabled(false);
                    ficha3.setEnabled(false);

                    Toast victoria = Toast.makeText(getApplicationContext(), "HAS GANADO", Toast.LENGTH_LONG);
                    victoria.setGravity(Gravity.CENTER|Gravity.CENTER, 0,0);
                    victoria.show();
                }
            }
        });
        ficha2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cont2 < NUMPUZZLES - 1) {
                    cont2++;
                } else {
                    cont2 = 1;
                }
                String img2 = "f" + cont2 + "2";
                ficha2.setBackgroundResource(getResources().getIdentifier(img2, "drawable", getPackageName()));

                if (cont1 == cont2 && cont2 == cont3 && cont3 == cont1) {
                    ficha1.setEnabled(false);
                    ficha2.setEnabled(false);
                    ficha3.setEnabled(false);

                    Toast victoria = Toast.makeText(getApplicationContext(), "HAS GANADO", Toast.LENGTH_LONG);
                    victoria.setGravity(Gravity.CENTER|Gravity.CENTER, 0,0);
                    victoria.show();
                }
            }
        });
        ficha3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cont3 < NUMPUZZLES-1){
                    cont3++;
                }else{
                    cont3 = 1;
                }
                String img3 = "f"+cont3+"3";
                ficha3.setBackgroundResource(getResources().getIdentifier(img3, "drawable", getPackageName()));

                if (cont1 == cont2 && cont2 == cont3 && cont3 == cont1) {
                    ficha1.setEnabled(false);
                    ficha2.setEnabled(false);
                    ficha3.setEnabled(false);

                    Toast victoria = Toast.makeText(getApplicationContext(), "HAS GANADO", Toast.LENGTH_LONG);
                    victoria.setGravity(Gravity.CENTER|Gravity.CENTER, 0,0);
                    victoria.show();
                }
            }
        });
        reiniciar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                overridePendingTransition(0, 0);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                finish();
                overridePendingTransition(0, 0);
                startActivity(intent);
            }
        });
    }


}