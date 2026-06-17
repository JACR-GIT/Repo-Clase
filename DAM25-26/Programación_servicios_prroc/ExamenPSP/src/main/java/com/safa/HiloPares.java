package com.safa;

public class HiloPares implements Runnable{

    public void run() {
        int sumaPares = 0;
        System.out.println("Numeros Pares:");
        for (int i= 1; i<=10; i++){
            if(i%2==0){
                System.out.println(i+" ");
                sumaPares += i;
            }
        }
        System.out.println("Suma de nuemros pares: "+ sumaPares);
    }
}
