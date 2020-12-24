package m5.coleccionDeObjetos;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author CARLOS FLORES
 * @version 2.0 27-nov-2019
 */
public class Piedra implements InterfaceDataAlfabetic, Comparable<Piedra> {
   // private static int cont;
    //private int id;
    private int valor;
    private String color;
    private String material;
    private LocalDate fecha;
    
    public Piedra( int valor, String color, String material, LocalDate fecha) {
        this.valor = valor;
        this.color = color;
        this.material=material;
        this.fecha = fecha;
       // cont++;
       // id = cont;
    }
    
    public int getValor() {
        return valor;
    }

    public String getColor() {
        return color;
    }
    
    public String getMaterial() {
        return material;
    }

    public LocalDate getFecha() {
        return fecha;
    }

      @Override
    public String toString() {
        return "Piedra{" + " valor=" + valor + ", color=" + color + ", material=" + material + ", fecha=" + fecha + '}';
    }

    @Override
    public int compareTo(Piedra t) {
        int aux=0;
        
        if(this.valor > t.getValor()){
            aux = -1;
        }
        else if(this.valor < t.getValor()){
            aux = 1;
        }    
        return aux;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + this.valor;
        hash = 43 * hash + Objects.hashCode(this.color);
        hash = 43 * hash + Objects.hashCode(this.material);
        hash = 43 * hash + Objects.hashCode(this.fecha);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if(this.hashCode()!=obj.hashCode()){
            return this.equals2(obj);
        }else return true;
    }
    
    public boolean equals2(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Piedra other = (Piedra) obj;
        if (this.valor != other.valor) {
            return false;
        }
        if (!Objects.equals(this.color, other.color)) {
            return false;
        }
        if (!Objects.equals(this.material, other.material)) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        return true;
    }

    @Override
    public LocalDate getGenericData() {
        return fecha;
    }

    @Override
    public String getGenericAlfabetic() {
        return color;
    }

    
    
    
}
