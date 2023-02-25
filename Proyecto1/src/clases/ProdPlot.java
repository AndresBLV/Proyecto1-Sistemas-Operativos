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
public class ProdPlot extends Thread{

    public boolean stop;
    String Treadname;
    int tipo;
    JLabel area1;
    Semaphore sem5;
    Semaphore plottwist;
    long dia;
    Semaphore PT;
    JLabel area13;
    JLabel areaPT;


    public ProdPlot(int tipo,Semaphore sem5,Semaphore plottwist,long dia,Semaphore PT,JLabel tiempo,JLabel areaPT ){
       this.stop = true;
       this.areaPT = areaPT;
       this.tipo=tipo;
       this.sem5 = sem5;
       this.plottwist = plottwist;
       this.dia=dia;
       this.PT=PT;
       this.area13=tiempo;
    }

}
