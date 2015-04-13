package com.rezeaul.algo;
public class Fractal {
    public static void main(String args[]){
        drawFractal(32,0);
    }
     
    public static void drawFractal(int length, int space){
        if (length==1){ // the stopping case
            for (int n=0; n<space; n++) System.out.print("  ");
            System.out.println("* ");
        } else {        // length is a power of two
            drawFractal(length/2,space);
            for (int n=0; n<space; n++) System.out.print("  ");
            for (int n=0; n<length; n++) System.out.print("* ");
            System.out.println();
            drawFractal(length/2,length/2+space);
        }
    }
}