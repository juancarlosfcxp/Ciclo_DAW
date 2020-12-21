package m5.Excepciones;


/**
 *
 * @author CARLOS FLORES
 * @version 2.0 22-nov-2019
 */
public class PuertaDeEntrada {
    
       Sensor s=new Sensor();
    
    public void comprovar() throws InsuficienteException, demasiadoException{
        int altura= this.s.ObtenerAltura();
         System.out.println("SENSOR: Alçada llegida = "+altura);
        if( altura<150){
        throw new InsuficienteException();
        }else if( altura>190){
        throw new demasiadoException();
        }else{
            System.out.println("Obrint la porta a l'alçada"+altura+" cms\n");

        }
    }

}
