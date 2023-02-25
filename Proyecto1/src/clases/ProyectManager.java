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
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author andre
 */
public class ProyectManager extends Thread{
    
    public boolean stop;
    JLabel countdown;
    Semaphore modCountdown;
    String RM = "El PM esta viendo Rick y Morty";
    String trabajo = "El PM esta revisando sprint reviews";
    String modC = "El PM esta disminuyendo el contador";
    JLabel accion;
    JLabel dias;
    long dia;
    int actual;
    int tipo;
    JLabel episodio;
    JLabel accionPM;
    int ruta=0;
    
    JLabel sueldoIntro;
    JLabel sueldoCreditos;
    JLabel sueldoInicio;
    JLabel sueldoCierre;
    JLabel sueldoPT;
    JLabel sueldoEnsamblador;
    JLabel sueldoPM;
    JLabel sueldoDirector;
    JLabel episodios;
    JLabel gastos;
    JLabel ganacias;
    JLabel neto;
    
    JButton boton1;
    JButton boton2;
    JButton boton3;
    JButton boton4;
    JButton boton5;
    
    public ProyectManager(int tipo,long dia,Semaphore mod,JLabel countdown,JLabel accion){
        this.stop=true;
        this.modCountdown = mod;
        this.countdown = countdown;
        this.accion=accion;
        this.dias=dias;
        this.dia=dia;
        this.actual=Integer.parseInt(countdown.getText())+1;
        this.tipo=tipo;
        
    }
    public ProyectManager(long dia,int tipo,Semaphore mod,JLabel accion,JLabel countdown,JLabel episodio,JLabel accionPM,JLabel saldoPM){
        this.stop=true;
        this.modCountdown = mod;
        this.countdown = countdown;
        this.accion=accion;
        this.dias=dias;
        this.dia=dia;
        this.actual=Integer.parseInt(countdown.getText())+1;
        this.tipo=tipo;
        this.episodio=episodio;
        this.accionPM = accionPM;
        this.sueldoPM = saldoPM;
        
    }
    public ProyectManager(long dia,JLabel count,int tipo){
        this.stop=true;
        this.tipo=tipo;
        this.countdown=count;
        this.dia=dia;
    }
    public ProyectManager(int tipo,JLabel gastoIntro,JLabel gastoCreditos,JLabel gastoInicio,JLabel gastoCierre,JLabel gastoPT, JLabel sueldoPM, JLabel sueldoDirector,JLabel episodio,JLabel gastos,JLabel ganacias,JLabel neto,JLabel countdown,JLabel sueldoEnsamblador,JButton boton1,JButton boton2,JButton boton3,JButton boton4,JButton boton5){
      this.stop = true;
       this.tipo = tipo;
      this.sueldoIntro = gastoIntro;
      this.sueldoCreditos = gastoCreditos;
      this.sueldoInicio = gastoInicio;
      this.sueldoCierre = gastoCierre;
      this.sueldoPT = gastoPT;
      this.sueldoPM = sueldoPM;
      this.sueldoDirector = sueldoDirector;
      this.episodios = episodio;
      this.gastos = gastos;
      this.ganacias = ganacias;
      this.neto = neto;
      this.countdown = countdown;
      this.actual = Integer.parseInt(countdown.getText())+1;
      this.sueldoEnsamblador = sueldoEnsamblador;
      this.boton1 = boton1;
      this.boton2 = boton2;
      this.boton3 = boton3;
      this.boton4 = boton4;
      this.boton5 = boton5;
    }
    
