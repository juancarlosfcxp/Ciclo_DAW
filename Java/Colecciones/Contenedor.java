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

public class Contenedor<E extends Comparable<E> & InterfaceDataAlfabetic> implements Iterable<E> {
    
    private final int CAP_INICIAL;
    private ArrayList<E> coleccion;
    
    public Contenedor(int medidaInicial){
        coleccion=new ArrayList<>(medidaInicial);
       this. CAP_INICIAL=medidaInicial;
        
    }

public void printaCosas(){
    //usar iteerador para mostrar
     for(E obj: coleccion){
            System.out.println(obj);
        }
     
//      Iterator<Piedra> it =piedras.iterator();
//        while(it.hasNext()){
//            System.out.println(it.next());
//        }
  
    }

     public void añadeCosa(E obj) throws duplicadoException{
         if (coleccion.contains(obj)){
             throw new duplicadoException("ELEMENTO DUPLICADO: "+obj.toString());
         }
        coleccion.add(obj);
    }
    

    public void ordenaValor(){
        Collections.sort(coleccion);
    }
    

    public void ordenaAlfabetico(){
        coleccion.sort((pa,pb)->pa.getGenericAlfabetic().compareTo(pb.getGenericAlfabetic()));
    }
    
    public void ordenaFecha(){
        Collections.sort(coleccion, (E obj1, E obj2) -> obj1.getGenericData().compareTo(obj2.getGenericData()) 
        );
    }
   
    
    @Override
    public Iterator<E> iterator() {
        //usar iterator de arrayList
        return coleccion.iterator();
        
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
    
//    public  Iterator<E> iteradorPorValor(double minValor) {
//        return new Iterator<E>() {
//            int actual=0;
//            @Override
//            public boolean hasNext() {
//                boolean find =false;
//                while(actual<coleccion.size()&& !find){
//                    find=coleccion.get(actual).getValor() >= minValor;
//                    if(!find){
//                        actual++;
//                    }
//                
//            }
//            return find;
//            }
//            @Override
//            public E next() {
//                return coleccion.get(actual++);
//            }
//        };
//                
//    }

}
