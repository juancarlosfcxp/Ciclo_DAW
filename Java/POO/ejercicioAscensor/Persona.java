package m4.ejercicioAscensor;

/**
 *
 * @author CARLOS FLORES
 * @version 2.0 25-sep-2019
 */
public class Persona {
private String nom;
private int pisoActual;
private int pisoDestino;
private boolean dentro;
private boolean llega;

    public Persona(String nom, int pisoActual, int pisoDestino) {
        this.nom=nom;
        this.pisoActual = pisoActual;
        this.pisoDestino = pisoDestino;
        this.dentro=false;
        this.llega=false;
        
    }

    public int getPisoActual() {
        return pisoActual;
    }

    public int getPisoDestino() {
        return pisoDestino;
    }

    public boolean isDentro() {
        return this.dentro;
    }

    public void setPisoActual(int pisoActual) {
        this.pisoActual = pisoActual;
    }

    public void setSubiendo(boolean dentro) {
        this.dentro = dentro;
    }
    
    public void setLlega(boolean llega) {
        this.llega = llega;
    }

    public boolean isLlega() {
        return llega;
    }

    public String getNom() {
        return nom;
    }


}
