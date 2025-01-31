
package com.mycompany.matrices;


public class Utilidades {

    // Genera una matriz con números aleatorios
    public static int[][] generarMatriz(int filas, int columnas) {
        int[][] matriz = new int[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = (int) (Math.random() * 90 + 10); // Números entre 10 y 99
            }
        }
        return matriz;
    }

    // Elimina múltiplos de un número
    public static int[][] eliminarMultiplos(int[][] matriz, int numero) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] % numero == 0) {
                    matriz[i][j] = 0;
                }
            }
        }
        return matriz;
    }

    // Elimina números primos
    public static int[][] eliminarPrimos(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (esPrimo(matriz[i][j])) {
                    matriz[i][j] = 0;
                }
            }
        }
        return matriz;
    }

    // Verifica si un número es primo
    private static boolean esPrimo(int numero) {
        if (numero < 2) return false;
        if (numero == 2 || numero == 3) return true;
        if (numero % 2 == 0 || numero % 3 == 0) return false;
        
        for (int i = 5; i * i <= numero; i += 6) {
            if (numero % i == 0 || numero % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    // Convierte una matriz a un String para mostrarla en un JTextArea
    public static String matrizToString(int[][] matriz) {
        StringBuilder sb = new StringBuilder();
        for (int[] fila : matriz) {
            for (int valor : fila) {
                sb.append(valor).append("\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    // Convierte un String de un JTextArea en una matriz
    public static int[][] stringToMatriz(String texto) {
        String[] lineas = texto.trim().split("\n");
        int filas = lineas.length;
        int columnas = lineas[0].trim().split("\t").length;
        int[][] matriz = new int[filas][columnas];

        for (int i = 0; i < filas; i++) {
            String[] valores = lineas[i].trim().split("\t");
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = Integer.parseInt(valores[j].trim());
            }
        }
        return matriz;
    }
}

