package intset;

import java.util.LinkedList;

//questa classe rappresenta oggetti mutabili
//ogni oggetto rappresenta un insieme di interi 
//uno oggetto tipico ha questa forma: {e1,e2,e3,...,en}, in cui n e' la cardinalita' dell'insieme 
//gli elementi dell'insieme occorrono al piu' una volta

public class IntSet {

    private LinkedList<Integer> elems;
    private int length;

    //costruttori

    //post-con: crea un insieme vuoto
    public IntSet() {
        elems=new LinkedList<Integer>();
        length=0;
    }

    //post-con: cre un insieme contentente il solo elemento x
    public IntSet(int x) {
        elems= new LinkedList<Integer>();
        elems.addFirst(x);
        length=1;
    }

    //modificatori

    //modifica: this
    //post-con: inserisce un elemento nell'insieme. Se l'elemento e' gia' nel'insieme non fa nulla. 
    public void insert(int x) {

        if(contains(x)) return;
        elems.add(x);
        length++;
    }

    //modifica: this
    //post-con: rimuove un elemento dall'insieme. Se l'insieme e' vuoto solleva un'eccezione.
    public void remove(int x) throws EmptyException {
        
        if(isEmpty()) throw new EmptyException("Cannot remove from empty set");
        Integer i=x;
        elems.remove(i);
        length--;
    }

    //modifica:this
    //post-con:restituisce l'elemento x E LO RIMUOVE
    public int get(int x) {
        Integer i=x;
        elems.remove(i);
        length--;
        return x;
    }

    //ossertivi
    
    //post-con: restituisce un elemento arbitrario SENZA RIMUOVERLO. Se l'insieme e' vuoto solleva un'eccezione
    public int choose() throws EmptyException  {
        
        if(isEmpty()) throw new EmptyException("Cannot choose from empty set");
        return elems.get(0);

    }

    //post-con: restituisce true se l'insieme e' vuoto, falso altrimenti
    public boolean isEmpty() {
        return length==0;
    }

    //post-con: restituisce true se l'elemento x e' presente nell'insieme, falso altrimenti
    public boolean contains(int x) {
        return elems.contains(x);
    }

    //post-con: restituisce la cardininalita' del'inseme
    public int size() {
        return length;
    }

    


    //abs-fun: f(x1,x2,x2,x3,...,xn) = {x1,x2,x3,...,x(n-1)}, con n-1 cardinalita' dell'insieme

    @Override
    public String toString() {


        String s="{";
        
        for(int i=0; i<length;i++) {
            s+=Integer.toString(elems.get(i))+",";
        }

        return s+"}";
    }


    //rep-inv: la lunghezza e' positiva
    //         gli elementi sono unici

}






    
