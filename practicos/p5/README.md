# Práctico 5

Fecha de entrega del practico es el 13 de Junio de 2023.

## Objetivo

Se debe programar una aplicación que permita realizar 
un cálculo de un esquema piramidal de ventas
de un extracto medicinal.

Existe un solo producto que es el extracto medicinal,
el costo del mismo es de 15 Bs.

El esquema piramidal de ventas es el siguiente:
* Por cada venta yo gano el 20% del costo del producto.
* Por cada venta de un vendedor que yo reclute directamente,
yo gano el 5% de la venta.
* Por cada venta de un vendedor que reclute mi recluta,
yo gano el 2% de la venta.
* Por cada venta de vendedores que están a 3 o más niveles,
yo gano el 0.5% de la venta.

## Estructura

Cada vendedor tiene la siguiente información:
* Nombre
* una lista de ventas realizadas
* Ganancias acumuladas (calculadas a partir
de las ventas realizadas y las ventas de todo
el subarbol debajo del vendedor)

Cada venta tiene la siguiente información:
* Vendedor
* Cantidad vendida (solo hay un producto)
* Fecha de la venta
* Monto de la venta (calculado a partir de 
la cantidad y del precio del único artículo)

## Funcionalidades

1. El programa debe poder leer el arbol de los
vendedores a partir de un archivo. El formato
del archivo es el siguiente:
```
<nombre1>
<nombre2>
<nombre3>
...
<nombreN>

<nombre1> <nombre2>
<nombre1> <nombre3>
...
<nombre5> <nombreN>
```
Los nombres son unicos y diferentes entre si,
luego viene una línea en blanco y luego
la lista de las relaciones de vendedor y recluta.

2. El programa muestra el arbol en forma gráfica.
3. El programa permite agregar una venta a un vendedor.
4. El programa permite leer la lista de ventas 
desde un archivo. El archivo consiste en x líneas 
donde cada línea tiene el siguiente formato:
```
<nombre>,<cantidad>,<fecha en formato dd.mm.yyyy>
```
5. Desde la forma gráfica, cuando se hace 
clic en algun nodo se despliega la siguiente
información:
   * Nombre del vendedor
   * Ganancias acumuladas
   * Total de ventas realizadas
   * Total de ventas hechas por todo el subarbol

## Archivos adjuntos
En esta misma carpeta se encuentran los siguientes archivos:
* [arbol.txt](arbol.txt): Archivo para el arbol de vendedores.
* [ventas.txt](ventas.txt): Archivo para las ventas.
