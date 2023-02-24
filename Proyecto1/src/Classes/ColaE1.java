/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author sebas
 */
public class ColaE1<T> {
    NodoE1<T> pfirst;
    NodoE1<T> plast;
   int size;

    public ColaE1() {
        this.pfirst = null;
        this.plast = null;
        this.size = 0;
    }

    public NodoE1<T> getPfirst() {
        return pfirst;
    }

    public void setPfirst(NodoE1<T> pfirst) {
        this.pfirst = pfirst;
    }

    public NodoE1<T> getPlast() {
        return plast;
    }

    public void setPlast(NodoE1<T> plast) {
        this.plast = plast;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    
   
   public boolean esta_vacia(){
       return size==0;
   }
   
   public ProcesosE1 Leer_cabeza(){
       return pfirst.getproceso();
   }
   
   public void Encolar(ProcesosE1 proceso){
       NodoE1 nuevo_nodo= new NodoE1();
       nuevo_nodo.setproceso(proceso);
       
       if (pfirst==null) {
           pfirst=nuevo_nodo;
       }
       else{
           plast.setSiguiente(nuevo_nodo);
       }
       plast= nuevo_nodo;
       size++;
   }
   
   public void Desencolar(){
       pfirst=pfirst.getSiguiente();
       size--;
       if (pfirst==null) {
           plast=null;
       }
       
       
   }
   

}
