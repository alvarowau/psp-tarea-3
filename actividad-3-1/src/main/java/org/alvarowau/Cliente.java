package org.alvarowau;

import java.io.*;
import java.net.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Clase Cliente que se conecta a un servidor en el puerto 2000 para jugar un juego de adivinanza de números.
 * El cliente intenta adivinar el número secreto generado por el servidor enviando conjeturas.
 * Usa un algoritmo básico para ajustar su rango y optimizar los intentos.
 *
 * @author Álvaro Wau
 */
public class Cliente {

    private static int numeroMenor = 0;
    private static int numeroMayor = 100;
    private static int ultimoNumero = -1;

    /**
     * Método principal que establece la conexión con el servidor y gestiona el juego de adivinanza.
     *
     * @param args Argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 2000);

            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);

            String respuesta;
            reset();
            while (true) {
                int numeroCliente = advinadorNumero(null);
                salida.println(numeroCliente);
                System.out.println("Intentando con el número: " + numeroCliente);

                respuesta = entrada.readLine();
                System.out.println("Respuesta del servidor: " + respuesta);

                advinadorNumero(respuesta);

                if ("¡Felicidades! Has adivinado el número secreto.".equals(respuesta)) {
                    break;
                }
            }

            // Cerrar la conexión
            socket.close();
        } catch (IOException e) {
            System.err.println("Error al conectar con el servidor o durante la comunicación.");
            e.printStackTrace();
        }
    }

    /**
     * Ajusta los límites del rango según la respuesta del servidor y genera el siguiente número.
     *
     * @param respuesta Respuesta del servidor indicando si el número es mayor, menor o correcto.
     * @return El número siguiente a intentar adivinar.
     */
    public static int advinadorNumero(String respuesta) {
        if (respuesta != null) {
            switch (respuesta) {
                case "El número es mayor." -> numeroMenor = ultimoNumero + 1;
                case "El número es menor." -> numeroMayor = ultimoNumero - 1;
            }

            if (numeroMenor > numeroMayor) {
                throw new IllegalStateException("Los límites del rango son inválidos.");
            }
        }

        ultimoNumero = ThreadLocalRandom.current().nextInt(numeroMenor, numeroMayor + 1);
        return ultimoNumero;
    }

    /**
     * Reinicia los valores iniciales para los límites del rango y el último número.
     */
    public static void reset() {
        numeroMenor = 0;
        numeroMayor = 100;
        ultimoNumero = -1;
    }
}
