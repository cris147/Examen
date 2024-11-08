/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license/default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examen1p1_cristophersibrian;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author BLINTEC
 */
public class Examen1P1_CristopherSibrian {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner exa = new Scanner(System.in);
        
        int resp;
        do {
            System.out.println("---------------------------");
            System.out.println("1. Decifrar la combinacion");
            System.out.println("2. Rotacion circular de arreglo");
            System.out.println("3. Bono: suma de binarios");
            System.out.println("4. Salir");
            System.out.print("Ingrese una opcion: ");
            resp = exa.nextInt();
            
            switch(resp) {
                case 1: 
                    descifrarCombinacion();
                    break;
                case 2:
                    rotacionCircular();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Ingrese una opcion valida");
            }
        } while (resp != 4);
        System.out.println("Gracias por jugar");
    }
    
    public static void descifrarCombinacion() {
        Scanner des = new Scanner(System.in);
        Random mandy = new Random();
        System.out.println("---------------");
        System.out.println("1) Facil");
        System.out.println("2) Media");            
        System.out.println("3) Dificil");
        System.out.print("Ingrese el nivel de dificultad: ");
        int cmb = des.nextInt();
        
        int inte = 0;
        int tam = 0;
        
        if (cmb == 1) {
            tam = 6;
            inte = 22; 
        } else if (cmb == 2) {
            tam = 8;
            inte = 20;
        } else if (cmb == 3) {
            tam = 10;
            inte = 18;
        } else {
            System.out.println("Opcion no existe");
            return;
        }
        
        char[] comb = crearCombinacion(tam);
        char[] prog = new char[tam];
        for (int i = 0; i < tam; i++) {
            prog[i] = '-';
        }
        
         for (char c : comb) {
                System.out.print(c);
            }
         System.out.println("");
        
        while (inte >0 && !nita(comb, prog)) {
            System.out.println("------------------------------------");
            System.out.print("Progreso actual: ");
            for (char c : prog) {
                System.out.print(c);
            }
            System.out.println("");
            System.out.println("Intentos restantes: " + inte);
            System.out.print("Ingrese una letra: ");
            char intento = des.next().charAt(0);
            prog = sprout(comb, prog, intento);
            inte--;
        }
        
        if (nita(comb, prog)) {
            System.out.println("Bien, pudiste decifrarlo");
        } else {
            System.out.println("La bomba hizo like 911 !BOOM!");
            System.out.print("La combinacion era: ");
            System.out.println("");
            for (char c : comb) {
                System.out.print(c);
            }
            System.out.println("");
        }
    }
    
    public static char[] crearCombinacion(int tam) {
        Random mandy = new Random();
        char[] comb = new char[tam];
        for (int i = 0; i < tam; i++) {
            comb[i] = (char) (mandy.nextInt(26) + 'a');
        }
        return comb;
    }
    
    public static char[] sprout(char[] comb, char[] prog, char intento) {
        for (int i = 0; i < comb.length; i++) {
            if (comb[i] == intento) {
                prog[i] = intento;
            }
        }
        return prog;
    }
    
    public static boolean nita(char[] comb, char[] prog) {
        for (int i = 0; i < comb.length; i++) {
            if (comb[i] != prog[i]) {
                return false;
            }
        }
        return true;
    }
    
    public static void rotacionCircular(){
        Scanner tick = new Scanner(System.in);
        System.out.print("Ingrese el tamano del arreglo: ");
        int juju = tick.nextInt();
        if (juju <= 5){
            System.out.print("El numero debe ser mayor a 5");
            System.out.println("");
            return;
            
        }
        int[] arr = llenar(juju);
        System.out.println("Arreglo original");
        arreglo(arr);
        
        System.out.println("Ingrese la cadena de rotacion (formato i|d:numero)" );
        String entrada = tick.next();
        String[] partes = entrada.split(":");
        char direccion = partes[0].charAt(0);
        int posiciones = Integer.parseInt(partes[1]);
        arr = rotacion(arr, direccion, posiciones);
        
        System.out.println("Arreglo con la rotacion: ");
        arreglo(arr);
    }
    
    public static int[] llenar(int tam){
        Random ejer2 = new Random();
        int[] arr = new int[tam];
        for (int i = 0; i <tam ; i++){
            arr[i] = ejer2.nextInt(100) + 1;
        }
        return arr;
    }
    
    public static int[] rotacion(int[] arr, char direccion, int posiciones){
        int tam = arr.length;
        posiciones %= tam;
        
        if (direccion == 'i'){
            for (int j = 0; j<posiciones; j++){
                int temp = arr[0];
                for (int h = 0; h<tam-1; h++){
                    arr[h] = arr[h+1];
                }
                arr[tam-1] = temp;
            }
        }else if(direccion == 'd'){
            for (int j= 0; j<posiciones;j++){
                int temp = arr[tam-1];
                for (int i = tam-1; i>0; i--){
                    arr[i] = arr[i-1];
                }
                arr[0] = temp;
            }
        }
        return arr;
    }
        
        public static void arreglo(int[] arr){
            for (int num : arr){
                System.out.print(num + " ");
            }
            System.out.println("");
        }
    
}