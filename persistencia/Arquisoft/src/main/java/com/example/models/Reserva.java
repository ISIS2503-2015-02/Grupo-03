/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author je.camargo10
 */
@Entity
public class Reserva
{
  //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------

    /**
     * ID de la reserva
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    
    
    /**
     * Fecha de la reserva
     */
    @Temporal(TemporalType.DATE)
private Date fecha;  
    /**
     * Usuarios en listade espera
     */
        @OneToMany
   private List<Usuario> listaEspera;
  
   
        @OneToOne
        private Mobibus busAsociado;

  
 
   
    
    /**
     * UsuarioDTO acargo de la reserva
     */
    @OneToOne
        
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
    public Reserva( Mobibus pbus, Date pfecha)
    {
        
        
     listaEspera = new ArrayList<Usuario>();
    usuario = null;
busAsociado = pbus;
fecha = pfecha;
        
  
    }

    //-----------------------------------------------------------
    // Getters y setters
    //-----------------------------------------------------------

    /**
     * Un usuario suelta la reserva
     */
    public Usuario soltarReserva()
    {
     usuario = null;
    if (listaEspera.size()!= 0)
    {
    Usuario jesus = listaEspera.get(0);
    jesus.setNotificacion("se ha liberado un Mobibus, usted queda con la reserva");
    listaEspera.remove(0);
    return jesus;
    }
    else
    {
    listaEspera = new ArrayList<Usuario>();
    fecha = null;
    busAsociado = null;
    return null;
    
    }
    
    }
    
    public String reservar(Usuario jesus, Date fecha)
    {
        
       if ( verificarFecha(fecha))
       {
       if (listaEspera.size() !=0 || usuario != null)
       {
           listaEspera.add(jesus);
           
           return "Se ingreso a la lista de espera";
       }
       else
       {
           usuario = jesus;
           return "Reserva Exitosa";
       }
       
       
       }
       else
       {
           
           return "Cambie la fecha";
           
       }

    
    
    
    }
    
    public boolean verificarFecha(Date fechaVerficar)
    {
    java.util.Date fechaActual = new Date();
    Calendar calendar = Calendar.getInstance();
	
      calendar.setTime(fechaActual); 	
      calendar.add(Calendar.DAY_OF_YEAR, 8);
     java.util.Date x = calendar.getTime();

    if (fechaActual.after(fechaVerficar) || x.before(fechaVerficar) )
    {
    return true;
    
    }
 else
    {
    
    return false;
    
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

    public List<Usuario> getListaEspera()
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
    
    
      public Mobibus getBusAsociado() {
        return busAsociado;
    }

    public void setBusAsociado(Mobibus busAsociado) {
        this.busAsociado = busAsociado;
    }
    
}