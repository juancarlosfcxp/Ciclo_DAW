package m4.ejercicioAscensor;

/**
 *
 * @author CARLOS FLORES
 * @version 2.0 25-sep-2019
 */
public class Edificio {
    private int nPisos;
    private Persona[] personas;
    private Ascensor elevator;

    public Edificio(int nPisos, Persona[] personas) {
        this.nPisos = nPisos;
        this.personas = personas;
        this.elevator =  new Ascensor();
    }
    
    public void encenderAscensor() {
        int cont=0;
        while(cont<this.personas.length){
        entrar(this.personas,this.elevator.getPisoSituado());
        if(this.elevator.getPisoSituado()==nPisos){
            elevator.setSubiendo(false);
        }else if(this.elevator.getPisoSituado()==0) {
            elevator.setSubiendo(true);
        }
        this.elevator.setPisoSituado();
        
        cont =salir(this.personas,this.elevator.getPisoSituado(),cont);
        }
    }

    private void entrar(Persona[] personas, int pisoSituado) {
        for(int i=0;i<personas.length;i++){
            if (personas[i].getPisoActual()==pisoSituado && !personas[i].isDentro()){
                System.out.println("Piso: "+pisoSituado+"\nSube "+personas[i].getNom());
                personas[i].setSubiendo(true);
                
            }
        }
    }
        private int  salir(Persona[] personas, int pisoSituado,int cont) {
        for(int i=0;i<personas.length;i++){
            if (personas[i].getPisoDestino()==pisoSituado && personas[i].isDentro() && !personas[i].isLlega()){
                System.out.println("Piso: "+pisoSituado+"\nBaja "+personas[i].getNom());
                cont++;
                personas[i].setLlega(true);
                
            }
        }
        return cont;
        }
        
        public static void main(String[] args) {
        Persona[] gente=new Persona[3];
        gente[0]=new Persona("juan",2,5);
        gente[1]=new Persona("jose",1,4);
        gente[2]=new Persona("jesus",3,1);
        
        Edificio ed1= new Edificio(5,gente);
        
        ed1.encenderAscensor();
    }
}
