/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arquisoft.logica.ejb;


import com.mycompany.arquisoft.dto.Mobibus;
import com.mycompany.arquisoft.excepciones.OperacionInvalidaException;
import com.mycompany.arquisoft.logica.interfaces.IServicioPersistenciaMockLocal;
import com.mycompany.arquisoft.logica.interfaces.IServicioMobibusMockLocal;
import com.mycompany.arquisoft.persistencia.mock.ServicioPersistenciaMock;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;


/**
 *
 * @author dc.bonilla10
 */
@Stateless
public class ServicioMobibusMock implements IServicioMobibusMockLocal
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
    public ServicioMobibusMock() throws OperacionInvalidaException
    {
        persistencia=new ServicioPersistenciaMock();
        //Inicializa el arreglo de los muebles
  
    }

    //-----------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------

    @Override
    public void agregarMobibus(Mobibus mobibus)
    {
        try
        {
            persistencia.create(mobibus);
        }
        catch (OperacionInvalidaException ex)
        {
            Logger.getLogger(ServicioMobibusMock.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminarMobibus(long id) 
    {
        Mobibus m=(Mobibus) persistencia.findById(Vcub.class, id);
        try
        {
            persistencia.delete(m);
        }
        catch (OperacionInvalidaException ex)
        {
            Logger.getLogger(ServicioMobibusMock.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Mobibus> darMobibus() 
    {
        return persistencia.findAll(Mobibus.class);
    }    

    @Override
    public void actualizarMobibus(Mobibus mobibus) 
    {
            mobibus.setEstado();
            persistencia.update(mobibus);
    }
}