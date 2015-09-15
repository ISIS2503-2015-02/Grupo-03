/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.models;

/**
 *
 * @author je.camargo10
 */
public class TranviaDTO
{
  //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------

    /**
     * ID del TranviaDTO
     */
    private long id;
    
    /**
     * Estado del TranviaDTO
     */
    private boolean choque;
    
    
    /**
     * Temperatura
     */
   private long tempatura;
   
   /**
    * Boolean con referencia al boton de paanico para situacion de emergencia
    */
    private boolean panico; 
    
    /**
     * String coordenada
     */
    private String coordenada;
    
    /**
     * Linea de circulacion
     */

    private String linea;
    /**
     * Kilometraje recorrido
     */
    private long kilometraje ;
    //-----------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------

  

    /**
     * Constructor de la clase (sin argumentos)
     */
    public TranviaDTO()
    {

    }

    /**
     * Constructor de la clase (con argumentos)
     * @param id
     */
    public TranviaDTO(long id ,String plinea, String coordenadaInic, long pkilometraje)
    {
        this.id = id;
        this.linea= plinea;
        this.tempatura = 0;
        this.coordenada = coordenadaInic;
        this.panico= false;
        this.choque=false;
    }

    //-----------------------------------------------------------
    // Getters y setters
    //-----------------------------------------------------------

    /**
     * Devuelve el id del TranviaDTO
     * @return id Id del TranviaDTO
     */
    public long getId()
    {
        return id;
    }
    
    /**
     * Devuelve si ha sufrido un choque
     * @return choque si ha sufrido un choque o no
     */
    public boolean getChoque()
    {
        return choque;
    }
    
    /**
     * Modifica el id del Trnavia
     * @param id Nuevo id del Vcub
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Indica que ha sufrido un choque
     */
    public void chocado()
    {
     choque = true;
    }
      public long getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(long kilometraje) {
        this.kilometraje = kilometraje;
    }

    public long getTempatura() {
        return tempatura;
    }

    public void setTempatura(int tempatura) {
        this.tempatura = tempatura;
    }

    public boolean isPanico() {
        return panico;
    }

    public void setPanico() {
        this.panico = true;
    }

    public String getCoordenada() {
        return coordenada;
    }

    public void setCoordenada(String coordenada) {
        this.coordenada = coordenada;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }
}