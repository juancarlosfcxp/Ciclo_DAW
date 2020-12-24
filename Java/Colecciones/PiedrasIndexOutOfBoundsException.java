package m5.coleccionDeObjetos;

/**
 *
 * @author CARLOS FLORES
 * @version 2.0 03-dic-2019
 */
public class PiedrasIndexOutOfBoundsException extends Exception {

    public PiedrasIndexOutOfBoundsException(int nPiedras) {
        super("Error: te has pasado de objetos en la colección. Hay "+ nPiedras);
    }

}
