/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arquisoft.logica.interfaces;

import com.mycompany.arquisoft.dto.Estacion;
import com.mycompany.arquisoft.dto.Vehiculo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author df.sabogal10
 */
@Local
public interface IServicioEstacionMockLocal 
{
        /**
         * Agrega una Estacion al sistema
         * @param estacion nueva estacion
         */
        public void agregarEstacion(Estacion estacion);

        /**
         * Elimina una estacion del sistema
         * @param id Identificador único de la estacion a eliminar
         */
        public void eliminarEstacion(int id);

            /**
         * Actualiza un estacion al sistema
         * @param estacion Nueva estacion
         */
        public void actualizarEstacion(Estacion estacion);

        /**
         * Devuelve todas las estaciones del sistema
         * @return estaciones Lista de estaciones
         */
        public List<Estacion> darEstaciones();
        /**
         * Devuelve una estacion dado el id
         * @param id id de la estación a devolver
         * @return  e Estacion a retornar
         */
         public Estacion darEstacion(int id);
}
