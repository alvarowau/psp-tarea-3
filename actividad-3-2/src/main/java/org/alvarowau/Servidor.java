
package org.alvarowau;

import java.io.*;
import java.net.*;

/**
 * La clase `Servidor` implementa la funcionalidad del servidor en una aplicación cliente/servidor para la transferencia de archivos.
 * Escucha conexiones entrantes en el puerto `1500` y atiende a las solicitudes de los clientes para enviar el contenido de un archivo.
 *
 * @author Álvaro Bajo
 */
public class Servidor {

    /**
     * El punto de entrada principal de la aplicación servidor.
     *
     * @param args argumentos de la línea de comandos
     */
    public static void main(String[] args) {
        try (
                ServerSocket serverSocket = new ServerSocket(1500)
        ) {
            System.out.println("Esperando conexión del cliente...");

            try (
                    Socket socket = serverSocket.accept()
            ) {
                System.out.println("Conexión establecida con " + socket.getInetAddress());

                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                String nombreArchivo = in.readLine();
                File archivo = new File(nombreArchivo);

                if (archivo.exists() && !archivo.isDirectory()) {
                    try (
                            BufferedReader fileReader = new BufferedReader(new FileReader(archivo))
                    ) {
                        String line;
                        while ((line = fileReader.readLine()) != null) {
                            out.println(line);
                        }
                    }
                } else {
                    out.println("Error: El archivo no existe.");
                }
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}