/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author andre
 */
public class Nodo<T> {
    
    Object proceso;
    Nodo<T>  siguiente;

    public Nodo() {
        this.proceso=proceso;
        this.siguiente = siguiente;
    }


    public Object getproceso() {
        return proceso;
    }

    public void setproceso(Object proceso) {
        this.proceso = proceso;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

}
