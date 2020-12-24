package m5.coleccionDeObjetos;
import java.util.Comparator;
/**
 *
 * @author CARLOS FLORES
 * @version 2.0 03-dic-2019
 */
public class AlfabeticComparator implements Comparator<Piedra> {



    @Override
    public int compare(Piedra p1, Piedra p2) {//El String es Comparable y se sabe comparar
        int resultado = p1.getColor().compareToIgnoreCase(p2.getColor());
        
        if(resultado == 0){//Si son iguales, miramos la siguiente opción, y vamos anidando en caso de que también sean iguales
            resultado = p1.getMaterial().compareToIgnoreCase(p2.getMaterial());
        }
        return resultado;
    }
    
}
