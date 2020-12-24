package m5.coleccionDeObjetos;

import java.time.LocalDate;
import java.time.Month;
import java.util.Collections;
import java.util.Iterator;

/**
 *
 * @author CARLOS FLORES
 * @version 2.0 03-dic-2019
 */
public class MainPiedras  {
    public static void main(String[] args) throws duplicadoException {
        Piedras vector = new Piedras(10);
        
            vector.añadePiedra(new Piedra(2,"rojo","rubi",LocalDate.of(2012, Month.MARCH, 12)));
            vector.añadePiedra(new Piedra(5,"rojo","rubi",LocalDate.of(2011, Month.APRIL, 12)));
            vector.añadePiedra(new Piedra(4,"verde","rubi",LocalDate.of(2002, Month.MARCH, 12)));
            vector.añadePiedra(new Piedra(6,"rojo","rubi",LocalDate.of(2010, Month.AUGUST, 12)));
            vector.añadePiedra(new Piedra(2,"azul","rubi",LocalDate.of(2010, Month.FEBRUARY, 12)));
            vector.añadePiedra(new Piedra(4,"rojo","rubi",LocalDate.of(2015, Month.AUGUST, 12)));
            vector.añadePiedra(new Piedra(1,"blanco","rubi",LocalDate.of(2013, Month.MARCH, 12)));
            vector.añadePiedra(new Piedra(1,"blanco","rubi",LocalDate.of(2013, Month.MARCH, 12)));
            
//            Piedra p=new Piedra(3,"verde","rubi",LocalDate.of(2011, Month.SEPTEMBER, 12));
//            vector.añadePiedra(p);
//            vector.añadePiedra(p);
            
        
        System.out.println("\nLista de piedras");
        vector.printaPiedras();

        System.out.println("\nOrden por valor");
        vector.ordenaValor();
        vector.printaPiedras();
        
        System.out.println("\nOrden alfabetico");
        vector.ordenaAlfabetico();
        vector.printaPiedras();
        
        System.out.println("\nOrden por fecha");
        vector.ordenaFecha();
        vector.printaPiedras();
        
        System.out.println("\nIterador por valor");
        Iterator<Piedra> it =vector.iteradorPorValor(4);
         while(it.hasNext()){
            System.out.println(it.next());
        }
    }

}
