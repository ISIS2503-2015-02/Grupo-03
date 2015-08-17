/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arquisoft.logica.ejb;

import com.mycompany.arquisoft.dto.Ubicacion;
import com.mycompany.arquisoft.excepciones.OperacionInvalidaException;
import com.mycompany.arquisoft.logica.interfaces.IServicioPersistenciaMockLocal;
import com.mycompany.arquisoft.logica.interfaces.IServicioUbicacionMockLocal;
import com.mycompany.arquisoft.persistencia.mock.ServicioPersistenciaMock;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;

/**
 *
 * @author ja.silva11
 */
@Stateless
public class ServicioUbicacionMock implements IServicioUbicacionMockLocal
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
    public ServicioUbicacionMock()
    {
        persistencia=new ServicioPersistenciaMock();
        //Inicializa el arreglo de los muebles
  
    }

    //-----------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------

    @Override
    public void agregarUbicacion(Ubicacion ubicacion)
    {
        try
        {
            persistencia.create(ubicacion);
        }
        catch (OperacionInvalidaException ex)
        {
            Logger.getLogger(ServicioUbicacionMock.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminarUbicacion(long id) 
    {
        Ubicacion u=(Ubicacion) persistencia.findById(Ubicacion.class, id);
        try
        {
            persistencia.delete(u);
        }
        catch (OperacionInvalidaException ex)
        {
            Logger.getLogger(ServicioUbicacionMock.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Ubicacion> darUbicaciones() 
    {
        return persistencia.findAll(Ubicacion.class);
    }    

    @Override
    public void actualizarUbicacion(Ubicacion Ubicacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
