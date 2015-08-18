/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arquisoft.logica.ejb;

import com.mycompany.arquisoft.dto.Vehiculo;
import com.mycompany.arquisoft.excepciones.OperacionInvalidaException;
import com.mycompany.arquisoft.logica.interfaces.IServicioPersistenciaMockLocal;
import com.mycompany.arquisoft.logica.interfaces.IServicioVehiculoMockLocal;
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
public class ServicioVehiculoMock implements IServicioVehiculoMockLocal
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
    public ServicioVehiculoMock() throws OperacionInvalidaException
    {
        persistencia=new ServicioPersistenciaMock();
        //Inicializa el arreglo de los muebles
  
    }

    //-----------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------

    @Override
    public void agregarVehiculo(Vehiculo vehiculo) {
        try
        {
            persistencia.create(vehiculo);
        }
        catch (OperacionInvalidaException ex)
        {
            Logger.getLogger(ServicioVehiculoMock.class.getName()).log(Level.SEVERE, null, ex);
        }    }

    @Override
    public void eliminarVehiculo(int id) {
        Vehiculo v=(Vehiculo) persistencia.findById(Vehiculo.class, id);
        try
        {
            persistencia.delete(v);
        }
        catch (OperacionInvalidaException ex)
        {
            Logger.getLogger(ServicioVehiculoMock.class.getName()).log(Level.SEVERE, null, ex);
        }    }

    @Override
    public void actualizarVehiculo(Vehiculo vehiculo) {         
        persistencia.update(vehiculo);    
    }

    @Override
    public List<Vehiculo> darVehiculos() {
        return persistencia.findAll(Vehiculo.class);
    }

    @Override
    public Vehiculo darVehiculo(int id) {
        return (Vehiculo) persistencia.findById(Vehiculo.class, id);
    }
}