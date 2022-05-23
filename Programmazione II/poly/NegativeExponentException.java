package poly;

import java.lang.Exception;
import java.lang.String;

//la consegna richiede una eccezione non controllata
public class NegativeExponentException extends RuntimeException {

    public NegativeExponentException() {super();}

     public NegativeExponentException(String s) {super(s);}

}
