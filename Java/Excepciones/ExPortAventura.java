package m5.Excepciones;

/**
 *
 * @author CARLOS FLORES
 * @version 2.0 22-nov-2019
 */
public class ExPortAventura {
    public static void main(String[] args) throws InsuficienteException, demasiadoException {
       PuertaDeEntrada p= new PuertaDeEntrada();
       for(int i=0;i<21;i++){
           try{
            p.comprovar();
            }catch(InsuficienteException |demasiadoException e ){
                System.out.println(e.getMessage());
            }
       }
    }

}
