package org.alvarowau;

import java.io.*;
import java.net.*;
import java.util.Random;

/**
 * Clase Servidor que actúa como parte del modelo cliente-servidor.
 * Este servidor genera un número secreto aleatorio entre 0 y 100.
 * Los clientes intentan adivinar el número enviando sus conjeturas.
 * El servidor responde indicando si el número enviado es mayor, menor, o igual al número secreto.
 *
 * @author Álvaro Wau
 */
public class Servidor {

    /**
     * Método principal que inicia el servidor.
     * Establece una conexión con un cliente, genera un número secreto y gestiona la comunicación.
     *
     * @param args Argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(2000);
            System.out.println("Esperando conexión del cliente...");

            Socket clienteSocket = serverSocket.accept();
            System.out.println("Conexión establecida con " + clienteSocket.getInetAddress());

            Random random = new Random();
            int numeroSecreto = random.nextInt(101);
            System.out.println("Número secreto generado.");

            BufferedReader entrada = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
            PrintWriter salida = new PrintWriter(clienteSocket.getOutputStream(), true);

            String mensaje;
            while (true) {
                mensaje = entrada.readLine();
                if (mensaje == null) {
                    break;
                }

                try {
                    int numeroCliente = Integer.parseInt(mensaje);

                    if (numeroCliente < numeroSecreto) {
                        salida.println("El número es mayor.");
                    } else if (numeroCliente > numeroSecreto) {
                        salida.println("El número es menor.");
                    } else {
                        salida.println("¡Felicidades! Has adivinado el número secreto.");
                        break;
                    }
                } catch (NumberFormatException e) {
                    salida.println("Por favor ingresa un número válido.");
                }
            }

            clienteSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            System.err.println("Error al iniciar el servidor o comunicarse con el cliente.");
            e.printStackTrace();
        }
    }
}
