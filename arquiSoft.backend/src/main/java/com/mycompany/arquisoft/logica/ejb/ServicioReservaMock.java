/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ ServicioUsuarioMock.java
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 3.0
 *
 * Ejercicio: Muebles de los Alpes
 * Autor: Javier Camargo
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package com.mycompany.arquisoft.logica.ejb;


import com.mycompany.arquisoft.dto.Mobibus;
import com.mycompany.arquisoft.dto.Reservas;
import com.mycompany.arquisoft.dto.Usuario;
import com.mycompany.arquisoft.dto.Vcub;
import com.mycompany.arquisoft.excepciones.NoSePudoAlquilarException;
import com.mycompany.arquisoft.excepciones.OperacionInvalidaException;
import com.mycompany.arquisoft.logica.interfaces.IServicioPersistenciaMockLocal;
import com.mycompany.arquisoft.logica.interfaces.IServicioReservasMockLocal;
import com.mycompany.arquisoft.persistencia.mock.ServicioPersistenciaMock;
import java.util.ArrayList;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Implementación de los servicios de una serva
 * @author Javier Camargo
 */
@Stateless
public class ServicioReservaMock implements IServicioReservasMockLocal {

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
     * Constructor de la clase sin argumentos
     */
    public ServicioReservaMock() throws OperacionInvalidaException
    {
       persistencia=new ServicioPersistenciaMock();
        //Inicializa el arreglo de los usuario
    }

    //-----------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------

    /**
     * Agrega una reserva al sistema
     * @param res Nuevo reserva
     * @throws OperacionInvalidaException Excepción lanzada en caso de error
     */
    @Override
    public void agregarReservasMoviBus(Reservas res)
    {
        try
        {
            persistencia.create(res);
        }
        catch (Exception ex)
        {
            System.out.println("Error"+ex.getMessage());
        }
    }

    
    /**
     * Devuelve todos los usuarios del sistema
     * @return usuarios Usuarios del sistema
     */
    public List<Usuario> darUsuarios()
    {
        return persistencia.findAll(Usuario.class);
    }
     /**
     * Devuelve el  usuarios de la reserva
     * @return usuario Usuario de la reserva
     */
    public List<Usuario> darUsuario()
    {
        return persistencia.findAll(Usuario.class);
    }

    /**
     * Actualiza la informacion de un usario
     * @param usr usuario a ser actualizado
     */
    @Override
    public void actualizarReservas(Reservas res) 
    {
        
         try
        {
            persistencia.update(res);
        }
        catch (Exception ex)
        {
            System.out.println("Error"+ex.getMessage());
        }
    }

      /**
     * Cancela una reserva
     * @param res Reserva en cuestion
     */
    public void cancelarReserva (Reservas res)
    {
     try
        {
           Reservas jesus = (Reservas)persistencia.findById(Reservas.class, res);
           jesus.soltarReserva();
           persistencia.update(jesus);
            
        }
        catch (Exception ex)
        {
            System.out.println("Error"+ex.getMessage());
        }
    
    }

    @Override
    public List<Reservas> darReservas()
    {
        return persistencia.findAll(Reservas.class);
    }


}
    
    
    
    

    

    
    
    


