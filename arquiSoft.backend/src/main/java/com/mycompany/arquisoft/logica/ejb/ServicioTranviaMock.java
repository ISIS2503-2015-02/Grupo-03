

package com.mycompany.arquisoft.logica.ejb;

import com.mycompany.arquisoft.dto.Tranvia;
import com.mycompany.arquisoft.excepciones.OperacionInvalidaException;
import com.mycompany.arquisoft.logica.interfaces.IServicioPersistenciaMockLocal;
import com.mycompany.arquisoft.logica.interfaces.IServicioTranviaMockLocal;
import com.mycompany.arquisoft.persistencia.mock.ServicioPersistenciaMock;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;

/**
 * Implementacion de los servicios del Tranvia.
 * @author je.camargo10
 */
@Stateless
public class ServicioTranviaMock implements IServicioTranviaMockLocal
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
    public ServicioTranviaMock()
    {
        persistencia=new ServicioPersistenciaMock();
        //Inicializa el arreglo de los muebles
  
    }

    //-----------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------

 

    @Override
    public void agregarTranvia(Tranvia tranvia) 
    {
 
        try
        {
            persistencia.create(tranvia);
        }
        catch (OperacionInvalidaException ex)
        {
            Logger.getLogger(ServicioTranviaMock.class.getName()).log(Level.SEVERE, null, ex);
        }

    
    }

    @Override
    public void eliminarTranvia(long id) 
    {
Tranvia t=(Tranvia) persistencia.findById(Tranvia.class, id);
        try
        {
            persistencia.delete(t);
        }
        catch (OperacionInvalidaException ex)
        {
            Logger.getLogger(ServicioTranviaMock.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void actualizarTranvia(Tranvia tranvia) 
    {

        try
        {
            persistencia.update(tranvia);
        }
        catch (Exception ex)
        {
            Logger.getLogger(ServicioTranviaMock.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public List<Tranvia> darTranvias() 
    {
        return persistencia.findAll(Tranvia.class);
    }

    @Override
    public void emergenciaTranvia(long id)
    {
Tranvia t=(Tranvia) persistencia.findById(Tranvia.class, id);
t.setPanico();
        try
        {
            persistencia.update(t);
        }
        catch (Exception ex)
        {
            Logger.getLogger(ServicioTranviaMock.class.getName()).log(Level.SEVERE, null, ex);
        }    }

    @Override
    public void choqueTranvia(long id)
    {
Tranvia t=(Tranvia) persistencia.findById(Tranvia.class, id);
t.chocado();
        try
        {
            persistencia.update(t);
        }
        catch (Exception ex)
        {
            Logger.getLogger(ServicioTranviaMock.class.getName()).log(Level.SEVERE, null, ex);
        }    
    
    }

}
