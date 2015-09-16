/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.models;

import com.example.excepciones.OperacionInvalidaException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
/**
 *
 * @author df.sabogal10
 */
@Entity
public class Emergencia {
    //-----------------------------------------------------------
    // Constantes
    //-----------------------------------------------------------
    /**
     * constante para identificar una magnitud de emergencia leve
     */
    public final static String LEVE="leve";
    
     /**
     * constante para identificar una magnitud de emergencia moderada
     */
    public final static String MODERADA="moderada";
    
     /**
     * constante para identificar una magnitud de emergencia grave
     */
    public final static String GRAVE="grave";
    
    public final static String VEHICULOS_FUERA_DE_SERVICIO ="ko";
    
    public final static String VEHICULOS_SIGUEN_FUNCIONANDO = "sigue";
    
    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------

    /**
     * ID de la emergencia
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="idEstacion")
    private int id;
    
    /**
     * descripcion de la emergencia
     */
    private String descripcion;
    
    /**
     * vehiculos involucrados en la emergencia
     */
    @OneToMany(cascade=ALL)
    private List<Vehiculo> VehiculosInvolucrados;
    
    /**
     * 
     */
    private String consecuencia;
    
    /**
     * magnitud de la emergencia 
     */
    private String magnitud;
    
    /**
     * ubicacion de la emergencia
     */
    @OneToOne( cascade= CascadeType.PERSIST, targetEntity = Ubicacion.class)
    @JoinColumn(name="idUbicacion") 
    private Ubicacion ubicacion;
    
    /**
     * fecha de la emergencia
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    
    //-----------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------
    
     /**
     * Constructor de la clase (sin argumentos)
     */
    public Emergencia()
    {

    }
    
    /**
     * Constructor de la clase 
     * @param i
     * @param descr
     * @param vehInv
     * @param magn
     * @param ubic 
     * @param fec 
     * @param consec 
     */
    public Emergencia(int i,String descr, List<Vehiculo> vehInv, String magn, Ubicacion ubic, Date fec, String consec) throws OperacionInvalidaException
    {
        if(!magn.equals(LEVE) && !magn.equals(MODERADA) && !magn.equals(GRAVE))
        {
            throw new OperacionInvalidaException("magnitud de la emergencia no válida");
        }
        else
        {
            this.magnitud=magn;
        }
        if(!consec.equals(VEHICULOS_FUERA_DE_SERVICIO) && !consec.equals(VEHICULOS_SIGUEN_FUNCIONANDO))
        {
            throw new OperacionInvalidaException("consecuencia de la emergencia no válida");
        }
        else
        {
            this.consecuencia=consec;
        }
        this.id=i;
        this.descripcion= descr;
        this.VehiculosInvolucrados= vehInv;
        this.ubicacion=ubic;
        this.fecha=fec;

    }

    
    //-----------------------------------------------------------
    // Metodos
    //-----------------------------------------------------------
    
    /**
     * getter id
     * @return 
     */
    public int getId()
    {
        return id;
    }

    /**
     * getter consecuencia
     * @return 
     */
    public String getConsecuencia() {
        return consecuencia;
    }
    
    /**
     * setter id
     * @param i 
     */
    public void setId(int i)
    {
       id=i; 
    }
    
    /**
     * getter descripcion
     * @return 
     */
    public String getDescripcion()
    {
        return descripcion;
    }
    /**
     * setter descripcion
     * @param desc 
     */
    public void setDescripcion(String desc)
    {
        descripcion= desc;
    }

    /**
     * setter consecuencia
     * @param consecuencia 
     */
    public void setConsecuencia(String consecuencia) {
        this.consecuencia = consecuencia;
    }
    
    /**
     * getter vehiculos involucrados
     * @return 
     */
    public List<Vehiculo> getVehiculosInvolucrados()
    {
        return VehiculosInvolucrados;
    }
    /**
     * setter vehiculos involucrados
     * @param vehInv 
     */
    public void setVehiculosInvolucrados(List <Vehiculo> vehInv)
    {
        VehiculosInvolucrados=vehInv;
    }
    
    /**
     * getter magnitud
     * @return 
     */
    public String getMagnitud()
    {
        return magnitud;
    }
    
    /**
     * setter magnitud
     * @param magn
     * @throws OperacionInvalidaException 
     */
    public void setMagnitud(String magn) throws OperacionInvalidaException
    {
         if(!magn.equals(LEVE) && !magn.equals(MODERADA) && !magn.equals(GRAVE))
        {
            throw new OperacionInvalidaException("magnitud de la emergencia no válida");
        }
        else
        {
            magnitud=magn;
        }
    }
    
    /**
     * getter ubicacion
     * @return 
     */
    public Ubicacion getUbicacion()
    {
        return ubicacion;
    }
    
    /**
     * setter ubicacion
     * @param nueva 
     */
    public void setUbicacion(Ubicacion nueva)
    {
        ubicacion=nueva;
    }
    
    /**
     * getter fecha 
     * @return 
     */
    public Date getFecha()
    {
        return fecha;
    }
    
    /**
     * setter fecha
     * @param fec 
     */
    public void setFecha(Date fec)
    {
        fecha=fec;
    }
   
}
