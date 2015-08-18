/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arquisoft.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author je.camargo10
 */
public class Reservas
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
     * Usuario acargo de la reserva
     */
    private Usuario usuario;
    
    
    //-----------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------

  

    /**
     * Constructor de la clase (sin argumentos)
     */
    public Reservas()
    {

    }

    /**
     * Constructor de la clase (con argumentos)
     * @param id
     */
    public Reservas(long id ,String pfecha)
    {
        this.id = id;
        SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd/MM/yyyy");
        
        try {
            fecha = formatoDeFecha.parse(pfecha);
        } catch (ParseException ex) {
System.out.print("error fecha");
        }
        
        listaEspera = new ArrayList<Usuario>();
    usuario = null;

        
  
    }

    //-----------------------------------------------------------
    // Getters y setters
    //-----------------------------------------------------------

    public void soltarReserva()
    {
    if (listaEspera.size()!= 0)
    {
    Usuario jesus = listaEspera.get(0);
    jesus.setNotificacion("se ha liberado un Mobibus, usted queda con la reserva");
    listaEspera.remove(0);
    }
    else
    {
    listaEspera = new ArrayList<Usuario>();
    usuario = null;
    }
    }
    
    public void verificarFecha()
    {
    java.util.Date fechaActual = new Date();
    if (fechaActual.before(fecha))
    {
        for (int i = 0; listaEspera.size() > i; i++)
        {
         Usuario jesus =  listaEspera.get(i);
         jesus.setNotificacion("No se pudo generar el servicio");
              
        }
 
    
    }

    
    }
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

    public ArrayList<Usuario> getListaEspera()
    {
        return listaEspera;
    }

    public void setListaEspera(ArrayList<Usuario> listaEspera) {
        this.listaEspera = listaEspera;
    }

  

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    } 
}