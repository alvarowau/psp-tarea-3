package org.alvarowau;

import java.io.*;
import java.net.*;
/**
 * La clase `Cliente` implementa la funcionalidad del cliente en una aplicación cliente/servidor para la transferencia de archivos.
 * Se conecta a un servidor en ejecución en `localhost` y puerto `1500`. El cliente solicita el contenido de un archivo
 * especificado por el usuario y lo muestra en la consola.
 *
 * @author Álvaro Bajo
 */
public class Cliente {

    /**
     * El punto de entrada principal de la aplicación cliente.
     *
     * @param args argumentos de la línea de comandos (no utilizados en este caso)
     */
    public static void main(String[] args) {
        try (
                Socket socket = new Socket("localhost", 1500)
        ) {
            System.out.println("Conectado al servidor");

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Introduce el nombre del archivo: ");
            String nombreArchivo = userInput.readLine();

            out.println(nombreArchivo);

            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}