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
   
    private int id;
    
    /**
     * Estado del TranviaDTO
     */
    private int choque;
    
    
    /**
     * Temperatura
     */
   private int tempatura;
   
   /**
    * Boolean con referencia al boton de paanico para situacion de emergencia
    */
   private int panico; 
    
   
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
    private int kilometraje ;
    //-----------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------

  

    /**
     * Constructor de la clase (sin argumentos)
     */
    public TranviaDTO()
    {

    }
    //-----------------------------------------------------------
    // Getters y setters
    //-----------------------------------------------------------

    /**
     * Devuelve el id del TranviaDTO
     * @return id Id del TranviaDTO
     */
    public int getId()
    {
        return id;
    }
    
    /**
     * Devuelve si ha sufrido un choque
     * @return choque si ha sufrido un choque o no
     */
    public boolean getChoque()
    {
        return choque >= 1 ;
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
    public void setChocado()
    {
     this.choque = 1;
    }
      public int getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(int kilometraje) {
        this.kilometraje = kilometraje;
    }

    public int getTempatura() {
        return tempatura;
    }

    public void setTempatura(int tempatura) {
        this.tempatura = tempatura;
    }

    public boolean getPanico() {
        return panico >=1;
    }

    public void setPanico() {
        this.panico = 1;
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