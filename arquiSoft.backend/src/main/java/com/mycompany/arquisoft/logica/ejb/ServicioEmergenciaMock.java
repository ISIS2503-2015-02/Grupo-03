/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arquisoft.logica.ejb;

import com.mycompany.arquisoft.dto.Emergencia;
import com.mycompany.arquisoft.excepciones.OperacionInvalidaException;
import com.mycompany.arquisoft.logica.interfaces.IServicioPersistenciaMockLocal;
import com.mycompany.arquisoft.logica.interfaces.IServicioEmergenciaMockLocal;
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
public class ServicioEmergenciaMock implements IServicioEmergenciaMockLocal
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
    public ServicioEmergenciaMock() throws OperacionInvalidaException
    {
        persistencia=new ServicioPersistenciaMock();
        //Inicializa el arreglo de las emergencias
  
    }

    //-----------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------

    @Override
    public void agregarEmergencia(Emergencia emergencia) {
        try
        {
            persistencia.create(emergencia);
            if(emergencia.getConsecuencia().equals(Emergencia.VEHICULOS_FUERA_DE_SERVICIO))
            {
                //mandar otro vehiculo a cubrir la ruta
            }
        }
        catch (OperacionInvalidaException ex)
        {
            Logger.getLogger(ServicioEmergenciaMock.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }    

    @Override
    public void eliminarEmergencia(int id) 
    {
        Emergencia e=(Emergencia) persistencia.findById(Emergencia.class, id);
        try
        {
            persistencia.delete(e);
        }
        catch (OperacionInvalidaException ex)
        {
            Logger.getLogger(ServicioEmergenciaMock.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }

    @Override
    public void actualizarEmergencia(Emergencia emergencia) {
        persistencia.update(emergencia);    
    }

    @Override
    public List<Emergencia> darEmergencias() {
        return persistencia.findAll(Emergencia.class);
    }

    @Override
    public Emergencia darEmergencia(int id) {
        return (Emergencia) persistencia.findById(Emergencia.class, id);
    }
}