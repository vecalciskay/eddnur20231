package edu.nur.edd.imagenes.obj;

/**
 * Filtros practico 2:
 * <ol>
 *     <li>Flip Horizontal</li>
 *     <li>Flip Vertical</li>
 *     <li>Floyd Steinberg</li>
 *     <li>Tonos de gris</li>
 *     <li>Tonos rojos</li>
 *     <li>Tonos verdes</li>
 *     <li>Tonos azules</li>
 *     <li>Ruido sal y pimienta</li>
 * </ol>
 */
public abstract class ComandoFiltro {
    protected Imagen imagenBase;

    /**
     * Metodo del patron de diseno Command para
     * ejecutar los comandos de filtro sobre una
     * imagen.
     * Cada filtro debe <b>implementar</b> este metodo, por eso
     * es que este está abstracto
     */
    public abstract void ejecutar();
}
