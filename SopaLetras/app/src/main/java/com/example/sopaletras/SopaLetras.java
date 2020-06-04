package com.example.sopaletras;

import android.util.Log;

public class SopaLetras {
    private String [][]tablero;
    private String[] capitales = {"MADRID", "PARIS", "ROMA", "LISBOA", "ARGEL", "PRAGA", "DUBLIN", "VIENA"};
    private String [] abecedario = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    private int tamaño = 10;

    public SopaLetras(){
        for(int i = 0; i < tamaño; i++){
            for(int j = 0; j < tamaño; j++){
                this.tablero[i][j] = "0";
                Log.d("tablero", "hola");
            }
        }
    }

}
