/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.models;

import java.util.ArrayList;

/**
 *
 * @author dc.bonilla10
 */
public class ConductorDTO
{
    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------

    /**
     * CC del ConductorDTO
     */
    private long cc;
    
    /**
     * Nombre del ConductorDTO
     */
    private String nombre;
    
    /**
     * Vehiculo que conduce
     */
    private MobibusDTO mobibus;
    private Tranvia tranvia;
    
    /**
     * Tipó de ruta que cubre
     */
    private Ruta ruta;
    
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

     */
    public ConductorDTO(long cc, String nombre, MobibusDTO movi, Tranvia tran)
    {
        this.cc = cc;
        this.nombre = nombre;
        this.mobibus = movi;
        this.tranvia = tran;
        Ruta r = new Ruta(1, "Universidad", "Monserrate");
        this.ruta = r;
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

    public MobibusDTO getMobibus() {
        return mobibus;
    }

    public void setMobibus(MobibusDTO mobibus) {
        this.mobibus = mobibus;
    }

    public Tranvia getTranvia() {
        return tranvia;
    }

    public void setTranvia(Tranvia tranvia) {
        this.tranvia = tranvia;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
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

    