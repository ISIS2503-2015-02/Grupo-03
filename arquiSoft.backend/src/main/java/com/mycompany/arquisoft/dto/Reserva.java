/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arquisoft.dto;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author je.camargo10
 */
public class Reserva
{
  //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------

    /**
     * ID de la reserva
     */
    private long id;
    
    /**
     * Fecha de la reserva
     */
    private Date fecha;  
    /**
     * Usuarios en listade espera
     */
   private ArrayList<Usuario> listaEspera;
   
   /**
    * Diferente notificacion que puede generarse
    */
    private String notificacion; 
    
    /**
     * Usuario acargo de la reserva
     */
    private Usuario usuario;
    
    
    //-----------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------

  

    /**
     * Constructor de la clase (sin argumentos)
     */
    public Reserva()
    {

    }

    /**
     * Constructor de la clase (con argumentos)
     * @param id
     */
    public Reserva(long id ,String pfecha, String coordenadaInic, long pkilometraje)
    {
        this.id = id;
        
  
    }

    //-----------------------------------------------------------
    // Getters y setters
    //-----------------------------------------------------------

    /**
     * Devuelve el id de la Reserva
     * @return id Id de la Reserva
     */
    public long getId()
    {
        return id;
    }
    
       
    /**
     * Modifica el id de la Reserva
     * @param id Nuevo id de la Reserva
     */
    public void setId(int id) {
        this.id = id;
    }
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public ArrayList<Usuario> getListaEspera() {
        return listaEspera;
    }

    public void setListaEspera(ArrayList<Usuario> listaEspera) {
        this.listaEspera = listaEspera;
    }

    public String getNotificacion() {
        return notificacion;
    }

    public void setNotificacion(String notificacion) {
        this.notificacion = notificacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    
   
}