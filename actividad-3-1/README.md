
# Actividad 3.1: Aplicación Cliente/Servidor para Adivinar un Número

## Descripción

Esta actividad consiste en implementar una aplicación cliente/servidor en Java que se comunica a través del puerto 2000. La funcionalidad principal es la siguiente:

- **Servidor:** Genera un número secreto aleatorio entre 0 y 100 y espera conexiones de los clientes. Responde a cada conjetura del cliente indicando si el número secreto es mayor, menor o si ha sido adivinado correctamente.
- **Cliente:** Intenta adivinar el número secreto generado por el servidor enviando sucesivas conjeturas. Ajusta su rango de posibles números basándose en las respuestas del servidor hasta encontrar el número correcto.

## Estructura del Proyecto

El proyecto está compuesto por dos clases principales:

### 1. Servidor

**Descripción:**

- Genera un número secreto aleatorio al iniciar.
- Escucha conexiones de clientes en el puerto 2000.
- Procesa los números enviados por el cliente y responde:
    - "El número es mayor." si la conjetura del cliente es menor al número secreto.
    - "El número es menor." si la conjetura del cliente es mayor al número secreto.
    - "¡Felicidades! Has adivinado el número secreto." cuando el cliente acierta.

**Archivo:**

- `Servidor.java`

### 2. Cliente

**Descripción:**

- Se conecta al servidor en localhost y el puerto 2000.
- Usa un algoritmo para ajustar el rango de posibles números basado en las respuestas del servidor.
- Envía sucesivamente conjeturas hasta adivinar el número secreto.

**Archivo:**

- `Cliente.java`

## Instrucciones de Ejecución

### 1. Requisitos Previos

- Java 11 o superior (recomendado: Java 21).
- Un IDE como IntelliJ IDEA o Eclipse, o bien ejecutar el programa desde la línea de comandos.

### 2. Ejecución del Servidor

1. Navegar al directorio del proyecto.
2. Compilar el archivo del servidor:

```bash
  javac org/alvarowau/Servidor.java
```

3. Ejecutar el servidor:

```bash
  java org.alvarowau.Servidor
```

### 3. Ejecución del Cliente

1. En una nueva terminal, navegar al directorio del proyecto.
2. Compilar el archivo del cliente:

```bash
  javac org/alvarowau/Cliente.java
```

3. Ejecutar el cliente:

```bash
  java org.alvarowau.Cliente
```

## Ejemplo de Salida

**Servidor:**

```bash
  Esperando conexión del cliente...
  Conexión establecida con /127.0.0.1
  Número secreto generado.
```

**Cliente:**

```bash
    Intentando con el número: 50
    Respuesta del servidor: El número es mayor.
    Intentando con el número: 75
    Respuesta del servidor: El número es menor.
    Intentando con el número: 62
    Respuesta del servidor: ¡Felicidades! Has adivinado el número secreto.
```

## Notas

- La comunicación se basa en sockets TCP, garantizando una transmisión confiable de los datos entre cliente y servidor.
- El cliente usa un algoritmo para ajustar el rango de posibles conjeturas basado en las respuestas del servidor.
- Este ejercicio ilustra los conceptos de programación en red y el uso de sockets en Java.

## Autor

Álvaro Bajo
