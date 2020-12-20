package programacionmodular;

/**
 *
 * @author CARLOS FLORES
 * @version 2.0 22-mar-2019
 */
public class PalindromaRecursiva{

    public static void main(String[] args) {
        
        System.out.println(palindromaRecursiva("arepera",0));
        
    }
 
    public static boolean palindromaRecursiva(String p, int i){
        if( i>p.length()/2){
            return true;
        }
        else if(p.charAt(i)==p.charAt((p.length()-1)-i)){
            return palindromaRecursiva(p,i+1);
        }
        else {return false;}    
    }
}