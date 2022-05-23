package poly;

import java.lang.String;
import java.lang.reflect.Array;

//Gli oggetti di questa classe sono immutabili;
//Ogni oggetto rappresenta un polinomio di grado n;

//Un oggetto tipico ha questa forma: (c0)x^0+(c1)x^1+(c2)x^2+(c3)x^3+...+(cn)^xn, con n grado complessivo del polinomio;

public class Poly {

    private int[] monomi;
    private int degree;
    

    //costruttori

    //post-con:crea un polinomio inizializzato a 0
    public Poly() {
        monomi= new int[1];
        degree=0;
    }

    //post-con:crea un monomio di coefficiente c e grado n;
    public Poly(int c, int n) throws NegativeExponentException {

        if(n<0) throw new NegativeExponentException();
        monomi = new int[n+1];
        monomi[n]=c;
        degree=n;
    }

     //il prof non ha usato questo metodo anche se e' molto comodo. Probabilmente e' una porcata.
     //edit: non l'ha usato perche' si puo' usare Poly(c,n) con c=0;
    private Poly(int n) {
        monomi= new int[n+1];
        degree=n;
    }



    //metodi osservativi

    //post-con: restituisce il grado massimo del polinomio
    public int degree() {
        return degree;
    }

    //post-con: restituisce il coefficiente del monomio di grado n
    public int coeff(int n) {
        if(n<0 || n>degree) return 0;
        return monomi[n];
    }

    //restuisce il grado massimo dati due polinomi
    private int maxDegree(Poly p, Poly q) {
        if(p.degree()>=q.degree()) return p.degree();
        return q.degree();
    }



    //post-con: restituisce la somma di this con il polinomio q
    public Poly add(Poly q) {

        Poly r = new Poly(0,maxDegree(this,q));
        r.degree=maxDegree(this,q);
       
        
        for (int i=0; i<=maxDegree(this,q); i++) {
            r.monomi[i]=this.coeff(i)+q.coeff(i);
        
        }

        return r;
    }

    //post-con: restituisce la differenza tra this e il polinomio q
    public Poly sub(Poly q) {

        Poly r = new Poly(0,maxDegree(this,q));
        r.degree=maxDegree(this,q);

        for(int i=0; i<=maxDegree(this,q); i++) {
            r.monomi[i]=this.coeff(i)-q.coeff(i);
        }

        return r;
    }
    

    //post-con: restituice il prodotto di this con il polinomio q
    public Poly mul(Poly q) {

       
        int newDegree=this.degree()*q.degree();

        //caso limite: uno degli addendi ha grado 0. A prevalere e' il grado maggiore.
        //es. 3x^4 * 3 = 9x^4
        if( this.degree()==0 || q.degree()==0) {
            newDegree=maxDegree(this,q);
        }

        Poly r= new Poly(newDegree);


        for (int i=this.degree();i>=0; i--) {
            for (int j = q.degree(); j>=0;j--) {
                r.monomi[i+j]=this.coeff(i)*q.coeff(j);
            }
        }

        //caso limite: uno degli addendi e' 0; il risultato e' sempre 0;
        //es. 5x^6 * 0 = 0 ;
        if(q.degree()==0 && monomi[0]==0) {
            r.monomi[0]=0;
            r.degree=0;
        }

        if(this.degree()==0 && monomi[0]==0) {
            r.monomi[0]=0;
            r.degree=0;
        }

        
        return r;

    }

     //il prof non ha usato questo metodo anche se e' molto comodo. Probabilmente e' una porcata
    private Poly(int n) {
        monomi= new int[n+1];
        degree=n;
    }
    
    

    //post-con: restituisce l'opposto del polinomio
    public Poly minus() {

        Poly r= new Poly(this.degree());

        for (int i=0; i<=this.degree(); i++) {
            
            r.monomi[i]=-(this.monomi[i]);
            
        }

        r.degree=this.degree();

        return r;
    }

    //rep-inv: 

    //abs-fun: f(c0,c1,c2,c3,..,cn)= c0+c1x+c2x^2+c3x^3+...+cnx^n

    @Override
    public String toString() {

        String s="";

        if(this.degree()==0 && monomi[0]==0) return "0";

        for(int i=this.degree();i>0;i--) {
            
            if(monomi[i]>0) {s+="+"+Integer.toString(monomi[i])+"x^"+Integer.toString(i);}
            else if(monomi[i]<0) {s+=Integer.toString(monomi[i])+"x^"+Integer.toString(i);}
            //non riporta i monomi nulli
        }
        
        
        if(monomi[0]>0) s+="+"+Integer.toString(monomi[0]);
        if(monomi[0]<0) s+=Integer.toString(monomi[0]);

        return s;
    }
   
}
