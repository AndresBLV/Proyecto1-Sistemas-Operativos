/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import static java.lang.Thread.sleep;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
/**
 *
 * @author sebas
 */
public class ProcesosE1 extends Thread{
    
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
    
    public Semaphore sem1;
    public Semaphore sem2;
    public Semaphore sem3;
    public Semaphore sem4;
    public Semaphore sem5;
    
    Semaphore intro;
    Semaphore creditos;
    Semaphore inicio;
    Semaphore cierre;
    Semaphore plottwist;
    
    long dia;
    Semaphore Int;
    Semaphore Cre;
    Semaphore Ini;
    Semaphore Cie;
    Semaphore PT;
    
    boolean procesado = false;
    
    Semaphore colitaE1;
    Semaphore colitaE2;
    Semaphore colitaE3;
    Semaphore colitaE4;
    Semaphore colitaE5;
    
    
    
    // Produccion Intro
    public ProcesosE1(int tipo,JLabel area1,Semaphore sem1, Semaphore intro,long dia,Semaphore Int,JLabel tiempo ){
        this.stop = true;
        this.area1 = area1;
        this.tipo=tipo;
        this.sem1 = sem1;
        this.intro = intro;
        this.dia=dia;
        this.Int = Int;
        this.area13=tiempo;
        
    }
    
    // Produccion Creditos
    public ProcesosE1(int tipo,Semaphore sem2,Semaphore creditos,JLabel area2,long dia,Semaphore Cre,JLabel tiempo ){
        this.stop = true;
        this.area2 = area2;
        this.tipo=tipo;
        this.sem2 = sem2;
        this.creditos = creditos;
        this.dia=dia;
        this.Cre=Cre;
        this.area13=tiempo;
    }
    
    // Produccion Inicio
    public ProcesosE1(int tipo,Semaphore sem3,JLabel area3,Semaphore inicio,long dia,Semaphore Ini,JLabel tiempo ){
       this.stop = true;
       this.area3 = area3;
       this.tipo=tipo;
       this.sem3 = sem3;
       this.inicio = inicio;
       this.dia=dia;
       this.Ini=Ini;
       this.area13=tiempo;
    }
     
    // Produccion Cierre
    public ProcesosE1(JLabel area4,int tipo,Semaphore sem4,Semaphore cierre,long dia,Semaphore Cie,JLabel tiempo ){
       this.stop = true;
       this.area4 = area4;
       this.tipo=tipo;
       this.sem4 = sem4;
       this.cierre = cierre;
       this.dia=dia;
       this.Cie=Cie;
       this.area13=tiempo;
    }
     
    // Produccion Plot Twist
    public ProcesosE1(int tipo,Semaphore sem5,Semaphore plottwist,long dia,Semaphore PT,JLabel tiempo,JLabel areaPT ){
       this.stop = true;
       this.areaPT = areaPT;
       this.tipo=tipo;
       this.sem5 = sem5;
       this.plottwist = plottwist;
       this.dia=dia;
       this.PT=PT;
       this.area13=tiempo;
    }
     
