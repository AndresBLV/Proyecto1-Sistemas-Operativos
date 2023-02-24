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
public class NodoE1<T> {
    ProcesosE1 proceso;
    NodoE1<T> siguiente;

    public NodoE1() {
        this.proceso=proceso;
        this.siguiente = siguiente;
    }


    public ProcesosE1 getproceso() {
        return proceso;
    }

    public void setproceso(ProcesosE1 proceso) {
        this.proceso = proceso;
    }

    public NodoE1<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoE1<T> siguiente) {
        this.siguiente = siguiente;
    }

    
    
    
    
}
