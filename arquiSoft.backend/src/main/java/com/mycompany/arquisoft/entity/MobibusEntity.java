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
public class MobibusEntity 
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
     * Estado del Mobibus
     */
    private String estado;
    

    //-----------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------

    /**
     * Constructor de la clase (sin argumentos)
     */
    public MobibusEntity()
    {

    }

    /**
     * Constructor de la clase (con argumentos)
     * @param id
     */
    public MobibusEntity(long id)
    {
        this.estado = "disponible";
    }

    //-----------------------------------------------------------
    // Getters y setters
    //-----------------------------------------------------------

    /**
     * Devuelve el id del Mobibus
     * @return id Id del Mobibus
     */
    public String getId()
    {
        return id;
    }
    
    /**
     * Devuelve el estado del Mobibus
     * @return estado Estado del Mobibus
     */
    public String getEstado()
    {
        return estado;
    }
    
    /**
     * Modifica el id del Mobibus
     * @param id Nuevo id del Mobibus
     */
    public void setId(String id) {
        this.id = id;
    }
    
    /**
     * Modifica el estado del Mobibus
     */
    public void setEstado() {
        if(this.estado.equalsIgnoreCase("disponible"))
        {
            this.estado = "reservado"; 
        }
        else
        {
            this.estado = "disponible";
        }
    }
}
