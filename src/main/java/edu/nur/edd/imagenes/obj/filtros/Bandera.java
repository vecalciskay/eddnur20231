package edu.nur.edd.imagenes.obj.filtros;

import edu.nur.edd.imagenes.obj.ComandoFiltro;
import edu.nur.edd.imagenes.obj.Imagen;

public class Bandera extends ComandoFiltro {
    public Bandera(Imagen img) {
        this.imagenBase = img;
    }

    @Override
    public void ejecutar() {
        int ancho = imagenBase.getAncho();
        int alto = imagenBase.getAlto();
        int[][] pixeles = imagenBase.getPixeles();

        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto/3; j++) {
                pixeles[i][j] = 0xFF0000;
            }
            for (int j = alto/3; j < 2*alto/3; j++) {
                pixeles[i][j] = 0xF8F32B;
            }
            for (int j = 2*alto/3; j < alto; j++) {
                pixeles[i][j] = 0x32CD32;
            }
        }
        imagenBase.cambiosImagen();
    }
}
