/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arquisoft.dto;

import java.util.ArrayList;

/**
 *
 * @author dc.bonilla10
 */
public class Conductor
{
    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------

    /**
     * CC del Conductor
     */
    private long cc;
    
    /**
     * Nombre del Conductor
     */
    private String nombre;
    
    /**
     * Vehiculo que conduce
     */
    private Mobibus mobibus;
    private Tranvia tranvia;
    
    /**
     * Tipó de ruta que cubre
     */
    private String ruta;
    
    /**
     *Array de tiempos cubriendo la ruta
     */
    private ArrayList<Double> tiempos;
    
    /**
     * Promedio tiempo de ruta
     */
    private Double promedio;
    
    
    
    
    

    //-----------------------------------------------------------
    // Constructores
    
    //-----------------------------------------------------------


    /**
     * Constructor de la clase 
     * @param cc
     * @param nombre
     * @param movi
     * @param tran
     * @param tipoRuta
     * @param tiempos
     * @param prom
     */
    public Conductor(long cc, String nombre, Mobibus movi, Tranvia tran, String tipoRuta, ArrayList tiempos, Double prom)
    {
        this.cc = cc;
        this.nombre = nombre;
        this.mobibus = movi;
        this.tranvia = tran;
        this.ruta = tipoRuta;
        this.tiempos = new ArrayList();
        this.promedio = 0.0;

    }

    public long getCc() {
        return cc;
    }

    public void setCc(long cc) {
        this.cc = cc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Mobibus getMobibus() {
        return mobibus;
    }

    public void setMobibus(Mobibus mobibus) {
        this.mobibus = mobibus;
    }

    public Tranvia getTranvia() {
        return tranvia;
    }

    public void setTranvia(Tranvia tranvia) {
        this.tranvia = tranvia;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public ArrayList<Double> getTiempos() {
        return tiempos;
    }

    public void agregarTiempo (Double tiempo) {
        this.tiempos.add(tiempo);
    }

    public Double calcularPromedio() {
        Double prom;
        Double temp = 0.0;
        int i = 0;
        while(i<tiempos.size())
        {if(tiempos.get(i) != null)
        {
            temp += tiempos.get(i);
            i++;
        }
        }
        prom = (temp/(i+1));
        return prom;     
        
    }
}

    //-----------------------------------------------------------
    // Getters y setters
    //-----------------------------------------------------------

    