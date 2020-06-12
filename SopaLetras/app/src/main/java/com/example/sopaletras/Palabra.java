package com.example.sopaletras;
public class Palabra {
    public int coorX, coorY, xInicial, yInicial, direc;
    public String[] palabraArray;
    public static String[] arrayLetras;
    public String palabra;
    private static String[] capitales = {"BERLIN", "DENVER", "NAIROBI", "TOKIO", "MOSCU", "PALERMO", "LISBOA", "MARSELLA"};

    public Palabra(){
        this.palabra = capitales[(int)(Math.random()*7+1)];
        this.palabraArray = this.palabra.split("");
        this.coorX= (int)(Math.random()*9+1);
        this.coorY = (int)(Math.random()*9+1);
        this.xInicial = this.coorX;
        this.yInicial = this.coorY;
        this.direc = (int)(Math.random()*7+1);
    }
    public void calcDirec(int sentido){
        switch (this.direc) {
            case 0:
                this.coorX += 1 * sentido;
                break;
            case 1:
                this.coorY -= 1 * sentido;
                break;
            case 2:
                this.coorX -= 1 * sentido;
                break;
            case 3:
                this.coorY += 1 * sentido;
                break;
            case 4:
                this.coorX += 1 * sentido;
                this.coorY -= 1 * sentido;
                break;
            case 5:
                this.coorX += 1 * sentido;
                this.coorY += 1 * sentido;
                break;
            case 6:
                this.coorX -= 1 * sentido;
                this.coorY -= 1 * sentido;
                break;
            case 7:
                this.coorX -= 1 * sentido;
                this.coorY += 1 * sentido;
                break;
        }
    }
    public void coorIniciales(){
        this.coorX = this.xInicial;
        this.coorY = this.yInicial;
    }
    public static void dividirPalabra(String string){
        arrayLetras = string.split(",");
    }
}