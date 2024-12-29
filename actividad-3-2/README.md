
# Actividad 3.2: Aplicación Cliente/Servidor para Enviar un Fichero

## Descripción

El objetivo de este ejercicio es crear una aplicación cliente/servidor en Java que permita el envío de ficheros al cliente. El cliente se conectará al servidor por el puerto 1500 y le solicitará el nombre de un fichero del servidor. Si el fichero existe, el servidor enviará el fichero al cliente y éste lo mostrará por pantalla. Si el fichero no existe, el servidor enviará un mensaje de error. Una vez que el cliente haya mostrado el fichero, la conexión se finalizará.

### Flujo de Trabajo

1. **Cliente:**
   - Se conecta al servidor en el puerto 1500.
   - Solicita el nombre de un archivo.
   - Si el archivo existe, el cliente lo muestra por pantalla.
   - Si el archivo no existe, el servidor le envía un mensaje de error.

2. **Servidor:**
   - Escucha las conexiones en el puerto 1500.
   - Espera la solicitud del cliente con el nombre del archivo.
   - Si el archivo existe, envía su contenido al cliente.
   - Si el archivo no existe, envía un mensaje de error.

## Estructura del Proyecto

El proyecto consta de dos clases principales:

### 1. Servidor

**Descripción:**
- Escucha las conexiones en el puerto 1500.
- Recibe una solicitud con el nombre de un archivo.
- Si el archivo existe, envía su contenido al cliente.
- Si el archivo no existe, envía un mensaje de error.

**Archivo:**
- `Servidor.java`

### 2. Cliente

**Descripción:**
- Se conecta al servidor en el puerto 1500.
- Solicita un archivo por su nombre.
- Recibe el contenido del archivo o un mensaje de error.
- Muestra el contenido del archivo recibido.

**Archivo:**
- `Cliente.java`

## Instrucciones de Ejecución

### 1. Requisitos Previos

- Java 11 o superior.
- Un IDE como IntelliJ IDEA o Eclipse, o la línea de comandos.

### 2. Ejecución del Servidor

- Navega al directorio del proyecto.
- Compila el archivo del servidor:
  ```bash
  javac org/alvarowau/Servidor.java
  ```
- Ejecuta el servidor:
  ```bash
  java org.alvarowau.Servidor
  ```

### 3. Ejecución del Cliente

- En una nueva terminal, navega al directorio del proyecto.
- Compila el archivo del cliente:
  ```bash
  javac org/alvarowau/Cliente.java
  ```
- Ejecuta el cliente:
  ```bash
  java org.alvarowau.Cliente
  ```

Cuando el cliente se ejecute, te pedirá que introduzcas el nombre del archivo. Puedes probar con el archivo **`texto.txt`** que debe estar en la raíz del servidor. Si el archivo existe, el contenido será mostrado por pantalla; si no, el cliente recibirá un mensaje de error.

## Ejemplo de Ejecución

**Servidor:**
```bash
    Esperando conexión del cliente...
    Conexión establecida con /127.0.0.1
```

**Cliente:**
```bash
    Introduce el nombre del archivo: texto.txt
    Contenido del archivo recibido:
    Este es un archivo de prueba.
    Fin del contenido.
```

Si el archivo no existe:

**Servidor:**
```bash
    El archivo no existe.
```

**Cliente:**
```bash
    Error: El archivo no existe.
```

## Notas

- El archivo de ejemplo que puedes utilizar para la prueba se llama **`texto.txt`**.
- La comunicación se basa en sockets TCP, garantizando una transmisión confiable de los datos entre cliente y servidor.

## Autor

Álvaro Wau
