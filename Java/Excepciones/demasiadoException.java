package m5.Excepciones;

/**
 *
 * @author CARLOS FLORES
 * @version 2.0 26-nov-2019
 */
public class demasiadoException extends Exception {

    public demasiadoException() {
        super("ERROR: alçada màxima de 190 sobrepassada\n");
    }

}
