package m4.ejercicioAscensor;

/**
 *
 * @author CARLOS FLORES
 * @version 2.0 20-sep-2019
 */
public class Ascensor {
    private int pisoSituado;
    private boolean subiendo;
    private int maxPersonas;
    

    public Ascensor() {
    }

    public int getPisoSituado() {
        return this.pisoSituado;
    }

    public boolean isSubiendo() {
        return subiendo;
    }

    public void setPisoSituado() {
        if (this.subiendo){
        this.pisoSituado = this.pisoSituado+1;
            System.out.println("Subiendo");
        }
        else{
            this.pisoSituado = this.pisoSituado-1;
            System.out.println("Bajando");
        }
    }

    public void setSubiendo(boolean subiendo) {
        this.subiendo = subiendo;
    }

    
    
    
}
