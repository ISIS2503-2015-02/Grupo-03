/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arquisoft.logica.ejb;

import com.mycompany.arquisoft.dto.EstacionVcub;
import com.mycompany.arquisoft.dto.Vcub;
import com.mycompany.arquisoft.excepciones.OperacionInvalidaException;
import com.mycompany.arquisoft.logica.interfaces.IServicioEstacionVcubMockLocal;
import com.mycompany.arquisoft.logica.interfaces.IServicioPersistenciaMockLocal;
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
public class ServicioEstacionVcubMock implements IServicioEstacionVcubMockLocal
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
    public ServicioEstacionVcubMock() throws OperacionInvalidaException
    {
        persistencia=new ServicioPersistenciaMock();
        //Inicializa el arreglo de los muebles
  
    }

    //-----------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------
    
    @Override
    public void agregarEstacion(EstacionVcub ev) {
        try
        {
            persistencia.create(ev);
        }
        catch (OperacionInvalidaException ex)
        {
            Logger.getLogger(ServicioVcubMock.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminarEstacion(long id) 
    {
        EstacionVcub ev=(EstacionVcub) persistencia.findById(EstacionVcub.class, id);
        try
        {
            persistencia.delete(ev);
        }
        catch (OperacionInvalidaException ex)
        {
            Logger.getLogger(ServicioVcubMock.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<EstacionVcub> darEstaciones() 
    {
        return persistencia.findAll(EstacionVcub.class);
    }    

    @Override
    public Vcub agregarVcub(long idEstacion, long idVcub) {
        return persistencia.agregarVcubEstacion(idEstacion, idVcub);
    }

    @Override
    public void eliminarVcub(long idEstacion, long idVcub) {
        persistencia.eliminarVcubEstacion(idEstacion, idVcub);
    }

    @Override
    public List<Vcub> darVcubs() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}