    public ProcesosE1(JLabel intro,JLabel creditos,JLabel inicio,JLabel cierre,JLabel plottwist, JLabel intro1,JLabel creditos2,JLabel inicio3,JLabel cierre4,JLabel plottwist5,JLabel ensamblador6,JLabel t7,int tipo,long dia,JLabel pm8,JLabel director9,JLabel tiempo ){
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
    
    public ProcesosE1(Semaphore mutex5, Semaphore mutex4,Semaphore mutex3,Semaphore mutex2,Semaphore mutex1,long dia,int tipo,Semaphore sem1,Semaphore sem2,Semaphore sem3,Semaphore sem4,Semaphore sem5, JLabel intros,JLabel creditos,JLabel inicios,JLabel cierres,JLabel plottwists,JLabel AreaE,JLabel AreaT,Semaphore intro,Semaphore credito,Semaphore inicio,Semaphore cierre,Semaphore plottwist,JLabel tiempo ){
        this.stop = true;
        this.dia = dia;
        this.tipo =tipo;
        this.sem1 = sem1;
        this.sem2 = sem2;
        this.sem3 = sem3;
        this.sem4 = sem4;
        this.sem5 = sem5;
        this.area1 = inicios;
        this.area2 = creditos;
        this.area3 = inicios;
        this.area4 = cierres;
        this.areaPT = plottwists;
        this.area5 = AreaE;
        this.area6 = AreaT;
        this.intro = intro;
        this.creditos = credito;
        this.inicio = inicio;
        this.cierre = cierre;
        this.plottwist = plottwist;
        this.colitaE1 = mutex1;
        this.colitaE2 = mutex2;
        this.colitaE3 = mutex3;
        this.colitaE4 = mutex4;
        this.colitaE5 = mutex5;
        this.area13=tiempo;
                 
    }
    
    public void StopToggle(){
        this.stop=!this.stop;
    }
    
    @Override
    public void run(){
        if (tipo == 0) {
        while (this.stop) {
            if (Integer.parseInt(area13.getText())==0) {
                this.StopToggle();
            }
        try{
            sleep(dia);
            if (Integer.parseInt(area13.getText())==0) {
                this.StopToggle();
            }
            cuenta();

        }catch(InterruptedException e){
        }
        }
        }
    if (tipo == 1) {
        while (this.stop) {
            if (Integer.parseInt(area13.getText())==0) {
                this.StopToggle();
            }
        try{
            if (procesado != true) {
            sleep(dia/3); //tiempo que le toma producir una intro
            if (Integer.parseInt(area13.getText())==0) {
                this.StopToggle();
            }
            procesado = true;
           cuenta();
            }else{
                cuenta();
            }

        }catch(InterruptedException e){
        }
        }
        }
        if (tipo == 2) {
        while (this.stop) {
            if (Integer.parseInt(area13.getText())==0) {
                this.StopToggle();
            }
        try{
            if (procesado != true) {
            sleep(dia/3); //tiempo que le toma producir unos creditos
            if (Integer.parseInt(area13.getText())==0) {
                this.StopToggle();
            }
            procesado = true;
            cuenta();
            }else{
                cuenta();
            }

        }catch(InterruptedException e){
        }
        }
        }
        if (tipo == 3) {
        while (this.stop) {
            if (Integer.parseInt(area13.getText())==0) {
                this.StopToggle();
            }
        try{
            if (procesado!=true) {
            sleep(dia*4); //tiempo que le toma producir un inicio
            if (Integer.parseInt(area13.getText())==0) {
                this.StopToggle();
            }
            procesado=true;
           cuenta();
            }else{
                cuenta();
            }

        }catch(InterruptedException e){
        }
        }
        }
        if (tipo == 4) {
        while (this.stop) {
            if (Integer.parseInt(area13.getText())==0) {
                this.StopToggle();
            }
        try{
            if (procesado!=true) {
            sleep(dia*3); //tiempo que le toma producir un cierre
            if (Integer.parseInt(area13.getText())==0) {
                this.StopToggle();
            }
            procesado=true;
           cuenta();
            }else{
                cuenta();
            }

        }catch(InterruptedException e){
        }
        }
        }
        if (tipo == 5) {
        while (this.stop) {
            if (Integer.parseInt(area13.getText())==0) {
                this.StopToggle();
            }
        try{
            if (procesado!=true) {
            sleep(dia*3); //tiempo que le toma producir un plot twist 
            if (Integer.parseInt(area13.getText())==0) {
                this.StopToggle();
            }
            procesado = true;
           cuenta();
            }else{
                cuenta();
            }

        }catch(InterruptedException e){
        }
        }
        }
        if (tipo == 6) {
        while (this.stop) {
            if (Integer.parseInt(area13.getText())==0) {
                this.StopToggle();
            }
        try{
            if (procesado!=true) {
            sleep(dia*2); //tiempo que le toma producir un cap al ensamblador
            if (Integer.parseInt(area13.getText())==0) {
                this.StopToggle();
            }
            procesado = true;
           cuenta();
            }else{
                cuenta();
            }

        }catch(InterruptedException e){
        }
        }
        }
    }
    
    synchronized void cuenta() throws InterruptedException{
        if (tipo==0) {
            area5.setText(Integer.toString((Integer.parseInt(area1.getText())*3)+Integer.parseInt(area5.getText())));
            area6.setText(Integer.toString((Integer.parseInt(area2.getText())*4)+Integer.parseInt(area6.getText())));
            area7.setText(Integer.toString((Integer.parseInt(area3.getText())*5)+Integer.parseInt(area7.getText())));
            area8.setText(Integer.toString((Integer.parseInt(area4.getText())*5)+Integer.parseInt(area8.getText())));
            area10.setText(Integer.toString((Integer.parseInt(area9.getText())*6)+Integer.parseInt(area10.getText())));
            area11.setText(Integer.toString(Integer.parseInt(area11.getText())+168));
            area12.setText(Integer.toString(Integer.parseInt(area12.getText())+180));
        try {
            sleep(10);
        } catch (Exception e) {
        }
        }
        if (tipo==1) {
            Int.acquire();
             if (intro.availablePermits() !=0) { 
            sem1.acquire();
            intro.acquire();
            area1.setText(Integer.toString(Integer.parseInt(area1.getText())+1));
            sem1.release();
            procesado = false;
            Int.release();
             }else{
                 wait(1500);
                 Int.release();
             }
        try {
            sleep(10);
        } catch (Exception e) {
        }
        }if (tipo==2) {
            Cre.acquire();
            if (creditos.availablePermits() !=0) {                     
            sem2.acquire();
            creditos.acquire();
            area2.setText(Integer.toString(Integer.parseInt(area2.getText())+1));
            sem2.release();
             procesado = false;
            Cre.release();
            }else{
                wait(1500);
                Cre.release();
            }
        try {
            sleep(10);
        } catch (Exception e) {
        }
        }if (tipo==3) {
            Ini.acquire();
            if (inicio.availablePermits() !=0) {                        
            sem3.acquire();
            inicio.acquire();
            area3.setText(Integer.toString(Integer.parseInt(area3.getText())+1));
            sem3.release();
             procesado = false;
            Ini.release();
            }else{
                wait(1500);
                Ini.release();
            }
        try {
            sleep(10);
        } catch (Exception e) {
        }
       
        }
        if (tipo==4) {
            Cie.acquire();
            if (cierre.availablePermits() !=0) {                     
            sem4.acquire();
            cierre.acquire();
            area4.setText(Integer.toString(Integer.parseInt(area4.getText())+1));
            sem4.release();
             procesado = false;
             Cie.release();
            }else{
                wait(1500);
                Cie.release();

            }
        try {
            sleep(10);
        } catch (Exception e) {
        }
        }
        if (tipo==5) {
            PT.acquire();
            if (plottwist.availablePermits() !=0) {                     
            sem5.acquire();
            plottwist.acquire();
            areaPT.setText(Integer.toString(Integer.parseInt(areaPT.getText())+1));
            sem5.release();
             procesado = false;
             PT.release();
            }else{
                wait(1500);
                PT.release();

            }
        try {
            sleep(10);
        } catch (Exception e) {
        }
        }
        if (tipo==6) {
            try {
                ArchivoCSV archiCsv = new ArchivoCSV();
                String capacidadIntro = archiCsv.leerCsvParametrosPorDefectoCapacidadIntroE1();
                colitaE1.acquire();
                while (intro.availablePermits() > Integer.parseInt(capacidadIntro)-1) {    //<--intro necesaria para ensamblar el cap                 
                }
                sem1.acquire();
                intro.release(1);
                area1.setText(Integer.toString(Integer.parseInt(area1.getText())-1));
                sem1.release();
                colitaE1.release();
                colitaE2.acquire();
                String capacidadCreditos = archiCsv.leerCsvParametrosPorDefectoCapacidadCreditosE1();
                while (creditos.availablePermits()>Integer.parseInt(capacidadCreditos)-1) { //<--creditos necesarios para ensamblar el cap                      
                }
                sem2.acquire();
                creditos.release(1);
                area2.setText(Integer.toString(Integer.parseInt(area2.getText())-1));
                sem2.release();
                colitaE2.release();
                colitaE3.acquire();
                String capacidadInicio = archiCsv.leerCsvParametrosPorDefectoCapacidadInicioE1();
                while (inicio.availablePermits()>Integer.parseInt(capacidadInicio)-2) {  //<--inicios necesarios para ensamblar el cap
                }
                sem3.acquire();
                inicio.release(2);
                area3.setText(Integer.toString(Integer.parseInt(area3.getText())-2));
                sem3.release();
                colitaE3.release();
                colitaE4.acquire();
                String capacidadCierre = archiCsv.leerCsvParametrosPorDefectoCapacidadCierreE1();
                while (cierre.availablePermits()>Integer.parseInt(capacidadCierre)-2) {  //<-- cierres necesarios para ensamblar el cap                      
                }
                sem4.acquire();
                cierre.release(2);
                area4.setText(Integer.toString(Integer.parseInt(area4.getText())-2));
                sem4.release();
                colitaE4.release();
                colitaE5.acquire();
                String capacidadPlotTwist = archiCsv.leerCsvParametrosPorDefectoCapacidadPlotTwistE1();
                while (intro.availablePermits() > Integer.parseInt(capacidadPlotTwist)-2) { //<-- plot twists necesarios para ensamblar el cap                    
                }
                sem5.acquire();
                plottwist.release(2);
                areaPT.setText(Integer.toString(Integer.parseInt(areaPT.getText())-2));
                sem5.release();
                colitaE5.release();
                area6.setText(Integer.toString(Integer.parseInt(area6.getText())+1));
                procesado=false;
                
                
          
            
             } catch (InterruptedException ex) {
         Logger.getLogger(ProcesosE1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    
    }

    void setText(String toString) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