    public void StopToggle(){
        this.stop=!this.stop;
    }
    public void run(){            
        if (tipo==1) {
       try {
           while (this.stop) {   
               if (Integer.parseInt(countdown.getText())!=actual) {       
               modCountdown.acquire();
               accion.setText(modC);
               sleep(dia/10);
               modCountdown.release();
                   if (Integer.parseInt(countdown.getText())==0) {
                       this.StopToggle();
                   }
               actual--;
               }
               accion.setText(RM);
               sleep(dia/72); //revisar esto
               accion.setText(trabajo);
               sleep(dia/72); //revisar esto
               
           }
       } catch (InterruptedException ex) {
           Logger.getLogger(ProyectManager.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
        if (tipo==2) {
            while (Integer.parseInt(countdown.getText())!=0) {                 
                try {
                    sleep(dia);
                    countdown.setText((Integer.toString((Integer.parseInt(countdown.getText()))-1)));
                } catch (InterruptedException ex) {
                    Logger.getLogger(ProyectManager.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            
        }
           if (tipo==3) {
            while (this.stop) {   
                if (ruta <= 0) {
                   if (modCountdown.availablePermits()==0) {
                       while (modCountdown.availablePermits()==0) {   
                           accion.setText("Esperando para leer el cartel");
                       }
                   
                   accion.setText("Leyendo el cartel");
                   long max1=dia*3/2;
                   long min1=dia/2;
                   ruta = (int)(Math.random()*(max1-min1+1)+min1);
                    try {
                        sleep(dia/288);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ProyectManager.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                   try {
                       modCountdown.acquire();
                       if (Integer.parseInt(countdown.getText())==0) {
                           sleep(dia);
                           System.out.println("dia despacho");
                           this.StopToggle();
                           modCountdown.release();
                       }    
                       modCountdown.release();
                   } catch (InterruptedException ex) {
                       Logger.getLogger(ProyectManager.class.getName()).log(Level.SEVERE, null, ex);
                   }
                }
                   

                try {
                   accion.setText("Dando vueltas por el estudio");
                   long max2=dia/16;
                   long min2=dia/48;
                   int tiempo = (int)(Math.random()*(max2-min2+1)+min2);
                   sleep(tiempo);
                   ruta=ruta-tiempo;
                   accion.setText("Revisando al PM");
                    if (accionPM.getText()==RM) {
                        sueldoPM.setText(Integer.toString(Integer.parseInt(sueldoPM.getText())-1));
                    }
                    sleep(dia/288);
                    ruta-=dia/288;
                } catch (InterruptedException ex) {
                    Logger.getLogger(ProyectManager.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        }
           if (tipo==4) {
           while (this.stop) {  
               if (Integer.parseInt(countdown.getText())==0) {
                   try {
                       sleep(dia*2);
                   } catch (InterruptedException ex) {
                       Logger.getLogger(ProyectManager.class.getName()).log(Level.SEVERE, null, ex);
                   }
                       gastos.setText(Integer.toString(Integer.parseInt(sueldoIntro.getText())+Integer.parseInt(sueldoCreditos.getText())+Integer.parseInt(sueldoInicio.getText())+Integer.parseInt(sueldoCierre.getText())+Integer.parseInt(sueldoPT.getText())+Integer.parseInt(sueldoEnsamblador.getText())+Integer.parseInt(sueldoPM.getText())+Integer.parseInt(sueldoDirector.getText())));
                       ganacias.setText(Integer.toString(Integer.parseInt(episodios.getText())*((1100000/150000)*100000)));
                       neto.setText(Integer.toString(Integer.parseInt(ganacias.getText())-Integer.parseInt(gastos.getText())));
                       boton1.setEnabled(true);
                       boton2.setEnabled(true);
                       boton3.setEnabled(true);
                       boton4.setEnabled(true);
                       boton5.setEnabled(true);

                   }
                   gastos.setText(Integer.toString(Integer.parseInt(sueldoIntro.getText())+Integer.parseInt(sueldoCreditos.getText())+Integer.parseInt(sueldoInicio.getText())+Integer.parseInt(sueldoCierre.getText())+Integer.parseInt(sueldoPT.getText())+Integer.parseInt(sueldoEnsamblador.getText())+Integer.parseInt(sueldoPM.getText())+Integer.parseInt(sueldoDirector.getText())));
                   ganacias.setText(Integer.toString(Integer.parseInt(episodios.getText())*((1100000/150000)*100000)));
                   neto.setText(Integer.toString(Integer.parseInt(ganacias.getText())-Integer.parseInt(gastos.getText())));
               
               

       }
    }
    
    }

}
