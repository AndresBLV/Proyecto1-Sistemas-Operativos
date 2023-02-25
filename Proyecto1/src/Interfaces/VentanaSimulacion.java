/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.util.concurrent.Semaphore;
import Classes.*;
import clases.*;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


/**
 *
 * @author andre
 */
public class VentanaSimulacion extends javax.swing.JFrame {
    // Estudio 2
    String cadenaE2 = "";
    int diasE2;
    long diaE2 = 0;
    public static int totalE =13;
    public static int count =0;
    
    Cola colaLibreIntroE2 = new Cola();
    Cola colaOcupadoIntroE2 = new Cola();
    Cola colaLibreCreditosE2 = new Cola();
    Cola colaOcupadoCreditosE2 = new Cola();
    Cola colaLibreInicioE2 = new Cola();
    Cola colaOcupadoInicioE2 = new Cola();
    Cola colaLibreCierreE2 = new Cola();
    Cola colaOcupadoCierreE2 = new Cola();
    Cola colaLibrePlotTwistE2 = new Cola();
    Cola colaOcupadoPlotTwistE2 = new Cola();
    Cola colaEnsambladoresLibresE2 = new Cola(); 
    Cola colaEnsambladoresOcupadosE2 = new Cola();
    
    Semaphore sem1E2 = new Semaphore(1);
    Semaphore sem2E2 = new Semaphore(1);
    Semaphore sem3E2 = new Semaphore(1);
    Semaphore sem4E2 = new Semaphore(1);
    Semaphore sem5E2 = new Semaphore(1);
    
    Semaphore mutex1E2 = new Semaphore(1);
    Semaphore mutex2E2 = new Semaphore(1);
    Semaphore mutex3E2 = new Semaphore(1);
    Semaphore mutex4E2 = new Semaphore(1);
    Semaphore mutex5E2 = new Semaphore(1);
    
    Semaphore capacidadIntroE2;
    Semaphore capacidadCreditosE2;
    Semaphore capacidadInicioE2;
    Semaphore capacidadCierreE2;
    Semaphore capacidadPlotTwistE2;
    
    Semaphore introE2 = new Semaphore(1);
    Semaphore creditosE2= new Semaphore(1);
    Semaphore inicioE2= new Semaphore(1);
    Semaphore cierreE2= new Semaphore(1);
    Semaphore plottwistE2= new Semaphore(1);
    
    Semaphore modCountdownE2 = new Semaphore(1);
    Thread total2;
    
    // Historico
    String[] historicoLanzamientosE2 = new String[7]; 
    
    public void agregarE2(int tipo,Cola libre,Cola ocupada,JLabel trabajador){
        if (totalE!=0) {
            // Produtor Intro
            if (tipo==1) {
                ProdIntro hiloIntro = new ProdIntro(tipo, capacidadIntE2, sem1E2, capacidadIntroE2, diaE2, introE2,countdownE2);
                ocupada.Encolar(hiloIntro);
                hiloIntro.start();
            }
            // Produtor Creditos
            if (tipo==2) {
                ProdCre hiloCreditos = new ProdCre(tipo, sem2E2, capacidadCreditosE2, capacidadCreE2, diaE2, creditosE2,countdownE2);
                ocupada.Encolar(hiloCreditos);
                hiloCreditos.start();
            }
            // Produtor Inicio
            if (tipo==3) {
                ProdInicio hiloInicio = new ProdInicio(tipo, sem3E2, capacidadIniE2, capacidadInicioE2, diaE2, inicioE2,countdownE2);
                ocupada.Encolar(hiloInicio);
                hiloInicio.start();
            }
            // Produtor Cierre
            if (tipo==4) {
                ProdCierre hiloCierre = new ProdCierre(capacidadCieE2, tipo, sem4E2, capacidadCierreE2, diaE2, cierreE2,countdownE2);
                ocupada.Encolar(hiloCierre);
                hiloCierre.start();
            }
            // Produtor PlotTwist
            if (tipo==5) {
                ProdPlot hiloPlotTwist = new ProdPlot(tipo,sem5E2,capacidadPlotTwistE2,diaE2,plottwistE2,countdownE2,capacidadPTE2);
                ocupada.Encolar(hiloPlotTwist);
                hiloPlotTwist.start();
            }
            // Ensamblador
            if (tipo==6) {
                Ensamblador hiloEnsamblador = new Ensamblador(mutex5E2, mutex4E2, mutex3E2, mutex2E2, mutex1E2, diaE2, tipo, sem1E2, sem2E2, sem3E2, sem4E2, sem5E2, capacidadIntE2, capacidadCreE2, capacidadIniE2, capacidadCieE2, capacidadPTE2, ensambladoresE2, episodiosProducidosE2, capacidadIntroE2, capacidadCreditosE2, capacidadInicioE2, capacidadCierreE2, capacidadPlotTwistE2, countdownE2);
                ocupada.Encolar(hiloEnsamblador);
                hiloEnsamblador.start();
            };
        }
    }
    
    public void quitarE2(int tipo,Cola ocupado,Cola libre,JLabel trabajadores,Semaphore mutexQuitar,Semaphore semQuitar){
        if (ocupado.getSize() > 1) {
        if ( !ocupado.esta_vacia()) {
            switch (tipo){
                case 1:{
                ProdIntro siguiente = (ProdIntro) ocupado.getPfirst().getproceso();
                ocupado.Desencolar();
                libre.Encolar(siguiente);
                mutexQuitar.release();
                semQuitar.release();
                siguiente.suspend();
                }
                case 2:{
                ProdCre siguiente = (ProdCre) ocupado.getPfirst().getproceso();
                ocupado.Desencolar();
                libre.Encolar(siguiente);
                mutexQuitar.release();
                semQuitar.release();
                siguiente.suspend();
                }
                case 3:{
                ProdInicio siguiente = (ProdInicio) ocupado.getPfirst().getproceso();
                ocupado.Desencolar();
                libre.Encolar(siguiente);
                mutexQuitar.release();
                semQuitar.release();
                siguiente.suspend();
                }
                case 4:{
                ProdCierre siguiente = (ProdCierre) ocupado.getPfirst().getproceso();
                ocupado.Desencolar();
                libre.Encolar(siguiente);
                mutexQuitar.release();
                semQuitar.release();
                siguiente.suspend();
                }
                case 5:{
                ProdPlot siguiente = (ProdPlot) ocupado.getPfirst().getproceso();
                ocupado.Desencolar();
                libre.Encolar(siguiente);
                mutexQuitar.release();
                semQuitar.release();
                siguiente.suspend();
                }
                case 6:{
                Ensamblador siguiente = (Ensamblador) ocupado.getPfirst().getproceso();
                ocupado.Desencolar();
                libre.Encolar(siguiente);
                mutexQuitar.release();
                semQuitar.release();
                siguiente.suspend();
                }
            }
        }
        }
    }   
    
    public VentanaSimulacion() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Estudios");
        
        agregarPIntE2.setEnabled(false);
        agregarPCreE2.setEnabled(false);
        agregarPIniE2.setEnabled(false);
        agregarPCieE2.setEnabled(false);
        agregarPPTE2.setEnabled(false);
        agregarEE2.setEnabled(false);
        
        eliminarPIntE2.setEnabled(false);
        eliminarPCreE2.setEnabled(false);
        eliminarPIniE2.setEnabled(false);
        eliminarPCieE2.setEnabled(false);
        eliminarPPTE2.setEnabled(false);
        eliminarEE2.setEnabled(false);

