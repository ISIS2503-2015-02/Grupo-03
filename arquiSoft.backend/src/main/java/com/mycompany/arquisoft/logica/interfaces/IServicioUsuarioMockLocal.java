
package com.mycompany.arquisoft.logica.interfaces;



import com.mycompany.arquisoft.dto.Usuario;
import com.mycompany.arquisoft.dto.Vcub;
import com.mycompany.arquisoft.excepciones.NoSePudoAlquilarException;

import java.util.List;
import javax.ejb.Local;


@Local
public interface IServicioUsuarioMockLocal
{

    /**
     * Agrega un usuario al sistema
     * @param usr Nuevo Usuario
     */
    public void agregarUsuario(Usuario usr);

     /**
     * Actualiza un usuario del sistema
     * @param usr Usuario en cuestion
     */
    public void actualizarUsuario(Usuario usr);


    /**
     * Permite al usuario resrvar un Vcub
     * @param idUsr que se le prestara
     * @param idVcub que intenta prestar
     * @return el vcub reservado
     */
    public List<Vcub> prestarVcub(Long idUsr, Long idVcub)throws NoSePudoAlquilarException;
            
    /**
     * Devuelve todos los usuarios del sistema
     * @return usuarios Lista de usuarios
     */
    public List<Usuario> darUsuarios();

   
    
}
