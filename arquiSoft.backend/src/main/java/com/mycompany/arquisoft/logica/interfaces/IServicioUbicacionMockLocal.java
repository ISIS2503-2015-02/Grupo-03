/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arquisoft.logica.interfaces;

import com.mycompany.arquisoft.dto.Ubicacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ja.silva11
 */
@Local
public interface IServicioUbicacionMockLocal 
{
        /**
         * Agrega una Ubicacion al sistema
         * @param Ubicacion Nueva Ubicacion
         */
        public void agregarUbicacion(Ubicacion Ubicacion);

        /**
         * Elimina una Ubicacion del sistema
         * @param id Identificador único de la Ubicacion a eliminar
         */
        public void eliminarUbicacion(long id);

            /**
         * Actualiza una Ubicacion al sistema
         * @param Ubicacion Nueva Ubicacion
         */
        public void actualizarUbicacion(Ubicacion Ubicacion);

        /**
         * Devuelve todas las Ubicaciones del sistema
         * @return Ubicaciones Lista de Ubicaciones
         */
        public List<Ubicacion> darUbicaciones();

}
