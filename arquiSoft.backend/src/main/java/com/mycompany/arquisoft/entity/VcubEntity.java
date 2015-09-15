/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arquisoft.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.Field;
import org.eclipse.persistence.nosql.annotations.NoSql;
/**
 *
 * @author ja.silva11
 */
@NoSql(dataFormat=DataFormatType.MAPPED)
@Entity
@XmlRootElement
public class VcubEntity 
{
    
    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------

    /**
     * ID del Vcub
     */
    @Id
    @GeneratedValue
    @Field(name="_id")
    private String id;
    
    /**
     * Estado del Vcub
     */
    private String estado;
    

    //-----------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------

    /**
     * Constructor de la clase (sin argumentos)
     */
    public VcubEntity()
    {

    }

    /**
     * Constructor de la clase (con argumentos)
     * @param id
     */
    public VcubEntity(long id)
    {
        this.estado = "disponible";
    }

    //-----------------------------------------------------------
    // Getters y setters
    //-----------------------------------------------------------

    /**
     * Devuelve el id del Vcub
     * @return id Id del Vcub
     */
    public String getId()
    {
        return id;
    }
    
    /**
     * Devuelve el estado del Vcub
     * @return estado Estado del Vcub
     */
    public String getEstado()
    {
        return estado;
    }
    
    /**
     * Modifica el id del Vcub
     * @param id Nuevo id del Vcub
     */
    public void setId(String id) {
        this.id = id;
    }
    
    /**
     * Modifica el estado del Vcub
     */
    public void setEstado() {
        if(this.estado.equalsIgnoreCase("disponible"))
        {
            this.estado = "alquilado"; 
        }
        else
        {
            this.estado = "disponible";
        }
    }
}
