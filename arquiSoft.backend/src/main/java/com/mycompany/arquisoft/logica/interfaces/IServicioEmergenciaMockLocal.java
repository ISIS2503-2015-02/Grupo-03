/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arquisoft.logica.interfaces;

import com.mycompany.arquisoft.dto.Ubicacion;
import com.mycompany.arquisoft.dto.Emergencia;
import com.mycompany.arquisoft.dto.Vehiculo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author df.sabogal10
 */
@Local
public interface IServicioEmergenciaMockLocal 
{
        /**
         * Agrega una emergencia al sistema
         * @param emergencia Nuevo emergencia
         */
        public void agregarEmergencia(Emergencia emergencia);

        /**
         * Elimina una emergencia del sistema
         * @param id Identificador único de la emergencia a eliminar
         */
        public void eliminarEmergencia(int id);

            /**
         * Actualiza una emergencia al sistema
         * @param emergencia Nueva emergencia
         */
        public void actualizarEmergencia(Emergencia emergencia);

        /**
         * Devuelve todas las emergencias del sistema
         * @return emergencias Lista de emergencias
         */
        public List<Emergencia> darEmergencias();
        /**
         * Devuelve un emergencia dado el id
         * @param id id de la emergencia a devolver
         * @return  e Emergencia a devolver
         */
         public Emergencia darEmergencia(int id);
}
