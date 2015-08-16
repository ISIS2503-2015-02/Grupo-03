/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arquisoft.logica.ejb;

import com.mycompany.arquisoft.dto.Vcub;
import com.mycompany.arquisoft.excepciones.OperacionInvalidaException;
import com.mycompany.arquisoft.logica.interfaces.IServicioPersistenciaMockLocal;
import com.mycompany.arquisoft.logica.interfaces.IServicioVcubMockLocal;
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
public class ServicioVcubMock implements IServicioVcubMockLocal
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
    public ServicioVcubMock()
    {
        persistencia=new ServicioPersistenciaMock();
        //Inicializa el arreglo de los muebles
  
    }

    //-----------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------

    @Override
    public void agregarVcub(Vcub vcub)
    {
        try
        {
            persistencia.create(vcub);
        }
        catch (OperacionInvalidaException ex)
        {
            Logger.getLogger(ServicioVcubMock.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminarVcub(long id) 
    {
        Vcub v=(Vcub) persistencia.findById(Vcub.class, id);
        try
        {
            persistencia.delete(v);
        }
        catch (OperacionInvalidaException ex)
        {
            Logger.getLogger(ServicioVcubMock.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Vcub> darVcubs() 
    {
        return persistencia.findAll(Vcub.class);
    }    
}
