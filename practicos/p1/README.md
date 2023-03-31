# Práctico 1 - Primeros pasos con observer

## Objetivo
Realizar un programa con interfaz gráfica que demuestre al menos un algoritmo
de ordenamiento de un arreglo de enteros.

## Características obligatorias

* La interfaz debe ser gráfica, con dos menús que tienen las siguientes opciones:
	* Menú Archivo: Opción Reset, Opción Salir
	* Menú Arreglo: Opción Agregar, Opción Eliminar, Opción Azar, Opción Ordenar
* El tamaño de la interfaz gráfica puede ser de 600x400
* El programa debe manejar un modelo (patrón MVC) que es un arreglo de enteros de
  hasta 100 enteros.
* Los enteros se ven gráficamente en la pantalla como barras verticales de ancho 3 o 4 píxeles
una al lado de la siguiente.
* El programa utiliza un factor positivo para poder dibujar la altura de cada barra vertical,
entonces un entero que vale 20 en la pantalla se verá como una barra de 20 x Factor píxeles. Se
puede usar un factor de 5 por ejemplo.
* El programa implementa observer para mostrar cómo está el arreglo en todo momento y
cuando este cambia de alguna manera (por movimiento de los enteros o por agregar uno o por
eliminar uno).
* El programa implementa log4j en todo el código para que se pueda ver lo que pasa por
detrás.

## Funcionalidades

### Reset
Todos los 100 valores del arreglo se colocan en 0 ó -1 para indicar que no hay ningún
valor en ese lugar. El dibujo será una linea horizontal que funciona de base para las
barras verticales. No hay ninguna barra vertical.

### Salir
Sale del programa.

### Agregar
Aparece un popup con un campo para indicar el tamaño de la barra vertical que queremos.
Luego de darle OK, la barra vertical aparece en el dibujo con el tamaño asignado en el 
primer lugar disponible. Es decir, si ya hay 34 barras, entonces la coloca en el lugar 35.

### Eliminar
Elimina la última barra agregada.

### Azar
Esta función crea 100 números al azar y los asigna al arreglo.

### Ordenar
Esta función ejecuta un algoritmo de ordenamiento de complejidad n^2 y muestra en la 
pantalla cómo va cambiando el arreglo, o en su defecto, muestra el resultado final.
Este resultado consiste en el arreglo con las barras verticales ordenadas de menor 
a mayor tamaño.