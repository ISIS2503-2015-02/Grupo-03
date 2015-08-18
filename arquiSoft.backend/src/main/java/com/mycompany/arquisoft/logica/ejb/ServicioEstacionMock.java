/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arquisoft.logica.ejb;

import com.mycompany.arquisoft.dto.Estacion;
import com.mycompany.arquisoft.excepciones.OperacionInvalidaException;
import com.mycompany.arquisoft.logica.interfaces.IServicioPersistenciaMockLocal;
import com.mycompany.arquisoft.logica.interfaces.IServicioEstacionMockLocal;
import com.mycompany.arquisoft.persistencia.mock.ServicioPersistenciaMock;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;

/**
 *
 * @author df.sabogal10
 */
@Stateless
public class ServicioEstacionMock implements IServicioEstacionMockLocal
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
    public ServicioEstacionMock() throws OperacionInvalidaException
    {
        persistencia=new ServicioPersistenciaMock();
        //Inicializa el arreglo de los muebles
  
    }

    //-----------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------

    @Override
    public void agregarEstacion(Estacion estacion) {
        try
        {
            persistencia.create(estacion);
        }
        catch (OperacionInvalidaException ex)
        {
            Logger.getLogger(ServicioEstacionMock.class.getName()).log(Level.SEVERE, null, ex);
        }    }

    @Override
    public void eliminarEstacion(int id) {
        Estacion e=(Estacion) persistencia.findById(Estacion.class, id);
        try
        {
            persistencia.delete(e);
        }
        catch (OperacionInvalidaException ex)
        {
            Logger.getLogger(ServicioEstacionMock.class.getName()).log(Level.SEVERE, null, ex);
        }    }

    @Override
    public void actualizarEstacion(Estacion estacion) {         
        persistencia.update(estacion);    
    }

    @Override
    public List<Estacion> darEstaciones() {
        return persistencia.findAll(Estacion.class);
    }

    @Override
    public Estacion darEstacion(int id) {
        return (Estacion) persistencia.findById(Estacion.class, id);
    }
}