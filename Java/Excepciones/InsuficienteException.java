package m5.Excepciones;

/**
 *
 * @author CARLOS FLORES
 * @version 2.0 26-nov-2019
 */
public class InsuficienteException extends Exception {

    public InsuficienteException() {
        super("ERROR: no arriba a l'alçada mínima de 150\n");
    }
}
