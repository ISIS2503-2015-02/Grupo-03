
package com.mycompany.arquisoft.logica.interfaces;



import com.mycompany.arquisoft.dto.Mobibus;
import com.mycompany.arquisoft.dto.Reservas;
import com.mycompany.arquisoft.dto.Usuario;
import com.mycompany.arquisoft.excepciones.NoSePudoAlquilarException;

import java.util.List;
import javax.ejb.Local;


@Local
public interface IServicioReservasMockLocal
{

    /**
     * Agrega una reserva al sistema
     * @param res Nueva reserva
     */
    public void agregarReservasMoviBus(Reservas res);

     /**
     * Actualiza una reserva del sistema
     * @param res Reserva en cuestion
     */
    public void actualizarReservas (Reservas res) ; 
    
     /**
     * Cancela una reserva
     * @param res Reserva en cuestion
     */
    public void cancelarReserva (Reservas res) ; 
    
    /**
     * Devuelve el usuario de la reserva
     * @return usuarios Lista de usuarios
     */
    public List<Usuario> darUsuario();
   /**
     * Devuelve los  usuarios en espera
     * @return usuarios Lista de usuarios
     */
    public List<Usuario> darUsuarios();
    /**
     * Devuelve las reservas
     * @return reservas Lista de reservas
     */
    public List<Reservas> darReservas();
  
    
   
    
}
