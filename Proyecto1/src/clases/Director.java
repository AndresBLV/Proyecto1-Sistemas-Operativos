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
public class Director extends Thread{
    public boolean stop;
    String Treadname;
    int tipo;
    
    JLabel area1;
    JLabel area2;
    JLabel area3;
    JLabel area4;
    JLabel areaPT;
    JLabel area5;
    JLabel area6;
    JLabel area7;
    JLabel area8;
    JLabel area9;
    JLabel area10;
    JLabel area11;
    JLabel area12;
    JLabel area13;
    long dia;

    public Director(JLabel intro,JLabel creditos,JLabel inicio,JLabel cierre,JLabel plottwist, JLabel intro1,JLabel creditos2,JLabel inicio3,JLabel cierre4,JLabel plottwist5,JLabel ensamblador6,JLabel t7,int tipo,long dia,JLabel pm8,JLabel director9,JLabel tiempo ){
        this.stop = true;
        this.area1 = intro;
        this.area2 = creditos;
        this.area3 = inicio;
        this.area4 = cierre;
        this.areaPT = plottwist;
        this.area5 = intro1;
        this.area6 = creditos2;
        this.area7= inicio3;
        this.area8 = cierre4;
        this.area9 = ensamblador6;
        this.area10 = t7;
        this.tipo = tipo;
        this.dia = dia;
        this.area11 = pm8;
        this.area12=director9;
        this.area13=tiempo;
    }
}
