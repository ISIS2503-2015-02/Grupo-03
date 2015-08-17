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


import com.mycompany.arquisoft.dto.Usuario;
import com.mycompany.arquisoft.dto.Vcub;
import com.mycompany.arquisoft.excepciones.NoSePudoAlquilarException;
import com.mycompany.arquisoft.logica.interfaces.IServicioPersistenciaMockLocal;
import com.mycompany.arquisoft.logica.interfaces.IServicioUsuarioMockLocal;
import com.mycompany.arquisoft.persistencia.mock.ServicioPersistenciaMock;
import java.util.ArrayList;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Implementación de los servicios de administración de un usuario
 * @author Javier Camargo
 */
@Stateless
public class ServicioUsuarioMock implements IServicioUsuarioMockLocal {

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
    public ServicioUsuarioMock()
    {
       persistencia=new ServicioPersistenciaMock();
        //Inicializa el arreglo de los usuario
    }

    //-----------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------

    /**
     * Agrega un usuario al sistema
     * @param usr Nuevo usuario
     * @throws OperacionInvalidaException Excepción lanzada en caso de error
     */
    @Override
    public void agregarUsuario(Usuario usr)
    {
        try
        {
            persistencia.create(usr);
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
     * Actualiza la informacion de un usario
     * @param usr usuario a ser actualizado
     */
    @Override
    public void actualizarUsuario(Usuario usr) 
    {
        
         try
        {
            persistencia.update(usr);
        }
        catch (Exception ex)
        {
            System.out.println("Error"+ex.getMessage());
        }
    }

    @Override
    public List<Vcub> prestarVcub(Long idUsr, Long idVcub) throws NoSePudoAlquilarException 
    {
 
        List<Vcub> retorno = new ArrayList<Vcub>();
        
        try
        {
         Vcub jesus = (Vcub) persistencia.findById(Vcub.class,idVcub);
          Usuario cliente = (Usuario) persistencia.findById(Usuario.class,idUsr);

          if (jesus != null && cliente != null && jesus.getEstado().equals("disponible"))
          {
              cliente.prestarVicicleta(jesus);
              jesus.setEstado();
              persistencia.update(cliente);
              persistencia.update(jesus);
              retorno.add(jesus);

          }
          else
          {
              throw new NoSePudoAlquilarException("No se pudo");
          }
        
        }
         catch (Exception ex)
        {
            System.out.println("Error"+ex.getMessage());
                          throw new NoSePudoAlquilarException("No se pudo");

        }
        return retorno;
        
        
    }
}
    
    
    
    

    

    
    
    


