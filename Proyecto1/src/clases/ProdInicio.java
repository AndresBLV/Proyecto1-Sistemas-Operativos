/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;
import static java.lang.Thread.sleep;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author andre
 */
public class ProdInicio extends Thread{
    
    public boolean stop;
    String Treadname;
    int tipo;
    JLabel area3;
    Semaphore sem3;
    Semaphore inicio;
    long dia;
    Semaphore Ini;
    JLabel area13;

    public ProdInicio(int tipo,Semaphore sem3,JLabel area3,Semaphore inicio,long dia,Semaphore Ini,JLabel tiempo) {

       this.stop = true;
       this.area3 = area3;
       this.tipo=tipo;
       this.sem3 = sem3;
       this.inicio = inicio;
       this.dia=dia;
       this.Ini=Ini;
       this.area13=tiempo;
    }
         
}
