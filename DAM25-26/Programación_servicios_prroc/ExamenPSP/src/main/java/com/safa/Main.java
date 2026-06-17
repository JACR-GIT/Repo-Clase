package com.safa;
public class Main {
    public static void main(String[] args) {
        // Crear e iniciar el hilo para imprimir números pares
        Thread hiloPares =new Thread(new HiloPares());
        hiloPares.start();
        System.out.println("Numeros Impares:");
        for (int i= 1; i<=10; i++){
            if(i%2!=0){
                System.out.println(i+" ");
            }
        }
        System.out.println();
    }
}