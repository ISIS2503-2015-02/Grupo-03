/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arquisoft.dto;

import com.mycompany.arquisoft.excepciones.OperacionInvalidaException;
import com.mycompany.arquisoft.logica.interfaces.IServicioPersistenciaMockLocal;
import com.mycompany.arquisoft.persistencia.mock.ServicioPersistenciaMock;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ja.silva11
 */
public class EstacionVcub 
{
     //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------
        
    private ArrayList<Vcub> vcubsEstacion;
    
    private int capacidad;

    //-----------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------
    
    /**
     * Constructor sin argumentos de la clase
     */
    public EstacionVcub() 
    {
    }
    
    /**
     * Constructor con argumentos de la clase
     * @param n Capacidad de la estacion.
     */
    public EstacionVcub(int n)
    {
        vcubsEstacion = new ArrayList<Vcub>();
        capacidad = n;
    }
    
    public void agregarVcub(long id)
    {
        Vcub vcub;
        if(vcubsEstacion.size()<capacidad)
        {
            for(int i =0; i < vcubsEstacion.size(); i++)
            {
                vcub = vcubsEstacion.get(i);
                if(vcub.getId() == id)
                {
                    if(vcub.getEstado().equalsIgnoreCase("alquilado"))
                    {
                        vcub.setEstado();
                    }
                    vcubsEstacion.add(vcub);
                }
            }
        }
    }

    public void eliminarVcub(long id) 
    {
        Vcub x;
        for(int i = 0; i<vcubsEstacion.size(); i++)
        {
            x = vcubsEstacion.get(i);
            if(x.getId()==id)
            {
                x.setEstado();
                vcubsEstacion.remove(i);
            }
        }
        
    }

    public List<Vcub> darVcubs() 
    {
        return vcubsEstacion;
    }
}
