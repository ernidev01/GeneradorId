package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("*** Sistema Generador de ID Único ***");

        // Objetos para capturar datos del usuario y generar números aleatorios
        var consola = new Scanner(System.in);
        var aleatorio = new Random();

        // Solicitar el nombre del usuario
        System.out.print("¿Cuál es tu nombre? ");
        var nombre = consola.nextLine();

        // Solicitar el apellido del usuario
        System.out.print("¿Cuál es tu apellido? ");
        var apellido = consola.nextLine();

        // Solicitar el año de nacimiento en formato YYYY
        System.out.print("¿Cuál es tu año de nacimiento (YYYY)? ");
        var anioNacimiento = consola.nextLine();

        // ===== Normalización de datos =====

        // Obtener las dos primeras letras del nombre en mayúsculas
        var nombre2 = nombre.trim().toUpperCase().substring(0, 2);

        // Obtener las dos primeras letras del apellido en mayúsculas
        var apellido2 = apellido.trim().toUpperCase().substring(0, 2);

        // Obtener los dos últimos dígitos del año de nacimiento
        var anioNacimiento2 = anioNacimiento.trim().substring(2);

        // ===== Generación de la parte aleatoria =====

        // Generar un número aleatorio entre 1 y 9999
        var numeroAleatorio = aleatorio.nextInt(9999) + 1;

        // Convertir el número a un formato de 4 dígitos (0001 - 9999)
        var numeroAleatorioFormato = String.format("%04d", numeroAleatorio);

        // ===== Construcción del identificador =====

        // Combinar los datos procesados para formar el ID único
        var idUnico = nombre2 + apellido2 + anioNacimiento2 + numeroAleatorioFormato;

        // Mostrar el resultado al usuario
        System.out.printf("""
                %nHola %s,
                \tTu nuevo número de identificación (ID) generado por el sistema es:
                \t%s
                \t¡Felicidades!
                """, nombre, idUnico);

        // Liberar recursos utilizados por Scanner
        consola.close();
    }
}