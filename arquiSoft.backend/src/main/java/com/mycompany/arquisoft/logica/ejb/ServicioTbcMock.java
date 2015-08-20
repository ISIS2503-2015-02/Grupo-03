/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arquisoft.logica.ejb;

import com.mycompany.arquisoft.dto.Conductor;
import com.mycompany.arquisoft.dto.Vcub;
import com.mycompany.arquisoft.excepciones.OperacionInvalidaException;
import com.mycompany.arquisoft.logica.interfaces.IServicioPersistenciaMockLocal;
import com.mycompany.arquisoft.logica.interfaces.IServicioTbcMockLocal;
import com.mycompany.arquisoft.persistencia.mock.ServicioPersistenciaMock;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;

/**
 *
 * @author ja.silva11
 */
@Stateless
public class ServicioTbcMock implements IServicioTbcMockLocal
{
     //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------

    /**
     * Interface con referencia al servicio de persistencia en el sistema
     */
    private IServicioPersistenciaMockLocal persistencia;

    //-----------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------

    /**
     * Constructor sin argumentos de la clase
     */
    public ServicioTbcMock() throws OperacionInvalidaException
    {
        persistencia=new ServicioPersistenciaMock();
        //Inicializa el arreglo de los muebles
  
    }

    //-----------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------

    @Override
    public long darConductorProductivo() {
        double promedio = 0;
        long resp = 0; 
        List x = persistencia.findAll(Conductor.class);
        for(int i=0; i<x.size(); i++)
        {
            Conductor y = (Conductor) x.get(i);
            if(y.calcularPromedio()>= promedio)
            {
                promedio = y.calcularPromedio();
                resp = y.getCc();
            }
        }
        return resp;
    }  
}
