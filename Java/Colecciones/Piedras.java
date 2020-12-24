package m5.coleccionDeObjetos;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;
/**
 *
 * @author CARLOS FLORES
 * @version 2.0 27-nov-2019
 */
//0 si son iguales
//>0 si el primero es mayor
//<0 si el primero es menor

public class Piedras implements Iterable<Piedra> {
    
    private final int CAP_INICIAL;
    private ArrayList<Piedra> piedras;
    
    public Piedras(int medidaInicial){
        piedras=new ArrayList<>(medidaInicial);
       this. CAP_INICIAL=medidaInicial;
        
    }

public void printaPiedras(){
    //usar iteerador para mostrar
     for(Piedra p: piedras){
            System.out.println(p);
        }
     
//      Iterator<Piedra> it =piedras.iterator();
//        while(it.hasNext()){
//            System.out.println(it.next());
//        }
  
    }

     public void añadePiedra(Piedra piedra) throws duplicadoException{
         if (piedras.contains(piedra)){
             throw new duplicadoException("ELEMENTO DUPLICADO: "+piedra.toString());
         }
        piedras.add(piedra);
    }
    

    public void ordenaValor(){
        Collections.sort(piedras);
    }
    

    public void ordenaAlfabetico(){
        Collections.sort(piedras, new AlfabeticComparator());
    }
    
    public void ordenaFecha(){
        Collections.sort(piedras, (Piedra p1, Piedra p2) -> p1.getFecha().compareTo(p2.getFecha()) 
        );
    }
   
    
    @Override
    public Iterator<Piedra> iterator() {
        //usar iterator de arrayList
        return piedras.iterator();
        
 //crear un iterator propio
//        return new Iterator<Piedra>(){
//            int index=0;
//            @Override
//            public boolean hasNext() {
//                return piedras.size()>index;
//            }
//
//            @Override
//            public Piedra next() {
//                return piedras.get(index++);
//            }
//            
//        };
    }
    
    public  Iterator<Piedra> iteradorPorValor(double minValor) {
        return new Iterator<Piedra>() {
            int actual=0;
            @Override
            public boolean hasNext() {
                boolean find =false;
                while(actual<piedras.size()&& !find){
                    find=piedras.get(actual).getValor() >= minValor;
                    if(!find){
                        actual++;
                    }
                
            }
            return find;
            }
            @Override
            public Piedra next() {
                return piedras.get(actual++);
            }
        };
                
    }

    
    public static void main(String[] args) throws duplicadoException {
        Piedras vector = new Piedras(10);
        
            vector.añadePiedra(new Piedra(2,"rojo","rubi",LocalDate.of(2012, Month.MARCH, 12)));
            vector.añadePiedra(new Piedra(5,"rojo","rubi",LocalDate.of(2011, Month.APRIL, 12)));
            vector.añadePiedra(new Piedra(4,"verde","rubi",LocalDate.of(2002, Month.MARCH, 12)));
            vector.añadePiedra(new Piedra(6,"rojo","rubi",LocalDate.of(2010, Month.AUGUST, 12)));
            vector.añadePiedra(new Piedra(2,"azul","rubi",LocalDate.of(2010, Month.FEBRUARY, 12)));
            
        
        System.out.println("\nLista de piedras");
        vector.printaPiedras();

        System.out.println("\nOrden por valor");
        vector.ordenaValor();
        vector.printaPiedras();
        //El index of si hace servir el equals para poder comparar el objeto que se pasa por parametro con los objetos dentro de la lista
        System.out.println(vector.piedras.indexOf(new Piedra(2,"azul","rubi",LocalDate.of(2010, Month.FEBRUARY, 12))));
    }

}