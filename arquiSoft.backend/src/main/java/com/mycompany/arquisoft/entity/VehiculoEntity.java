/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arquisoft.entity;

import com.mycompany.arquisoft.dto.*;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.Field;
import org.eclipse.persistence.nosql.annotations.NoSql;

/**
 *
 * @author df.sabogal10
 */
@NoSql(dataFormat=DataFormatType.MAPPED)
@Entity
@XmlRootElement
public class Vehiculo implements Serializable {
    
    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------

    /**
     * ID del Vehiculo
     */
    @Id
    @GeneratedValue
    @Field(name="_id")
    private int id;
    
    /**
     * capacidad del vehiculo
     */
    private int capacidad;
    
    /**
     * ubicacion del vehiculo
     */
    private Ubicacion ubicacion;
    
    //-----------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------

    /**
     * Constructor de la clase (sin argumentos)
     */
    public Vehiculo()
    {

    }
    
    /**
     * Constructor de la clase (con argumentos)
     * @param id
     * @param ubic
     */
    public VehiculoEntity(int id, Ubicacion ubic)
    {
        this.id = id;
        ubicacion = ubic;
        
    }
     /**
     * Devuelve el id del Vehiculo
     * @return id Id del Vehiculo
     */
    public long getId()
    {
        return id;
    }
    
    /**
     * Devuelve la capacidad del Vehiculo
     * @return capacidad Capacidad del vehiculo
     */
    public int getCapacidad()
    {
        return capacidad;
    }

    /**
     * getter ubicacion
     * @return ubicacion
     */
    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    

    
    /**
     * Modifica la capacidad del Vehiculo
     * @param cap La nueva capacidad del vehiculo
     */
    public void setCapacidad(int cap) {
        capacidad= cap;
    }

    /**
     * setter ubicacion
     * @param ubicacion 
     */
    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }
   
    
}