        aggDashboard.setEnabled(false);
        
        
        // Estudio 2
        diaE2 = archivo.leerPorDefectoE1(diaE2, countdownE2, maxIntE2, maxCreE2, maxIniE2, maxCieE2, maxPTE2);
        capacidadIntroE2 = new Semaphore(Integer.parseInt(maxIntE2.getText()));
        capacidadCreditosE2 = new Semaphore(Integer.parseInt(maxCreE2.getText()));
        capacidadInicioE2 = new Semaphore(Integer.parseInt(maxIniE2.getText()));
        capacidadCierreE2 = new Semaphore(Integer.parseInt(maxCieE2.getText()));
        capacidadPlotTwistE2 = new Semaphore(Integer.parseInt(maxPTE2.getText()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        Panel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        productoresIniE1 = new javax.swing.JLabel();
        ensambladoresE2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        eliminarPIntE1 = new javax.swing.JButton();
        sueldoEE2 = new javax.swing.JLabel();
        agregarPIntE1 = new javax.swing.JButton();
        eliminarPCreE1 = new javax.swing.JButton();
        agregarPCreE1 = new javax.swing.JButton();
        eliminarPIniE1 = new javax.swing.JButton();
        agregarPIniE1 = new javax.swing.JButton();
        eliminarPCieE1 = new javax.swing.JButton();
        agregarPCieE1 = new javax.swing.JButton();
        maxCreE1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        agregarEE1 = new javax.swing.JButton();
        eliminarEE1 = new javax.swing.JButton();
        episodiosProducidosE1 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        eliminarPIntE2 = new javax.swing.JButton();
        faltasPME2 = new javax.swing.JLabel();
        faltasPME1 = new javax.swing.JLabel();
        productoresCreE2 = new javax.swing.JLabel();
        productoresCieE2 = new javax.swing.JLabel();
        productoresIniE2 = new javax.swing.JLabel();
        agregarPIntE2 = new javax.swing.JButton();
        eliminarPCreE2 = new javax.swing.JButton();
        agregarPCreE2 = new javax.swing.JButton();
        eliminarPIniE2 = new javax.swing.JButton();
        agregarPIniE2 = new javax.swing.JButton();
        eliminarPCieE2 = new javax.swing.JButton();
        agregarPCieE2 = new javax.swing.JButton();
        productoresIntE2 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        agregarEE2 = new javax.swing.JButton();
        eliminarEE2 = new javax.swing.JButton();
        episodiosProducidosE2 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        estadoDirectorE1 = new javax.swing.JLabel();
        sueldoDE1 = new javax.swing.JLabel();
        estadoDirectorE2 = new javax.swing.JLabel();
        estadoPME2 = new javax.swing.JLabel();
        iniciarEstudios = new javax.swing.JButton();
        countdownE2 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        productoresCreE1 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        productoresIntE1 = new javax.swing.JLabel();
        capacidadCreE1 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        ensambladoresE1 = new javax.swing.JLabel();
        capacidadIntE1 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        maxIniE1 = new javax.swing.JLabel();
        capacidadIniE1 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        maxCieE1 = new javax.swing.JLabel();
        capacidadCieE1 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        estadoPME1 = new javax.swing.JLabel();
        sueldoPME2 = new javax.swing.JLabel();
        maxIntE1 = new javax.swing.JLabel();
        sueldoIntE1 = new javax.swing.JLabel();
        sueldoCreE1 = new javax.swing.JLabel();
        sueldoIniE1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        maxCreE2 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        sueldoDE2 = new javax.swing.JLabel();
        capacidadCreE2 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        sueldoCieE2 = new javax.swing.JLabel();
        capacidadIntE2 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        maxIniE2 = new javax.swing.JLabel();
        capacidadIniE2 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        maxCieE2 = new javax.swing.JLabel();
        capacidadCieE2 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        sueldoPME1 = new javax.swing.JLabel();
        maxIntE2 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        sueldoIntE2 = new javax.swing.JLabel();
        sueldoCreE2 = new javax.swing.JLabel();
        sueldoIniE2 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        productoresCieE1 = new javax.swing.JLabel();
        sueldoCieE1 = new javax.swing.JLabel();
        sueldoEE1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        capacidadPTE1 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        maxPTE1 = new javax.swing.JLabel();
        productoresPTE1 = new javax.swing.JLabel();
        agregarPPTE1 = new javax.swing.JButton();
        eliminarPPTE1 = new javax.swing.JButton();
        sueldoPTE1 = new javax.swing.JLabel();
        capacidadPTE2 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        maxPTE2 = new javax.swing.JLabel();
        productoresPTE2 = new javax.swing.JLabel();
        agregarPPTE2 = new javax.swing.JButton();
        eliminarPPTE2 = new javax.swing.JButton();
        sueldoPTE2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        irSimulacionButton = new javax.swing.JButton();
        irDashboardButton = new javax.swing.JButton();
        irParametrosButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        netoE1 = new javax.swing.JLabel();
        gastosE1 = new javax.swing.JLabel();
        gananciasE1 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        netoE2 = new javax.swing.JLabel();
        gastosE2 = new javax.swing.JLabel();
        gananciasE2 = new javax.swing.JLabel();
        reiniciar = new javax.swing.JButton();
        aggDashboard = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        countdownE1 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setMinimumSize(new java.awt.Dimension(900, 550));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Panel.setBackground(new java.awt.Color(204, 204, 204));
        Panel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(153, 153, 153));
        jLabel2.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        jLabel2.setText("Tipo");
        Panel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, -1, -1));

        jLabel3.setBackground(new java.awt.Color(153, 153, 153));
        jLabel3.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        jLabel3.setText("Intro");
        Panel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, -1, -1));

        jLabel4.setBackground(new java.awt.Color(153, 153, 153));
        jLabel4.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        jLabel4.setText("Estudio 1");
        Panel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, -1, -1));

        productoresIniE1.setBackground(new java.awt.Color(153, 153, 153));
        productoresIniE1.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        productoresIniE1.setText("0");
        Panel.add(productoresIniE1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 370, 10, -1));

        ensambladoresE2.setBackground(new java.awt.Color(153, 153, 153));
        ensambladoresE2.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        ensambladoresE2.setText("0");
        Panel.add(ensambladoresE2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 510, -1, -1));

        jLabel9.setBackground(new java.awt.Color(153, 153, 153));
        jLabel9.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Capacidad(GB)");
        Panel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, 100, -1));

        eliminarPIntE1.setBackground(new java.awt.Color(51, 51, 51));
        eliminarPIntE1.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        eliminarPIntE1.setForeground(new java.awt.Color(255, 255, 255));
        eliminarPIntE1.setText("-");
        eliminarPIntE1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarPIntE1ActionPerformed(evt);
            }
        });
        Panel.add(eliminarPIntE1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 280, 40, 30));

        sueldoEE2.setBackground(new java.awt.Color(153, 153, 153));
        sueldoEE2.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        sueldoEE2.setText("0");
        Panel.add(sueldoEE2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 510, 30, -1));

        agregarPIntE1.setBackground(new java.awt.Color(51, 51, 51));
        agregarPIntE1.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        agregarPIntE1.setForeground(new java.awt.Color(255, 255, 255));
        agregarPIntE1.setText("+");
        agregarPIntE1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarPIntE1ActionPerformed(evt);
            }
        });
        Panel.add(agregarPIntE1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 280, 40, 30));

        eliminarPCreE1.setBackground(new java.awt.Color(51, 51, 51));
        eliminarPCreE1.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        eliminarPCreE1.setForeground(new java.awt.Color(255, 255, 255));
        eliminarPCreE1.setText("-");
        eliminarPCreE1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarPCreE1ActionPerformed(evt);
            }
        });
        Panel.add(eliminarPCreE1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 320, 40, 30));

        agregarPCreE1.setBackground(new java.awt.Color(51, 51, 51));
        agregarPCreE1.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        agregarPCreE1.setForeground(new java.awt.Color(255, 255, 255));
        agregarPCreE1.setText("+");
        agregarPCreE1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarPCreE1ActionPerformed(evt);
            }
        });
        Panel.add(agregarPCreE1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 320, 40, 30));

        eliminarPIniE1.setBackground(new java.awt.Color(51, 51, 51));
        eliminarPIniE1.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        eliminarPIniE1.setForeground(new java.awt.Color(255, 255, 255));
        eliminarPIniE1.setText("-");
        eliminarPIniE1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarPIniE1ActionPerformed(evt);
            }
        });
        Panel.add(eliminarPIniE1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 360, 40, 30));

        agregarPIniE1.setBackground(new java.awt.Color(51, 51, 51));
        agregarPIniE1.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        agregarPIniE1.setForeground(new java.awt.Color(255, 255, 255));
        agregarPIniE1.setText("+");
        agregarPIniE1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarPIniE1ActionPerformed(evt);
            }
        });
        Panel.add(agregarPIniE1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 360, 40, 30));

        eliminarPCieE1.setBackground(new java.awt.Color(51, 51, 51));
        eliminarPCieE1.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        eliminarPCieE1.setForeground(new java.awt.Color(255, 255, 255));
        eliminarPCieE1.setText("-");
        eliminarPCieE1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarPCieE1ActionPerformed(evt);
            }
        });
        Panel.add(eliminarPCieE1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 400, 40, 30));

        agregarPCieE1.setBackground(new java.awt.Color(51, 51, 51));
        agregarPCieE1.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        agregarPCieE1.setForeground(new java.awt.Color(255, 255, 255));
        agregarPCieE1.setText("+");
        agregarPCieE1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarPCieE1ActionPerformed(evt);
            }
        });
        Panel.add(agregarPCieE1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 400, 40, 30));

        maxCreE1.setBackground(new java.awt.Color(153, 153, 153));
        maxCreE1.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        maxCreE1.setText("25");
        Panel.add(maxCreE1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 330, 20, -1));

        jLabel10.setBackground(new java.awt.Color(153, 153, 153));
        jLabel10.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        jLabel10.setText("Ensambladores");
        Panel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 480, -1, -1));

        agregarEE1.setBackground(new java.awt.Color(51, 51, 51));
        agregarEE1.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        agregarEE1.setForeground(new java.awt.Color(255, 255, 255));
        agregarEE1.setText("+");
        agregarEE1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarEE1ActionPerformed(evt);
            }
        });
        Panel.add(agregarEE1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 500, 40, 30));

        eliminarEE1.setBackground(new java.awt.Color(51, 51, 51));
        eliminarEE1.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        eliminarEE1.setForeground(new java.awt.Color(255, 255, 255));
        eliminarEE1.setText("-");
        eliminarEE1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarEE1ActionPerformed(evt);
            }
        });
        Panel.add(eliminarEE1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 500, 40, 30));

        episodiosProducidosE1.setBackground(new java.awt.Color(153, 153, 153));
        episodiosProducidosE1.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        episodiosProducidosE1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        episodiosProducidosE1.setText("0");
        Panel.add(episodiosProducidosE1, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 190, 50, -1));

        jLabel26.setBackground(new java.awt.Color(153, 153, 153));
        jLabel26.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("The Last of Us");
        Panel.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 170, 160, -1));

        jLabel24.setBackground(new java.awt.Color(153, 153, 153));
        jLabel24.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        jLabel24.setText("Productores");
        Panel.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 250, -1, -1));

        jLabel32.setBackground(new java.awt.Color(153, 153, 153));
        jLabel32.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("Faltas");
        Panel.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 140, 60, -1));

        eliminarPIntE2.setBackground(new java.awt.Color(51, 51, 51));
        eliminarPIntE2.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        eliminarPIntE2.setForeground(new java.awt.Color(255, 255, 255));
        eliminarPIntE2.setText("-");
        eliminarPIntE2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarPIntE2ActionPerformed(evt);
            }
        });
        Panel.add(eliminarPIntE2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 280, 40, 30));

        faltasPME2.setBackground(new java.awt.Color(153, 153, 153));
        faltasPME2.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        faltasPME2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        faltasPME2.setText("0");
        Panel.add(faltasPME2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 170, 60, 20));

        faltasPME1.setBackground(new java.awt.Color(153, 153, 153));
        faltasPME1.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        faltasPME1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        faltasPME1.setText("0");
        Panel.add(faltasPME1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 170, 60, 20));

        productoresCreE2.setBackground(new java.awt.Color(153, 153, 153));
        productoresCreE2.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        productoresCreE2.setText("0");
        Panel.add(productoresCreE2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 330, 20, 20));

        productoresCieE2.setBackground(new java.awt.Color(153, 153, 153));
        productoresCieE2.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        productoresCieE2.setText("0");
        Panel.add(productoresCieE2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 410, 20, -1));

        productoresIniE2.setBackground(new java.awt.Color(153, 153, 153));
        productoresIniE2.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        productoresIniE2.setText("0");
        Panel.add(productoresIniE2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 370, 20, -1));

        agregarPIntE2.setBackground(new java.awt.Color(51, 51, 51));
        agregarPIntE2.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        agregarPIntE2.setForeground(new java.awt.Color(255, 255, 255));
        agregarPIntE2.setText("+");
        agregarPIntE2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarPIntE2ActionPerformed(evt);
            }
        });
        Panel.add(agregarPIntE2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 280, 40, 30));

        eliminarPCreE2.setBackground(new java.awt.Color(51, 51, 51));
        eliminarPCreE2.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        eliminarPCreE2.setForeground(new java.awt.Color(255, 255, 255));
        eliminarPCreE2.setText("-");
        eliminarPCreE2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarPCreE2ActionPerformed(evt);
            }
        });
        Panel.add(eliminarPCreE2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 320, 40, 30));

        agregarPCreE2.setBackground(new java.awt.Color(51, 51, 51));
        agregarPCreE2.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        agregarPCreE2.setForeground(new java.awt.Color(255, 255, 255));
        agregarPCreE2.setText("+");
        agregarPCreE2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarPCreE2ActionPerformed(evt);
            }
        });
        Panel.add(agregarPCreE2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 320, 40, 30));

        eliminarPIniE2.setBackground(new java.awt.Color(51, 51, 51));
        eliminarPIniE2.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        eliminarPIniE2.setForeground(new java.awt.Color(255, 255, 255));
        eliminarPIniE2.setText("-");
        eliminarPIniE2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarPIniE2ActionPerformed(evt);
            }
        });
        Panel.add(eliminarPIniE2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 360, 40, 30));

        agregarPIniE2.setBackground(new java.awt.Color(51, 51, 51));
        agregarPIniE2.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        agregarPIniE2.setForeground(new java.awt.Color(255, 255, 255));
        agregarPIniE2.setText("+");
        agregarPIniE2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarPIniE2ActionPerformed(evt);
            }
        });
        Panel.add(agregarPIniE2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 360, 40, 30));

        eliminarPCieE2.setBackground(new java.awt.Color(51, 51, 51));
        eliminarPCieE2.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        eliminarPCieE2.setForeground(new java.awt.Color(255, 255, 255));
        eliminarPCieE2.setText("-");
        eliminarPCieE2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarPCieE2ActionPerformed(evt);
            }
        });
        Panel.add(eliminarPCieE2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 400, 40, 30));

        agregarPCieE2.setBackground(new java.awt.Color(51, 51, 51));
        agregarPCieE2.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        agregarPCieE2.setForeground(new java.awt.Color(255, 255, 255));
        agregarPCieE2.setText("+");
        agregarPCieE2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarPCieE2ActionPerformed(evt);
            }
        });
        Panel.add(agregarPCieE2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 400, 40, 30));

        productoresIntE2.setBackground(new java.awt.Color(153, 153, 153));
        productoresIntE2.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        productoresIntE2.setText("0");
        Panel.add(productoresIntE2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 290, 20, -1));
        Panel.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 310, 20, -1));

        agregarEE2.setBackground(new java.awt.Color(51, 51, 51));
        agregarEE2.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        agregarEE2.setForeground(new java.awt.Color(255, 255, 255));
        agregarEE2.setText("+");
        agregarEE2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarEE2ActionPerformed(evt);
            }
        });
        Panel.add(agregarEE2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 500, 40, 30));

        eliminarEE2.setBackground(new java.awt.Color(51, 51, 51));
        eliminarEE2.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        eliminarEE2.setForeground(new java.awt.Color(255, 255, 255));
        eliminarEE2.setText("-");
        eliminarEE2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarEE2ActionPerformed(evt);
            }
        });
        Panel.add(eliminarEE2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 500, 40, 30));

        episodiosProducidosE2.setBackground(new java.awt.Color(153, 153, 153));
        episodiosProducidosE2.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        episodiosProducidosE2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        episodiosProducidosE2.setText("0");
        Panel.add(episodiosProducidosE2, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 410, 50, 20));

        jLabel48.setBackground(new java.awt.Color(153, 153, 153));
        jLabel48.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel48.setText("Velma");
        Panel.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 390, 160, -1));

        jLabel49.setBackground(new java.awt.Color(153, 153, 153));
        jLabel49.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        jLabel49.setText("Director esta...");
        Panel.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 196, 120, 30));

        jLabel50.setBackground(new java.awt.Color(153, 153, 153));
        jLabel50.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        jLabel50.setText("PM esta... ");
        Panel.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, -1, 20));

        jLabel51.setBackground(new java.awt.Color(153, 153, 153));
        jLabel51.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        jLabel51.setText("Estudio 2");
        Panel.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 140, -1, -1));

        estadoDirectorE1.setBackground(new java.awt.Color(153, 153, 153));
        estadoDirectorE1.setFont(new java.awt.Font("NSimSun", 0, 12)); // NOI18N
        estadoDirectorE1.setText("null");
        Panel.add(estadoDirectorE1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, 110, 20));

        sueldoDE1.setBackground(new java.awt.Color(153, 153, 153));
        sueldoDE1.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        sueldoDE1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sueldoDE1.setText("0");
        Panel.add(sueldoDE1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 200, 50, 20));

        estadoDirectorE2.setBackground(new java.awt.Color(153, 153, 153));
        estadoDirectorE2.setFont(new java.awt.Font("NSimSun", 0, 12)); // NOI18N
        estadoDirectorE2.setText("null");
        Panel.add(estadoDirectorE2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 200, 100, 20));

        estadoPME2.setBackground(new java.awt.Color(153, 153, 153));
        estadoPME2.setFont(new java.awt.Font("NSimSun", 0, 12)); // NOI18N
        estadoPME2.setText("null");
        Panel.add(estadoPME2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 170, 100, 20));

        iniciarEstudios.setBackground(new java.awt.Color(51, 51, 51));
        iniciarEstudios.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        iniciarEstudios.setForeground(new java.awt.Color(255, 255, 255));
        iniciarEstudios.setText("Iniciar Simulacion");
        iniciarEstudios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarEstudiosActionPerformed(evt);
            }
        });
        Panel.add(iniciarEstudios, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 160, 40));

        countdownE2.setBackground(new java.awt.Color(153, 153, 153));
        countdownE2.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        countdownE2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        countdownE2.setText("0");
        Panel.add(countdownE2, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 100, 50, 20));

        jLabel38.setBackground(new java.awt.Color(153, 153, 153));
        jLabel38.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        jLabel38.setText("Productores");
        Panel.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 250, -1, -1));

        jLabel58.setBackground(new java.awt.Color(153, 153, 153));
        jLabel58.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        jLabel58.setText("Creditos");
        Panel.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, -1, -1));

        productoresCreE1.setBackground(new java.awt.Color(153, 153, 153));
        productoresCreE1.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        productoresCreE1.setText("0");
        Panel.add(productoresCreE1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 330, -1, -1));

        jLabel14.setBackground(new java.awt.Color(153, 153, 153));
        jLabel14.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        jLabel14.setText("Inicio");
        Panel.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 370, 120, -1));

        jLabel15.setBackground(new java.awt.Color(153, 153, 153));
        jLabel15.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        jLabel15.setText("Cierre");
        Panel.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 410, -1, -1));

        productoresIntE1.setBackground(new java.awt.Color(153, 153, 153));
        productoresIntE1.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        productoresIntE1.setText("0");
        Panel.add(productoresIntE1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 290, 20, -1));

        capacidadCreE1.setBackground(new java.awt.Color(153, 153, 153));
        capacidadCreE1.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        capacidadCreE1.setText("0");
        Panel.add(capacidadCreE1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 330, 20, -1));

        jLabel22.setBackground(new java.awt.Color(153, 153, 153));
        jLabel22.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        jLabel22.setText("/");
        Panel.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 330, 20, -1));

        ensambladoresE1.setBackground(new java.awt.Color(153, 153, 153));
        ensambladoresE1.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        ensambladoresE1.setText("0");
        Panel.add(ensambladoresE1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 510, 20, -1));

        capacidadIntE1.setBackground(new java.awt.Color(153, 153, 153));
        capacidadIntE1.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        capacidadIntE1.setText("0");
        Panel.add(capacidadIntE1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 290, 20, -1));

        jLabel29.setBackground(new java.awt.Color(153, 153, 153));
        jLabel29.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        jLabel29.setText("/");
        Panel.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 290, 20, -1));

        maxIniE1.setBackground(new java.awt.Color(153, 153, 153));
        maxIniE1.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        maxIniE1.setText("50");
        Panel.add(maxIniE1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 370, 20, -1));

        capacidadIniE1.setBackground(new java.awt.Color(153, 153, 153));
        capacidadIniE1.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        capacidadIniE1.setText("0");
        Panel.add(capacidadIniE1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 370, 20, -1));

        jLabel40.setBackground(new java.awt.Color(153, 153, 153));
        jLabel40.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        jLabel40.setText("/");
        Panel.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 370, 20, -1));

        maxCieE1.setBackground(new java.awt.Color(153, 153, 153));
        maxCieE1.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        maxCieE1.setText("55");
        Panel.add(maxCieE1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 410, 20, -1));

        capacidadCieE1.setBackground(new java.awt.Color(153, 153, 153));
        capacidadCieE1.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        capacidadCieE1.setText("0");
        Panel.add(capacidadCieE1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 410, 20, -1));

        jLabel43.setBackground(new java.awt.Color(153, 153, 153));
        jLabel43.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        jLabel43.setText("/");
        Panel.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 410, 20, -1));

        estadoPME1.setBackground(new java.awt.Color(153, 153, 153));
        estadoPME1.setFont(new java.awt.Font("NSimSun", 0, 12)); // NOI18N
        estadoPME1.setText("null");
        Panel.add(estadoPME1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, 110, 20));

        sueldoPME2.setBackground(new java.awt.Color(153, 153, 153));
        sueldoPME2.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        sueldoPME2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sueldoPME2.setText("0");
        Panel.add(sueldoPME2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 170, 50, 20));

        maxIntE1.setBackground(new java.awt.Color(153, 153, 153));
        maxIntE1.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        maxIntE1.setText("30");
        Panel.add(maxIntE1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 290, 20, -1));

        sueldoIntE1.setBackground(new java.awt.Color(153, 153, 153));
        sueldoIntE1.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        sueldoIntE1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sueldoIntE1.setText("0");
        Panel.add(sueldoIntE1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 280, 50, 30));

        sueldoCreE1.setBackground(new java.awt.Color(153, 153, 153));
        sueldoCreE1.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        sueldoCreE1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sueldoCreE1.setText("0");
        Panel.add(sueldoCreE1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 320, 50, 30));

        sueldoIniE1.setBackground(new java.awt.Color(153, 153, 153));
        sueldoIniE1.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        sueldoIniE1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sueldoIniE1.setText("0");
        Panel.add(sueldoIniE1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 360, 50, 30));

        jLabel12.setBackground(new java.awt.Color(153, 153, 153));
        jLabel12.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Capacidad(GB)");
        Panel.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 250, -1, -1));

        maxCreE2.setBackground(new java.awt.Color(153, 153, 153));
        maxCreE2.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        maxCreE2.setText("25");
        Panel.add(maxCreE2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 330, 20, -1));

        jLabel60.setBackground(new java.awt.Color(153, 153, 153));
        jLabel60.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        jLabel60.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel60.setText("Faltas");
        Panel.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 140, 60, -1));

        sueldoDE2.setBackground(new java.awt.Color(153, 153, 153));
        sueldoDE2.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        sueldoDE2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sueldoDE2.setText("0");
        Panel.add(sueldoDE2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 200, 50, 20));

        capacidadCreE2.setBackground(new java.awt.Color(153, 153, 153));
        capacidadCreE2.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        capacidadCreE2.setText("0");
        Panel.add(capacidadCreE2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 330, 20, -1));

        jLabel63.setBackground(new java.awt.Color(153, 153, 153));
        jLabel63.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        jLabel63.setText("/");
        Panel.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 330, 20, -1));

        sueldoCieE2.setBackground(new java.awt.Color(153, 153, 153));
        sueldoCieE2.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        sueldoCieE2.setText("0");
        Panel.add(sueldoCieE2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 410, 30, -1));

        capacidadIntE2.setBackground(new java.awt.Color(153, 153, 153));
        capacidadIntE2.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        capacidadIntE2.setText("0");
        Panel.add(capacidadIntE2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 290, 20, -1));

        jLabel66.setBackground(new java.awt.Color(153, 153, 153));
        jLabel66.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        jLabel66.setText("/");
        Panel.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 290, 20, -1));

        maxIniE2.setBackground(new java.awt.Color(153, 153, 153));
        maxIniE2.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        maxIniE2.setText("50");
        Panel.add(maxIniE2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 370, 20, -1));

        capacidadIniE2.setBackground(new java.awt.Color(153, 153, 153));
        capacidadIniE2.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        capacidadIniE2.setText("0");
        Panel.add(capacidadIniE2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 370, 20, -1));

        jLabel69.setBackground(new java.awt.Color(153, 153, 153));
        jLabel69.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        jLabel69.setText("/");
        Panel.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 370, 20, -1));

        maxCieE2.setBackground(new java.awt.Color(153, 153, 153));
        maxCieE2.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        maxCieE2.setText("55");
        Panel.add(maxCieE2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 410, 20, -1));

        capacidadCieE2.setBackground(new java.awt.Color(153, 153, 153));
        capacidadCieE2.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        capacidadCieE2.setText("0");
        Panel.add(capacidadCieE2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 410, 20, -1));

        jLabel33.setBackground(new java.awt.Color(153, 153, 153));
        jLabel33.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("Sueldo");
        Panel.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 140, 60, -1));

        jLabel72.setBackground(new java.awt.Color(153, 153, 153));
        jLabel72.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        jLabel72.setText("/");
        Panel.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 410, 20, -1));

        sueldoPME1.setBackground(new java.awt.Color(153, 153, 153));
        sueldoPME1.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        sueldoPME1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sueldoPME1.setText("0");
        Panel.add(sueldoPME1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 170, 50, 20));

        maxIntE2.setBackground(new java.awt.Color(153, 153, 153));
        maxIntE2.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        maxIntE2.setText("30");
        Panel.add(maxIntE2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 290, 20, -1));

        jLabel61.setBackground(new java.awt.Color(153, 153, 153));
        jLabel61.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        jLabel61.setText("Sueldo");
        Panel.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 140, 80, -1));

        sueldoIntE2.setBackground(new java.awt.Color(153, 153, 153));
        sueldoIntE2.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        sueldoIntE2.setText("0");
        Panel.add(sueldoIntE2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 290, 30, -1));

        sueldoCreE2.setBackground(new java.awt.Color(153, 153, 153));
        sueldoCreE2.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        sueldoCreE2.setText("0");
        Panel.add(sueldoCreE2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 330, 30, -1));

        sueldoIniE2.setBackground(new java.awt.Color(153, 153, 153));
        sueldoIniE2.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        sueldoIniE2.setText("0");
        Panel.add(sueldoIniE2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 370, 30, -1));

        jLabel16.setBackground(new java.awt.Color(153, 153, 153));
        jLabel16.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        jLabel16.setText("Ensambladores");
        Panel.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 480, -1, -1));

        productoresCieE1.setBackground(new java.awt.Color(153, 153, 153));
        productoresCieE1.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        productoresCieE1.setText("0");
        Panel.add(productoresCieE1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 410, -1, -1));

        sueldoCieE1.setBackground(new java.awt.Color(153, 153, 153));
        sueldoCieE1.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        sueldoCieE1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sueldoCieE1.setText("0");
        Panel.add(sueldoCieE1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 400, 50, 30));

        sueldoEE1.setBackground(new java.awt.Color(153, 153, 153));
        sueldoEE1.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        sueldoEE1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sueldoEE1.setText("0");
        Panel.add(sueldoEE1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 500, 50, 30));

        jLabel6.setBackground(new java.awt.Color(153, 153, 153));
        jLabel6.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Estudio 2");
        Panel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 370, 160, -1));

        jLabel13.setBackground(new java.awt.Color(153, 153, 153));
        jLabel13.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Estudio 1");
        Panel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(733, 146, 160, 20));

        jLabel19.setBackground(new java.awt.Color(153, 153, 153));
        jLabel19.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        jLabel19.setText("Plot Twist");
        Panel.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 450, -1, -1));

        capacidadPTE1.setBackground(new java.awt.Color(153, 153, 153));
        capacidadPTE1.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        capacidadPTE1.setText("0");
        Panel.add(capacidadPTE1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 450, 20, -1));

        jLabel44.setBackground(new java.awt.Color(153, 153, 153));
        jLabel44.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        jLabel44.setText("/");
        Panel.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 450, 20, -1));

        maxPTE1.setBackground(new java.awt.Color(153, 153, 153));
        maxPTE1.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        maxPTE1.setText("40");
        Panel.add(maxPTE1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 450, 20, -1));

        productoresPTE1.setBackground(new java.awt.Color(153, 153, 153));
        productoresPTE1.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        productoresPTE1.setText("0");
        Panel.add(productoresPTE1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 450, -1, -1));

        agregarPPTE1.setBackground(new java.awt.Color(51, 51, 51));
        agregarPPTE1.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        agregarPPTE1.setForeground(new java.awt.Color(255, 255, 255));
        agregarPPTE1.setText("+");
        agregarPPTE1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarPPTE1ActionPerformed(evt);
            }
        });
        Panel.add(agregarPPTE1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 440, 40, 30));

        eliminarPPTE1.setBackground(new java.awt.Color(51, 51, 51));
        eliminarPPTE1.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        eliminarPPTE1.setForeground(new java.awt.Color(255, 255, 255));
        eliminarPPTE1.setText("-");
        eliminarPPTE1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarPPTE1ActionPerformed(evt);
            }
        });
        Panel.add(eliminarPPTE1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 440, 40, 30));

        sueldoPTE1.setBackground(new java.awt.Color(153, 153, 153));
        sueldoPTE1.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        sueldoPTE1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sueldoPTE1.setText("0");
        Panel.add(sueldoPTE1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 440, 50, 30));

        capacidadPTE2.setBackground(new java.awt.Color(153, 153, 153));
        capacidadPTE2.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        capacidadPTE2.setText("0");
        Panel.add(capacidadPTE2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 450, 20, -1));

        jLabel73.setBackground(new java.awt.Color(153, 153, 153));
        jLabel73.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        jLabel73.setText("/");
        Panel.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 450, 20, -1));

        maxPTE2.setBackground(new java.awt.Color(153, 153, 153));
        maxPTE2.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        maxPTE2.setText("40");
        Panel.add(maxPTE2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 450, 20, -1));

        productoresPTE2.setBackground(new java.awt.Color(153, 153, 153));
        productoresPTE2.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        productoresPTE2.setText("0");
        Panel.add(productoresPTE2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 450, 20, -1));

        agregarPPTE2.setBackground(new java.awt.Color(51, 51, 51));
        agregarPPTE2.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        agregarPPTE2.setForeground(new java.awt.Color(255, 255, 255));
        agregarPPTE2.setText("+");
        agregarPPTE2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarPPTE2ActionPerformed(evt);
            }
        });
        Panel.add(agregarPPTE2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 440, 40, 30));

        eliminarPPTE2.setBackground(new java.awt.Color(51, 51, 51));
        eliminarPPTE2.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        eliminarPPTE2.setForeground(new java.awt.Color(255, 255, 255));
        eliminarPPTE2.setText("-");
        eliminarPPTE2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarPPTE2ActionPerformed(evt);
            }
        });
        Panel.add(eliminarPPTE2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 440, 40, 30));

        sueldoPTE2.setBackground(new java.awt.Color(153, 153, 153));
        sueldoPTE2.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        sueldoPTE2.setText("0");
        Panel.add(sueldoPTE2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 450, 30, -1));

        jPanel1.setBackground(new java.awt.Color(102, 0, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Poor Richard", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("HBO MAX");
        jLabel17.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 40));

        Panel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 40));

        jPanel3.setBackground(new java.awt.Color(51, 0, 102));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        irSimulacionButton.setBackground(new java.awt.Color(0, 0, 0));
        irSimulacionButton.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        irSimulacionButton.setForeground(new java.awt.Color(204, 204, 204));
        irSimulacionButton.setText("Simulacion");
        irSimulacionButton.setBorder(null);
        irSimulacionButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        irSimulacionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                irSimulacionButtonActionPerformed(evt);
            }
        });
        jPanel3.add(irSimulacionButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 40, 130, 40));

        irDashboardButton.setBackground(new java.awt.Color(0, 0, 0));
        irDashboardButton.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        irDashboardButton.setForeground(new java.awt.Color(204, 204, 204));
        irDashboardButton.setText("Dashboard");
        irDashboardButton.setBorder(null);
        irDashboardButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        irDashboardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                irDashboardButtonActionPerformed(evt);
            }
        });
        jPanel3.add(irDashboardButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 90, 130, 40));

        irParametrosButton.setBackground(new java.awt.Color(0, 0, 0));
        irParametrosButton.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        irParametrosButton.setForeground(new java.awt.Color(204, 204, 204));
        irParametrosButton.setText("Parametros");
        irParametrosButton.setBorder(null);
        irParametrosButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        irParametrosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                irParametrosButtonActionPerformed(evt);
            }
        });
        jPanel3.add(irParametrosButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 140, 130, 40));

        Panel.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 110, 500));

        jLabel5.setBackground(new java.awt.Color(153, 153, 153));
        jLabel5.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        jLabel5.setText("Neto");
        Panel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 280, 50, 20));

        jLabel7.setBackground(new java.awt.Color(153, 153, 153));
        jLabel7.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        jLabel7.setText("Episodios");
        Panel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 410, 80, 20));

        jLabel18.setBackground(new java.awt.Color(153, 153, 153));
        jLabel18.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        jLabel18.setText("Ganancia");
        Panel.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 250, 80, 20));

        netoE1.setBackground(new java.awt.Color(153, 153, 153));
        netoE1.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        netoE1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        netoE1.setText("0");
        Panel.add(netoE1, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 280, 50, 20));

        gastosE1.setBackground(new java.awt.Color(153, 153, 153));
        gastosE1.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        gastosE1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gastosE1.setText("0");
        Panel.add(gastosE1, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 220, 50, 20));

        gananciasE1.setBackground(new java.awt.Color(153, 153, 153));
        gananciasE1.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        gananciasE1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gananciasE1.setText("0");
        Panel.add(gananciasE1, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 250, 50, 20));

        jLabel23.setBackground(new java.awt.Color(153, 153, 153));
        jLabel23.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        jLabel23.setText("Neto");
        Panel.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 500, 50, 20));

        jLabel25.setBackground(new java.awt.Color(153, 153, 153));
        jLabel25.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        jLabel25.setText("Gastos");
        Panel.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 440, 50, 20));

        jLabel27.setBackground(new java.awt.Color(153, 153, 153));
        jLabel27.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        jLabel27.setText("Ganancia");
        Panel.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 470, 80, 20));

        netoE2.setBackground(new java.awt.Color(153, 153, 153));
        netoE2.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        netoE2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        netoE2.setText("0");
        Panel.add(netoE2, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 500, 50, 20));

        gastosE2.setBackground(new java.awt.Color(153, 153, 153));
        gastosE2.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        gastosE2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gastosE2.setText("0");
        Panel.add(gastosE2, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 440, 50, 20));

        gananciasE2.setBackground(new java.awt.Color(153, 153, 153));
        gananciasE2.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        gananciasE2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gananciasE2.setText("0");
        Panel.add(gananciasE2, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 470, 50, 20));

        reiniciar.setBackground(new java.awt.Color(51, 51, 51));
        reiniciar.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        reiniciar.setForeground(new java.awt.Color(255, 255, 255));
        reiniciar.setText("Reiniciar");
        reiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reiniciarActionPerformed(evt);
            }
        });
        Panel.add(reiniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 80, -1, 40));

        aggDashboard.setBackground(new java.awt.Color(51, 51, 51));
        aggDashboard.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        aggDashboard.setForeground(new java.awt.Color(255, 255, 255));
        aggDashboard.setText("Guardar Corrida");
        aggDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aggDashboardActionPerformed(evt);
            }
        });
        Panel.add(aggDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, 140, 40));

        jLabel36.setBackground(new java.awt.Color(153, 153, 153));
        jLabel36.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        jLabel36.setText("Dias restantes para lanzamiento del Estudio 2:");
        Panel.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 90, 330, 40));

        jLabel1.setBackground(new java.awt.Color(102, 102, 102));
        jLabel1.setFont(new java.awt.Font("Poor Richard", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("SIMULACION");
        Panel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 770, 20));
        Panel.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 770, 10));

        jLabel20.setBackground(new java.awt.Color(153, 153, 153));
        jLabel20.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        jLabel20.setText("Gastos");
        Panel.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 220, 50, 20));

        jLabel21.setBackground(new java.awt.Color(153, 153, 153));
        jLabel21.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        jLabel21.setText("Episodios");
        Panel.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 190, 80, 20));

        jLabel28.setBackground(new java.awt.Color(153, 153, 153));
        jLabel28.setToolTipText("");
        jLabel28.setOpaque(true);
        Panel.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 590, 410));

        jLabel30.setBackground(new java.awt.Color(153, 153, 153));
        jLabel30.setToolTipText("");
        jLabel30.setOpaque(true);
        Panel.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 360, 170, 180));

        jLabel31.setBackground(new java.awt.Color(153, 153, 153));
        jLabel31.setToolTipText("");
        jLabel31.setOpaque(true);
        Panel.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 130, 170, 180));

        jLabel37.setBackground(new java.awt.Color(153, 153, 153));
        jLabel37.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        jLabel37.setText("Dias restantes para lanzamiento del Estudio 1:");
        Panel.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 70, 330, 40));

        countdownE1.setBackground(new java.awt.Color(153, 153, 153));
        countdownE1.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        countdownE1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        countdownE1.setText("0");
        Panel.add(countdownE1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 80, 50, 20));

        jLabel34.setBackground(new java.awt.Color(153, 153, 153));
        jLabel34.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("Faltas");
        Panel.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 140, 60, -1));

        getContentPane().add(Panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void eliminarPIntE1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarPIntE1ActionPerformed
        
    }//GEN-LAST:event_eliminarPIntE1ActionPerformed

    private void agregarPIntE1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarPIntE1ActionPerformed
        
    }//GEN-LAST:event_agregarPIntE1ActionPerformed

    private void eliminarPCreE1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarPCreE1ActionPerformed
        
    }//GEN-LAST:event_eliminarPCreE1ActionPerformed

    private void agregarPCreE1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarPCreE1ActionPerformed
        
    }//GEN-LAST:event_agregarPCreE1ActionPerformed

    private void eliminarPIniE1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarPIniE1ActionPerformed
        
    }//GEN-LAST:event_eliminarPIniE1ActionPerformed

    private void agregarPIniE1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarPIniE1ActionPerformed
        
    }//GEN-LAST:event_agregarPIniE1ActionPerformed

    private void eliminarPCieE1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarPCieE1ActionPerformed
        
    }//GEN-LAST:event_eliminarPCieE1ActionPerformed

    private void agregarPCieE1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarPCieE1ActionPerformed
        
    }//GEN-LAST:event_agregarPCieE1ActionPerformed

    private void agregarEE1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarEE1ActionPerformed
        
    }//GEN-LAST:event_agregarEE1ActionPerformed

    private void eliminarEE1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarEE1ActionPerformed
        
    }//GEN-LAST:event_eliminarEE1ActionPerformed

    private void eliminarPIntE2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarPIntE2ActionPerformed
        int sueldo = 5;
        int num = Integer.parseInt(productoresIntE2.getText());
        int mult = Integer.parseInt(sueldoIntE2.getText());
        if (num != 0){
            num -= 1;
            count -=1;
            mult = mult -sueldo;
            sueldoIntE2.setText(Integer.toString(mult));
            productoresIntE2.setText(Integer.toString(num));
            quitarE2(1,colaOcupadoIntroE2, colaLibreIntroE2, productoresIntE2, sem1E2, introE2);

        }else{
            JOptionPane.showMessageDialog(null, "No hay productores"); 
        }
    }//GEN-LAST:event_eliminarPIntE2ActionPerformed

    private void agregarPIntE2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarPIntE2ActionPerformed
        int sueldo = 5;
        if (count < totalE) {
            int mult;
            int num = Integer.parseInt(productoresIntE2.getText());
            num += 1;
            count +=1;
            mult = sueldo * num;
            sueldoIntE2.setText(Integer.toString(mult));
            productoresIntE2.setText(Integer.toString(num));
            agregarE2(1, colaLibreIntroE2, colaOcupadoIntroE2, productoresIntE2);
        }else{
            JOptionPane.showMessageDialog(null, "Numero maximo de producotres alcanzado");
        }                                             
    }//GEN-LAST:event_agregarPIntE2ActionPerformed

    private void eliminarPCreE2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarPCreE2ActionPerformed
        int sueldo = 3;
        int num = Integer.parseInt(productoresCreE2.getText());
        int mult = Integer.parseInt(sueldoCreE2.getText());
        if (num != 0){
            num -= 1;
            count -=1;
            mult = mult -sueldo;
            sueldoCreE2.setText(Integer.toString(mult));
            productoresCreE2.setText(Integer.toString(num));
            quitarE2(2,colaOcupadoCreditosE2, colaLibreCreditosE2, productoresCreE2, sem2E2, creditosE2);
        }else{
            JOptionPane.showMessageDialog(null, "No hay productores"); 
        }
    }//GEN-LAST:event_eliminarPCreE2ActionPerformed

    private void agregarPCreE2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarPCreE2ActionPerformed
        int sueldo = 3;
        if (count < totalE) {
            int mult;
            int num = Integer.parseInt(productoresCreE2.getText());
            num += 1;
            count +=1;
            mult = sueldo * num;
            sueldoCreE2.setText(Integer.toString(mult));
            productoresCreE2.setText(Integer.toString(num));
            agregarE2(2, colaLibreCreditosE2, colaOcupadoCreditosE2, productoresCreE2);

        }else{
            JOptionPane.showMessageDialog(null, "Numero maximo de producotres alcanzado");
        }                                                
    }//GEN-LAST:event_agregarPCreE2ActionPerformed

    private void eliminarPIniE2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarPIniE2ActionPerformed
        int sueldo = 7;
        int num = Integer.parseInt(productoresIniE2.getText());
        int mult = Integer.parseInt(sueldoIniE2.getText());
        if (num != 0){
            num -= 1;
            count -=1;
            mult = mult -sueldo;
            sueldoIniE2.setText(Integer.toString(mult));
            productoresIniE2.setText(Integer.toString(num));
            quitarE2(3,colaOcupadoInicioE2, colaLibreInicioE2, productoresIniE2, sem3E2, inicioE2);
        }else{
            JOptionPane.showMessageDialog(null, "No hay productores"); 
        }
    }//GEN-LAST:event_eliminarPIniE2ActionPerformed

    private void agregarPIniE2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarPIniE2ActionPerformed
        int sueldo = 7;
        if (count < totalE) {
            int mult;
            int num = Integer.parseInt(productoresIniE2.getText());
            num += 1;
            count +=1;
            mult = sueldo * num;
            sueldoIniE2.setText(Integer.toString(mult));
            productoresIniE2.setText(Integer.toString(num));
            agregarE2(3, colaLibreInicioE2, colaOcupadoInicioE2, productoresIniE2);

        }else{
            JOptionPane.showMessageDialog(null, "Numero maximo de producotres alcanzado");
        }
    }//GEN-LAST:event_agregarPIniE2ActionPerformed

    private void eliminarPCieE2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarPCieE2ActionPerformed
        float sueldo = (float) 7.5;
        int num = Integer.parseInt(productoresCieE2.getText());
        float mult = (float) Integer.parseInt(sueldoCieE2.getText());
        if (num != 0){
            num -= 1;
            count -=1;
            mult = mult -sueldo;
            sueldoCieE2.setText(Integer.toString((int)mult));
            productoresCieE2.setText(Integer.toString(num));
            quitarE2(4,colaOcupadoCierreE2, colaLibreCierreE2, productoresCieE2, sem4E2, cierreE2);
        }else{
            JOptionPane.showMessageDialog(null, "No hay productores"); 
        }
    }//GEN-LAST:event_eliminarPCieE2ActionPerformed

    private void agregarPCieE2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarPCieE2ActionPerformed
        float sueldo = (float)7.5;
        if (count < totalE) {
            float mult;
            int num = Integer.parseInt(productoresCieE2.getText());
            num += 1;
            count +=1;
            mult = sueldo * num;
            sueldoCieE2.setText(Integer.toString((int)mult));
            productoresCieE2.setText(Integer.toString(num));
            agregarE2(4, colaLibreCierreE2, colaOcupadoCierreE2, productoresCieE2);
        }else{
            JOptionPane.showMessageDialog(null, "Numero maximo de producotres alcanzado");
        }
    }//GEN-LAST:event_agregarPCieE2ActionPerformed

    private void agregarEE2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarEE2ActionPerformed
        int sueldo = 8;
        if (count < totalE) {
            int mult;
            int num = Integer.parseInt(ensambladoresE2.getText());
            num += 1;
            count +=1;
            mult = sueldo * num;
            sueldoEE2.setText(Integer.toString(mult));
            ensambladoresE2.setText(Integer.toString(num));
            agregarE2(6, colaEnsambladoresLibresE2, colaEnsambladoresOcupadosE2, ensambladoresE2);
        }else{
            JOptionPane.showMessageDialog(null, "Numero maximo de producotres alcanzado");
        }
    }//GEN-LAST:event_agregarEE2ActionPerformed

    private void eliminarEE2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarEE2ActionPerformed
        if ( !colaEnsambladoresOcupadosE2.esta_vacia()) {
            Ensamblador siguiente = (Ensamblador)colaEnsambladoresOcupadosE2.getPfirst().getproceso();
            colaEnsambladoresOcupadosE2.Desencolar();
            siguiente.suspend();
            siguiente.sem1.release();
            siguiente.sem2.release();
            siguiente.sem3.release();
            siguiente.sem4.release();
            siguiente.sem5.release();
            int sueldo = 8;
            int num = Integer.parseInt(ensambladoresE2.getText());
            int mult = Integer.parseInt(sueldoEE2.getText());
            if (num != 0){
                num -= 1;
                count -=1;
                mult = mult -sueldo;
                sueldoEE2.setText(Integer.toString(mult));
                ensambladoresE2.setText(Integer.toString(num));
            }
        }else{
            JOptionPane.showMessageDialog(null, "No hay Ensambladores"); 
        }
    }//GEN-LAST:event_eliminarEE2ActionPerformed

    private void iniciarEstudiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarEstudiosActionPerformed
        agregarPIntE2.setEnabled(true);
        agregarPCreE2.setEnabled(true);
        agregarPIniE2.setEnabled(true);
        agregarPCieE2.setEnabled(true);
        agregarPPTE2.setEnabled(true);
        agregarEE2.setEnabled(true);
        
        eliminarPIntE2.setEnabled(true);
        eliminarPCreE2.setEnabled(true);
        eliminarPIniE2.setEnabled(true);
        eliminarPCieE2.setEnabled(true);
        eliminarPPTE2.setEnabled(true);
        eliminarEE2.setEnabled(true);

        aggDashboard.setEnabled(false);
        
        reiniciar.setEnabled(true);
        irParametrosButton.setEnabled(false);
        irDashboardButton.setEnabled(false);
        irSimulacionButton.setEnabled(false);
        iniciarEstudios.setEnabled(false);
        
        //Estudio2
        if (colaEnsambladoresOcupadosE2.esta_vacia()) {
        totalE = archivo.leerPorDefecto2E1(diaE2,totalE,colaLibreIntroE2,colaOcupadoIntroE2,colaLibreCreditosE2,colaOcupadoCreditosE2,colaLibreInicioE2,colaOcupadoInicioE2,colaLibreCierreE2,colaOcupadoCierreE2, colaLibrePlotTwistE2, colaOcupadoPlotTwistE2, productoresIntE2,productoresCreE1,productoresIniE2,productoresCieE2, productoresPTE2, colaEnsambladoresLibresE2,colaEnsambladoresOcupadosE2,ensambladoresE2,capacidadIntE2,capacidadCreE2,capacidadIniE2,capacidadCieE2,capacidadPTE2,episodiosProducidosE2,sem1E2,sem2E2,sem3E2,sem4E2,sem5E2,capacidadIntroE2,capacidadCreditosE2,capacidadInicioE2,capacidadCierreE2,capacidadPlotTwistE2,introE2,creditosE2,inicioE2,cierreE2,plottwistE2,mutex5E2,mutex4E2,mutex3E2,mutex2E2,mutex1E2,countdownE2);
        }else{
            diaE2=archivo.leerPorDefectoE1(diaE2, countdownE2, maxIntE2, maxCreE2, maxIniE2, maxCieE2, maxPTE2);
        }
        diasE2=Integer.parseInt(countdownE2.getText());
        Director pagosE2 = new Director(productoresIntE2, productoresCreE2, productoresIniE2, productoresCieE2, productoresPTE2,sueldoIntE2, sueldoCreE2, sueldoIniE2, sueldoCieE2,sueldoPTE2, ensambladoresE2,sueldoEE2,0,diaE2,sueldoPME2,sueldoDE2,countdownE2);
        pagosE2.start();
        // PM 
        ProyectManager PME2 = new ProyectManager(1,diaE2,modCountdownE2, countdownE2, estadoPME2);
        PME2.start();
        // Director
        ProyectManager directorE2 = new ProyectManager(diaE2, 3, modCountdownE2, estadoDirectorE2, countdownE2,episodiosProducidosE2,estadoPME2,sueldoPME2);
        directorE2.start();
        
        ProyectManager totalE2 = new ProyectManager(4,sueldoIntE2, sueldoCreE2, sueldoIniE2, sueldoCieE2, sueldoPTE2, sueldoPME2, sueldoDE2, episodiosProducidosE2, gastosE2, gananciasE2, netoE2,countdownE2,sueldoEE2,reiniciar,aggDashboard,irDashboardButton,irParametrosButton,iniciarEstudios);
        totalE2.start();
        
        total2 = totalE2;
        ProyectManager diasRestantesE2 = new ProyectManager(diaE2, countdownE2, 2);
        diasRestantesE2.start();

    }//GEN-LAST:event_iniciarEstudiosActionPerformed

    private void irSimulacionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_irSimulacionButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_irSimulacionButtonActionPerformed

    private void irDashboardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_irDashboardButtonActionPerformed

        this.dispose();
        VentanaDashboard dashboard = new VentanaDashboard();
        dashboard.setVisible(true);

    }//GEN-LAST:event_irDashboardButtonActionPerformed

    private void irParametrosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_irParametrosButtonActionPerformed
        this.dispose();
        VentanaParametros parametros = new VentanaParametros();
        parametros.setVisible(true);
    }//GEN-LAST:event_irParametrosButtonActionPerformed

    private void reiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reiniciarActionPerformed
        

    }//GEN-LAST:event_reiniciarActionPerformed

    private void aggDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aggDashboardActionPerformed

    }//GEN-LAST:event_aggDashboardActionPerformed

    private void agregarPPTE1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarPPTE1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_agregarPPTE1ActionPerformed

    private void eliminarPPTE1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarPPTE1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eliminarPPTE1ActionPerformed

    private void agregarPPTE2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarPPTE2ActionPerformed
        int sueldo = 10;
        if (count < totalE) {
            int mult;
            int num = Integer.parseInt(productoresPTE2.getText());
            num += 1;
            count +=1;
            mult = sueldo * num;
            sueldoPTE2.setText(Integer.toString((mult)));
            productoresPTE2.setText(Integer.toString(num));
            agregarE2(5, colaLibrePlotTwistE2, colaOcupadoPlotTwistE2, productoresPTE2);
        }else{
            JOptionPane.showMessageDialog(null, "Numero maximo de producotres alcanzado");
        }
    }//GEN-LAST:event_agregarPPTE2ActionPerformed

    private void eliminarPPTE2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarPPTE2ActionPerformed
        int sueldo = 10;
        int num = Integer.parseInt(productoresPTE2.getText());
        int mult = Integer.parseInt(sueldoPTE2.getText());
        if (num != 0){
            num -= 1;
            count -=1;
            mult = mult -sueldo;
            sueldoPTE2.setText(Integer.toString(mult));
            productoresPTE2.setText(Integer.toString(num));
            quitarE2(5,colaOcupadoPlotTwistE2, colaLibrePlotTwistE2, productoresPTE2, sem5E2, plottwistE2);
        }else{
            JOptionPane.showMessageDialog(null, "No hay productores"); 
        }
    }//GEN-LAST:event_eliminarPPTE2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaSimulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaSimulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaSimulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaSimulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaSimulacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel;
    private javax.swing.JButton aggDashboard;
    private javax.swing.JButton agregarEE1;
    private javax.swing.JButton agregarEE2;
    private javax.swing.JButton agregarPCieE1;
    private javax.swing.JButton agregarPCieE2;
    private javax.swing.JButton agregarPCreE1;
    private javax.swing.JButton agregarPCreE2;
    private javax.swing.JButton agregarPIniE1;
    private javax.swing.JButton agregarPIniE2;
    private javax.swing.JButton agregarPIntE1;
    private javax.swing.JButton agregarPIntE2;
    private javax.swing.JButton agregarPPTE1;
    private javax.swing.JButton agregarPPTE2;
    private javax.swing.JLabel capacidadCieE1;
    private javax.swing.JLabel capacidadCieE2;
    private javax.swing.JLabel capacidadCreE1;
    private javax.swing.JLabel capacidadCreE2;
    private javax.swing.JLabel capacidadIniE1;
    private javax.swing.JLabel capacidadIniE2;
    private javax.swing.JLabel capacidadIntE1;
    private javax.swing.JLabel capacidadIntE2;
    private javax.swing.JLabel capacidadPTE1;
    private javax.swing.JLabel capacidadPTE2;
    private javax.swing.JLabel countdownE1;
    private javax.swing.JLabel countdownE2;
    private javax.swing.JButton eliminarEE1;
    private javax.swing.JButton eliminarEE2;
    private javax.swing.JButton eliminarPCieE1;
    private javax.swing.JButton eliminarPCieE2;
    private javax.swing.JButton eliminarPCreE1;
    private javax.swing.JButton eliminarPCreE2;
    private javax.swing.JButton eliminarPIniE1;
    private javax.swing.JButton eliminarPIniE2;
    private javax.swing.JButton eliminarPIntE1;
    private javax.swing.JButton eliminarPIntE2;
    private javax.swing.JButton eliminarPPTE1;
    private javax.swing.JButton eliminarPPTE2;
    private javax.swing.JLabel ensambladoresE1;
    private javax.swing.JLabel ensambladoresE2;
    private javax.swing.JLabel episodiosProducidosE1;
    private javax.swing.JLabel episodiosProducidosE2;
    private javax.swing.JLabel estadoDirectorE1;
    private javax.swing.JLabel estadoDirectorE2;
    private javax.swing.JLabel estadoPME1;
    private javax.swing.JLabel estadoPME2;
    private javax.swing.JLabel faltasPME1;
    private javax.swing.JLabel faltasPME2;
    private javax.swing.JLabel gananciasE1;
    private javax.swing.JLabel gananciasE2;
    private javax.swing.JLabel gastosE1;
    private javax.swing.JLabel gastosE2;
    private javax.swing.JButton iniciarEstudios;
    private javax.swing.JButton irDashboardButton;
    private javax.swing.JButton irParametrosButton;
    private javax.swing.JButton irSimulacionButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel maxCieE1;
    private javax.swing.JLabel maxCieE2;
    private javax.swing.JLabel maxCreE1;
    private javax.swing.JLabel maxCreE2;
    private javax.swing.JLabel maxIniE1;
    private javax.swing.JLabel maxIniE2;
    private javax.swing.JLabel maxIntE1;
    private javax.swing.JLabel maxIntE2;
    private javax.swing.JLabel maxPTE1;
    private javax.swing.JLabel maxPTE2;
    private javax.swing.JLabel netoE1;
    private javax.swing.JLabel netoE2;
    private javax.swing.JLabel productoresCieE1;
    private javax.swing.JLabel productoresCieE2;
    private javax.swing.JLabel productoresCreE1;
    private javax.swing.JLabel productoresCreE2;
    private javax.swing.JLabel productoresIniE1;
    private javax.swing.JLabel productoresIniE2;
    private javax.swing.JLabel productoresIntE1;
    private javax.swing.JLabel productoresIntE2;
    private javax.swing.JLabel productoresPTE1;
    private javax.swing.JLabel productoresPTE2;
    private javax.swing.JButton reiniciar;
    private javax.swing.JLabel sueldoCieE1;
    private javax.swing.JLabel sueldoCieE2;
    private javax.swing.JLabel sueldoCreE1;
    private javax.swing.JLabel sueldoCreE2;
    private javax.swing.JLabel sueldoDE1;
    private javax.swing.JLabel sueldoDE2;
    private javax.swing.JLabel sueldoEE1;
    private javax.swing.JLabel sueldoEE2;
    private javax.swing.JLabel sueldoIniE1;
    private javax.swing.JLabel sueldoIniE2;
    private javax.swing.JLabel sueldoIntE1;
    private javax.swing.JLabel sueldoIntE2;
    private javax.swing.JLabel sueldoPME1;
    private javax.swing.JLabel sueldoPME2;
    private javax.swing.JLabel sueldoPTE1;
    private javax.swing.JLabel sueldoPTE2;
    // End of variables declaration//GEN-END:variables
}
