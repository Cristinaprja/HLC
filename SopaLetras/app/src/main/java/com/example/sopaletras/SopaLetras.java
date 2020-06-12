package com.example.sopaletras;
import android.util.Log;
import java.util.ArrayList;
public class SopaLetras {
    private ArrayList<ArrayList<String>> tablero;
    private int tamaño = 10;
    private int xAlmacenada, yAlmacenada;
    public int palabras = 5;

    public ArrayList<Palabra> arrayPalabras = new ArrayList<>();
    private String[] capitales = {"BERLIN", "DENVER", "NAIROBI", "TOKIO", "MOSCU", "PALERMO", "LISBOA", "MARSELLA"};
    public SopaLetras(){
        tablero = new ArrayList<ArrayList<String>>();
        for(int i = 0; i<this.tamaño; i++){
            this.tablero.add(new ArrayList<String>());
            for(int j = 0; j<this.tamaño; j++){
                this.tablero.get(i).add("0");
            }
        }
        generarTablero();
    }

    private void generarTablero(){
        boolean valido;
        int numPal = this.palabras;
        ArrayList<String> repes = new ArrayList<String>();
        do{
            Palabra palabra;
            do{
                valido = true;
                palabra = new Palabra();
                for(String p : repes){
                    if(p == palabra.palabra){
                        valido = false;
                    }
                }
                if(valido){
                    for(int i = 0; i< palabra.palabraArray.length; i++){
                        //Comprobamos que la palabra no se salga del tablero
                        if(palabra.coorX>=tamaño || palabra.coorY>=tamaño || palabra.coorX < 0 || palabra.coorY <0){
                            valido = false;
                        }else if(this.tablero.get(palabra.coorX).get(palabra.coorY) != "0"){
                            if(this.tablero.get(palabra.coorX).get(palabra.coorY) != palabra.palabraArray[i]){
                                valido = false;
                            }
                        }
                        palabra.calcDirec(1);
                    }
                }
            }while(!valido);
            repes.add(palabra.palabra);
            String caracter = "";
            actualizarTablero(palabra, caracter);
            numPal--;
        }while(numPal != 0);
    }

    private void actualizarTablero(Palabra palabra, String caracter){
        //Cambio el valor de las coordenadas de la palabras
        palabra.coorIniciales();
        for(int i = 0; i< palabra.palabraArray.length; i++){
            Log.d("busqueda", "Y: "+palabra.coorX+" X: "+palabra.coorY);
            this.tablero.get(palabra.coorX).set(palabra.coorY, palabra.palabraArray[i]+caracter);
            palabra.calcDirec(1);
        }
        palabra.calcDirec(-1);
        if(caracter!=""){
            this.palabras--;
        }else{
            this.arrayPalabras.add(palabra);
        }
    }

    public void setAlmacenado(int x, int y){
        this.xAlmacenada = x;
        this.yAlmacenada = y;
    }

    public boolean comprobarSeleccion(int x, int y){
        if(x != this.xAlmacenada || y != this.yAlmacenada){
            Palabra palabraCoincidente = new Palabra();
            boolean encontrado = false;
            for(Palabra palabra: this.arrayPalabras){
                if(palabra.xInicial == this.xAlmacenada && palabra.yInicial == this.yAlmacenada){
                    palabraCoincidente = palabra;
                    encontrado = true;
                    Log.d("contador", "Palabra encontrada");
                }
                if(palabra.coorX == this.xAlmacenada && palabra.coorY == this.yAlmacenada){
                    palabraCoincidente = palabra;
                    encontrado = true;
                    Log.d("contador", "Palabra encontrada");

                }
            }
            if(encontrado){
                for(Palabra palabra: this.arrayPalabras){
                    if(palabra.xInicial == x){
                        if(palabra.yInicial == y && palabraCoincidente.palabra == palabra.palabra){
                            String caracter = "*";
                            actualizarTablero(palabra, caracter);
                            return true;
                        }
                    }if(palabra.coorX == x && palabra.coorY == y){
                        if(palabraCoincidente.palabra == palabra.palabra){
                            String caracter = "*";
                            actualizarTablero(palabra, caracter);
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    public ArrayList<ArrayList<String>> getTablero(){
        return this.tablero;
    }
}